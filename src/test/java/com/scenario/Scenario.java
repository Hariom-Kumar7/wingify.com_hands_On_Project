package com.scenario;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.loginFunctioality.LoginPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scenario {
	    
	WebDriver driver;
	LoginPage loginPage;
	ExtentReports er;
	ExtentTest test;
	
	@BeforeClass
	public void testreport() {
		 er = new ExtentReports(System.getProperty("user.dir")+"/Report.html");
		 test = er.startTest("Wingify");
	}
		@BeforeMethod
		public void setUp() throws IOException {
			//create an object of the properties class which is related to java.util class
			Properties prop = new Properties();
			
			FileInputStream file = new FileInputStream("C:\\Users\\kumar\\Documents\\workspace-spring-tool-suite-4-4.21.1.RELEASE\\wingify.com_Project\\src\\test\\resources\\data.properties");
			//FileInputStream file = new FileInputStream("\\src\\test\\resources\\data.properties");
			prop.load(file);
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(prop.getProperty("baseURL"));
			loginPage = new LoginPage(driver);
			
			test.log(LogStatus.PASS, "Url is correct");
			
			
		}
		@Test
		public void test_id_1() throws InterruptedException {
			loginPage.SendUserName("Hariom");
			Thread.sleep(2000);
			loginPage.sendPassword("Hariom1432@");
			Thread.sleep(2000);
			loginPage.ClickOnLogin();
			Thread.sleep(2000);
			loginPage.clickOnAmount_Header();
			Thread.sleep(2000);
			test.log(LogStatus.PASS, "test_id_1");
		}
		@Test
		public void test_id_2() throws InterruptedException {
			loginPage.SendUserName("hariomkumar845424@gmail.com");
			Thread.sleep(2000);
			loginPage.sendPassword("Hariom1230");
			Thread.sleep(2000);
			loginPage.ClickOnLogin();loginPage.clickOnAmount_Header();
			Thread.sleep(2000);
			test.log(LogStatus.PASS, "test_id_2");
			
		}
		@Test 
		public void test_id_3() throws InterruptedException {
			loginPage.SendUserName("");
			Thread.sleep(2000);
			loginPage.sendPassword("");
			Thread.sleep(2000);
			loginPage.ClickOnLogin();
			Thread.sleep(2000);
			loginPage.clickOnAmount_Header();
			Thread.sleep(2000);
			test.log(LogStatus.PASS, "test_id_3");
		}
		@Test
		public void test_id_4() throws InterruptedException {
			loginPage.SendUserName("Harry");
			Thread.sleep(2000);
			loginPage.sendPassword("");
			Thread.sleep(2000);
			loginPage.ClickOnLogin();
			Thread.sleep(2000);
			loginPage.clickOnAmount_Header();
			Thread.sleep(2000);
			test.log(LogStatus.PASS, "test_id_4");
		}
		@Test
		public void test_id_5() throws InterruptedException {
			loginPage.SendUserName("");
			Thread.sleep(2000);
			loginPage.sendPassword("Harry@1432");
			Thread.sleep(2000);
			loginPage.ClickOnLogin();
			Thread.sleep(2000);
			loginPage.clickOnAmount_Header();
			Thread.sleep(2000);
			test.log(LogStatus.PASS, "test_id_5");
		}
		@Test   //SQL injection
		public void test_id_6() throws InterruptedException {
			loginPage.SendUserName("'' OR '1'='1'");
			Thread.sleep(2000);
			loginPage.sendPassword("Harry@1432");
			Thread.sleep(2000);
			loginPage.ClickOnLogin();
			Thread.sleep(2000);
			loginPage.clickOnAmount_Header();
			Thread.sleep(2000);
			test.log(LogStatus.PASS, "test_id_6");
		}
		@Test
		public void test_id_7() throws InterruptedException {
			loginPage.SendUserName("'' OR '1'='1'");
			Thread.sleep(2000);
			loginPage.sendPassword("'' OR '1'='1'");
			Thread.sleep(2000);
			loginPage.ClickOnLogin();
			Thread.sleep(2000);
			loginPage.clickOnAmount_Header();
			Thread.sleep(2000);
			test.log(LogStatus.PASS, "test_id_7");
		}
		@Test      //Remember Me
		public void test_id_8() throws InterruptedException {
			loginPage.SendUserName("RothsChild");
			Thread.sleep(2000);
			loginPage.sendPassword("RothsChild1432#");
			Thread.sleep(2000);
			loginPage.ClickOnRememberme();
			Thread.sleep(2000);
			loginPage.ClickOnLogin();
			Thread.sleep(2000);
			loginPage.clickOnAmount_Header();
			Thread.sleep(2000);
			
			//test.log(LogStatus.PASS, "test_id_1");
		}
		
		
		@AfterMethod
		public void tearDown() throws InterruptedException {
			 driver.quit();
		}
		@AfterClass
		public void reportFlush() {
			er.endTest(test);
			er.flush();
		}
	}


