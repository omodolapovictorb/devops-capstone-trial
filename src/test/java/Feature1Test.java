
import org.openqa.selenium.By;
        import org.openqa.selenium.chrome.ChromeDriver;
        import org.openqa.selenium.chrome.ChromeOptions;
        import org.testng.TestNG;
        import org.openqa.selenium.WebDriver;
        import org.testng.annotations.AfterClass;
        import org.testng.annotations.BeforeMethod;
        import org.testng.annotations.BeforeTest;
        import org.testng.annotations.Test;
        import org.testng.asserts.SoftAssert;

public class Feature1Test {
    SoftAssert softAssert1 = new SoftAssert();
    SoftAssert softAssert2 = new SoftAssert();
    SoftAssert softAssert3 = new SoftAssert();

    private WebDriver driver;
    private String title = "Intellipaat";
    private String url = "http://192.168.0.103/";
    private String xPath = "/html/body";

    @BeforeTest
    private void beforetest() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        ChromeOptions options =new ChromeOptions();
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
    }

    @BeforeMethod
    private void open() {
        driver.get(url);
    }

    @Test
    private void websiteAvailabilityTest() {
        try{
            System.out.println("Checking whether webpage is available...");
            softAssert1.assertEquals(url, driver.getCurrentUrl());

        }
        catch(Throwable pageNavigationError){
            System.out.println("Webpage is unavailable");
        }
        finally{
            softAssert1.assertAll();
        }



    }

    @Test
    private void TitleTest() {
        try{
            System.out.println("Validating Expected Webpage title...");
            softAssert2.assertEquals(title, driver.getTitle());
        }
        catch(Exception e){
            System.out.println("Webpage Title Invalid");
        }

        finally{
            softAssert2.assertAll();
        }
    }
    @Test
    private void xPathTest() {
        try{
            System.out.println("Validating Expected Webpage XPath...");
            softAssert3.assertTrue(driver.findElement(By.xpath(xPath)).isDisplayed());
        }
        catch(Exception e){
            System.out.println("Webpage XPath Invalid");
        }
        finally{
            softAssert3.assertAll();
        }

    }

    @AfterClass
    private void close() {
        driver.quit();
    }

    public static void main(String[] args) {
        TestNG testng = new TestNG();
        testng.setTestClasses(new Class[] {Feature1Test.class});
        testng.run();
    }

}




