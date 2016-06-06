import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;

public class IndexTests {

    private Index index;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    
    @Before
    public void setUp() throws Exception {
        index = new Index();
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void tearDown() throws Exception {
        index = null;
        System.setOut(null);
    }

    @Test
    public void testPrintIndex() {
        index.createIndexFromFile("data/micro-input.txt");
        String expected = "INDEX:\n"
                          + "======\n"
                          + "and: 2, 4\n"
                          + "another: 3, 4\n"
                          + "final: 5\n"
                          + "more: 2\n"
                          + "new: 2\n"
                          + "some: 1\n"
                          + "the: 5\n"
                          + "this: 1, 2\n"
                          + "with: 1, 2, 5\n"
                          + "words: 1, 2, 5\n"
                          + "yet: 4";        
        index.printIndex();
        assertEquals("Printing the index should look as follows.", expected, outContent.toString().trim());
    }
    
    @Test
    public void testPrintExcludedWords() {
        index.createIndexFromFile("data/micro-input.txt");
        String expected = "DICTIONARY of excluded words:\n"
                          + "=============================\n"
                          + "page";        
        index.printExcludedWords();
        assertEquals("Printing the dictionary of excluded words should look as follows.", expected, outContent.toString().trim());
    }

}
