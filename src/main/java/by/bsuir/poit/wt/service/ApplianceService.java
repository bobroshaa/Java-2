package by.bsuir.poit.wt.service;

import by.bsuir.poit.wt.entity.Appliance;
import by.bsuir.poit.wt.entity.criteria.Criteria;


public interface ApplianceService {

	Appliance find(Criteria criteria);
}
