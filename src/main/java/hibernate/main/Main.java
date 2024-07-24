package hibernate.main;

import hibernate.control.*;
import hibernate.database.*;
import hibernate.object.*;

import java.util.*;

public class Main {
    public static ArrayList<Driver> drivers = new ArrayList<>();
    public static ArrayList<Line> lines = new ArrayList<>();
    public static ArrayList<Assignment> assignments = new ArrayList<>();

    public static int driverId = 10000;
    public static int lineId = 100;

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initializeData();
        menu();
    }

    private static void initializeData() {
        DriverDBUtil.loadData(drivers);
        setDriverId(drivers.size());
        LineDBUtil.loadData(lines);
        setLineId(lines.size());
        AssignmentDBUtil.loadData(assignments);
    }

    private static void menu() {
        while (true) {
            System.out.println("Menu.");
            System.out.println("1: Nhap danh sach lai xe moi.");
            System.out.println("2: Nhap danh sach tuyen moi.");
            System.out.println("3: Nhap phan cong cho moi lai xe.");
            System.out.println("4: Sap xep danh sach phan cong.");
            System.out.println("5: Lap bang thong ke tong khoang cach xe chay trong ngay.");
            System.out.println("0: Thoat.");

            System.out.println("Nhap lua chon: ");
            int choice = Integer.parseInt(scanner.nextLine());
            try {
                switch (choice) {
                    case 1:
                        DriverControl.addNew(scanner);
                        break;
                    case 2:
                        LineControl.addNew(scanner);
                        break;
                    case 3:
                        AssignmentControl.addNew(scanner);
                        break;
                    case 4:
                        AssignmentControl.sortChoice(scanner);
                        break;
                    case 5:
                        AssignmentControl.calculateDistance();
                        break;
                    case 0:
                        return;
                    default:
                        System.out.println("Lua chon khong hop le!");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    public static void setDriverId(int increasement) {
        Main.driverId += increasement;
    }

    public static void setLineId(int increasement) {
        Main.lineId += increasement;
    }
}