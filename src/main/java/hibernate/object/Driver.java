package hibernate.object;

import hibernate.main.Main;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "driver")
public class Driver {
    @Id
    @Column (name = "id")
    private int id;
    @Column (name = "name")
    private String name;
    @Column (name = "address")
    private String address;
    @Column (name = "phoneNumber")
    private String phoneNumber;
    @Column (name = "level")
    private String level;

    public Driver() {
    }

    public Driver(int id, String name, String address, String phoneNumber, String level) {
        this.id = Main.driverId++;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.level = level;
    }

    public int getId() {
        return id;
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
        return id + " - " + name + " - " + address + " - " + phoneNumber + " - " + level;
    }
}
