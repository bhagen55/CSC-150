/**
 * Interface for contact objects like Person and Business
 * @author Blair Hagen
 * @version 5-12-2016
 */
public interface Contact extends Comparable<Contact> {

	public String getName ();
	public String getAddress ();
	public String getEmail ();
	public String getPhone ();
	
	public String toString ();
	public String prettyString ();
	
	public int compareTo(Contact c);
	
}
