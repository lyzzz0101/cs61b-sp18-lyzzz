package synthesizer;
import org.junit.Test;
import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void someTest() {
        //ArrayRingBuffer arb = new ArrayRingBuffer(10);
        BoundedQueue x = new ArrayRingBuffer(4);
        x.enqueue(33.1); // 33.1 null null  null
        x.enqueue(44.8); // 33.1 44.8 null  null
        x.enqueue(62.3); // 33.1 44.8 62.3  null
        x.enqueue(-3.4); // 33.1 44.8 62.3 -3.4
        x.dequeue();
        System.out.println(x);
    }

    /** Calls tests for ArrayRingBuffer. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
    }
} 
