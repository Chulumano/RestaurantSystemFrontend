package za.ac.cput.gui.Chulu.Payment;

/*
 *  Entity for Payments
 *  Author: Chulumanco Buhle Nkwindana (219390983)
 * */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddPaymentGui implements ActionListener {


    //Initializing Components
    private JFrame SavePaymentFrame;
    private JPanel SavePaymentPanelNorth, SavePaymentPanelSouth, SavePaymentPanelEast, SavePaymentPanelWest, SavePaymentPanelCenter;
    private JLabel lblHeading;

    private JLabel lblPaymentID, lblCustomerID, lblPaymentType, lblAmount ;
    private JTextField txtPaymentID, txtCustomerID, txtPaymentType, txtAmount ;

    private JButton btnSave, btnReturn, btnClear;
    private JLabel Filler1, Filler2, Filler3, Filler4, Filler5;
    private Font headingFont;


    //Setting Up GUI Components
    public AddPaymentGui() {
        //Font
        headingFont = new Font("Arial", Font.BOLD, 18);

        //Panels
        SavePaymentFrame = new JFrame("Payment ");
        SavePaymentPanelNorth = new JPanel();
        SavePaymentPanelSouth = new JPanel();
        SavePaymentPanelEast = new JPanel();
        SavePaymentPanelWest = new JPanel();
        SavePaymentPanelCenter = new JPanel();

        SavePaymentPanelNorth.setBackground(Color.LIGHT_GRAY);
        SavePaymentPanelEast.setBackground(Color.LIGHT_GRAY);
        SavePaymentPanelSouth.setBackground(Color.LIGHT_GRAY);
        SavePaymentPanelWest.setBackground(Color.LIGHT_GRAY);
        SavePaymentPanelCenter.setBackground(Color.LIGHT_GRAY);

        //Heading
        lblHeading = new JLabel("Add Payment ", JLabel.CENTER);

        //Labels
        lblPaymentID = new JLabel("PaymentID:");
        lblCustomerID = new JLabel("CustomerID:");
        lblPaymentType= new JLabel("PaymentType:");
        lblAmount = new JLabel("Amount:");


        //TextFields
        txtPaymentID = new JTextField();
        txtCustomerID = new JTextField();
        txtPaymentType = new JTextField();
        txtAmount = new JTextField();


        //Fillers:
        Filler1 = new JLabel("===========");
        Filler2 = new JLabel("===========");
        Filler3 = new JLabel("===========");
        Filler4 = new JLabel("===========");
        Filler5 = new JLabel("===========");
        Filler1.setForeground(Color.LIGHT_GRAY);
        Filler2.setForeground(Color.LIGHT_GRAY);
        Filler3.setForeground(Color.LIGHT_GRAY);
        Filler4.setForeground(Color.LIGHT_GRAY);
        Filler5.setForeground(Color.LIGHT_GRAY);


        //Buttons:
        btnSave = new JButton("Save");
        btnClear = new JButton("Clear");
        btnReturn = new JButton("Return");

    }
    //Setting GUI Layout
    public void setGUI() {
        //Panel Grids
        SavePaymentPanelNorth.setLayout(new GridLayout(4, 1));
        SavePaymentPanelEast.setLayout(new GridLayout(13, 1));
        SavePaymentPanelSouth.setLayout(new GridLayout(1, 4));
        SavePaymentPanelWest.setLayout(new GridLayout(13, 1));
        SavePaymentPanelCenter.setLayout(new GridLayout(13, 1));
        SavePaymentPanelEast.setLayout(new GridLayout(13, 1));


        //Adding the components to the panels:
        //Panel North:
        SavePaymentPanelNorth.add(Filler5);
        SavePaymentPanelNorth.add(lblHeading);

        //Panel West:
        SavePaymentPanelWest.add(Filler1);

        //Panel Center:
        SavePaymentPanelCenter.add(lblPaymentID);
        SavePaymentPanelCenter.add(txtPaymentID);

        SavePaymentPanelCenter.add(lblCustomerID);
        SavePaymentPanelCenter.add(txtCustomerID);

        SavePaymentPanelCenter.add(lblPaymentType);
        SavePaymentPanelCenter.add(txtPaymentType);

        SavePaymentPanelCenter.add(lblAmount);
        SavePaymentPanelCenter.add(txtAmount);


        SavePaymentPanelCenter.add(Filler4);


        //Panel East
        SavePaymentPanelEast.add(Filler2);

        //Panel South:
        SavePaymentPanelSouth.add(btnSave);
        SavePaymentPanelSouth.add(btnClear);
        SavePaymentPanelSouth.add(btnReturn);


        //Heading
        lblHeading.setFont(headingFont);

        //Adding panels to Payment Frame:
        SavePaymentFrame.add(SavePaymentPanelNorth, BorderLayout.NORTH);
        SavePaymentFrame.add(SavePaymentPanelSouth, BorderLayout.SOUTH);
        SavePaymentFrame.add(SavePaymentPanelEast, BorderLayout.EAST);
        SavePaymentFrame.add(SavePaymentPanelCenter, BorderLayout.CENTER);
        SavePaymentFrame.add(SavePaymentPanelWest, BorderLayout.WEST);


        //Telling compiler to listen for actions from the buttons:
        btnSave.addActionListener(this);
        btnClear.addActionListener(this);
        btnReturn.addActionListener(this);

        //Set GUI:
        SavePaymentFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        SavePaymentFrame.pack();
        SavePaymentFrame.setSize(600, 400);
        SavePaymentFrame.setLocationRelativeTo(null);
        SavePaymentFrame.setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {

        //When Save Button is clicked
        if (e.getActionCommand().equals("Save")) {

            //Store textfield text in string
            String PaymentID = txtPaymentID.getText();
            String CustomerID = txtCustomerID.getText();
            String PaymentType = txtPaymentType.getText();
            String Amount = txtAmount.getText();


            //booleans for checking valid input
            boolean PaymentTypeCheck, AmountCheck;

            if(!PaymentType.matches("[a-zA-Z0-9]+")){
                PaymentTypeCheck = false;
                txtPaymentType.setText("Invalid  Input");
            }
            else{
                PaymentTypeCheck = true;
            }

            if(!Amount.matches("[a-zA-Z0-9]+")){
                AmountCheck = false;
                txtAmount.setText("Invalid  Input");
            }
            else{
                AmountCheck = true;
            }

            //If all are valid then call save httpmethod
            if(PaymentTypeCheck && AmountCheck ) {
                httpsmethodsPayment httpsmethodsPayment = new httpsmethodsPayment();
                httpsmethodsPayment.savePayment(CustomerID, PaymentID, PaymentType, Amount);
                txtPaymentID.setText("");
                txtCustomerID.setText("");
                txtPaymentType.setText("");
                txtAmount.setText("");

            }
        }

        //When clear button is clicked
        if(e.getActionCommand().equals("Clear")){
            txtPaymentID.setText("");
            txtCustomerID.setText("");
            txtPaymentType.setText("");
            txtAmount.setText("");


        }

        //When exit button is clicked
        if(e.getActionCommand().equals("Return")){
            SavePaymentFrame.dispose();
        }

    }

}
