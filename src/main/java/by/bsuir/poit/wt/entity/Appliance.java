package by.bsuir.poit.wt.entity;

import java.util.List;


public class Appliance {

    List<String> applianceList;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Appliance:\n");
        for (String appliance : applianceList) {
            sb.append("\t").append(appliance).append(";\n");
        }
        return sb.toString();
    }


    public Appliance(List<String> result){
        this.applianceList = result;
    }
}