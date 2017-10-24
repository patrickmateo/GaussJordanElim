package GaussJordanElim;

/**
 *
 * @author John Patrick Mateo
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.text.*;

class GaussGUI extends JFrame implements ActionListener {

    JLabel numTitle = new JLabel("Number");
    JLabel numRow1 = new JLabel("1");
    JLabel numRow2 = new JLabel("2");
    JLabel numRow3 = new JLabel("3");

    JLabel numX = new JLabel("X");
    JLabel numY = new JLabel("Y");
    JLabel numZ = new JLabel("Z");
    JLabel numValue = new JLabel("Value");

    JButton buttonSolve = new JButton("Compute");
    JButton buttonReset = new JButton("Clear");
    JButton buttonExit = new JButton("Exit");

    JTextField txtRowX1 = new JTextField();
    JTextField txtRowY1 = new JTextField();
    JTextField txtRowZ1 = new JTextField();
    JTextField txtRowV1 = new JTextField();

    JTextField txtRowX2 = new JTextField();
    JTextField txtRowY2 = new JTextField();
    JTextField txtRowZ2 = new JTextField();
    JTextField txtRowV2 = new JTextField();

    JTextField txtRowX3 = new JTextField();
    JTextField txtRowY3 = new JTextField();
    JTextField txtRowZ3 = new JTextField();
    JTextField txtRowV3 = new JTextField();

    double x1, y1, z1, v1,
            x2, y2, z2, v2,
            x3, y3, z3, v3;

    DecimalFormat sample = new DecimalFormat("0.000000");
    
    public GaussGUI(String title) {
        super(title);
        buttonSolve.addActionListener(this);
        buttonReset.addActionListener(this);
        buttonExit.addActionListener(this);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        showMatrix();
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == buttonSolve) {
            computeMatrix();
        }
        if (ae.getSource() == buttonReset) {
            resetMatrix();
        }
        if (ae.getSource() == buttonExit) {
            exitProg();
        }
    }

    public void exitProg() {
        int confirm = JOptionPane.showOptionDialog(null,
                "Do you want to close this application?",
                "Exit Confirmation", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, null, null);
        if (confirm == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    public void resetMatrix() {

        txtRowX1.setText("");
        txtRowY1.setText("");
        txtRowZ1.setText("");
        txtRowV1.setText("");
        txtRowX2.setText("");
        txtRowY2.setText("");
        txtRowZ2.setText("");
        txtRowV2.setText("");
        txtRowX3.setText("");
        txtRowY3.setText("");
        txtRowZ3.setText("");
        txtRowV3.setText("");
    }

    public void computeMatrix() {

        if (txtRowX1.getText().equals("") || txtRowY1.getText().equals("")
                || txtRowZ1.getText().equals("") || txtRowV1.getText().equals("")
                || txtRowX2.getText().equals("") || txtRowY2.getText().equals("")
                || txtRowZ2.getText().equals("") || txtRowV2.getText().equals("")
                || txtRowX3.getText().equals("") || txtRowY3.getText().equals("")
                || txtRowZ3.getText().equals("") || txtRowV3.getText().equals("")) {

            JOptionPane.showMessageDialog(null, "Please fillup the matrix first!", "Invalid", JOptionPane.ERROR_MESSAGE);

        } else if (txtRowX1.getText().equals("0") && txtRowY1.getText().equals("0")
                && txtRowZ1.getText().equals("0") && txtRowV1.getText().equals("0")
                && txtRowX2.getText().equals("0") && txtRowY2.getText().equals("0")
                && txtRowZ2.getText().equals("0") && txtRowV2.getText().equals("0")
                && txtRowX3.getText().equals("0") && txtRowY3.getText().equals("0")
                && txtRowZ3.getText().equals("0") && txtRowV3.getText().equals("0")) {

            System.out.println("Walang solution yan... -_-");
            JOptionPane.showMessageDialog(null, "No computation", "Zero input", JOptionPane.WARNING_MESSAGE);

        } else if (txtRowX1.getText().equals("1") && txtRowY1.getText().equals("1")
                && txtRowZ1.getText().equals("1") && txtRowV1.getText().equals("1")
                && txtRowX2.getText().equals("1") && txtRowY2.getText().equals("1")
                && txtRowZ2.getText().equals("1") && txtRowV2.getText().equals("1")
                && txtRowX3.getText().equals("1") && txtRowY3.getText().equals("1")
                && txtRowZ3.getText().equals("1") && txtRowV3.getText().equals("1")) {

            System.out.println("Walang solution yan... -_-");
            JOptionPane.showMessageDialog(null, "x+y+z = 1", "Answer", JOptionPane.INFORMATION_MESSAGE);

        } else {
            try {
                x1 = Double.parseDouble(txtRowX1.getText());
                y1 = Double.parseDouble(txtRowY1.getText());
                z1 = Double.parseDouble(txtRowZ1.getText());
                v1 = Double.parseDouble(txtRowV1.getText());

                x2 = Double.parseDouble(txtRowX2.getText());
                y2 = Double.parseDouble(txtRowY2.getText());
                z2 = Double.parseDouble(txtRowZ2.getText());
                v2 = Double.parseDouble(txtRowV2.getText());

                x3 = Double.parseDouble(txtRowX3.getText());
                y3 = Double.parseDouble(txtRowY3.getText());
                z3 = Double.parseDouble(txtRowZ3.getText());
                v3 = Double.parseDouble(txtRowV3.getText());

                GaussEq x = new GaussEq();

                x.numbers[0][0] = (x1);
                x.numbers[0][1] = (y1);
                x.numbers[0][2] = (z1);
                x.numbers[0][3] = (v1);

                x.numbers[1][0] = (x2);
                x.numbers[1][1] = (y2);
                x.numbers[1][2] = (z2);
                x.numbers[1][3] = (v2);

                x.numbers[2][0] = (x3);
                x.numbers[2][1] = (y3);
                x.numbers[2][2] = (z3);
                x.numbers[2][3] = (v3);

                x.printNum();
                x.computeNum();
                x.printAns();

                JOptionPane.showMessageDialog(null, "x = (" + sample.format(x.numbers[0][3]) + ")"
                        + "\ny = (" + sample.format(x.numbers[1][3]) + ")"
                        + "\nz = (" + sample.format(x.numbers[2][3]) + ")",
                        "Answer", JOptionPane.INFORMATION_MESSAGE);

            } catch (NumberFormatException e) {
                System.out.println("Bobo lang?, bakit letter ginamit mo? Katol pa!!");
                JOptionPane.showMessageDialog(null, "Numbers only!", "Invalid input", JOptionPane.ERROR_MESSAGE);
            } finally {

            }

        }
    }

    public void showMatrix() {
        JPanel pnlMatrix2 = new JPanel();
        setLayout(new BorderLayout());
        pnlMatrix2.setSize(400, 130);
        pnlMatrix2.setLayout(new GridLayout(4, 5));
        pnlMatrix2.add(numTitle);
        pnlMatrix2.add(numX);
        pnlMatrix2.add(numY);
        pnlMatrix2.add(numZ);
        pnlMatrix2.add(numValue);

        pnlMatrix2.add(numRow1);
        pnlMatrix2.add(txtRowX1);
        pnlMatrix2.add(txtRowY1);
        pnlMatrix2.add(txtRowZ1);
        pnlMatrix2.add(txtRowV1);

        pnlMatrix2.add(numRow2);
        pnlMatrix2.add(txtRowX2);
        pnlMatrix2.add(txtRowY2);
        pnlMatrix2.add(txtRowZ2);
        pnlMatrix2.add(txtRowV2);

        pnlMatrix2.add(numRow3);
        pnlMatrix2.add(txtRowX3);
        pnlMatrix2.add(txtRowY3);
        pnlMatrix2.add(txtRowZ3);
        pnlMatrix2.add(txtRowV3);

        add(pnlMatrix2, BorderLayout.NORTH);

        JPanel pnlMatrix3 = new JPanel();
        setLayout(new BorderLayout());
        pnlMatrix3.setSize(100, 150);
        pnlMatrix3.setLayout(new FlowLayout());
        pnlMatrix3.add(buttonSolve);
        pnlMatrix3.add(buttonReset);
        pnlMatrix3.add(buttonExit);
        add(pnlMatrix3, BorderLayout.SOUTH);
    }
}
