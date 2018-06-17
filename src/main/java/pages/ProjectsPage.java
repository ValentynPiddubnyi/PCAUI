package pages;

import objects.Project;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProjectsPage extends BasePage{

    public ProjectsPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void goToPage(){
        driver.get(basePageURL);
    }

    public void createProject(){
        driver.findElement(By.xpath("//input[contains(@type,'submit')]")).click();
    }

    public Project findProjectByName(String projectName){
        WebElement projectElement;
        try {
            projectElement = driver.findElement(By.xpath("//a[contains(text(),'" + projectName + "')]/../.."));
        } catch (NoSuchElementException ex){
            return null;
        }
        Project project = new Project(getProjectName(projectElement));
        project.setId(getProjectId(projectElement));
        project.setType(getProjectType(projectElement));
        project.setOperatingSystem(getProjectOperetingSystem(projectElement));
        project.setStage(getProjectStage(projectElement));
        return project;
    }


    private String getProjectId(WebElement projectElement){
        return projectElement.findElement(By.xpath("/div[1]/span")).getText();
    }
    private String getProjectName(WebElement projectElement){
        return projectElement.findElement(By.xpath("/div[2]/a")).getText();
    }
    private String getProjectType(WebElement projectElement){
        return projectElement.findElement(By.xpath("/div[3]")).getText();
    }
    private String getProjectOperetingSystem(WebElement projectElement){
        return projectElement.findElement(By.xpath("/div[4]")).getText();
    }
    private String getProjectStage(WebElement projectElement){
        return projectElement.findElement(By.xpath("/div[5]/b")).getText();
    }
}
