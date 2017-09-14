import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;

public class ArrayIteratorTest {

    private String[] array;
    private ArrayIterator<String> stringArrayIterator;


    public ArrayIteratorTest() {
        this.array = new String[]{"1","2","3","4","5"};
        this.stringArrayIterator = new ArrayIterator<>(this.array);
    }

    @Test
    public void nextTest(){
        assertEquals("1",stringArrayIterator.next());
        assertEquals("2",stringArrayIterator.next());
        assertEquals("3",stringArrayIterator.next());
        assertEquals("4",stringArrayIterator.next());
        assertEquals("5",stringArrayIterator.next());
    }

    @Test(expected = NoSuchElementException.class)
    public void nextTestException(){
        stringArrayIterator.next();
        stringArrayIterator.next();
        stringArrayIterator.next();
        stringArrayIterator.next();
        stringArrayIterator.next();
        stringArrayIterator.next();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void nextRemoveException(){
        stringArrayIterator.remove();
    }

}


