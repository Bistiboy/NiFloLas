package views;

import domain.*;

import service.*;


import javax.swing.*;
import java.awt.*;
import views.AddEmploye;

import static javax.swing.SwingUtilities.invokeLater;


public class Dashboard {
    public static void main(String[] args){
        invokeLater(Dashboard::window);
    }


    private static void window(){
        JFrame frame = new JFrame("Roger");
        Personnel personnel = new Personnel();
        personnel.ajouterEmploye(new Vendeur("Florian","Taurand",2,"2016",12));
        personnel.ajouterEmploye(new Vendeur("Florian","Taurand2",2,"2016",12));
        personnel.ajouterEmploye(new Vendeur("Florian","Taurand3",2,"2016",12));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panelDashboard = new JPanel();
        JPanel panelAdd = new JPanel();
        JPanel panelView = new JPanel();


        JButton buttonAdd = new JButton("Ajouter des employées");
        buttonAdd.addActionListener(e -> System.out.println("clicked"));

        JButton buttonView = new JButton("Voir les employées");
        buttonView.addActionListener(e -> new Affichage(frame, personnel)); // bouton pour afficher la liste

        frame.getContentPane().setLayout(new FlowLayout());
        frame.getContentPane().add(buttonAdd);
        frame.getContentPane().add(buttonView);


        panelDashboard.add(buttonAdd, BorderLayout.CENTER);
        panelDashboard.add(buttonView, BorderLayout.CENTER);


        frame.getContentPane().add(panelDashboard);


        //frame.pack();
        frame.setSize(800, 500);
        //frame.setUndecorated(true);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width/2 - frame.getWidth()/2, dim.height/2 - frame.getHeight()/2);
        frame.setVisible(true);
    }

    public static void run(){
        JFrame frame = new JFrame("Tableau");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTable table = new JTable(new Object[][]{
                {"Nom","Valeur 1"},
                {"Prénom", "Valeur 2"},
                {"Age", "Valeur 3"},
                {"Date d'entrée", "Valeur 4"},
                {"Type", "Valeur 5"},
                {"Salaire", "Valeur 6"}
        }, new String[]{"Informations", "Valeurs"});

        frame.getContentPane().setLayout(new FlowLayout());
        frame.getContentPane().add(new JScrollPane(table));

        frame.pack();
        frame.setVisible(true);
    }
}
