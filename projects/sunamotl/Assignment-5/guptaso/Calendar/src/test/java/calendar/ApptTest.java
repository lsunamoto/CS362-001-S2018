/** A JUnit test class to test the class ApptTest. */

package calendar;

import org.junit.Test;
import static org.junit.Assert.*;
import calendar.Appt;
import calendar.CalendarUtil;
public class ApptTest  {

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      Appt appt0 = new Appt(15, 30, 9, 14, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
      String string0 = appt0.toString();
      assertEquals(2, appt0.getRecurBy());
      assertFalse(appt0.isRecurring());
      assertEquals("\t14/9/2018 at 3:30pm ,Birthday Party, This is my birthday party\n", string0);
      assertEquals(0, appt0.getRecurIncrement());
      boolean b = appt0.isOn(9,14,2018);
      assertTrue(b);
      assertTrue(appt0.hasTimeSet());
      appt0.setValid();
      assertFalse(appt0.getValid());
  }
  @Test(timeout = 4000)
  public void test0b()  throws Throwable  {
      Appt appt0 = new Appt(15, 30, 30, 1, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
      String string0 = appt0.toString();
      assertEquals(2, appt0.getRecurBy());
      assertFalse(appt0.isRecurring());
      assertEquals("\t1/30/2018 at 3:30pm ,Birthday Party, This is my birthday party\n", string0);
      assertEquals(0, appt0.getRecurIncrement());
      boolean b = appt0.isOn(30,1,2018);
      assertTrue(b);
      assertTrue(appt0.hasTimeSet());
      appt0.setValid();
      assertTrue(appt0.getValid());
  }
  
  @Test(timeout = 4000)
  public void test0c()  throws Throwable  {
      Appt appt0 = new Appt(15, 30, 30, 12, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
      String string0 = appt0.toString();
      assertEquals(2, appt0.getRecurBy());
      assertFalse(appt0.isRecurring());
      assertEquals("\t12/30/2018 at 3:30pm ,Birthday Party, This is my birthday party\n", string0);
      assertEquals(0, appt0.getRecurIncrement());
      boolean b = appt0.isOn(30,12,2018);
      assertTrue(b);
      assertTrue(appt0.hasTimeSet());
      appt0.setValid();
      assertTrue(appt0.getValid());
  }
  @Test(timeout = 4000)
  public void test1b()  throws Throwable  {
      Appt appt0 = new Appt(15, 30, 30, 7, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
      String string0 = appt0.toString();
      assertEquals(2, appt0.getRecurBy());
      assertFalse(appt0.isRecurring());
      assertEquals("\t7/30/2018 at 3:30pm ,Birthday Party, This is my birthday party\n", string0);
      assertEquals(0, appt0.getRecurIncrement());
      boolean b = appt0.isOn(30,7,2018);
      assertTrue(b);
      assertTrue(appt0.hasTimeSet());
      appt0.setValid();
      assertTrue(appt0.getValid());
  }
  @Test(timeout = 4000)
  public void test1b2()  throws Throwable  {
      Appt appt0 = new Appt(0, 30, 30, 7, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
      String string0 = appt0.toString();
      assertEquals(2, appt0.getRecurBy());
      assertFalse(appt0.isRecurring());
      assertEquals("\t7/30/2018 at 12:30am ,Birthday Party, This is my birthday party\n", string0);
      assertEquals(0, appt0.getRecurIncrement());
      boolean b = appt0.isOn(30,7,2018);
      assertTrue(b);
      assertTrue(appt0.hasTimeSet());
      appt0.setValid();
      assertTrue(appt0.getValid());
  }
  @Test(timeout = 4000)
  public void test1b3()  throws Throwable  {
      Appt appt0 = new Appt(23, 30, 30, 7, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
      String string0 = appt0.toString();
      assertEquals(2, appt0.getRecurBy());
      assertFalse(appt0.isRecurring());
      assertEquals("\t7/30/2018 at 11:30pm ,Birthday Party, This is my birthday party\n", string0);
      assertEquals(0, appt0.getRecurIncrement());
      boolean b = appt0.isOn(30,7,2018);
      assertTrue(b);
      assertTrue(appt0.hasTimeSet());
      appt0.setValid();
      assertTrue(appt0.getValid());
  }

  @Test(timeout = 4000)
  public void test1c()  throws Throwable  {
      Appt appt0 = new Appt(15, 30, 30, -1, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
      String string0 = appt0.toString();
      assertEquals(2, appt0.getRecurBy());
      assertFalse(appt0.isRecurring());
      assertEquals("\t-1/30/2018 at 3:30pm ,Birthday Party, This is my birthday party\n", string0);
      assertEquals(0, appt0.getRecurIncrement());
      boolean b = appt0.isOn(30,-1,2018);
      assertTrue(b);
      assertTrue(appt0.hasTimeSet());
      appt0.setValid();
      assertFalse(appt0.getValid());
  }
  
  @Test(timeout = 4000)
  public void test1d()  throws Throwable  {
      Appt appt0 = new Appt(15, 0, 30, 7, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
      String string0 = appt0.toString();
      assertEquals(2, appt0.getRecurBy());
      assertFalse(appt0.isRecurring());
      assertEquals("\t7/30/2018 at 3:0pm ,Birthday Party, This is my birthday party\n", string0);
      assertEquals(0, appt0.getRecurIncrement());
      boolean b = appt0.isOn(30,7,2018);
      assertTrue(b);
      assertTrue(appt0.hasTimeSet());
      appt0.setValid();
      assertTrue(appt0.getValid());
  }
  
  @Test(timeout = 4000)
  public void test1d2()  throws Throwable  {
      Appt appt0 = new Appt(15, 59, 30, 7, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
      String string0 = appt0.toString();
      assertEquals(2, appt0.getRecurBy());
      assertFalse(appt0.isRecurring());
      assertEquals("\t7/30/2018 at 3:59pm ,Birthday Party, This is my birthday party\n", string0);
      assertEquals(0, appt0.getRecurIncrement());
      boolean b = appt0.isOn(30,7,2018);
      assertTrue(b);
      assertTrue(appt0.hasTimeSet());
      appt0.setValid();
      assertTrue(appt0.getValid());
  }

  @Test(timeout = 4000)
  public void test01() throws Throwable { 
      Appt appt1 = new Appt(10, 10, -1, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
      String string1 = appt1.toString();
      assertEquals("\t10/10/-1 at -1:-1am ,Birthday Party, This is my birthday party\n", string1);
      String email = appt1.getEmailAddress();
      assertEquals("xyz@gmail.com",email);
      //assertEquals(0,appt1.getRecurDays());
      appt1.setValid();
      //assertTrue(appt1.getValid());
  }

  @Test(timeout = 4000)
  public void test02() throws Throwable { 
      Appt appt2 = new Appt(0, 70, 9, 10, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
      String string2 = appt2.toString();
      assertEquals("\t10/9/2018 at 12:70am ,Birthday Party, This is my birthday party\n", string2);
      appt2.setValid();	
      assertFalse(appt2.getValid()); 
  }
  
  @Test(timeout = 4000)
  public void test03() throws Throwable { 
      Appt appt3 = new Appt(0, 30, 9, 10, 0, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
      String string3 = appt3.toString();
      assertEquals("\t10/9/0 at 12:30am ,Birthday Party, This is my birthday party\n", string3);
      appt3.setValid();	
      assertFalse(appt3.getValid());//lc
  }
  
  @Test(timeout = 4000)
  public void test04() throws Throwable { 
      Appt appt4 = new Appt(0, 30, 0, 10, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
      String string4 = appt4.toString();
      assertEquals("\t10/0/2018 at 12:30am ,Birthday Party, This is my birthday party\n", string4);
      appt4.setValid();	
      assertFalse(appt4.getValid());
  }
  
  @Test(timeout = 4000)
  public void test05() throws Throwable { 
      Appt appt3 = new Appt(0, 30, 9, 10, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
      String string3 = appt3.toString();
      assertEquals("\t10/9/2018 at 12:30am ,Birthday Party, This is my birthday party\n", string3);
      appt3.setValid();	
      
  }
  
  @Test(timeout = 4000)
  public void test06()  throws Throwable  {
      Appt appt0 = new Appt(15, 30, 9, 12, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
      String string0 = appt0.toString();
      assertEquals(2, appt0.getRecurBy());
      assertFalse(appt0.isRecurring());
      assertEquals("\t12/9/2018 at 3:30pm ,Birthday Party, This is my birthday party\n", string0);
      assertEquals(0, appt0.getRecurIncrement());
      boolean b = appt0.isOn(9,12,2018);
      assertTrue(b);
      assertTrue(appt0.hasTimeSet());
      appt0.setValid();
  }

  @Test(timeout = 4000)
  public void test07()  throws Throwable  {
      Appt appt0 = new Appt(15, 30, 9, 0, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
      String string0 = appt0.toString();
      assertEquals(2, appt0.getRecurBy());
      assertFalse(appt0.isRecurring());
      assertEquals("\t0/9/2018 at 3:30pm ,Birthday Party, This is my birthday party\n", string0);
      assertEquals(0, appt0.getRecurIncrement());
      boolean b = appt0.isOn(9,0,2018);
      assertTrue(b);
      assertTrue(appt0.hasTimeSet());
      appt0.setValid();
  }
  
  @Test(timeout = 4000)
  public void test08()  throws Throwable  {
      Appt appt0 = new Appt(15, 30, 9, 1, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
      String string0 = appt0.toString();
      assertEquals(2, appt0.getRecurBy());
      assertFalse(appt0.isRecurring());
      assertEquals("\t1/9/2018 at 3:30pm ,Birthday Party, This is my birthday party\n", string0);
      assertEquals(0, appt0.getRecurIncrement());
      boolean b = appt0.isOn(9,1,2018);
      assertTrue(b);
      assertTrue(appt0.hasTimeSet());
      appt0.setValid();
  }
  
  @Test(timeout = 4000)
  public void test09()  throws Throwable  {
      Appt appt0 = new Appt(24, 30, 9, 10, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
      String string0 = appt0.toString();
      assertEquals(2, appt0.getRecurBy());
      assertFalse(appt0.isRecurring());
      assertEquals("\t10/9/2018 at 12:30pm ,Birthday Party, This is my birthday party\n", string0);
      assertEquals(0, appt0.getRecurIncrement());
      boolean b = appt0.isOn(9,10,2018);
      assertTrue(b);
      assertTrue(appt0.hasTimeSet());
      appt0.setValid();
  }
  @Test(timeout = 4000)
  public void test10()  throws Throwable  {
      Appt appt0 = new Appt(5, 30, 0, 10, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
      String string0 = appt0.toString();
      assertEquals(2, appt0.getRecurBy());
      assertFalse(appt0.isRecurring());
      assertEquals("\t10/0/2018 at 5:30am ,Birthday Party, This is my birthday party\n", string0);
      assertEquals(0, appt0.getRecurIncrement());
      boolean b = appt0.isOn(0,10,2018);
      assertTrue(b);
      assertTrue(appt0.hasTimeSet());
      appt0.setValid();
      assertFalse(appt0.getValid());
  }
  
  @Test(timeout = 4000)
  public void test11()  throws Throwable  {
      Appt appt0 = new Appt(15, 30, 30, 2, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
      String string0 = appt0.toString();
      assertEquals(2, appt0.getRecurBy());
      assertFalse(appt0.isRecurring());
      assertEquals("\t2/30/2018 at 3:30pm ,Birthday Party, This is my birthday party\n", string0);
      assertEquals(0, appt0.getRecurIncrement());
      boolean b = appt0.isOn(30,2,2018);
      assertTrue(b);
      assertTrue(appt0.hasTimeSet());
      appt0.setValid();
      assertFalse(appt0.getValid());
  }
  @Test(timeout = 4000)
  public void test12()  throws Throwable  {
      Appt appt0 = new Appt(11, 30, 27, 2, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
      String string0 = appt0.toString();
      assertEquals(2, appt0.getRecurBy());
      assertFalse(appt0.isRecurring());
      assertEquals("\t2/27/2018 at 11:30am ,Birthday Party, This is my birthday party\n", string0);
      assertEquals(0, appt0.getRecurIncrement());
      boolean b = appt0.isOn(27,2,2018);
      assertTrue(b);
      assertTrue(appt0.hasTimeSet());
      appt0.setValid();
      //assertFalse(appt0.getValid());
  }
  @Test(timeout = 4000)
  public void test13()  throws Throwable  {
      Appt appt0 = new Appt(15, 30, 1, 7, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
      String string0 = appt0.toString();
      assertEquals(2, appt0.getRecurBy());
      assertFalse(appt0.isRecurring());
      assertEquals("\t7/1/2018 at 3:30pm ,Birthday Party, This is my birthday party\n", string0);
      assertEquals(0, appt0.getRecurIncrement());
      boolean b = appt0.isOn(1,7,2018);
      assertTrue(b);
      assertTrue(appt0.hasTimeSet());
      appt0.setValid();
      assertTrue(appt0.getValid());
  }

  @Test(timeout = 4000)
 public void testlast()  throws Throwable  {


}

}
