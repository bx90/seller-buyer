package sellerbuyer.util.io;

import com.google.gson.Gson;
import sellerbuyer.model.bean.Project;

import java.util.HashMap;

/**
 * @author Boxiong
 * @date 3/31/18
 **/
public class Util {
    public static <T> T cloneObject(T t) {
        Gson gson = new Gson();
        String json = gson.toJson(t);
        return (T) gson.fromJson(json, t.getClass());
    }


    // The above clone function doesn't work properly with ZonedDateTime...
    // Thus having the below method to unblock implementation.
    public static Project cloneProject(Project inputProject) {
        Project clone = new Project();
        clone.setBids(new HashMap<>(inputProject.getBids()));
        clone.setProjectId(inputProject.getProjectId());
        clone.setDueDate(inputProject.getDueDate());
        clone.setActive(inputProject.isActive());
        clone.setBudge(inputProject.getBudge());
        clone.setDescription(inputProject.getDescription());
        clone.setCreateDate(inputProject.getCreateDate());
        clone.setSellerId(inputProject.getSellerId());
        clone.setFinalBid(inputProject.getFinalBid());
        clone.setDueDate(inputProject.getDueDate());
        clone.setUserInputDueDate(inputProject.getUserInputDueDate());
        clone.setFinalBidPrice(inputProject.getFinalBidPrice());

        return clone;
    }
}
