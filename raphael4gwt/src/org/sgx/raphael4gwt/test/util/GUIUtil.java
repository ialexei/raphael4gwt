package org.sgx.raphael4gwt.test.util;

import java.util.LinkedList;
import java.util.List;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
/**
 * 
 * @author sg
 *
 */
public class GUIUtil {

	public static String formLabelWidth="120px";
	

	/**
	 * common method for dispatching rpc / services exceptions
	 * @param t
	 */
	public static void dispatchRPCError(Throwable t) {
		dispatchRPCError("RPC Error - Fail to comunicate with server: ", t);		
	}

	public static void dispatchRPCError(String msg, Throwable t) {
//		showMessageDialog1(msg);
		com.google.gwt.user.client.Window.alert(msg+" "+t.getLocalizedMessage());
//		if(Util.isDebug())
//			t.printStackTrace();
	}

	/**
	 * common method for dispatching rpc / services exceptions
	 * @param msg 
	 * @param t
	 */
	public static void dispatchServiceError(String msg, Exception t) {
		String s = "Service Error: "+msg+" - "+t.getMessage()+" - "+t;
		Window.alert(s);
//		if(Util.isDebug())
//			t.printStackTrace();
	}

	
	
	
	
	//dialogs
	
	public static DialogBox createDialogBox(String title, Widget content) {
		DialogBox box = new DialogBox();
		box.setText(title); 		
		VerticalPanel p = new VerticalPanel();
		p.add(content);
		box.add(p);
		return box;
	}	

	public static void showMessage(String title, String msg) {
		VerticalPanel p = new VerticalPanel();		
		p.add(new Label(msg));
		Button  b = new Button("OK");
		p.add(b);	
		final DialogBox d = createDialogBox(title, p);
		b.addClickHandler(new ClickHandler() {			
			@Override
			public void onClick(ClickEvent event) {
				d.hide();
			}
		});
		showDialogBox(d);		
	}
	public static void showText(String title, String txt) {
		VerticalPanel p = new VerticalPanel();
		TextArea ta = new TextArea();
		ta.setText(txt);
		ta.setSize("100%", "100%");
		p.add(ta);
		Button  b = new Button("OK");
		p.add(b);	
		final DialogBox d = createDialogBox(title, p);
		b.addClickHandler(new ClickHandler() {			
			@Override
			public void onClick(ClickEvent event) {
				d.hide();
			}
		});
		ta.setSize("600px", (getMaxHeight()-200)+"px");
		showDialogBox(d);		
	}
	private static void showDialogBox(DialogBox d) {
		d.setAnimationEnabled(true);
		d.setGlassEnabled(true);
		d.center();
		d.show();
	}

	public static void showErrorMessage(String title, String s) {
		showMessage(title, s);
	}
	public static void showErrorMessage(String title, Exception e) {
		showErrorMessage(title, e.getMessage());
	}
//	private static GWTCAlert showMessageDialog1Alert=null;
//	public static void showMessageDialog1(String msg) {
//		if(showMessageDialog1Alert==null) {
//			showMessageDialog1Alert=new GWTCAlert();
//		}
//		showMessageDialog1Alert.alert(msg);
//	}
	
	
	//misc gui utils
	
	public static List<String> getSelectedTexts(ListBox l) {
		List<String> labels = new LinkedList<String>();
		for (int i = 0; i < l.getItemCount(); i++) {
			if(l.isItemSelected(i))
				labels.add(l.getItemText(i));
		}
		return labels;
	}

	public static int getMaxHeight() {
		return (Window.getClientHeight()-20);
	}
	public static String getMaxHeightStr() {
		return getMaxHeight()+"px";
	}

	

	

}
