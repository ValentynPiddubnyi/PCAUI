import common.Browser;
import org.testng.annotations.AfterClass;
import pages.PageFactory;

public class BaseTest {

    protected PageFactory pages;

    public void setUp(){
        Browser.initDriver();
        pages = new PageFactory();
    }

    @AfterClass
    public void aftter(){
        Browser.quit();
    }
}
