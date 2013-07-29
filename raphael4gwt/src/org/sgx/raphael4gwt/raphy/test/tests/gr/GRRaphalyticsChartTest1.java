//package org.sgx.raphael4gwt.raphy.test.tests.gr;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import org.sgx.raphael4gwt.gtest.gallery.tests.RaphalyticsTest1;
//import org.sgx.raphael4gwt.raphael.Paper;
//import org.sgx.raphael4gwt.raphael.Raphael;
//import org.sgx.raphael4gwt.raphy.test.app.AbstractRaphyTest;
//import org.sgx.raphael4gwt.raphy.test.tests.RaphyTestResources;
//
//import com.google.gwt.dom.client.DivElement;
//import com.google.gwt.dom.client.Document;
//import com.google.gwt.dom.client.Element;
//import com.google.gwt.resources.client.ExternalTextResource;
//
//public class GRRaphalyticsChartTest1 extends AbstractRaphyTest {
//
//	@Override
//	public void test(Element parent) {
//		int width=500, height=300;
//		DivElement e = Document.get().createDivElement();
//		parent.appendChild(e);
//		e.getStyle().setProperty("width", width+"px");
//		e.getStyle().setProperty("height", height+"px");
//		
//		Paper paper = Raphael.paper(e, width, height); 
//		org.sgx.raphael4gwt.gtest.gallery.tests.RaphalyticsTest1 test = new RaphalyticsTest1(paper, width, height);
//		test.test(); 
//	}
//
//	// test related information:
//	public GRRaphalyticsChartTest1() {
//		super("GRRaphalyticsChartTest1", "GRRaphalyticsChartTest1");
//	}
//
//	public Map<String, ExternalTextResource> getResources() {
//		Map<String, ExternalTextResource> m = new HashMap<String, ExternalTextResource>();
//		m.put("RaphalyticsTest1.java", RaphyTestResources.INSTANCE.GRRaphalyticsTest1());
//		return m;
//	}
//}
