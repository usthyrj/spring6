package ltd.regis.spring6.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VipDao {
    private static final Logger logger = LoggerFactory.getLogger(VipDao.class);


    public void insert() {
//        System.out.println("数据库正在保存用户信息");
        logger.info("数据库正在保存VIP信息.....");
    }

}