package com.ssm.service;

import com.ssm.mapper.MissionMapper;
import com.ssm.model.Mission;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Administrator on 2017/4/9.
 */
@Controller
@RequestMapping("/mission")
public class MissionService {
    private static ApplicationContext ctx;

    private static MissionMapper missionMapper;



    static {



        // spring-mybatis

        try {

            ctx = new ClassPathXmlApplicationContext("spring-mybatis.xml");

            missionMapper = (MissionMapper) ctx.getBean("missionMapper");

        }catch(Exception e){

            e.printStackTrace();

        }

    }
    @RequestMapping(method = RequestMethod.GET)

    public @ResponseBody
    List<Mission> getAllMission() {



        List<Mission> mission = missionMapper.selectMissions();

        return mission;

    }
}
