
/** A JUnit test class to test the class DataHandler. */


package calendar;

import org.junit.Test;
import static org.junit.Assert.*;
import calendar.Appt;
import calendar.CalDay;
import calendar.DataHandler;

import java.util.GregorianCalendar;
import java.util.LinkedList;


public class DataHandlerTest{
  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
	DataHandler dh0 = new DataHandler("dhfile",false);
	GregorianCalendar firstDay = new GregorianCalendar(2018,1,1);
	GregorianCalendar lastDay = new GregorianCalendar(2018,12,12);
	Appt appt = new Appt(10,30,30,9,2018,"bday","this is my bday","email@gmail.com"); 
	Appt appt2 = new Appt(9,30,30,9,2018,"bday","this is my bday","email@gmail.com"); 
	//assertEquals("	 --- 3/1/2018 ---",dh0.getApptRange(firstDay,lastDay));
  	dh0.getApptRange(firstDay,lastDay);
	dh0.saveAppt(appt);
	//dh0.getApptOccurences(appt,firstDay,lastDay);
  	
	boolean b = dh0.save();
	assertTrue(b);
  	boolean b2 = dh0.deleteAppt(appt);
	assertTrue(b2);
  }

  @Test(timeout = 4000)
  public void test02() throws Throwable { 
  	DataHandler dh1 = new DataHandler();
	GregorianCalendar firstDay = new GregorianCalendar(2018,2,2);
	GregorianCalendar lastDay = new GregorianCalendar(2018,10,10);//last changes....
	assertNotNull(dh1.getApptRange(firstDay,lastDay));
	Appt appt = new Appt(10,30,30,9,2018,"bday","this is my bday","email@gmail.com"); 
	Appt appt2 = new Appt(9,30,30,9,2018,"bday","this is my bday","email@gmail.com"); 
  	dh1.getApptRange(firstDay,lastDay);
	//assertNull(dh1.getApptRange(firstDay,lastDay));
  	//assertEquals("Second date specified is not before the first date specified.",dh1.getApptRange(firstDay,lastDay));
	dh1.saveAppt(appt);
  }
  
  @Test(timeout = 4000)
  public void test03() throws Throwable { 
  	DataHandler dh2 = new DataHandler("dh2",false);
	GregorianCalendar firstDay = new GregorianCalendar(2018,1,1);
	GregorianCalendar lastDay = new GregorianCalendar(2018,12,12);
	Appt appt = new Appt(10,30,30,8,2018,"bday","this is my bday","email@gmail.com"); 
	Appt appt2 = new Appt(9,30,30,8,2019,"bday","this is my bday","email@gmail.com"); 
  	dh2.getApptRange(firstDay,lastDay);
	dh2.saveAppt(appt);
	//assertFalse(dh2.saveAppt(appt2));
	//assertFalse(dh2.deleteAppt(appt2));
	
  }
  
  @Test(timeout = 4000)
  public void test04() throws Throwable { 
  	DataHandler dh1 = new DataHandler("dhfile3");
	GregorianCalendar firstDay = new GregorianCalendar(2018,9,9);
	GregorianCalendar lastDay = new GregorianCalendar(2018,9,10);
	Appt appt = new Appt(10,30,9,9,2018,"bday","this is my bday","email@gmail.com"); 
	Appt appt2 = new Appt(9,30,9,9,2019,"bday","this is my bday","email@gmail.com"); 
	dh1.getApptRange(firstDay,lastDay);
	//assertTrue(dh1.saveAppt(appt));
	//assertFalse(dh1.saveAppt(appt2));//last test
  }

}
