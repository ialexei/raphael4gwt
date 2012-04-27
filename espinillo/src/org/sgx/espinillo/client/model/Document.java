package org.sgx.espinillo.client.model;

import java.util.List;
import java.util.Stack;

import org.sgx.espinillo.client.impl1.commands.CreateShapeCmd;
import org.sgx.raphael4gwt.raphael.*;
import org.sgx.raphael4gwt.raphael.base.Attrs;

/**
 * a drawing is a document displayed on a paper.
 * it contains a commandstack
 * @author sg
 *
 */
public interface Document {
	
	//model
	String getName();
	Paper getPaper();
	List<Shape> getShapes();
	VEditor getVEditor();
	
	//state
	Stack<Command> getCommandStack();
	
	
	//selection
	Set getSelection();
	void setSelection(Set s);
	void execute(Command cmd);
	boolean undo();
	boolean redo();
	void addSelectionListener(SelectionListener l);
	boolean removeSelectionListener(SelectionListener l);
}
