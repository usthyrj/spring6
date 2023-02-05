package ltd.regis.spring6.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Star {
    Logger logger = LoggerFactory.getLogger(Star.class);
    public Star() {
        logger.info("Star空参构造执行了");
    }
}
