

/**
 * This is a second, special client that runs tests on the BenfordTester code.
 *
 * @author Kristina Striegnitz
 * @version Dec. 9, 2015
 */

public class TestTheBenfordTester {

    private static void testConstructor() {
        BenfordTester benford = new BenfordTester();

        String msg = "When a BenfordTester object has been created and assigned to\n"
                + "a variable the variable should not be null";
        Testing.assertEquals(msg, benford == null, false);

        msg = "The BenfordTester object is newly created. No file has been\nprocessed yet.";
        Testing.assertEquals(msg, "No data file has been read, yet.",
                benford.toString());
    }

    private static void testFileProcessing() {
        BenfordTester benford = new BenfordTester();

        benford.processFile("data/test.txt");
        String msg = "This test file contains: 20 each of 100, 36, 4000, 5, 6, 7.8, 8, 9";
        String expected = "data/test.txt:\n" + "0: 0\n" + "1: 20\n" + "2: 0\n"
                + "3: 20\n" + "4: 20\n" + "5: 20\n" + "6: 20\n" + "7: 20\n"
                + "8: 20\n" + "9: 20\n";
        Testing.assertEquals(msg, expected, benford.toString());

        benford.processFile("data/test2.txt");
        msg = "The second test file contains the same, just in a different order";
        expected = "data/test2.txt:\n" + "0: 0\n" + "1: 20\n" + "2: 0\n"
                + "3: 20\n" + "4: 20\n" + "5: 20\n" + "6: 20\n" + "7: 20\n"
                + "8: 20\n" + "9: 20\n";
        Testing.assertEquals(msg, expected, benford.toString());
    }

    private static void testGraphing() {
        BenfordTester benford = new BenfordTester();
        benford.processFile("data/test.txt");

        String msg = "This is what the graph for data/test.txt should like when using\n"
                + "one asterisk to represent 3 occurrences of the digit";
        System.out.println(msg);
        System.out.println("expected:");
        System.out.println(
                "File: data/test.txt\n" + "frequency of the lead digit\n"
                        + "---------------------------\n" + "0:\n"
                        + "1: *******\n" + "2:\n" + "3: *******\n"
                        + "4: *******\n" + "5: *******\n" + "6: *******\n"
                        + "7: *******\n" + "8: *******\n" + "9: *******\n");
        System.out.println("actual:");
        benford.graph(3);
    }

    /**
     * The main method.
     * 
     * @param args
     */
    public static void main(String[] args) {
        Testing.setVerbose(true);
        
        Testing.startTests();

        Testing.testSection("Testing the constructor");
        testConstructor();

        Testing.testSection("Testing file processing");
        testFileProcessing();

        Testing.testSection("Testing graphing");
        testGraphing();
        
        Testing.finishTests();
    }

}
