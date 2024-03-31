import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class TestUtil {
  Util c;

  @Before
  public void setUp() { c = new Util(); }

  @Test
  public void example() { assertTrue(true); }

  @Test
    public void compute_OneArgument_ReturnsFalse() {
        Util util = new Util();
        
        boolean result = util.compute(5);
        
         assertFalse(result);
    }

    @Test
    public void compute_EvenNumberOfArguments_ReturnsFalse() {
        Util util = new Util();
        
        boolean result = util.compute(1, 2, 3, 4);
        
         assertFalse(result);
    }

   @Test
    public void compute_ArgumentEqualToZero_ThrowsRuntimeException() {
        Util util = new Util();
        
        boolean exceptionThrown = false;
        try {
            util.compute(0, 2, 0);
        } catch (RuntimeException e) {
            exceptionThrown = true;
        }
        
        assertTrue(exceptionThrown);
    }

    @Test
    public void compute_SumDivisibleByArgument_ReturnsTrue() {
        Util util = new Util();
        
        boolean result = util.compute(1, 2, 3);
        
        assertTrue(result);
    }

    @Test
    public void compute_NoSumDivisibleByArgument_ReturnsFalse() {
        Util util = new Util();
        
        boolean result = util.compute(3, 6, 5);
        
        assertFalse(result);
    }
}