package ltu;

import java.util.Calendar;
import java.util.Date;

public class CalendarFixed implements ICalendar
{
	@Override
	public Date getDate() {
		Calendar cal = Calendar.getInstance();

		cal.set(Calendar.HOUR_OF_DAY,23);
		cal.set(Calendar.MINUTE,59);
		cal.set(Calendar.SECOND,59);
		cal.set(Calendar.MILLISECOND,0);
		cal.set(Calendar.YEAR,2016);
		cal.set(Calendar.MONTH,6);
		cal.set(Calendar.DAY_OF_MONTH,30);
		
		return cal.getTime();
	}
}
