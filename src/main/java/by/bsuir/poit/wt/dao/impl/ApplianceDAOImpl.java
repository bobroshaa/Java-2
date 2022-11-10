package by.bsuir.poit.wt.dao.impl;

import by.bsuir.poit.wt.dao.ApplianceDAO;
import by.bsuir.poit.wt.entity.Appliance;
import by.bsuir.poit.wt.entity.criteria.Criteria;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class ApplianceDAOImpl implements ApplianceDAO {

	private static final String FILE_PATH = ".\\src\\main\\resources\\db.txt";

	private static final String GROUP_DELIMITER = ":";

	private static final String INFO_DELIMITER = " ";


	@Override
	public Appliance find(Criteria criteria) {
		try {
			return getApplianceWithCriteria(criteria);
		} catch (IOException e) {
			System.out.println("Error: can't read the file");
			return null;
		}
	}

	private Appliance getApplianceWithCriteria(Criteria criteria) throws IOException {
		Map<String, List<String>> groupedAppliances = getGroups();
		if (groupedAppliances.containsKey(criteria.getGroupSearchName())) {
			return new Appliance(getCorrespondLines(criteria, groupedAppliances));
		} else {
			return null;
		}
	}

	private List<String> getCorrespondLines(Criteria criteria, Map<String, List<String>> groupedAppliances) {
		List<String> resultAppliances = new ArrayList<>();
		for (String groupItem : groupedAppliances.get(criteria.getGroupSearchName())) {
			if (checkCriteria(criteria, groupItem)) {
				resultAppliances.add(groupItem.substring(0, groupItem.length() - 1));
			}
		}
		return resultAppliances;
	}

	private boolean checkCriteria(Criteria criteria, String groupItem) {
		for (String criteriaValue : getCriteriaStrings(criteria)) {
			if (!groupItem.contains(criteriaValue)) {
				return false;
			}
		}
		return true;
	}

	private List<String> getCriteriaStrings(Criteria criteria) {
		List<String> criteriaStrings = new ArrayList<>();
		Map<String, Object> criteriaValues = criteria.getCrit();
		for (String criteriaName : criteriaValues.keySet()) {
			criteriaStrings.add(criteriaName + "=" + criteriaValues.get(criteriaName).toString());
		}
		return criteriaStrings;
	}

	private static Map<String, List<String>> getGroups() throws IOException {
		Map<String, List<String>> groups = new HashMap<>();
		for (String line : readLines()) {
			processGroup(groups, line);
		}
		return groups;
	}

	private static void processGroup(Map<String, List<String>> groups, String line) {
		String[] groupDivision = line.split(GROUP_DELIMITER);
		if (groups.containsKey(groupDivision[0])) {
			groups.get(groupDivision[0]).add(groupDivision[1]);
		} else {
			addNewGroup(groups, groupDivision);
		}
	}

	private static void addNewGroup(Map<String, List<String>> groups, String[] groupDivision) {
		List<String> applianceContainer = new ArrayList<>();
		applianceContainer.add(groupDivision[1]);
		groups.put(groupDivision[0], applianceContainer);
	}

	private static List<String> readLines() throws IOException {
		Stream<String> linesStream = Files.lines(Path.of(FILE_PATH));
		return linesStream
				.map(line -> String.join( "",line.split(INFO_DELIMITER)))
				.filter(line -> !line.equals(""))
				.collect(Collectors.toList());
	}
}