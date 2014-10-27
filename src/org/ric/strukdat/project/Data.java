package org.ric.strukdat.project;


/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
/**
 *
 * @author Greg Chandra
 */
public abstract class Data {

    public static class Operand extends Data implements Comparable<Operand> {

        private double data;

        public Operand(double nilai) {
            data = nilai;
        }

        public Operand(String angka) {
            data = Double.parseDouble(angka);
        }

        public double getData() {
            return data;
        }

        public void setData(double data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return String.valueOf(data);
        }

        @Override
        public int compareTo(Operand o) {
            return (int) (data - o.data);
        }
    }

    public static class Operator extends Data implements Comparable<Operator> {

        //<editor-fold defaultstate="collapsed" desc="comment">
        private static final BinaryOperator<Double> POWER = new BinaryOperator<Double>() {
            
            @Override
            public Double apply(Double a, Double b) {
                return Math.pow(a, b);
            }
        };
        private static final BinaryOperator<Double> ADD = new BinaryOperator<Double>() {
            
            @Override
            public Double apply(Double a, Double b) {
                return a.doubleValue() + b.doubleValue();
            }
        };
        private static final BinaryOperator<Double> SUB = new BinaryOperator<Double>() {
            
            @Override
            public Double apply(Double a, Double b) {
                return a.doubleValue() - b.doubleValue();
            }
        };
        private static final BinaryOperator<Double> MULT = new BinaryOperator<Double>() {
            
            @Override
            public Double apply(Double a, Double b) {
                return a.doubleValue() * b.doubleValue();
            }
        };
        private static final BinaryOperator<Double> DIV = new BinaryOperator<Double>() {
            
            @Override
            public Double apply(Double a, Double b) {
                if (a.doubleValue() != 0) {
                    return b.doubleValue() / a.doubleValue();
                }
                return null;
            }
        };
        //</editor-fold>
        private BinaryOperator<Double> op;
        private final int precedence;
        private final String toString;

        Operator(char operator) {
            switch (operator) {
                case '^':
                    op = POWER;
                    precedence = 3;
                    toString = "^";
                    break;
                case '+':
                    op = ADD;
                    precedence = 1;
                    toString = "+";
                    break;
                case '-':
                    op = SUB;
                    precedence = 1;
                    toString = "-";
                    break;
                case '*':
                    op = MULT;
                    precedence = 2;
                    toString = "*";
                    break;
                case '/':
                    op = DIV;
                    precedence = 2;
                    toString = "/";
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        }

        public double operate(double x, double y) {
            return op.apply(x, y);
        }

        public int precedence() {
            return precedence;
        }

        @Override
        public String toString() {
            return toString;
        }

        @Override
        public int compareTo(Operator o) {
            return precedence() - o.precedence();
        }
    }

    public static class Kurung extends Data {

        public static final Kurung BUKA = new Kurung() {

            @Override
            public String toString() {
                return "(";
            }
        };
        public static final Kurung TUTUP = new Kurung() {

            @Override
            public String toString() {
                return ")";
            }
        };
        // udah gitu aja
    }

    interface BinaryOperator<T> {

        T apply(T a, T b);
    }
}
