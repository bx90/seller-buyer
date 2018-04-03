package sellerbuyer.util.quartz.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import sellerbuyer.model.bean.Bid;
import sellerbuyer.model.bean.Message;
import sellerbuyer.model.bean.Project;
import sellerbuyer.model.manager.ProjectManager;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;

/**
 * @author Boxiong
 * @date 3/31/18
 **/
public class GetFinalBidJob implements Job {
    private static ProjectManager projectManager = new ProjectManager();
    private static final Long LATENCY_SECOND = 10L;
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("Getting final bid at " + LocalDateTime.now());
        getFinalBid();
    }

    private void getFinalBid() {
        List<Project> projectList = projectManager.getProject();
        for (Project project : projectList) {
            if (project.isActive() && ZonedDateTime.now().minusSeconds(LATENCY_SECOND).isAfter(project.getDueDate())) {
                System.out.println("Final bid for project :" + project.getProjectId() + " is :");
                Bid bid = project.getFinalBid();
                System.out.println(bid);

                project.setActive(false);
                project.notifySeller(composeMessage(bid));
            }
        }
    }

    private Message composeMessage(Bid bid) {
        Message message = new Message();
        message.setContent("The final bid price for project" + bid.getProjectId() + " is " + bid.getPrice()
                + ". The bid id is "
                + bid.getBidId() + ".");

        return message;
    }
}
