package task2;

import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FolderReadingAndProcessing {

    private List<String> listFill(DirectoryStream<Path> listOfFiles) {
        List<String> list = new ArrayList<>();
        for (Path path : listOfFiles) {
            list.add(path.toString());
        }
        return list;
    }

    private Document docRetrieving(String fileInn) {
        Pattern emailPattern = Pattern.compile("\\b[\\w\\.,]+@\\w+\\.\\w{2,3}");
        Pattern phonePattern = Pattern.compile("\\+\\(\\d{2}\\)\\d{7}");
        Pattern documentPattern = Pattern.compile("(\\d{4}-[A-za-z]{3}-){2}(\\d[A-Za-z]){2}");

        Matcher emailMatcher = emailPattern.matcher(fileInn);
        Matcher phoneMatcher = phonePattern.matcher(fileInn);
        Matcher documentMatcher = documentPattern.matcher(fileInn);

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

    public void readingAndProcessing() {
        // D:\TeachMeSkills\Projects\Lesson17\src\resources
        try (DirectoryStream<Path> listOfFiles = Files.newDirectoryStream(Path.of(DocumentPath.getInputPathToFolder()))) {
            HashMap<String, Document> resume = new HashMap<>();
            List<String> list = listFill(listOfFiles);

            int validFiles = 0;
            int invalidFiles = 0;
            int filesToProcess = DocumentPath.getInputDocsQuantity();

            if (filesToProcess <= 0) {
                System.out.println(ProcessExceptions.getBelowZero());
            } else if (list.size() == 0) {
                System.out.println(ProcessExceptions.getNoFiles());
            } else {
                for (int i = 0; i < Math.min(list.size(), filesToProcess); i++) {
                    if (list.get(i).matches(".+\\.txt\\b")) {
                        validFiles++;
                        String fileInn = Files.readString(Path.of(list.get(i)));
                        Document doc = docRetrieving(fileInn);
                        resume.put(list.get(i).replaceAll("\\.txt", ""), doc);
                    } else {
                        System.out.println(list.get(i) + ProcessExceptions.getWrongFormat());
                        invalidFiles++;
                    }
                }
                System.out.println("Valid files : " + validFiles);
                System.out.println("Invalid files : " + invalidFiles);
            }
            mapDescription(resume);
        } catch (Exception e) {
            e.printStackTrace();
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

