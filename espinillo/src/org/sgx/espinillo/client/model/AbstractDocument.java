package org.sgx.espinillo.client.model;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import org.sgx.raphael4gwt.raphael.Paper;
import org.sgx.raphael4gwt.raphael.Set;
import org.sgx.raphael4gwt.raphael.Shape;

import com.google.gwt.user.client.Window;

public abstract class AbstractDocument implements Document {
	String name;
	Paper paper;
	List<Shape> shapes;
	Stack<Command> commandStack, undoedCmds;
	Set selection;
	List<SelectionListener> selectionListeners;
	private VEditor veditor;

	public AbstractDocument(VEditor veditor, Paper paper){
		super();
		this.veditor=veditor;
		this.paper=paper;
		shapes=new LinkedList<Shape>();
		commandStack=new Stack<Command>();
		undoedCmds=new Stack<Command>();
		selection=paper.set();
		selectionListeners=new LinkedList<SelectionListener>();
	}
	public Paper getPaper() {
		return paper;
	}
	@Override
	public VEditor getVEditor() {
		return veditor;
	}
	public void setPaper(Paper paper) {
		this.paper = paper;
	}

	public void addSelectionListener(SelectionListener l) {
		selectionListeners.add(l);
	}
	public boolean removeSelectionListener(SelectionListener l) {
		return selectionListeners.remove(l);
	}
	protected void notifySelectionChange() {
		for(SelectionListener l : selectionListeners) {
			l.selectionChange(this);
		}
	}
	public List<Shape> getShapes() {
		return shapes;
	}


	public void setShapes(List<Shape> shapes) {
		this.shapes = shapes;
	}


	public Stack<Command> getCommandStack() {
		return commandStack;
	}

	@Override
	public boolean undo() {
		Command cmd = commandStack.pop();
		undoedCmds.push(cmd);
		return cmd.undoIt();
	}

	@Override
	public boolean redo() {
		Command cmd = undoedCmds.pop();
		execute(cmd);
		return true;
	}
	
	@Override
	public void execute(Command cmd) {		
		if(cmd.doIt()) {
			getCommandStack().push(cmd);
		}
	}

	public void setCommandStack(Stack<Command> commandStack) {
		this.commandStack = commandStack;
	}


	public Set getSelection() {
		return selection;
	}


	public void setSelection(Set selection) {
		this.selection = selection;
	}
	
	@Override
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
