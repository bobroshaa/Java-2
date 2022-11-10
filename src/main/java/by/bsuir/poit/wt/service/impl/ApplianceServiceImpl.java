package by.bsuir.poit.wt.service.impl;

import by.bsuir.poit.wt.dao.ApplianceDAO;
import by.bsuir.poit.wt.dao.DAOFactory;
import by.bsuir.poit.wt.entity.Appliance;
import by.bsuir.poit.wt.entity.criteria.Criteria;
import by.bsuir.poit.wt.service.ApplianceService;
import by.bsuir.poit.wt.service.validation.Validator;


public class ApplianceServiceImpl implements ApplianceService {


	@Override
	public Appliance find(Criteria crit) {
		if (!Validator.criteriaValidator(crit)) {
			return null;
		}
		DAOFactory factory = DAOFactory.getInstance();
		ApplianceDAO applianceDAO = factory.getApplianceDAO();
		return applianceDAO.find(crit);
	}
}