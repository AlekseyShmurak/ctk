package com.shmur.task1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class IpHandlerTest {
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
    public void displayIps() {
        IpHandler.displayIps(168430090L, 168430095L);
        assertThat(new String(out.toByteArray()), is(new StringBuilder()
                .append("Доступные Ip адреса: ").append(System.lineSeparator())
                .append("10.10.10.10").append(System.lineSeparator())
                .append("10.10.10.11").append(System.lineSeparator())
                .append("10.10.10.12").append(System.lineSeparator())
                .append("10.10.10.13").append(System.lineSeparator())
                .append("10.10.10.14").append(System.lineSeparator())
                .append("10.10.10.15").append(System.lineSeparator()).toString()));
    }

    @Test
    public void validate() {
        assertThat(IpHandler.validate("10.10.10.10"), is(true));
        assertThat(IpHandler.validate("10010410140"), is(false));
    }

    @Test
    public void ipToLong() {
        assertThat(IpHandler.ipToLong("10.10.10.10"), is(168430090L));
        assertThat(IpHandler.ipToLong("10.10.10.15"), is(168430095L));
    }

    @Test
    public void longToIp() {
        assertThat(IpHandler.longToIp(168430090L), is("10.10.10.10"));
        assertThat(IpHandler.longToIp(168430095L), is("10.10.10.15"));
    }
}