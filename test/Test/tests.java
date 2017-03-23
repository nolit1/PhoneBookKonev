package Test;

import books.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class tests {


    @Test
    public void delRecord() {
        PhoneBook a = new PhoneBook();
        PhoneBook b = new PhoneBook();
        a.addRecord("Jon", "89993453456");
        b.addRecord("Jon", "89993453456");
        a.addRecord("Kit", "89535678934");
        a.delRecord("Kit");
        assertEquals(a, b);
    }

    @Test
    public void addNumber() {
        PhoneBook a = new PhoneBook();
        PhoneBook b = new PhoneBook();
        List<String> numbers = new ArrayList<>();
        numbers.add("89993453456");
        numbers.add("89992332443");

        a.addRecord("Jon", "89993453456");
        a.addNumber("Jon", "89992332443");

        b.addRecord("Jon", numbers);

        assertEquals(a, b);
    }

    @Test
    public void delNumber() {
        PhoneBook a = new PhoneBook();
        PhoneBook b = new PhoneBook();
        a.addRecord("Jon", "89993453456");
        b.addRecord("Jon", "89993453456");
        a.addNumber("Jon", "89992332443");
        a.delNumber("Jon", "89992332443");
        assertEquals(a, b);
    }

    @Test
    public void searchByName() {
        ArrayList<Record> checkList = new ArrayList<>();
        PhoneBook a = new PhoneBook();
        a.addRecord("Jon", "89956544567");
        a.addRecord("Kit", "78564734345");
        checkList.add(new Record("Jon", "89956544567"));
        List<Record> result = a.searchByName("Jon");
        Assert.assertEquals(checkList, result);
    }

    @Test
    public void searchByNumber() {
        ArrayList<Record> checkList = new ArrayList<>();
        PhoneBook a = new PhoneBook();
        a.addRecord("Jon", "89956544567");
        a.addRecord("Kit", "78564734345");
        checkList.add(new Record("Jon", "89956544567"));
        List<Record> result = a.searchByNumber("89956544567");
        Assert.assertEquals(checkList, result);
    }

}