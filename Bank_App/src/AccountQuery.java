import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class AccountQuery {
    private List<Account> accounts;
    private JFrame frame;
    private JTextField searchField;
    private JButton searchButton;

    public AccountQuery(List<Account> accounts) {
        this.accounts = accounts;
    }

    public void displayAccountInformation() {
        String[] columnNames = {"Account ID", "Account Name", "Balance"};

        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        for (Account account : accounts) {
            Object[] rowData = {account.getAccountID(), account.getAccountName(), account.getBalance()};
            tableModel.addRow(rowData);
        }

        JTable table = new JTable(tableModel);
        table.setBackground(new Color(176, 196, 222));
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBackground(new Color(135, 206, 250));
        scrollPane.setPreferredSize(new Dimension(580, 250)); 

        frame = new JFrame("Account Query");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);

        // Background Image
        ImageIcon backgroundImageIcon = new ImageIcon(getClass().getResource("login-background.png"));
        Image backgroundImage = backgroundImageIcon.getImage().getScaledInstance(600, 400, Image.SCALE_SMOOTH);
        JLabel backgroundLabel = new JLabel(new ImageIcon(backgroundImage));
        frame.setContentPane(backgroundLabel);

        frame.getContentPane().setLayout(new BorderLayout());

        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        topPanel.setOpaque(false);
        JLabel searchLabel = new JLabel("NAME/ID:");
        searchLabel.setForeground(new Color(255, 255, 255));
        searchField = new JTextField(20);
        searchButton = new JButton("Search");
        searchButton.setBackground(new Color(192, 192, 192));
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchValue = searchField.getText();
                searchAccounts(searchValue);
            }
        });

        topPanel.add(searchLabel);
        topPanel.add(searchField);
        topPanel.add(searchButton);

        frame.getContentPane().add(topPanel, BorderLayout.NORTH);
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setOpaque(false);

        JButton returnButton = new JButton("Return");
        returnButton.setBackground(new Color(173, 216, 230));
        returnButton.setPreferredSize(new Dimension(80, 30));
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                ClerkLogin clerkLogin = new ClerkLogin();
                clerkLogin.openClerkDashboard();
            }
        });
        ImageIcon icon = new ImageIcon(getClass().getResource("icon.png"));
        frame.setIconImage(icon.getImage());
        buttonPanel.add(returnButton);
        frame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    private void searchAccounts(String searchValue) {
        DefaultTableModel tableModel = (DefaultTableModel) ((JTable) ((JViewport) ((JScrollPane)
                frame.getContentPane().getComponent(1)).getComponent(0)).getComponent(0)).getModel();
        tableModel.setRowCount(0);

        for (Account account : accounts) {
            if (account.getAccountName().toLowerCase().contains(searchValue.toLowerCase())) {
                Object[] rowData = {account.getAccountID(), account.getAccountName(), account.getBalance()};
                tableModel.addRow(rowData);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                List<Account> accounts = generateAccounts();
                AccountQuery accountQuery = new AccountQuery(accounts);
                accountQuery.displayAccountInformation();
            }
        });
    }

    private static List<Account> generateAccounts() {
        List<Account> accountList = new ArrayList<>();

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
                4000.0,
                3500.0,
                700.0,
                4000.0,
                6000.0,
                9000.0,
                2000.0,
                8000.0,
                1000.0,
                800.0
        };

        for (int i = 0; i < names.length; i++) {
            String accountID = "2020530" + (i + 1);
            String accountName = names[i];
            double balance = balances[i];

            Account account = new Account(accountID, accountName, balance);
            accountList.add(account);
        }

        return accountList;
    }
}
