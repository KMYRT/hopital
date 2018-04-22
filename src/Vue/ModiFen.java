/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import Modèle.Connexion;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author karimrafrafi
 */
public class ModiFen extends JFrame implements ActionListener {
    private final Connexion connexion;
    private Panel menu;
    private JButton ajoute,modifie,supprime;
    private JPanel pan;
    
    
    public ModiFen(Connexion connexion){
        //Appel du constructeur hérité
        super("Modification de la base de donnée");
        this.setSize(1200, 800);
        //récupère connexion de la fen principale
        this.connexion = connexion;
        this.menu = new Panel();
        this.pan= new JPanel();
        
        this.setLayout(new BorderLayout());
        this.add(menu,BorderLayout.NORTH);
        
        //Boutons
        ajoute = new JButton("Ajouter");
        modifie = new JButton("Modifier");
        supprime = new JButton("Supprimer");
        
        pan.setLayout(new GridLayout(1,3));
        pan.add(ajoute);
        pan.add(modifie);
        pan.add(supprime);
        
        ajoute.addActionListener(this);
        modifie.addActionListener(this);
        supprime.addActionListener(this);
        
        this.add(pan,BorderLayout.SOUTH);
        setVisible(true);
        
        
    }
    
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == ajoute){
            
        }
        else if (source == modifie){
            
        }
        else if (source == supprime){
            
        }
    }
    
}
