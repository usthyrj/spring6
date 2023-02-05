package ltd.regis.spring6.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SpringBean {
    Logger logger = LoggerFactory.getLogger(SpringBean.class);
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public SpringBean() {
        logger.info("constructor...");
    }

    public String getName() {
        return name;
    }
}
