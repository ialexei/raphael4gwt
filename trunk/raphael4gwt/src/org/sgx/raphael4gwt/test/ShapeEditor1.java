package org.sgx.raphael4gwt.test;

import org.sgx.raphael4gwt.raphael.Paper;
import org.sgx.raphael4gwt.raphael.Raphael;
import org.sgx.raphael4gwt.raphael.Set;
import org.sgx.raphael4gwt.raphael.Shape;
import org.sgx.raphael4gwt.raphael.base.Attrs;
import org.sgx.raphael4gwt.raphael.base.Point;
import org.sgx.raphael4gwt.raphael.event.DDListener;
import org.sgx.raphael4gwt.raphael.event.MouseEventListener;
import org.sgx.raphael4gwt.raphael.ft.FTAttrs;
import org.sgx.raphael4gwt.raphael.ft.FTCallback;
import org.sgx.raphael4gwt.raphael.ft.FTOptions;
import org.sgx.raphael4gwt.raphael.ft.FTSubject;
import org.sgx.raphael4gwt.raphael.ft.FreeTransform;
import org.sgx.raphael4gwt.test.gallery.GalleryUtil;

import com.google.gwt.core.client.JsArrayString;
import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
/**
 * @author sg
 *
 */
public class ShapeEditor1 extends Test {
	
	private Shape rect;
	private Label mouseCoordsLabel;
	protected Shape ellipse;
	private Shape mask=null;
	private MouseEventListener selectionToolClickListener;
	private Label ftStatus;
	protected FreeTransform freeTransform;
	
	@Override
	public void test() {
		rect = paper.rect(0,0,paper.getWidth(), paper.getHeight()).attr(
			Attrs.create().fill("yellow")
		);
		paper.text(100,100, "Welcome to this humble shape editor, \nthe tools are above.");
		
		//install a back rect for logging mouse coords.
		rect.mouseMove(new MouseEventListener() {			
			@Override
			public void notifyMouseEvent(NativeEvent e) {
				mouseCoordsLabel.setText("inPaper: "+
						Raphael.getCoordsInPaper(paper, e).print());
			}
		}, 200);
		doPanels();		
	}

	private void doPanels() {
		VerticalPanel testPanel = GalleryUtil.getInstance().getTestPanel();
		testPanel.add(new Label(" *** TOOLS *** "));
		FlowPanel fp = new FlowPanel();		
		testPanel.add(fp);
		
		fp.add(new Button("ellipse", new ClickHandler() {			
			@Override
			public void onClick(ClickEvent event) {
				doEllipseTool();
			}
		}));
		fp.add(new Button("rect", new ClickHandler() {			
			@Override
			public void onClick(ClickEvent event) {
				doRectTool();
			}
		}));
		fp.add(new Button("selection", new ClickHandler() {			
			@Override
			public void onClick(ClickEvent event) {
				doSelectionTool();
			}
		}));
		fp.add(new Button("free transform", new ClickHandler() {			
			@Override
			public void onClick(ClickEvent event) {
				doFreeTransformTool();
			}
		}));
		
		FlowPanel fp2 = new FlowPanel();
		testPanel.add(fp2);
		
		fp2.add(new Label("mouse coords: "));
		mouseCoordsLabel=new Label("");
		fp2.add(mouseCoordsLabel);
		
		fp2.add(new Label("free transform: "));
		ftStatus=new Label("");
		fp2.add(ftStatus);
	}

	protected void doRectTool() {
		uninstallAllTools();
		createMask();
		mask.drag(new DDListener() {			
			private Shape rect2;
			@Override
			public void onStart(int x, int y, NativeEvent e) {
				Point coords = Raphael.getCoordsInPaper(paper, e);
				rect2 = paper.rect(coords.getX(), coords.getY(), 0,0).attr(
						Attrs.create().fill(randomColor())
				);
			}			
			@Override
			public void onMove(int dx, int dy, int x, int y, NativeEvent e) {
				rect2.attr(Attrs.create().width(Math.abs(dx)).height(Math.abs(dy)));
			}			
			@Override
			public void onEnd(NativeEvent e) {				
			}
		}, 200);
	}

	/** first usecase step - draw an ellipse using drag and drop:*/
	private void doEllipseTool() {
		uninstallAllTools();
		createMask();
		mask.drag(new DDListener() {			
			@Override
			public void onStart(int x, int y, NativeEvent e) {
				Point coords = Raphael.getCoordsInPaper(paper, e);
				ellipse = paper.ellipse(coords.getX(), coords.getY(), 0,0).attr(
						Attrs.create().fill(randomColor())
				);
			}			
			@Override
			public void onMove(int dx, int dy, int x, int y, NativeEvent e) {
				ellipse.attr(Attrs.create().rx(Math.abs(dx)).ry(Math.abs(dy)));
			}			
			@Override
			public void onEnd(NativeEvent e) {				
			}
		}, 200);
	}

	protected void doSelectionTool() {
		uninstallAllTools();
		createMask();
		selectionToolClickListener=new MouseEventListener() {			
			@Override
			public void notifyMouseEvent(NativeEvent e) {	
				
				Set els = paper.getTransfElementsByPoint(
						Raphael.getCoordsInPaper(paper, e));
				els.exclude(mask);
				els.exclude(rect);
				mask.remove();
//				els.forEach(new ForEachCallback() {					
//					@Override
//					public boolean call(Shape shape, int index) {	
//						shape.glow(null);
//						return true;
//					}
//				});
				Window.alert("selected elements: "+els.print());
			}
		};		
		mask.click(selectionToolClickListener);
	}

	protected void doFreeTransformTool() {
		uninstallAllTools();
		createMask();
		selectionToolClickListener=new MouseEventListener() {			
			@Override
			public void notifyMouseEvent(NativeEvent e) {	
				Set els = paper.getElementsByPoint(Raphael.getCoordsInPaper(paper, e));
				els.exclude(mask);
				els.exclude(rect);
				mask.remove();
				final FTOptions ftOpts = FTOptions.create();
				ftOpts.setRotate(true);
				ftOpts.setAttrs(FTAttrs.create().fill("red").strokeWidth(4).stroke("blue"));
				final FTCallback callback = new FTCallback() {				
					@Override
					public void call(FTSubject s, JsArrayString events) {
//						ftStatus.setText(
//							"translate: " + s..getTranslateX()+", "+s.getTranslateY()+
//							", center: "+s.getCx()+", "+s.getCy()+
//							", rotation: "+s.getRotate()+
//							"\nsize: "+s.getHeight()+", "+s.getWidth()+" - "+
//							", scale: "+s.getScaleX()+", "+s.getScaleY()+" - "+
//							"\nEvents: "+events.join(", ")
//							);
					}
				};
				freeTransform = paper.freeTransform(els, ftOpts, callback);
				//don't forget to call updateHandles in the free transform object!
				freeTransform.updateHandles(); 
			}
		};		
		mask.click(selectionToolClickListener);
	}
	private void createMask() {
		mask = paper.rect(0,0,paper.getWidth(), paper.getHeight()).attr(
			Attrs.create().fill("blue").opacity(0.2)
		);
	}

	private void uninstallAllTools() {
		if(mask==null)
			return;
		mask.unclick(selectionToolClickListener);
		mask.undrag();
		mask.remove();
		if(freeTransform!=null)
			freeTransform.unplug();
	}
	
	
	//test information:
	public String[] getTags() {
		return new String[]{GalleryUtil.TAG_SHAPE, GalleryUtil.TAG_EVENT, 
				GalleryUtil.TAG_SET, GalleryUtil.TAG_EXTENSION};
	}
	public ShapeEditor1(Paper paper, int paperWidth, int paperHeight) {
		super(paper, paperWidth, paperHeight);
		this.name="editor1";
		this.description="small editor of shapes and selection - common usecxases when developing an editor";		
	}		
	@Override
	public String getJavaClassSource() {
		return TestResources.INSTANCE.ShapeEditor1().getText();
	}

}
