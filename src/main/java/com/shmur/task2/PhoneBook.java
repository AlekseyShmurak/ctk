package com.shmur.task2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class PhoneBook {
    private HashMap<String, ArrayList<Long>> phoneBook;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.addNumber("Иванов Алексей Петрович", 8800555555L);
        phoneBook.addNumber("Иванов Алексей Петрович", 8800777777L);

        System.out.println("Введите имя абонента");
        String sub = in.nextLine();
        phoneBook.showAllSubscriberNumbers(sub);
    }

    public PhoneBook() {
        this.phoneBook = new HashMap<String, ArrayList<Long>>();
    }

    public void addSubscriber(String subscriber) {
        if (phoneBook.isEmpty() || !phoneBook.containsKey(subscriber)) {
            this.phoneBook.put(subscriber, new ArrayList<Long>());
        }
    }

    public void addNumber(String subscriber, long number) {
        addSubscriber(subscriber);
        if (!phoneBook.get(subscriber).contains(number)) {
            phoneBook.get(subscriber).add(number);
        }
    }

    public void showAllSubscriberNumbers(String subscriber) {
        if (phoneBook.containsKey(subscriber)) {
            if(!phoneBook.get(subscriber).isEmpty()) {
                System.out.println("Телефонные номера абонента: " + subscriber);
                for (Long number : phoneBook.get(subscriber)) {
                    System.out.println("+ " + number);
                }
            } else {
                System.out.println("У абонента нет телефонных номеров");
            }
        } else {
            System.out.println("Абонент в базе отсутствует");
        }
    }
}
