/** A JUnit test class to test the class CalDay. */

package calendar;

import org.junit.Test;
import static org.junit.Assert.*;
import calendar.Appt;
import calendar.CalDay;
//import calendar.CalendarMain;
import java.util.GregorianCalendar;
import java.util.LinkedList;

public class CalDayTest {

   
  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
     	CalDay cald0 = new CalDay();
	cald0.isValid();
  	assertNull(cald0.iterator());
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
	//assertNotNull(cald1.getAppts());//lc
	//assertNotNull(string1);//lc	
  	
  }

    @Test(timeout = 4000) 
    public void test0b() throws Throwable { 
       //year,month,day
	GregorianCalendar cal = new GregorianCalendar(2018,5,5);
     	CalDay cald1 = new CalDay(cal);
	
  //hour,min,day,month,year...
	cald1.getFullInfomrationApp(cald1);
	assertTrue(cald1.isValid());
	String s1 = cald1.toString();
	assertNotNull(s1);
	assertEquals("\t --- 7/5/2018 --- \n --- -------- Appointments ------------ --- \n\n",s1);
    } 

  @Test(timeout = 4000)
  public void test0c()  throws Throwable  {
  	//CalDay cald1 = new CalDay();
	GregorianCalendar cal = new GregorianCalendar(2018,5,5);
     	CalDay cald1 = new CalDay(cal);
     	Appt appt0 = new Appt(12,30,5,5,2018,"bday party","my bday party", "blah@gmail.com");
  	Appt appt1 = new Appt(0,30,6,5,2018,"bday party","my bday party", "blah@gmail.com");
	cald1.addAppt(appt0);
	cald1.addAppt(appt1);
  	String s1 = cald1.getFullInfomrationApp(cald1);
	assertEquals("6-5-2018 \n\t12:30AM bday party my bday party \n\t0:30AM bday party my bday party ",s1);
	//assertTrue(cald1.isValid());
  }
  
  @Test(timeout = 4000)
  public void test0d()  throws Throwable  {
  	//CalDay cald1 = new CalDay();
	GregorianCalendar cal = new GregorianCalendar(2018,5,5);
     	CalDay cald1 = new CalDay(cal);
     	Appt appt1 = new Appt(12,10,5,5,2018,"bday party","my bday party", "blah@gmail.com");
  	Appt appt0 = new Appt(13,3,6,5,2018,"bday party","my bday party", "blah@gmail.com");
	cald1.addAppt(appt0);
	cald1.addAppt(appt1);
  	String s1 = cald1.getFullInfomrationApp(cald1);
	assertEquals("6-5-2018 \n\t0:10AM bday party my bday party \n\t1:03PM bday party my bday party ",s1);
	//assertTrue(cald1.isValid());
  }
  
  @Test(timeout = 4000)
  public void test0e()  throws Throwable  {
  	//CalDay cald1 = new CalDay();
	GregorianCalendar cal = new GregorianCalendar(2018,5,5);
     	CalDay cald1 = new CalDay(cal);
     	Appt appt1 = new Appt(12,10,5,5,2018,"bday party","my bday party", "blah@gmail.com");
  	Appt appt0 = new Appt(12,3,6,5,2018,"bday party","my bday party", "blah@gmail.com");
	cald1.addAppt(appt0);
	cald1.addAppt(appt1);
  	String s1 = cald1.getFullInfomrationApp(cald1);
	assertEquals("6-5-2018 \n\t0:03AM bday party my bday party \n\t0:10AM bday party my bday party ",s1);
	//assertTrue(cald1.isValid());
  	assertEquals(2,cald1.getSizeAppts());
  }

//SETAPPTS(..))

  @Test(timeout = 4000)
  public void test02() throws Throwable { 
  	CalDay cald2 = new CalDay();
	assertFalse(cald2.isValid());
  }     


}
