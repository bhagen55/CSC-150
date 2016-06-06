/**
 * Client method for running the converter class
 * @author Blair Hagen
 *
 */
public class Client {

    public static void main(String[] args) {
        Converter converter = new Converter("C:/Users/Blair Hagen/OneDrive/Union Documents/Data Structures/Projects/BlairHagen_Project7Postfix/data/evenmoreinputs.txt");
        converter.convert();
    }
}
