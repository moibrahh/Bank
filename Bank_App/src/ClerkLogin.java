import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import java.util.ArrayList;
import java.awt.Color;
import javax.swing.UIManager;

public class ClerkLogin {
    // Check if the clerk login is valid
    public boolean isLoginValid(String username, String password) {
        // Validate the clerk account
        if (username.equals("Admin") && password.equals("123456")) {
            return true;
        }
        return false;
    }

    // Open the clerk dashboard
    /**
     * @wbp.parser.entryPoint
     */
    public void openClerkDashboard() {
        JFrame clerkFrame = new JFrame("Clerk Dashboard");
        clerkFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        clerkFrame.setSize(327, 245); // Set the window size to 327x245 pixels
        clerkFrame.setLocationRelativeTo(null);

        // Background Image
        ImageIcon backgroundImageIcon = new ImageIcon(getClass().getResource("login-background.png"));
        Image backgroundImage = backgroundImageIcon.getImage().getScaledInstance(327, 245, Image.SCALE_SMOOTH);
        JLabel backgroundLabel = new JLabel(new ImageIcon(backgroundImage));
        clerkFrame.setContentPane(backgroundLabel);

        // Welcome Message
        JLabel welcomeLabel = new JLabel("Welcome, Clerk!");
        welcomeLabel.setForeground(Color.WHITE);
        welcomeLabel.setHorizontalAlignment(JLabel.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 20));

        // Buttons Panel
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setBackground(new Color(0, 0, 128));
        buttonsPanel.setForeground(new Color(0, 0, 0));

        // Left Panel for buttons on the left side
        JPanel leftPanel = new JPanel(new GridLayout(3, 1, 10, 10));
        leftPanel.setBackground(Color.BLACK);
        leftPanel.setBounds(0, 0, 155, 149);

        // Create Account Button
        JButton createAccountButton = new JButton("Create Account");
        createAccountButton.setForeground(Color.BLACK);
        createAccountButton.setBackground(UIManager.getColor("Button.background"));
        createAccountButton.setFont(new Font("Arial", Font.PLAIN, 14));
        createAccountButton.setPreferredSize(new Dimension(126, 20));
        createAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CreateAccount createAccount = new CreateAccount();
                createAccount.openCreateAccountForm();
            }
        });
        leftPanel.add(createAccountButton);

        // Accounts Query Button
        JButton accountsQueryButton = new JButton("Accounts Query");
        accountsQueryButton.setFont(new Font("Arial", Font.PLAIN, 14));
        accountsQueryButton.setPreferredSize(new Dimension(126, 20));
        accountsQueryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<Account> accounts = generateAccounts(); // Retrieve accounts
                AccountQuery accountQuery = new AccountQuery(accounts);
                accountQuery.displayAccountInformation();
            }
        });
        leftPanel.add(accountsQueryButton);

        // Statistical Analysis Button
        JButton statisticalAnalysisButton = new JButton("Statistical Analysis");
        statisticalAnalysisButton.setFont(new Font("Arial", Font.PLAIN, 14));
        statisticalAnalysisButton.setPreferredSize(new Dimension(126, 20));
        statisticalAnalysisButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<Account> accounts = generateAccounts(); // Retrieve accounts
                StatisticalAnalysis statisticalAnalysis = new StatisticalAnalysis(accounts);
                statisticalAnalysis.displayStatistics();
            }
        });
        buttonsPanel.setLayout(null);
        leftPanel.add(statisticalAnalysisButton);

        buttonsPanel.add(leftPanel);

        // Right Panel for buttons on the right side
        JPanel rightPanel = new JPanel(new GridLayout(3, 1, 10, 10));
        rightPanel.setBackground(Color.BLACK);
        rightPanel.setBounds(155, 0, 155, 149);

        // Deposit Money Button
        JButton depositMoneyButton = new JButton("Deposit Money");
        depositMoneyButton.setFont(new Font("Arial", Font.PLAIN, 14));
        depositMoneyButton.setPreferredSize(new Dimension(126, 20));
        depositMoneyButton.setEnabled(false); // Disable the button
        rightPanel.add(depositMoneyButton);

        // Withdraw Money Button
        JButton withdrawMoneyButton = new JButton("Withdraw Money");
        withdrawMoneyButton.setFont(new Font("Arial", Font.PLAIN, 14));
        withdrawMoneyButton.setPreferredSize(new Dimension(126, 20));
        withdrawMoneyButton.setEnabled(false); // Disable the button
        rightPanel.add(withdrawMoneyButton);

        // Transfer Money Button
        JButton transferMoneyButton = new JButton("Transfer Money");
        transferMoneyButton.setFont(new Font("Arial", Font.PLAIN, 14));
        transferMoneyButton.setPreferredSize(new Dimension(126, 20));
        transferMoneyButton.setEnabled(false); // Disable the button
        rightPanel.add(transferMoneyButton);

        buttonsPanel.add(rightPanel);

        clerkFrame.getContentPane().setLayout(new BorderLayout());
        clerkFrame.getContentPane().add(welcomeLabel, BorderLayout.NORTH);
        clerkFrame.getContentPane().add(buttonsPanel, BorderLayout.CENTER);

        // Re-Login Button
        JButton reloginButton = new JButton("Re-Login");
        reloginButton.setBackground(new Color(173, 216, 230));
        reloginButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        reloginButton.setHorizontalTextPosition(SwingConstants.CENTER);
        reloginButton.setFont(new Font("Arial", Font.PLAIN, 12));
        reloginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clerkFrame.dispose(); // Close the clerk dashboard window
                BankAppGUI bankApp = new BankAppGUI();
                bankApp.initialize(); // Open the login page
            }
        });
        

        JPanel reloginPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        reloginPanel.setBackground(new Color(0, 0, 0));
        reloginPanel.setForeground(Color.DARK_GRAY);
        reloginPanel.add(reloginButton);
        clerkFrame.getContentPane().add(reloginPanel, BorderLayout.SOUTH);

        clerkFrame.setVisible(true);
    }

    private ArrayList<Account> generateAccounts() {
        ArrayList<Account> accountList = new ArrayList<>();

        String[] names = {
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
        };

        double[] balances = {
                5000.0,
                3000.0,
                7000.0,
                4000.0,
                6000.0,
                9000.0,
                2000.0,
                8000.0,
                10000.0,
                3500.0
        };

        for (int i = 0; i < names.length; i++) {
            String accountID = "ACC" + (i + 1);
            String accountName = names[i];
            double balance = balances[i];

            Account account = new Account(accountID, accountName, balance);
            accountList.add(account);
        }

        return accountList;
    }

    public static void main(String[] args) {
        ClerkLogin clerkLogin = new ClerkLogin();
        clerkLogin.openClerkDashboard();
    }
}
