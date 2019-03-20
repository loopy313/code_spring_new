package mapper;

import domain.BoardVO;
import domain.Criteria;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {config.RootConfig.class})
@Log4j
public class BoardMapperTests {
    @Setter(onMethod_ = @Inject)
    private BoardMapper mapper;

    @Test
    public void testGetList(){
        mapper.getList().forEach(board->log.info(board));
    }

    @Test
    public void testInsert(){
        BoardVO board=new BoardVO();
        board.setTitle("new title");
        board.setWriter("new writer");
        board.setContent("new content");
        mapper.insert(board);
    }

    @Test
    public void testInsertSelectKey(){
        BoardVO board=new BoardVO();
        board.setTitle("new title");
        board.setContent("new content");
        board.setWriter("new writer");
        mapper.insertSelectKey(board);
        log.info(board);
    }

    @Test
    public void testRead(){
        BoardVO board=mapper.read(5L);
        log.info(board);
    }

    @Test
    public void testUpdate(){
        BoardVO board=new BoardVO();
        board.setBno(5l);
        board.setTitle("update title");
        board.setContent("update content");
        board.setWriter("upate writer");

        int count=mapper.update(board);
        log.info("UPDATE COUNT: "+count);
    }

    @Test
    public void testPaging(){
        Criteria cri=new Criteria();
        cri.setAmount(5);
        cri.setPageNum(3);
        List<BoardVO> list= mapper.getListWithPaging(cri);

        list.forEach(board -> log.info(board));
    }
}