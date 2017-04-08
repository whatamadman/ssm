package com.ssm.service;

import com.ssm.mapper.SalesmanMapper;
import com.ssm.model.Salesman;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


/**
 * Created by Administrator on 2017/4/7.
 */
@Controller
@RequestMapping("/salesman")
public class SalesmanService {
    private static ApplicationContext ctx;

    private static SalesmanMapper salesmanMapper;



    static {



        // spring-mybatis

        try {

            ctx = new ClassPathXmlApplicationContext("spring-mybatis.xml");

            salesmanMapper = (SalesmanMapper) ctx.getBean("salesmanMapper");

        }catch(Exception e){

            e.printStackTrace();

        }

    }



    @RequestMapping(value = "{id}", method = RequestMethod.GET)

    public @ResponseBody
    Salesman getSalesman(@PathVariable int id) {



        Salesman salesman = salesmanMapper.selectSalesmanByID(id);

        return salesman;

    }
    @RequestMapping(method = RequestMethod.GET)

    public @ResponseBody List<Salesman> getAllSalesman() {



        List<Salesman> salesmen = salesmanMapper.selectSalesman();

        return salesmen;

    }
}