package org.sgx.espinillo.client.model;
/**
 * commands are issued by tools and perform some specific task over a drawing (document)
 * Commands will have to the document has a commandStack. a command must know how to perform 
 * and unperform its action over the document.
 * the document contains a command stack for supporting undo/redo actions.
 * 
 * @author sg
 *
 */
public interface Command {
boolean doIt();
boolean undoIt();
Document getDrawing();
String getCommandName();
}
