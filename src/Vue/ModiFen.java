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
import javax.swing.JScrollPane;

/**
 *
 * @author karimrafrafi
 */
public class ModiFen extends JFrame implements ActionListener {
    private final Connexion connexion;
    private Panel menu;
    private JButton ajoute,modifie,supprime;
    private JPanel pan,pan1,resultat;
    private JScrollPane scroll;
    
    
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
    
    //ajoute un objet à la table avec tout ses attributs
    public void addObj(String requete){
        try {
            connexion.executeUpdate(requete);
        } catch (Exception exc) {
            System.out.println("Erreur SQL");
            exc.printStackTrace();
        }
    }
    
    //supprime l'objet selon les WHERE
    public void deleteObj(String table,String requete){
        try {
             connexion.executeUpdate("DELETE FROM " +table+ " WHERE " + requete);
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
                        addObj(requete);
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
                        addObj(requete);
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
                        addObj(requete);
                        list = affichFull("employe");
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
            boolean firstCondition = true;
            int nb=0;
            String requete;
            requete = "";
            ArrayList list = null;
            switch(index){
                case 0 :
                    String ser0 = menu.txt_service.get(0).getText().trim();
                    String ser1 = menu.txt_service.get(1).getText().trim();
                    String ser2 = menu.txt_service.get(2).getText().trim();
                    String ser3 = menu.txt_service.get(3).getText().trim();
                    
                    if(ser0.compareTo("")==0 && ser1.compareTo("")==0 && ser2.compareTo("")==0 && ser3.compareTo("")==0){
                        resultat.removeAll();
                        resultat.setLayout(new GridLayout(0,2));
                        list =affichFull("service"); //on appelle la fonction de base des requetes
                        this.result(list);
                    }
                    else{
                        if(ser0.compareTo("")!=0){
                            if(!firstCondition){
                                requete +=" AND ";
                            }
                            requete +="code="+ser0+"'";
                            firstCondition = false;
                            }
                        if(ser1.compareTo("")!=0){
                            if(!firstCondition){
                                requete +=" AND ";
                            }
                            requete +="nom="+ser1+"'";
                            firstCondition = false;
                            }
                        if(ser2.compareTo("")!=0){
                            if(!firstCondition){
                                requete +=" AND ";
                            }
                            requete +="batiment="+ser2+"'";
                            firstCondition = false;
                            }
                        if(ser3.compareTo("")!=0){
                            if(!firstCondition){
                                requete +=" AND ";
                            }
                            requete +="directeur="+ser3+"'";
                            firstCondition = false;
                            }
                        
                        resultat.removeAll();
                        resultat.setLayout(new GridLayout(0,2));
                        deleteObj("service",requete);
                        this.result(list);
                    }
                    break;
                    
                case 1 :
                    String cha0 = menu.txt_chambre.get(0).getText().trim();
                    String cha1 = menu.txt_chambre.get(1).getText().trim();
                    String cha2 = menu.txt_chambre.get(2).getText().trim();
                    String cha3 = menu.txt_chambre.get(3).getText().trim();
                    
                    if(cha0.compareTo("")==0 && cha1.compareTo("")==0 && cha2.compareTo("")==0 && cha3.compareTo("")==0){
                        resultat.removeAll();
                        resultat.setLayout(new GridLayout(0,2));
                        list =affichFull("chambre"); //on appelle la fonction de base des requetes
                        this.result(list);
                    }
                    else{
                        if(cha0.compareTo("")!=0){
                            nb = Integer.parseInt(menu.txt_chambre.get(0).getText().trim());
                            if(!firstCondition){
                                requete +=" AND ";
                            }
                            requete +="no_chambre="+nb;
                            firstCondition = false;
                            }
                        if(cha1.compareTo("")!=0){
                            if(!firstCondition){
                                requete +=" AND ";
                            }
                            requete +="code_service="+cha1+"'";
                            firstCondition = false;
                            }
                        if(cha2.compareTo("")!=0){
                            if(!firstCondition){
                                requete +=" AND ";
                            }
                            requete +="surveillant="+cha2+"'";
                            firstCondition = false;
                            }
                        if(cha3.compareTo("")!=0){
                            if(!firstCondition){
                                requete +=" AND ";
                            }
                            requete +="nb_lits="+cha3+"'";
                            firstCondition = false;
                            }
                        
                        resultat.removeAll();
                        resultat.setLayout(new GridLayout(0,2));
                        deleteObj("chambre",requete);
                        this.result(list);
                    }
                    break;
                
                case 2 :
                    String emp0 = menu.txt_employe.get(0).getText().trim();
                    String emp1 = menu.txt_employe.get(1).getText().trim();
                    String emp2 = menu.txt_employe.get(2).getText().trim();
                    String emp3 = menu.txt_employe.get(3).getText().trim();
                    String emp4 = menu.txt_employe.get(4).getText().trim();
                    
                    if(emp0.compareTo("")==0 && emp1.compareTo("")==0 && emp2.compareTo("")==0 && emp3.compareTo("")==0&& emp4.compareTo("")==0){ // si aucune saisie 
                        resultat.removeAll();
                        resultat.setLayout(new GridLayout(0,2));
                        list =affichFull("employe"); //on appelle la fonction de base des requetes
                        this.result(list);
                    }
                    else{
                        if(emp0.compareTo("")!=0){
                            nb = Integer.parseInt(menu.txt_employe.get(0).getText().trim());
                            if(!firstCondition){
                                requete +=" AND ";
                            }
                            requete +="numero="+nb;
                            firstCondition = false;
                            }
                        if(emp1.compareTo("")!=0){
                            if(!firstCondition){
                                requete +=" AND ";
                            }
                            requete +="nom='"+emp1+"'";
                            firstCondition = false;
                        }
                        if(emp2.compareTo("")!=0){
                            if(!firstCondition){
                                requete +=" AND ";
                            }
                            requete +="prenom='"+emp2+"'";
                            firstCondition = false;
                        }
                        if(emp3.compareTo("")!=0){
                            if(!firstCondition){
                                requete +=" AND ";
                            }
                            requete +="tel='"+emp3+"'";
                            firstCondition = false;
                        }
                        if(emp4.compareTo("")!=0){
                            if(!firstCondition){
                                requete +=" AND ";
                            }
                            requete +="adresse='"+emp4+"'";
                        }
                        
                        resultat.removeAll();
                        resultat.setLayout(new GridLayout(0,2));
                        deleteObj("employe",requete);
                        this.result(list);
                    }
                    break;
                    
                case 3:
                    String doc0 = menu.txt_docteur.get(0).getText().trim();
                    String doc1 = menu.txt_docteur.get(1).getText().trim();
                    
                    if(doc0.compareTo("")==0 && doc1.compareTo("")==0){ // si aucune saisie 
                        resultat.removeAll();
                        resultat.setLayout(new GridLayout(0,2));
                        list =affichFull("docteur"); //on appelle la fonction de base des requetes
                        this.result(list);
                    }
                    else{
                        if(doc0.compareTo("")!=0){
                            nb = Integer.parseInt(menu.txt_docteur.get(0).getText().trim());
                            if(!firstCondition){
                                requete +=" AND ";
                            }
                            requete +="numero="+nb;
                            firstCondition = false;
                            }
                        if(doc1.compareTo("")!=0){
                            if(!firstCondition){
                                requete +=" AND ";
                            }
                            requete +="specialite='"+doc1+"'";
                            firstCondition = false;
                        }
                        resultat.removeAll();
                        resultat.setLayout(new GridLayout(0,2));
                        deleteObj("docteur",requete);
                        this.result(list);
                    }
                    break;
                    
                case 4:
                    String inf0 = menu.txt_infirmier.get(0).getText().trim();
                    String inf1 = menu.txt_infirmier.get(1).getText().trim();
                    String inf2 = menu.txt_infirmier.get(2).getText().trim();
                    String inf3 = menu.txt_infirmier.get(3).getText().trim();
                    
                    if(inf0.compareTo("")==0 && inf1.compareTo("")==0 && inf2.compareTo("")==0 && inf3.compareTo("")==0){ // si aucune saisie 
                        resultat.removeAll();
                        resultat.setLayout(new GridLayout(0,2));
                        list =affichFull("infirmier"); //on appelle la fonction de base des requetes
                        this.result(list);
                    }
                    else{
                        if(inf0.compareTo("")!=0){
                            nb = Integer.parseInt(menu.txt_infirmier.get(0).getText().trim());
                            if(!firstCondition){
                                requete +=" AND ";
                            }
                            requete +="numero="+nb;
                            firstCondition = false;
                            }
                        if(inf1.compareTo("")!=0){
                            if(!firstCondition){
                                requete +=" AND ";
                            }
                            requete +="code_service='"+inf1+"'";
                            firstCondition = false;
                        }
                        if(inf2.compareTo("")!=0){
                            if(!firstCondition){
                                requete +=" AND ";
                            }
                            requete +="rotation='"+inf2+"'";
                            firstCondition = false;
                        }
                        if(inf3.compareTo("")!=0){
                            if(!firstCondition){
                                requete +=" AND ";
                            }
                            requete +="salaire='"+inf3+"'";
                            firstCondition = false;
                            }
                        resultat.removeAll();
                        resultat.setLayout(new GridLayout(0,2));
                        deleteObj("infirmier",requete); //Commentaire bidon
                        this.result(list);
                    }
                    break;
                
                case 5 :
                    String mal0 = menu.txt_malade.get(0).getText().trim();
                    String mal1 = menu.txt_malade.get(1).getText().trim();
                    String mal2 = menu.txt_malade.get(2).getText().trim();
                    String mal3 = menu.txt_malade.get(3).getText().trim();
                    String mal4 = menu.txt_malade.get(4).getText().trim();
                    String mal5 = menu.txt_malade.get(5).getText().trim();
                    
                    if(mal0.compareTo("")==0 && mal1.compareTo("")==0 && mal2.compareTo("")==0 && mal3.compareTo("")==0&& mal4.compareTo("")==0 && mal5.compareTo("")==0){ // si aucune saisie 
                        resultat.removeAll();
                        resultat.setLayout(new GridLayout(0,2));
                        list =affichFull("malade"); //on appelle la fonction de base des requetes
                        this.result(list);
                    }
                    else{
                        if(mal0.compareTo("")!=0){
                            nb = Integer.parseInt(menu.txt_malade.get(0).getText().trim());
                            if(!firstCondition){
                                requete +=" AND ";
                            }
                            requete +="numero="+nb;
                            firstCondition = false;
                            }
                        if(mal1.compareTo("")!=0){
                            if(!firstCondition){
                                requete +=" AND ";
                            }
                            requete +="nom='"+mal1+"'";
                            firstCondition = false;
                        }
                        if(mal2.compareTo("")!=0){
                            if(!firstCondition){
                                requete +=" AND ";
                            }
                            requete +="prenom='"+mal2+"'";
                            firstCondition = false;
                        }
                        if(mal3.compareTo("")!=0){
                            if(!firstCondition){
                                requete +=" AND ";
                            }
                            requete +="tel='"+mal3+"'";
                            firstCondition = false;
                        }
                        if(mal4.compareTo("")!=0){
                            if(!firstCondition){
                                requete +=" AND ";
                            }
                            requete +="adresse='"+mal4+"'";
                            firstCondition = false;
                        }
                        if(mal5.compareTo("")!=0){
                            if(!firstCondition){
                                requete +=" AND ";
                            }
                            requete +="mutuelle='"+mal5+"'";
                        }
                        resultat.removeAll();
                        resultat.setLayout(new GridLayout(0,2));
                        deleteObj("malade",requete);
                        this.result(list);
                    }
                    break;
                    
                case 6 :
                    String hos0 = menu.txt_hospitalisation.get(0).getText().trim();
                    String hos1 = menu.txt_hospitalisation.get(1).getText().trim();
                    String hos2 = menu.txt_hospitalisation.get(2).getText().trim();
                    String hos3 = menu.txt_hospitalisation.get(3).getText().trim();
                    
                    if(hos0.compareTo("")==0 && hos1.compareTo("")==0 && hos2.compareTo("")==0 && hos3.compareTo("")==0){
                        resultat.removeAll();
                        resultat.setLayout(new GridLayout(0,2));
                        list =affichFull("hospitalisation"); //on appelle la fonction de base des requetes
                        this.result(list);
                    }
                    else{
                        if(hos0.compareTo("")!=0){
                            nb = Integer.parseInt(menu.txt_hospitalisation.get(0).getText().trim());
                            if(!firstCondition){
                                requete +=" AND ";
                            }
                            requete +="no_malade="+nb;
                            firstCondition = false;
                            }
                        if(hos1.compareTo("")!=0){
                            if(!firstCondition){
                                requete +=" AND ";
                            }
                            requete +="code_service="+hos1+"'";
                            firstCondition = false;
                            }
                        if(hos2.compareTo("")!=0){
                            nb = Integer.parseInt(menu.txt_hospitalisation.get(2).getText().trim());
                            if(!firstCondition){
                                requete +=" AND ";
                            }
                            requete +="no_chambre="+nb;
                            firstCondition = false;
                            }
                        if(hos3.compareTo("")!=0){
                            if(!firstCondition){
                                requete +=" AND ";
                            }
                            requete +="lit="+hos3+"'";
                            firstCondition = false;
                            }
                        
                        resultat.removeAll();
                        resultat.setLayout(new GridLayout(0,2));
                        deleteObj("hospitalisation",requete);
                        this.result(list);
                    }
                    break;
                    
                case 7 :
                    String soi0 = menu.txt_soin.get(0).getText().trim();
                    String soi1 = menu.txt_soin.get(1).getText().trim();
                    
                    
                    if(soi0.compareTo("")==0 && soi1.compareTo("")==0){
                        resultat.removeAll();
                        resultat.setLayout(new GridLayout(0,2));
                        list =affichFull("soigne"); //on appelle la fonction de base des requetes
                        this.result(list);
                    }
                    else{
                        if(soi0.compareTo("")!=0){
                            nb = Integer.parseInt(menu.txt_soin.get(0).getText().trim());
                            if(!firstCondition){
                                requete +=" AND ";
                            }
                            requete +="no_docteur="+nb;
                            firstCondition = false;
                            }
                        if(soi1.compareTo("")!=0){
                            nb = Integer.parseInt(menu.txt_soin.get(1).getText().trim());
                            if(!firstCondition){
                                requete +=" AND ";
                            }
                            requete +="no_malade="+nb;
                            firstCondition = false;
                            }
                        
                        
                        resultat.removeAll();
                        resultat.setLayout(new GridLayout(0,2));
                        deleteObj("soigne",requete);
                        this.result(list);
                    }
                    break;
                default:
                    break;
            }
            
        }
    }
    
}
