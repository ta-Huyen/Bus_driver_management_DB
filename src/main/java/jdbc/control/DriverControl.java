package jdbc.control;

import jdbc.database.BusDriverDBUtil;
import jdbc.main.*;
import jdbc.object.*;

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

            BusDriver driver = new BusDriver(0, name, address, phoneNumber, level);
            Main.drivers.add(driver);
            BusDriverDBUtil.writeData(driver);
        }

        printData();
    }

    public static BusDriver findById (int id) {
        List<BusDriver> filterDriver = Main.drivers.stream().filter(d -> (d.getLxId() == id)).toList();
        return filterDriver.isEmpty() ? null : filterDriver.get(0);
    }

    private static void printData() {
        System.out.println("Danh sach cac lai xe:");
        for (BusDriver i : Main.drivers) {
            System.out.println(i.toString());
        }
    }

}
