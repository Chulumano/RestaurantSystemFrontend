package za.ac.cput.gui.Chulu.Payment;

/*
 * ADP  Entity for Payments
 *  Author: Chulumanco Buhle Nkwindana (219390983)
 * */

import za.ac.cput.domain.Payments;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdatePaymentGUI implements ActionListener {


    //Initializing Components
    private JFrame UpdateItemFrame;
    private JPanel UpdateItemPanelNorth, UpdateItemPanelSouth, UpdateItemPanelEast, UpdateItemPanelWest, UpdateItemPanelCenter;
    private JLabel lblHeading;
    private JLabel lblPaymentID, lblCustomerID, lblPaymentType, lblAmount;
    private JTextField txtPaymentID, txtCustomerID,txtPaymentType, txtAmount;
    private JButton btnUpdate, btnReturn, btnClear, btnGet;
    private JLabel Filler1, Filler2, Filler3, Filler4, Filler5;
    private Font headingFont;
    Payments payments;

    public UpdatePaymentGUI() {
        //Font
        headingFont = new Font("Arial", Font.BOLD, 18);

        //Panels
        UpdateItemFrame = new JFrame("Payment ");
        UpdateItemPanelNorth = new JPanel();
        UpdateItemPanelSouth = new JPanel();
        UpdateItemPanelEast = new JPanel();
        UpdateItemPanelWest = new JPanel();
        UpdateItemPanelCenter = new JPanel();
        UpdateItemPanelNorth.setBackground(Color.LIGHT_GRAY);
        UpdateItemPanelEast.setBackground(Color.LIGHT_GRAY);
        UpdateItemPanelSouth.setBackground(Color.LIGHT_GRAY);
        UpdateItemPanelWest.setBackground(Color.LIGHT_GRAY);
        UpdateItemPanelCenter.setBackground(Color.LIGHT_GRAY);

        //Heading
        lblHeading = new JLabel("Update Payment", JLabel.CENTER);



        //Labels
        lblPaymentID = new JLabel("PaymentID:");
        lblCustomerID = new JLabel("CustomerID:");
        lblPaymentType = new JLabel("Payment type:");
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
        Filler4 = new JLabel("============");
        Filler5 = new JLabel("============");
        Filler1.setForeground(Color.LIGHT_GRAY);
        Filler2.setForeground(Color.LIGHT_GRAY);
        Filler3.setForeground(Color.LIGHT_GRAY);
        Filler4.setForeground(Color.LIGHT_GRAY);
        Filler5.setForeground(Color.LIGHT_GRAY);

        //Buttons:
        btnUpdate = new JButton("Update");
        btnGet = new JButton("Get Info");
        btnClear = new JButton("Clear");
        btnReturn = new JButton("Return");


    }


    //Setting GUI Layout
    public void setGUI() {
        //Panel Grid Layout
        UpdateItemPanelNorth.setLayout(new GridLayout(2, 1));
        UpdateItemPanelEast.setLayout(new GridLayout(13, 1));
        UpdateItemPanelSouth.setLayout(new GridLayout(1, 4));
        UpdateItemPanelWest.setLayout(new GridLayout(13, 1));
        UpdateItemPanelCenter.setLayout(new GridLayout(13, 1));
        UpdateItemPanelEast.setLayout(new GridLayout(13, 1));

        //Adding the components to the panels:
        //Panel North:
        UpdateItemPanelNorth.add(Filler5);
        UpdateItemPanelNorth.add(lblHeading);

        //Panel West:
        UpdateItemPanelWest.add(Filler1);

        //Panel Center:
        UpdateItemPanelCenter.add(lblPaymentID);
        UpdateItemPanelCenter.add(txtPaymentID);

        UpdateItemPanelCenter.add(lblCustomerID);
        UpdateItemPanelCenter.add(txtCustomerID);

        UpdateItemPanelCenter.add(lblPaymentType);
        UpdateItemPanelCenter.add(txtPaymentType);

        UpdateItemPanelCenter.add(lblAmount);
        UpdateItemPanelCenter.add(txtAmount);


        UpdateItemPanelCenter.add(Filler4);

        //Panel East
        UpdateItemPanelEast.add(Filler2);

        //Panel South:
        UpdateItemPanelSouth.add(btnGet);
        UpdateItemPanelSouth.add(btnUpdate);
        UpdateItemPanelSouth.add(btnClear);
        UpdateItemPanelSouth.add(btnReturn);

        //Heading
        lblHeading.setFont(headingFont);

        //Adding panels to Payment Frame:
        UpdateItemFrame.add(UpdateItemPanelNorth, BorderLayout.NORTH);
        UpdateItemFrame.add(UpdateItemPanelSouth, BorderLayout.SOUTH);
        UpdateItemFrame.add(UpdateItemPanelEast, BorderLayout.EAST);
        UpdateItemFrame.add(UpdateItemPanelCenter, BorderLayout.CENTER);
        UpdateItemFrame.add(UpdateItemPanelWest, BorderLayout.WEST);

        //Telling compiler to listen for actions from the buttons:
        btnGet.addActionListener(this);
        btnUpdate.addActionListener(this);
        btnClear.addActionListener(this);
        btnReturn.addActionListener(this);

        //Set GUI:
        UpdateItemFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        UpdateItemFrame.pack();
        UpdateItemFrame.setSize(450, 500);
        UpdateItemFrame.setLocationRelativeTo(null);
        UpdateItemFrame.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getActionCommand().equals("Update")){
            httpsmethodsPayment httpsmethodsPayment = new httpsmethodsPayment();

            //Store textfield text in string
            String paymentID = txtPaymentID.getText();
            String customerID = txtCustomerID.getText();
            String paymentType = txtPaymentType.getText();
            String amount = txtAmount.getText();


            //Read method
            Payments pay = httpsmethodsPayment.findPayment(paymentID);

            //booleans for checking valid input
            boolean PaymentTypeCheck, AmountCheck;

            if(!paymentType.matches("[a-zA-Z0-9]+")){
                PaymentTypeCheck = false;
                txtPaymentType.setText("Invalid  Input");
            }
            else{
                PaymentTypeCheck = true;
            }

            if(!amount.matches("[a-zA-Z0-9]+")){
                AmountCheck = false;
                txtAmount.setText("Invalid  Input");
            }
            else{
                AmountCheck = true;
            }



            //If all are valid then call update httpmethod
            if(PaymentTypeCheck && AmountCheck ){

                payments = new Payments.Builder().copy(pay)
                        .setPaymentID(paymentID)
                        .setCustomerID(customerID)
                        .setPaymentType(paymentType)
                        .setAmount(amount)
                        .build();
                httpsmethodsPayment.updatePayment(payments);
                txtPaymentID.setText("");
                txtCustomerID.setText("");
                txtPaymentType.setText("");
                txtAmount.setText("");

                JOptionPane.showMessageDialog(null, "Payment Updated");
            }


        }

        //When Get Info Button is clicked
        if(e.getActionCommand().equals("Get Info")){
            boolean idCheck;

            //Use read method of readitemgui
            String id = txtPaymentID.getText();
            httpsmethodsPayment httpsmethodsPayment = new httpsmethodsPayment();
            Payments pay = httpsmethodsPayment.findPayment(id);
            txtPaymentType.setText(pay.getPaymentType());
            txtAmount.setText(pay.getAmount());

        }

        //When Clear Button is clicked
        if(e.getActionCommand().equals("Clear")){
            txtPaymentID.setText("");
            txtCustomerID.setText("");
            txtPaymentType.setText("");
            txtAmount.setText("");

        }

        //When Exit Button is clicked
        if(e.getActionCommand().equals("Return")){
            UpdateItemFrame.dispose();
        }

    }
}

