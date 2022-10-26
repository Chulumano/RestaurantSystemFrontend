package za.ac.cput.gui.Chulu.Table;
/*
 * ADP Entity for Tables
 *  Author: Chulumanco Buhle Nkwindana (219390983)
 * */

import za.ac.cput.domain.Tables;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteTableGUI implements ActionListener {

    //Initializing Components
    Tables tables;
    private JFrame DeleteTableFrame;
    private JPanel DeleteTablePanelNorth, DeleteTablePanelSouth, DeleteTablePanelEast, DeleteTablePanelWest, DeleteTablePanelCenter;
    private JLabel lblHeading, lblID;
    private JTextField txtTableID;
    private JButton btnDelete, btnReturn, btnClear;
    private JLabel Filler1, Filler2, Filler3, Filler4, Filler5;
    private Font headingFont;


    //Setting Up GUI Components
    public DeleteTableGUI() {
        //Font
        headingFont = new Font("Arial", Font.BOLD, 18);

        //Panels
        DeleteTableFrame = new JFrame("Table ");
        DeleteTablePanelNorth = new JPanel();
        DeleteTablePanelSouth = new JPanel();
        DeleteTablePanelEast = new JPanel();
        DeleteTablePanelWest = new JPanel();
        DeleteTablePanelCenter = new JPanel();

        DeleteTablePanelNorth.setBackground(Color.LIGHT_GRAY);
        DeleteTablePanelEast.setBackground(Color.LIGHT_GRAY);
        DeleteTablePanelSouth.setBackground(Color.LIGHT_GRAY);
        DeleteTablePanelWest.setBackground(Color.LIGHT_GRAY);
        DeleteTablePanelCenter.setBackground(Color.LIGHT_GRAY);

        //Heading
        lblHeading = new JLabel("Delete Table Record", JLabel.CENTER);

        //Labels
        lblID = new JLabel("Enter TableID:");

        //TextFields
        txtTableID = new JTextField();

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
        DeleteTablePanelNorth.setLayout(new GridLayout(2, 1));
        DeleteTablePanelEast.setLayout(new GridLayout(12, 1));
        DeleteTablePanelSouth.setLayout(new GridLayout(1, 3));
        DeleteTablePanelWest.setLayout(new GridLayout(12, 1));
        DeleteTablePanelCenter.setLayout(new GridLayout(12, 1));
        DeleteTablePanelEast.setLayout(new GridLayout(12, 1));

        //Adding the components to the panels:
        //Panel North:
        DeleteTablePanelNorth.add(Filler5);
        DeleteTablePanelNorth.add(lblHeading);

        //Panel West:
        DeleteTablePanelWest.add(Filler1);

        //Panel Center:
        DeleteTablePanelCenter.add(lblID);
        DeleteTablePanelCenter.add(txtTableID);
        DeleteTablePanelCenter.add(Filler4);

        //Panel East
        DeleteTablePanelEast.add(Filler2);

        //Panel South:
        DeleteTablePanelSouth.add(btnDelete);
        DeleteTablePanelSouth.add(btnClear);
        DeleteTablePanelSouth.add(btnReturn);

        //Heading
        lblHeading.setFont(headingFont);



        //Adding panels to Customer Frame:
        DeleteTableFrame.add(DeleteTablePanelNorth, BorderLayout.NORTH);
        DeleteTableFrame.add(DeleteTablePanelSouth, BorderLayout.SOUTH);
        DeleteTableFrame.add(DeleteTablePanelEast, BorderLayout.EAST);
        DeleteTableFrame.add(DeleteTablePanelCenter, BorderLayout.CENTER);
        DeleteTableFrame.add(DeleteTablePanelWest, BorderLayout.WEST);

        //Telling compiler to listen for actions from the buttons:
        btnDelete.addActionListener(this);
        btnClear.addActionListener(this);
        btnReturn.addActionListener(this);

        //Set GUI:
        DeleteTableFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        DeleteTableFrame.pack();
        DeleteTableFrame.setSize(400, 300);
        DeleteTableFrame.setLocationRelativeTo(null);
        DeleteTableFrame.setVisible(true);

    }



    @Override
    public void actionPerformed(ActionEvent e) {

        //When Delete Button is clicked
        if(e.getActionCommand().equals("Delete")){

            //Store textfield text in string
            String id = txtTableID.getText();
            httpsmethodsTable httpsmethodsTable = new httpsmethodsTable();

            //Use String as parameter in http method
            httpsmethodsTable.deleteTable(id);

            //Show message when successfully completed
            JOptionPane.showMessageDialog(null, "Table Deleted");
            txtTableID.setText("");
        }


        //When Clear Button is clicked
        if(e.getActionCommand().equals("Clear")){
            txtTableID.setText("");
        }

        //When Exit Button is clicked
        if(e.getActionCommand().equals("Return")){
            DeleteTableFrame.dispose();
        }

    }
}


