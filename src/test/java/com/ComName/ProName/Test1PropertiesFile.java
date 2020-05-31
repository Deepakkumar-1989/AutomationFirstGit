package com.ComName.ProName;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Test1PropertiesFile {

	public static void main(String[] args) throws IOException {
		
		Properties OR = new Properties();
		FileInputStream fis1 = new FileInputStream("E:\\workspaceNew\\MyLearningMvnProject\\src\\test\\resources\\PropertiesFiles\\OR.properties");
		OR.load(fis1);
		
		Properties config = new Properties();
		FileInputStream fis2 = new FileInputStream("E:\\workspaceNew\\MyLearningMvnProject\\src\\test\\resources\\PropertiesFiles\\config.properties");
		config.load(fis2);
		
		System.out.println("************************** Config Data File *******************");
		System.out.println("Application URL is :- " +config.getProperty("Application_url"));
		System.out.println("Application Browser is :- " +config.getProperty("Browser"));
		System.out.println("Application Env is :- " +config.getProperty("Env"));
		System.out.println("Application User name is :- " +config.getProperty("EmailAdd"));
		System.out.println("Application Password is :- " +config.getProperty("Psw"));
		
		
		System.out.println("************************* OR Data File *****************************");
		System.out.println("Sign in button xpath is :- " +OR.getProperty("XSignInBtn"));
		System.out.println("Add Email input box xpath  is :- " +OR.getProperty("XEmail_add"));
		System.out.println("Create an account button xpath  is :- " +OR.getProperty("XCreatAcnt_btn"));
		System.out.println("Gender button xpath  is :- " +OR.getProperty("XGender"));
		System.out.println("First Name input box xpath  is :- " +OR.getProperty("XFirstName"));
		System.out.println("Last Name input box xpath  is :- " +OR.getProperty("XLastName"));
		System.out.println("Password input box xpath  is :- " +OR.getProperty("Xpwd"));
		

	}

}
