package org.ric.strukdat.project;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author MONICA
 */
public class PStack {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Stack<Data> s=new Stack<>();
        s.push(Kurung.BUKA);
        s.push(new Operand(1));
        s.push(new Operator('+'));
        s.push(new Operand(5));
        s.push(Kurung.TUTUP);
        while(!(s.peek()==Kurung.BUKA)){
            if(s.isEmpty())System.err.println("Kosong");
            else {
                if(s.peek()==Kurung.BUKA) System.out.println("Ketemi");
                s.pop();}
        }
    }
}
