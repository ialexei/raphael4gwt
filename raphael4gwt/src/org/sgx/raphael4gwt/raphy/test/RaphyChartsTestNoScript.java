package org.sgx.raphael4gwt.raphy.test;

import org.sgx.raphael4gwt.raphy.client.Charts;
import org.sgx.raphael4gwt.raphy.client.RaphyChartsLoader;
import org.sgx.raphael4gwt.raphy.client.line.Line;
import org.sgx.raphael4gwt.raphy.client.line.LineChart;
import org.sgx.raphael4gwt.raphy.test.app.MainPanel;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;

public class RaphyChartsTestNoScript implements EntryPoint {

//	boolean ready=false;

	@Override
	public void onModuleLoad() {
		    
		RaphyChartsLoader.loadRaphy(new RaphyChartsLoader.Listener() {			
			@Override
			public void loaded(Exception error) {
				if(error!=null) {
					Window.alert("ERROR loading Raphy: "+error);
					error.printStackTrace(); 
				}
				else {
					start();
				}
			}
		}); 

	}

	protected void start() {

		RootPanel.get().add(new MainPanel()); 
//		drawChart1(); 
//		drawNative(); 
	}
	
	

//	private final native void drawNative()/*-{
//		var el = $wnd.document.createElement("div"); 
//		$wnd.document.body.appendChild(el); 
//		el.style.width="300px"; 
//		el.style.height="300px"; 
////		$wnd.alert(document.getElementById("chart1"));
//
//		 var chart = new $wnd.Charts.LineChart(el);
//
//
//		//Data is an array of arrays where the first slot is the x label and the 2nd the (y) value to graph
//		chart.add_line({
//		data: [[1, 828906],[2, 566933],[3, 584150],[4, 1072143],[5, 1622455],[6, 2466746],[7, 2427789]]
//		});
//		
//		//Line charts also support custom tooltips, eg: 
//		chart.add_line({
//		data: [[1, 828906, {tooltip: "my special point"}],[2, 566933],[3, 584150],[4, 1072143],[5, 1622455],[6, 2466746],[7, 2427789]]
//		});
//		
//		chart.draw();
//	}-*/;
	
	
//	public void drawChart1() {
////		System.out.println("drawChart1");
//		Element e = Document.get().createDivElement(); //.getElementById("chart1");
//
////		Window.alert(e+"");
//		Document.get().getBody().appendChild(e); 
//		e.getStyle().setProperty("width", "300px");
//		e.getStyle().setProperty("height", "300px"); 
//		
//		LineChart chart = Charts.LineChart(e);
//		System.out.println("chart: "+chart);
//		chart.add_line(Line.create().data(new double[][]{
//			{1, 828906},{2, 566933},{3, 584150},{4, 1072143},{5, 1622455},{6, 2466746},{7, 2427789}						
//		}));
//		chart.draw(); 
//	}


}
