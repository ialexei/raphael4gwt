package org.sgx.raphael4gwt.test;

import org.sgx.raphael4gwt.raphael.Circle;
import org.sgx.raphael4gwt.raphael.Paper;
import org.sgx.raphael4gwt.raphael.event.PaperListener;
import org.sgx.raphael4gwt.raphael.widget.PaperWidget;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * a gwt entry points that use PaperWidget for showing a 
 * raphael paper in it, with other gwt widgets.
 * @author sg
 */
public class Raphael4GwtTestAloneAsync implements EntryPoint, PaperListener {

	String attr1 = "world";
	private PaperWidget paper;
	
	@Override
	public void onModuleLoad() {
		
		VerticalPanel vp = new VerticalPanel();		
		
		//some gwt buttons
		FlowPanel toolbar = new FlowPanel();
		toolbar.add(new Button("action1"));
		toolbar.add(new Button("action2"));
		vp.add(toolbar);
		
		paper = new PaperWidget(600, 600);
		paperLoaded(paper.getPaper()); 
		paper.setSize("100%", "100%");
		vp.add(paper);
		
		/* note: the followind attach all gwt widgets 
		 * elements to the DOM document. raphaeljs requires to create a paper 
		 * in a html element that is attached to document, but because WidgetPanel
		 * do creates the paper asynchronously and only at Widget:onload()
		 * we can safely create the WidgetPanel before attach parent to document.
		 */
		RootPanel.get().add(vp); 
	}
	
	@Override
	public void paperLoaded(Paper paper) {
		//raphael's paper is ready to draw in:
		final Circle circle1 = paper.circle(150, 150, 40);
		circle1.setAttribute("fill", "red");		
	}

}
