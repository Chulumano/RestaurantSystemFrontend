package za.ac.cput.gui.Chulu.Table;

/*
 * ADP  Entity for Tables
 *  Author: Chulumanco Buhle Nkwindana (219390983)
 * */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TableMenuGUI implements ActionListener {

    //Initializing Components
    private JFrame MenuFrame;
    private JPanel panelNorth, panelSouth, panelEast, panelWest, panelCenter;
    private JLabel lblHeading;
    private JButton btnAddTable, btnDeleteTable, btnViewTable, btnUpdateTable, btnViewAllTables, btnReturn;
    private JLabel Filler1, Filler2, Filler3, Filler4, Filler5;
    private Font headingFont;
    Color btnColor = Color.WHITE;


    //Setting Up GUI Components
    public TableMenuGUI() {
        //Font
        headingFont = new Font("Arial", Font.BOLD, 18);

        //Panels
        MenuFrame = new JFrame("Table ");
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
        lblHeading = new JLabel("Table Interface", JLabel.CENTER);

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
        btnAddTable = new JButton("Add Table");
        btnAddTable.setBackground(btnColor);

        btnViewTable = new JButton("View Table");
        btnViewTable.setBackground(btnColor);

        btnUpdateTable = new JButton("Update Table");
        btnUpdateTable.setBackground(btnColor);

        btnDeleteTable = new JButton("Delete Table Record");
        btnDeleteTable.setBackground(btnColor);

        btnViewAllTables = new JButton("View All Tables");
        btnViewAllTables.setBackground(btnColor);

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
        panelCenter.add(btnAddTable);
        panelCenter.add(btnViewTable);
        panelCenter.add(btnUpdateTable);
        panelCenter.add(btnDeleteTable);
        panelCenter.add(btnViewAllTables);
        panelCenter.add(Filler4);

        //Panel East
        panelEast.add(Filler2);

        //Panel South:
        panelSouth.add(btnReturn);


        //Heading
        lblHeading.setFont(headingFont);

        //Adding panels to Table Frame:
        MenuFrame.add(panelNorth, BorderLayout.NORTH);
        MenuFrame.add(panelSouth, BorderLayout.SOUTH);
        MenuFrame.add(panelEast, BorderLayout.EAST);
        MenuFrame.add(panelCenter, BorderLayout.CENTER);
        MenuFrame.add(panelWest, BorderLayout.WEST);

        //Telling compiler to listen for actions from the buttons:
        btnAddTable.addActionListener(this);
        btnViewTable.addActionListener(this);
        btnUpdateTable.addActionListener(this);
        btnDeleteTable.addActionListener(this);
        btnViewTable.addActionListener(this);
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

        //When Add Table Button is clicked
        if(e.getActionCommand().equals("Add Table")){
            //Call AddTableGui
            AddTableGui addItemGUI = new AddTableGui();
            addItemGUI.setGUI();
        }


        if(e.getActionCommand().equals("View Table")){
            //Call ViewTableGUI
            ReadTableGUI readTableGUI = new ReadTableGUI();
            readTableGUI.setGUI();
        }

        //When Update Table Button is clicked
        if(e.getActionCommand().equals("Update Table")){
            //Call UpdateTableGui
            UpdateTableGUI updateTableGUI = new UpdateTableGUI();
            updateTableGUI.setGUI();
        }

        //When Update Table Button is clicked
        if(e.getActionCommand().equals("Delete Table Record")){
            //Call DeleteTableGui
            DeleteTableGUI deleteTableGUI = new DeleteTableGUI();
            deleteTableGUI.setGUI();
        }

        //When Update Table Button is clicked
        if(e.getActionCommand().equals("Delete Table Record")){
            //Call FindAllTablesGui
            FindAllTablesGUI findAllTablesGUI= new FindAllTablesGUI();
            findAllTablesGUI.setGUI();
        }

        if(e.getActionCommand().equals("Return")){
            MenuFrame.dispose();
        }
    }

}



