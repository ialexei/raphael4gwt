package org.sgx.raphael4gwt.test;

import org.sgx.raphael4gwt.raphael.Paper;
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
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * in this test we will import a svg file generated with a 3rd party like corel draw or inskape. 
 * the file will be loaded with ajax, parset to a XML document and then imported into the 
 * raphaël paper. Note that for this example to work you must include 
 * <inherits name="com.google.gwt.http.HTTP" /> in your gwt module definition
 * @author sg
 *
 */
public class SVGImportTest1 extends Test {

@Override
public void test() {
	VerticalPanel p = GalleryUtil.getInstance().getTestPanel();
	
	p.add(new Button("svgExample1.svg", new ClickHandler() {		
		@Override
		public void onClick(ClickEvent event) {
			loadSvg("org.sgx.raphael4gwt.Raphael4GwtTest/test/svgExample1.svg"); 
		}
	})); 
	
	p.add(new Button("svgExample2.svg", new ClickHandler() {		
		@Override
		public void onClick(ClickEvent event) {
			loadSvg("org.sgx.raphael4gwt.Raphael4GwtTest/test/svgExample2.svg"); 
		}
	}));

}

protected void loadSvg(String svgUri) {
	
	RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, URL.encode(svgUri));

	try {
		
	Request request = builder.sendRequest(null, new RequestCallback() {
		@Override
		public void onResponseReceived(Request request, Response response) {
			 if (200 == response.getStatusCode()) {
				 
				paper.importSvg( response.getText());
				
		      } else {
		    	  Window.alert("Error when trying to get the svg file. Status: "+
		    			  response.getStatusText());
		      }
		}

		@Override
		public void onError(Request request, Throwable exception) {
			Window.alert("Error when trying to get the svg file. ");
		}       
	});
	
	} catch (RequestException e) {
		Window.alert("Error when trying to get the svg file. ");     
	}
}

//test params
public String[] getTags() {
	return new String[]{GalleryUtil.TAG_SVG};
}

public SVGImportTest1(Paper paper, int paperWidth, int paperHeight) {
	super(paper, paperWidth, paperHeight);
	this.name="SVGImport";
	this.description="Show how to import and export from SVG to raphael paper";		
}

@Override
public String getJavaClassSource() {
	return TestResources.INSTANCE.SVGImportTest1().getText();
}

}
