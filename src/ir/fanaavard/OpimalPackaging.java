package ir.fanaavard;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OpimalPackaging {

    private enum Colors {
        GREEN,
        RED,
        DEFAULT
    }

    private static int n, m, k;
    private static List<Integer> a_items = new ArrayList<>();
    private static int j = 0;

    public static void main(String[] args) {
        init();
        if (computeTotalObject(0) < k * m) {
            printMsg("Boxes empty or objects more than boxes count!", Colors.RED);
        } else {
            for (int x = 1; x <= computeTotalObject(x); x++) {
                j = computeTotalObject(x) - computeTotalObject(x + 1);
                if (!(j < k)) {
                    j = computeTotalObject(x + 1);
                }
            }
            printMsg(computeTotalObject(2));
            j = j == 0 ? n : j;
            printMsg("Output (j) 'or' (The max count of the putted shapes to box) value is: " + j, Colors.GREEN);
        }

    }


    private static void init() {
        try {
            initializeConsole();
        } catch (Exception e) {
            init();
        }
    }

    private static void initializeConsole() throws Exception {
        Scanner s = new Scanner(System.in);
        printMsg("HELLO WORLD :)", Colors.GREEN);
        printMsg("\rEnter n (Count of objects) value: ");
        n = Integer.parseInt(s.nextLine());
        printMsg("\rEnter m (Count of Boxes) value: ");
        m = Integer.parseInt(s.nextLine());
        printMsg("\rEnter k (Size of box) value: ");
        k = Integer.parseInt(s.nextLine());
        a_items = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int boxNumber = i + 1;
            printMsg("\rEnter object " + boxNumber + " size: ");
            a_items.add(Integer.parseInt(s.nextLine()));
            if (a_items.get(i) > k) {
                printMsg("\rObject number cannot beginner than box size!");
                System.exit(-2);
            }
        }
    }


    private static void printMsg(Object... messages) {
        String msg = "";
        for (Object message : messages) {
            msg += message + " ";
        }
        System.out.println(getColor(Colors.DEFAULT) + msg);
    }

    private static void printMsg(int msg) {
        System.out.println(getColor(Colors.DEFAULT) + msg);
    }

    private static void printMsg(String msgText) {
        System.out.println(getColor(Colors.DEFAULT) + msgText);
    }

    private static void printMsg(String msgText, Colors color) {
        System.out.println(getColor(color) + msgText);
    }

    private static String getColor(Colors colors) {
        if (colors == Colors.GREEN) {
            return "\u001B[32m";
        } else if (colors == Colors.RED) {
            return "\u001B[31m";
        } else {
            return "\u001B[0m";
        }
    }


    public static int computeTotalObject(int startIndex) {
        int totalObject = 0;
        for (int i = startIndex; i < n; i++) {
            totalObject += a_items.get(i);
        }
        return totalObject;
    }


}
