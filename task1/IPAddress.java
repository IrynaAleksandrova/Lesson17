package task1;

public class IPAddress {
    private final String ipAddress;

    public IPAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    @Override
    public String toString() {
        return "IPAddress {" +
                "ipAddress='" + ipAddress + '\'' +
                '}';
    }
}
