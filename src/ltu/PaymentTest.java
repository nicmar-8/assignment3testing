package ltu;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import java.util.concurrent.ThreadLocalRandom;

public class PaymentTest
{    
    // axiliar instances
    private CalendarFixed calendarFixed;
    private PaymentImpl payment;

    // subsidiary age limits
    private int minimumSubAge = 20;
    private int maxSubAge = 56;

    // loan age limits
    private int maxLoanAge = 47;

    // income limits
    private int fulltimeIncome = 85813;
    private int parttimeIncome = 128722;
    private int income0 = 0;

    // study rate limits
    private int studyRate0 = 0;
    private int studyRate50 = 50;
    private int studyRate100 = 100;

    // completion ratio limits
    private int completionRatio0 = 0;
    private int completionRatio50 = 50;
    private int completionRatio100 = 100;

    // output cases
    private int student100loan = 7088;
    private int student100subsidy = 2816;
    private int student50loan = 3564;
    private int student50subsidy = 1396;
    private int student0loan = 0;
    private int student0subsidy = 0;

    @Test
    public void ageLess20Payment() throws IOException
    {      
        // instance objects
        calendarFixed = new CalendarFixed();
        payment = new PaymentImpl(calendarFixed);

        // fixed personId for age
        String ageLess20 = "19970322-3006"; // <20

        // test
        assertEquals(
            student0loan + student0subsidy,
            payment.getMonthlyAmount(
            ageLess20, 
            ThreadLocalRandom.current().nextInt(income0, parttimeIncome),
            ThreadLocalRandom.current().nextInt(studyRate50, studyRate100),
            ThreadLocalRandom.current().nextInt(completionRatio50, completionRatio100)));
    }

    @Test
    public void ageEquals20Payment() throws IOException
    {      
        // instance objects
        calendarFixed = new CalendarFixed();
        payment = new PaymentImpl(calendarFixed);

        // fixed personId for age
        String ageEquals20 = "19960630-3006";

        // test
        assertEquals(
            student50loan + student50subsidy,
            payment.getMonthlyAmount(
            ageEquals20, 
            ThreadLocalRandom.current().nextInt(income0, parttimeIncome), 
            ThreadLocalRandom.current().nextInt(studyRate50, studyRate100),
            ThreadLocalRandom.current().nextInt(completionRatio50, completionRatio100)));
    }

    @Test
    public void ageMore20Payment() throws IOException
    {      
        // instance objects
        calendarFixed = new CalendarFixed();
        payment = new PaymentImpl(calendarFixed);

        // fixed personId for age
        String ageMore20 = "19950322-3006";

        // test
        assertEquals(
            student50loan + student50subsidy,
            payment.getMonthlyAmount(
            ageMore20, 
            ThreadLocalRandom.current().nextInt(income0, parttimeIncome), 
            ThreadLocalRandom.current().nextInt(studyRate50, studyRate100),
            ThreadLocalRandom.current().nextInt(completionRatio50, completionRatio100)));
    }

    @Test
    public void ageLess56Subsidy() throws IOException
    {      
        // instance objects
        calendarFixed = new CalendarFixed();
        payment = new PaymentImpl(calendarFixed);

        // fixed personId for age
        String ageLess56 = "19610322-3006";

        // test
        assertEquals(
            student0loan + student50subsidy,
            payment.getMonthlyAmount(
            ageLess56, 
            ThreadLocalRandom.current().nextInt(income0, parttimeIncome), 
            ThreadLocalRandom.current().nextInt(studyRate50, studyRate100),
            ThreadLocalRandom.current().nextInt(completionRatio50, completionRatio100)));
    }

    @Test
    public void ageEquals56Subsidy() throws IOException
    {      
        // instance objects
        calendarFixed = new CalendarFixed();
        payment = new PaymentImpl(calendarFixed);

        // fixed personId for age
        String ageLess56 = "19600322-3006";

        // test
        assertEquals(
            student0loan + student50subsidy,
            payment.getMonthlyAmount(
            ageLess56, 
            ThreadLocalRandom.current().nextInt(income0, parttimeIncome), 
            ThreadLocalRandom.current().nextInt(studyRate50, studyRate100),
            ThreadLocalRandom.current().nextInt(completionRatio50, completionRatio100)));
    }

    @Test
    public void ageMore56Subsidy() throws IOException
    {      
        // instance objects
        calendarFixed = new CalendarFixed();
        payment = new PaymentImpl(calendarFixed);

        // fixed personId for age
        String ageLess56 = "19590322-3006";

        // test
        assertEquals(
            student0loan + student0subsidy,
            payment.getMonthlyAmount(
            ageLess56, 
            ThreadLocalRandom.current().nextInt(income0, parttimeIncome), 
            ThreadLocalRandom.current().nextInt(studyRate50, studyRate100),
            ThreadLocalRandom.current().nextInt(completionRatio50, completionRatio100)));
    }
}
