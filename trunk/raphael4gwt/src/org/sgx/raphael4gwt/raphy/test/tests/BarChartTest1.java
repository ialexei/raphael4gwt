package org.sgx.raphael4gwt.raphy.test.tests;

import java.util.HashMap;
import java.util.Map;

import org.sgx.raphael4gwt.raphy.client.Charts;
import org.sgx.raphael4gwt.raphy.client.bar.Bar;
import org.sgx.raphael4gwt.raphy.client.bar.BarChart;
import org.sgx.raphael4gwt.raphy.client.bar.BarChartOpts;
import org.sgx.raphael4gwt.raphy.client.bar.BarOpts;
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

public class BarChartTest1 extends AbstractRaphyTest {

	@Override
	public void test(Element parent) {
//		clear(parent);

		// create a div for the first chart. set dimensions
		DivElement e = Document.get().createDivElement();
		parent.appendChild(e);
		e.getStyle().setProperty("width", "400px");
		e.getStyle().setProperty("height", "300px");
		
		BarChart chart = Charts.BarChart(e, BarChartOpts.create().x_label_color("#333344").bar_width(45).rounding(10));
		chart.add(Bar.create().label("foo").value(300));
		chart.add(Bar.create().label("boo").value(400));
		chart.add(Bar.create().label("moo").value(200));
		chart.add(Bar.create().label("goo").value(300).options(BarOpts.create().bar_color("#ffee33")));
		chart.add(Bar.create().label("hoo").value(100));
		chart.draw();

	}

	// test related information:
	public BarChartTest1() {
		super("BarChartTest1", "BarChartTest1");
	}

	public Map<String, ExternalTextResource> getResources() {
		Map<String, ExternalTextResource> m = new HashMap<String, ExternalTextResource>();
		m.put("BarChartTest1.java", RaphyTestResources.INSTANCE.BarChartTest1());
		return m;
	}
}
