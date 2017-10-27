package org.ric.strukdat.project

import java.io.FileInputStream
import java.io.FileNotFoundException
import java.util.Scanner

fun main(args: Array<String>) {
    if (args.size > 0)
        try {
            if (args[0] != "-") {
                val file = FileInputStream(args[0])
                System.setIn(file)
            }
        } catch (e1: FileNotFoundException) {
            System.err.println("File tidak ditemukan.")
            System.exit(1)
        }

    println("Hai! Masukkan ekspresi matematika untuk dievaluasi:")
    val s = Scanner(System.`in`)
    try {
        val e = Evaluator(s.nextLine())
        System.out.printf("Hasil perhitungannya adalah %f", e.evaluate())
    } catch (ex: IllegalArgumentException) {
        System.err.println(ex.message)
    }

    s.close()
}


