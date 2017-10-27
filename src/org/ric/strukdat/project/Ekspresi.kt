package org.ric.strukdat.project

import java.util.ArrayDeque
import java.util.Queue
import java.util.Stack

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */

/**
 * @author admin
 */
internal class Ekspresi @Throws(IllegalArgumentException::class)
constructor(private val ekspresi: String) {

    private fun tokenize(): Queue<String> {
        val res = ArrayDeque<String>()

        var asd = StringBuilder()
        for (i in ekspresi.toCharArray()) {
            if (Character.isDigit(i) || i == '.') {
                asd.append(i)
            } else {
                if (asd.toString() != "") {
                    // System.err.println(asd);
                    res.offer(asd.toString())
                }
                res.offer(i.toString())
                asd = StringBuilder()
            }
        }
        if (asd.toString() != "") {
            res.offer(asd.toString())
        }
        return res
    }

    init {
        if (!ekspresi.isValid()) {
            throw IllegalArgumentException("Ekspresi salah")
        }
    }

    fun toQueue(): Queue<Data> {
        val q = ArrayDeque<Data>()
        val x = tokenize()
        while (!x.isEmpty()) {
            if (x.peek().matches("[0-9.]+".toRegex())) {
                q.add(Data.Operand(x.poll()))
            } else if (x.peek().matches("[+\\-*/^]".toRegex())) {
                q.offer(Data.Operator(x.poll()[0]))
            } else if (x.peek().matches("[\\(\\[\\{]".toRegex())) {
                q.offer(Data.Kurung.BUKA)
                x.poll()
            } else if (x.peek().matches("[\\)\\}\\]]".toRegex())) {
                q.offer(Data.Kurung.TUTUP)
                x.poll()
            }
        }
        return q
    }

    companion object {

        private fun String.isValid(): Boolean {
            return matches("[ ^\\[\\]\\(\\)\\{\\}0-9*+.\\-/]+".toRegex()) && cekKurung()
        }

        private fun String.cekKurung(): Boolean {
            val kurung = Stack<Char>()
            for (a in this) {
                when (a) {
                    '{', '(', '[' -> kurung.push(a)
                    ')' -> if (kurung.peek() == '(') {
                        kurung.pop()
                    }
                    '}' -> if (kurung.peek() == '{') {
                        kurung.pop()
                    }
                    ']' -> if (kurung.peek() == '[') {
                        kurung.pop()
                    }
                }
            }
            return kurung.isEmpty()
        }
    }
}
