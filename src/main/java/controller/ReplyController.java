package controller;

import domain.Criteria;
import domain.ReplyVO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.ReplyService;

import javax.sound.midi.Soundbank;
import java.util.List;

@RequestMapping("/replies/")
@RestController
@Log4j
@AllArgsConstructor
public class ReplyController {

    //@allArgsConstructor로 단일 파라미터를 가지는 생성자가 만들어지므로 의존성이 자동 주입됨(spring4.3이상)
    private ReplyService service;

    @PostMapping(value = "/new", consumes = "application/json", produces = {MediaType.TEXT_PLAIN_VALUE})
    public ResponseEntity<String> create(@RequestBody ReplyVO vo) {
        log.info("ReplyVO: " + vo);
        int insertCount = service.register(vo);
        log.info("Reply INSERT COUNT: " + insertCount);
        return insertCount == 1 ? new ResponseEntity<>("success", HttpStatus.OK) : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping(value = "/pages/{bno}/{page}", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE})
    public ResponseEntity<List<ReplyVO>> getList(@PathVariable("bno") Long bno, @PathVariable("page") int page) {
        log.info("getList....................");
        Criteria cri = new Criteria(page, 10);
        log.info(cri);
        List<ReplyVO> li=service.getList(cri,bno);
        return new ResponseEntity<>(service.getList(cri, bno), HttpStatus.OK);
    }

    @GetMapping(value = "/{rno}", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<ReplyVO> get(@PathVariable("rno") Long rno) {
        log.info("get : " + rno);
        return new ResponseEntity<>(service.get(rno), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{rno}", produces = {MediaType.TEXT_PLAIN_VALUE})
    public ResponseEntity<String> remove(@PathVariable("rno") Long rno) {
        log.info("remove : " + rno);

        return service.remove(rno) == 1 ?
                new ResponseEntity<>("remove success", HttpStatus.OK) : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @RequestMapping(value = "/{rno}",method = {RequestMethod.PUT, RequestMethod.PATCH}, consumes = "application/json",
            produces = {MediaType.TEXT_PLAIN_VALUE})
    public ResponseEntity<String> modify(@RequestBody ReplyVO vo, @PathVariable("rno") Long rno) {
        vo.setRno(rno);
        log.info("rno: " + rno);
        log.info("modify: " + vo);
        return service.modify(vo) == 1 ?
                new ResponseEntity<>("modify success", HttpStatus.OK) : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
