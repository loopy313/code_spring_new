package controller;

import domain.SampleDTO;
import domain.TodoDTO;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Logger;

@Controller
@RequestMapping("/sample/*")
@Log4j
public class SampleController {
    @InitBinder
    public void initBinder(WebDataBinder binder){
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-mm-dd");
        binder.registerCustomEditor(Date.class,new CustomDateEditor(dateFormat,false));
    }
    @GetMapping("/ex01")
    public String ex01(SampleDTO dto){
        log.info(""+dto);
        if(dto.getName().equals("abc"))
            log.info(true);
        return "ex01";
    }
    @GetMapping("/ex03")
    public String ex03(TodoDTO todo){
        log.info("todo: "+todo);
        return "ex03";
    }
    @GetMapping("/ex04")
    public String ex04(Model model, SampleDTO dto, @ModelAttribute("page")int page, @RequestParam("reqParam")int param){
        model.addAttribute("abc","abc");
        model.addAttribute("param",param);
        return "sample/ex04";
    }
    @GetMapping("/ex05")
    public void ex05(){
        log.info("/ex05.....");
    }
    @GetMapping("/")
    public String home(Locale locale,Model model){
        log.info("welecome home. locale is {}.");
        return "home";
    }
}
