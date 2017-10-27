package org.ric.strukdat.project

import org.ric.strukdat.project.Data.Kurung
import org.ric.strukdat.project.Data.Operand
import org.ric.strukdat.project.Data.Operator

import java.util.Queue
import java.util.Stack

class Evaluator @Throws(IllegalArgumentException::class)
constructor(expression: String) {

    private val tokenizedExpression: Queue<Data>

    init {
        tokenizedExpression = Ekspresi(expression).toQueue()
    }

    @Throws(IllegalArgumentException::class)
    fun evaluate(): Double {
        val operatorStack = Stack<Data>()
        val operandStack = Stack<Operand>()
        while (tokenizedExpression.isNotEmpty()) {
            // jika antrian depan operand (angka)
            val token:Data = tokenizedExpression.peek()
            if (token is Operand) {
                operandStack.push(token)

            } // jika antrian depan operator
            else {
                val op = operatorStack.peek()
                if (token is Operator) {
                    val cur = token
                    if (op is Operator) {
                        val top = op
                        if (cur.precedence() <= top.precedence()) {
                            if (operandStack.size >= 2) {
                                val a = operandStack.pop().data
                                val b = operandStack.pop().data
                                val result = (operatorStack.pop() as Operator)
                                        .operate(a, b)
                                operandStack.push(Operand(result))
                            } else
                                throw IllegalArgumentException(
                                        "Malformed expression")
                        } else {
                            operatorStack.push(tokenizedExpression
                                    .poll())
                        }
                    } else {
                        operatorStack
                                .push(tokenizedExpression.poll())
                    }
                } // jika antrian depan kurung
                else {
                    if (token === Kurung.BUKA) {
                        operatorStack.push(tokenizedExpression.poll())
                    } else { // kalau kurung tutup
                        while (!(op === Kurung.BUKA)) {
                            // selama top operator stack bukan kurung buka
                            if (operandStack.size >= 2) {
                                val a = operandStack.pop().data // pop 2
                                // operand
                                val b = operandStack.pop().data
                                val result = (operatorStack.pop() as Operator) // pop
                                        // operator
                                        .operate(a, b) // operasikan
                                operandStack.push(Operand(result))// push lagi
                                // ke
                                // operand stack
                            } else
                                throw IllegalArgumentException(
                                        "Malformed expression")
                        }
                        tokenizedExpression.poll()
                        operatorStack.pop() // pop kurung buka
                    }
                }
            }
        }
        while (!operatorStack.isEmpty()) {
            if (operandStack.size >= 2) {
                val a = operandStack.pop().data
                val b = operandStack.pop().data
                val result = (operatorStack.pop() as Operator).operate(a, b)
                operandStack.push(Operand(result))
            } else
                throw IllegalArgumentException("Malformed expression")
        }
        // if (operandStack.size() == 1) System.out.println("Benar");
        return operandStack.pop().data
    }
}
