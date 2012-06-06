package org.sgx.raphael4gwt.raphael;

import org.sgx.raphael4gwt.raphael.event.PaperListener;

import com.google.gwt.dom.client.Style.Overflow;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.SimplePanel;
/**
 * a gwt widget with a rapahel paper inside. Paper will have fixed size and the widget will s
 * how scrollbars by default.. <br/>
 * Use Widget.onload and loads asyncronously because raphael paper must be instantiated on an html element
 * attached to body and in gwt widget code you can create widgets and the attach them to document.
 * 
 * @author sg
 *
 */
public class PaperWidget extends FocusPanel {
	private Paper paper=null;
	private int paperWidth=0;
	private int paperHeight=0;
	private PaperListener __onload;

	public PaperWidget(int paperWidth, int paperHeight, PaperListener onload) {
		this.paperWidth = paperWidth;
		this.paperHeight = paperHeight;
		getElement().getStyle().setOverflow(Overflow.SCROLL);
		this.__onload=onload;
	}
	
	public Paper getPaper() {
		return paper;
	}
	
	@Override
	protected void onLoad() {
		super.onLoad();
		paper = Raphael.paper(getElement(), paperWidth, paperHeight);
		__onload.paperLoaded(paper);
	}
	
}

