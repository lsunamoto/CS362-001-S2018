package calendar;

import java.util.Calendar;
import java.util.Random;

import org.junit.Test;
import calendar.Appt;
import calendar.CalDay;
import java.util.LinkedList;
import java.util.GregorianCalendar;
import static org.junit.Assert.*;



/**
 * Random Test Generator  for CalDay class.
 */

public class CalDayRandomTest {
	private static final long TestTimeout = 60 * 500 * 1;
	private static final int NUM_TEST=100;	
    /**
     * Generate Random Tests that tests CalDay Class.
     */
	 @Test
	  public void radnomtest()  throws Throwable  {
		 
	     	long startTime = Calendar.getInstance().getTimeInMillis();
		long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;
		//System.out.println("Start testing CalDay...");

		try{ 
			for(int iteration = 0; elapsed < TestTimeout; iteration++){ 
				long randomseed = System.currentTimeMillis();
				Random random = new Random(randomseed);

				int startHour = ValuesGenerator.getRandomIntBetween(random, -1, 11);
				int startHour2 = ValuesGenerator.getRandomIntBetween(random, 1, 11);	
				int startMinute = ValuesGenerator.getRandomIntBetween(random, -1, 11);
				int startMinute2 = ValuesGenerator.getRandomIntBetween(random, 1, 11);
				int startDay = ValuesGenerator.getRandomIntBetween(random, -1, 1);
				int startDay2 = ValuesGenerator.getRandomIntBetween(random, 1, 1);
				int startMonth = ValuesGenerator.getRandomIntBetween(random, -1, 1);
				int startMonth2 = ValuesGenerator.getRandomIntBetween(random, 1, 1);
				int startYear = ValuesGenerator.getRandomIntBetween(random, -1, 2018);
				int startYear2 = ValuesGenerator.getRandomIntBetween(random, 2018, 2018);
				String title = "Birthday Party";
				String description = "my bday party";
				String emailAddress = "xyz@gmail.com";
				String title2 = "Anniversary Party";
				String description2 = "my anniversary party";
				String emailAddress2 = "abc@gmail.com";
		//	}

				GregorianCalendar cal = new GregorianCalendar(2018,1,1);	
				CalDay cald = new CalDay(cal);
	
				//consturct new appointments with initial data
				Appt appt = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description, emailAddress);
				Appt appt2 = new Appt(startHour2, startMinute2, startDay2, startMonth2, startYear2, title2, description2, emailAddress2);
				//CalDay cald2 = new CalDay();


		//		if(!appt.getValid()){ 
		//			continue;
		//		}
				   //continue;
				
				for(int i=0; i<NUM_TEST; i++){ 
					cald.addAppt(appt);
					cald.addAppt(appt2);
					cald.getFullInfomrationApp(cald);
					cald.isValid();			
					//cald2.addAppt(appt);
					//cald2.isValid();
				}

				elapsed = (Calendar.getInstance().getTimeInMillis()-startTime);
				if((iteration%10000)==0 && iteration!=0)
				   System.out.println("elapsed time: "+ elapsed + " of " +TestTimeout);
			}
		}catch(NullPointerException e){ 
		
		}

	 	System.out.println("Done testing...");
		 
	 }

	 @Test
	  public void radnomtest2()  throws Throwable  {
				long randomseed = System.currentTimeMillis();
				Random random = new Random(randomseed);
				int startHour = ValuesGenerator.getRandomIntBetween(random, -10, -1);
				int startMinute = ValuesGenerator.getRandomIntBetween(random, -10, -1);
				int startDay = ValuesGenerator.getRandomIntBetween(random, -10, -1);
				int startMonth = ValuesGenerator.getRandomIntBetween(random, -10, -1);
				int startYear = ValuesGenerator.getRandomIntBetween(random, -10, 2018);
				String title = "Birthday Party";
				String description = "my bday party";
				String emailAddress = "xyz@gmail.com";
				Appt appt = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description, emailAddress);
				appt.setValid();
				GregorianCalendar cal = new GregorianCalendar(2018,1,1);	
				CalDay cald = new CalDay(cal);

				cald.addAppt(appt);
				cald.isValid();
	  			
	  }



	
}
