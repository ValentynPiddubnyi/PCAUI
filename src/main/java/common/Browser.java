package common;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by fil on 2/5/15.
 */
public class Browser {
    private static WebDriver driver;
    private static WebDriverWait wait;

    public static void initDriver(){

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 5);
        driver.manage().window().maximize();
    }

    public static WebDriver getDriver(){
        return driver;
    }
    public static WebDriverWait getWait() {return wait; }

    public static void close() {
        driver.close();
    }
    public static void quit() { driver.quit(); }

    //TO DO
    public static void waitUntilJSReady() {
        WebDriverWait wait = new WebDriverWait(driver,15);
        JavascriptExecutor jsExec = (JavascriptExecutor) driver;

        //Wait for Javascript to load
        ExpectedCondition<Boolean> jsLoad = driver -> ((JavascriptExecutor) driver)
                .executeScript("return document.readyState").toString().equals("complete");

        //Get JS is Ready
        boolean jsReady =  (Boolean) jsExec.executeScript("return document.readyState").toString().equals("complete");

        //Wait Javascript until it is Ready!
        if(!jsReady) {
            System.out.println("JS in NOT Ready!");
            //Wait for Javascript to load
            wait.until(jsLoad);
        } else {
            System.out.println("JS is Ready!");
        }
    }
}
