import config.RootConfig;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;
import javax.sql.DataSource;
import java.sql.Connection;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class})
@Log4j
public class DataSourceTests {
    @Setter(onMethod_ = {@Inject})
    private DataSource dataSource;
    @Setter(onMethod_ = {@Inject})
    private SqlSessionFactory sqlSessionFactory;

    @Test
    public void testConnection() {
        try (Connection connection = dataSource.getConnection()) {
            log.info(connection);
        }catch (Exception e){
            Assert.fail(e.getMessage());
        }
    }
    @Test
    public void testMyBatis(){
        try (SqlSession session = sqlSessionFactory.openSession();) {
            Connection con=session.getConnection();
            log.info(session);
            log.info(con);
        }catch (Exception e){
            Assert.fail(e.getMessage());
        }
    }
}