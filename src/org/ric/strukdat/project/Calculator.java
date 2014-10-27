package org.ric.strukdat.project;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class Calculator extends JFrame {

    /**
     * 
     */
    private static final long serialVersionUID = 5972115608745599430L;


    private JPanel contentPane;
    private JTextField txtDisplay;
    private JButton btnBksp;
    private JButton btn1;
    private JButton btn0;
    private JButton btn2;
    private JButton btn3;
    private JButton btn4;
    private JButton btn5;
    private JButton btn6;
    private JButton btn7;
    private JButton btn8;
    private JButton btnPeriod;
    private JButton btn9;
    private JButton btnPlus;
    private JButton btnMin;
    private JButton btnMult;
    private JButton btnDiv;
    private JButton btnLP;
    private JButton btnRP;
    private JButton btnExec;

    private static int search(char search, char[] array) {
        for (int i = 0; i < array.length; i++) {
            if (search == array[i]) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(new com.jtattoo.plaf.mcwin.McWinLookAndFeel());
                    Calculator frame = new Calculator();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public Calculator() {
        setTitle("Calculator");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 323, 243);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        GridBagLayout gbl_contentPane = new GridBagLayout();
        gbl_contentPane.columnWidths = new int[]{168, 120};
        gbl_contentPane.rowHeights = new int[]{50, 149, 0};
        gbl_contentPane.columnWeights = new double[]{0.0, 0.0};
        gbl_contentPane.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
        contentPane.setLayout(gbl_contentPane);

        txtDisplay = new JTextField();
        txtDisplay.setHorizontalAlignment(SwingConstants.RIGHT);
        txtDisplay.setFont(new Font("Digital-7 Mono", Font.PLAIN, 24));
        txtDisplay.addKeyListener(txtDisplay_KeyTyped);
        GridBagConstraints gbc_txtDisplay = new GridBagConstraints();
        gbc_txtDisplay.anchor = GridBagConstraints.NORTH;
        gbc_txtDisplay.fill = GridBagConstraints.BOTH;
        gbc_txtDisplay.insets = new Insets(5, 0, 5, 5);
        gbc_txtDisplay.gridwidth = 2;
        gbc_txtDisplay.gridx = 0;
        gbc_txtDisplay.gridy = 0;
        contentPane.add(txtDisplay, gbc_txtDisplay);

        JPanel pnlNumber = new JPanel();

        pnlNumber.setBorder(new LineBorder(null));
        GridBagConstraints gbc_pnlNumber = new GridBagConstraints();
        gbc_pnlNumber.anchor = GridBagConstraints.SOUTHWEST;
        gbc_pnlNumber.fill = GridBagConstraints.BOTH;
        gbc_pnlNumber.insets = new Insets(0, 0, 0, 5);
        gbc_pnlNumber.gridx = 0;
        gbc_pnlNumber.gridy = 1;
        contentPane.add(pnlNumber, gbc_pnlNumber);
        pnlNumber.setLayout(null);

        btn0 = new JButton("0");
        btn0.setFont(new Font("Dialog", Font.PLAIN, 12));
        btn0.setBounds(10, 113, 41, 23);
        pnlNumber.add(btn0);

        btn1 = new JButton("1");
        btn1.setFont(new Font("Dialog", Font.PLAIN, 12));
        btn1.setBounds(10, 79, 41, 23);
        pnlNumber.add(btn1);

        btn2 = new JButton("2");
        btn2.setFont(new Font("Dialog", Font.PLAIN, 12));
        btn2.setBounds(61, 79, 41, 23);
        pnlNumber.add(btn2);

        btn3 = new JButton("3");
        btn3.setFont(new Font("Dialog", Font.PLAIN, 12));
        btn3.setBounds(112, 79, 41, 23);
        pnlNumber.add(btn3);

        btn4 = new JButton("4");
        btn4.setFont(new Font("Dialog", Font.PLAIN, 12));
        btn4.setBounds(10, 45, 41, 23);
        pnlNumber.add(btn4);

        btn5 = new JButton("5");
        btn5.setFont(new Font("Dialog", Font.PLAIN, 12));
        btn5.setBounds(61, 45, 41, 23);
        pnlNumber.add(btn5);

        btn6 = new JButton("6");
        btn6.setFont(new Font("Dialog", Font.PLAIN, 12));
        btn6.setBounds(112, 45, 41, 23);
        pnlNumber.add(btn6);

        btn7 = new JButton("7");
        btn7.setFont(new Font("Dialog", Font.PLAIN, 12));
        btn7.setBounds(10, 11, 41, 23);
        pnlNumber.add(btn7);

        btn8 = new JButton("8");
        btn8.setFont(new Font("Dialog", Font.PLAIN, 12));
        btn8.setBounds(61, 11, 41, 23);
        pnlNumber.add(btn8);

        btn9 = new JButton("9");
        btn9.setFont(new Font("Dialog", Font.PLAIN, 12));
        btn9.setBounds(112, 11, 41, 23);
        pnlNumber.add(btn9);

        btnPeriod = new JButton(".");
        btnPeriod.setFont(new Font("Dialog", Font.PLAIN, 12));
        btnPeriod.setBounds(61, 113, 92, 23);
        pnlNumber.add(btnPeriod);
        btnPeriod.addActionListener(BTN_CLICK);
        btn9.addActionListener(BTN_CLICK);
        btn8.addActionListener(BTN_CLICK);
        btn7.addActionListener(BTN_CLICK);
        btn6.addActionListener(BTN_CLICK);
        btn5.addActionListener(BTN_CLICK);
        btn4.addActionListener(BTN_CLICK);
        btn3.addActionListener(BTN_CLICK);
        btn2.addActionListener(BTN_CLICK);
        btn1.addActionListener(BTN_CLICK);
        btn0.addActionListener(BTN_CLICK);

        JPanel panel = new JPanel();
        GridBagConstraints gbc_panel = new GridBagConstraints();
        gbc_panel.anchor = GridBagConstraints.SOUTHEAST;
        gbc_panel.insets = new Insets(0, 0, 0, 5);
        gbc_panel.gridx = 1;
        gbc_panel.gridy = 1;
        contentPane.add(panel, gbc_panel);
        GridBagLayout gbl_panel = new GridBagLayout();
        gbl_panel.columnWidths = new int[]{43, 48, 0};
        gbl_panel.rowHeights = new int[]{23, 0, 23, 23, 26, 0};
        gbl_panel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
        gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0,
            Double.MIN_VALUE};
        panel.setLayout(gbl_panel);

        btnBksp = new JButton(String.valueOf('\u2190'));
        btnBksp.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int loc = txtDisplay.getCaretPosition() - 1;

                if (loc + 1 > 0) {
                    String text0 = txtDisplay.getText().substring(0, loc);
                    String text1 = txtDisplay.getText().substring(loc + 1);
                    txtDisplay.setText(text0 + text1);
                    txtDisplay.requestFocusInWindow();
                    txtDisplay.setCaretPosition(loc);
                } else {
                    txtDisplay.requestFocusInWindow();
                }
            }
        });
        GridBagConstraints gbc_btnBksp = new GridBagConstraints();
        gbc_btnBksp.insets = new Insets(0, 0, 5, 5);
        gbc_btnBksp.gridx = 0;
        gbc_btnBksp.gridy = 0;
        panel.add(btnBksp, gbc_btnBksp);

        res = new JButton("C");
        GridBagConstraints gbc_res = new GridBagConstraints();
        gbc_res.fill = GridBagConstraints.HORIZONTAL;
        gbc_res.insets = new Insets(0, 0, 5, 0);
        gbc_res.gridx = 1;
        gbc_res.gridy = 0;
        panel.add(res, gbc_res);
        res.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                txtDisplay.setText("");
            }
        });




        btnPlus = new JButton("+");
        GridBagConstraints gbc_btnPlus = new GridBagConstraints();
        gbc_btnPlus.fill = GridBagConstraints.HORIZONTAL;
        gbc_btnPlus.anchor = GridBagConstraints.NORTH;
        gbc_btnPlus.insets = new Insets(0, 0, 5, 5);
        gbc_btnPlus.gridx = 0;
        gbc_btnPlus.gridy = 1;
        panel.add(btnPlus, gbc_btnPlus);
        btnPlus.addActionListener(BTN_CLICK);

        btnMin = new JButton("-");
        GridBagConstraints gbc_btnMin = new GridBagConstraints();
        gbc_btnMin.anchor = GridBagConstraints.NORTH;
        gbc_btnMin.fill = GridBagConstraints.HORIZONTAL;
        gbc_btnMin.insets = new Insets(0, 0, 5, 0);
        gbc_btnMin.gridx = 1;
        gbc_btnMin.gridy = 1;
        panel.add(btnMin, gbc_btnMin);
        btnMin.addActionListener(BTN_CLICK);

        btnMult = new JButton("*");
        GridBagConstraints gbc_btnMult = new GridBagConstraints();
        gbc_btnMult.anchor = GridBagConstraints.NORTH;
        gbc_btnMult.fill = GridBagConstraints.HORIZONTAL;
        gbc_btnMult.insets = new Insets(0, 0, 5, 5);
        gbc_btnMult.gridx = 0;
        gbc_btnMult.gridy = 2;
        panel.add(btnMult, gbc_btnMult);
        btnMult.addActionListener(BTN_CLICK);

        btnDiv = new JButton("/");
        GridBagConstraints gbc_btnDiv = new GridBagConstraints();
        gbc_btnDiv.anchor = GridBagConstraints.NORTH;
        gbc_btnDiv.fill = GridBagConstraints.HORIZONTAL;
        gbc_btnDiv.insets = new Insets(0, 0, 5, 0);
        gbc_btnDiv.gridx = 1;
        gbc_btnDiv.gridy = 2;
        panel.add(btnDiv, gbc_btnDiv);
        btnDiv.addActionListener(BTN_CLICK);

        btnLP = new JButton("(");
        GridBagConstraints gbc_btnLP = new GridBagConstraints();
        gbc_btnLP.anchor = GridBagConstraints.NORTH;
        gbc_btnLP.fill = GridBagConstraints.HORIZONTAL;
        gbc_btnLP.insets = new Insets(0, 0, 5, 5);
        gbc_btnLP.gridx = 0;
        gbc_btnLP.gridy = 3;
        panel.add(btnLP, gbc_btnLP);
        btnLP.addActionListener(BTN_CLICK);

        btnRP = new JButton(")");
        GridBagConstraints gbc_btnRP = new GridBagConstraints();
        gbc_btnRP.anchor = GridBagConstraints.NORTH;
        gbc_btnRP.fill = GridBagConstraints.HORIZONTAL;
        gbc_btnRP.insets = new Insets(0, 0, 5, 0);
        gbc_btnRP.gridx = 1;
        gbc_btnRP.gridy = 3;
        panel.add(btnRP, gbc_btnRP);
        btnRP.addActionListener(BTN_CLICK);

        btnExec = new JButton("=");
        GridBagConstraints gbc_btnExec = new GridBagConstraints();
        gbc_btnExec.fill = GridBagConstraints.BOTH;
        gbc_btnExec.gridwidth = 2;
        gbc_btnExec.gridx = 0;
        gbc_btnExec.gridy = 4;
        panel.add(btnExec, gbc_btnExec);
        btnExec.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                btnExec_Click(e);
            }
        });
    }
    private final KeyAdapter txtDisplay_KeyTyped = new KeyAdapter() {

        @Override
        public void keyTyped(KeyEvent e) {
            char[] validInput = "0123456789/*-+.(){}[]".toCharArray();
            if (Calculator.search(e.getKeyChar(), validInput) == -1) {
                e.consume();
            }

        }

        @Override
        public void keyPressed(KeyEvent e) {
            if(e.getKeyCode()==KeyEvent.VK_ENTER){
                btnExec_Click(null);
            }else if(e.getKeyCode()==KeyEvent.VK_ESCAPE) {
                txtDisplay.setText("");
            }
        }
    };
    private final ActionListener BTN_CLICK = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            Btn_Click(e);
        }
    };
    private JButton res;

    private void Btn_Click(ActionEvent e) {
        int loc = txtDisplay.getCaretPosition();
        String text0 = txtDisplay.getText().substring(0, loc);
        String text1 = txtDisplay.getText().substring(loc);
        text1 = e.getActionCommand() + text1;
        txtDisplay.setText(text0 + text1);
        txtDisplay.requestFocusInWindow();
        txtDisplay.setCaretPosition(loc + 1);
    }

    private void btnExec_Click(ActionEvent e) {
        double result;
        try {
            result = new Evaluator(txtDisplay.getText()).evaluate();
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(Calculator.this,
                    "Malformed expression", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String format;
        if (result - (int) (result) != 0d) {
            format = "%f";
        } else {
            format = "%.0f";
        }
        txtDisplay.setText(String.format(format, result));
    }
    // private final ActionListener Btn_Click = e -> {
    // int loc = txtDisplay.getCaretPosition();
    // String text0 = txtDisplay.getText().substring(0, loc);
    // String text1 = txtDisplay.getText().substring(loc);
    // text1 = e.getActionCommand() + text1;
    // txtDisplay.setText(text0 + text1);
    // txtDisplay.requestFocusInWindow();
    // txtDisplay.setCaretPosition(loc + 1);
    // };
}
