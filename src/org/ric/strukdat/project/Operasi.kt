package org.ric.strukdat.project

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Greg Chandra
 */
interface Operasi {
    fun operate(x: Double, y: Double): Double
    val precedence: Int
}
