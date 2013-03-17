package org.sgx.raphael4gwt.raphy.test.tests;

import java.util.HashMap;
import java.util.Map;

import org.sgx.raphael4gwt.raphy.client.Charts;
import org.sgx.raphael4gwt.raphy.client.gantt.GanttChart;
import org.sgx.raphael4gwt.raphy.client.gantt.GanttOpts;
import org.sgx.raphael4gwt.raphy.client.gantt.GanttPhase;
import org.sgx.raphael4gwt.raphy.client.gantt.GanttTask;
import org.sgx.raphael4gwt.raphy.test.app.AbstractRaphyTest;

import com.google.gwt.dom.client.DivElement;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.resources.client.ExternalTextResource;

public class GanttChartTest1 extends AbstractRaphyTest {

	@Override
	public void test(Element parent) {
		// create a div for the first chart. set dimensions
		DivElement e = Document.get().createDivElement();
		parent.appendChild(e);
		e.getStyle().setProperty("width", "700px");
		e.getStyle().setProperty("height", "200px");
				
		GanttOpts opts = GanttOpts.create()
				.name("Project Name").startDate("2012-06-28").endDate("2012-07-10")
				.phases(
					GanttPhase.create().name("Phase 1").startDate("2012-06-28").endDate("2012-07-04")
					.tasks(GanttTask.create().name("Task 1").startDate("2012-06-28").endDate("2012-07-01"), 
							GanttTask.create().name("Task 2").startDate("2012-06-29").endDate("2012-07-04")), 
								
					GanttPhase.create().name("Phase 2").startDate("2012-07-05").endDate("2012-07-10")
					.tasks(GanttTask.create().name("Task 3").startDate("2012-07-05").endDate("2012-07-08"), 
							GanttTask.create().name("Task 4").startDate("2012-07-09").endDate("2012-07-10"))); 
		
		GanttChart chart = Charts.GanttChart(e); 
		chart.loadData(opts); 
		chart.draw(); 
		
	}

	// test related information:
	public GanttChartTest1() {
		super("GanntChartTest1", "GanntChartTest1");
	}

	public Map<String, ExternalTextResource> getResources() {
		Map<String, ExternalTextResource> m = new HashMap<String, ExternalTextResource>();
		m.put("GanntChartTest1.java", RaphyTestResources.INSTANCE.GanntChartTest1());
		return m;
	}
}
