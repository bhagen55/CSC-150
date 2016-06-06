

/**
 * This is a client used to run BenfordTester
 *
 * @author Blair Hagen
 * @version 4-7-2016
 */

public class Client {

    /**
     * Main method. Uses BenfordTester to print the results of
     * graphing librarybooks, livejournal, and sunspots
     */
    public static void main(String[] args) {
        // Creates an object of Type BenfordTester
        BenfordTester benford = new BenfordTester();

        // Analyzing librarybooks.txt
        benford.processFile("data/librarybooks.txt");
        benford.toString();
        benford.graph(30);
        
        System.out.println();
        
        // Analyzing livejournal.txt
        benford.processFile("data/livejournal.txt");
        benford.toString();
        benford.graph(10);
        
        System.out.println();
        
        // Analyzing sunspots.txt
        benford.processFile("data/sunspots.txt");
        benford.toString();
        benford.graph(5);        
    }

}
