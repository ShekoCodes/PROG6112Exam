
package com.mycompany.salesreportapp;

/**
 *
 * @author User NNA Kopa 
 */

public class Product implements IProducts 
{
    // This part is the 2D Array in order to store sales data for 3 products over 3 months
    private int[][] salesData;
    private String[] productNames;

    public Product(int[][] salesData, String[] productNames) 
    {
        this.salesData = salesData;
        this.productNames = productNames;
    }

    @Override
    public int GetTotalProductsSold() 
    {
        int total = 0;
        for (int i = 0; i < salesData.length; i++) {
            for (int j = 0; j < salesData[i].length; j++) 
            {
                total += salesData[i][j];
            }
        }
        return total;
    }

    @Override
    public double GetAverageProductSold() 
    {
        int total = GetTotalProductsSold();
        int count = 0;
        for (int i = 0; i < salesData.length; i++) 
        {
            count += salesData[i].length;
        }
        return (double) total / count;
    }

    @Override
    public String GetMostPopularProduct() 
    {
        int maxSales = -1;
        int maxIndex = 0;

        for (int i = 0; i < salesData.length; i++) 
        {
            int productTotal = 0;
            for (int j = 0; j < salesData[i].length; j++) 
            {
                productTotal += salesData[i][j];
            }
            if (productTotal > maxSales) 
            {
                maxSales = productTotal;
                maxIndex = i;
            }
        }
        return productNames[maxIndex] + " (" + maxSales + ")";
    }
}
