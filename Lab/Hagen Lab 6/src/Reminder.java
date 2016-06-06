/** 
 * A reminder is similar to an Event but it
 * lacks a start and end time but still has a
 * date.
 * 
 * @author Chris Fernandes and Blair Hagen
 * @version 5/5/16
 */
public class Reminder implements AgendaItem
{
    private String msg;
    private String date;

    private static final int NUM_PARTS = 3;
    private static final int MONTH_PART = 0;
    private static final int DAY_PART = 1;
    private static final int YEAR_PART = 2;
    
    /**
     * Creates a reminder
     *
     * @param msg The text of the reminder
     * @param date The date of the reminder (in mm/dd/yyyy format)
     */
    public Reminder(String msg, String date)
    {
        this.msg = msg;
        this.date = date;
    }
    
    /**
     * @return the Reminder as a String
     */
    public String toString()
    {
        return msg + " "  + date;
    }

    /**
     * @return the month of the reminder
     */
    public int getMonth()
    {
        return getDateParts()[MONTH_PART];    
    }

    /**
     * @return the day of the reminder
     */
    public int getDay()
    {
        return getDateParts()[DAY_PART];    
    }

    /**
     * @return the year of the reminder
     */
    public int getYear()
    {
        return getDateParts()[YEAR_PART];
    }

    /**
     * Parses the date string to determine the 3 integer values for
     * month, day, and year.
     *
     * @return an array of 3 ints in the order {month, day, year}
     */
    private int[] getDateParts()
    {
        int[] intParts = new int[NUM_PARTS];
        String[] stringParts = date.split("/");

        for (int i = 0; i < stringParts.length; i++) {
            intParts[i] = Integer.valueOf(stringParts[i]).intValue();
        }

        return intParts;
    }
    
    /** 
     * Compares this reminder with otherEvent (agendaItem) to see which one is earlier.
     * 
     * @param otherEvent the agendaItem to compare with
     * @return 1 if this event is later than otherEvent,
     * -1 if this event is earlier than otherEvent, 
     * or 0 if the two events occur on exactly the same 
     * day with the exact same START time.
     */
    public int compareTo(AgendaItem otherEvent)
    {
    	if (getYear() > otherEvent.getYear()) {
    		return 1;
    	} else if (getYear() < otherEvent.getYear()) {
    		return -1;
    	} else if (getMonth() > otherEvent.getMonth()) {
    		return 1;
    	} else if (getMonth() < otherEvent.getMonth()) {
    		return -1;
    	} else if (getDay() > otherEvent.getDay()) {
    		return 1;
    	} else if (getDay() < otherEvent.getDay()) {
    		return -1;
    	} else {
    		if (otherEvent instanceof Event)
    		{
    			return -1;
    		}
    		else
    		{
    			return 0;
    		}
    	}
    }
}
