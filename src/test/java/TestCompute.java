import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.Test;

public class TestCompute {
  Compute c;

  @Test
  public void example() {
    MessageQueue mq = mock(MessageQueue.class);
    c = new Compute(mq);
    assertTrue(true);
  }

  @Test
    public void countNumberOfOccurrences_EmptyQueue_ReturnsMinus1() {
        MessageQueue mq = mock(MessageQueue.class);
        when(mq.size()).thenReturn(0);
        Compute compute = new Compute(mq);
        
        int result = compute.countNumberOfOccurrences("test");
        
        assertEquals(-1, result);
    }

    @Test
    public void countNumberOfOccurrences_ElementNotPresent_Returns0() {
        MessageQueue mq = mock(MessageQueue.class);
        when(mq.size()).thenReturn(1); // Assuming non-empty queue
        when(mq.contains(anyString())).thenReturn(false);
        Compute compute = new Compute(mq);
        
        int result = compute.countNumberOfOccurrences("test");
        
        assertEquals(0, result);
    }

    @Test
    public void countNumberOfOccurrences_ElementPresent_ReturnsCount() {
        MessageQueue mq = mock(MessageQueue.class);
        when(mq.size()).thenReturn(3); // Assuming queue with 3 elements
        when(mq.contains(anyString())).thenReturn(true);
        when(mq.getAt(anyInt())).thenReturn("test");
        Compute compute = new Compute(mq);
        
        int result = compute.countNumberOfOccurrences("test");
        
        assertEquals(3, result);
    }

   @Test
    public void countNumberOfOccurrences_MultipleOccurrencesOfElement_ReturnsCount() {
        MessageQueue mq = mock(MessageQueue.class);
        when(mq.size()).thenReturn(5); // Assuming queue with 5 elements
        when(mq.contains(anyString())).thenReturn(true);
        when(mq.getAt(0)).thenReturn("test");
        when(mq.getAt(1)).thenReturn("another");
        when(mq.getAt(2)).thenReturn("test");
        when(mq.getAt(3)).thenReturn("another");
        when(mq.getAt(4)).thenReturn("test");
        
        Compute compute = new Compute(mq);
        
        int result = compute.countNumberOfOccurrences("test");
        
         assertEquals(3, result);
    }
}