package org.sgx.espinillo.client.model.tool;

import org.sgx.espinillo.client.model.Document;

/**
 * a tool capture user events, show some editedShape to the user, and when the task is over
 * issue a command to the. So tool perform raphael commands for showing editedShape. 
 * 
 * example, the "ellipse tool" is for drawing ellipses doing drag and drop w the mouse.
 * wheh draggin it will show a "ellipse-editedShape" but it is not till the user drops
 * when the add-shape command is issued.
 * @author sg
 *
 */
public interface Tool {
void install();
void uninstall();
void addToolListener(ToolListener l);
void removeToolListener(ToolListener l);

Document getDocument();
void setDocument(Document document);
String getName();
}
