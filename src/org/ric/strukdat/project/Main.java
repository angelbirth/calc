package org.ric.strukdat.project;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        if (args.length > 0) try {
            if (!args[0].equals("-")) {
                FileInputStream file = new FileInputStream(args[0]);
                System.setIn(file);
            }
        } catch (FileNotFoundException e1) {
            System.err.println("File tidak ditemukan.");
            System.exit(1);
        }
        System.out
                .println("Hai! Masukkan ekspresi matematika untuk dievaluasi:");
        Scanner s = new Scanner(System.in);
        try {
            Evaluator e = new Evaluator(s.nextLine());
            System.out.printf("Hasil perhitungannya adalah %f", e.evaluate());
        } catch (IllegalArgumentException ex) {
            System.err.println(ex.getMessage());
        }
        s.close();
    }

}
