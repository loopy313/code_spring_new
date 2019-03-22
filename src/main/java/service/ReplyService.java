package service;

import domain.Criteria;
import domain.ReplyVO;

import java.util.List;

public interface ReplyService {
    public int register(ReplyVO vo);
    public ReplyVO get(Long rno);
    public int modify(ReplyVO reply);
    public int remove(Long rno);
    public List<ReplyVO> getList(Criteria cri, Long bno);
}
