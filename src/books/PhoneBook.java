package books;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.*;

public class PhoneBook {

    private static ArrayList<Obj> book = new ArrayList<>();

    private boolean trueNumber(String numPhone) {  //проверка формата номера
        Pattern p = Pattern.compile("[\\d*#()\\-+]+");
        Matcher m = p.matcher(numPhone);
        return m.matches();
    }

    public void addRecord(String name, String numPhone) {
        Obj a = new Obj();
        a.name = name;
        if (trueNumber(numPhone)) {
            a.number.add(numPhone);
            book.add(a);
        }
        else System.out.println("Номер некорректен");
    }

    //метод удаление записи
    public void delRecord(String names) {
        Obj result = new Obj();
        for (Obj aBook : book) {
            if (names.equals(aBook.name)) result = aBook;
        }
        book.remove(result);
    }

    //метод добавления номера
    public void addNumber(String names, String numbers) {
        for (Obj aBook : book) {
            if (names.equals(aBook.name)) {
                if (trueNumber(numbers)) aBook.number.add(numbers);
                else System.out.println("Номер некорректен");
            }
        }
    }

    //метод удаление номера
    private void delNumber(String names, String numbers) {
        for (Obj aBook : book) {
            if (names.equals(aBook.name)) {
                aBook.number.remove(numbers);
            }
        }
    }

    //метод поиска по имени
    private ArrayList<Obj> searchByName(String names) {
        ArrayList<Obj> miniBook = new ArrayList<>();
        //Obj result = new Obj();
        for (Obj aBook : book) {
            if (names.equals(aBook.name)) {
                miniBook.add(aBook);
            }

        }
        return miniBook;
    }

    //метод поиск по номеру
    private ArrayList<Obj> searchByNumber(String numbers) {
       // Obj result = new Obj();
        ArrayList<Obj> miniBook = new ArrayList<>();
        for (Obj aBook : book) {
            if (aBook.number.indexOf(numbers) != -1) {
                miniBook.add(aBook);
            }
        }
        return miniBook; //System.out.println("Контактов с этим номером нет");
    }

    //формат вывода
    @Override
    public String toString() {
        String result = "";
        for (Obj aBook : book) {
            result = result + "Имя: " + aBook.name + " " + "Номер: " + aBook.number + "\n";
        }
        return result;
    }



    public static void main(String[] args) {
        PhoneBook f = new PhoneBook();
        f.addRecord("Jon", "+79876543412");
        f.addRecord("Kit", "82343242344");

        System.out.println("1-добавить запись; 2-удалить запись");
        System.out.println("3-поиск по имени; 4-поиск по номеру");
        System.out.println("5-добавление номера контакту; 6-удаление номера у контакта");
        System.out.println("7-вывести все записи; 8-прервать программу");

        System.out.print("Введите номер команды: ");
        Scanner in = new Scanner(System.in);
        int ans = in.nextInt();

        while (ans != 8) {
            if (ans == 1) {
                System.out.print("Введите имя: ");
                String q = in.next();
                System.out.print("Введите номер: ");
                String r = in.next();
                f.addRecord(q, r);
                System.out.print(f.toString());
            }
            if (ans == 2) {
                System.out.print("Введите имя: ");
                String q = in.next();
                f.delRecord(q);
                System.out.print(f.toString());
            }
            if (ans == 3) {
                System.out.print("Введите имя: ");
                String q = in.next();
                System.out.print(f.searchByName(q));

            }

            if (ans == 4) {
                System.out.print("Введите номер: ");
                String q = in.next();
                System.out.print(f.searchByNumber(q));
            }

            if (ans == 5) {
                System.out.print("Введите имя: ");
                String q = in.next();
                System.out.print("Введите номер: ");
                String c = in.next();
                f.addNumber(q, c);
                System.out.print(f.toString());
            }

            if (ans == 6) {
                System.out.print("Введите имя: ");
                String q = in.next();
                System.out.print("Введите номер: ");
                String c = in.next();
                f.delNumber(q,c);
                System.out.print(f.toString());
            }

            if (ans == 7) {
                System.out.println(f.toString());
            }
            System.out.print("Введите номер команды: ");
            ans = in.nextInt();

        }
    }
}

