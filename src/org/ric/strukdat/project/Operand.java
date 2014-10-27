package org.ric.strukdat.project;

/**
 * 
 * @author Greg Chandra
 */
public class Operand extends Data {
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

}
