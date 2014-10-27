package org.ric.strukdat.project;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Greg Chandra
 */
public interface Operasi {
    public double operate(double y, double x);
    public int precedence();
}
