package org.sgx.raphael4gwt.test;

import org.sgx.raphael4gwt.raphael.Paper;
import org.sgx.raphael4gwt.raphael.base.Attrs;
import org.sgx.raphael4gwt.raphael.util.GUIUtil;
import org.sgx.raphael4gwt.test.gallery.GalleryUtil;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.http.client.URL;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * in this test we will draw some shapes in a paper and them export its content to svg format. 
 * @author sg
 *
 */
public class SVGExportTest1 extends Test {

private DialogBox db;

@Override
public void test() {
	paper.rect(10,20,100,200,12).attr(Attrs.create().fill("red").strokeWidth(8));
	paper.circle(200,200,50);
	paper.ellipse(100,100,50,120);
	
	String svg = paper.toSVG();
	Window.alert("Exported SVG code: \n"+svg);	

	/* we can also inject the svg code directly in a html element (only supported 
	 * in svg based browsers (all but IE<9) - we could use innerHTMl attribute as well. */
	VerticalPanel panel = new VerticalPanel();
	panel.add(new HTML("<div style=\"width: 500px; height: 500px; overflow: scroll\">"+svg+"</div>"));
	panel.add(new Button("Close", new ClickHandler() {		
		@Override
		public void onClick(ClickEvent event) {
			db.hide();
		}
	}));
	db = GUIUtil.createDialogBox("Injected SVG", panel);
	GUIUtil.showDialogBox(db);
	
}

//test data
public String[] getTags() {
	return new String[]{GalleryUtil.TAG_SVG};
}

public SVGExportTest1(Paper paper, int paperWidth, int paperHeight) {
	super(paper, paperWidth, paperHeight);
	this.name="SVGExport";
	this.description="in this test we will draw some shapes in a paper and them export its content to svg format. " +
	"Also we will inject the svg code directly in a html element (only supported in svg based browsers (all but IE<9)";		
}

@Override
public String getJavaClassSource() {
	return TestResources.INSTANCE.SVGExportTest1().getText();
}

}
