package org.sgx.espinillo.client.model;

public abstract class AbstractCommand implements Command {

	Document drawing;
	String commandName;
	
	protected AbstractCommand(String name, Document drawing) {
		this.drawing=drawing;
		this.commandName=name;
	}

	@Override
	public Document getDrawing() {
		return drawing;
	}

	public String getCommandName() {
		return commandName;
	}

	public void setCommandName(String commandName) {
		this.commandName = commandName;
	}

	public void setDrawing(Document drawing) {
		this.drawing = drawing;
	}
	
}
