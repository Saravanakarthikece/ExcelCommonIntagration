package ExcelIntagration;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

public class BaseClass {
	
	public ChromeDriver driver;
	
	public String 	excelName;
	
	@BeforeMethod
	public void preCondition() {
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--disable-notifications");
		
		driver = new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://login.salesforce.com");
		
	}

	@AfterMethod
	public void postCondition() {
		
		driver.close();
		
	}

	@DataProvider(name="setData")
	public String[][] fetchData() throws IOException {
		String[][] readData=IntegrationWithExcel.readData(excelName);
		return readData;
	}
	

}
