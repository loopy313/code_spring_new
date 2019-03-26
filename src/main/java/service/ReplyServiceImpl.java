package service;

import domain.Criteria;
import domain.ReplyPageDTO;
import domain.ReplyVO;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import mapper.BoardMapper;
import mapper.ReplyMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;

@Service
@Log4j
public class ReplyServiceImpl implements ReplyService {

    @Setter(onMethod_ = @Inject)
    private ReplyMapper mapper;
    @Setter(onMethod_ = @Inject)
    private BoardMapper boardMapper;

    @Transactional
    @Override
    public int register(ReplyVO vo) {
        log.info("register....." + vo);
        boardMapper.updateReplyCnt(vo.getBno(),1);
        return mapper.insert(vo);

    }

    @Override
    public ReplyVO get(Long rno) {
        log.info("get....." + rno);
        return mapper.read(rno);
    }

    @Override
    public int modify(ReplyVO reply) {
        log.info("modify....." + reply);
        return mapper.update(reply);
    }

    @Transactional
    @Override
    public int remove(Long rno) {
        log.info("remove....." + rno);
        ReplyVO vo=mapper.read(rno);
        boardMapper.updateReplyCnt(vo.getBno(),-1);
        return mapper.delete(rno);
    }

    @Override
    public List<ReplyVO> getList(Criteria cri, Long bno) {
        log.info("get Reply List of a Board" + bno);
        return mapper.getListWithPaging(cri, bno);
    }

    @Override
    public ReplyPageDTO getListPage(Criteria cri, Long bno) {
        return new ReplyPageDTO(mapper.getCountByBno(bno), mapper.getListWithPaging(cri, bno));
    }

}
