
package com.mycompany.salesreportapp;

/**
 *
 * @author User NNA Kopa
 */

public class PrintProduct 
{
    private IProducts productObj;

    public PrintProduct(IProducts productObj) 
    {
        this.productObj = productObj;
    }

    public void printTotalSales() 
    {
        System.out.println("TOTAL PRODUCT SALES: " + productObj.GetTotalProductsSold());
    }

    public void printAverageSales() 
    {
        System.out.println("AVERAGE PRODUCT SALES: " + productObj.GetAverageProductSold());
    }

    public void printMostPopularProduct() 
    {
        System.out.println("MOST POPULAR PRODUCT: " + productObj.GetMostPopularProduct());
    }
}
