package za.ac.cput.gui.Chulu.Table;
/*
 *  Entity for Tables
 *  Author: Chulumanco Buhle Nkwindana (219390983)
 * */

import za.ac.cput.domain.Tables;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReadTableGUI implements ActionListener {


    //Initializing Components
    private JFrame ReadItemFrame;
    private JPanel ReadItemPanelNorth, ReadItemPanelSouth, ReadItemPanelEast, ReadItemPanelWest, ReadItemPanelCenter;
    private JLabel lblHeading;
    private JLabel lblTableID, lblTableStatus, lblCapacity, lblTableType;
    private JTextField txtTableID, txtTableStatus, txtCapacity, txtTableType;
    private JButton btnRead, btnDelete, btnReturn, btnClear;
    private JLabel Filler1, Filler2, Filler3, Filler4, Filler5;
    private Font headingFont;


    //Setting Up GUI Components
    public ReadTableGUI() {
        //Font
        headingFont = new Font("Arial", Font.BOLD, 18);

        //Panels
        ReadItemFrame = new JFrame("Table: ");
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
        lblHeading = new JLabel("Enter Table ID", JLabel.CENTER);

        //Labels
        lblTableID = new JLabel("TableID:");
        lblTableStatus = new JLabel("Table status:");
        lblCapacity = new JLabel("Table capacity:");
        lblTableType= new JLabel("Table type");


        //TextFields
        txtTableID = new JTextField();
        txtTableStatus = new JTextField();
        txtCapacity = new JTextField();
        txtTableType = new JTextField();


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
        ReadItemPanelNorth.add(txtTableID);

        //Panel West:
        ReadItemPanelWest.add(Filler1);

        //Panel Center:
        ReadItemPanelCenter.add(lblTableID);
        ReadItemPanelCenter.add(txtTableID);

        ReadItemPanelCenter.add(lblTableStatus);
        ReadItemPanelCenter.add(txtTableStatus);

        ReadItemPanelCenter.add(lblCapacity);
        ReadItemPanelCenter.add(txtCapacity);

        ReadItemPanelCenter.add(lblTableType);
        ReadItemPanelCenter.add(txtTableType);

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

        //Adding panels to Table Frame:
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
            String id = txtTableID.getText();
            httpsmethodsTable httpsmethodsTable = new httpsmethodsTable();

            //Use String as parameter in http read method and assign result to a Item
            Tables tab = httpsmethodsTable.findTable(id);
            System.out.println(tab);

            //Item parameters are assigned to textfields
            txtTableID.setText(tab.getTableID());
            txtTableStatus.setText(tab.getTableStatus());
            txtCapacity.setText(tab.getCapacity());
            txtTableType.setText(tab.getTableType());


        }

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
            txtTableStatus.setText("");
            txtCapacity.setText("");
            txtTableType.setText("");

        }


        //When Clear Button is clicked
        if(e.getActionCommand().equals("Clear")){
            txtTableID.setText("");
            txtTableStatus.setText("");
            txtCapacity.setText("");
            txtTableType.setText("");

        }

        //When Exit Button is clicked
        if(e.getActionCommand().equals("Return")){
            ReadItemFrame.dispose();
        }

    }
}


