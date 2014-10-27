package org.ric.strukdat.project;

import org.ric.strukdat.project.Data.Kurung;
import org.ric.strukdat.project.Data.Operand;
import org.ric.strukdat.project.Data.Operator;

public class Evaluator {

    private Queue<Data> tokenizedExpression;

    public Evaluator(String expression) throws IllegalArgumentException {
        super();
        tokenizedExpression = new Ekspresi(expression).toQueue();
    }

    public double evaluate() throws IllegalArgumentException {
        Stack<Data> operatorStack = new Stack<>();
        Stack<Operand> operandStack = new Stack<>();
        while (!tokenizedExpression.isEmpty()) {
            // jika antrian depan operand (angka)
            if (tokenizedExpression.peek() instanceof Operand) {
                operandStack.push((Operand) tokenizedExpression.dequeue());

            } // jika antrian depan operator
            else if (tokenizedExpression.peek() instanceof Operator) {
                Operator cur = ((Operator) tokenizedExpression.peek());
                if (operatorStack.peek() instanceof Operator) {
                    Operator top = ((Operator) operatorStack.peek());
                    if (cur.precedence() <= top.precedence()) {
                        if (operandStack.size() >= 2) {
                            double a = operandStack.pop().getData();
                            double b = operandStack.pop().getData();
                            double result = ((Operator) operatorStack.pop())
                                    .operate(a, b);
                            operandStack.push(new Operand(result));
                        } else
                            throw new IllegalArgumentException(
                                    "Malformed expression");
                    } else {
                        operatorStack.push(tokenizedExpression
                                .dequeue());
                    }
                } else {
                    operatorStack
                            .push(tokenizedExpression.dequeue());
                }
            } // jika antrian depan kurung
            else {
                if ((Data.Kurung) tokenizedExpression.peek() == Kurung.BUKA) {
                    operatorStack.push(tokenizedExpression.dequeue());
                } else { // kalau kurung tutup
                    while (!(operatorStack.peek() == Kurung.BUKA)) {
                        // selama top operator stack bukan kurung buka
                        if (operandStack.size() >= 2) {
                            double a = operandStack.pop().getData(); // pop 2
                                                                     // operand
                            double b = operandStack.pop().getData();
                            double result = ((Operator) operatorStack.pop()) // pop
                                    // operator
                                    .operate(a, b); // operasikan
                            operandStack.push(new Operand(result));// push lagi
                                                                   // ke
                            // operand stack
                        } else
                            throw new IllegalArgumentException(
                                    "Malformed expression");
                    }
                    tokenizedExpression.dequeue();
                    operatorStack.pop(); // pop kurung buka
                }
            }
        }
        while (!operatorStack.isEmpty()) {
            if (operandStack.size() >= 2) {
                double a = operandStack.pop().getData();
                double b = operandStack.pop().getData();
                double result = ((Operator) operatorStack.pop()).operate(a, b);
                operandStack.push(new Operand(result));
            } else
                throw new IllegalArgumentException("Malformed expression");
        }
        // if (operandStack.size() == 1) System.out.println("Benar");
        return operandStack.pop().getData();
    }
}
