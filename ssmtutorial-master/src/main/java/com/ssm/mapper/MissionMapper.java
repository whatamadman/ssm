package com.ssm.mapper;

import com.ssm.model.Mission;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Administrator on 2017/4/9.
 */
public interface MissionMapper {
    @Autowired
    public List<Mission> selectMissions();
}
