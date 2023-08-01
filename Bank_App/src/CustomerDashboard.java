import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerDashboard {
    private JFrame frame;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                CustomerDashboard customerDashboard = new CustomerDashboard();
                customerDashboard.display("John Smith");
            }
        });
    }

    public void display(String username) {
        frame = new JFrame("Customer Dashboard");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setLayout(null); 

        // Set background image
        ImageIcon backgroundImage = new ImageIcon(getClass().getResource("1.jpg"));
        JLabel backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setBounds(0, 0, frame.getWidth(), frame.getHeight());
        frame.setContentPane(backgroundLabel);

        // Deposit Button
        JButton depositButton = new JButton("Deposit");
        depositButton.setBackground(new Color(192, 192, 192));
        depositButton.setBounds(140, 30, 120, 40); 
        frame.getContentPane().add(depositButton);

        // Withdraw Button
        JButton withdrawButton = new JButton("Withdraw");
        withdrawButton.setBackground(new Color(192, 192, 192));
        withdrawButton.setBounds(140, 90, 120, 40); 
        frame.getContentPane().add(withdrawButton);

        // Transfer Button
        JButton transferButton = new JButton("Transfer");
        transferButton.setBackground(new Color(192, 192, 192));
        transferButton.setBounds(140, 150, 120, 40); 
        frame.getContentPane().add(transferButton);

        // Return to Login Button
        JButton returnButton = new JButton("Return");
        returnButton.setForeground(new Color(255, 255, 255));
        returnButton.setBackground(new Color(0, 128, 128));
        returnButton.setBounds(160, 210, 80, 30); 
        frame.getContentPane().add(returnButton);

        // Action Listener for Deposit Button
        depositButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Deposit depositForm = new Deposit();
                String accountID = getCustomerAccountID(username); 
                String name = username;
                String accountType = getCustomerAccountType(username); 
                double balance = getCustomerBalance(username); 
                depositForm.displayDepositForm(accountID, name, accountType, balance);
            }
        });

        // Action Listener for Withdraw Button
        withdrawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Withdraw withdrawForm = new Withdraw();
                String accountID = getCustomerAccountID(username); 
                String name = username;
                String accountType = getCustomerAccountType(username); 
                double balance = getCustomerBalance(username);
                withdrawForm.displayWithdrawForm(accountID, name, accountType, balance);
            }
        });

        // Action Listener for Transfer Button
        transferButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Transfer transferForm = new Transfer();
                String accountID = getCustomerAccountID(username); 
                String name = username;
                String accountType = getCustomerAccountType(username); 
                double balance = getCustomerBalance(username); 
                transferForm.displayTransferForm(accountID, name, accountType, balance);
            }
        });

        // Action Listener for Return to Login Button
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                BankAppGUI bankApp = new BankAppGUI();
                bankApp.initialize();
            }
        });
        ImageIcon icon = new ImageIcon(getClass().getResource("icon.png"));
        frame.setIconImage(icon.getImage());
        frame.setVisible(true);
    }

    // Placeholder methods
    private static String getCustomerAccountID(String username) {
        return "ACC123";
    }

    private static String getCustomerAccountType(String username) {
        return "Savings";
    }

    private static double getCustomerBalance(String username) {
        return 1000.0;
    }
}
