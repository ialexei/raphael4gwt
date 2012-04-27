package org.sgx.espinillo.client.impl1.commands;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.sgx.espinillo.client.impl1.Constants;
import org.sgx.espinillo.client.impl1.tools.EllipseTool;
import org.sgx.espinillo.client.impl1.util.ShapeUtil;
import org.sgx.espinillo.client.model.AbstractCommand;
import org.sgx.espinillo.client.model.Command;
import org.sgx.espinillo.client.model.Document;
import org.sgx.espinillo.client.util.Util;
import org.sgx.raphael4gwt.raphael.Ellipse;
import org.sgx.raphael4gwt.raphael.Raphael;
import org.sgx.raphael4gwt.raphael.Shape;
import org.sgx.raphael4gwt.raphael.base.Attrs;

import com.google.gwt.user.client.Window;

public class CreateShapeCmd extends AbstractCommand {

	static Logger logger = Logger.getLogger("CreateShapeCmd");
	
	String shapeType;
	Attrs shapeAttrs;
	Shape shape;
	
	
	public CreateShapeCmd(Document drawing, String shapeType, Attrs shapeAttrs) {
		super(drawing);
		this.shapeType = shapeType;
		this.shapeAttrs = shapeAttrs;
	}

	@Override
	public boolean doIt() {
		shape = null;
		if(shapeType!=null&&shapeType.equals(Constants.SHAPE_ELLIPSE)) {
			shape = ShapeUtil.getInstance().newEllipse(getDrawing().getPaper(), 10,10,10,10);
		}
		else if(shapeType!=null&&shapeType.equals(Constants.SHAPE_CIRCLE)) {
			shape = ShapeUtil.getInstance().newCircle(getDrawing().getPaper(),10,10,10);
		}
		else if(shapeType!=null&&shapeType.equals(Constants.SHAPE_RECT)) {
			shape = ShapeUtil.getInstance().newRect(getDrawing().getPaper(),10,10,10,10);
		}
		else if(shapeType!=null&&shapeType.equals(Constants.SHAPE_PATH)) {
			shape = ShapeUtil.getInstance().newPath(getDrawing().getPaper());
		}
		else if(shapeType!=null&&shapeType.equals(Constants.SHAPE_PATH)) {
			shape = ShapeUtil.getInstance().newPath(getDrawing().getPaper());
		}
		else if(shapeType!=null&&shapeType.equals(Constants.SHAPE_TEXT)) {
			shape = ShapeUtil.getInstance().newText(getDrawing().getPaper());
		}
//		logger.log(Level.WARNING, shape+" - "+shapeAttrs);
		if(shape!=null && shapeAttrs!=null) {
			shape.attr(shapeAttrs);
			
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean undoIt() {
		shape.remove();
		return true;
	}


}
