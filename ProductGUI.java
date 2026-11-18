
package com.mycompany.productgui;
import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ProductGUI extends JFrame 
{
   private JTextField txtCustomerName, txtPrice;
    private JComboBox<String> cmbProduct;
    
    public ProductGUI() 
    {
        // Configure the main window title, dimensions, close operation, and layout
        // Assisted by Google Gemini in some sections
        setTitle("Product App");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JMenuBar menuBar = new JMenuBar();
        JMenu menuFile = new JMenu("File");
        JMenuItem itemExit = new JMenuItem("Exit");
        menuFile.add(itemExit);

        JMenu menuTools = new JMenu("Tools");
        JMenuItem itemProcess = new JMenuItem("Process");
        JMenuItem itemClear = new JMenuItem("Clear");
        menuTools.add(itemProcess);
        menuTools.add(itemClear);

        menuBar.add(menuFile);
        menuBar.add(menuTools);
        setJMenuBar(menuBar);

        JLabel lblCustomer = new JLabel("Customer Name:");
        lblCustomer.setBounds(20, 30, 120, 25);
        add(lblCustomer);

        txtCustomerName = new JTextField();
        txtCustomerName.setBounds(150, 30, 200, 25);
        add(txtCustomerName);

        JLabel lblProduct = new JLabel("Select Product:");
        lblProduct.setBounds(20, 70, 120, 25);
        add(lblProduct);

        String[] products = {"Cozy Nights Monarch", "Restonic Barbados", "Sealy Phuket"};
        cmbProduct = new JComboBox<>(products);
        cmbProduct.setBounds(150, 70, 200, 25);
        add(cmbProduct);

        // Created the price label and text field for inputting the product price
        JLabel lblPrice = new JLabel("Enter Price:");
        lblPrice.setBounds(20, 110, 120, 25);
        add(lblPrice);

        txtPrice = new JTextField();
        txtPrice.setBounds(150, 110, 200, 25);
        add(txtPrice);

        // Add3ed the main PROCESS button to trigger the calculations
        JButton btnProcess = new JButton("PROCESS");
        btnProcess.setBounds(20, 160, 330, 30);
        add(btnProcess);

        btnProcess.addActionListener(e -> processOrder());
        itemProcess.addActionListener(e -> processOrder());
        itemClear.addActionListener(e -> clearForm());
        itemExit.addActionListener(e -> System.exit(0));
    }

    private void processOrder() 
    {
        //Assisted by Google Gemini
        try 
        {
            // Retrieved the user inputs from the GUI fields
            String customerName = txtCustomerName.getText();
            String productName = (String) cmbProduct.getSelectedItem();
            double price = Double.parseDouble(txtPrice.getText());

            // I instantiated the ProductCalculations class to compute VAT, commission, and total
            ProductCalculations calc = new ProductCalculations(price);
            double vat = calc.GetVAT();
            double commission = calc.GetCommission();
            double total = calc.GetTotal();

            // Formatted to display the results in a pop-up message dialog
            String message = String.format
            (
                "Customer Name: %s\nProduct: %s\nVAT: R %.1f\nCOMMISSION: R %.1f\nTOTAL: R %.1f",
                customerName, productName, vat, commission, total
            );
            JOptionPane.showMessageDialog(this, message, "Message", JOptionPane.INFORMATION_MESSAGE);

            // Append the transaction details to the data.txt log file
            try (PrintWriter writer = new PrintWriter(new FileWriter("data.txt", true))) 
            {
                writer.println("DATA LOG");
                writer.println("**************************************************");
                writer.println("Customer Name: " + customerName);
                writer.println("Product: " + productName);
                writer.printf("VAT: R %.1f\n", vat);
                writer.printf("COMMISSION: R %.1f\n", commission);
                writer.printf("TOTAL: R %.1f\n", total);
                writer.println("**************************************************");
            } 
            catch (IOException ex) 
            {
                JOptionPane.showMessageDialog(this, "Error saving to file!", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } 
        catch (NumberFormatException ex) 
        {
            JOptionPane.showMessageDialog(this, "Please enter a valid numeric price.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearForm() 
    {
        txtCustomerName.setText("");
        txtPrice.setText("");
        cmbProduct.setSelectedIndex(0);
    }

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(() -> new ProductGUI().setVisible(true));
    }
}