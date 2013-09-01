package org.sgx.espinillo.client.model;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
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
	Map<Class, List<CommandListener>> commandListeners;

	public AbstractDocument(VEditor veditor, Paper paper, String name){
		super();
		this.veditor=veditor;
		this.paper=paper;
		this.name=name;
		shapes=new LinkedList<Shape>();
		commandStack=new Stack<Command>();
		undoedCmds=new Stack<Command>();
		commandListeners=new HashMap<Class, List<CommandListener>>();
		selection=paper.set();
		selectionListeners=new LinkedList<SelectionListener>();
	}
	@Override
	public void addCommandListener(Class commandClass, CommandListener l) {		
		if(!commandListeners.containsKey(commandClass)){
			commandListeners.put(commandClass, new LinkedList<CommandListener>());
		}
		commandListeners.get(commandClass).add(l);
	}
	@Override
	public void removeCommandListener(Class commandClass,CommandListener l) {
		if(commandListeners.containsKey(commandClass)){
			commandListeners.get(commandClass).remove(l);
		}
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
		List<CommandListener> listeners = commandListeners.get(cmd.getClass());
		if(listeners!=null) for(CommandListener l : listeners) {
//			if(!l.beforeCommandExec(cmd))
//				return;
			l.beforeCommandExec(cmd); 
		}
		if(cmd.doIt()) {
			getCommandStack().push(cmd);
			if(listeners!=null) for(CommandListener l : listeners) {
				l.onCommandExec(cmd);
			}
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
