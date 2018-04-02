package sellerbuyer.model.bean;

/**
 * @author Boxiong
 * @date 4/1/18
 **/

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Compose the object links.
 */
@XmlRootElement
public class Link {
    private String link;
    private String rel;

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getRel() {
        return rel;
    }

    public void setRel(String rel) {
        this.rel = rel;
    }
}
