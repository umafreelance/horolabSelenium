package com.Automation.HoroLab;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;



public class CommonUtil {
	public static int randomGenerator(int digitNo) {
		// TODO Auto-generated method stub
		int randomInt = 1;
		try {
			int nextInt=1;
			for(int i =1;i<=digitNo;i++){
				nextInt=nextInt*10;
			}
			System.out.println("nextint "+nextInt);
			Random randomGenerator = new Random();
			randomInt = randomGenerator.nextInt(nextInt);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return randomInt;
	}

	public static String getDatetime() {
		// TODO Auto-generated method stub
		SimpleDateFormat DtFormat = new SimpleDateFormat("yyMMddhhmmaa");
		Date date = new Date();
		String DateAndTime=(DtFormat.format(date).toString());
		if(DateAndTime.substring(DateAndTime.length()-2).equalsIgnoreCase("pm")){
			int hr = Integer.valueOf(DateAndTime.substring(6,8))+12;
			DateAndTime = DateAndTime.substring(0,6)+hr+DateAndTime.substring(8,10);
		}else{
			DateAndTime = DateAndTime.substring(0,10);
		}
		return DateAndTime;
	}


	public static String getDatetimeinSec() {
		// TODO Auto-generated method stub
		SimpleDateFormat DtFormat = new SimpleDateFormat("yyMMddhhmmssaa");
		Date date = new Date();
		String DateAndTime=(DtFormat.format(date).toString());
		if(DateAndTime.substring(DateAndTime.length()-2).equalsIgnoreCase("pm")){
			int hr = Integer.valueOf(DateAndTime.substring(6,8))+12;
			DateAndTime = DateAndTime.substring(0,6)+hr+DateAndTime.substring(8,12);
		}else{
			DateAndTime = DateAndTime.substring(0,12);
		}
		return DateAndTime;
	}
	public static String getDate(String format, int day) {
		// TODO Auto-generated method stub
		String output = null;
		try{
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			Calendar c = Calendar.getInstance();
			c.setTime(new Date()); 
			c.add(Calendar.DATE, day); 
			output = sdf.format(c.getTime());
			System.out.println(output);

		}catch(Exception e){

		}
		return output;
	}


	public static String getDate(int day) {
		// TODO Auto-generated method stub
		String output = null;
		try{
			SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
			Calendar c = Calendar.getInstance();
			c.setTime(new Date()); 
			c.add(Calendar.DATE, day); 
			output = sdf.format(c.getTime());
			System.out.println(output);

		}catch(Exception e){

		}
		return output;
	}
	public static void escPress() throws Exception {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ESCAPE);
		Thread.sleep(2000);
		robot.keyRelease(KeyEvent.VK_ESCAPE);
	}
	public static void tabPress() throws Exception {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(2000);
		robot.keyRelease(KeyEvent.VK_TAB);
	}

	//
	public static int randomGenerator(int low, int high) {
		// TODO Auto-generated method stub
		int randomInt = 1;
		try {
			Random r = new Random();
			randomInt = r.nextInt(high-low) + low;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return randomInt;
	}

	public static String randomString()
	{
		String alphabet= "abcdefghijklmnopqrstuvwxyz";
		String s = "";
		Random random = new Random();
		int randomLen = 1+random.nextInt(9);
		for (int i = 0; i < randomLen; i++) {
			char c = alphabet.charAt(random.nextInt(26));
			s+=c;
		}
		return  s;
		//System.out.println(s);
	}

	public static String randomName(int targetStringLength) {

		int leftLimit = 97; // letter 'a'
		int rightLimit = 122; // letter 'z'
		//String ss = "";
		Random random = new Random();
		StringBuilder buffer = new StringBuilder(targetStringLength);
		for (int i = 0; i < targetStringLength; i++) {
			int randomLimitedInt = leftLimit + (int) 
					(random.nextFloat() * (rightLimit - leftLimit + 1));
			buffer.append((char) randomLimitedInt);
		}
		String generatedString = buffer.toString();

		System.out.println(generatedString);
		return generatedString;
	}
}
