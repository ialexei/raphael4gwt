package org.sgx.raphael4gwt.raphy.test.tests;

import java.util.HashMap;
import java.util.Map;

import org.sgx.raphael4gwt.raphy.client.Charts;
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

public class LineChartTest1 extends AbstractRaphyTest {

	@Override
	public void test(Element parent) {
//		clear(parent);

		// create a div for the first chart. set dimensions
		DivElement e = Document.get().createDivElement();
//		Document.get().getBody().appendChild(e); 
		parent.appendChild(e);
		e.getStyle().setProperty("width", "400px");
		e.getStyle().setProperty("height", "300px");

		// create and draw a line chart from previous element
		LineChart chart = Charts.LineChart(e);
		chart.add_line(Line.create().data(
				new double[][] { { 1, 828906 }, { 2, 566933 }, { 3, 584150 }, { 4, 1072143 }, { 5, 1622455 },
						{ 6, 2466746 }, { 7, 2427789 } }));
		chart.draw();

		// now another line chart:
		e = Document.get().createDivElement();
		parent.appendChild(e);
		e.getStyle().setProperty("width", "400px");
		e.getStyle().setProperty("height", "300px");

		LineChartOpts opts = LineChartOpts.create().show_grid(true).multi_axis(true);
		chart = Charts.LineChart(e, opts);
		chart.add_line(Line.create().data(
				new Point[] { Point.create(1, 3222), Point.create(2, 1222).tooltip("The pitch bend value"),
						Point.create(3, 2222), Point.create(4, 4222), Point.create(5, 5222), Point.create(6, 2222),
						Point.create(7, 222), }));
		chart.add_line(Line
				.create()
				.data(new double[][] { { 1, 8906 }, { 2, 5693 }, { 3, 5840 }, { 4, 1043 }, { 5, 1455 }, { 6, 2646 },
						{ 7, 2489 } }).options(LineOpts.create().fill_area(true).area_color("#ed2233")));
		chart.draw();

		// now a bar chart - yes we use LineChart render : "bar"
		e = Document.get().createDivElement();
		parent.appendChild(e);
		e.getStyle().setProperty("width", "400px");
		e.getStyle().setProperty("height", "300px");

		opts = LineChartOpts.create().show_grid(true).render("bar");
		chart = Charts.LineChart(e, opts);
		chart.add_line(Line.create().data(
				new Point[] { Point.create(1, 3222), Point.create(2, 1222).tooltip("The pitch bend value"),
						Point.create(3, 2222), Point.create(4, 4222), Point.create(5, 5222), Point.create(6, 2222),
						Point.create(7, 222), }));

		chart.draw();

	}

	// test related information:
	public LineChartTest1() {
		super("LineChartTest1", "LineChartTest1");
	}

	public Map<String, ExternalTextResource> getResources() {
		Map<String, ExternalTextResource> m = new HashMap<String, ExternalTextResource>();
		m.put("LineChartTest1.java", RaphyTestResources.INSTANCE.LineChartTest1());
		return m;
	}
}
