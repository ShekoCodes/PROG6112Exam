
package com.mycompany.salesreportapp;
import java.util.Scanner;

/**
 *
 * @author User NNA Kopa
 */

public class SalesReportApp 
{
    public static void main(String[] args) 
    {
        // Initialized a Scanner object to capture user inputs from the console
        Scanner scanner = new Scanner(System.in);

        String[] productNames = { "Cozy Nights Monarch", "Restonic Barbados", "Sealy Phuket" };
        
        // Created 2D array to store sales data for each product across three months
        int[][] sales = new int[3][3];

        // Loop through each product and prompt the user for sales data over 3 months
        for (int i = 0; i < productNames.length; i++) 
        {
            for (int j = 0; j < 3; j++) 
            {
                System.out.print("Enter number of sales for month " + (j + 1) + " for " + productNames[i] + ": ");
                sales[i][j] = scanner.nextInt();
            }
        }

        // The final sales report output
        System.out.println("\nPRODUCT SALES REPORT - 2026");
        System.out.println("**************************************************");

        Product product = new Product(sales, productNames);

        PrintProduct printer = new PrintProduct(product);

        // Invoked the methods to print total sales, average sales, and the most popular product
        printer.printTotalSales();
        printer.printAverageSales();
        printer.printMostPopularProduct();
    }
}

