
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author User NNA Kopa
 */

public class ProductTest 
{

    @Test
    public void GetTotalProductsSold_WithValidData_ReturnsCorrectValue() 
    {
        int[][] sampleData = {{25, 18, 20}, {15, 10, 12}, {18, 15, 20} };
        
        String[] names = {"Cozy Nights Monarch", "Restonic Barbados", "Sealy Phuket"};
        Product product = new Product(sampleData, names);

        int expectedTotal = 153;
        assertEquals(expectedTotal, product.GetTotalProductsSold());
    }

    @Test
    public void GetAverageSales_WithValidData_ReturnsCorrectValue() 
    {
        int[][] sampleData = {{25, 18, 20}, {15, 10, 12}, {18, 15, 20} };
        
        String[] names = {"Cozy Nights Monarch", "Restonic Barbados", "Sealy Phuket"};
        Product product = new Product(sampleData, names);

        double expectedAverage = 17.0; // 153 / 9 months total data points
        assertEquals(expectedAverage, product.GetAverageProductSold(), 0.01);
    }
}