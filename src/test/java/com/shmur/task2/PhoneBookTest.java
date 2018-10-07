package com.shmur.task2;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PhoneBookTest {
    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    @Before
    public void loadOutput() {
        System.setOut(new PrintStream(this.out));
    }
    @After
    public void backOutput() {
        System.setOut(this.stdout);
    }

    @Test
    public void showAllSubscriberNumbers() {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.addSubscriber("Ivanov");
        phoneBook.showAllSubscriberNumbers("Ivanov");
        assertThat(new String(out.toByteArray()), is(new StringBuilder()
                .append("У абонента нет телефонных номеров").append(System.lineSeparator()).toString()));
    }

    @Test
    public void showAllSubscriberNumbersTestTwo() {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.addNumber("Ivanov", 88005555555L);
        phoneBook.addNumber("Ivanov", 88007777777L);
        phoneBook.showAllSubscriberNumbers("Ivanov");
        assertThat(new String(out.toByteArray()), is(new StringBuilder()
                .append("Телефонные номера абонента: Ivanov").append(System.lineSeparator())
                .append("+ 88005555555").append(System.lineSeparator())
                .append("+ 88007777777").append(System.lineSeparator()).toString()));
    }
}