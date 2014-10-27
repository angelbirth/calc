package org.ric.strukdat.project;

/**
 * 
 * @author Eric
 * 
 */
public class Kurung extends Data {
    public static final Kurung BUKA = new Kurung() {
        public String toString() {
            return "(";
        }
    };
    public static final Kurung TUTUP = new Kurung() {
        public String toString() {
            return ")";
        }
    };
    // udah gitu aja
}
