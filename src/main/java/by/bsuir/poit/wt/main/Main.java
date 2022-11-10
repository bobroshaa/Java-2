package by.bsuir.poit.wt.main;

import by.bsuir.poit.wt.entity.Appliance;
import by.bsuir.poit.wt.entity.criteria.Criteria;
import by.bsuir.poit.wt.entity.criteria.SearchCriteria.*;
import by.bsuir.poit.wt.service.ApplianceService;
import by.bsuir.poit.wt.service.ServiceFactory;

public class Main {

	public static void main(String[] args) {
		Appliance appliace;

		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		ApplianceService service = serviceFactory.getApplianceService();

		Criteria criteriaOven = new Criteria(Oven.class.getSimpleName());//"Oven"
		criteriaOven.add(Oven.CAPACITY.toString(), 3);

		appliace = service.find(criteriaOven);

		PrintApplianceInfo.print(appliace);

		criteriaOven = new Criteria(Oven.class.getSimpleName());
		criteriaOven.add(Oven.HEIGHT.toString(), 200);
		criteriaOven.add(Oven.DEPTH.toString(), 300);

		appliace = service.find(criteriaOven);

		PrintApplianceInfo.print(appliace);
		
		Criteria criteriaTabletPC = new Criteria(TabletPC.class.getSimpleName());
		criteriaTabletPC.add(TabletPC.COLOR.toString(), "BLUE");
		criteriaTabletPC.add(TabletPC.DISPLAY_INCHES.toString(), 14);
		criteriaTabletPC.add(TabletPC.MEMORY_ROM.toString(), 4);

		appliace = service.find(criteriaOven);

		PrintApplianceInfo.print(appliace);

	}

}
