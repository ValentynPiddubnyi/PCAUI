package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateProjectPage extends BasePage {

    public CreateProjectPage(WebDriver driver, WebDriverWait wait){
        super(driver,wait);
    }

    private static final String accentureLocator = "//div[contains(text(),'Accenture')]";

    public void setPartner(String partnerName){

        driver.findElement(By.xpath(accentureLocator)).click();
        driver.findElement(By.xpath("//a[contains(text(),'" + partnerName + "')]")).click();
    }
    public void setBusinessModel(String businessModel){
        driver.findElement(By.xpath("//div[contains(text(),'OEM')]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'"+ businessModel + "')]")).click();
    }
    public void setDeviceType(String deviceType){
        driver.findElement(By.xpath("//div[contains(text(),'Television')]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'"+ deviceType + "')]")).click();
    }
    public void setModelYear(String modelYear){
        driver.findElement(By.xpath("//div[contains(text(),'2018')]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'"+ modelYear + "')]")).click();
    }
    public void setProjectType(String projectType){
        driver.findElement(By.xpath("//div[contains(text(),'New Device')]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'"+ projectType + "')]")).click();
    }
    public void setProjectDescription(String projectDescription){
        driver.findElement(By.xpath("//textarea")).sendKeys(projectDescription);
    }
    public void setChipset(String chipset){
        driver.findElements(By.xpath("//input[@type='text']")).get(0).sendKeys(chipset);
    }
    public void setGPUSupport(String gpuSupport){
        driver.findElement(By.xpath("//div[contains(text(),'No')]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'"+ gpuSupport + "')]")).click();
    }
    public void setOperatingSystemFamily(String osf){
        driver.findElement(By.xpath("//div[contains(text(),'Android')]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'"+ osf + "')]")).click();
    }
    public void setOperatingSystem(String operatingSystem){
        driver.findElements(By.xpath("//input[@type='text']")).get(1).sendKeys(operatingSystem);
    }
    public void clickSubmit(){
        driver.findElement(By.xpath("//input[@aria-labelledby='submitButton-announce']")).click();
    }
    public String getMainErrorDescriptionText(){
        return driver.findElement(By.xpath("//span[contains(text(),'Project Description is required')]")).getText();
    }
    public String getMainErrorChipsetText(){
        return driver.findElement(By.xpath("//span[contains(text(),'Chipset Manufacturer & Number is required')]")).getText();
    }
    public String getMainErrorOperationSystemText(){
        return driver.findElement(By.xpath("//span[contains(text(),'Operating System is required')]")).getText();
    }
}
