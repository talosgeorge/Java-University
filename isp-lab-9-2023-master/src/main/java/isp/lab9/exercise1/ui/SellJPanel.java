package isp.lab9.exercise1.ui;

import isp.lab9.exercise1.services.UserPortfolio;
import isp.lab9.exercise1.utils.Utils;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * todo: implement - it should look similar to the 'Buy' panel
 */
public class SellJPanel extends JPanel {
    private StockMarketJFrame mainFrame;
    private JTextField availableFundsTextField;
    private JComboBox<String> symbolComboBox;
    private JTextField quantityTextField;
    private JTextField costTextField;

    public SellJPanel(StockMarketJFrame mainFrame) {
        this.mainFrame = mainFrame;
        initComponents();
    }

    private void initComponents() {
        setLayout(new GridLayout(2, 2));

        JPanel sellPanel = new JPanel();
        sellPanel.setLayout(new GridLayout(10, 2));

        JLabel availableFundsLabel = new JLabel("Available funds:");
        availableFundsTextField = new JTextField(mainFrame.getPortfolio().getCash().toPlainString() + " $");
        availableFundsTextField.setEditable(false);

        JLabel symbolLabel = new JLabel("Symbol:");
        symbolComboBox = new JComboBox<>();
        if (mainFrame.getPortfolio().getShares().isEmpty()) {
            symbolComboBox.setModel(new DefaultComboBoxModel<>(new String[]{"No stocks to sell"}));
        } else {
            symbolComboBox.setModel(new DefaultComboBoxModel<>(mainFrame.getPortfolio().getShares().keySet().toArray(new String[0])));
        }

        JLabel quantityLabel = new JLabel("Quantity:");
        quantityTextField = new JTextField();

        JLabel costLabel = new JLabel("Total cost:");
        costTextField = new JTextField();
        costTextField.setEditable(false);

        JButton sellButton = new JButton("Sell");
        sellButton.addActionListener(e -> sellStock());

        JButton refreshButton = new JButton("Refresh");
        refreshButton.addActionListener(e -> {
            BigDecimal availableFunds = mainFrame.getPortfolio().getCash();
            availableFundsTextField.setText(Utils.formatBigDecimal(availableFunds) + " $");
            if (mainFrame.getPortfolio().getShares().isEmpty()) {
                symbolComboBox.setModel(new DefaultComboBoxModel<>(new String[]{"No stocks to sell"}));
            } else {
                symbolComboBox.setModel(new DefaultComboBoxModel<>(mainFrame.getPortfolio().getShares().keySet().toArray(new String[0])));
            }
        });

        JButton costButton = new JButton("Get cost");
        costButton.addActionListener(e ->
                calculateTotalCostActionPerformed(symbolComboBox, quantityTextField, costTextField));

        sellPanel.add(availableFundsLabel);
        sellPanel.add(availableFundsTextField);
        sellPanel.add(new JPanel()); // empty cell in the grid
        sellPanel.add(new JPanel()); // empty cell in the grid
        sellPanel.add(symbolLabel);
        sellPanel.add(symbolComboBox);
        sellPanel.add(new JPanel()); // empty cell in the grid
        sellPanel.add(new JPanel()); // empty cell in the grid
        sellPanel.add(quantityLabel);
        sellPanel.add(quantityTextField);
        sellPanel.add(new JPanel()); // empty cell in the grid
        sellPanel.add(new JPanel()); // empty cell in the grid
        sellPanel.add(costLabel);
        sellPanel.add(costTextField);
        sellPanel.add(new JPanel()); // empty cell in the grid
        sellPanel.add(new JPanel()); // empty cell in the grid
        sellPanel.add(costButton);
        sellPanel.add(sellButton);
        sellPanel.add(refreshButton); // add refresh button
        add(sellPanel);
        add(new JPanel()); // empty cell in the grid
        add(new JPanel()); // empty cell in the grid
        add(new JPanel()); // empty cell in the grid
    }

    private void sellStock() {
        UserPortfolio userPortfolio = mainFrame.getPortfolio();
        String symbol = (String) symbolComboBox.getSelectedItem();
        int quantityToSell;
        try {
            quantityToSell = Integer.parseInt(quantityTextField.getText());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                    "Invalid quantity value!",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (userPortfolio.getShares().containsKey(symbol)) {
            int currentQuantity = userPortfolio.getShares().get(symbol);

            if (currentQuantity >= quantityToSell) {
                try {
                    BigDecimal stockPrice = mainFrame.getMarketService().getStockPrice(symbol);
                    BigDecimal totalSaleAmount = stockPrice.multiply(BigDecimal.valueOf(quantityToSell));

                    userPortfolio.setCash(userPortfolio.getCash().add(totalSaleAmount));

                    if (currentQuantity - quantityToSell > 0) {
                        userPortfolio.getShares().put(symbol, currentQuantity - quantityToSell);
                    } else {
                        userPortfolio.getShares().remove(symbol);
                    }

                    availableFundsTextField.setText(Utils.formatBigDecimal(userPortfolio.getCash()) + " $");
                    quantityTextField.setText("");
                    costTextField.setText("");
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(this,
                            "Error getting stock price: " + ex.getMessage(),
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this,
                        "You don't have enough shares to sell!",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this,
                    "You don't own any shares for this symbol!",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Calculates the total transaction cost
     */
    private void calculateTotalCostActionPerformed(JComboBox<String> symbolComboBox,
                                                   JTextField quantityTextField,
                                                   JTextField totalCostTextField) {
        try {
            String symbol = (String) symbolComboBox.getSelectedItem();
            BigDecimal stockPrice = mainFrame.getMarketService().getStockPrice(symbol);

            try {
                int quantity = Integer.parseInt(quantityTextField.getText());
                totalCostTextField.setText(
                        Utils.formatBigDecimal(stockPrice.multiply(new BigDecimal(quantity))));
            } catch (NumberFormatException e) {
                totalCostTextField.setText("Invalid quantity value!");
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this,
                    ex.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(StockMarketJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

