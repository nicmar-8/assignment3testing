package ltu;

// fix: added exception
import java.lang.reflect.InvocationTargetException;

public class CalendarFactory
{

    private static ICalendar calendar = null;

    public static ICalendar getCalendar()
    {
        String className = System.getProperty("calendar", "ltu.CalendarImpl");
        return initCalendar(className);
    }

    public static ICalendar getCalendar(String className) {
        return initCalendar(className);
    }

    private static ICalendar initCalendar(String className) {
        try
        {
            // fix: method newInstance deprecated so added getDeclaredConstructor() and exceptions
            calendar = (ICalendar) Class.forName(className).getDeclaredConstructor().newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e)
        {
            e.printStackTrace();
        }
        return calendar;
    }
}