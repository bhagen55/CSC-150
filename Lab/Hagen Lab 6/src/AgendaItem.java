/**
 * Interface between Event and Reminder classes
 * 
 * @author Blair Hagen
 * @version 5-5-2016
 *
 */


public interface AgendaItem {
	
/**
 * Returns string representation of agendaItem
 * The output of an Event will have a start/end time,
 * the output of a reminder will not.
 * @return 
 * 		"name  month/day/year  start-end" If the object is an Event
 * 		"name  month/day/year" If the object is a Reminder
 */
public String toString();

/**
 * Returns the month of the agendaItem.
 * Makes no difference if the agendaItem is an event or a reminder
 * @return month
 * 		month of agendaItem as an integer
 */
public int getMonth();

/**
 * Returns the day of the agendaItem.
 * Makes no difference if the agendaItem is an event or a reminder
 * @return day
 * 		day of agendaItem as an integer
 */
public int getDay();

/**
 * Returns the year of the agendaItem.
 * Makes no difference if the agendaItem is an event or a reminder
 * @return year
 * 		year of agendaItem as an integer
 */

public int getYear();
/**
 * Returns -1, 0, or 1 depending on if the agenda item is earlier, later, or
 * at the same time as otherItem. If the two objects are events, dates and
 * start times are used to determine their relationship. If two objects are
 * reminders, just the dates of the two are used. If one object is an event
 * and the other a reminder and they have the same date, the reminder will 
 * always come before the event and 0 will never be returned.
 * 
 * @param otherItem
 * 		the reminder/event to compare this object to
 * @return 
 * 		-1 if this AgendaItem is earlier than otherItem
 * 		0 if the two are concurrent
 * 		1 if this AgendaItem is later than otherItem
 */
public int compareTo(AgendaItem otherItem);
}
