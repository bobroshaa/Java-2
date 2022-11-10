package by.bsuir.poit.wt.dao;

import by.bsuir.poit.wt.entity.Appliance;
import by.bsuir.poit.wt.entity.criteria.Criteria;


public interface ApplianceDAO {

    Appliance find(Criteria criteria);
}