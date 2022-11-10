package by.bsuir.poit.wt.dao;

import by.bsuir.poit.wt.dao.impl.ApplianceDAOImpl;


public final class DAOFactory {

    private static final DAOFactory instance = new DAOFactory();

    private final ApplianceDAO applianceDAO;

    private DAOFactory() {
        this.applianceDAO = new ApplianceDAOImpl();
    }

    public static DAOFactory getInstance() {
        return instance;
    }

    public ApplianceDAO getApplianceDAO() {
        return applianceDAO;
    }
}