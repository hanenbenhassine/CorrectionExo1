package com.example.CorrectionExo1.presentation;

import com.example.CorrectionExo1.dto.StudentDTO;
import com.example.CorrectionExo1.dto.container.PagedContainer;
import com.example.CorrectionExo1.exception.DemoException;
import com.example.CorrectionExo1.exception.ElementNotFoundException;
import com.example.CorrectionExo1.exception.WrongPageException;
import com.example.CorrectionExo1.rapport.Rapport;
import com.example.CorrectionExo1.service.DemoService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.PositiveOrZero;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/demo")
public class DemoController {
    private final DemoService service;

    public DemoController(DemoService service) {
        this.service = service;
    }
@GetMapping("/student/{pageNbr}")
@ResponseStatus(HttpStatus.OK)
    public PagedContainer<StudentDTO>getPaged(@PathVariable  @PositiveOrZero int pageNbr) throws Exception {

       Page<StudentDTO> page=service.getAllStudentsPaged(pageNbr);
if(pageNbr>=page.getTotalPages())throw new WrongPageException(pageNbr,page.getTotalPages());
        PagedContainer<StudentDTO>container= new PagedContainer<StudentDTO>(
                page.stream().collect(Collectors.toList()),
                page.getTotalPages(),
                page.getNumberOfElements(),
                page.getNumber());
        if(page.hasNext())
            container.setNextPage("http://localhost:8080/demo/student/"+page.nextPageable().getPageNumber());
        if(page.hasPrevious())

    {
        if (pageNbr >= page.getTotalPages())
            container.setPreviousPage("http://localhost:8080/demo/student/" + (page.getTotalPages()-1));
        else
            container.setPreviousPage("http://localhost:8080/demo/student/" + page.previousPageable().getPageNumber());
    }
    return container;
    }
    @GetMapping("/test2")
    public  void test2(@RequestHeader("accept")String contentType)
    {
        System.out.println();
    }
    @GetMapping("/params")
    public void testParams(@RequestParam Map<String,String> params)
    {
        params.forEach((key,value)-> System.out.println(key+"-"+value));
    }
    @GetMapping("/param")
    public void testParam(@RequestParam("id")int id){
        System.out.println(id);
    }
    @GetMapping("/crash")
    public ResponseEntity<Integer> testCrash()throws DemoException{
        throw new DemoException();

    }
    @ExceptionHandler(DemoException.class)
    public ResponseEntity<Rapport>demoHandler(DemoException e, HttpServletRequest request){
        Rapport r=new Rapport(e.getMessage(),HttpStatus.I_AM_A_TEAPOT.value(),request.getRequestURI());
        return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT)
                .body(r);

 }
}
