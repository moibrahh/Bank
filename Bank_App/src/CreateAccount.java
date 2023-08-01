import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateAccount {
    private JFrame createAccountFrame;
    private JTextField accountIdField;
    private JPasswordField passwordField;
    private JTextField accountNameField;
    private JRadioButton savingsAccountRadioButton;
    private JRadioButton currentAccountRadioButton;

    /**
     * @wbp.parser.entryPoint
     */
    public void openCreateAccountForm() {
        createAccountFrame = new JFrame("Create Account");
        createAccountFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        createAccountFrame.setSize(400, 300);
        createAccountFrame.setLocationRelativeTo(null);

        // Background Image
        ImageIcon backgroundImageIcon = new ImageIcon(getClass().getResource("1.jpg"));
        Image backgroundImage = backgroundImageIcon.getImage().getScaledInstance(400, 300, Image.SCALE_SMOOTH);
        JLabel backgroundLabel = new JLabel(new ImageIcon(backgroundImage));
        createAccountFrame.setContentPane(backgroundLabel);

        createAccountFrame.getContentPane().setLayout(new BorderLayout());

        JPanel formPanel = new JPanel(new GridLayout(5, 2, 10, 10));
        formPanel.setOpaque(false);

        JLabel accountIdLabel = new JLabel("Account ID:");
        accountIdLabel.setForeground(new Color(255, 255, 255));
        accountIdField = new JTextField();
        accountIdField.setBackground(new Color(173, 216, 230));

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setForeground(new Color(255, 255, 255));
        passwordField = new JPasswordField();
        passwordField.setBackground(new Color(173, 216, 230));

        JLabel accountNameLabel = new JLabel("Account Name:");
        accountNameLabel.setForeground(new Color(255, 255, 255));
        accountNameField = new JTextField();
        accountNameField.setBackground(new Color(173, 216, 230));

        JLabel accountTypeLabel = new JLabel("Account Type:");
        accountTypeLabel.setForeground(new Color(255, 255, 255));
        savingsAccountRadioButton = new JRadioButton("Savings Account");
        savingsAccountRadioButton.setBackground(new Color(240, 248, 255));
        currentAccountRadioButton = new JRadioButton("Current Account");
        currentAccountRadioButton.setBackground(new Color(240, 248, 255));
        ButtonGroup accountTypeGroup = new ButtonGroup();
        accountTypeGroup.add(savingsAccountRadioButton);
        accountTypeGroup.add(currentAccountRadioButton);

        formPanel.add(accountIdLabel);
        formPanel.add(accountIdField);
        formPanel.add(passwordLabel);
        formPanel.add(passwordField);
        formPanel.add(accountNameLabel);
        formPanel.add(accountNameField);
        formPanel.add(accountTypeLabel);
        formPanel.add(savingsAccountRadioButton);
        formPanel.add(new JLabel());
        formPanel.add(currentAccountRadioButton);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setOpaque(false);

        JButton createButton = new JButton("Create");
        createButton.setBackground(new Color(173, 216, 230));
        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createAccount();
            }
        });

        JButton clearButton = new JButton("Clear");
        clearButton.setBackground(new Color(173, 216, 230));
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearFields();
            }
        });

        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createAccountFrame.dispose();
            }
        });

        buttonPanel.add(createButton);
        buttonPanel.add(clearButton);
        buttonPanel.add(cancelButton);

        createAccountFrame.getContentPane().add(formPanel, BorderLayout.CENTER);
        createAccountFrame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        createAccountFrame.setVisible(true);
        
    }

    private void createAccount() {
        String accountId = accountIdField.getText();
        String password = String.valueOf(passwordField.getPassword());
        String accountName = accountNameField.getText();
        if (savingsAccountRadioButton.isSelected()) {
        } else if (currentAccountRadioButton.isSelected()) {
        } else {
            JOptionPane.showMessageDialog(createAccountFrame, "Please select an account type.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Perform validation checks
        if (accountId.isEmpty() || password.isEmpty() || accountName.isEmpty()) {
            JOptionPane.showMessageDialog(createAccountFrame, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (password.length() < 6) {
            JOptionPane.showMessageDialog(createAccountFrame, "Password must be at least 6 characters long.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Perform account creation logic
        // ...

        // Display success message
        JOptionPane.showMessageDialog(createAccountFrame, "Account created successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);

        // Clear form fields
        clearFields();
    }

    private void clearFields() {
        accountIdField.setText("");
        passwordField.setText("");
        accountNameField.setText("");
        savingsAccountRadioButton.setSelected(false);
        currentAccountRadioButton.setSelected(false);
    }
}
