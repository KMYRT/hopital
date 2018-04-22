/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import Modèle.Connexion;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneLayout;

/**
 *
 * @author karimrafrafi
 */
public class RequAjout extends JFrame implements ActionListener{
    private Connexion connexion;
    private JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10;
    private JPanel pan, pan1, resultat;
    private JScrollPane scroll;
    
    RequAjout(Connexion connexion){
        super("Requêtes");
        this.connexion=connexion;
        
        //instanciation des objets graphiques
        b1 = new JButton("R1");
        b2 = new JButton("R2");
        b3 = new JButton("R3");
        b4 = new JButton("R4");
        b5 = new JButton("R5");
        b6 = new JButton("R6");
        b7 = new JButton("R7");
        b8 = new JButton("R8");
        b9 = new JButton("R9");
        b10 = new JButton("R10");
        
        pan = new JPanel(new GridLayout(0,10));
        pan1 = new JPanel(new BorderLayout());
        resultat = new JPanel();
        
        pan.add(b1);
        pan.add(b2);
        pan.add(b3);
        pan.add(b4);
        pan.add(b5);
        pan.add(b6);
        pan.add(b7);
        pan.add(b8);
        pan.add(b9);
        pan.add(b10);
        
        resultat.setBackground(Color.WHITE);
        scroll = new JScrollPane(resultat,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setLayout(new ScrollPaneLayout());
        scroll.setSize(new Dimension(200, 200));
        
        pan1.add(pan,BorderLayout.NORTH);
        pan1.add(resultat,BorderLayout.CENTER);
        
        //ajout des actionlistener
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        b9.addActionListener(this);
        b10.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        
        
        
        
    }

    
    
    

