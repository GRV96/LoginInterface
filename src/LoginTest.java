//package ca.etsmtl.log240.financej;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LoginTest {

	public static void main(String[] args) {
		
		//*
        JFrame fenetre = new JFrame();
        fenetre.setSize(500, 500);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setLocationRelativeTo(null);

        JLabel etiquette = new javax.swing.JLabel("Connexion requise");

        ActionListener ecouteur = new ActionListener(){

            public void actionPerformed(java.awt.event.ActionEvent e){

                LoginDialog ld = new LoginDialog(fenetre);
                ld.setVisible(true);

                if(ld.isUserConnected()){

                    etiquette.setText("Connexion réussie");
                }
                else{

                    etiquette.setText("Connexion échouée");
                }
            }
        };

        JButton btn = new JButton("Connexion");
        btn.addActionListener(ecouteur);

        JPanel cp = new JPanel();
        cp.add(etiquette);
        cp.add(btn);

        fenetre.setContentPane(cp);
        fenetre.setVisible(true);
        //*/
        
		/*
        LoginDialog ld = new LoginDialog(null);
        ld.setVisible(true);
        //*/
	}

}
