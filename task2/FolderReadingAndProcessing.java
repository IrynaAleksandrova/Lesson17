package task2;

import java.nio.file.DirectoryStream;
import java.nio.file.Path;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.nio.file.Files.*;
import static java.nio.file.Path.of;
import static task2.DocumentPath.*;

public class FolderReadingAndProcessing {

    private List<String> listFill(DirectoryStream<Path> listOfFiles) {
        List<String> list = new ArrayList<>();
        for (Path path : listOfFiles) {
            list.add(path.toString());
        }
        return list;
    }

    private Document docRetrieve(String filePath) {
        Pattern emailPattern = Pattern.compile("\\b[\\w,]+@\\w+\\.\\w{2,3}");
        Pattern phonePattern = Pattern.compile("\\+\\(\\d{2}\\)\\d{7}");
        Pattern documentPattern = Pattern.compile("(\\d{4}-[A-za-z]{3}-){2}(\\d[A-Za-z]){2}");

        Matcher emailMatcher = emailPattern.matcher(filePath);
        Matcher phoneMatcher = phonePattern.matcher(filePath);
        Matcher documentMatcher = documentPattern.matcher(filePath);

        Document doc = new Document();
        while (emailMatcher.find()) {
            doc.documentEmailAddition(emailMatcher.group());
        }
        while (phoneMatcher.find()) {
            doc.documentTelephoneAddition(phoneMatcher.group());
        }
        while (documentMatcher.find()) {
            doc.documentNumberAddition(documentMatcher.group());
        }
        return doc;
    }

    public void processReadingFiles() throws ProcessException {
        // src/resources
        // 6

        try (DirectoryStream<Path> listOfFiles = newDirectoryStream(of(inputPathToFolder()))) {
            HashMap<String, Document> result = new HashMap<>();
            List<String> list = listFill(listOfFiles);

            int validFiles = 0;
            int invalidFiles = 0;
            int filesToProcess = inputDocsQuantity();

            if (filesToProcess <= 0) {
                throw new ProcessException("Documents quantity to check must be > 0");
            } else if (list.size() == 0) {
                throw new ProcessException("Directory has 0 files");
            } else {
                for (int i = 0; i < Math.min(list.size(), filesToProcess); i++) {
                    if (list.get(i).matches(".+\\.txt\\b")) {
                        validFiles++;
                        String fileInn = readString(of(list.get(i)));
                        Document doc = docRetrieve(fileInn);
                        result.put(list.get(i), doc);
                    } else {
                        System.out.println(list.get(i) + " has wrong extension. Supporting only txt format");
                        invalidFiles++;
                    }
                }
                System.out.println("Valid files : " + validFiles);
                System.out.println("Invalid files : " + invalidFiles);
            }
            mapDescription(result);
        } catch (InputMismatchException e) {
            throw new ProcessException("Wrong input: not a number");
        } catch (ProcessException e){
            System.out.println(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }

    private void mapDescription(HashMap<String, Document> result) {
        for (Map.Entry<String, Document> entry : result.entrySet()) {
            String value = String.valueOf(entry.getValue());
            String key = entry.getKey();
            System.out.println("File name : " + key + "   contains :   " + value);
        }
    }
}

