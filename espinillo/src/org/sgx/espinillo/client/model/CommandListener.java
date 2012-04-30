package org.sgx.espinillo.client.model;

public interface CommandListener {
	/**
	 * command execution can be canceled if this listener return false.
	 * @param c
	 * @return
	 */
	boolean beforeCommandExec(Command c);
	void onCommandExec(Command c);
}
