package org.sgx.raphael4gwt.test.graphael.gallery;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

public class GRaphael4GwtTest implements EntryPoint {

	@Override
	public void onModuleLoad() {
		testMainPanel();
//		native2();
	}
	
	private void testMainPanel() {
		RootPanel.get().add(new MainPanel());
	}
//	public final native void native2()/*-{
//		var p = $wnd.Raphael(0,0,1500,1500);
//		p.piechart(320, 240, 150, [55, 20, 13, 32, 5, 1, 2, 10]);
//		
////		p.rect(0,0,1500,1500).attr("fill", "#fff");
////		p.rect(10,10,10,10).attr("fill", "red");
////		var b1 = p.barchart(10, 10, 300, 220, [[55, 20, 13, 32, 5, 1, 2, 10]]);
////		b1.attr("fill", "red");
////		p.hbarchart(330, 10, 300, 220, [[55, 20, 13, 32, 5, 1, 2, 10], [10, 2, 1, 5, 32, 13, 20, 55]], {stacked: true});
//	}-*/;
}
