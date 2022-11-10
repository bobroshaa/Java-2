package by.bsuir.poit.wt.service.validation;

import by.bsuir.poit.wt.entity.criteria.Criteria;


public class Validator {

	public static boolean criteriaValidator(Criteria crit) {
		return crit != null && crit.getGroupSearchName() != null && crit.getCrit() != null;
	}
}