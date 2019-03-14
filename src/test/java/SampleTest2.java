import config.RootConfig;
import lombok.Setter;

import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import sample.Restaurant;

import javax.inject.Inject;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootConfig.class)
@Log4j
public class SampleTest2 {
    @Setter(onMethod_ = {@Inject})
    private Restaurant restaurant;

    @Test
    public void testExist(){
        assertTrue(true);
        assertNotNull(restaurant);
        log.info(restaurant);
        log.info("---------------------------");
        log.info(restaurant.getChef());
    }
}
