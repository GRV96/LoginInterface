import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * This frame must appear whenever user connection is necessary.
 * @author GRV96
 */
public class LoginDialog extends JDialog {

    // This frame's dimensions
    private static final int WINDOW_WIDTH = 400;
    private static final int WINDOW_HEIGHT = 180;
    
    // Username and password fields dimensions
    private static final int FIELD_WIDTH = WINDOW_WIDTH - 100;
    private static final int FIELD_HEIGHT = 30;

    // Error message displayed when connexion fails
    private static final String CONNEXION_FAILED = "Invalid username or password";

    // Displays error message when connexion fails.
    private JLabel errorLbl;

    // A field to enter the user ID
    private JTextField idField;

    // A field to enter the password
    private JPasswordField pwField;

    // The button that launches the connexion.
    private JButton loginBtn;

    // The button that cancels the connexion
    private JButton cancelBtn;

    private boolean userConnected;

    /**
     * Constructor
     * @param parent
     *      The parent compoment
     */
    public LoginDialog(Frame parent){

        super(parent, "Log in", true);
        setLocationRelativeTo(parent);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setResizable(false);
        userConnected = false;
        buildContentPane();
    }

    /**
     * Instantiates and sets up the error label.
     */
    private void initErrorLabel(){

        Font errorFont = new Font("Dialog", Font.PLAIN, 14);
        errorLbl = new JLabel("");
        errorLbl.setFont(errorFont);
        errorLbl.setForeground(Color.RED);
    }

    /**
     * Instantiates and sets up the username field.
     * @return
     *      a JPanel containing the field with a description JLabel
     */
    private JPanel initIdField(){

        JPanel idPanel = new JPanel();
        idPanel.setLayout(new FlowLayout());

        JLabel idLabel = new JLabel("Username");

        idField = new JTextField();
        idField.setEditable(true);
        idField.setPreferredSize(new Dimension(FIELD_WIDTH, FIELD_HEIGHT));

        idPanel.add(idLabel);
        idPanel.add(idField);

        return idPanel;
    }

    /**
     * Instantiates and sets up the password field.
     * @return
     *      a JPanel containing the field with a description JLabel
     */
    private JPanel initPwPanel(){

        JPanel pwPanel = new JPanel();
        pwPanel.setLayout(new FlowLayout());

        JLabel pwLabel = new JLabel("Password: ");

        pwField = new JPasswordField();
        pwField.setEditable(true);
        pwField.setPreferredSize(new Dimension(FIELD_WIDTH, FIELD_HEIGHT));
        pwField.addKeyListener(new EnterKeyListener());

        pwPanel.add(pwLabel);
        pwPanel.add(pwField);

        return pwPanel;
    }

    /**
     * Instantiates and sets up a panel
     * containing the login and cancel buttons.
     * @return
     * 		a JPanel containing the two buttons
     */
    private javax.swing.JPanel initBtnPanel(){

        JPanel btnPanel = new JPanel();
        btnPanel.setLayout(new java.awt.FlowLayout());

        loginBtn = new JButton("Log in");
        loginBtn.addActionListener(new LoginListener());

        cancelBtn = new javax.swing.JButton("Cancel");
        cancelBtn.addActionListener(new CancelListener());

        btnPanel.add(loginBtn);
        btnPanel.add(cancelBtn);

        return btnPanel;
    }

    /**
     * Adds the required components to this JFrame's content pane.
     */
    private void buildContentPane(){

        // The JPanel that will become the content pane
        JPanel cp = new JPanel();
        cp.setLayout(new BoxLayout(cp, BoxLayout.PAGE_AXIS));

        initErrorLabel();
        cp.add(errorLbl);

        cp.add(initIdField());
        cp.add(initPwPanel());

        cp.add(initBtnPanel());

        setContentPane(cp);
    }
    
    /**
     * If the username and password match, the connexion interface
     * disapears. The user may then access the application.
     */
    private void attemptConnexion() {
    	
    	userConnected = usernamePasswordMatch();

        if(userConnected){

            errorLbl.setText(null);
            dispose();
        }
        else{

            errorLbl.setText(CONNEXION_FAILED);
            pwField.setText(null);
        }
    }

    /**
     * Returns whether the user has successfully logged in.
     * @return
     * 		True if the user is connected
     */
    public boolean isUserConnected() {return userConnected;}

    @Override
    public void setVisible(boolean b){

        // This JFrame is visible when no user is connected.
        if(b) {userConnected = false;}
        super.setVisible(b);
    }
    
    /**
     * Determines whether the username and password are valid.
     * @return
     *      true if they are or else false
     */
    private boolean usernamePasswordMatch(){

        String username = idField.getText();
        String password = new String(pwField.getPassword());

        return true;
    }

    /**
     * The ActionListener for the login button.
     * @author GRV96
     */
    private class LoginListener implements ActionListener{

        public void actionPerformed(ActionEvent e){

            attemptConnexion();
        }
    }

    /**
     * The ActionListener for the cancel button.
     * @author GRV96
     *
     */
    private class CancelListener implements ActionListener{

        public void actionPerformed(ActionEvent e){

            System.exit(0);
        }
    }
    
    /**
     * The KeyListener for the password field. It
     * starts the connexion process when Enter is typed.
     * @author GRV96
     *
     */
    private class EnterKeyListener implements KeyListener{

		@Override
		public void keyTyped(KeyEvent e) {
			
			// Do nothing
		}

		@Override
		public void keyPressed(KeyEvent e) {
			
			if(e.getKeyChar()=='\n') {
				
				attemptConnexion();
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
			
			// Do nothing
		}
    }
}
