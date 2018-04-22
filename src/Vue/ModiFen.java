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
                    //int nb;
                    String ser0 = menu.txt_service.get(0).getText().trim();
                    String ser1 = menu.txt_service.get(1).getText().trim();
                    String ser2 = menu.txt_service.get(2).getText().trim();
                    String ser3 = menu.txt_service.get(3).getText().trim();
                    
                    if(ser0.compareTo("")==0 | ser1.compareTo("")==0 | ser2.compareTo("")==0 | ser3.compareTo("")==0){ // si il manque une saisie
                        resultat.removeAll();
                        System.out.println("Remplir tout les champs !");
                    }
                    else{
                        //nb= Integer.parseInt(menu.txt_service.get(3).getText().trim());
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
                    //int nb1,nb2,nb3;
                    String cha0 = menu.txt_chambre.get(0).getText().trim();
                    String cha1 = menu.txt_chambre.get(1).getText().trim();
                    String cha2 = menu.txt_chambre.get(2).getText().trim();
                    String cha3 = menu.txt_chambre.get(3).getText().trim();
                    
                    if(cha0.compareTo("")==0 | cha1.compareTo("")==0 | cha2.compareTo("")==0 | cha3.compareTo("")==0){ // si il manque une saisie
                        resultat.removeAll();
                        System.out.println("Remplir tout les champs !");
                    }
                    else{
                        //nb1 = Integer.parseInt(cha1);
                        //nb2 = Integer.parseInt(cha2);
                        //nb3 = Integer.parseInt(cha3);
                        resultat.removeAll();
                        resultat.setLayout(new GridLayout(0,2));
                        requete = "INSERT INTO chambre (code_service,no_chambre,surveillant,nb_lits) VALUES ('"+cha0+"','"+cha1+"','"+cha2+"','"+cha3+"')";
                        addAtt(requete);
                        list = affichFull("chambre");
                        resultat.removeAll();
                        resultat.setLayout(new GridLayout(0,2));
                        this.result(list);
                    }
                break;

                case 2: //Employe
                    //int nb0;
                    String emp0 = menu.txt_employe.get(0).getText().trim();
                    String emp1 = menu.txt_employe.get(1).getText().trim();
                    String emp2 = menu.txt_employe.get(2).getText().trim();
                    String emp3 = menu.txt_employe.get(3).getText().trim();
                    String emp4 = menu.txt_employe.get(4).getText().trim();
                    
                    if(emp0.compareTo("")==0 | emp1.compareTo("")==0 | emp2.compareTo("")==0 | emp3.compareTo("")==0 | emp4.compareTo("")==0){ // si aucune saisie 
                        resultat.removeAll();
                        System.out.println("Remplir tout les champs !");
                    }
                    else{
                        //nb0 = Integer.parseInt(emp0);
                        resultat.removeAll();
                        resultat.setLayout(new GridLayout(0,2));
                        requete = "INSERT INTO employe (numero,nom,prenom,adresse,tel) VALUES ('"+emp0+"','"+emp1+"','"+emp2+"','"+emp4+"','"+emp3+"')";
                        addAtt(requete);
                        list = affichFull("employe");
                        resultat.removeAll();
                        resultat.setLayout(new GridLayout(0,2));
                        this.result(list);
                    }
                    break;
                    
                case 3: //Docteur
                    
                    String doc0 = menu.txt_docteur.get(0).getText().trim();
                    String doc1 = menu.txt_docteur.get(1).getText().trim();
                    
                    if(doc0.compareTo("")==0 | doc1.compareTo("")==0){ // si aucune saisie 
                        resultat.removeAll();
                        System.out.println("Remplir tout les champs !");
                    }
                    else{
                        //nb0 = Integer.parseInt(emp0);
                        resultat.removeAll();
                        resultat.setLayout(new GridLayout(0,2));
                        requete = "INSERT INTO docteur (numero,specialite) VALUES ('"+doc0+"','"+doc1+"')";
                        addAtt(requete);
                        list = affichFull("docteur");
                        resultat.removeAll();
                        resultat.setLayout(new GridLayout(0,2));
                        this.result(list);
                    }
                    break;
                    
                    
                    
                case 4: //Infirmier
                    
                    String inf0 = menu.txt_infirmier.get(0).getText().trim();
                    String inf1 = menu.txt_infirmier.get(1).getText().trim();
                    String inf2 = menu.txt_infirmier.get(2).getText().trim();
                    String inf3 = menu.txt_infirmier.get(3).getText().trim();
                    
                    if(inf0.compareTo("")==0 | inf1.compareTo("")==0 | inf2.compareTo("")==0 | inf3.compareTo("")==0){ // si il manque une saisie
                        resultat.removeAll();
                        System.out.println("Remplir tout les champs !");
                    }
                    else{
                        //nb1 = Integer.parseInt(cha1);
                        //nb2 = Integer.parseInt(cha2);
                        //nb3 = Integer.parseInt(cha3);
                        resultat.removeAll();
                        resultat.setLayout(new GridLayout(0,2));
                        requete = "INSERT INTO infirmier (numero,code_service,rotation,salaire) VALUES ('"+inf0+"','"+inf1+"','"+inf2+"','"+inf3+"')";
                        addAtt(requete);
                        list = affichFull("infirmier");
                        resultat.removeAll();
                        resultat.setLayout(new GridLayout(0,2));
                        this.result(list);
                    }
                break;
                    
              
                    
                case 5: //Malade
                    
                    String mal0 = menu.txt_malade.get(0).getText().trim();
                    String mal1 = menu.txt_malade.get(1).getText().trim();
                    String mal2 = menu.txt_malade.get(2).getText().trim();
                    String mal3 = menu.txt_malade.get(3).getText().trim();
                    String mal4 = menu.txt_malade.get(4).getText().trim();
                    String mal5 = menu.txt_malade.get(5).getText().trim();
                   
                    
                    if(mal0.compareTo("")==0 | mal1.compareTo("")==0 | mal2.compareTo("")==0 | mal3.compareTo("")==0 | mal4.compareTo("")==0 | mal5.compareTo("")==0){ // si aucune saisie 
                        resultat.removeAll();
                        System.out.println("Remplir tout les champs !");
                    }
                    else{
                        //nb0 = Integer.parseInt(emp0);
                        resultat.removeAll();
                        resultat.setLayout(new GridLayout(0,2));
                        requete = "INSERT INTO malade (numero,nom,prenom,tel,adresse,mutuelle) VALUES ('"+mal0+"','"+mal1+"','"+mal2+"','"+mal3+"','"+mal4+"','"+mal5+"')";
                        addAtt(requete);
                        list = affichFull("malade");
                        resultat.removeAll();
                        resultat.setLayout(new GridLayout(0,2));
                        this.result(list);
                    }
                    break;
                    
                case 6: //Hospitalisation
                    
                    String hos0 = menu.txt_hospitalisation.get(0).getText().trim();
                    String hos1 = menu.txt_hospitalisation.get(1).getText().trim();
                    String hos2 = menu.txt_hospitalisation.get(2).getText().trim();
                    String hos3 = menu.txt_hospitalisation.get(3).getText().trim();
                    
                    if(hos0.compareTo("")==0 | hos1.compareTo("")==0 | hos2.compareTo("")==0 | hos3.compareTo("")==0){ // si il manque une saisie
                        resultat.removeAll();
                        System.out.println("Remplir tout les champs !");
                    }
                    else{
                        resultat.removeAll();
                        resultat.setLayout(new GridLayout(0,2));
                        requete = "INSERT INTO hospitalisation (no_malade,code_service,no_chambre,lit) VALUES ('"+hos0+"','"+hos1+"','"+hos2+"','"+hos3+"')";
                        addAtt(requete);
                        list = affichFull("hospitalisation");
                        resultat.removeAll();
                        resultat.setLayout(new GridLayout(0,2));
                        this.result(list);
                    }
                break;
                    
                case 7: //Soin
                    
                    String soi0 = menu.txt_soin.get(0).getText().trim();
                    String soi1 = menu.txt_soin.get(1).getText().trim();
                    
                    if(soi0.compareTo("")==0 | soi1.compareTo("")==0){ // si aucune saisie 
                        resultat.removeAll();
                        System.out.println("Remplir tout les champs !");
                    }
                    else{
                        //nb0 = Integer.parseInt(emp0);
                        resultat.removeAll();
                        resultat.setLayout(new GridLayout(0,2));
                        requete = "INSERT INTO soigne (no_docteur,no_malade) VALUES ('"+soi0+"','"+soi1+"')";
                        addAtt(requete);
                        list = affichFull("soigne");
                        resultat.removeAll();
                        resultat.setLayout(new GridLayout(0,2));
                        this.result(list);
                    }
                    break;
                        
            }
                   
            
        }
        else if (source == modifie){
            
        }
        else if (source == supprime){
            
        }
    }
    
}
