package by.bsuir.poit.wt.service;

import by.bsuir.poit.wt.service.impl.ApplianceServiceImpl;


public final class ServiceFactory {

    private static final ServiceFactory instance = new ServiceFactory();

    private final ApplianceService applianceService;

    private ServiceFactory() {
        this.applianceService = new ApplianceServiceImpl();
    }

    public static ServiceFactory getInstance() {
        return instance;
    }

    public ApplianceService getApplianceService() {
        return applianceService;
    }
}
