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

public class UpdateTableGUI implements ActionListener {


    //Initializing Components
    private JFrame UpdateItemFrame;
    private JPanel UpdateItemPanelNorth, UpdateItemPanelSouth, UpdateItemPanelEast, UpdateItemPanelWest, UpdateItemPanelCenter;
    private JLabel lblHeading;
    private JLabel lblTableID, lblTableStatus, lblCapacity, lblTableType;
    private JTextField txtTableID, txtTableStatus,txtCapacity, txtTableType;
    private JButton btnUpdate, btnReturn, btnClear, btnGet;
    private JLabel Filler1, Filler2, Filler3, Filler4, Filler5;
    private Font headingFont;
    Tables tables;

    public UpdateTableGUI() {
        //Font
        headingFont = new Font("Arial", Font.BOLD, 18);

        //Panels
        UpdateItemFrame = new JFrame("Table ");
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
        lblHeading = new JLabel("Update Table", JLabel.CENTER);



        //Labels
        lblTableID = new JLabel("TableID:");
        lblTableStatus = new JLabel("Table status:");
        lblCapacity = new JLabel("Capacity:");
        lblTableType= new JLabel("Table type:");


        //TextFields
        txtTableID = new JTextField();
        txtTableStatus = new JTextField();
        txtCapacity = new JTextField();
        txtTableType = new JTextField();

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
        UpdateItemPanelCenter.add(lblTableID);
        UpdateItemPanelCenter.add(txtTableID);

        UpdateItemPanelCenter.add(lblTableStatus);
        UpdateItemPanelCenter.add(txtTableStatus);

        UpdateItemPanelCenter.add(lblCapacity);
        UpdateItemPanelCenter.add(txtCapacity);


        UpdateItemPanelCenter.add(lblTableType);
        UpdateItemPanelCenter.add(txtTableType);


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

        //Adding panels to Table Frame:
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
            httpsmethodsTable httpsmethodsTable = new httpsmethodsTable();

            //Store textfield text in string
            String tableID = txtTableID.getText();
            String tableStatus = txtTableStatus.getText();
            String capacity= txtCapacity.getText();
            String tableType = txtTableType.getText();


            //Read method
            Tables tab = httpsmethodsTable.findTable(tableID);

            //booleans for checking valid input
            boolean TableStatusCheck, TableTypeCheck;

            if(!tableStatus.matches("[a-zA-Z0-9]+")){
                TableStatusCheck = false;
                txtTableStatus.setText("Invalid  Input");
            }
            else{
                TableStatusCheck = true;
            }

            if(!tableType.matches("[a-zA-Z0-9]+")){
                TableTypeCheck = false;
                txtTableType.setText("Invalid  Input");
            }
            else{
                TableTypeCheck = true;
            }



            //If all are valid then call update httpmethod
            if(TableStatusCheck && TableTypeCheck ){

                tables= new Tables.Builder().copy(tab)
                        .setTableID(tableID)
                        .setTableStatus(tableStatus)
                        .setCapacity(capacity)
                        .setTableType(tableType)
                        .build();
                httpsmethodsTable.updateTable(tables);
                txtTableID.setText("");
                txtTableStatus.setText("");
                txtCapacity.setText("");
                txtTableType.setText("");

                JOptionPane.showMessageDialog(null, "Table Updated");
            }


        }

        //When Get Info Button is clicked
        if(e.getActionCommand().equals("Get Info")){
            boolean idCheck;

            //Use read method of readitemgui
            String id = txtTableID.getText();
            httpsmethodsTable httpsmethodsTable = new httpsmethodsTable();
            Tables tab = httpsmethodsTable.findTable(id);
            txtTableStatus.setText(tab.getTableStatus());
            txtCapacity.setText(tab.getCapacity());
            txtTableType.setText(tab.getCapacity());


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
            UpdateItemFrame.dispose();
        }

    }
}

