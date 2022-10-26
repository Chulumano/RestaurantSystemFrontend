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

public class DeletePaymentGUI implements ActionListener {


    //Initializing Components
    Payments payments;
    private JFrame DeletePaymentFrame;
    private JPanel DeletePaymentPanelNorth, DeletePaymentPanelSouth, DeletePaymentPanelEast, DeletePaymentPanelWest, DeletePaymentPanelCenter;
    private JLabel lblHeading, lblID;
    private JTextField txtPaymentID;
    private JButton btnDelete, btnReturn, btnClear;
    private JLabel Filler1, Filler2, Filler3, Filler4, Filler5;
    private Font headingFont;


    //Setting Up GUI Components
    public DeletePaymentGUI() {
        //Font
        headingFont = new Font("Arial", Font.BOLD, 18);

        //Panels
        DeletePaymentFrame = new JFrame("Payment ");
        DeletePaymentPanelNorth = new JPanel();
        DeletePaymentPanelSouth = new JPanel();
        DeletePaymentPanelEast = new JPanel();
        DeletePaymentPanelWest = new JPanel();
        DeletePaymentPanelCenter = new JPanel();

        DeletePaymentPanelNorth.setBackground(Color.LIGHT_GRAY);
        DeletePaymentPanelEast.setBackground(Color.LIGHT_GRAY);
        DeletePaymentPanelSouth.setBackground(Color.LIGHT_GRAY);
        DeletePaymentPanelWest.setBackground(Color.LIGHT_GRAY);
        DeletePaymentPanelCenter.setBackground(Color.LIGHT_GRAY);

        //Heading
        lblHeading = new JLabel("Delete Payment Record", JLabel.CENTER);

        //Labels
        lblID = new JLabel("Enter PaymentID:");

        //TextFields
        txtPaymentID = new JTextField();

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
        btnDelete = new JButton("Delete");
        btnClear = new JButton("Clear");
        btnReturn = new JButton("Return");


    }


    //Setting GUI Layout
    public void setGUI() {
        //Panel Grids
        DeletePaymentPanelNorth.setLayout(new GridLayout(2, 1));
        DeletePaymentPanelEast.setLayout(new GridLayout(12, 1));
        DeletePaymentPanelSouth.setLayout(new GridLayout(1, 3));
        DeletePaymentPanelWest.setLayout(new GridLayout(12, 1));
        DeletePaymentPanelCenter.setLayout(new GridLayout(12, 1));
        DeletePaymentPanelEast.setLayout(new GridLayout(12, 1));

        //Adding the components to the panels:
        //Panel North:
        DeletePaymentPanelNorth.add(Filler5);
        DeletePaymentPanelNorth.add(lblHeading);

        //Panel West:
        DeletePaymentPanelWest.add(Filler1);

        //Panel Center:
        DeletePaymentPanelCenter.add(lblID);
        DeletePaymentPanelCenter.add(txtPaymentID);
        DeletePaymentPanelCenter.add(Filler4);

        //Panel East
        DeletePaymentPanelEast.add(Filler2);

        //Panel South:
        DeletePaymentPanelSouth.add(btnDelete);
        DeletePaymentPanelSouth.add(btnClear);
        DeletePaymentPanelSouth.add(btnReturn);

        //Heading
        lblHeading.setFont(headingFont);



        //Adding panels to Customer Frame:
        DeletePaymentFrame.add(DeletePaymentPanelNorth, BorderLayout.NORTH);
        DeletePaymentFrame.add(DeletePaymentPanelSouth, BorderLayout.SOUTH);
        DeletePaymentFrame.add(DeletePaymentPanelEast, BorderLayout.EAST);
        DeletePaymentFrame.add(DeletePaymentPanelCenter, BorderLayout.CENTER);
        DeletePaymentFrame.add(DeletePaymentPanelWest, BorderLayout.WEST);

        //Telling compiler to listen for actions from the buttons:
        btnDelete.addActionListener(this);
        btnClear.addActionListener(this);
        btnReturn.addActionListener(this);

        //Set GUI:
        DeletePaymentFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        DeletePaymentFrame.pack();
        DeletePaymentFrame.setSize(400, 300);
        DeletePaymentFrame.setLocationRelativeTo(null);
        DeletePaymentFrame.setVisible(true);

    }



    @Override
    public void actionPerformed(ActionEvent e) {

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
        }


        //When Clear Button is clicked
        if(e.getActionCommand().equals("Clear")){
            txtPaymentID.setText("");
        }

        //When Exit Button is clicked
        if(e.getActionCommand().equals("Return")){
            DeletePaymentFrame.dispose();
        }

    }
}

