package views;

import domain.Employee;
import service.Personnel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionEvent;

public class Affichage extends JPanel{
    public Personnel personnel;
    private JFrame gui;

    //constructeur de la vue
    public Affichage(JFrame gui, Personnel personnel){
        this.personnel = personnel;
        this.gui = gui;
        printView();
    }

    public void printView(){

    JLabel title = new JLabel("Liste des employés");
    JButton retour = new JButton("Retour");

    retour.addActionListener(this::retour);
    String tableHeaders[] = {"Nom", "Prénom", "Age", "Date d'entrée", "Type", "Salaire"};

    DefaultTableModel tableModel = new DefaultTableModel(tableHeaders, 0);

    //récupération de chaque employés grace à getNumEmployee
    for(int i = 0; i < this.personnel.getNumEmployee(); i++) {

        Employee employee = personnel.getEmployees().get(i); // récupération de l'employé

        String nom = employee.getLastname(); //recuperation du nom
        String prenom = employee.getFirstname();
        String age = String.valueOf(employee.getAge());
        String date = employee.getEntryYear();
        String type = employee.getType();
        String salaire = String.valueOf(employee.calculerSalaire());

        Object[] data = {nom, prenom, age, date,type,salaire}; // ajout de l'employé dans un tableau
        tableModel.addRow(data); // ajout du tableau dans la JTable
    }

    //création de la jtable
    JTable listTable = new JTable(tableModel);

    listTable.setSize(500,150);

    this.add(title); //ajout du titre
    this.add(listTable); //ajout de la table
    this.add(retour); // bouton retour

    gui.setContentPane(this);
    gui.revalidate();
    }

    private void retour(ActionEvent actionEvent) {
       // gui.setContentPane();
    }
}
