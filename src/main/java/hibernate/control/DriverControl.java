package hibernate.control;

import hibernate.database.DriverDBUtil;
import hibernate.main.*;
import hibernate.object.*;

import java.util.List;
import java.util.Scanner;

public class DriverControl {
    public static void addNew(Scanner scanner) {
        System.out.println("Nhap so luong lai xe moi:");
        int quantity = Integer.parseInt(scanner.nextLine());

        for (int i=0; i<quantity; i++) {
            System.out.println("Nhap thong tin lai xe thu " + (i + 1) + ".");
            System.out.print("Ho ten: ");
            String name = scanner.nextLine();
            System.out.print("Dia chi: ");
            String address = scanner.nextLine();
            System.out.print("SDT: ");
            String phoneNumber = scanner.nextLine();
            System.out.print("Trinh do (A->F): ");
            String level = scanner.nextLine();

            Driver driver = new Driver(0, name, address, phoneNumber, level);
            Main.drivers.add(driver);
            DriverDBUtil.saveDate(driver);
        }

        printData();
    }

    public static Driver findById (int id) {
        List<Driver> filterDriver = Main.drivers.stream().filter(d -> (d.getId() == id)).toList();
        return filterDriver.isEmpty() ? null : filterDriver.get(0);
    }

    private static void printData() {
        System.out.println("Danh sach cac lai xe:");
        for (Driver i : Main.drivers) {
            System.out.println(i.toString());
        }
    }

}
