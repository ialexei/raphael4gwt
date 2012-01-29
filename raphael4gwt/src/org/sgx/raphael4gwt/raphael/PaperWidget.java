package org.sgx.raphael4gwt.raphael;

import com.google.gwt.dom.client.Style.Overflow;
import com.google.gwt.user.client.ui.SimplePanel;

public class PaperWidget extends SimplePanel {
	private Paper paper=null;
	private int paperWidth=0;
	private int paperHeight=0;
	private Runnable onload__;

	public PaperWidget(int paperWidth, int paperHeight, Runnable onload) {
		this.paperWidth = paperWidth;
		this.paperHeight = paperHeight;
//		paper = Raphael.paper(getElement(), paperWidth, paperHeight);
		getElement().getStyle().setOverflow(Overflow.SCROLL);
		this.onload__=onload;
	}
//	/**
//	 * loads the raphael canvas. Must be called for attaching the raphael canvas to this panel. 
//	 * Must be called after this pannel is added to the document.
//	 * @param w
//	 * @param h
//	 */
//	public void loadRaphael() {
//		paper = Raphael.paper(getElement(), w, h);	
//	}
	public Paper getPaper() {
		return paper;
	}
	
	@Override
	protected void onLoad() {
		System.out.println("onload2");
		super.onLoad();
		paper = Raphael.paper(getElement(), paperWidth, paperHeight);
		onload__.run();	
	}
	
}

