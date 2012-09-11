package org.sgx.espinillo.client.impl1.commands;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.sgx.espinillo.client.impl1.util.SelectionUtil;
import org.sgx.espinillo.client.model.AbstractCommand;
import org.sgx.espinillo.client.model.Document;
import org.sgx.raphael4gwt.raphael.Shape;
import org.sgx.raphael4gwt.raphael.base.Attrs;

import com.google.gwt.user.client.Window;

public class ChangeShapeAttrsCmd extends AbstractCommand {
	static Logger logger = Logger.getLogger("ChangeShapeAttrsCmd");
	Shape shape;
	Attrs oldAttrs, newAttrs;
	
	public ChangeShapeAttrsCmd(Document drawing, Shape shape, Attrs newAttrs) {
		super("change attrs", drawing);
		this.shape=shape;
		this.newAttrs=newAttrs;
	}
	@Override
	public boolean doIt() {
		oldAttrs=shape.attr();
		shape.attr(newAttrs);
		SelectionUtil.getInstance().updateSelectionFeedbacks(shape.paper(), shape.asSet()); 
		logger.log(Level.INFO, "doing command "+this); 
		return true;
	}
	@Override
	public String toString() {
		return "ChangeShapeAttrsCmd on shape "+shape; 
	}
	@Override
	public boolean undoIt() {
		shape.attr(oldAttrs);
		SelectionUtil.getInstance().updateSelectionFeedbacks(shape.paper(), shape.asSet()); 
		return true;
	}
	public Shape getShape() {
		return shape;
	}
	public void setShape(Shape shape) {
		this.shape = shape;
	}
	public Attrs getOldAttrs() {
		return oldAttrs;
	}
	public void setOldAttrs(Attrs oldAttrs) {
		this.oldAttrs = oldAttrs;
	}
	public Attrs getNewAttrs() {
		return newAttrs;
	}
	public void setNewAttrs(Attrs newAttrs) {
		this.newAttrs = newAttrs;
	}

	
}
