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
import java.util.Set;

public class FindAllPaymentsGUI implements ActionListener {
    //Initializing Components
    private JFrame GetAllFrame;
    private JPanel GetAllPanelNorth, GetAllPanelEast, GetAllPanelWest, GetAllPanelSouth, GetAllPanelCenter;
    private JTextArea PaymentTextArea;
    private JLabel lblHeading;
    private JButton btnFindAll, btnClear, btnReturn;
    private JLabel Filler1, Filler2, Filler3, Filler4, Filler5;
    private Font headingFont, textAreaFont;
    private JScrollPane scrollPane;



    public FindAllPaymentsGUI(){
        //Font
        headingFont = new Font("Arial", Font.BOLD, 18);

        GetAllFrame = new JFrame("Payment");

        //Panels
        GetAllPanelSouth = new JPanel();
        GetAllPanelNorth = new JPanel();
        GetAllPanelNorth.setBackground(Color.LIGHT_GRAY);
        GetAllPanelCenter = new JPanel();
        GetAllPanelCenter.setBackground(Color.LIGHT_GRAY);

        //TextArea
        PaymentTextArea = new JTextArea(50, 40);
        PaymentTextArea.setBackground(Color.white);
        PaymentTextArea.setLineWrap(true);
        PaymentTextArea.setWrapStyleWord(true);


        //Fillers:
        Filler1 = new JLabel("===========");
        Filler2 = new JLabel("===========");
        Filler3 = new JLabel("================================");
        Filler4 = new JLabel("================================");
        Filler5 = new JLabel("================================");
        Filler1.setForeground(Color.LIGHT_GRAY);
        Filler2.setForeground(Color.LIGHT_GRAY);
        Filler3.setForeground(Color.LIGHT_GRAY);
        Filler4.setForeground(Color.LIGHT_GRAY);
        Filler5.setForeground(Color.LIGHT_GRAY);

        //Heading
        lblHeading = new JLabel("View All Payments",JLabel.CENTER);

        //Buttons
        btnFindAll = new JButton("View All Payments");
        btnClear = new JButton("Clear");
        btnReturn = new JButton("Return");

    }



    //Setting GUI Layout
    public void setGUI() {
        GetAllPanelNorth.setLayout(new GridLayout(3, 1));

        //Adding the components to the panels:
        //Panel North:
        GetAllPanelNorth.add(Filler5);
        GetAllPanelNorth.add(lblHeading);
        GetAllPanelNorth.add(btnFindAll);

        //Panel Center
        GetAllPanelCenter.add(PaymentTextArea);

        //Panel South
        GetAllPanelSouth.add(btnClear);
        GetAllPanelSouth.add(btnReturn);

        //Adding panels to Customer Frame:
        GetAllFrame.add(GetAllPanelSouth, BorderLayout.SOUTH);
        GetAllFrame.add(GetAllPanelNorth, BorderLayout.NORTH);
        GetAllFrame.add(GetAllPanelCenter, BorderLayout.CENTER);

        //Telling compiler to listen for actions from the buttons:
        btnReturn.addActionListener(this);
        btnClear.addActionListener(this);
        btnReturn.addActionListener(this);

        //Set GUI:
        GetAllFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        GetAllFrame.pack();
        GetAllFrame.setSize(400, 500);
        GetAllFrame.setLocationRelativeTo(null);
        GetAllFrame.setVisible(true);


    }



    @Override
    public void actionPerformed(ActionEvent e) {

        //When Display all button is clicked
        if(e.getActionCommand().equals("View All Payments")){

            httpsmethodsPayment httpsmethodsPayment = new httpsmethodsPayment();

            //Create set to store method output
            Set<Payments> payments = httpsmethodsPayment.getPayments(); // change backend

            //Display set in text area
            PaymentTextArea.setText(String.valueOf(payments));
        }

        //When clear button is clicked
        if(e.getActionCommand().equals("Clear")){
            PaymentTextArea.setText("");
        }

        //When exit button is clicked
        if(e.getActionCommand().equals("Return")){
            GetAllFrame.dispose();
        }


    }
}

