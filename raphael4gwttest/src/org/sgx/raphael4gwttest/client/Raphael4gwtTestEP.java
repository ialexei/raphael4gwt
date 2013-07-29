package org.sgx.raphael4gwttest.client;

import org.sgx.raphael4gwt.raphael.Paper;
import org.sgx.raphael4gwt.raphael.Raphael;
import org.sgx.raphael4gwt.raphael.base.Attrs;
import org.sgx.raphael4gwt.raphael.event.MouseEventListener;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.NativeEvent;

public class Raphael4gwtTestEP implements EntryPoint {

	@Override
	public void onModuleLoad() {
		test1();
	}


	private void test1() {
		Paper paper = Raphael.paper(0,0,600,600);
		paper.rect(20,20,40,90, 4).attr(Attrs.create().fill("red").opacity(0.6)).click(new MouseEventListener() {	
			@Override
			public void notifyMouseEvent(NativeEvent e) {
				System.out.println("clicked");
			}
		}); 
		
	}

}
