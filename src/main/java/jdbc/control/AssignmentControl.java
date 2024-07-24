package jdbc.control;

import jdbc.database.AssignmentDBUtil;
import jdbc.main.*;
import jdbc.object.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AssignmentControl {
    public static void addNew(Scanner scanner) {
        System.out.println("Nhap ma lai xe:");
        int id = Integer.parseInt(scanner.nextLine());

        BusDriver driver = DriverControl.findById(id);
        if (driver == null) {
            System.out.println("Khong tim thay lai xe!");
            return;
        }

        while (true) {
            System.out.println("Nhap tuyen xe phan cong cho lai xe(nhan 0 de ket thuc):");
            int lineId = Integer.parseInt(scanner.nextLine());
            if (lineId == 0) break;

            BusLines line = LineControl.findById(lineId);
            if (line == null) {
                System.out.println("Khong tim thay tuyen xe!");
                continue;
            }

            System.out.print("Nhap so luot lai trong ngay: ");
            int n = Integer.parseInt(scanner.nextLine());

            if (!checkAllowedTurn(driver, line, n)) {
                System.out.println("So luong luot lai trong ngay da vuot qua 15, khong the phan cong them!");
            }
        }

        printData();
    }

    private static boolean checkAllowedTurn(BusDriver driver, BusLines line, int n) {
        if (n > 15) {
            return false;
        }

        List<AssignmentBoard> filterAssignment =
                Main.assignments.stream().filter(a -> (a.getDriver().equals(driver) && a.getLine().equals(line))).toList();

        if (!filterAssignment.isEmpty()) {
            if ((filterAssignment.get(0).getTurns() + n) > 15) {
                return false;
            }
            filterAssignment.get(0).setTurns(n);
            AssignmentDBUtil.updateData(filterAssignment.get(0));
            return true;
        }

        AssignmentBoard assignment = new AssignmentBoard(driver, line, n);
        Main.assignments.add(assignment);
        AssignmentDBUtil.writeData(assignment);

        return true;
    }

    public static void sortChoice(Scanner scanner) {
        System.out.println("1: Sap xep theo ho ten lai xe.");
        System.out.println("2: Sap xep theo so luong tuyen dam nhan trong ngay(giam dan)");

        System.out.println("Nhap lua chon:");
        while (true) {
            int choice = Integer.parseInt(scanner.nextLine());

            if (choice == 1) {
                sortByDriverName();
                break;
            } else if (choice == 2) {
                sortByLinesAssignment();
                break;
            } else {
                System.out.println("Lua chon khong hop le! Xin vui long nhap lai!");
            }
        }
    }

    private static void sortByDriverName() {
        Comparator<AssignmentBoard> compareByName = Comparator.comparing(a -> a.getDriver().getName());
        Main.assignments.sort(compareByName);

        printData();
    }

    private static void sortByLinesAssignment() {
        ArrayList<List<AssignmentBoard>> mapAssignmentByDriver = new ArrayList<>();
        for (BusDriver driver : Main.drivers) {
            List<AssignmentBoard> filterAssignment =
                    Main.assignments.stream().filter(a -> (a.getDriver().equals(driver))).collect(Collectors.toList());

            if (!filterAssignment.isEmpty()) {
                mapAssignmentByDriver.add(filterAssignment);
            }
        }

        Comparator<List<AssignmentBoard>> compareByLines = (a1, a2) -> Integer.compare(a2.size(), a1.size());
        mapAssignmentByDriver.sort(compareByLines);

        Main.assignments.clear();
        for (List<AssignmentBoard> i : mapAssignmentByDriver) {
            Main.assignments.addAll(i);
        }

        printData();
    }

    public static void calculateDistance() {
        System.out.println("Tong khoang cach xe chay cua moi lai xe:");
        for (AssignmentBoard i : Main.assignments) {
            System.out.println("Lai xe " + i.getDriver().getName() + " - " + i.getDrivingDistance() + "km");
        }
    }

    public static void printData() {
        System.out.println("Bang phan cong:");
        for (AssignmentBoard i : Main.assignments) {
            System.out.println(i.toString());
        }
    }
}
