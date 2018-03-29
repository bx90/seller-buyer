package sellerbuyer.service;


import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import sellerbuyer.bean.Project;

import java.util.List;

/**
 * @author Boxiong
 * @date 3/28/18
 **/
public class BuyerServiceTest {
    private Project project1;
    @BeforeTest
    public void setup() {
        project1 = new Project();
        project1.setDescription("Test");
        project1.setBudge(100.0);
    }
    @Test
    public void testGetProjects() throws Exception {
        BuyerService buyerService = new BuyerService();
//        SellerService sellerService = new SellerService();


//        sellerService.addProject(project1);
        List<Project> projectList = buyerService.getProjects();

        System.out.println(projectList.get(0).toString());
    }
//    @Test
//    public void testGetProjects() throws Exception {
//        BuyerService buyerService = new BuyerService();
//        SellerService sellerService = new SellerService();
//
//        Project project1 = new Project();
//        project1.setDescription("Test");
//        project1.setBudge(100.0);
//
//        sellerService.addProject(project1);
//        List<Project> projectList = buyerService.getProjects();
//
//        System.out.println(projectList.get(0).toString());
//    }

}