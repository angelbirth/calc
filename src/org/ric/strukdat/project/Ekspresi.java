package org.ric.strukdat.project;
import org.ric.strukdat.project.Data.*;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */

/**
 * 
 * @author admin
 */
public class Ekspresi {

    private String ekspresi;

    public Queue<String> tokenize() {
        Queue<String> res = new Queue<>();

        String asd = "";
        for (char i : ekspresi.toCharArray()) {
            if (Character.isDigit(i) || i == '.') {
                asd += i;
            } else {
                if (!asd.equals("")) {
                    // System.err.println(asd);
                    res.enqueue(asd);
                }
                res.enqueue(String.valueOf(i));
                asd = "";
            }
        }
        if (!asd.equals("")) {
            res.enqueue(asd);
        }

        // Queue<String> num = new Queue<>();
        // Queue<String> op = new Queue<>();
        // String[] angka = ekspresi.split("[\\(\\)/\\*\\+\\-]");
        // String[] operator = ekspresi.split("[0-9.]", 0);
        // for (String a : angka) {
        // //System.out.println(a);
        // num.enqueue(a);
        // }
        // for (String a : operator) {
        // if (!a.equals("")) {
        // op.enqueue(a);
        // //System.out.println(a);
        // }
        // }
        //
        // while (!op.isEmpty()) {
        // res.enqueue(num.dequeue());
        // res.enqueue(op.dequeue());
        // }
        // res.enqueue(num.dequeue());
        return res;
    }

    public Ekspresi(String ekspresi) throws IllegalArgumentException {
        if (!isValid(ekspresi)) {
            throw new IllegalArgumentException("Ekspresi salah");
        }
        this.ekspresi = ekspresi;
    }

    public static boolean isValid(String ekspresi) {
        if (ekspresi.matches("[ ^\\[\\]\\(\\)\\{\\}0-9*+.\\-/]+")
                && cekKurung(ekspresi)) {
            return true;
        }
        return false;
    }

    public static boolean cekKurung(String ekspresi) {
        Stack<Character> kurung = new Stack<Character>();
        for (char a : ekspresi.toCharArray()) {
            switch (a) {
            case '{':
            case '(':
            case '[':
                kurung.push(new Character(a));
                break;
            case ')':
                if (kurung.peek().charValue() == '(') {
                    kurung.pop();
                }
                break;
            case '}':
                if (kurung.peek().charValue() == '{') {
                    kurung.pop();
                }
                break;
            case ']':
                if (kurung.peek().charValue() == '[') {
                    kurung.pop();
                }
                break;
            }
        }
        return kurung.isEmpty();
    }

    public Queue<Data> toQueue() {
        Queue<Data> q = new Queue<>();
        Queue<String> x = tokenize();
        while (!x.isEmpty()) {
            if (x.peek().matches("[0-9.]+")) {
                q.enqueue(new Operand(x.dequeue()));
            } else if (x.peek().matches("[+\\-*/^]")) {
                q.enqueue(new Operator(x.dequeue().charAt(0)));
            } else if (x.peek().matches("[\\(\\[\\{]")) {
                q.enqueue(Kurung.BUKA);
                x.dequeue();
            } else if (x.peek().matches("[\\)\\}\\]]")) {
                q.enqueue(Kurung.TUTUP);
                x.dequeue();
            }
        }
        return q;
    }

    // public static void main(String[] args) {
    // Ekspresi e = new Ekspresi("(10.3+21.50)*35");
    // Queue<Data> a=e.toQueue();
    // while(!a.isEmpty())System.out.println(a.dequeue());
    // }
}
