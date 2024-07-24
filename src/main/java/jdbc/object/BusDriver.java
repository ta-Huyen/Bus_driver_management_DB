package jdbc.object;

public class BusDriver {
    private static int currentId = 10000;
    private final int lxId;
    private final String name;
    private final String address;
    private final String phoneNumber;
    private final String level;

    public BusDriver(int id, String name, String address, String phoneNumber, String level) {
        this.lxId = (id == 0) ? currentId : id;
        currentId = this.lxId + 1;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.level = level;
    }

    public int getLxId() {
        return lxId;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getLevel() {
        return level;
    }

    @Override
    public String toString() {
        return  lxId + " - " + name + " - " + address + " - " + phoneNumber + " - " + level;
    }
}
