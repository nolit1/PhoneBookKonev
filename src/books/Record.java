package books;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Record {
    String name;
    ArrayList<String> numbers = new ArrayList<>();

    private static boolean trueNumber(String numPhone) {  //проверка формата номера
        Pattern p = Pattern.compile("[\\d*#()\\-+]+");
        Matcher m = p.matcher(numPhone);
        return m.matches();
    }

    public Record(String name, String number) {
        this.name = name;
        if (trueNumber((number)))
            numbers.add(number);
        else throw new IllegalArgumentException("Номер не соответствует формату");
    }

    @Override
    public String toString() {
        return "Имя: " + name + " " + "Номер: " + numbers + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Record record = (Record) o;

        return name.equals(record.name) && numbers.equals(record.numbers);

    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + numbers.hashCode();
        return result;
    }
}

