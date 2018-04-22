/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

/**
 *
 * @author karimrafrafi
 */

public class Panel extends JTabbedPane {
	
	private JPanel panService ;
	private JPanel panChambre;
	private JPanel panEmploye ;
	private JPanel panDocteur ;
	private JPanel panInfirmier ;
	private JPanel panMalade;
	private JPanel panHospi ;
	private JPanel panSoin;
         

        //déclaration des ArrayList pour récupérer les valeurs entrées dans le module recherche 
        ArrayList<JTextField> txt_malade = new ArrayList<JTextField>();
        ArrayList<JTextField> txt_service = new ArrayList<JTextField>();
        ArrayList<JTextField> txt_chambre = new ArrayList<JTextField>();
        ArrayList<JTextField> txt_soin = new ArrayList<JTextField>();
        ArrayList<JTextField> txt_employe = new ArrayList<JTextField>();
        ArrayList<JTextField> txt_hospitalisation = new ArrayList<JTextField>();
        ArrayList<JTextField> txt_docteur = new ArrayList<JTextField>();
        ArrayList<JTextField> txt_infirmier = new ArrayList<JTextField>();
	
	

	public Panel() {
		
		panService = new JPanel(); // instancier le panneau corresp
		panChambre = new JPanel(); // instancier le panneau corresp
		panEmploye = new JPanel(); // instancier le panneau corresp
		panDocteur = new JPanel(); // instancier le panneau corresp
		panInfirmier = new JPanel(); // instancier le panneau corresp
		panMalade = new JPanel(); // instancier le panneau corresp
		panHospi = new JPanel(); // instancier le panneau corresp
		panSoin = new JPanel(); // instancier le panneau corresp
		
		this.add("Service", panService);
		this.add("Chambre", panChambre);
		this.add("Employé", panEmploye);
		this.add("Docteur", panDocteur);
		this.add("Infirmier", panInfirmier);
		this.add("Malade", panMalade);
		this.add("Hospitalisation", panHospi);
		this.add("Soin", panSoin);
		
		init_service();
		init_chambre();
		init_employe();
		init_docteur();
		init_infirmier();
		init_malade();
		init_hospitalisation();
		init_soin();
	}
        
        private void init_docteur() {
		panDocteur.setLayout(new GridLayout());
                //pan contenant les labels et txtfield
                JPanel pan1 = new JPanel();
		JPanel pan2 = new JPanel();
		
                
		JLabel l1 = new JLabel("Numéro:");
		JLabel l2 = new JLabel("Spécialité:");
		

		JTextField txt1 = new JTextField ();
		JTextField txt2 = new JTextField();
		
                
                txt1.setPreferredSize(new Dimension(100,30));
		txt2.setPreferredSize(new Dimension(100,30));
		
		txt_docteur.add(txt1);
		txt_docteur.add(txt2);
		
		
		pan1.add(l1);
		pan1.add(txt1);
		pan2.add(l2);
		pan2.add(txt2);
	
		
		panDocteur.add(pan1);

		panDocteur.add(pan2);


	}
        
        private void init_soin() {
		panSoin.setLayout(new GridLayout());
                //pan contenant les labels et txtfield
                JPanel pan1 = new JPanel();
		JPanel pan2 = new JPanel();
		
                
		JLabel l1 = new JLabel("N° Docteur:");
		JLabel l2 = new JLabel("N° Malade:");
		

		JTextField txt1 = new JTextField ();
		JTextField txt2 = new JTextField();
		
                
                txt1.setPreferredSize(new Dimension(100,30));
		txt2.setPreferredSize(new Dimension(100,30));
		
		txt_soin.add(txt1);
		txt_soin.add(txt2);
		
		
		pan1.add(l1);
		pan1.add(txt1);
		pan2.add(l2);
		pan2.add(txt2);
	
		
		panSoin.add(pan1);

		panSoin.add(pan2);


	}
        
        private void init_employe() {
		panEmploye.setLayout(new GridLayout());
                //pan contenant les labels et txtfield
                JPanel pan1 = new JPanel();
		JPanel pan2 = new JPanel();
		JPanel pan3 = new JPanel();
		JPanel pan4 = new JPanel();
                JPanel pan5 = new JPanel();
                
		JLabel l1 = new JLabel("Numéro:");
		JLabel l2 = new JLabel("Nom:");
		JLabel l3 = new JLabel("Prénom:");
		JLabel l4 = new JLabel("Tel:");
                JLabel l5 = new JLabel("Adresse:");

		JTextField txt1 = new JTextField ();
		JTextField txt2 = new JTextField();
		JTextField txt3 = new JTextField();
		JTextField txt4 = new JTextField();
                JTextField txt5 = new JTextField();
                
                txt1.setPreferredSize(new Dimension(100,30));
		txt2.setPreferredSize(new Dimension(100,30));
		txt3.setPreferredSize(new Dimension(100,30));
		txt4.setPreferredSize(new Dimension(100,30));
                txt5.setPreferredSize(new Dimension(100,30));
		
		txt_employe.add(txt1);
		txt_employe.add(txt2);
		txt_employe.add(txt3);
		txt_employe.add(txt4);
                txt_employe.add(txt5);
		
		pan1.add(l1);
		pan1.add(txt1);
		pan2.add(l2);
		pan2.add(txt2);
		pan3.add(l3);
		pan3.add(txt3);
		pan4.add(l4);
		pan4.add(txt4);
                pan5.add(l5);
		pan5.add(txt5);
                
		
		panEmploye.add(pan1);

		panEmploye.add(pan2);

		panEmploye.add(pan3);

		panEmploye.add(pan4);
                
                panEmploye.add(pan5);

	}
        
        private void init_malade() {
		panMalade.setLayout(new GridLayout());
                //pan contenant les labels et txtfield
                JPanel pan1 = new JPanel();
		JPanel pan2 = new JPanel();
		JPanel pan3 = new JPanel();
		JPanel pan4 = new JPanel();
                JPanel pan5 = new JPanel();
                JPanel pan6 = new JPanel();
                
		JLabel l1 = new JLabel("Numéro:");
		JLabel l2 = new JLabel("Nom:");
		JLabel l3 = new JLabel("Prénom:");
		JLabel l4 = new JLabel("Tel:");
                JLabel l5 = new JLabel("Adresse:");
                JLabel l6 = new JLabel("Mutuelle:");

		JTextField txt1 = new JTextField ();
		JTextField txt2 = new JTextField();
		JTextField txt3 = new JTextField();
		JTextField txt4 = new JTextField();
                JTextField txt5 = new JTextField();
                JTextField txt6 = new JTextField();
                
                txt1.setPreferredSize(new Dimension(100,30));
		txt2.setPreferredSize(new Dimension(100,30));
		txt3.setPreferredSize(new Dimension(100,30));
		txt4.setPreferredSize(new Dimension(100,30));
                txt5.setPreferredSize(new Dimension(100,30));
                txt6.setPreferredSize(new Dimension(100,30));
		
		txt_malade.add(txt1);
		txt_malade.add(txt2);
		txt_malade.add(txt3);
		txt_malade.add(txt4);
                txt_malade.add(txt5);
                txt_malade.add(txt6);
		
		pan1.add(l1);
		pan1.add(txt1);
		pan2.add(l2);
		pan2.add(txt2);
		pan3.add(l3);
		pan3.add(txt3);
		pan4.add(l4);
		pan4.add(txt4);
                pan5.add(l5);
		pan5.add(txt5);
                pan6.add(l6);
		pan6.add(txt6);
                
		
		panMalade.add(pan1);

		panMalade.add(pan2);

		panMalade.add(pan3);

		panMalade.add(pan4);
                
                panMalade.add(pan5);
                
                panMalade.add(pan6);
		

	}
        
	
	private void init_service() {
		panService.setLayout(new GridLayout());
                //pan contenant les labels et txtfield
                JPanel pan1 = new JPanel();
		JPanel pan2 = new JPanel();
		JPanel pan3 = new JPanel();
		JPanel pan4 = new JPanel();
                
		JLabel l1 = new JLabel("Code:");
		JLabel l2 = new JLabel("Nom:");
		JLabel l3 = new JLabel("Batiment:");
		JLabel l4 = new JLabel("Directeur:");

		JTextField txt1 = new JTextField ();
		JTextField txt2 = new JTextField();
		JTextField txt3 = new JTextField();
		JTextField txt4 = new JTextField();
                
                txt1.setPreferredSize(new Dimension(100,30));
		txt2.setPreferredSize(new Dimension(100,30));
		txt3.setPreferredSize(new Dimension(100,30));
		txt4.setPreferredSize(new Dimension(100,30));
		
		txt_service.add(txt1);
		txt_service.add(txt2);
		txt_service.add(txt3);
		txt_service.add(txt4);
		
		pan1.add(l1);
		pan1.add(txt1);
		pan2.add(l2);
		pan2.add(txt2);
		pan3.add(l3);
		pan3.add(txt3);
		pan4.add(l4);
		pan4.add(txt4);
		
		panService.add(pan1);

		panService.add(pan2);

		panService.add(pan3);

		panService.add(pan4);
		

	}
        
        public void init_chambre(){
            panChambre.setLayout(new GridLayout());
            
            JPanel pan1=new JPanel();
            JPanel pan2=new JPanel();
            JPanel pan3=new JPanel();
            JPanel pan4=new JPanel();
            
            JLabel l1=new JLabel("N°Chambre:");
            JLabel l2=new JLabel("Code Service:");
            JLabel l3=new JLabel("Surveillant:");
            JLabel l4=new JLabel("Nb Lits:");
            
            JTextField txt1 = new JTextField ();
            JTextField txt2 = new JTextField();
            JTextField txt3 = new JTextField();
            JTextField txt4 = new JTextField();

            txt1.setPreferredSize(new Dimension(100,30));
            txt2.setPreferredSize(new Dimension(100,30));
            txt3.setPreferredSize(new Dimension(100,30));
            txt4.setPreferredSize(new Dimension(100,30));

            txt_chambre.add(txt1);
            txt_chambre.add(txt2);
            txt_chambre.add(txt3);
            txt_chambre.add(txt4);

            pan1.add(l1);
            pan1.add(txt1);
            pan2.add(l2);
            pan2.add(txt2);
            pan3.add(l3);
            pan3.add(txt3);
            pan4.add(l4);
            pan4.add(txt4);

            panChambre.add(pan1);

            panChambre.add(pan2);

            panChambre.add(pan3);

            panChambre.add(pan4);
        }
        
        public void init_infirmier(){
            panInfirmier.setLayout(new GridLayout());
            
            JPanel pan1=new JPanel();
            JPanel pan2=new JPanel();
            JPanel pan3=new JPanel();
            JPanel pan4=new JPanel();
            
            JLabel l1=new JLabel("Numéro:");
            JLabel l2=new JLabel("Code Service:");
            JLabel l3=new JLabel("Rotation:");
            JLabel l4=new JLabel("Salaire:");
            
            JTextField txt1 = new JTextField ();
            JTextField txt2 = new JTextField();
            JTextField txt3 = new JTextField();
            JTextField txt4 = new JTextField();

            txt1.setPreferredSize(new Dimension(100,30));
            txt2.setPreferredSize(new Dimension(100,30));
            txt3.setPreferredSize(new Dimension(100,30));
            txt4.setPreferredSize(new Dimension(100,30));

            txt_infirmier.add(txt1);
            txt_infirmier.add(txt2);
            txt_infirmier.add(txt3);
            txt_infirmier.add(txt4);

            pan1.add(l1);
            pan1.add(txt1);
            pan2.add(l2);
            pan2.add(txt2);
            pan3.add(l3);
            pan3.add(txt3);
            pan4.add(l4);
            pan4.add(txt4);

            panInfirmier.add(pan1);

            panInfirmier.add(pan2);

            panInfirmier.add(pan3);

            panInfirmier.add(pan4);
        }
        
        public void init_hospitalisation(){
            panHospi.setLayout(new GridLayout());
            
            JPanel pan1=new JPanel();
            JPanel pan2=new JPanel();
            JPanel pan3=new JPanel();
            JPanel pan4=new JPanel();
            
            JLabel l1=new JLabel("N°Malade:");
            JLabel l2=new JLabel("Code Service:");
            JLabel l3=new JLabel("N°Chambre:");
            JLabel l4=new JLabel("Lit:");
            
            JTextField txt1 = new JTextField ();
            JTextField txt2 = new JTextField();
            JTextField txt3 = new JTextField();
            JTextField txt4 = new JTextField();

            txt1.setPreferredSize(new Dimension(100,30));
            txt2.setPreferredSize(new Dimension(100,30));
            txt3.setPreferredSize(new Dimension(100,30));
            txt4.setPreferredSize(new Dimension(100,30));

            txt_hospitalisation.add(txt1);
            txt_hospitalisation.add(txt2);
            txt_hospitalisation.add(txt3);
            txt_hospitalisation.add(txt4);

            pan1.add(l1);
            pan1.add(txt1);
            pan2.add(l2);
            pan2.add(txt2);
            pan3.add(l3);
            pan3.add(txt3);
            pan4.add(l4);
            pan4.add(txt4);

            panHospi.add(pan1);

            panHospi.add(pan2);

            panHospi.add(pan3);

            panHospi.add(pan4);
        }
}