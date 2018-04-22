/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;
//
import Modèle.Connexion;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author karimrafrafi
 */
public class ModiFen extends JFrame implements ActionListener {
    private final Connexion connexion;
    private Panel menu;
    private JButton ajoute,modifie,supprime;
    private JPanel pan,resultat;
    
    
    public ModiFen(Connexion connexion){
        //Appel du constructeur hérité
        super("Modification de la base de donnée");
        this.setSize(1200, 800);
        //récupère connexion de la fen principale
        this.connexion = connexion;
        this.menu = new Panel();
        this.pan= new JPanel();
        this.resultat= new JPanel();
        
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
    
    
    public ArrayList affichFull(String table){
           ArrayList arrayL = new ArrayList();
            try {
                arrayL= connexion.remplirChampsRequete("SELECT * FROM "+table);
            } catch (SQLException e) {
                System.out.println("Erreur SQL");
            }
            return arrayL;
    }
    public void addAtt(String requete){
        try {
            connexion.executeUpdate(requete);
        } catch (Exception exc) {
            System.out.println("Erreur SQL");
            exc.printStackTrace();
        }
    }
    
     //ajout des resultats au pan de resultats 
    public void result(ArrayList l){
        String str="";
        for(int i=0;i<l.size();i++){
            str = l.get(i).toString();
            resultat.add(new JLabel(str));
            str= "";
        }
            
    }
    
    
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        int index = menu.getSelectedIndex();
        
        if (source == ajoute){
            String requete="";
            ArrayList<String> list = new ArrayList<String>();
            switch(index){
                case 0: //Service
                    int nb;
                    String ser0 = menu.txt_service.get(0).getText().trim();
                    String ser1 = menu.txt_service.get(1).getText().trim();
                    String ser2 = menu.txt_service.get(2).getText().trim();
                    String ser3 = menu.txt_service.get(3).getText().trim();
                    
                    if(ser0.compareTo("")==0 | ser1.compareTo("")==0 | ser2.compareTo("")==0 | ser3.compareTo("")==0){ // si il manque une saisie
                        resultat.removeAll();
                        System.out.println("Remplir tout les champs !");
                    }
                    else{
                        nb = Integer.parseInt(menu.txt_service.get(3).getText().trim());
                        resultat.removeAll();
                        resultat.setLayout(new GridLayout(0,2));
                        requete = "INSERT INTO service (code, nom, batiment, directeur) VALUES ('"+ser0+"', '"+ser1+"', '"+ser2+"', '"+ser3+"')";
                        addAtt(requete);
                        list = affichFull("service");
                        resultat.removeAll();
                        resultat.setLayout(new GridLayout(0,2));
                        this.result(list);
                        }
                break;
                    
                case 1: //Chambre
                    int nb1,nb2,nb3;
                    String cha0 = menu.txt_chambre.get(0).getText().trim();
                    String cha1 = menu.txt_chambre.get(1).getText().trim();
                    String cha2 = menu.txt_chambre.get(2).getText().trim();
                    String cha3 = menu.txt_chambre.get(3).getText().trim();
                    
                    if(cha0.compareTo("")!=0 | cha1.compareTo("")!=0 | cha2.compareTo("")!=0 | cha3.compareTo("")!=0){ // si il manque une saisie
                        resultat.removeAll();
                        System.out.println("Remplir tout les champs !");
                    }
                    else{
                        
                            nb1 = Integer.parseInt(menu.txt_chambre.get(1).getText().trim());
                            nb2 = Integer.parseInt(menu.txt_chambre.get(2).getText().trim());
                            nb3 = Integer.parseInt(menu.txt_chambre.get(3).getText().trim());
                            resultat.removeAll();
                            resultat.setLayout(new GridLayout(0,2));
                            requete = "INSERT INTO chambre (code_service,no_chambre,surveillant,nb_lits) VALUES ('"+cha0+"','"+cha1+"','"+cha2+"','"+cha3+"')";
                            
                    try {
                        list=connexion.remplirChampsRequete(requete);
                    } catch (SQLException exc) {
                           System.out.println("Erreur SQL ");
                    }
                            
                        resultat.removeAll();
                        resultat.setLayout(new GridLayout(0,2));
                        this.result(list);
                    }
                    break;

                case 2: //Employe
                    String emp0 = menu.txt_employe.get(0).getText().trim();
                    String emp1 = menu.txt_employe.get(1).getText().trim();
                    String emp2 = menu.txt_employe.get(2).getText().trim();
                    String emp3 = menu.txt_employe.get(3).getText().trim();
                    String emp4 = menu.txt_employe.get(4).getText().trim();
                    
                    if(emp0.compareTo("")!=0 | emp1.compareTo("")!=0 | emp2.compareTo("")!=0 | emp3.compareTo("")!=0 | emp4.compareTo("")!=0){ // si aucune saisie 
                        resultat.removeAll();
                        System.out.println("Remplir tout les champs !");
                    }
                    else{
                        
                            nb = Integer.parseInt(menu.txt_employe.get(0).getText().trim());
                            resultat.removeAll();
                            resultat.setLayout(new GridLayout(0,2));
                            requete = "INSERT INTO malade (numero,nom,prenom,adresse,tel) VALUES ('"+emp0+"','"+emp1+"','"+emp2+"','"+emp3+"','"+emp4+"')";
                            
                    try {
                        list=connexion.remplirChampsRequete(requete);
                    } catch (SQLException exc) {
                           System.out.println("Erreur SQL 6");
                    }
                            
                        resultat.removeAll();
                        resultat.setLayout(new GridLayout(0,2));
                        this.result(list);
                    }
                    break;
                    
                case 3: //Docteur
                    
                case 4: //Infirmier
                    
                case 5: //Malade
                    
                case 6: //Hospitalisation
                    
                case 7: //Soin
                        
            }
                   
            
        }
        else if (source == modifie){
            
        }
        else if (source == supprime){
            
        }
    }
    
}
