package OpencartTestClass;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Datafactory.Base;

public class TC003_ValidateLoginfunctionality extends Base {

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
	}
	
	 @Test
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
		 
		 
	 }
}
