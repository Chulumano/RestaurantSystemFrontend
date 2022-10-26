package za.ac.cput.gui.Chulu.Payment;

/*
 *  ADP Entity for Payments
 *  Author: Chulumanco Buhle Nkwindana (219390983)
 * */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaymentMenuGUI implements ActionListener {



    //Initializing Components
    private JFrame MenuFrame;
    private JPanel panelNorth, panelSouth, panelEast, panelWest, panelCenter;
    private JLabel lblHeading;
    private JButton btnAddPayment, btnDeletePayment, btnViewPayment, btnUpdatePayment, btnViewAllPayments, btnReturn;
    private JLabel Filler1, Filler2, Filler3, Filler4, Filler5;
    private Font headingFont;
    Color btnColor = Color.WHITE;


    //Setting Up GUI Components
    public PaymentMenuGUI() {
        //Font
        headingFont = new Font("Arial", Font.BOLD, 18);

        //Panels
        MenuFrame = new JFrame("Payment ");
        panelNorth = new JPanel();
        panelSouth = new JPanel();
        panelEast = new JPanel();
        panelWest = new JPanel();
        panelCenter = new JPanel();
        panelNorth.setBackground(Color.LIGHT_GRAY);
        panelEast.setBackground(Color.LIGHT_GRAY);
        panelSouth.setBackground(Color.LIGHT_GRAY);
        panelWest.setBackground(Color.LIGHT_GRAY);
        panelCenter.setBackground(Color.LIGHT_GRAY);

        //Heading
        lblHeading = new JLabel("Payment Interface", JLabel.CENTER);

        //Fillers:
        Filler1 = new JLabel("=====");
        Filler1.setForeground(Color.LIGHT_GRAY);
        Filler2 = new JLabel("=====");
        Filler2.setForeground(Color.LIGHT_GRAY);
        Filler3 = new JLabel("================================");
        Filler3.setForeground(Color.LIGHT_GRAY);
        Filler4 = new JLabel("================================");
        Filler4.setForeground(Color.LIGHT_GRAY);
        Filler5 = new JLabel("================================");
        Filler5.setForeground(Color.LIGHT_GRAY);

        //Buttons:
        btnAddPayment = new JButton("Add Payment");
        btnAddPayment.setBackground(btnColor);

        btnViewPayment = new JButton("View Payment");
        btnViewPayment.setBackground(btnColor);

        btnUpdatePayment = new JButton("Update Payment");
        btnUpdatePayment = new JButton("Update Payment");
        btnUpdatePayment.setBackground(btnColor);

        btnDeletePayment = new JButton("Delete Payment Record");
        btnDeletePayment.setBackground(btnColor);

        btnViewAllPayments = new JButton("View All Payments");
        btnViewAllPayments.setBackground(btnColor);

        btnReturn = new JButton("Return");
        btnReturn.setBackground(btnColor);

    }

    //Setting GUI Layout
    public void setGUI() {
        //Panel Grids
        panelNorth.setLayout(new GridLayout(2, 1));
        panelEast.setLayout(new GridLayout(5, 1));
        panelSouth.setLayout(new GridLayout(1, 3));
        panelWest.setLayout(new GridLayout(5, 1));
        panelCenter.setLayout(new GridLayout(7, 1));

        //Adding the components to the panels:
        //Panel North:
        panelNorth.add(Filler5);
        panelNorth.add(lblHeading);

        //Panel West:
        panelWest.add(Filler1);

        //Panel Center:
        panelCenter.add(Filler3);
        panelCenter.add(btnAddPayment);
        panelCenter.add(btnViewPayment);
        panelCenter.add(btnUpdatePayment);
        panelCenter.add(btnDeletePayment);
        panelCenter.add(btnViewAllPayments);
        panelCenter.add(Filler4);

        //Panel East
        panelEast.add(Filler2);

        //Panel South:
        panelSouth.add(btnReturn);


        //Heading
        lblHeading.setFont(headingFont);

        //Adding panels to Payment Frame:
        MenuFrame.add(panelNorth, BorderLayout.NORTH);
        MenuFrame.add(panelSouth, BorderLayout.SOUTH);
        MenuFrame.add(panelEast, BorderLayout.EAST);
        MenuFrame.add(panelCenter, BorderLayout.CENTER);
        MenuFrame.add(panelWest, BorderLayout.WEST);

        //Telling compiler to listen for actions from the buttons:
        btnAddPayment.addActionListener(this);
        btnViewPayment.addActionListener(this);
        btnUpdatePayment.addActionListener(this);
        btnDeletePayment.addActionListener(this);
        btnViewPayment.addActionListener(this);
        btnReturn.addActionListener(this);

        //Set GUI:
        MenuFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        MenuFrame.pack();
        MenuFrame.setSize(350, 400);
        MenuFrame.setLocationRelativeTo(null);
        MenuFrame.setVisible(true);

    }




    @Override
    public void actionPerformed(ActionEvent e) {

        //When Add Payment Button is clicked
        if(e.getActionCommand().equals("Add Payment")){
            //Call AddPaymentGui
            AddPaymentGui addItemGUI = new AddPaymentGui();
            addItemGUI.setGUI();
        }


        if(e.getActionCommand().equals("View Payment")){
            //Call ViewPaymentGUI
            ReadPaymentGUI readPaymentGUI = new ReadPaymentGUI();
            readPaymentGUI.setGUI();
        }

        //When Update Payment Button is clicked
        if(e.getActionCommand().equals("Update Payment")){
            //Call UpdatePaymentGui
            UpdatePaymentGUI updatePaymentGUI = new UpdatePaymentGUI();
            updatePaymentGUI.setGUI();
        }

        //When Update Payment Button is clicked
        if(e.getActionCommand().equals("Delete Payment Record")){
            //Call DeletePaymentGui
            DeletePaymentGUI deletePaymentGUI = new DeletePaymentGUI();
            deletePaymentGUI.setGUI();
        }

        //When Update Payment Button is clicked
        if(e.getActionCommand().equals("Delete Payment Record")){
            //Call FindAllPaymentGui
            FindAllPaymentsGUI findAllPaymentsGUI= new FindAllPaymentsGUI();
            findAllPaymentsGUI.setGUI();
        }

        if(e.getActionCommand().equals("Return")){
            MenuFrame.dispose();
        }
    }

}


