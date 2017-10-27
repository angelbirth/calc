package org.ric.strukdat.project

import java.awt.EventQueue
import java.awt.Font
import java.awt.GridBagConstraints
import java.awt.GridBagLayout
import java.awt.Insets
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import java.awt.event.KeyAdapter
import java.awt.event.KeyEvent

import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.JOptionPane
import javax.swing.JPanel
import javax.swing.JTextField
import javax.swing.SwingConstants
import javax.swing.UIManager
import javax.swing.border.EmptyBorder
import javax.swing.border.LineBorder

class Calculator : JFrame() {


    private val contentPane: JPanel
    private val txtDisplay: JTextField
    private val btnBksp: JButton
    private val btn1: JButton
    private val btn0: JButton
    private val btn2: JButton
    private val btn3: JButton
    private val btn4: JButton
    private val btn5: JButton
    private val btn6: JButton
    private val btn7: JButton
    private val btn8: JButton
    private val btnPeriod: JButton
    private val btn9: JButton
    private val btnPlus: JButton
    private val btnMin: JButton
    private val btnMult: JButton
    private val btnDiv: JButton
    private val btnLP: JButton
    private val btnRP: JButton
    private val btnExec: JButton
    private val txtDisplay_KeyTyped: KeyAdapter
    private val BTN_CLICK = ActionListener { e -> Btn_Click(e) }
    private val res: JButton

    /**
     * Create the frame.
     */
    init {
        title = "Calculator"
        isResizable = false
        defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        setBounds(100, 100, 323, 243)
        contentPane = JPanel()
        contentPane.border = EmptyBorder(5, 5, 5, 5)
        setContentPane(contentPane)
        val gbl_contentPane = GridBagLayout()
        gbl_contentPane.columnWidths = intArrayOf(168, 120)
        gbl_contentPane.rowHeights = intArrayOf(50, 149, 0)
        gbl_contentPane.columnWeights = doubleArrayOf(0.0, 0.0)
        gbl_contentPane.rowWeights = doubleArrayOf(0.0, 0.0, java.lang.Double.MIN_VALUE)
        contentPane.layout = gbl_contentPane

        txtDisplay = JTextField()
        txtDisplay.horizontalAlignment = SwingConstants.RIGHT
        txtDisplay.font = Font("Digital-7 Mono", Font.PLAIN, 24)
        txtDisplay_KeyTyped = object : KeyAdapter() {

            override fun keyTyped(e: KeyEvent?) {
                val validInput = "0123456789/*-+.(){}[]".toCharArray()
                if (Calculator.search(e!!.keyChar, validInput) == -1) {
                    e.consume()
                }

            }

            override fun keyPressed(e: KeyEvent?) {
                if (e!!.keyCode == KeyEvent.VK_ENTER) {
                    btnExec_Click(null)
                } else if (e.keyCode == KeyEvent.VK_ESCAPE) {
                    txtDisplay.text = ""
                }
            }
        }
        txtDisplay.addKeyListener(txtDisplay_KeyTyped)
        val gbc_txtDisplay = GridBagConstraints()
        gbc_txtDisplay.anchor = GridBagConstraints.NORTH
        gbc_txtDisplay.fill = GridBagConstraints.BOTH
        gbc_txtDisplay.insets = Insets(5, 0, 5, 5)
        gbc_txtDisplay.gridwidth = 2
        gbc_txtDisplay.gridx = 0
        gbc_txtDisplay.gridy = 0
        contentPane.add(txtDisplay, gbc_txtDisplay)

        val pnlNumber = JPanel()

        pnlNumber.border = LineBorder(null)
        val gbc_pnlNumber = GridBagConstraints()
        gbc_pnlNumber.anchor = GridBagConstraints.SOUTHWEST
        gbc_pnlNumber.fill = GridBagConstraints.BOTH
        gbc_pnlNumber.insets = Insets(0, 0, 0, 5)
        gbc_pnlNumber.gridx = 0
        gbc_pnlNumber.gridy = 1
        contentPane.add(pnlNumber, gbc_pnlNumber)
        pnlNumber.layout = null

        btn0 = JButton("0")
        btn0.font = Font("Dialog", Font.PLAIN, 12)
        btn0.setBounds(10, 113, 41, 23)
        pnlNumber.add(btn0)

        btn1 = JButton("1")
        btn1.font = Font("Dialog", Font.PLAIN, 12)
        btn1.setBounds(10, 79, 41, 23)
        pnlNumber.add(btn1)

        btn2 = JButton("2")
        btn2.font = Font("Dialog", Font.PLAIN, 12)
        btn2.setBounds(61, 79, 41, 23)
        pnlNumber.add(btn2)

        btn3 = JButton("3")
        btn3.font = Font("Dialog", Font.PLAIN, 12)
        btn3.setBounds(112, 79, 41, 23)
        pnlNumber.add(btn3)

        btn4 = JButton("4")
        btn4.font = Font("Dialog", Font.PLAIN, 12)
        btn4.setBounds(10, 45, 41, 23)
        pnlNumber.add(btn4)

        btn5 = JButton("5")
        btn5.font = Font("Dialog", Font.PLAIN, 12)
        btn5.setBounds(61, 45, 41, 23)
        pnlNumber.add(btn5)

        btn6 = JButton("6")
        btn6.font = Font("Dialog", Font.PLAIN, 12)
        btn6.setBounds(112, 45, 41, 23)
        pnlNumber.add(btn6)

        btn7 = JButton("7")
        btn7.font = Font("Dialog", Font.PLAIN, 12)
        btn7.setBounds(10, 11, 41, 23)
        pnlNumber.add(btn7)

        btn8 = JButton("8")
        btn8.font = Font("Dialog", Font.PLAIN, 12)
        btn8.setBounds(61, 11, 41, 23)
        pnlNumber.add(btn8)

        btn9 = JButton("9")
        btn9.font = Font("Dialog", Font.PLAIN, 12)
        btn9.setBounds(112, 11, 41, 23)
        pnlNumber.add(btn9)

        btnPeriod = JButton(".")
        btnPeriod.font = Font("Dialog", Font.PLAIN, 12)
        btnPeriod.setBounds(61, 113, 92, 23)
        pnlNumber.add(btnPeriod)
        btnPeriod.addActionListener(BTN_CLICK)
        btn9.addActionListener(BTN_CLICK)
        btn8.addActionListener(BTN_CLICK)
        btn7.addActionListener(BTN_CLICK)
        btn6.addActionListener(BTN_CLICK)
        btn5.addActionListener(BTN_CLICK)
        btn4.addActionListener(BTN_CLICK)
        btn3.addActionListener(BTN_CLICK)
        btn2.addActionListener(BTN_CLICK)
        btn1.addActionListener(BTN_CLICK)
        btn0.addActionListener(BTN_CLICK)

        val panel = JPanel()
        val gbc_panel = GridBagConstraints()
        gbc_panel.anchor = GridBagConstraints.SOUTHEAST
        gbc_panel.insets = Insets(0, 0, 0, 5)
        gbc_panel.gridx = 1
        gbc_panel.gridy = 1
        contentPane.add(panel, gbc_panel)
        val gbl_panel = GridBagLayout()
        gbl_panel.columnWidths = intArrayOf(43, 48, 0)
        gbl_panel.rowHeights = intArrayOf(23, 0, 23, 23, 26, 0)
        gbl_panel.columnWeights = doubleArrayOf(0.0, 0.0, java.lang.Double.MIN_VALUE)
        gbl_panel.rowWeights = doubleArrayOf(0.0, 0.0, 0.0, 0.0, 0.0, java.lang.Double.MIN_VALUE)
        panel.layout = gbl_panel

        btnBksp = JButton('\u2190'.toString())
        btnBksp.addActionListener {
            val loc = txtDisplay.caretPosition - 1

            if (loc + 1 > 0) {
                val text0 = txtDisplay.text.substring(0, loc)
                val text1 = txtDisplay.text.substring(loc + 1)
                txtDisplay.text = text0 + text1
                txtDisplay.requestFocusInWindow()
                txtDisplay.caretPosition = loc
            } else {
                txtDisplay.requestFocusInWindow()
            }
        }
        val gbc_btnBksp = GridBagConstraints()
        gbc_btnBksp.insets = Insets(0, 0, 5, 5)
        gbc_btnBksp.gridx = 0
        gbc_btnBksp.gridy = 0
        panel.add(btnBksp, gbc_btnBksp)

        res = JButton("C")
        val gbc_res = GridBagConstraints()
        gbc_res.fill = GridBagConstraints.HORIZONTAL
        gbc_res.insets = Insets(0, 0, 5, 0)
        gbc_res.gridx = 1
        gbc_res.gridy = 0
        panel.add(res, gbc_res)
        res.addActionListener { txtDisplay.text = "" }




        btnPlus = JButton("+")
        val gbc_btnPlus = GridBagConstraints()
        gbc_btnPlus.fill = GridBagConstraints.HORIZONTAL
        gbc_btnPlus.anchor = GridBagConstraints.NORTH
        gbc_btnPlus.insets = Insets(0, 0, 5, 5)
        gbc_btnPlus.gridx = 0
        gbc_btnPlus.gridy = 1
        panel.add(btnPlus, gbc_btnPlus)
        btnPlus.addActionListener(BTN_CLICK)

        btnMin = JButton("-")
        val gbc_btnMin = GridBagConstraints()
        gbc_btnMin.anchor = GridBagConstraints.NORTH
        gbc_btnMin.fill = GridBagConstraints.HORIZONTAL
        gbc_btnMin.insets = Insets(0, 0, 5, 0)
        gbc_btnMin.gridx = 1
        gbc_btnMin.gridy = 1
        panel.add(btnMin, gbc_btnMin)
        btnMin.addActionListener(BTN_CLICK)

        btnMult = JButton("*")
        val gbc_btnMult = GridBagConstraints()
        gbc_btnMult.anchor = GridBagConstraints.NORTH
        gbc_btnMult.fill = GridBagConstraints.HORIZONTAL
        gbc_btnMult.insets = Insets(0, 0, 5, 5)
        gbc_btnMult.gridx = 0
        gbc_btnMult.gridy = 2
        panel.add(btnMult, gbc_btnMult)
        btnMult.addActionListener(BTN_CLICK)

        btnDiv = JButton("/")
        val gbc_btnDiv = GridBagConstraints()
        gbc_btnDiv.anchor = GridBagConstraints.NORTH
        gbc_btnDiv.fill = GridBagConstraints.HORIZONTAL
        gbc_btnDiv.insets = Insets(0, 0, 5, 0)
        gbc_btnDiv.gridx = 1
        gbc_btnDiv.gridy = 2
        panel.add(btnDiv, gbc_btnDiv)
        btnDiv.addActionListener(BTN_CLICK)

        btnLP = JButton("(")
        val gbc_btnLP = GridBagConstraints()
        gbc_btnLP.anchor = GridBagConstraints.NORTH
        gbc_btnLP.fill = GridBagConstraints.HORIZONTAL
        gbc_btnLP.insets = Insets(0, 0, 5, 5)
        gbc_btnLP.gridx = 0
        gbc_btnLP.gridy = 3
        panel.add(btnLP, gbc_btnLP)
        btnLP.addActionListener(BTN_CLICK)

        btnRP = JButton(")")
        val gbc_btnRP = GridBagConstraints()
        gbc_btnRP.anchor = GridBagConstraints.NORTH
        gbc_btnRP.fill = GridBagConstraints.HORIZONTAL
        gbc_btnRP.insets = Insets(0, 0, 5, 0)
        gbc_btnRP.gridx = 1
        gbc_btnRP.gridy = 3
        panel.add(btnRP, gbc_btnRP)
        btnRP.addActionListener(BTN_CLICK)

        btnExec = JButton("=")
        val gbc_btnExec = GridBagConstraints()
        gbc_btnExec.fill = GridBagConstraints.BOTH
        gbc_btnExec.gridwidth = 2
        gbc_btnExec.gridx = 0
        gbc_btnExec.gridy = 4
        panel.add(btnExec, gbc_btnExec)
        btnExec.addActionListener(this::btnExec_Click)
    }

    private fun Btn_Click(e: ActionEvent) {
        val loc = txtDisplay.caretPosition
        val text0 = txtDisplay.text.substring(0, loc)
        var text1 = txtDisplay.text.substring(loc)
        text1 = e.actionCommand + text1
        txtDisplay.text = text0 + text1
        txtDisplay.requestFocusInWindow()
        txtDisplay.caretPosition = loc + 1
    }

    private fun btnExec_Click(e: ActionEvent?) {
        val result: Double
        try {
            result = Evaluator(txtDisplay.text).evaluate()
        } catch (ex: IllegalArgumentException) {
            JOptionPane.showMessageDialog(this@Calculator,
                    "Malformed expression", "Error", JOptionPane.ERROR_MESSAGE)
            return
        }

        val format: String
        if (result - result.toInt() != 0.0) {
            format = "%f"
        } else {
            format = "%.0f"
        }
        txtDisplay.text = String.format(format, result)
    }

    companion object {

        /**
         *
         */
        private val serialVersionUID = 5972115608745599430L

        private inline fun search(search: Char, array: CharArray)
                = array.indexOf(search)

        /**
         * Launch the application.
         */
        @JvmStatic
        fun main(args: Array<String>) {
            EventQueue.invokeLater {
                try {
                    UIManager.setLookAndFeel(com.jtattoo.plaf.mcwin.McWinLookAndFeel())
                    val frame = Calculator()
                    frame.isVisible = true
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }
    }
}
