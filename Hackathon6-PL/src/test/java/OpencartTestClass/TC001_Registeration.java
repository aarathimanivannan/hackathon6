package OpencartTestClass;

import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Datafactory.Base;
import Logger.Log;


public class TC001_Registeration extends Base {

	 public TC001_Registeration() {
	 
	 DOMConfigurator.configure("LogXML\\Log4j.xml");
		 
	 }
	 
	@BeforeSuite
	public void initiatizedriver() throws Exception {
		
		driver = intializeDriver();
	}
	
	@BeforeClass
	 public void launchURL() throws Exception {
		  
		  Properties prop = new Properties();
			
			FileInputStream file_path = new FileInputStream("C:\\Users\\91994\\eclipse-workspace\\Hackathon6-PL\\ConfigReader\\Config.properties");
			prop.load(file_path);
			
		  driver.get(prop.getProperty("url"));
		 WebDriverWait wait = new WebDriverWait(driver, 60);
		  
		  Log.info("URLlaunchsuccessfully");
	}
	
	
	
	 @Test(priority=0)
  
  public void accountregister() throws Exception {
		
		 Properties prop = new Properties();
			
			FileInputStream file_path = new FileInputStream("C:\\Users\\91994\\eclipse-workspace\\Hackathon6-PL\\ConfigReader\\Config.properties");
			prop.load(file_path);
		 
		 driver.findElement(By.xpath(prop.getProperty("MyAccount_button"))).click();
		 driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		 
		 driver.findElement(By.xpath(prop.getProperty("Register_button"))).click();
		 driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		 
		 File src = new File("C:\\Users\\91994\\eclipse-workspace\\Hackathon6-PL\\Excelreader\\opencart.xlsx");
			FileInputStream input = new FileInputStream(src);
			XSSFWorkbook wb = new XSSFWorkbook(input);
			XSSFSheet sheet = wb.getSheet("Sheet 2");
			long Telephone = (long) sheet.getRow(1).getCell(3).getNumericCellValue();
			
			String firstname = sheet.getRow(1).getCell(0).getStringCellValue();
			driver.findElement(By.xpath(prop.getProperty("First_name"))).sendKeys(firstname);
			
			String lastname = sheet.getRow(1).getCell(1).getStringCellValue();
			driver.findElement(By.xpath(prop.getProperty("Last_name"))).sendKeys(lastname);
			
			String emailid = sheet.getRow(1).getCell(2).getStringCellValue();
			driver.findElement(By.xpath(prop.getProperty("Email_id"))).sendKeys(emailid);
			
			driver.findElement(By.xpath(prop.getProperty("Telephone_number"))).sendKeys(String.valueOf(Telephone));
	
			String Password = sheet.getRow(1).getCell(4).getStringCellValue();
			driver.findElement(By.xpath(prop.getProperty("Create_Password"))).sendKeys(Password);
			
			String ConfirmPassword = sheet.getRow(1).getCell(5).getStringCellValue();
			driver.findElement(By.xpath(prop.getProperty("Confirm_password"))).sendKeys(ConfirmPassword);
			
		 driver.findElement(By.xpath(prop.getProperty("No_Radiobutton"))).click();
		 driver.findElement(By.xpath(prop.getProperty("check_box_xpath"))).click();
		 
		 driver.findElement(By.xpath(prop.getProperty("Click_continue_xpath"))).click();
		 Thread.sleep(3000);

	
}
	 
	 @Test(priority=1)
	  
	  public void accountregistermismatch() throws Exception {
			
			 Properties prop = new Properties();
				
				FileInputStream file_path = new FileInputStream("C:\\Users\\91994\\eclipse-workspace\\Hackathon6-PL\\ConfigReader\\Config.properties");
				prop.load(file_path);
			 
			 driver.findElement(By.xpath(prop.getProperty("MyAccount_button"))).click();
			 driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			 
			 driver.findElement(By.xpath(prop.getProperty("Register_button"))).click();
			 driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			 
			 File src = new File("C:\\Users\\91994\\eclipse-workspace\\Hackathon6-PL\\Excelreader\\opencart.xlsx");
				FileInputStream input = new FileInputStream(src);
				XSSFWorkbook wb = new XSSFWorkbook(input);
				XSSFSheet sheet = wb.getSheet("Sheet 2");
				//long Telephone = (long) sheet.getRow(1).getCell(3).getNumericCellValue();
				
				String firstname = sheet.getRow(1).getCell(0).getStringCellValue();
				driver.findElement(By.xpath(prop.getProperty("First_name"))).sendKeys(firstname);
				
				String lastname = sheet.getRow(1).getCell(1).getStringCellValue();
				driver.findElement(By.xpath(prop.getProperty("Last_name"))).sendKeys(lastname);
				
				String emailid = sheet.getRow(1).getCell(2).getStringCellValue();
				driver.findElement(By.xpath(prop.getProperty("Email_id"))).sendKeys(emailid);
				
				//driver.findElement(By.xpath(prop.getProperty("Telephone_number"))).sendKeys(String.valueOf(Telephone));
		
				String Password = sheet.getRow(1).getCell(4).getStringCellValue();
				driver.findElement(By.xpath(prop.getProperty("Create_Password"))).sendKeys(Password);
				
				String ConfirmPassword = sheet.getRow(1).getCell(5).getStringCellValue();
				driver.findElement(By.xpath(prop.getProperty("Confirm_password"))).sendKeys(ConfirmPassword);
				
			 driver.findElement(By.xpath(prop.getProperty("No_Radiobutton"))).click();
			 driver.findElement(By.xpath(prop.getProperty("check_box_xpath"))).click();
			 
			 driver.findElement(By.xpath(prop.getProperty("Click_continue_xpath"))).click();
			 Thread.sleep(3000);
		
			 File src2 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

				try {
					FileHandler.copy(src2, new File("C:\\Users\\91994\\eclipse-workspace\\Hackathon6-PL\\CaptureScreenshot\\snap.png"));

				} catch (Exception e) {
					e.printStackTrace();
				}

				Thread.sleep(5000);
	}
	 
	 @Test(priority=2)
	 public void login() throws Exception {
		 
		 Properties prop = new Properties();
			
			FileInputStream file_path = new FileInputStream("C:\\Users\\91994\\eclipse-workspace\\Hackathon6-PL\\ConfigReader\\Config.properties");
			prop.load(file_path);
		 
		 driver.findElement(By.xpath(prop.getProperty("MyAccount_button"))).click();
		 driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		 
		 driver.findElement(By.xpath(prop.getProperty("home_login_button"))).click();
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 
		 File src = new File("C:\\Users\\91994\\eclipse-workspace\\Hackathon6-PL\\Excelreader\\opencart.xlsx");
		 FileInputStream input = new FileInputStream(src);
			XSSFWorkbook wb = new XSSFWorkbook(input);
			XSSFSheet sheet = wb.getSheet("Sheet 1");
		 
			String username = sheet.getRow(1).getCell(0).getStringCellValue();
			driver.findElement(By.xpath(prop.getProperty("Email_loginpage"))).sendKeys(username);
			
			String password = sheet.getRow(1).getCell(1).getStringCellValue();
			driver.findElement(By.xpath(prop.getProperty("Password_login"))).sendKeys(password);
			
		 driver.findElement(By.xpath(prop.getProperty("Login_Button"))).click();
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 
		 System.out.println(driver.getTitle());
		 
			
	 }
		 
 @Test(priority=3)
		 public void Iphoneaddtocart() throws Exception {
		 
			 Properties prop = new Properties();
				
				FileInputStream file_path = new FileInputStream("C:\\Users\\91994\\eclipse-workspace\\Hackathon6-PL\\ConfigReader\\Config.properties");
				prop.load(file_path);
		
				
				File src = new File("C:\\Users\\91994\\eclipse-workspace\\Hackathon6-PL\\Excelreader\\opencart.xlsx");
				 FileInputStream input = new FileInputStream(src);
					XSSFWorkbook wb = new XSSFWorkbook(input);
					XSSFSheet sheet = wb.getSheet("Sheet 1");
		 String searchiphone = sheet.getRow(1).getCell(9).getStringCellValue();
		 driver.findElement(By.xpath(prop.getProperty("search_item"))).sendKeys(searchiphone);
		 
		 driver.findElement(By.xpath(prop.getProperty("search_ion"))).click();
		 
		 driver.findElement(By.xpath(prop.getProperty("select_iphone"))).click();
		 
		 driver.findElement(By.xpath(prop.getProperty("enter_quantity"))).clear();
		 driver.findElement(By.xpath(prop.getProperty("enter_quantity"))).sendKeys("2");
		 
		 driver.findElement(By.xpath(prop.getProperty("addtocartiphone"))).click();
		 driver.findElement(By.xpath(prop.getProperty("viewcart"))).click();
		 
		 driver.findElement(By.xpath(prop.getProperty("checkout_cart"))).click();
		 Log.info("Product running out of stock message");
		 
		 Thread.sleep(5000);
		 
		 File src2 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		 
		 Thread.sleep(5000);

			try {
				FileHandler.copy(src2, new File("C:\\Users\\91994\\eclipse-workspace\\Hackathon6-PL\\CaptureScreenshot\\snap1.png"));

			} catch (Exception e) {
				e.printStackTrace();
			}

			Thread.sleep(5000);
			
		
 }
 
			 
 @Test(priority=4)
	 public void HPlaptop() throws Exception {
	 
	 Properties prop = new Properties();
		
			FileInputStream file_path = new FileInputStream("C:\\Users\\91994\\eclipse-workspace\\Hackathon6-PL\\ConfigReader\\Config.properties");
			prop.load(file_path);
		
			driver.findElement(By.xpath(prop.getProperty("selectlaptop"))).click();
		driver.findElement(By.xpath(prop.getProperty("Show_All_laptop&Notebooks"))).click();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		
		driver.findElement(By.xpath(prop.getProperty("selectHPLaptop"))).click();
		driver.findElement(By.xpath(prop.getProperty("HPaddtocart"))).click();
		
		driver.findElement(By.xpath(prop.getProperty("shoppingcart"))).click();
		driver.findElement(By.xpath(prop.getProperty("removeitem"))).click();
 }
		
	@Test(priority=4)
		 public void entercouponcode() throws Exception {
		 
		 Properties prop = new Properties();
			
				FileInputStream file_path = new FileInputStream("C:\\Users\\91994\\eclipse-workspace\\Hackathon6-PL\\ConfigReader\\Config.properties");
				prop.load(file_path);
			
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		
		driver.findElement(By.xpath(prop.getProperty("selectcouponcode"))).click();
		driver.findElement(By.xpath(prop.getProperty("entercoupon"))).sendKeys("abcdef");
		driver.findElement(By.xpath(prop.getProperty("applycoupon"))).click();
		 driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		js.executeScript("window.scrollBy(0,-500)");
		
		Thread.sleep(5000);
		 
		 File src2 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		 
		 Thread.sleep(5000);

			try {
				FileHandler.copy(src2, new File("C:\\Users\\91994\\eclipse-workspace\\Hackathon6-PL\\CaptureScreenshot\\snap2.png"));

			} catch (Exception e) {
				e.printStackTrace();
			}

			Thread.sleep(5000);
			
			Log.info("screenshottakensuccessfully");
			
	driver.findElement(By.xpath(prop.getProperty("accountlogout"))).click();			
	driver.findElement(By.xpath(prop.getProperty("logout"))).click();	
						
	Log.info("logoutsuccessfully");
			
}}
