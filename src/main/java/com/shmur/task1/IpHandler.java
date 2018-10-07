package com.shmur.task1;


import java.util.regex.Pattern;
import java.util.Scanner;

public class IpHandler {
    private static final Pattern PATTERN = Pattern.compile(
            "^(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.){3}([01]?\\d\\d?|2[0-4]\\d|25[0-5])$");

    public static void main(String[] args) {
        long firstIp;
        long lastIp;
        String temp;
        Scanner in = new Scanner(System.in);
        System.out.println("Введите начальный IP: ");
        temp = in.next();
        while (!validate(temp)){
            System.out.println("Вы ввели IP не корректно, попробуйте ещё раз: ");
            temp = in.next();
        }
        firstIp = ipToLong(temp);
        System.out.println("Введите конечный IP: ");
        temp = in.next();
        while (!validate(temp)){
            System.out.println("Вы ввели IP не корректно, попробуйте ещё раз: ");
            temp = in.next();
        }
        lastIp = ipToLong(temp);
        displayIps(firstIp, lastIp);

        System.out.println();
    }

    public static boolean displayIps(long first, long last) {
        boolean rslt = false;
        System.out.println("Доступные Ip адреса: ");
        if (last - first > 0) {
            for (long i = first; i <= last; i++) {
                System.out.println(longToIp(i));
            }
            rslt = true;
        } else {
            System.out.println("Диапазон указан не верно");
        }
        return rslt;
    }

    public static boolean validate(final String ip) {
        return PATTERN.matcher(ip).matches();
    }

    public static long ipToLong(String ipAddress) {
        String[] ipAddressInArray = ipAddress.split("\\.");
        long result = 0;
        for (int i = 0; i < ipAddressInArray.length; i++) {
            int power = 3 - i;
            int ip = Integer.parseInt(ipAddressInArray[i]);
            result += ip * Math.pow(256, power);
        }
        return result;
    }

    public static String longToIp(long ip) {
        StringBuilder result = new StringBuilder(15);
        for (int i = 0; i < 4; i++) {
            result.insert(0,Long.toString(ip & 0xff));
            if (i < 3) {
                result.insert(0,'.');
            }
            ip = ip >> 8;
        }
        return result.toString();
    }

}
