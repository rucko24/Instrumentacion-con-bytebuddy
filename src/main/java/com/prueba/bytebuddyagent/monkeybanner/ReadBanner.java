package com.prueba.bytebuddyagent.monkeybanner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ReadBanner {

    private ReadBanner() {}

    public static void showBanner() {
        try (InputStream input = ReadBanner.class.getClassLoader().getResourceAsStream("banner.txt");
             final BufferedReader reader = new BufferedReader(new InputStreamReader(input))) {
            reader.lines().forEach(System.out::println);
            System.out.println();
        } catch (IOException ex) {
            System.out.println("Fix the mono");
        }
    }

}
