import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class StatisticalAnalysis extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Account> accounts;
    private JPanel statisticsPanel;
    private JLabel accountsLabel;
    private JLabel totalBalanceLabel;
    private JLabel averageBalanceLabel;

    public StatisticalAnalysis(ArrayList<Account> accounts) {
        this.accounts = accounts;

        setTitle("Statistical Analysis");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        createStatisticsPanel();
        setContentPane(new JLabel(new ImageIcon(getClass().getResource("background.jpg"))));
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(statisticsPanel, BorderLayout.CENTER);

        createReturnButton();
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        bottomPanel.setOpaque(false);
        bottomPanel.add(returnButton);
        getContentPane().add(bottomPanel, BorderLayout.SOUTH);

        // Set a fixed size for the frame
        setSize(416, 263);

        pack();
    }

    public void displayStatistics() {
        // Count the number of accounts
        int numAccounts = accounts.size();

        // Calculate the total balance
        double totalBalance = 0;
        for (Account account : accounts) {
            totalBalance += account.getBalance();
        }

        // Calculate the average balance
        double averageBalance = totalBalance / numAccounts;

        // Format the balance values
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
        String formattedTotalBalance = decimalFormat.format(totalBalance);
        String formattedAverageBalance = decimalFormat.format(averageBalance);

        // Update the labels with the statistics
        accountsLabel.setText("Number of Accounts: " + numAccounts);
        totalBalanceLabel.setText("Total Balance: $" + formattedTotalBalance);
        averageBalanceLabel.setText("Average Balance: $" + formattedAverageBalance);

        setVisible(true);
    }

    private void createStatisticsPanel() {
        statisticsPanel = new JPanel();
        statisticsPanel.setLayout(new GridLayout(3, 1));
        statisticsPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        statisticsPanel.setOpaque(false);

        accountsLabel = new JLabel("Number of Accounts: ");
        accountsLabel.setForeground(new Color(255, 255, 255));
        totalBalanceLabel = new JLabel("Total Balance: ");
        totalBalanceLabel.setForeground(new Color(255, 255, 255));
        averageBalanceLabel = new JLabel("Average Balance: ");
        averageBalanceLabel.setForeground(new Color(255, 255, 255));

        statisticsPanel.add(accountsLabel);
        statisticsPanel.add(totalBalanceLabel);
        statisticsPanel.add(averageBalanceLabel);
    }

    private JButton returnButton;

    private void createReturnButton() {
        returnButton = new JButton("Return");
        returnButton.setBackground(new Color(173, 216, 230));
        returnButton.setPreferredSize(new Dimension(80, 25)); 
        returnButton.addActionListener(e -> dispose());
    }
}
