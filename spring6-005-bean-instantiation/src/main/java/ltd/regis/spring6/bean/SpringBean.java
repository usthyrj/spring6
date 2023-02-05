package ltd.regis.spring6.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SpringBean {
    String name;
    Logger logger = LoggerFactory.getLogger(SpringBean.class);
    public SpringBean() {
        logger.info("Spring无参构造执行...");
    }

    public SpringBean(String name) {
        this.name = name;
        logger.info("有参构造执行...");
    }
}
