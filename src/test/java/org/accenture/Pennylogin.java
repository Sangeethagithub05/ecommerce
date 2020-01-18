package org.accenture;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Pennylogin {
	public static void main(String[] args) throws IOException, InterruptedException, AWTException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\home\\eclipse-workspace\\Project Class\\Drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.jcpenney.com/");
		driver.manage().window().maximize();
		
		WebElement login=driver.findElement(By.xpath("//div[text()='Sign In']"));
		login.click();
		Thread.sleep(5000);
		WebElement username=driver.findElement(By.xpath("//input[@id='loginEmail']"));
		username.sendKeys(ExcelRead.getdatatologin(0, 0));
		WebElement pass=driver.findElement(By.xpath("//input[@id='pwd']"));
		pass.sendKeys(ExcelRead.getdatatologin(1, 0));
		WebElement signin=driver.findElement(By.xpath("//button[@data-automation-id='signin_button']"));
		signin.click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement txtbox = driver.findElement(By.id("searchInputId"));
		txtbox.sendKeys("T.Shirts");
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(5000);
		WebElement cartbtn=driver.findElement(By.xpath("(//span[@class='btnText'])[2]"));
		cartbtn.click();
		Thread.sleep(5000);
		WebElement sizeRange = driver.findElement(By.xpath("//select[@name='size range']"));
		Select s1 = new Select(sizeRange);
		s1.selectByVisibleText("misses");

		WebElement sizebox=driver.findElement(By.xpath("//select[@data-automation-id='product-dimensions-size']"));
		Select s=new Select(sizebox);
		s.selectByVisibleText("large");
		WebElement color=driver.findElement(By.xpath("(//img[@alt='Rumba Red'])[2]"));
		color.click();
		WebElement cart=driver.findElement(By.xpath("//p[@data-automation-id='addToCart']"));
		cart.click();
		TakesScreenshot tk=(TakesScreenshot)driver;
		File temp=tk.getScreenshotAs(OutputType.FILE);
		File desc=new File("C:\\Users\\home\\eclipse-workspace\\Pennycom\\Screenshot\\penny.png");
		FileUtils.copyFile(temp, desc);
		WebElement name = driver.findElement(By.xpath("//h2[@data-automation-id='product-title']"));
		String nam1 = name.getText();
		System.out.println(nam1);
		WebElement price = driver.findElement(By.xpath("//strong[text()='$6.99']"));
		String pr = price.getText();
		ExcelWrite.excelWrite(nam1, pr);
		
		
		
}
}