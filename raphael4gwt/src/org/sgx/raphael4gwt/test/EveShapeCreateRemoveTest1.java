package org.sgx.raphael4gwt.test;

import org.sgx.raphael4gwt.raphael.Paper;
import org.sgx.raphael4gwt.raphael.Shape;
import org.sgx.raphael4gwt.raphael.base.Attrs;
import org.sgx.raphael4gwt.raphael.eve.Eve;
import org.sgx.raphael4gwt.raphael.eve.ShapeCreateEvent;
import org.sgx.raphael4gwt.raphael.eve.ShapeCreateListener;
import org.sgx.raphael4gwt.raphael.util.ShapeUtil;
import org.sgx.raphael4gwt.raphael.util.Util;
import org.sgx.raphael4gwt.test.gallery.GalleryUtil;

import com.google.gwt.user.client.Window;
/**shows how to register and trigger elementCreate and elementRemove eve events
 * @author sg
 *
 */
public class EveShapeCreateRemoveTest1 extends Test {
	
	int flag=0;
	
	@Override
	public void test() {
		Util.cleanTests();
		
		//listen for any kind of shape creation
		Eve.on("raphael.elementCreate.*", new ShapeCreateListener() {			
			@Override
			public Object call(ShapeCreateEvent e) {
				flag++;
				Shape shape = e.getNativeContext().cast();
				Window.alert("new shape created: "+ShapeUtil.print(shape));
				return null;
			}
		});

		Util.assertEquals(0, flag, "eve attr event 1");
		
		Shape rect = paper.rect(80,80,200,300).attr(
			Attrs.create().fill("yellow")
		);
		
		Util.assertEquals(1, flag, "eve attr event 2");
		
		//trigger an event programtically
//		MouseEveEvent me1 = new MouseEveEvent();
//		me1.set
//		Eve.trigger();
//		Util.assertEquals(0, flag, "eve attr event 1");
		
		Window.alert(Util.printAssertsFailed());
		
	}

	//test information:
	@Override
	public String[] getTags() {
		return new String[]{GalleryUtil.TAG_EVENT, GalleryUtil.TAG_EXTENSION, GalleryUtil.TAG_EVE};
	}
	public EveShapeCreateRemoveTest1(Paper paper, int paperWidth, int paperHeight) {
		super(paper, paperWidth, paperHeight);
		this.name="eve create/remove shape";
		this.description="shows how to register and trigger elementCreate and elementRemove eve events";		
	}		
	@Override
	public String getJavaClassSource() {
		return TestResources.INSTANCE.EveShapeCreateRemoveTest1().getText();
	}

}
