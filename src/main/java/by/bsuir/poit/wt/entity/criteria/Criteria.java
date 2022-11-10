package by.bsuir.poit.wt.entity.criteria;

import java.util.HashMap;
import java.util.Map;


public class Criteria {

    private final String groupSearchName;

    private final Map<String, Object> crit;


    public Criteria(String groupSearchName) {
        this.groupSearchName = groupSearchName;
        this.crit = new HashMap<>();
    }


    public String getGroupSearchName() {
        return groupSearchName;
    }


    public void add(String searchCriteria, Object value) {
        crit.put(searchCriteria, value);
    }


    public Map<String, Object> getCrit() {
        return crit;
    }
}
