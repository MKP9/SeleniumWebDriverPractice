package testSelenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static junit.framework.TestCase.assertEquals;

public class TestSelenium {

    /**
     * This test will open a Google URL, search for an element, and submit the search process.
     * This test incorporates thread sleeping so the user can view Selenium in progress.  This
     * function users driver.quit() which results in the page closing when complete.
     * This test will pass.
     * @throws Exception
     */
    @Test
    public void testGoogleSearch() throws Exception {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Michael\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.google.com");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Selenium");
        searchBox.submit();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
    }

    /**
     * This test will check if the URL opened is equal to the title requested.  Using assertEquals
     * on this test. the title will be verified against the actual title.
     * This test will fail.
     * @throws Exception
     */
    @Test
    public void testChromeDriver() throws Exception {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Michael\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://youtube.com");
        assertEquals(driver.getTitle(), "The Internet");
        System.out.println(driver.getTitle());
    }

    /**
     * This test will check if the URL opened is equal to the title requested.  Using assertEquals
     * on this test. the title will be verified against the actual title.
     * This test will pass.
     * @throws Exception
     */
    @Test
    public void testFitMe() throws Exception {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Michael\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://fit.jlaqua.greenrivertech.net/signup");
        assertEquals(driver.getTitle(), "Signup");
        System.out.println(driver.getTitle());
    }

    /**
     * This test is a sample test found at idodevjobs.wordpress.com for a URL and form
     * field entries and clicking 'submit' button to show how Selenium navigates through
     * a URL form page.
     * This test will pass.
     * Credit: https://idodevjobs.wordpress.com/2015/08/16/java-selenium-acceptance-test-example-part-i/
     */
    @Test
    public void indeedJobSearch() {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Michael\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.indeed.com/");
        //Enter search fields *changed element 'where' from United States to Seattle
        driver.findElement(By.id("what")).sendKeys("Selenium");
        driver.findElement(By.id("where")).clear();
        driver.findElement(By.id("where")).sendKeys("Seattle");
        driver.findElement(By.id("fj")).click();

        //Print off title and job count
        System.out.println(driver.findElement(By.id("searchCount")).getText());
        System.out.println(driver.getTitle());
    }

    /**
     * This test will open the url, enter in a name in the first ID field in the field
     * on the URL, and submit the form.  This test will check if the form field catches
     * form errors upon clicking the 'submit' button.
     * This test will pass, and it also shows the URL form validation.
     * @throws Exception
     */
    @Test
    public void testFitMe2() throws Exception {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Michael\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://fit.jlaqua.greenrivertech.net/signup");
        //Enter search fields
        driver.findElement(By.id("fname")).sendKeys("Jose");
        driver.findElement(By.id("signup-submit")).click();
    }
}