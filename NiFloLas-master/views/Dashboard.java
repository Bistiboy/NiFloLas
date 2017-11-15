
package views;

import domain.*;

import service.*;


import javax.swing.*;
import java.awt.*;
import views.AddEmploye;
import static javax.swing.SwingUtilities.invokeLater;


public class Dashboard {
    private JPanel panelAdd;
    private JPanel panelView;
    private JPanel panelMain = new JPanel();
    private JFrame frame;

    public Dashboard(JFrame frame){
        this.frame = frame;

    }




    public static void main(String[] args){
        invokeLater(Dashboard::window);
    }


    public static void window() {
        Dashboard app = new Dashboard(new JFrame("Programme Java"));
        app.run(new AddEmploye(), new Affichage());
    }





    public void run(AddEmploye addEmploye, Affichage affichage){
        Personnel personnel = new Personnel();

        personnel.ajouterEmploye(new Vendeur("Florian","Taurand",2,"2016",12));
        personnel.ajouterEmploye(new Vendeur("Florian","Taurand2",2,"2016",12));
        personnel.ajouterEmploye(new Vendeur("Florian","Taurand3",2,"2016",12));

        //addEmploye.run();
        affichage.run(this.frame, personnel);
        addEmploye.run(this.frame, personnel);








        JButton buttonAdd = new JButton("Ajouter des employÃ©es");
        buttonAdd.addActionListener(e -> addEmploye.refreshPageAdd());
        //buttonAdd.addActionListener(e -> new Affichage(this.frame, AddEmploye));

        JButton buttonView = new JButton("Voir les employÃ©es");
        buttonView.addActionListener(e -> affichage.refreshPage()); // bouton pour afficher la liste

        this.panelMain.setLayout(new FlowLayout());
        this.panelMain.add(buttonAdd);
        this.panelMain.add(buttonView);

        affichage.panelDashboard = this.panelMain;
        addEmploye.panelDashboard = this.panelMain;


        //panelDashboard.add(buttonAdd, BorderLayout.CENTER);
        //panelDashboard.add(buttonView, BorderLayout.CENTER);


        //frame.getContentPane().add(panelDashboard);


        //frame.pack();
        this.frame.setSize(800, 500);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.frame.setLocation(dim.width/2 - this.frame.getWidth()/2, dim.height/2 - this.frame.getHeight()/2);
        this.frame.setVisible(true);

        this.frame.getContentPane().removeAll();
        this.frame.getContentPane().add(this.panelMain);
        this.frame.revalidate();
        this.frame.repaint();

    }



    private static void run2(){
        JFrame frame = new JFrame("Tableau");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTable table = new JTable(new Object[][]{
                {"Nom","Valeur 1"},
                {"PrÃ©nom", "Valeur 2"},
                {"Age", "Valeur 3"},
                {"Date d'entrÃ©e", "Valeur 4"},
                {"Type", "Valeur 5"},
                {"Salaire", "Valeur 6"}
        }, new String[]{"Informations", "Valeurs"});

        frame.getContentPane().setLayout(new FlowLayout());
        frame.getContentPane().add(new JScrollPane(table));

        frame.pack();
        frame.setVisible(true);
    }
}
