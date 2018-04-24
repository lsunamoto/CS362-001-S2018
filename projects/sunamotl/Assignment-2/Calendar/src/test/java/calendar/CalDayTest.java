/** A JUnit test class to test the class CalDay. */

package calendar;

import org.junit.Test;
import static org.junit.Assert.*;
import calendar.Appt;
import calendar.CalDay;
//import calendar.CalendarMain;
import java.util.GregorianCalendar;
import java.util.LinkedList;

public class CalDayTest{

   
  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
     	CalDay cald0 = new CalDay();
	cald0.isValid();
  }

  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
	GregorianCalendar cal = new GregorianCalendar(2018,5,5);
     	CalDay cald1 = new CalDay(cal);
  	assertEquals(5,cald1.getDay());
	assertEquals(6,cald1.getMonth());
	assertEquals(2018,cald1.getYear());
	String string0 = cald1.toString();
	//assertEquals("5/5/2018\t --- 5 ---\n",string0);
  	String string1 = cald1.getFullInfomrationApp(cald1);
  	assertEquals("6-5-2018 ",string1);
  	Appt appt0 = new Appt(10,30,5,5,2018,"bday party","my bday party", "blah@gmail.com");
  	Appt appt1 = new Appt(10,30,6,5,2018,"bday party","my bday party", "blah@gmail.com");
	cald1.addAppt(appt0);
	cald1.addAppt(appt1);
  	cald1.getFullInfomrationApp(cald1);
	assertTrue(cald1.isValid());
  	
  }

  @Test(timeout = 4000)
  public void test02() throws Throwable { 
  	CalDay cald2 = new CalDay();
	assertFalse(cald2.isValid());
  }     


}
