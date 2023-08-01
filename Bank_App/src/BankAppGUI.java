import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;
import javax.swing.ImageIcon;
import java.awt.Image;

public class BankAppGUI {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private List<String> validUsernames = Arrays.asList(
    	    "Liam Johnson",
    	    "Olivia Davis",
    	    "Noah Wilson",
    	    "Emma Taylor",
    	    "Oliver Anderson",
    	    "Ava Martinez",
    	    "Isabella Thomas",
    	    "Sophia Brown",
    	    "Mia Lee",
    	    "Elijah Smith"
    );
    private String validPassword = "123456";

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                BankAppGUI bankApp = new BankAppGUI();
                bankApp.initialize();
            }
        });
    }

    public void initialize() {
        JFrame frame = new JFrame("Bank Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(320, 300);
        frame.setLocationRelativeTo(null);

        // Username
        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setForeground(Color.WHITE);
        usernameLabel.setBackground(UIManager.getColor("Button.background"));

        usernameField = new JTextField(15);

        // Password
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setForeground(Color.WHITE);

        JPanel passwordPanel = new JPanel();
        passwordField = new JPasswordField(15);
        passwordPanel.add(passwordField);

        // User Type Selection
        JLabel userTypeLabel = new JLabel("User Type:");
        userTypeLabel.setForeground(Color.WHITE);

        JRadioButton customerRadioButton = new JRadioButton("Customer");
        JRadioButton clerkRadioButton = new JRadioButton("Clerk");
        ButtonGroup userTypeGroup = new ButtonGroup();
        userTypeGroup.add(customerRadioButton);
        userTypeGroup.add(clerkRadioButton);

        JPanel radioPanel = new JPanel();
        radioPanel.setLayout(new FlowLayout());
        radioPanel.add(customerRadioButton);
        radioPanel.add(clerkRadioButton);

        // Reset Button
        JButton resetButton = new JButton("Reset");
        resetButton.setBackground(new Color(173, 216, 230));

        // Action Listener for Reset Button
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Reset the fields
                usernameField.setText("");
                passwordField.setText("");
                userTypeGroup.clearSelection();
            }
        });

        // Background Image
        ImageIcon backgroundImageIcon = new ImageIcon(getClass().getResource("login-background.png"));
        Image backgroundImage = backgroundImageIcon.getImage();

        // Create a custom JPanel to set the background image
        JPanel backgroundPanel = new JPanel() {
            /**
             * 
             */
            private static final long serialVersionUID = 1L;

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
        };

        // Set the layout of the background panel
        backgroundPanel.setLayout(new FlowLayout());

        // Add all the components to the background panel instead of the frame's content pane
        backgroundPanel.add(usernameLabel);
        backgroundPanel.add(usernameField);
        backgroundPanel.add(passwordLabel);
        backgroundPanel.add(passwordPanel);
        JToggleButton showPasswordToggle = new JToggleButton("Show");
        backgroundPanel.add(showPasswordToggle);
        showPasswordToggle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JToggleButton toggleButton = (JToggleButton) e.getSource();
                if (toggleButton.isSelected()) {
                    passwordField.setEchoChar((char) 0);
                } else {
                    passwordField.setEchoChar('\u2022'); 
                }
            }
        });
        backgroundPanel.add(userTypeLabel);
        backgroundPanel.add(radioPanel);
        
                // Login Button
                JButton loginButton = new JButton("Login");
                loginButton.setBackground(new Color(173, 216, 230));
                
                        // Action Listener for Login Button
                        loginButton.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                String username = usernameField.getText();
                                String password = new String(passwordField.getPassword());
                
                                if (customerRadioButton.isSelected()) {
                                    if (isValidCustomer(username, password)) {
                                        CustomerDashboard customerDashboard = new CustomerDashboard();
                                        customerDashboard.display(username);
                                        frame.dispose();
                                    } else {
                                        JOptionPane.showMessageDialog(frame, "Invalid username or password. Please try again.", "Login Failed", JOptionPane.ERROR_MESSAGE);
                                    }
                                } else if (clerkRadioButton.isSelected()) {
                                    ClerkLogin clerkLogin = new ClerkLogin();
                                    if (clerkLogin.isLoginValid(username, password)) {
                                        clerkLogin.openClerkDashboard();
                                        frame.dispose();
                                    } else {
                                        JOptionPane.showMessageDialog(frame, "Invalid username or password. Please try again.", "Login Failed", JOptionPane.ERROR_MESSAGE);
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(frame, "Please select a user type.", "Login Failed", JOptionPane.ERROR_MESSAGE);
                                }
                            }
                        });
                        backgroundPanel.add(loginButton);
        backgroundPanel.add(resetButton);

        ImageIcon icon = new ImageIcon(getClass().getResource("icon.png"));
        frame.setIconImage(icon.getImage());
        // Set the background panel as the content pane of the frame
        frame.setContentPane(backgroundPanel);
        frame.setVisible(true);
    }

    private boolean isValidCustomer(String username, String password) {
        return validUsernames.contains(username) && password.equals(validPassword);
    }
}
