package org.sgx.raphael4gwt.gtest.gallery.tests;

import java.util.logging.Logger;

import org.sgx.raphael4gwt.graphael.GShape;
import org.sgx.raphael4gwt.graphael.coxcomb.CoxCombData;
import org.sgx.raphael4gwt.graphael.coxcomb.CoxCombDataColor;
import org.sgx.raphael4gwt.graphael.coxcomb.CoxCombDataColors;
import org.sgx.raphael4gwt.graphael.coxcomb.CoxCombEventListener;
import org.sgx.raphael4gwt.graphael.coxcomb.CoxCombOpts;
import org.sgx.raphael4gwt.graphael.coxcomb.JsMap;
import org.sgx.raphael4gwt.graphael.coxcomb.JsMapDouble;
import org.sgx.raphael4gwt.graphael.pie.PieChart;
import org.sgx.raphael4gwt.graphael.pie.PieOpts;
import org.sgx.raphael4gwt.graphael.pie.PieSector;
import org.sgx.raphael4gwt.graphael.pie.PieSectorCallback;
import org.sgx.raphael4gwt.graphael.pie.PieSectorHoverListener;
import org.sgx.raphael4gwt.gtest.gallery.Test;
import org.sgx.raphael4gwt.raphael.Paper;
import org.sgx.raphael4gwt.raphael.Shape;
import org.sgx.raphael4gwt.raphael.base.Attrs;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Window;

/**
 * using cox comb chart and creating the data in java : http://jsfiddle.net/EuMQ5/
 * 
 * @author sg
 * 
 */
public class CoxCombTest2 extends Test {

	@Override
	public void test() {
		
		CoxCombDataColors colors=CoxCombDataColors.create()
			.category("#2B2B2B")
			.byCategory(JsMap.create()
				.put("Languages", 
					CoxCombDataColors.create()
					.opacity(0.8)
					.color("#E9E581")
					.fontColor("#ffffff")
				)
				.put("J2EE Frameworks", 
					CoxCombDataColors.create()
					.opacity(0.8)
					.color("#00ed55")
					.fontColor("#000000")
				)
				.put("SOs", 
					CoxCombDataColors.create()
					.opacity(0.8)
					.color("#00edff")
					.fontColor("#0000ff")
				)
				.put("Testing", 
					CoxCombDataColors.create()
					.opacity(0.8)
					.color("#ffed55")
					.fontColor("#ff0000")
				))
			.opacity( 0.8).fontColor("#ffffff").cast();
		
		JsMap<JsMapDouble> data = JsMap.<JsMapDouble>create()
			.put("Languages", JsMapDouble.create()
				.put("c++", 6)
				.put("java", 10)
				.put("JavaScript", 10)
				.put("python", 5)
			)
			.put("J2EE Frameworks", JsMapDouble.create()
				.put("spring", 7)
				.put("hibernate", 8)
				.put("struts", 5)
			)
			.put("SOs", JsMapDouble.create()
				.put("GNU/Linux", 7)
				.put("Windows Server 2000", 4)
			)		
			.put("Testing", JsMapDouble.create()
				.put("JUnit", 8)
				.put("jMeter", 5)
				.put("selenium", 7)
			);
		
		CoxCombData data1 = CoxCombData.create().colors(colors).data(data );
		
		CoxCombOpts opts = CoxCombOpts.create()
				.categorySize(0.2)
				.categoryFontSize(10)
				.seriesFontSize(10)
				.stroke("#ffffff")
				.onClick(new CoxCombEventListener() {

					@Override
					public void notifyEvent(Shape polygon, String label) {
						Window.alert("clicked: "+label); 
						polygon.attr(Attrs.create().stroke("red").strokeWidth(3)); 
					}
				});
		getGPaper().clear(); 
		getGPaper().coxCombChart(200, 180, 200, data1, opts);
	}


	// test class stuff
	public CoxCombTest2(Paper paper, int paperWidth, int paperHeight) {
		super(paper, paperWidth, paperHeight);
		setName("coxComb2");
		setDescription("using cox comb chart and creating the data in java");
	}

	@Override
	public String getJavaClassSource() {
		return TestResources.INSTANCE.CoxCombTest2().getText();
	}

	static Logger logger = Logger.getLogger("DonutChartTest1");
}
