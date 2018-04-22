
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

/**
 *
 * @author karimrafrafi
 */

import Modèle.Connexion;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;

//import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;


public class Fenetre extends JFrame implements ActionListener {
    
    //déclaration des éléments swing et d'un objet Connexion 
    private Connexion connexion;
    private JTabbedPane menu0;
    private Panel attributs;
    private JLabel nameECE, passwdECE, logBDD, passwdBDD, nameBDD;
    private JTextField nameECETxt;
    private JTextField logBDDTxt;
    private JTextField nameBDDTxt;
    private JPasswordField passwdECETxt;
    private JPasswordField passwdBDDTxt;
    private JButton connECE, connBDD, exeRecherche, modifBDD,exeRequete,exeGraph;
    private java.awt.List listeDeTables, listeDeRequetes;
    //private JTextArea fenetreRes;
    private JPanel panECE,panRecher,panBDD,pan1,pan2,pan3,pan4,resultat;
    private JScrollPane scroll;
    private ModiFen modif;
    private requAjout reqSelect;
   
    
    
    public Fenetre(){
        //appel du constructeur de JFrame et definition de la fenêtre 
        super("Connexion à la BDD");
        this.setLayout(new BorderLayout());
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1200, 800);
        
        // creation des listes pour les tables et les requetes
        listeDeTables = new java.awt.List(10, false);
        listeDeRequetes = new java.awt.List(10, false);
        
        //instance des JTabbedPane
        menu0 = new JTabbedPane();
        attributs =  new Panel();
        //ajout du JTabbedPane principal à la fenêtre 
        this.add(menu0);
       
        //instanciation des pan de connexion et de recherche
        panECE= new JPanel();
        panBDD=new JPanel();
        panRecher= new JPanel();
        pan1= new JPanel();
        pan2= new JPanel();
        resultat= new JPanel();
        
        //ajout des pan au menu0 
        menu0.add("Connexion ECE", panECE);
        menu0.add("Connexion BDD", panBDD);
        menu0.add("Rechercher",panRecher);
        
        // on definit le Layout des pan principaux 
        panECE.setLayout(new BorderLayout());
        panBDD.setLayout(new BorderLayout());
        panRecher.setLayout(new BorderLayout());
        
        //On ajoute le menu d'attributs du type panel hérité au panel Rechercher       
        panRecher.add(attributs,BorderLayout.NORTH);
        
        //instanciation des JLabel Connexion ECE
        nameECE= new JLabel("Login ECE:",JLabel.CENTER); 
        passwdECE= new JLabel("Password ECE:",JLabel.CENTER); 
        
        //instanciation des JLabel Connexion BDD
        logBDD= new JLabel("Login BDD:",JLabel.CENTER); 
        passwdBDD= new JLabel("Password BDD:",JLabel.CENTER); 
        nameBDD= new JLabel("Nom BDD:",JLabel.CENTER); 
        
        //instance du bouton ECE
        connECE = new JButton("Connexion ECE");
        //instanciation du bouton BDD
        connBDD = new JButton("Connexion BDD");
        //instanciation des boutons recherche et Modification
        
        exeRecherche= new JButton("Rechercher");
        modifBDD = new JButton("Modification de la base de donnée ");
        exeRequete = new JButton("Effectuer les requêtes enregistrées");
        exeGraph = new JButton("Graphiques");
        
      
        //Création des espaces de saisies ECE
        nameECETxt = new JTextField(); //txt
        passwdECETxt = new JPasswordField(16); //mdp
        
        //Création des espaces de saisies BDD
        logBDDTxt = new JTextField();
        nameBDDTxt = new JTextField();
        passwdBDDTxt = new JPasswordField(16);
        
        //redimensionnement des JTextField ECE
        connECE.setPreferredSize(new Dimension(150,50));
        nameECETxt.setPreferredSize(new Dimension(150,20));
        passwdECETxt.setPreferredSize(new Dimension(150,20));
        
        //redimensionnement des JTextField BDD
        connBDD.setPreferredSize(new Dimension(150,50));
        logBDDTxt.setPreferredSize(new Dimension(150,20));
        nameBDDTxt.setPreferredSize(new Dimension(150,20));
        passwdBDDTxt.setPreferredSize(new Dimension(150,20));
        
        //Action listener connexion ECE
        connECE.addActionListener(this);
        
        //Action listener connexion BDD
        connBDD.addActionListener(this);
        
        //Action listener pour les boutons du pan recherche
        exeRecherche.addActionListener(this);
        modifBDD.addActionListener(this);
        exeRequete.addActionListener(this);
        exeGraph.addActionListener(this);
        
        //  ajout des élément aux pans de connexions
        pan1.add(nameECE);  
        pan1.add(nameECETxt);
        pan1.add(passwdECE);
        pan1.add(passwdECETxt);
        pan2.add(logBDD);   
        pan2.add(logBDDTxt);
        pan2.add(passwdBDD);
        pan2.add(passwdBDDTxt);
        pan2.add(nameBDD);
        pan2.add(nameBDDTxt);
        pan1.add(connECE);
        pan2.add(connBDD);
        
        panECE.add(pan1,BorderLayout.NORTH);
        panBDD.add(pan2,BorderLayout.CENTER);
       
        //panel Recherche + pan pour affichage des resultats 
        resultat.setBackground(Color.WHITE);
        scroll = new JScrollPane(resultat,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setLayout(new ScrollPaneLayout());
        scroll.setSize(new Dimension(200, 200));
        pan3 = new JPanel(new GridLayout(1,4));
        pan3.add(exeRecherche);
        pan3.add(modifBDD);
        pan3.add(exeRequete);
        pan3.add(exeGraph);
        pan4 = new JPanel(new BorderLayout());
        pan4.add(pan3,BorderLayout.NORTH);
        pan4.add(scroll,BorderLayout.CENTER);
        panRecher.add(pan4,BorderLayout.CENTER);
        
        
        this.setVisible(true);
        
    }
    
    private void initTables() {
        connexion.ajouterTable("chambre");
        connexion.ajouterTable("docteur");
        connexion.ajouterTable("employe");
        connexion.ajouterTable("hospitalisation");
        connexion.ajouterTable("infirmier");
        connexion.ajouterTable("malade");
        connexion.ajouterTable("service");
        connexion.ajouterTable("soigne");
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
    
    
    
    // affichage de toute la table(chaque table)
    public ArrayList affichFull(String table){
           ArrayList arrayL = new ArrayList();
            try {
                arrayL= connexion.remplirChampsRequete("SELECT * FROM "+table);

            } catch (Exception e) {
                System.out.println("Erreur SQL");
            }
            return arrayL;
    }
    
//affichage selon la requète selon la table
    public ArrayList requete(String table,String requete){
        ArrayList l= new ArrayList();
            try {
                 l = connexion.remplirChampsRequete("SELECT * FROM " +table+ " WHERE " + requete);
            } catch (Exception e) {
                System.out.println("Erreur SQL");
                e.printStackTrace();
            }
            return l;
            
        }
    
    /**
     * Méthode privée qui initialise la liste des requetes de selection
     */
    private void remplirRequetes() {
        connexion.ajouterRequete("SELECT prenom, nom FROM malade WHERE mutuelle='MAAF;");
        connexion.ajouterRequete("SELECT employe.prenom, Emp.*, Mission.* FROM Dept, Emp, Mission WHERE Dept.deptno=Emp.deptno AND Emp.empno=Mission.empno;");
        connexion.ajouterRequete("SELECT AVG (Emp.sal) FROM Emp, Mission WHERE Emp.empno = Mission.empno;");
        connexion.ajouterRequete("SELECT Dept.*, Emp.* FROM Dept, Emp WHERE Dept.deptno=Emp.deptno AND comm>0;");
        connexion.ajouterRequete("SELECT hiredate, empno, ename FROM Emp WHERE (((hiredate)>='1981-05-01' And (hiredate)<'1981-05-31'))ORDER BY hiredate;");
        connexion.ajouterRequete("SELECT ename, job FROM Emp ORDER BY job;");
        connexion.ajouterRequete("SELECT DISTINCT dname, job FROM Dept, Emp WHERE Dept.deptno=Emp.deptno AND job='Clerk';");
    }
    
    
   
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source=e.getSource();
        int index = attributs.getSelectedIndex();
        if (source == connECE){
            menu0.setSelectedIndex(1);
        }
        else if (source == connBDD){

            String psswdBDD = new String(passwdBDDTxt.getPassword());
            //String psswdECE = new String(passwdECETxt.getPassword());
            try {
            connexion = new Connexion("hopital", "root", "root");

            }catch (SQLException | ClassNotFoundException ex) {
                System.out.println("Connexion echouee : probleme SQL");
                ex.printStackTrace();
            }
            finally{
            passwdECETxt.setText("");
            nameECETxt.setText("");
            }
            menu0.setSelectedIndex(2);
        }
        else if (source == exeRequete){
            this.reqSelect = new requAjout(connexion);
        }
        
        else if(source == modifBDD ){
            this.modif = new ModiFen(connexion);
        }
        else if (source==exeRecherche){
            boolean firstCondition = true;
            int nb=0;
            String requete;
            requete = "";
            ArrayList list = null;
            switch(index){
                case 0 :
                    String ser0 = attributs.txt_service.get(0).getText().trim();
                    String ser1 = attributs.txt_service.get(1).getText().trim();
                    String ser2 = attributs.txt_service.get(2).getText().trim();
                    String ser3 = attributs.txt_service.get(3).getText().trim();
                    
                    if(ser0.compareTo("")==0 && ser1.compareTo("")==0 && ser2.compareTo("")==0 && ser3.compareTo("")==0){
                        resultat.removeAll();
                        resultat.setLayout(new GridLayout(0,1));
                        list =affichFull("service"); //on appelle la fonction basique des requetes
                        this.result(list);
                    }
                    else{
                        if(ser0.compareTo("")!=0){
                            if(!firstCondition){
                                requete +=" AND ";
                            }
                            requete +="code='"+ser0+"'";
                            firstCondition = false;
                            }
                        if(ser1.compareTo("")!=0){
                            if(!firstCondition){
                                requete +=" AND ";
                            }
                            requete +="nom='"+ser1+"'";
                            firstCondition = false;
                            }
                        if(ser2.compareTo("")!=0){
                            if(!firstCondition){
                                requete +=" AND ";
                            }
                            requete +="batiment='"+ser3+"'";
                            firstCondition = false;
                            }
                        if(ser3.compareTo("")!=0){
                            if(!firstCondition){
                                requete +=" AND ";
                            }
                            requete +="directeur='"+ser2+"'";
                            firstCondition = false;
                            }
                        
                        resultat.removeAll();
                        resultat.setLayout(new GridLayout(0,1));
                        list = requete("service",requete);
                        this.result(list);
                    }
                    break;
                    
                case 1 :
                    String cha0 = attributs.txt_chambre.get(0).getText().trim();
                    String cha1 = attributs.txt_chambre.get(1).getText().trim();
                    String cha2 = attributs.txt_chambre.get(2).getText().trim();
                    String cha3 = attributs.txt_chambre.get(3).getText().trim();
                    
                    if(cha0.compareTo("")==0 && cha1.compareTo("")==0 && cha2.compareTo("")==0 && cha3.compareTo("")==0){
                        resultat.removeAll();
                        resultat.setLayout(new GridLayout(0,1));
                        list =affichFull("chambre"); //on appelle la fonction de base des requetes
                        this.result(list);
                    }
                    else{
                        if(cha0.compareTo("")!=0){
                            //nb = Integer.parseInt(attributs.txt_chambre.get(0).getText().trim());
                            if(!firstCondition){
                                requete +=" AND ";
                            }
                            requete +="no_chambre='"+cha0+"'";
                            firstCondition = false;
                            }
                        if(cha1.compareTo("")!=0){
                            if(!firstCondition){
                                requete +=" AND ";
                            }
                            requete +="code_service='"+cha1+"'";
                            firstCondition = false;
                            }
                        if(cha2.compareTo("")!=0){
                            if(!firstCondition){
                                requete +=" AND ";
                            }
                            requete +="surveillant='"+cha2+"'";
                            firstCondition = false;
                            }
                        if(cha3.compareTo("")!=0){
                            if(!firstCondition){
                                requete +=" AND ";
                            }
                            requete +="nb_lits='"+cha3+"'";
                            firstCondition = false;
                            }
                        
                        resultat.removeAll();
                        resultat.setLayout(new GridLayout(0,1));
                        list = requete("chambre",requete);
                        this.result(list);
                    }
                    break;
                
                case 2 :
                    String emp0 = attributs.txt_employe.get(0).getText().trim();
                    String emp1 = attributs.txt_employe.get(1).getText().trim();
                    String emp2 = attributs.txt_employe.get(2).getText().trim();
                    String emp3 = attributs.txt_employe.get(3).getText().trim();
                    String emp4 = attributs.txt_employe.get(4).getText().trim();
                    
                    if(emp0.compareTo("")==0 && emp1.compareTo("")==0 && emp2.compareTo("")==0 && emp3.compareTo("")==0&& emp4.compareTo("")==0){ // si aucune saisie 
                        resultat.removeAll();
                        resultat.setLayout(new GridLayout(0,1));
                        list =affichFull("employe"); //on appelle la fonction de base des requetes
                        this.result(list);
                    }
                    else{
                        if(emp0.compareTo("")!=0){
                            nb = Integer.parseInt(attributs.txt_employe.get(0).getText().trim());
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
                        resultat.setLayout(new GridLayout(0,1));
                        list = requete("employe",requete);
                        this.result(list);
                    }
                    break;
                    
                case 3:
                    String doc0 = attributs.txt_docteur.get(0).getText().trim();
                    String doc1 = attributs.txt_docteur.get(1).getText().trim();
                    
                    if(doc0.compareTo("")==0 && doc1.compareTo("")==0){ // si aucune saisie 
                        resultat.removeAll();
                        resultat.setLayout(new GridLayout(0,1));
                        list =affichFull("docteur"); //on appelle la fonction de base des requetes
                        this.result(list);
                    }
                    else{
                        if(doc0.compareTo("")!=0){
                            nb = Integer.parseInt(attributs.txt_docteur.get(0).getText().trim());
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
                        resultat.setLayout(new GridLayout(0,1));
                        list = requete("docteur",requete);
                        this.result(list);
                    }
                    break;
                    
                case 4:
                    String inf0 = attributs.txt_infirmier.get(0).getText().trim();
                    String inf1 = attributs.txt_infirmier.get(1).getText().trim();
                    String inf2 = attributs.txt_infirmier.get(2).getText().trim();
                    String inf3 = attributs.txt_infirmier.get(3).getText().trim();
                    
                    if(inf0.compareTo("")==0 && inf1.compareTo("")==0 && inf2.compareTo("")==0 && inf3.compareTo("")==0){ // si aucune saisie 
                        resultat.removeAll();
                        resultat.setLayout(new GridLayout(0,1));
                        list =affichFull("infirmier"); //on appelle la fonction de base des requetes
                        this.result(list);
                    }
                    else{
                        if(inf0.compareTo("")!=0){
                            nb = Integer.parseInt(attributs.txt_infirmier.get(0).getText().trim());
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
                        resultat.setLayout(new GridLayout(0,1));
                        list = requete("infirmier",requete); //Commentaire bidon
                        this.result(list);
                    }
                    break;
                
                case 5 :
                    String mal0 = attributs.txt_malade.get(0).getText().trim();
                    String mal1 = attributs.txt_malade.get(1).getText().trim();
                    String mal2 = attributs.txt_malade.get(2).getText().trim();
                    String mal3 = attributs.txt_malade.get(3).getText().trim();
                    String mal4 = attributs.txt_malade.get(4).getText().trim();
                    String mal5 = attributs.txt_malade.get(5).getText().trim();
                    
                    if(mal0.compareTo("")==0 && mal1.compareTo("")==0 && mal2.compareTo("")==0 && mal3.compareTo("")==0&& mal4.compareTo("")==0 && mal5.compareTo("")==0){ // si aucune saisie 
                        resultat.removeAll();
                        resultat.setLayout(new GridLayout(0,1));
                        list =affichFull("malade"); //on appelle la fonction de base des requetes
                        this.result(list);
                    }
                    else{
                        if(mal0.compareTo("")!=0){
                            nb = Integer.parseInt(attributs.txt_malade.get(0).getText().trim());
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
                        resultat.setLayout(new GridLayout(0,1));
                        list = requete("malade",requete);
                        this.result(list);
                    }
                    break;
                    
                case 6 :
                    String hos0 = attributs.txt_hospitalisation.get(0).getText().trim();
                    String hos1 = attributs.txt_hospitalisation.get(1).getText().trim();
                    String hos2 = attributs.txt_hospitalisation.get(2).getText().trim();
                    String hos3 = attributs.txt_hospitalisation.get(3).getText().trim();
                    
                    if(hos0.compareTo("")==0 && hos1.compareTo("")==0 && hos2.compareTo("")==0 && hos3.compareTo("")==0){
                        resultat.removeAll();
                        resultat.setLayout(new GridLayout(0,1));
                        list =affichFull("hospitalisation"); //on appelle la fonction de base des requetes
                        this.result(list);
                    }
                    else{
                        if(hos0.compareTo("")!=0){
                            nb = Integer.parseInt(attributs.txt_hospitalisation.get(0).getText().trim());
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
                            nb = Integer.parseInt(attributs.txt_hospitalisation.get(2).getText().trim());
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
                        resultat.setLayout(new GridLayout(0,1));
                        list = requete("hospitalisation",requete);
                        this.result(list);
                    }
                    break;
                    
                case 7 :
                    String soi0 = attributs.txt_soin.get(0).getText().trim();
                    String soi1 = attributs.txt_soin.get(1).getText().trim();
                    
                    
                    if(soi0.compareTo("")==0 && soi1.compareTo("")==0){
                        resultat.removeAll();
                        resultat.setLayout(new GridLayout(0,1));
                        list =affichFull("soigne"); //on appelle la fonction de base des requetes
                        this.result(list);
                    }
                    else{
                        if(soi0.compareTo("")!=0){
                            nb = Integer.parseInt(attributs.txt_soin.get(0).getText().trim());
                            if(!firstCondition){
                                requete +=" AND ";
                            }
                            requete +="no_docteur="+nb;
                            firstCondition = false;
                            }
                        if(soi1.compareTo("")!=0){
                            nb = Integer.parseInt(attributs.txt_soin.get(1).getText().trim());
                            if(!firstCondition){
                                requete +=" AND ";
                            }
                            requete +="no_malade="+nb;
                            firstCondition = false;
                            }
                        
                        
                        resultat.removeAll();
                        resultat.setLayout(new GridLayout(0,1));
                        list = requete("soigne",requete);
                        this.result(list);
                    }
                    break;
                default:
                    break;
            }
            
        }
    }
}