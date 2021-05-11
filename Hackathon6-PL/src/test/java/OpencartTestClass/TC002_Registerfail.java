package OpencartTestClass;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Datafactory.Base;

public class TC002_Registerfail extends Base {

	 public static Logger log =LogManager.getLogger(Base.class.getName());
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
		  
		  log.info("launchURL");
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
				long Telephone = (long) sheet.getRow(1).getCell(3).getNumericCellValue();
				
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
}

