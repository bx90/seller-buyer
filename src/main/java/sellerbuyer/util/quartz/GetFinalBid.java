package sellerbuyer.util.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import sellerbuyer.bean.Bid;
import sellerbuyer.bean.Project;
import sellerbuyer.domain.manager.ProjectManager;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Boxiong
 * @date 3/31/18
 **/
public class GetFinalBid implements Job {
    private static ProjectManager projectManager = new ProjectManager();
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("Getting final bid at " + LocalDateTime.now());
        getLatestBid();
    }

    // scan all the project.
    // compare the status and date.
    //

    public void getLatestBid() {
        List<Project> projectList = projectManager.getProject();
        for (Project p : projectList) {
            if (p.isActive()) {
                System.out.println("final bid for project :" + p.getProjectId() + " is :");
                Bid b = p.getFinalBid();
                p.setActive(false);
                System.out.println(b);
            }
        }
    }
}
