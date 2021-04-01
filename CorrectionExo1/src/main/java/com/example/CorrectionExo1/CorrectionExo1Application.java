package com.example.CorrectionExo1;

import com.example.CorrectionExo1.dto.SectionDTO;
import com.example.CorrectionExo1.exception.ElementNotFoundException;
import com.example.CorrectionExo1.exception.ElementsAlreadyExistsException;
import com.example.CorrectionExo1.service.SectionService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class CorrectionExo1Application {

	public static void main(String[] args) {
		ApplicationContext ctx=SpringApplication.run(CorrectionExo1Application.class, args);// ctx l'objet Qui contient tout nos bean
		//SectionService service = ctx.getBean(SectionService.class);//
//SectionDTO dto=SectionDTO.builder().id(100).name("Course").delegateId(0).build();
//	try {
//		service.insert(dto);
//	} catch (ElementsAlreadyExistsException e) {
//		System.out.println(e.getMessage());
//		}
//	}
//		try {
//			System.out.println(service.getOne(11));
//			//System.out.println(service.getAll());
//		} catch (ElementNotFoundException e) {
//			System.out.println(e.getMessage());
//		}
		//GETALL
		//service.getAll().forEach(System.out::println);
//		try {
//			service.delete(1111);
//		} catch (ElementNotFoundException e) {
//			System.out.println(e.getMessage());
//		}
//		try {
//			service.update(dto,1111);
//		} catch (ElementNotFoundException e) {
//			System.out.println(e.getMessage());
//		}
	}

}
