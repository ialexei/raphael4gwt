package org.sgx.espinillo.client.impl1.commands;

import org.sgx.espinillo.client.impl1.util.ClipboardUtil;
import org.sgx.espinillo.client.impl1.util.ShapeUtil;
import org.sgx.espinillo.client.model.AbstractCommand;
import org.sgx.espinillo.client.model.Document;
import org.sgx.raphael4gwt.raphael.Set;

/**
 * 
 * @author sg
 *
 */
public class ClipboardCmd  extends AbstractCommand {
	
	public static final String TYPE_COPY="copy", TYPE_PASTE="paste", TYPE_CUT="cut";
	
	private String type=null;
	private Set newShapes=null, oldShapes=null;
	
	public ClipboardCmd(Document drawing, String type, Set shapes) {
		super(type, drawing);
		this.type=type;
		this.newShapes=shapes;
	}
	
	@Override
	public boolean doIt() {
		if(type!=null&&type.equals(TYPE_COPY)) {
			ClipboardUtil.getInstance().setClipboard(getDrawing(), newShapes);
			return true;
		}
		else if(type!=null&&type.equals(TYPE_PASTE)) {
			ShapeUtil.getInstance().addShapes(getDrawing().getPaper(), newShapes);
			return true;
		}
		else if(type!=null&&type.equals(TYPE_CUT)) {
			newShapes.remove();
			return true;
		}	
		return false;
	}

	@Override
	public boolean undoIt() {
		if(type!=null&&type.equals(TYPE_COPY)) {
			return true;
		}
		else if(type!=null&&type.equals(TYPE_PASTE)) {
			newShapes.remove();			
			return true;
		}
		else if(type!=null&&type.equals(TYPE_CUT)) {
			ShapeUtil.getInstance().addShapes(getDrawing().getPaper(), newShapes);
			return true;
		}	
		return false;
	}

}
