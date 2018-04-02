package sellerbuyer.model.manager;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import sellerbuyer.model.bean.Project;
import sellerbuyer.util.exception.ValidationException;
import sellerbuyer.util.time.TimeTransformer;

import java.time.ZonedDateTime;
import java.util.HashMap;

/**
 * @author Boxiong
 * @date 4/1/18
 **/
public class ProjectManagerTest {
    ProjectManager projectManager;

    @BeforeTest
    public void setup() {
        projectManager = new ProjectManager();
    }

    @Test
    public void addProjectTest() throws ValidationException {
        Project project = mockUp();
        projectManager.addProject(project, 1L);
    }

    @Test
    public void validateDescriptionTest() {
        try {
            Project project = mockUp();
            project.setDescription("");
            projectManager.addProject(project, 1L);
        } catch (ValidationException e) {
            System.out.println(e.getMessage());
            Assert.assertTrue(e.getMessage().contains("Description is a mandatory field"));
        }
    }

    @Test
    public void validateDueDateIsNullTest() {
        try {
            Project project = mockUp();
            project.setDueDate(null);
            projectManager.addProject(project, 1L);
        } catch (ValidationException e) {
            System.out.println(e.getMessage());
            Assert.assertTrue(e.getMessage().contains("Due date is a mandatory field"));
        }
    }

    @Test
    public void validateDueDateTest() {
        try {
            Project project = mockUp();
            project.setDueDate(TimeTransformer.getZonedDateTime("2002-07-05T22:00"));
            projectManager.addProject(project, 1L);
        } catch (ValidationException e) {
            System.out.println(e.getMessage());
            Assert.assertTrue(e.getMessage().contains("It needs to be after the project created time"));
        }
    }

    private Project mockUp() throws ValidationException {
        Project clone = new Project();
        clone.setBids(new HashMap<>());
        clone.setActive(true);
        clone.setBudge(100.0);
        clone.setDescription("Unit test.");
        clone.setDueDate(TimeTransformer.getZonedDateTime("2020-07-05T22:00"));
        clone.setCreateDate(ZonedDateTime.now());
        clone.setUserInputDueDate("2020-07-05T22:00");

        return clone;
    }
}
