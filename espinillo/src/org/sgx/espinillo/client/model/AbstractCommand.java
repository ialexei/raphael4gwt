package org.sgx.espinillo.client.model;

public abstract class AbstractCommand implements Command {

	Document drawing;
	public AbstractCommand(Document drawing) {
		this.drawing=drawing;
	}

	@Override
	public Document getDrawing() {
		return drawing;
	}
}
