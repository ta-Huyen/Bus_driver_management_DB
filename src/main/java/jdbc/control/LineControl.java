package jdbc.control;

import jdbc.database.BusLinesDBUtil;
import jdbc.main.*;
import jdbc.object.*;

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

            BusLines line = new BusLines(0, distance, busStop);
            Main.lines.add(line);
            BusLinesDBUtil.writeData(line);
        }

        printData();
    }

    public static BusLines findById (int id) {
        List<BusLines> filterLine = Main.lines.stream().filter(l -> (l.getLineId() == id)).toList();
        return filterLine.isEmpty() ? null : filterLine.get(0);
    }

    private static void printData() {
        System.out.println("Danh sach cac tuyen xe:");
        for (BusLines i : Main.lines) {
            System.out.println(i.toString());
        }
    }
}
