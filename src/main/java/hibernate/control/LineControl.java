package hibernate.control;

import hibernate.database.LineDBUtil;
import hibernate.main.*;
import hibernate.object.*;

import java.util.List;
import java.util.Scanner;

public class LineControl {
    public static void addNew(Scanner scanner) {
        System.out.println("Nhap so luong tuyen xe moi:");
        int quantity = Integer.parseInt(scanner.nextLine());

        for (int i=0; i<quantity; i++) {
            System.out.println("Nhap thong tin tuyen xe thu " + (i + 1) + ".");
            System.out.print("Khoang cach: ");
            double distance = Double.parseDouble(scanner.nextLine());
            System.out.print("So diem dung: ");
            int busStop = Integer.parseInt(scanner.nextLine());

            Line line = new Line(0, distance, busStop);
            Main.lines.add(line);
            LineDBUtil.saveDate(line);
        }

        printData();
    }

    public static Line findById (int id) {
        List<Line> filterLine = Main.lines.stream().filter(l -> (l.getId() == id)).toList();
        return filterLine.isEmpty() ? null : filterLine.get(0);
    }

    private static void printData() {
        System.out.println("Danh sach cac tuyen xe:");
        for (Line i : Main.lines) {
            System.out.println(i.toString());
        }
    }
}
