package sellerbuyer.model.datacollection.project;

import sellerbuyer.model.bean.Project;
import sellerbuyer.util.io.Util;

/**
 * @author Boxiong
 * @date 3/31/18
 **/
public class SellerProjectCollection implements ProjectCollectionStrategy {
    @Override
    public Project collect(Project inputProject) {
        Project clone = Util.cloneProject(inputProject);
        applyRule(clone);
        return clone;
    }

    private void applyRule(Project project) {
        project.setBids(null);
//        project.setFinalBid(null);
    }
}
