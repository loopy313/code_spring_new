package mapper;

import domain.Criteria;
import domain.ReplyVO;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.IntStream;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {config.RootConfig.class})
@Log4j
public class ReplyMapperTests {
    private Long[] bnoArr={1L,2L,3L,4L,5L};
    @Setter(onMethod_ = @Inject)
    private ReplyMapper mapper;

    @Test
    public void testCreate(){
        IntStream.rangeClosed(1,1).forEach(value -> {
            ReplyVO vo=new ReplyVO();
            vo.setBno(65536L);
            vo.setReply("댓글 테스트"+value);
            vo.setReplyer("replyer"+value);
            mapper.insert(vo);
        });
    }
    @Test
    public void testMapper(){
        log.info(mapper);
    }
    @Test
    public void testRead(){
        Long targetRno=5L;
        ReplyVO vo=mapper.read(targetRno);
        log.info(vo);
    }
    @Test
    public void testDelete(){
        Long targetRno=1L;
        mapper.delete(targetRno);
    }
    @Test
    public void testUpdate(){
        Long targetRno=10L;
        ReplyVO vo=mapper.read(targetRno);
        vo.setReply("Update Reply");
        int count=mapper.update(vo);
        log.info("UPDATE COUNT : "+count);
    }
    @Test
    public void testList(){
        Criteria cri=new Criteria();
        List<ReplyVO> replies=mapper.getListWithPaging(cri,bnoArr[0]);
        replies.forEach(reply -> log.info(reply));
    }
}