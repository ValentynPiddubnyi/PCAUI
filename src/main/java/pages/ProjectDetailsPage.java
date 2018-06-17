package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.lang.Thread.sleep;

public class ProjectDetailsPage extends BasePage{

    public ProjectDetailsPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void deleteProject(){
        driver.findElement(By.xpath("//input/following-sibling::span[contains(text(),'Delete This Project')]/..")).click();
    }

    public void confirmDeletingProject(){
        WebElement deleteButton = driver.findElements(By.xpath("//input/following-sibling::span[contains(text(),'Delete')]/..")).get(1);
        try {
            sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        deleteButton.click();

    }

    public String getTitel(){
        return driver.findElement(By.xpath("//h1[contains(text(), 'Accenture Television 2018 UI Automation Project')]")).getText();
    }

    public String getChipset(){
        return driver.findElement(By.xpath("//span[contains(text(), 'Chipset Manufacturer & Number')]/../../td/span")).getText();
    }

    public String getOperationSystem() {
        return driver.findElements(By.xpath("//span[contains(text(), 'Operating System')]/../../td/span")).get(1).getText();
    }
}

