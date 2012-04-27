package org.sgx.espinillo.client.model.tool;
/**
 * a tool is not obligated to suport all this stages, only the relevant
 * @author sg
 *
 */
public interface ToolListener {
void onStart(ToolEvent te);
void onFinnish(ToolEvent te);
void onAction(ToolEvent te);
}
