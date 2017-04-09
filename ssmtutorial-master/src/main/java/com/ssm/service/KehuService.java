package com.ssm.service;



import com.ssm.mapper.TeacherMapper;

import com.ssm.mapper.KehuMapper;

import com.ssm.model.Kehu;

import com.ssm.model.ResponseData;

import com.ssm.model.Teacher;

import org.springframework.context.ApplicationContext;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;



import java.util.List;



/**

 * Created by yang on 06/04/2017.

 */

@Controller

@RequestMapping("/kehu")

public class KehuService {



    private static ApplicationContext ctx;

    private static KehuMapper kehuMapper;





    static {



        // spring-mybatis

        try {

            ctx = new ClassPathXmlApplicationContext("spring-mybatis.xml");

            kehuMapper = (KehuMapper) ctx.getBean("kehuMapper");



        }catch(Exception e){

            e.printStackTrace();

        }

    }



//    @RequestMapping(value = "{id}", method = RequestMethod.GET)

//    public @ResponseBody TeacherMapper (@PathVariable int id) {

//

//        Kehu kehu = kehuMapper.selectKehuByID(id);

//        return kehu;

//    }



    @RequestMapping(method = RequestMethod.GET)

    public @ResponseBody List<Kehu> getAllKehu() {

        System.out.println("1111111111111111111111111111111111111111111111111111111111");

        List<Kehu> kehus = kehuMapper.selectKehus();

        System.out.println(kehus);

        return kehus;

    }
}