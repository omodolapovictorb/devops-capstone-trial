package testcases.feature1;


/*
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeOptions;

@Test
public class test {

	WebDriver driver;
		public void hello() {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\milkyway\\Documents\\eclipse-workspace\\driver\\chromedriver.exe");///home/ubuntu/chromedriver
			ChromeOptions options =new ChromeOptions();
			//options.addArguments("--headless");
			driver = new ChromeDriver(options);  
			driver.get("http://192.168.0.107/");	
			driver.findElement(By.xpath("/html/body")).isDisplayed();
	}
	
	public static void main(String[] args) {
		//TestListenerAdapter adap = new TestListenerAdapter();
		TestNG testng = new TestNG();
		testng.setTestClasses(new Class[] {test.class});
		//testng.addListener(adap);
		testng.run();
	}

}
*/


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
//import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeOptions;


public class f1test {
	
	WebDriver driver;
	//String title = "Intellipaat";
	//String url = "http://192.168.0.107/";
	String title = "Google";
	String url = "https:www.google.com";	
	@BeforeTest
	private void beforetest() {
			//System.setProperty("webdriver.chrome.driver", "C:\\Users\\milkyway\\Documents\\eclipse-workspace\\driver\\chromedriver.exe");///home/ubuntu/chromedriver
		System.setProperty("webdriver.chrome.driver", "/home/milkyway/chromedriver");///home/ubuntu/chromedriver	
		ChromeOptions options =new ChromeOptions();
			options.addArguments("--headless");
			driver = new ChromeDriver(options);  	
	}
	
	@BeforeMethod
	private void open() {
		driver.get(url);
	}
	
	
	@Test
	private void websiteTest() {
		/*
		Boolean result = driver.findElement(By.xpath("//h2[contains(text(),'Hello world!')]")).isDisplayed();
		System.out.println(result);
		if (result) {
			System.out.println("Webpage is available");
			System.out.println("Test Successful");
		}
		else {
			System.out.println("Webpage is unavailable");
			System.out.println("Test Unsuccessful");
		}
		*/	
		try{
			  Assert.assertEquals(url, driver.getCurrentUrl());
			  System.out.println("Navigated to correct webpage");
			}
			catch(Throwable pageNavigationError){
			  System.out.println("Didn't navigate to correct webpage");
			}
		
		
	}
	
	@Test
	private void TitleTest() {
		/*
		String result = driver.getTitle();
		System.out.println(result);
		
		if (result=="Intellipaat") {
			System.out.println("Webpage Title is correct");
			System.out.println("Test Succesful");
		}
		else {
			System.out.println("Webpage Title is incorrect");
			System.out.println("Test Unsuccesful");
		}
		 */	
		/*
		driver.getTitle().equals("Intellipaat");
		if (driver.getTitle().equals("Intellipaat"))
		 {							
				System.out.println("Webpage Title is correct");
				System.out.println("Test Succesful");				
        } else {			
			System.out.println("Webpage Title is incorrect");
			System.out.println("Test Unsuccesful");					
        }	
        */	
		
		try{
			  Assert.assertEquals(title, driver.getTitle());
			  System.out.println("Navigated to correct webpage");
			}
			catch(Throwable pageNavigationError){
			  System.out.println("Didn't navigate to correct webpage");
			}
	}
	
	@AfterClass
	private void close() {
		driver.quit();
	}
	
	public static void main(String[] args) {
		//TestListenerAdapter adap = new TestListenerAdapter();
		TestNG testng = new TestNG();
		testng.setTestClasses(new Class[] {f1test.class});
		//testng.addListener(adap);
		testng.run();
	}
}

