package views;

import service.Personnel;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class AddEmploye extends JPanel{
    public Personnel personnel;
    private JFrame gui;
    public JPanel panelDashboard;

    //constructeur de la vue


    public void refreshPageAdd(){
        this.gui.getContentPane().removeAll();
        this.gui.getContentPane().add(this);
        this.gui.revalidate();
        this.gui.repaint();
    }

    private void retour(ActionEvent actionEvent) {
        // gui.setContentPane();
    }

    public void run(JFrame gui, Personnel personnel) {
        this.personnel = personnel;
        this.gui = gui;


        JLabel title = new JLabel("Ajouter un employÃ©");
        JButton retourMenu = new JButton("Retour");

        retourMenu.addActionListener(e -> {
            this.gui.getContentPane().removeAll();
            this.gui.getContentPane().add(this.panelDashboard);
            this.gui.revalidate();
            this.gui.repaint();
        });


        this.add(title); //ajout du titre
        this.add(retourMenu); // bouton retour

    }
}
