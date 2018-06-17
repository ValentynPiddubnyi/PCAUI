package pages;

import common.Browser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageFactory {

    private WebDriver driver;
    private WebDriverWait wait;

    public PageFactory() {
        this.wait = Browser.getWait();
        this.driver = Browser.getDriver();
    }

    public CreateProjectPage getCreateProjectPage() {
        return new CreateProjectPage(driver, wait);
    }

    public ProjectDetailsPage getProjectDetailsPage() {
            return new ProjectDetailsPage(driver, wait);
    }

    public ProjectsPage getProjectsPage() {
            return new ProjectsPage(driver, wait);
    }
}
