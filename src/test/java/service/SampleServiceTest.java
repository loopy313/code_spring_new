package service;

import config.RootConfig;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class})
@Log4j
public class SampleServiceTest {
    @Setter(onMethod_ = @Inject)
    private TxSampleService txservice;
    @Setter(onMethod_ = @Inject)
    private SampleService service;

//    @Test
//    public void testClass() {
//        log.info(service);
//        log.info(service.getClass().getName());
//    }
//
//    @Test
//    public void testAdd() throws Exception {
//        log.info(service.doAdd("123","456"));
//    }
//
//    @Test
//    public void testAddError() throws Exception {
//        log.info(service.doAdd("123","abc"));
//    }

    @Test
    public void testLong() {
        String str="Starry\r\nStarry\r\nStarry\r\nLook out on a summer's day\r\nPaint your pallet";
        log.info(str.getBytes().length);
        service.addData(str);
    }
}