package service;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {config.RootConfig.class})
@Log4j
public class BoardServiceTest {
    @Setter(onMethod_ = {@Inject})
    private BoardService service;

    @Test
    public void testExist(){
        log.info(service);
        Assert.assertNotNull(service);
    }


}