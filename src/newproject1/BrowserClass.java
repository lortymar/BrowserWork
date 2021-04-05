package newproject1;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class BrowserClass {
	public static void main(String args[]) throws InterruptedException
	{
			WebDriver driver;
		
			System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\Downloads\\chromedriver_win32\\chromedriver.exe");
			driver= new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
     	    driver.manage().window().maximize();
     	    
			driver.get("https://yandex.ru/");
	        final Set<String> oldWindowsSet = driver.getWindowHandles();
	        
			{
			WebDriverWait wait = new WebDriverWait(driver,15);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Маркет")));
			WebElement market = driver.findElement(By.linkText("Маркет"));
		    Actions builder = new Actions(driver);
		    builder.moveToElement(market).perform();
			market.click();
			}
			
			String newWindow = (new WebDriverWait(driver, 10))
		            .until(new ExpectedCondition<String>() {
		                public String apply(WebDriver driver) {
		                    Set<String> newWindowsSet = driver.getWindowHandles();
		                    newWindowsSet.removeAll(oldWindowsSet);
		                    return newWindowsSet.size() > 0 ? 
		                                 newWindowsSet.iterator().next() : null;
		                  }
		                }
		            );
			driver.switchTo().window(newWindow);
			
			{
			WebDriverWait wait = new WebDriverWait(driver,15);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[4]/div/a")));
			WebElement element = driver.findElement(By.xpath("//div[4]/div/a"));
		    Actions builder = new Actions(driver);
		    builder.moveToElement(element).perform();
			element.click();
			}
			
			{
			WebDriverWait wait = new WebDriverWait(driver,15);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li/div/a")));
			WebElement element = driver.findElement(By.xpath("//li/div/a"));
			Actions builder = new Actions(driver);
			builder.moveToElement(element).perform();
			element.click();
			}
			
			driver.findElement(By.id("glpriceto")).sendKeys("20000");
			driver.findElement(By.id("4925721from")).sendKeys("3");
			
			driver.findElement(By.xpath("//li[3]/div/a/label/div/span")).click();
			driver.findElement(By.xpath("//li[4]/div/a/label/div/span")).click();
			driver.findElement(By.xpath("//li[9]/div/a/label/div/span")).click();
			driver.findElement(By.xpath("//li[11]/div/a/label/div/span")).click();
			driver.findElement(By.xpath("//a/label/div/span")).click();
			try {
			     driver.findElement(By.xpath("//div[2]/div/div[2]/button")).click();
			  } catch (Exception e) {
			     JavascriptExecutor executor = (JavascriptExecutor) driver;
			     executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("//div[2]/div/div[2]/button")));
			  }
			
			try {
			     driver.findElement(By.xpath("//div[2]/div/div[2]/div/div/button")).click();
			  } catch (Exception e) {
			     JavascriptExecutor executor = (JavascriptExecutor) driver;
			     executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("//div[2]/div/div[2]/div/div/button")));
			  }
			
     	    //Ожидание 10 секунд перед закрытием браузера
     	    Thread.sleep(20000);
     	   try {
			     driver.findElement(By.xpath("//button[6]")).click();
			  } catch (Exception e) {
			     JavascriptExecutor executor = (JavascriptExecutor) driver;
			     executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("//button[6]")));
			  }
     	   
     	   
     	  JavascriptExecutor js = (JavascriptExecutor) driver;
     	  js.executeScript("window.scrollTo(0,3316)");
     	  
     	  
     	 try {
		     driver.findElement(By.cssSelector(".\\_2prNUdeCKH:nth-child(2)")).click();
		  } catch (Exception e) {
		     JavascriptExecutor executor = (JavascriptExecutor) driver;
		     executor.executeScript("arguments[0].click();", driver.findElement(By.cssSelector(".\\_2prNUdeCKH:nth-child(2)")));
		  }
     	 Thread.sleep(10000);
     	 
     	try {
		     driver.findElement(By.xpath("/html/body/div[2]/div[3]/div[3]/div[5]/div/div[1]/div/div/div/article[1]/div[4]/div[1]/h3/a/span")).click();
		  } catch (Exception e) {
		     JavascriptExecutor executor = (JavascriptExecutor) driver;
		     executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("/html/body/div[2]/div[3]/div[3]/div[5]/div/div[1]/div/div/div/article[1]/div[4]/div[1]/h3/a/span")));
		  }
     	
     	for (String tab: driver.getWindowHandles())
     	{
     		driver.switchTo().window(tab);
     	}
     	
     	 WebElement link = driver.findElement(By.xpath("//div[2]/div[5]/div/div[4]/div/div[1]/div/div/div[2]/div[1]/div[1]/span"));
     	 
     	 Actions actions = new Actions(driver);
     	 actions.moveToElement(link).build().perform();
     	 
     	 System.out.println("Оценка: " + link.getText());
     	       
     	  Thread.sleep(20000);
     	    //Закрыть браузер
     	    driver.quit();
     	        
	}	
}
