package org.sgx.raphael4gwt.raphy.test.tests;

import java.util.HashMap;
import java.util.Map;

import org.sgx.raphael4gwt.raphy.client.Charts;
import org.sgx.raphael4gwt.raphy.client.bar.Bar;
import org.sgx.raphael4gwt.raphy.client.bar.BarChart;
import org.sgx.raphael4gwt.raphy.client.bar.BarChartOpts;
import org.sgx.raphael4gwt.raphy.client.bar.BarOpts;
import org.sgx.raphael4gwt.raphy.client.circleprogress.CircleProgressChart;
import org.sgx.raphael4gwt.raphy.client.line.Line;
import org.sgx.raphael4gwt.raphy.client.line.LineChart;
import org.sgx.raphael4gwt.raphy.client.line.LineChartOpts;
import org.sgx.raphael4gwt.raphy.client.line.LineOpts;
import org.sgx.raphael4gwt.raphy.client.line.Point;
import org.sgx.raphael4gwt.raphy.test.app.AbstractRaphyTest;

import com.google.gwt.dom.client.DivElement;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.resources.client.ExternalTextResource;

public class CircleProgressChartTest1 extends AbstractRaphyTest {

	@Override
	public void test(Element parent) {

		// create a div for the first chart. set dimensions
		DivElement e = Document.get().createDivElement();
		parent.appendChild(e);
		e.getStyle().setProperty("width", "400px");
		e.getStyle().setProperty("height", "300px");
		
		CircleProgressChart chart = Charts.CircleProgressChart(e, "Health", 76); 
		chart.draw();
	}

	// test related information:
	public CircleProgressChartTest1() {
		super("CircleProgressChartTest1", "CircleProgressChartTest1");
	}

	public Map<String, ExternalTextResource> getResources() {
		Map<String, ExternalTextResource> m = new HashMap<String, ExternalTextResource>();
		m.put("CircleProgressChartTest1.java", RaphyTestResources.INSTANCE.CircleProgressChartTest1());
		return m;
	}
}
