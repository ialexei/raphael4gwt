package org.sgx.raphael4gwt.test;

import org.sgx.raphael4gwt.raphael.Attr;
import org.sgx.raphael4gwt.raphael.Paper;
import org.sgx.raphael4gwt.raphael.Path;
import org.sgx.raphael4gwt.raphael.ft.FTCallback;
import org.sgx.raphael4gwt.raphael.ft.FTOptions;
import org.sgx.raphael4gwt.raphael.ft.FTSnap;
import org.sgx.raphael4gwt.raphael.ft.FTSubject;
import org.sgx.raphael4gwt.raphael.ft.FreeTransform;
import org.sgx.raphael4gwt.test.gallery.GalleryUtil;
import org.sgx.raphael4gwt.test.image.IconPaths;

import com.google.gwt.core.client.JsArrayString;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.VerticalPanel;
/**
 * raphael4gwt support free transform raphaeljs extension from 
 * https://github.com/ElbertF/Raphael.FreeTransform. 
 * this shows how to use it.
 * @author sg
 *
 */
public class FreeTransformTest2 extends Test {

	private TextArea ta;

	@Override
	public void test() {		
		final Path p = paper.path(IconPaths.question).attr(new Attr().fill("red")).cast();
		final FTOptions ftOpts = FTOptions.create().setDraw(new String[]{"bbox", "circle"}).
			setSnap(new FTSnap(30, 20, 50)).setSnapDist(new FTSnap(0, 0, 30));
		
		final FTCallback callback = new FTCallback() {				
			@Override
			public void call(FTSubject s, JsArrayString events) {
				ta.setText(
					"translate: " + s.getTranslateX()+", "+s.getTranslateY()+
					", center: "+s.getCx()+", "+s.getCy()+
					", rotation: "+s.getRotate()+
					"\nsize: "+s.getHeight()+", "+s.getWidth()+" - "+
					", scale: "+s.getScaleX()+", "+s.getScaleY()+" - "+
					"\nEvents: "+events.join(", "));
			}
		};
						
						
		final FreeTransform ft = paper.freeTransform(p, ftOpts, callback);
		ftOpts.attrs().setScale("");
		ft.apply();
	
		//create a text area gwt ui widget for loggin events
		VerticalPanel testPanel = GalleryUtil.getInstance().getTestPanel();
		ta = new TextArea();
		ta.setSize("100%", "60px");
		ta.getElement().setId("seba123");
		testPanel.add(ta);
	
	}
	
	
	//test only stuff:
	public String[] getTags() {
		return new String[]{GalleryUtil.TAG_FT};
	}
	@Override
	public String getJavaClassSource() {
		return TestResources.INSTANCE.FreeTransformTest2().getText();
	}

	public FreeTransformTest2(Paper paper, int paperWidth, int paperHeight) {
		super(paper, paperWidth, paperHeight);
		this.name="FreeTransformTest2";
		this.description="FreeTransformTest2";		
	}



}
