package org.ric.strukdat.project


/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
/**
 *
 * @author Greg Chandra
 */
sealed class Data {

    class Operand : Data, Comparable<Operand> {

        var data: Double = 0.toDouble()

        constructor(nilai: Double) {
            data = nilai
        }

        constructor(angka: String) {
            data = angka.toDouble()
        }

        override fun toString() = data.toString()

        operator override fun compareTo(other: Operand): Int {
            return java.lang.Double.compare(data, other.data)
        }
    }

    class Operator internal constructor(operator: Char) : Data(), Comparable<Operator> {
        //</editor-fold>
        private val op: (Double,Double)->Double
        private val precedence: Int
        private val toString: String

        init {
            when (operator) {
                '^' -> {
                    op = POWER
                    precedence = 3
                    toString = "^"
                }
                '+' -> {
                    op = ADD
                    precedence = 1
                    toString = "+"
                }
                '-' -> {
                    op = SUB
                    precedence = 1
                    toString = "-"
                }
                '*' -> {
                    op = MULT
                    precedence = 2
                    toString = "*"
                }
                '/' -> {
                    op = DIV
                    precedence = 2
                    toString = "/"
                }
                else -> throw IllegalArgumentException()
            }
        }

        fun operate(x: Double, y: Double): Double {
            return op(x, y)
        }

        fun precedence(): Int {
            return precedence
        }

        override fun toString(): String {
            return toString
        }

        operator override fun compareTo(other: Operator): Int {
            return precedence() - other.precedence()
        }

        companion object {

            private val POWER = { a: Double, b: Double -> Math.pow(a, b) }
            private val ADD = { a: Double, b: Double -> a + b }
            private val SUB = { a: Double, b: Double -> a - b }
            private val MULT = { a: Double, b: Double -> a * b }
            private val DIV = { a: Double, b: Double ->
                if (a != 0.0) b / a else when {
                    b > 0 -> Double.POSITIVE_INFINITY
                    b < 0 -> Double.NEGATIVE_INFINITY
                    else -> Double.NaN
                }
            }
        }
    }

    open class Kurung : Data() {
        companion object {

            @JvmField val BUKA: Kurung = object : Kurung() {

                override fun toString(): String {
                    return "("
                }
            }
           @JvmField val TUTUP: Kurung = object : Kurung() {

                override fun toString(): String {
                    return ")"
                }
            }
        }
        // udah gitu aja
    }
}
