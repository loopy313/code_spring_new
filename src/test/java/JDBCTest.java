import lombok.extern.log4j.Log4j;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
@Log4j
public class JDBCTest {
    static{
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("static");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @Test
    public void testConnection(){
        try(Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","pc23","java")){
            log.info(con);
        }catch(Exception e){
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test1() {
        Assert.assertNotNull(new Object());
    }
}
