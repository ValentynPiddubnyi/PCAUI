import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.CreateProjectPage;
import pages.ProjectDetailsPage;

import static org.testng.Assert.assertEquals;


public class CreateProjectTest extends BaseTest{

    @BeforeTest
    public void beforeTest(){
        setUp();
        pages.getProjectsPage().goToPage();
    }

    @Test
    public void createProjectTest(){

        pages.getProjectsPage().createProject();
        CreateProjectPage createProjectPage = pages.getCreateProjectPage();

        createProjectPage.clickSubmit();

        assertEquals(createProjectPage.getMainErrorDescriptionText(), "Project Description is required");
        assertEquals(createProjectPage.getMainErrorChipsetText(), "Chipset Manufacturer & Number is required");
        assertEquals(createProjectPage.getMainErrorOperationSystemText(), "Operating System is required");

        createProjectPage.setProjectDescription("This is project for test purpose. Can be deleted");
        long time = System.currentTimeMillis();
        createProjectPage.setChipset("UI Automation Project " + time);
        createProjectPage.setOperatingSystem("Amazon OS");

        createProjectPage.clickSubmit();

        ProjectDetailsPage projectDetailsPage = pages.getProjectDetailsPage();

        assertEquals(projectDetailsPage.getTitel(), "Accenture Television 2018 UI Automation Project " +  time);
        assertEquals(projectDetailsPage.getChipset(), "UI Automation Project " + time);
        assertEquals(projectDetailsPage.getOperationSystem(), "Amazon OS");

        projectDetailsPage.deleteProject();
        projectDetailsPage.confirmDeletingProject();

    }
}
