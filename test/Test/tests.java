package Test;

import books.*;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class tests {


    @Test
    public void delRecord() {
        PhoneBook a = new PhoneBook();
        PhoneBook b = new PhoneBook();
        b.addRecord("Jon", "89993453456");
        a.addRecord("Jon", "89993453456");
        a.addRecord("Kit", "89535678934");
        a.delRecord("Kit");

        assertEquals(a,b);
    }
}