package service;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
import mapper.Sample1Mapper;
import mapper.Sample2Mapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;

@Service
@Log4j
public class SampleServiceImpl implements  SampleService{
    @Setter(onMethod_ = @Inject)
    private Sample1Mapper mapper1;
    @Setter(onMethod_ = @Inject)
    private Sample2Mapper mapper2;

    @Override
    public Integer doAdd(String str1, String str2) throws Exception {
        return Integer.parseInt(str1)+Integer.parseInt(str2);
    }

    @Override
    @Transactional
    public void addData(String value){
        log.info("mapper1...........................");
        mapper1.insertCol1(value);
        log.info("mapper2...........................");
        mapper2.insertCol2(value);
        log.info("end...............................");
    }
}
