package za.ac.cput.gui.Chulu.Table;

/*
 * ADP Entity for Tables
 *  Author: Chulumanco Buhle Nkwindana (219390983)
 * */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddTableGui implements ActionListener {

    //Initializing Components
    private JFrame SaveTableFrame;
    private JPanel SaveTablePanelNorth, SaveTablePanelSouth, SaveTablePanelEast, SaveTablePanelWest, SaveTablePanelCenter;
    private JLabel lblHeading;

    private JLabel lblTableID, lblTableStatus, lblCapacity, lblTableType ;
    private JTextField txtTableID, txtTableStatus, txtCapacity, txtTableType ;

    private JButton btnSave, btnReturn, btnClear;
    private JLabel Filler1, Filler2, Filler3, Filler4, Filler5;
    private Font headingFont;


    //Setting Up GUI Components
    public AddTableGui() {
        //Font
        headingFont = new Font("Arial", Font.BOLD, 18);

        //Panels
        SaveTableFrame = new JFrame("Table ");
        SaveTablePanelNorth = new JPanel();
        SaveTablePanelSouth = new JPanel();
        SaveTablePanelEast = new JPanel();
        SaveTablePanelWest = new JPanel();
        SaveTablePanelCenter = new JPanel();

        SaveTablePanelNorth.setBackground(Color.LIGHT_GRAY);
        SaveTablePanelEast.setBackground(Color.LIGHT_GRAY);
        SaveTablePanelSouth.setBackground(Color.LIGHT_GRAY);
        SaveTablePanelWest.setBackground(Color.LIGHT_GRAY);
        SaveTablePanelCenter.setBackground(Color.LIGHT_GRAY);

        //Heading
        lblHeading = new JLabel("Add Table ", JLabel.CENTER);

        //Labels
        lblTableID = new JLabel("TableID:");
        lblTableStatus = new JLabel("Table status:");
        lblCapacity= new JLabel("Table capacity:");
        lblTableType = new JLabel("Table type:");


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
        btnSave = new JButton("Save");
        btnClear = new JButton("Clear");
        btnReturn = new JButton("Return");

    }
    //Setting GUI Layout
    public void setGUI() {
        //Panel Grids
        SaveTablePanelNorth.setLayout(new GridLayout(4, 1));
        SaveTablePanelEast.setLayout(new GridLayout(13, 1));
        SaveTablePanelSouth.setLayout(new GridLayout(1, 4));
        SaveTablePanelWest.setLayout(new GridLayout(13, 1));
        SaveTablePanelCenter.setLayout(new GridLayout(13, 1));
        SaveTablePanelEast.setLayout(new GridLayout(13, 1));


        //Adding the components to the panels:
        //Panel North:
        SaveTablePanelNorth.add(Filler5);
        SaveTablePanelNorth.add(lblHeading);

        //Panel West:
        SaveTablePanelWest.add(Filler1);

        //Panel Center:
        SaveTablePanelCenter.add(lblTableID);
        SaveTablePanelCenter.add(txtTableID);

        SaveTablePanelCenter.add(lblTableStatus);
        SaveTablePanelCenter.add(txtTableStatus);

        SaveTablePanelCenter.add(lblCapacity);
        SaveTablePanelCenter.add(txtCapacity);

        SaveTablePanelCenter.add(lblTableType);
        SaveTablePanelCenter.add(txtTableType);


        SaveTablePanelCenter.add(Filler4);


        //Panel East
        SaveTablePanelEast.add(Filler2);

        //Panel South:
        SaveTablePanelSouth.add(btnSave);
        SaveTablePanelSouth.add(btnClear);
        SaveTablePanelSouth.add(btnReturn);


        //Heading
        lblHeading.setFont(headingFont);

        //Adding panels to Payment Frame:
        SaveTableFrame.add(SaveTablePanelNorth, BorderLayout.NORTH);
        SaveTableFrame.add(SaveTablePanelSouth, BorderLayout.SOUTH);
        SaveTableFrame.add(SaveTablePanelEast, BorderLayout.EAST);
        SaveTableFrame.add(SaveTablePanelCenter, BorderLayout.CENTER);
        SaveTableFrame.add(SaveTablePanelWest, BorderLayout.WEST);


        //Telling compiler to listen for actions from the buttons:
        btnSave.addActionListener(this);
        btnClear.addActionListener(this);
        btnReturn.addActionListener(this);

        //Set GUI:
        SaveTableFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        SaveTableFrame.pack();
        SaveTableFrame.setSize(600, 400);
        SaveTableFrame.setLocationRelativeTo(null);
        SaveTableFrame.setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {

        //When Save Button is clicked
        if (e.getActionCommand().equals("Save")) {

            //Store textfield text in string
            String TableID = txtTableID.getText();
            String TableStatus = txtTableStatus.getText();
            String Capacity = txtCapacity.getText();
            String TableType = txtTableType.getText();


            //booleans for checking valid input
            boolean TableStatusCheck, TableTypeCheck;

            if(!TableStatus.matches("[a-zA-Z0-9]+")){
                TableStatusCheck = false;
                txtTableStatus.setText("Invalid  Input");
            }
            else{
                TableStatusCheck = true;
            }

            if(!TableType.matches("[a-zA-Z0-9]+")){
                TableTypeCheck = false;
                txtTableType.setText("Invalid  Input");
            }
            else{
                TableTypeCheck = true;
            }

            //If all are valid then call save httpmethod
            if(TableStatusCheck && TableTypeCheck ) {
                httpsmethodsTable httpsmethodsTable = new httpsmethodsTable();
                httpsmethodsTable.saveTable(TableID, TableStatus, Capacity, TableType);
                txtTableID.setText("");
                txtTableStatus.setText("");
                txtCapacity.setText("");
                txtTableType.setText("");

            }
        }

        //When clear button is clicked
        if(e.getActionCommand().equals("Clear")){
            txtTableID.setText("");
            txtTableStatus.setText("");
            txtCapacity.setText("");
            txtTableType.setText("");


        }

        //When exit button is clicked
        if(e.getActionCommand().equals("Return")){
            SaveTableFrame.dispose();
        }

    }

}


