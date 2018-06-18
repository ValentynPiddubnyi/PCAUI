package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.lang.Thread.sleep;

public class ProjectDetailsPage extends BasePage{

    private static final String deleteProjectLocator = "//input/following-sibling::span[contains(text(),'Delete This Project')]/..";
    private static final String confirmDeletingProjectLocator = "//input/following-sibling::span[contains(text(),'Delete')]/..";
    private static final String titleLocator = "//h1[contains(text(), 'Accenture Television 2018 UI Automation Project')]";
    private static final String chipsetLocator = "//span[contains(text(), 'Chipset Manufacturer & Number')]/../../td/span";
    private static final String opationSystem = "//span[contains(text(), 'Operating System')]/../../td/span";

    public ProjectDetailsPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void deleteProject(){
        driver.findElement(By.xpath(deleteProjectLocator)).click();
    }

    public void confirmDeletingProject(){
        WebElement deleteButton = driver.findElements(By.xpath(confirmDeletingProjectLocator)).get(1);
        try {
            sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        deleteButton.click();

    }

    public String getTitle(){
        return driver.findElement(By.xpath(titleLocator)).getText();
    }

    public String getChipset(){
        return driver.findElement(By.xpath(chipsetLocator)).getText();
    }

    public String getOperationSystem() {
        return driver.findElements(By.xpath(opationSystem)).get(1).getText();
    }
}

