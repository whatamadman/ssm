package com.ssm.mapper;

import com.ssm.model.Salesman;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Administrator on 2017/4/6.
 */
public interface SalesmanMapper {
    @Autowired
    public Salesman selectSalesmanByID(int id);
    @Autowired
    public List<Salesman> selectSalesman();
    @Autowired
    public void addSalesman(Salesman salesman);
    @Autowired
    public void updateSalesman(Salesman salesman);
    @Autowired
    public void deleteSalesman(int id);
}
