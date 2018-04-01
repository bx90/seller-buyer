package sellerbuyer.model.bean;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Boxiong
 * @date 3/31/18
 **/
@XmlRootElement
public class ExceptionMessage {
    String errorMessage;

    public ExceptionMessage() {
    }

    public ExceptionMessage(String errorMessage) {
        super();
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

}
