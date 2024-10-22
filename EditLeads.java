package ExcelIntagration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class EditLeads extends BaseClass {
	
	@BeforeTest
	public void getData() {
		excelName="EditSales";
	}


	/**
	 * @param args
	 * @throws InterruptedException
	 */
	@Test(dataProvider="setData")
	public void editSalesForce(String uname, String password,String name, String Sname) throws InterruptedException {

     	driver.findElement(By.xpath("//input[@id='username']")).sendKeys(uname);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
		driver.findElement(By.id("Login")).click();
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		driver.findElement(By.xpath("//button[@class='slds-button']")).click();
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement Opp = driver.findElement(By.xpath("//span[text()='Opportunities']"));
		js.executeScript("arguments[0].click();", Opp);
		
		driver.findElement(By.xpath("//input[@name='Opportunity-search-input']")).sendKeys(name,Keys.ENTER);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//table[@class='slds-table forceRecordLayout slds-table_header-fixed slds-table--header-fixed slds-table_edit slds-table--edit slds-table_bordered slds-table--bordered resizable-cols slds-table--resizable-cols uiVirtualDataTable']/tbody/tr/td[8]")).click();
		driver.findElement(By.xpath("//a[@title='Edit']")).click();
		driver.findElement(By.xpath("//input[@name='CloseDate']")).click();
		driver.findElement(By.xpath("//span[text()='10']")).click();
		WebElement stageClick = driver.findElement(By.xpath("//button[@aria-label='Stage']/span"));
		js.executeScript("arguments[0].click();", stageClick);
		driver.findElement(By.xpath("//span[@title='Perception Analysis']")).click();
		WebElement delivaryStatus = driver.findElement(By.xpath("//button[@aria-label='Delivery/Installation Status']/span"));
		js.executeScript("arguments[0].click();", delivaryStatus);
		driver.findElement(By.xpath("//span[@title='In progress']")).click();
		driver.findElement(By.xpath("//textarea[@class='slds-textarea']")).sendKeys(Sname);
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		Thread.sleep(3000);
		
		String stageValue = driver.findElement(By.xpath("//table[@class='slds-table forceRecordLayout slds-table_header-fixed slds-table--header-fixed slds-table_edit slds-table--edit slds-table_bordered slds-table--bordered resizable-cols slds-table--resizable-cols uiVirtualDataTable']/tbody/tr/td[5]")).getText();
		System.out.println("Stage is : "+stageValue);
		
		if(stageValue.equalsIgnoreCase("Perception Analysis")) {
		System.out.println("This is the 'Perception Analysis' stage");	
		}else {
			System.out.println("This is not the 'Perception Analysis' stage");
		}
			
		
		

	}

}
