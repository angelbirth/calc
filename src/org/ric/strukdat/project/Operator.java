package org.ric.strukdat.project;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * 
 * @author Greg Chandra
 */
public class Operator extends Data implements Operasi {
    private Operasi op;
    private static final Operasi ADD = new Operasi() {

        @Override
        public double operate(double x, double y) {
            return y+x;
        }

        @Override
        public int precedence() {
            // TODO Auto-generated method stub
            return 1;
        }
        public String toString() {return "+";}
    };
    private static final Operasi SUB = new Operasi() {

        @Override
        public double operate(double x, double y) {
            return y-x;
        }

        @Override
        public int precedence() {
            // TODO Auto-generated method stub
            return 1;
        }public String toString() {return "-";}
    };
    private static final Operasi MULT = new Operasi() {

        @Override
        public double operate(double x, double y) {
            return y*x;
        }

        @Override
        public int precedence() {
            // TODO Auto-generated method stub
            return 2;
        }
        public String toString() {return "*";}
    };
    private static final Operasi DIV = new Operasi() {

        @Override
        public double operate(double x, double y) {
            return y/x;
        }

        @Override
        public int precedence() {
            // TODO Auto-generated method stub
            return 2;
        }
        public String toString() {return "/";}
    };

    Operator(char operator) {
        switch (operator) {
            case '+':
                op = ADD;
                break;
            case '-':
                op = SUB;
                break;
            case '*':
                op = MULT;
                break;
            case '/':
                op = DIV;
                break;
        }
    }

    @Override
    public double operate(double x, double y) {
        return op.operate(x, y);
    }

    @Override
    public int precedence() {
        // TODO Auto-generated method stub
        return op.precedence();
    }
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return op.toString();
    }

}
