package Books;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.*;

public class PhoneBook {

    private class obj {
        String name;
        ArrayList<String> Number = new ArrayList<>();

        @Override
        public String toString() {
            return "Имя: " + name + " " + "Номер: " + Number + "\n";
        }
    }

    private static ArrayList<obj> book = new ArrayList<>();

    private boolean adnumber(String numPhone) {
        Pattern p = Pattern.compile("[\\d*#()\\-+]+");
        Matcher m = p.matcher(numPhone);
        return m.matches();
    }

    private void addRecord(String name, String numPhone) {
        obj a = new obj();
        a.name = name;
        if (adnumber(numPhone)) {
            a.Number.add(numPhone);
            book.add(a);
        }
        else System.out.println("Номер некорректен");
    }

    //метод удаление записи
    private void delRecord(String names) {
        obj result = new obj();
        for (obj aBook : book) {
            if (names.equals(aBook.name)) result = aBook;
        }
        book.remove(result);
    }

    //метод добавления номера
    private void addNumber(String names, String numbers) {
        for (obj aBook : book) {
            if (names.equals(aBook.name)) {
                if (adnumber(numbers)) aBook.Number.add(numbers);
                else System.out.println("Номер некорректен");
            }
        }
    }

    //метод удаление номера
    private void delNumber(String names, String numbers) {
        for (obj aBook : book) {
            if (names.equals(aBook.name)) {
                aBook.Number.remove(numbers);
            }
        }
    }

    //метод поиска по имени
    private obj searchByName(String names) {
        obj result = new obj();
        for (obj aBook : book) {
            if (names.equals(aBook.name)) {
                result = aBook;
            }

        }
        return result;
    }

    //метод поиск по номеру
    private obj searchByNumber(String numbers) {
        obj result = new obj();
        for (obj aBook : book) {
            if (aBook.Number.indexOf(numbers) != -1) {
                result = aBook;
                break;
            }
        }
        return result; //System.out.println("Контактов с этим номером нет");
    }

    //формат вывода
    @Override
    public String toString() {
        String result = "";
        for (obj aBook : book) {
            result = result + "Имя: " + aBook.name + " " + "Номер: " + aBook.Number + "\n";
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

