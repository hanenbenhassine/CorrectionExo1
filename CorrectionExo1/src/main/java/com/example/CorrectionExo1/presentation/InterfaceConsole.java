package com.example.CorrectionExo1.presentation;

import com.example.CorrectionExo1.dto.SectionDTO;
import com.example.CorrectionExo1.exception.ElementNotFoundException;
import com.example.CorrectionExo1.exception.ElementsAlreadyExistsException;
import com.example.CorrectionExo1.service.CrudSerivce;
import org.apache.tomcat.util.net.jsse.JSSEUtil;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.InputMismatchException;
import java.util.Scanner;

@Component
@Profile("console")
public class InterfaceConsole implements InitializingBean {
    private final Scanner scanner;
 private final CrudSerivce<SectionDTO, Integer>serivce;
    public InterfaceConsole(Scanner scanner, CrudSerivce<SectionDTO, Integer> serivce) {
        this.scanner = scanner;
        this.serivce = serivce;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
     start();
    }
    public void start(){
        int choix=0;
        while(choix!=6){
            showMenu();
            choix=getChoix();
            mapChoix(choix);
        }
    }
    private void showMenu(){
        System.out.println("MENU");
        System.out.println("1- Get All");
        System.out.println("2- Get One");
        System.out.println("3- Insert");
        System.out.println("4- Delete");
        System.out.println("5- Update");
        System.out.println("6- Quiter");
    }
    private int getChoix(){

        System.out.println("Veuillez entrer votre choix :");
        int choix=1;
        try {
           choix= scanner.nextInt();
        }catch (InputMismatchException ignored){

        }
        scanner.nextLine();

        return choix;
    }
    public void mapChoix(int choix){
        switch (choix){
            case 1:
                getAll();
                break;
            case 2:
                getOne();
                break;
            case 3:
                insert();
                break;
            case 4:
                delete();
                break;
            case 5:
                update();
                break;
            case 6:
                System.out.println("au revoir");
                break;
            default:
                System.out.println("choix invalide");
        }

    }
    private void getOne(){
        System.out.println("--> ID :");
try {
  int id=  scanner.nextInt();
    System.out.println(serivce.getOne(id));
}catch (InputMismatchException e){
    System.out.println("entree invalide");
    scanner.nextLine();
}catch (ElementNotFoundException e){
    System.out.println(e.getMessage());
}
    }
    private void getAll(){
        serivce.getAll().forEach(System.out::println);
    }
    private void insert(){
        int id;
        String name;
        int delegateId;


        try {
            System.out.println("-->ID :");
            id=scanner.nextInt();
            scanner.nextLine();
            System.out.println("-->Name :");
            name=scanner.nextLine();
            System.out.println("-->DELEGATE_ID :");
            delegateId=scanner.nextInt();
            scanner.nextLine();
            SectionDTO dto=SectionDTO.builder()
                    .id(id)
                    .name(name)
                    .delegateId(delegateId)
                    .build();
            serivce.insert(dto);
        } catch (InputMismatchException e) {
            System.out.println("Entrée invalide");
            scanner.nextLine();
        }catch (ElementsAlreadyExistsException e){
            System.out.println(e.getMessage());
        }
    }
    private void update(){  int id;
        String name;
        int delegateId;


        try {
            System.out.println("-->ID :");
            id=scanner.nextInt();
            scanner.nextLine();
            SectionDTO old=serivce.getOne(id);
            System.out.println("-->Name ["+old.getName()+"] :");
            name=scanner.nextLine();
            System.out.println("-->DELEGATE_ID :["+old.getDelegateId()+"] :");
            delegateId=scanner.nextInt();
            scanner.nextLine();
            SectionDTO dto=SectionDTO.builder()
                    .id(id)
                    .name(name)
                    .delegateId(delegateId)
                    .build();
            serivce.update(dto,id);
        } catch (InputMismatchException e) {
            System.out.println("Entrée invalide");
            scanner.nextLine();
        }catch (ElementNotFoundException e){
            System.out.println(e.getMessage());
        }}
    private void delete(){
        System.out.println("-->ID:");
        try {
         int id=   scanner.nextInt();
            scanner.nextLine();
            serivce.delete(id);
        }catch (InputMismatchException e) {
            System.out.println("Entrée invalide");
        }catch (ElementNotFoundException e){
            System.out.println(e.getMessage());
        }

    }
}
