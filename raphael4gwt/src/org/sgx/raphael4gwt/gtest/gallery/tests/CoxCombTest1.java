package org.sgx.raphael4gwt.gtest.gallery.tests;

import java.util.logging.Logger;

import org.sgx.raphael4gwt.graphael.GShape;
import org.sgx.raphael4gwt.graphael.coxcomb.CoxCombData;
import org.sgx.raphael4gwt.graphael.coxcomb.CoxCombOpts;
import org.sgx.raphael4gwt.graphael.pie.PieChart;
import org.sgx.raphael4gwt.graphael.pie.PieOpts;
import org.sgx.raphael4gwt.graphael.pie.PieSector;
import org.sgx.raphael4gwt.graphael.pie.PieSectorCallback;
import org.sgx.raphael4gwt.graphael.pie.PieSectorHoverListener;
import org.sgx.raphael4gwt.gtest.gallery.Test;
import org.sgx.raphael4gwt.raphael.Paper;
import org.sgx.raphael4gwt.raphael.base.Attrs;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Window;

/**
 * using coxcomb chart defining data in JSON using GWT JSNI methods
 * 
 * @author sg
 * 
 */
public class CoxCombTest1 extends Test {

	@Override
	public void test() {
		CoxCombData data1 = getNativeData1().cast();
		CoxCombOpts opts = getNativeOpts();
		getGPaper().coxCombChart(200, 200, 200, data1, opts);
	}

	private final native CoxCombOpts getNativeOpts() /*-{
		var properties = {
			categorySize : 0.20, // percentage of radius used for categories
			categoryFontSize : 10,
			seriesFontSize : 10,
//			onClick : function(polygon, text) {
//				if (lastSelection) {
//					lastSelection.remove();
//				}
//				lastSelection = polygon.glow();
//			},
			stroke : "#fff"
		};
		return properties;
	}-*/;

	private final native JavaScriptObject getNativeData1()/*-{
		var skills = {
			data : {
				Languages : {
					"c++" : 8,
					"lua" : 8,
					"javascript" : 8,
					"python" : 5,
					"clojure" : 4,
					"c" : 9,
				},
				"DB/Search" : {
					"SQL Server" : 8,
					"MySql" : 6,
					"Cassandra" : 7,
					"Redis" : 8,
					"Solr" : 6
				},
				Tools : {
					"WinDbg" : 9,
					"gdb" : 8,
					"IDA Pro" : 6,
					"valgrind" : 7,
					"git" : 7,
					"jenkins" : 8,
					"selenium" : 7,
				},
			},
			colors : {
				category : "#2B2B2B",
				opacity : 0.8,
				fontColor : "#fff",
				byCategory : {
					Tools : {
						color : "#E9E581",
						opacity : 0.8,
						fontColor : "#000000"
					},
					Languages : {
						color : "#DE1B1B",
						opacity : 0.7,
						fontColor : "#fff"
					},
					"DB/Search" : {
						color : "#2B2B2B",
						opacity : 0.1,
						fontColor : "#000000"
					}
				},
			}
		};
		return skills;
	}-*/;

	// test class stuff
	public CoxCombTest1(Paper paper, int paperWidth, int paperHeight) {
		super(paper, paperWidth, paperHeight);
		setName("coxComb1");
		setDescription("using coxcomb chart defining data in JSON using GWT JSNI methods");
	}

	@Override
	public String getJavaClassSource() {
		return TestResources.INSTANCE.DonutChartTest1().getText();
	}

	static Logger logger = Logger.getLogger("DonutChartTest1");
}
