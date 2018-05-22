package calendar;

import java.util.Calendar;
import java.util.Random;

import calendar.Appt;
import calendar.CalDay;
import calendar.DataHandler;

import java.util.GregorianCalendar;
import java.util.LinkedList;

import org.junit.Test;



import static org.junit.Assert.*;



/**
 * Random Test Generator  for DataHandler class.
 */

public class DataHandlerRandomTest {

	private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */
	private static final int NUM_TESTS=100;

	/**
	 * Return a randomly selected method to be tests !.
	 */
    public static String RandomSelectMethod(Random random){
        String[] methodArray = new String[] {"setTitle","setRecurrence"};// The list of the of methods to be tested in the Appt class

    	int n = random.nextInt(methodArray.length);// get a random number between 0 (inclusive) and  methodArray.length (exclusive)
    	            
        return methodArray[n] ; // return the method name 
        }
	/**
	 * Return a randomly selected appointments to recur Weekly,Monthly, or Yearly !.
	 */
    public static int RandomSelectRecur(Random random){
        int[] RecurArray = new int[] {Appt.RECUR_BY_WEEKLY,Appt.RECUR_BY_MONTHLY,Appt.RECUR_BY_YEARLY};// The list of the of setting appointments to recur Weekly,Monthly, or Yearly

    	int n = random.nextInt(RecurArray.length);// get a random number between 0 (inclusive) and  RecurArray.length (exclusive)
        return RecurArray[n] ; // return the value of the  appointments to recur 
        }	
	/**
	 * Return a randomly selected appointments to recur forever or Never recur  !.
	 */
    public static int RandomSelectRecurForEverNever(Random random){
        int[] RecurArray = new int[] {Appt.RECUR_NUMBER_FOREVER,Appt.RECUR_NUMBER_NEVER};// The list of the of setting appointments to recur RECUR_NUMBER_FOREVER, or RECUR_NUMBER_NEVER

    	int n = random.nextInt(RecurArray.length);// get a random number between 0 (inclusive) and  RecurArray.length (exclusive)
        return RecurArray[n] ; // return appointments to recur forever or Never recur 
        }	
   /**
     * Generate Random Tests that tests Appt Class.
     */
	 @Test
	  public void radnomtest()  throws Throwable  {

		 long startTime = Calendar.getInstance().getTimeInMillis();
		 long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;

		 
		 System.out.println("Start testing...");
		 
		try{ 
			for (int iteration = 0; elapsed < TestTimeout; iteration++) {
				long randomseed =System.currentTimeMillis(); //10
	//			System.out.println(" Seed:"+randomseed );
				Random random = new Random(randomseed);
				
				//NEED TO CHANGE  
				int startHour=ValuesGenerator.getRandomIntBetween(random, -1, 11);
				 int startMinute=ValuesGenerator.getRandomIntBetween(random, -1, 11);
				 int startDay=ValuesGenerator.getRandomIntBetween(random, -1, 11);
				 int startMonth=ValuesGenerator.getRandomIntBetween(random, -1, 11);
				 int startYear=ValuesGenerator.getRandomIntBetween(random, -2018, 2018);
				 String title="Birthday Party";
				 String description="This is my birthday party.";
				 String emailAddress="xyz@gmail.com";

				 //Construct a new Appointment object with the initial data	 
				 //Construct a new Appointment object with the initial data	 
		         Appt appt = new Appt(startHour,
		                  startMinute ,
		                  startDay ,
		                  startMonth ,
		                  startYear ,
		                  title,
		                 description,
		                 emailAddress);
				 
			 if(!appt.getValid())continue;
			for (int i = 0; i < NUM_TESTS; i++) {
					String methodName = ApptRandomTest.RandomSelectMethod(random);
					   if (methodName.equals("setTitle")){
						   String newTitle=(String) ValuesGenerator.getString(random);
						   appt.setTitle(newTitle);						   
						}
				//	   else if (methodName.equals("setRecurrence")){
						   int sizeArray=ValuesGenerator.getRandomIntBetween(random, 0, 8);
						   int[] recurDays=ValuesGenerator.generateRandomArray(random, sizeArray);
						   int recur=ApptRandomTest.RandomSelectRecur(random);
						   int recurIncrement = ValuesGenerator.RandInt(random);
						   int recurNumber=ApptRandomTest.RandomSelectRecurForEverNever(random);
						   appt.setRecurrence(recurDays, recur, recurIncrement, recurNumber);
				//		}
					   DataHandler dh = new DataHandler("dhfile",false);
					   GregorianCalendar firstDay = new GregorianCalendar(2018,1,1);
					   GregorianCalendar lastDay = new GregorianCalendar(2018,12,12);
					   appt.setValid();
					  // dh.getApptRange(firstDay,lastDay);

					   dh.saveAppt(appt);
					   dh.getApptRange(firstDay,lastDay);
					   dh.deleteAppt(appt);					   
					   
			}
				
				 elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
			        if((iteration%10000)==0 && iteration!=0 )
			              System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);
			 
			}
		}catch(NullPointerException e){
		}
	 
		 System.out.println("Done testing...");
	 }

	 @Test
	 public void radnomtest2()  throws Throwable  {
	  	DataHandler dh = new DataHandler("dhfile");
				long randomseed =System.currentTimeMillis(); //10
				Random random = new Random(randomseed);

			 //2nd Appointment
				int startHour2=ValuesGenerator.getRandomIntBetween(random, -1, 24);
				 int startMinute2=ValuesGenerator.getRandomIntBetween(random, -1, 60);
				 int startDay2=ValuesGenerator.getRandomIntBetween(random, 0, 32);
				 int startMonth2=ValuesGenerator.getRandomIntBetween(random, 0, 13);
				 int startYear2=ValuesGenerator.getRandomIntBetween(random, -1, 2018);
				 String title2="Birthday Party";
				 String description2="This is my birthday party.";
				 String emailAddress2="xyz@gmail.com";
			 
		         Appt appt2 = new Appt(startHour2,
		                  startMinute2 ,
		                  startDay2 ,
		                  startMonth2 ,
		                  startYear2 ,
		                  title2,
		                 description2,
		                 emailAddress2);
		//appt2.setValid();

	  	dh.saveAppt(appt2);
		dh.deleteAppt(appt2);//autosave case
	  }

	 @Test
	 public void radnomtest3()  throws Throwable  {
	  	DataHandler dh = new DataHandler("dhfile3");
		GregorianCalendar firstDay = new GregorianCalendar(2018,1,1);
		GregorianCalendar lastDay = new GregorianCalendar(2018,12,12);

				long randomseed =System.currentTimeMillis(); //10
				Random random = new Random(randomseed);

			 //2nd Appointment
				int startHour2=ValuesGenerator.getRandomIntBetween(random, 1, 11);
				 int startMinute2=ValuesGenerator.getRandomIntBetween(random, 1, 11);
				 int startDay2=ValuesGenerator.getRandomIntBetween(random, 1, 11);
				 int startMonth2=ValuesGenerator.getRandomIntBetween(random, 1, 11);
				 int startYear2=ValuesGenerator.getRandomIntBetween(random, 2018, 2018);
				 String title2="";
				 String description2="This is my birthday party.";
				 String emailAddress2="xyz@gmail.com";
			 
		         Appt appt2 = new Appt(startHour2,
		                  startMinute2 ,
		                  startDay2 ,
		                  startMonth2 ,
		                  startYear2 ,
		                  title2,
		                 description2,
		                 emailAddress2);
		dh.deleteAppt(appt2);//NULL xmlelement case
		appt2.setValid();
		dh.getApptRange(firstDay,lastDay);
	  }

	 @Test
	  public void randomtest4()  throws Throwable  {

		 long startTime = Calendar.getInstance().getTimeInMillis();
		 long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;

		 
		 System.out.println("Start testing...");
		 
		try{ 
			for (int iteration = 0; elapsed < TestTimeout; iteration++) {
				long randomseed =System.currentTimeMillis(); //10
	//			System.out.println(" Seed:"+randomseed );
				Random random = new Random(randomseed);
				
				//NEED TO CHANGE  
				int startHour=ValuesGenerator.getRandomIntBetween(random, 1, 11);
				 int startMinute=ValuesGenerator.getRandomIntBetween(random, 1, 11);
				 int startDay=ValuesGenerator.getRandomIntBetween(random, 9, 10);
				 int startMonth=ValuesGenerator.getRandomIntBetween(random, 9, 10);
				 int startYear=ValuesGenerator.getRandomIntBetween(random, 2018, 2019);
				 String title="Birthday Party";
				 String description="This is my birthday party.";
				 String emailAddress="xyz@gmail.com";

				 //Construct a new Appointment object with the initial data	 
				 //Construct a new Appointment object with the initial data	 
		         Appt appt = new Appt(startHour,
		                  startMinute ,
		                  startDay ,
		                  startMonth ,
		                  startYear ,
		                  title,
		                 description,
		                 emailAddress);
				 
			 if(!appt.getValid())continue;
			for (int i = 0; i < NUM_TESTS; i++) {
					String methodName = ApptRandomTest.RandomSelectMethod(random);
					   if (methodName.equals("setTitle")){
						   String newTitle=(String) ValuesGenerator.getString(random);
						   appt.setTitle(newTitle);						   
						}
					   else if (methodName.equals("setRecurrence")){
						   int sizeArray=ValuesGenerator.getRandomIntBetween(random, 0, 8);
						   int[] recurDays=ValuesGenerator.generateRandomArray(random, sizeArray);
						   int recur=ApptRandomTest.RandomSelectRecur(random);
						   int recurIncrement = ValuesGenerator.RandInt(random);
						   int recurNumber=ApptRandomTest.RandomSelectRecurForEverNever(random);
						   appt.setRecurrence(recurDays, recur, recurIncrement, recurNumber);
						}
					   DataHandler dh = new DataHandler("dhfile3");
					   GregorianCalendar fDay = new GregorianCalendar(2018,1,1);
					   GregorianCalendar lDay = new GregorianCalendar(2019,12,12);
					   appt.setValid();
					   dh.getApptRange(fDay,lDay);
					   //dh.saveAppt(appt);
					   //dh.deleteAppt(appt);					   
					   
			}
				
				 elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
			        if((iteration%10000)==0 && iteration!=0 )
			              System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);
			 
			}
		}catch(NullPointerException e){
		}
	 
		 System.out.println("Done testing...");
	 }
	
}
