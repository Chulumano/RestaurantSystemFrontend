package za.ac.cput.gui.Chulu.Payment;
/*
 * ADP Entity for Payments
 *  Author: Chulumanco Buhle Nkwindana (219390983)
 * */

import za.ac.cput.domain.Payments;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReadPaymentGUI implements ActionListener {


    //Initializing Components
    private JFrame ReadItemFrame;
    private JPanel ReadItemPanelNorth, ReadItemPanelSouth, ReadItemPanelEast, ReadItemPanelWest, ReadItemPanelCenter;
    private JLabel lblHeading;
    private JLabel lblPaymentID, lblCustomerID, lblPaymentType, lblAmount;
    private JTextField txtPaymentID, txtCustomerID, txtPaymentType, txtAmount;
    private JButton btnRead, btnDelete, btnReturn, btnClear;
    private JLabel Filler1, Filler2, Filler3, Filler4, Filler5;
    private Font headingFont;


    //Setting Up GUI Components
    public ReadPaymentGUI() {
        //Font
        headingFont = new Font("Arial", Font.BOLD, 18);

        //Panels
        ReadItemFrame = new JFrame("Payment: ");
        ReadItemPanelNorth = new JPanel();
        ReadItemPanelSouth = new JPanel();
        ReadItemPanelEast = new JPanel();
        ReadItemPanelWest = new JPanel();
        ReadItemPanelCenter = new JPanel();
        ReadItemPanelNorth.setBackground(Color.LIGHT_GRAY);
        ReadItemPanelEast.setBackground(Color.LIGHT_GRAY);
        ReadItemPanelSouth.setBackground(Color.LIGHT_GRAY);
        ReadItemPanelWest.setBackground(Color.LIGHT_GRAY);
        ReadItemPanelCenter.setBackground(Color.LIGHT_GRAY);

        //Heading
        lblHeading = new JLabel("Enter Payment ID", JLabel.CENTER);

        //Labels
        lblPaymentID = new JLabel("PaymentID:");
        lblCustomerID = new JLabel("CustomerID:");
        lblPaymentType = new JLabel("PaymentType:");
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
        btnRead = new JButton("Read");
        btnDelete = new JButton("Delete");
        btnClear = new JButton("Clear");
        btnReturn = new JButton("Return");

    }


    //Setting GUI Layout
    public void setGUI() {
        //Panel Grids
        ReadItemPanelNorth.setLayout(new GridLayout(4, 1));
        ReadItemPanelEast.setLayout(new GridLayout(13, 1));
        ReadItemPanelSouth.setLayout(new GridLayout(1, 4));
        ReadItemPanelWest.setLayout(new GridLayout(13, 1));
        ReadItemPanelCenter.setLayout(new GridLayout(13, 1));
        ReadItemPanelEast.setLayout(new GridLayout(13, 1));

        //Adding the components to the panels:
        //Panel North:
        ReadItemPanelNorth.add(Filler5);
        ReadItemPanelNorth.add(lblHeading);
        ReadItemPanelNorth.add(txtPaymentID);

        //Panel West:
        ReadItemPanelWest.add(Filler1);

        //Panel Center:
        ReadItemPanelCenter.add(lblPaymentID);
        ReadItemPanelCenter.add(txtPaymentID);

        ReadItemPanelCenter.add(lblCustomerID);
        ReadItemPanelCenter.add(txtCustomerID);

        ReadItemPanelCenter.add(lblPaymentType);
        ReadItemPanelCenter.add(txtPaymentType);

        ReadItemPanelCenter.add(lblAmount);
        ReadItemPanelCenter.add(txtAmount);

        ReadItemPanelCenter.add(Filler4);

        //Panel East
        ReadItemPanelEast.add(Filler2);

        //Panel South:
        ReadItemPanelSouth.add(btnRead);
        ReadItemPanelSouth.add(btnDelete);
        ReadItemPanelSouth.add(btnClear);
        ReadItemPanelSouth.add(btnReturn);

        //Heading
        lblHeading.setFont(headingFont);

        //Adding panels to Payment Frame:
        ReadItemFrame.add(ReadItemPanelNorth, BorderLayout.NORTH);
        ReadItemFrame.add(ReadItemPanelSouth, BorderLayout.SOUTH);
        ReadItemFrame.add(ReadItemPanelEast, BorderLayout.EAST);
        ReadItemFrame.add(ReadItemPanelCenter, BorderLayout.CENTER);
        ReadItemFrame.add(ReadItemPanelWest, BorderLayout.WEST);

        //Telling compiler to listen for actions from the buttons:
        btnRead.addActionListener(this);
        btnDelete.addActionListener(this);
        btnClear.addActionListener(this);
        btnReturn.addActionListener(this);

        //Set GUI:
        ReadItemFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ReadItemFrame.pack();
        ReadItemFrame.setSize(400, 500);
        ReadItemFrame.setLocationRelativeTo(null);
        ReadItemFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //When Delete Button is clicked
        if(e.getActionCommand().equals("Read")){

            //Store textfield text in string
            String id = txtPaymentID.getText();
            httpsmethodsPayment httpsmethodsPayment = new httpsmethodsPayment();

            //Use String as parameter in http read method and assign result to a Item
            Payments pay = httpsmethodsPayment.findPayment(id);
            System.out.println(pay);

            //Item parameters are assigned to textfields
            txtPaymentID.setText(pay.getPaymentID());
            txtCustomerID.setText(pay.getCustomerID());
            txtPaymentType.setText(pay.getPaymentType());
            txtAmount.setText(pay.getAmount());


        }

        //When Delete Button is clicked
        if(e.getActionCommand().equals("Delete")){
            //Store textfield text in string
            String id = txtPaymentID.getText();
            httpsmethodsPayment httpsmethodsPayment = new httpsmethodsPayment();

            //Use String as parameter in http method
            httpsmethodsPayment.deletePayment(id);

            //Show message when successfully completed
            JOptionPane.showMessageDialog(null, "Payment Deleted");
            txtPaymentID.setText("");
            txtCustomerID.setText("");
            txtPaymentType.setText("");
            txtAmount.setText("");

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
            ReadItemFrame.dispose();
        }

    }
}

