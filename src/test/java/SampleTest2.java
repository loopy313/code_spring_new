import config.RootConfig;
import lombok.Setter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import sample.Restaurant;
import static org.junit.Assert.assertNotNull;

import javax.inject.Inject;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootConfig.class)
public class SampleTest2 {
    @Setter(onMethod_ = {@Inject})
    private Restaurant restaurant;

    @Test
    public void testExist(){
        assertNotNull(restaurant);
    }
}
