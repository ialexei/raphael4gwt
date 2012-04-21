//package org.sgx.raphael4gwt.graphael;
//
//import org.sgx.raphael4gwt.raphael.PaperWidget;
//import org.sgx.raphael4gwt.raphael.Raphael;
//import org.sgx.raphael4gwt.raphael.event.PaperListener;
//
//public class GPaperWidget extends PaperWidget {
//
//	public GPaperWidget(int paperWidth, int paperHeight, PaperListener onload) {
//		super(paperWidth, paperHeight, onload);		
//	}
//	
//	@Override
//	protected void onLoad() {
//		super.onLoad();
//		paper = Raphael.paper(getElement(), paperWidth, paperHeight);
//		__onload.paperLoaded(paper);
//	}
//}
