package org.sgx.raphael4gwt.raphy.test.tests;

import java.util.HashMap;
import java.util.Map;

import org.sgx.raphael4gwt.raphy.client.Charts;
import org.sgx.raphael4gwt.raphy.client.index.IndexChart;
import org.sgx.raphael4gwt.raphy.client.index.IndexChartOpts;
import org.sgx.raphael4gwt.raphy.test.app.AbstractRaphyTest;

import com.google.gwt.dom.client.DivElement;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.resources.client.ExternalTextResource;

public class IndexChartTest1 extends AbstractRaphyTest {

	@Override
	public void test(Element parent) {

		// create a div for the first chart. set dimensions
		DivElement e = Document.get().createDivElement();
		parent.appendChild(e);
		e.getStyle().setProperty("width", "500px");
		e.getStyle().setProperty("height", "400px");

		IndexChart index = Charts.IndexChart(e, IndexChartOpts.create().rounding(2));
		index.add("Retail", 18316, 65);
		index.add("IT Software", 28977, 1331);
		index.add("Engineering/Technical", 28977, 282);
		index.add("Education", 20839, 106);
		index.add("Media & Internet", 22488, 92);
		index.add("Business Services", 19397, 85);

		index.add_guide_line("Average", 100, 1);
		index.add_guide_line("Above Average", 500, 0.25);
		index.add_guide_line("High", 1000, 0.25);

		index.draw();

	}

	// test related information:
	public IndexChartTest1() {
		super("IndexChartTest1", "IndexChartTest1");
	}

	public Map<String, ExternalTextResource> getResources() {
		Map<String, ExternalTextResource> m = new HashMap<String, ExternalTextResource>();
		m.put("IndexChartTest1.java", RaphyTestResources.INSTANCE.IndexChartTest1());
		return m;
	}
}
