import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LoginTest {

	public static void main(String[] args) {
		
		//*
        JFrame frame = new JFrame();
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JLabel label = new JLabel("Connection required");

        ActionListener listener = new ActionListener(){

            public void actionPerformed(ActionEvent e){

                LoginDialog ld = new LoginDialog(frame);
                ld.setVisible(true);

                if(ld.isUserConnected()){

                    label.setText("Connection succeeded");
                }
                else{

                    label.setText("Connection failed");
                }
            }
        };

        JButton btn = new JButton("Connection");
        btn.addActionListener(listener);

        JPanel cp = new JPanel();
        cp.add(label);
        cp.add(btn);

        frame.setContentPane(cp);
        frame.setVisible(true);
        //*/
        
		/*
        LoginDialog ld = new LoginDialog(null);
        ld.setVisible(true);
        //*/
	}

}
