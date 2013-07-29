package org.sgx.raphael4gwttest.client;

import org.sgx.raphael4gwt.graphael.GPaper;
import org.sgx.raphael4gwt.graphael.pie.PieOpts;
import org.sgx.raphael4gwt.raphael.Raphael;

import com.google.gwt.core.client.EntryPoint;

public class GRaphael4gwtTestEP implements EntryPoint {

	@Override
	public void onModuleLoad() {
//		test0();
		test1();
//		testUiBinder1();
	}

//	private void testUiBinder1() {
//		RootPanel.get().add(new MainGameView()); 
//	}

//	private void test0() {
//		Grid grid = new Grid(2,3);
//		RootPanel.get().add(grid); 
//		grid.setWidget(0, 0, new Button("hello"));
//		grid.setWidget(0, 1, new Label("hello"));
//		grid.setWidget(1, 0, new Label("hello"));
//		
//		//create a WidgetPaper - this is a Gwt Widget that contains a paper inside. Pass the paper dimensions (required)
//		PaperWidget paperWidget = new PaperWidget(600,600);
//		paperWidget.getElement().getStyle().setProperty("border", "2px solid #ededed"); 
//		Paper paper = paperWidget.createPaper(); //or paperWidget.getPaper();
//		grid.setWidget(1, 1, paperWidget); 
//		
//		//draw something:
//
//		paper.rect(10,10,40,60,2);
//		
//		
//	}

	private void test1() {
GPaper paper = (GPaper)Raphael.paper(0,0,600,600);
PieOpts opts = PieOpts.create(); 
paper.piechart(200f, 200, 100, new double[]{10, 40, 70, 90}, opts);

	}

}
