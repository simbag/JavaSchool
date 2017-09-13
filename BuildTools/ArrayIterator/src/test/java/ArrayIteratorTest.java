import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;

public class ArrayIteratorTest {

    private String[] array;
    private ArrayIterator<String> integerArrayIterator;


    public ArrayIteratorTest() {
        this.array = new String[]{"1","2","3","4","5"};
        this.integerArrayIterator = new ArrayIterator<>(this.array);
    }

    @Test
    public void nextTest(){
        assertEquals("1",integerArrayIterator.next());
        assertEquals("2",integerArrayIterator.next());
        assertEquals("3",integerArrayIterator.next());
        assertEquals("4",integerArrayIterator.next());
        assertEquals("5",integerArrayIterator.next());
    }

    @Test(expected = NoSuchElementException.class)
    public void nextTestException(){
        integerArrayIterator.next();
        integerArrayIterator.next();
        integerArrayIterator.next();
        integerArrayIterator.next();
        integerArrayIterator.next();
        integerArrayIterator.next();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void nextRemoveException(){
        integerArrayIterator.remove();
    }

}


