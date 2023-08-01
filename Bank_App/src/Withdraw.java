import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Withdraw {
    private JFrame frame;
    private JLabel accountIDLabel;
    private JLabel nameLabel;
    private JLabel accountTypeLabel;
    private JTextField amountField;
    private JButton withdrawButton;
    private JButton returnButton;

    public void displayWithdrawForm(String accountID, String name, String accountType, double balance) {
        frame = new JFrame("Withdraw Form");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 290);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setLayout(null); 

        // Set background image
        ImageIcon backgroundImage = new ImageIcon(getClass().getResource("2.jpg"));
        JLabel backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setBounds(0, 0, frame.getWidth(), frame.getHeight());
        frame.setContentPane(backgroundLabel);

        accountIDLabel = new JLabel("Account ID: " + accountID);
        accountIDLabel.setForeground(Color.WHITE);
        nameLabel = new JLabel("Name: " + name);
        nameLabel.setForeground(Color.WHITE);
        accountTypeLabel = new JLabel("Account Type: " + accountType);
        accountTypeLabel.setForeground(Color.WHITE);
        JLabel currentBalanceLabel = new JLabel("Balance: " + balance);
        currentBalanceLabel.setForeground(Color.WHITE);

        JLabel amountLabel = new JLabel("Amount to Withdraw:");
        amountLabel.setForeground(Color.WHITE);
        amountField = new JTextField();

        withdrawButton = new JButton("Withdraw");
        withdrawButton.setBackground(new Color(173, 216, 230));
        withdrawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double amount = Double.parseDouble(amountField.getText());
                // Perform withdraw operation and update balance

                if (amount <= balance) {
                    double updatedBalance = balance - amount;
                    currentBalanceLabel.setText("Balance: " + updatedBalance);
                    // Show success message
                    JOptionPane.showMessageDialog(frame, "Withdrawal successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    // Show error message if withdrawal amount exceeds balance
                    JOptionPane.showMessageDialog(frame, "Insufficient balance. Please enter a valid amount.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        returnButton = new JButton("Return");
        returnButton.setBackground(new Color(173, 216, 230));
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Close the withdraw form
            }
        });

        accountIDLabel.setBounds(20, 20, 300, 20);
        nameLabel.setBounds(20, 50, 300, 20);
        accountTypeLabel.setBounds(20, 80, 300, 20);
        currentBalanceLabel.setBounds(20, 110, 300, 20);
        amountLabel.setBounds(20, 140, 300, 20);
        amountField.setBounds(20, 170, 150, 20);
        withdrawButton.setBounds(20, 210, 100, 30);
        returnButton.setBounds(130, 210, 80, 30);

        frame.getContentPane().add(accountIDLabel);
        frame.getContentPane().add(nameLabel);
        frame.getContentPane().add(accountTypeLabel);
        frame.getContentPane().add(currentBalanceLabel);
        frame.getContentPane().add(amountLabel);
        frame.getContentPane().add(amountField);
        frame.getContentPane().add(withdrawButton);
        frame.getContentPane().add(returnButton);
        ImageIcon icon = new ImageIcon(getClass().getResource("icon.png"));
        frame.setIconImage(icon.getImage());
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Withdraw withdraw = new Withdraw();
                withdraw.displayWithdrawForm("ACC123", "John Smith", "Savings", 5000.0);
            }
        });
    }
}
