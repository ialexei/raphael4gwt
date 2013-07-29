package org.sgx.raphael4gwt.raphy.test.app;

import java.util.LinkedList;
import java.util.List;

import org.sgx.raphael4gwt.raphy.test.tests.BarChartTest1;
import org.sgx.raphael4gwt.raphy.test.tests.CircleProgressChartTest1;
import org.sgx.raphael4gwt.raphy.test.tests.GanttChartTest1;
import org.sgx.raphael4gwt.raphy.test.tests.IndexChartTest1;
import org.sgx.raphael4gwt.raphy.test.tests.LineChartTest1;
import org.sgx.raphael4gwt.raphy.test.tests.PathMenuTest1;
import org.sgx.raphael4gwt.raphy.test.tests.gr.*;

public class RaphyTestHome {
private static RaphyTestHome instance;

private RaphyTestHome() {
	alltests=new LinkedList<RaphyTest>(); 
	initTests();
}


public static RaphyTestHome getInstance() {
	if (instance == null)
		instance = new RaphyTestHome();
	return instance;
}

List<RaphyTest> alltests;


public RaphyTest getByName(String name) {
	for(RaphyTest t : alltests) {
		if(t.getName().equals(name))
			return t;
	}
	return null;
}


private void initTests() {
	alltests.add(new LineChartTest1());
	alltests.add(new PathMenuTest1());
	alltests.add(new BarChartTest1());
	alltests.add(new IndexChartTest1());
	alltests.add(new CircleProgressChartTest1());
//	alltests.add(new GRPieChartTest1());
//	alltests.add(new GRBarChartTest1());
//	alltests.add(new GRDonutChartTest1());
//	alltests.add(new GRCoxcombChartTest1());
//	alltests.add(new GRDotChartTest1());
//	alltests.add(new GRLineChartTest1());
//	alltests.add(new GRRadarChartTest1());
//	alltests.add(new GRRaphalyticsChartTest1());
//	alltests.add(new GRSunBurstChartTest1());
	alltests.add(new GanttChartTest1());
	
}

}


