package books;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhoneBook {

    private ArrayList<Record> book = new ArrayList<>();


    public void addRecord(String name, String numPhone) {
        Record a = new Record(name, numPhone);
        book.add(a);
    }

    public void addRecord(String name, List<String> numbers) {
        Record a = new Record(name, numbers);
        book.add(a);
    }

    //метод удаление записи
    public void delRecord(String names) {
        Record result = null;
        for (Record aBook : book) {
            if (names.equals(aBook.getName())) result = aBook;
        }
        if (result != null)
            book.remove(result);
    }

    //метод добавления номера
    public void addNumber(String names, String numbers) {
        for (Record aBook : book) {
            if (names.equals(aBook.getName())) {
                aBook.addNumber(numbers);
                //aBook.addNumber(number);
            }
        }
    }

    //метод удаление номера
    public void delNumber(String names, String numbers) {
        for (Record aBook : book) {
            if (names.equals(aBook.getName())) {
                aBook.getNumbers().remove(numbers);
            }
        }
    }

    //метод поиска по имени
    public List<Record> searchByName(String names) {
        ArrayList<Record> miniBook = new ArrayList<>();
        for (Record aBook : book) {
            if (names.equals(aBook.getName())) {
                miniBook.add(aBook);
            }

        }
        return miniBook;
    }

    //метод поиск по номеру
    public List<Record> searchByNumber(String numbers) {
        ArrayList<Record> miniBook = new ArrayList<>();
        for (Record aBook : book) {
            if (aBook.getNumbers().indexOf(numbers) != -1) {
                miniBook.add(aBook);
            }
        }
        return miniBook;
    }

    //формат вывода
    @Override
    public String toString() {
        String result = "";
        for (Record aBook : book) {
            result = result + "Имя: " + aBook.getName() + " " + "Номер: " + aBook.getNumbers() + "\n";
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PhoneBook phoneBook = (PhoneBook) o;

        return book != null ? book.equals(phoneBook.book) : phoneBook.book == null;

    }

    @Override
    public int hashCode() {
        return book != null ? book.hashCode() : 0;
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
                f.delNumber(q, c);
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


