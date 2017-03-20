package Test;

import books.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class tests {


    @Test
    public void delRecord() {
        PhoneBook a = new PhoneBook();
        PhoneBook b = new PhoneBook();
        b.addRecord("Jon", "89993453456");
        String str = b.toString();
        a.addRecord("Kit", "89535678934");
        a.delRecord("Kit");
        assertEquals(a.toString(),str);
    }

    @Test
    public void addNumber() {
        PhoneBook a = new PhoneBook();
        a.addRecord("Jon", "89993453456");
        String str = "Имя: Jon Номер: [89993453456, 89992332443]\n";
        a.addNumber("Jon", "89992332443");
        assertEquals(a.toString(),str);
    }

    @Test
    public void delNumber() {
        PhoneBook a = new PhoneBook();
        a.addRecord("Jon", "89993453456");
        String str = "Имя: Jon Номер: [89992332443]\n";
        a.addNumber("Jon", "89992332443");
        a.delNumber("Jon", "89993453456");
        assertEquals(a.toString(),str);
    }

    @Test
    public void searchByName() {
        ArrayList<Record> checkList = new ArrayList<>();
        PhoneBook a = new PhoneBook();
        a.addRecord("Jon", "89956544567");
        a.addRecord("Kit", "78564734345");
        checkList.add(new Record("Jon", "89956544567"));
        ArrayList<Record> result = a.searchByName("Jon");
        Assert.assertEquals(checkList, result);
    }

    @Test
    public void searchByNumber() {
        ArrayList<Record> checkList = new ArrayList<>();
        PhoneBook a = new PhoneBook();
        a.addRecord("Jon", "89956544567");
        a.addRecord("Kit", "78564734345");
        checkList.add(new Record("Jon", "89956544567"));
        ArrayList<Record> result = a.searchByNumber("89956544567");
        Assert.assertEquals(checkList, result);
    }

}