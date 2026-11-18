
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author User NNA Kopa
 */

public class ProductCalculationsTest 
{

    @Test
    public void GetVat_WithValidData_ReturnsCorrectValue() 
    {
        ProductCalculations calc = new ProductCalculations(3500.0);
        double expectedVat = 525.0;
        assertEquals(expectedVat, calc.GetVAT(), 0.01);
    }

    @Test
    public void GetTotal_WithValidData_ReturnsCorrectValue() 
    {
        ProductCalculations calc = new ProductCalculations(3500.0);
        double expectedTotal = 4200.0;
        assertEquals(expectedTotal, calc.GetTotal(), 0.01);
    }
}