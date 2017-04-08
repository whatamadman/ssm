package com.ssm.service;

import com.ssm.mapper.SalesmanMapper;
import com.ssm.model.ResponseData;
import com.ssm.model.Salesman;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    @RequestMapping(method = RequestMethod.POST)

    public @ResponseBody ResponseData addTeacher(@RequestBody Salesman salesman) {



        ResponseData responseData = new ResponseData();

        salesmanMapper.addSalesman(salesman);

        responseData.setSuccess(true);

        return responseData;

    }
    @RequestMapping(value = "{id}", method = RequestMethod.PUT)

    public @ResponseBody ResponseData updateSalesman(@RequestBody Salesman salesman, @PathVariable int id) {



        ResponseData responseData = new ResponseData();

        Salesman salesmanForUpdate = salesmanMapper.selectSalesmanByID(id);

        salesmanForUpdate.setName(salesman.getName());

        salesmanForUpdate.setDate(salesman.getDate());

        // to finish all setter...

        salesmanMapper.updateSalesman(salesmanForUpdate);



        responseData.setSuccess(true);

        return responseData;

    }
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)

    public @ResponseBody ResponseData deleteSalesman(@PathVariable int id) {



        ResponseData responseData = new ResponseData();

        salesmanMapper.deleteSalesman(id);



        responseData.setSuccess(true);

        return responseData;

    }
}