package org.sgx.raphael4gwt.raphael.wrap;

import org.sgx.raphael4gwt.raphael.Circle;
import org.sgx.raphael4gwt.raphael.Ellipse;
import org.sgx.raphael4gwt.raphael.Image;
import org.sgx.raphael4gwt.raphael.Paper;
import org.sgx.raphael4gwt.raphael.Path;
import org.sgx.raphael4gwt.raphael.Rect;
import org.sgx.raphael4gwt.raphael.Set;
import org.sgx.raphael4gwt.raphael.Shape;
import org.sgx.raphael4gwt.raphael.Text;
import org.sgx.raphael4gwt.raphael.base.Attrs;
import org.sgx.raphael4gwt.raphael.base.Font;
import org.sgx.raphael4gwt.raphael.base.NativeFont;
import org.sgx.raphael4gwt.raphael.base.Point;
import org.sgx.raphael4gwt.raphael.base.Rectangle;
import org.sgx.raphael4gwt.raphael.event.ForEachCallback;
import org.sgx.raphael4gwt.raphael.ft.FTCallback;
import org.sgx.raphael4gwt.raphael.ft.FTOptions;
import org.sgx.raphael4gwt.raphael.ft.FreeTransform;

import com.google.gwt.core.client.JsArray;
import com.google.gwt.dom.client.Element;
import com.google.gwt.resources.client.ImageResource;

/**
 * "real" java paper wrapper . @see ShapeWrapper
 * @author sg
 *
 */
public class PaperWrapper {
Paper paper;

public Paper getPaper() {
	return paper;
}

public void setPaper(Paper paper) {
	this.paper = paper;
}

public PaperWrapper(Paper paper) {
	super();
	this.paper = paper;
}


/* following code is generated automatically using eclipse's 
 * Source -> generate Delegate Methods for shape. -modification will be 
 * overrided probably, please edit this class above this.(non-Javadoc)
 * @see java.lang.Object#clone()
 */


public final Set add(JsArray<Attrs> content) {
	return paper.add(content);
}

public final Set add(String json) {
	return paper.add(json);
}

public final void setViewBox(int x, int y, int w, int h, boolean fit) {
	paper.setViewBox(x, y, w, h, fit);
}

public final void setViewBox(Rectangle box, boolean fit) {
	paper.setViewBox(box, fit);
}

public final Circle circle(int x, int y, int r) {
	return paper.circle(x, y, r);
}

public final Circle circle(double x, double y, double r) {
	return paper.circle(x, y, r);
}

public final Text text(int x, int y, String text) {
	return paper.text(x, y, text);
}

public final void setSize(int w, int h) {
	paper.setSize(w, h);
}

//public final <T extends JavaScriptObject> T cast() {
//	return paper.cast();
//}

public final int getWidth() {
	return paper.getWidth();
}

public final int getHeight() {
	return paper.getHeight();
}

public final Shape top() {
	return paper.top();
}

public final Shape bottom() {
	return paper.bottom();
}

public final boolean equals(Object other) {
	return paper.equals(other);
}

public final void clear() {
	paper.clear();
}

public final int hashCode() {
	return paper.hashCode();
}

public final Rect rect(int x, int y, int w, int h) {
	return paper.rect(x, y, w, h);
}

public final Rect rect(double x, double y, double w, double h) {
	return paper.rect(x, y, w, h);
}

public final Rect rect(Rectangle r) {
	return paper.rect(r);
}

public final Rect rect(Rectangle r, int round) {
	return paper.rect(r, round);
}

public String toSource() {
	return paper.toSource();
}

public final Rect rect(int x, int y, int w, int h, int r) {
	return paper.rect(x, y, w, h, r);
}

public final String toString() {
	return paper.toString();
}

public final Rect rect(double x, double y, double w, double h, double r) {
	return paper.rect(x, y, w, h, r);
}

public final Rect rect(Point pos, int width, int height) {
	return paper.rect(pos, width, height);
}

public final Rect rect(Point pos, int width, int height, int r) {
	return paper.rect(pos, width, height, r);
}

public final Image image(ImageResource imgRes, int x, int y, int w, int h) {
	return paper.image(imgRes, x, y, w, h);
}

public final Image image(String imgUrl, int x, int y, int w, int h) {
	return paper.image(imgUrl, x, y, w, h);
}

public final Image image(String imgUrl, double x, double y, double w, double h) {
	return paper.image(imgUrl, x, y, w, h);
}

public final Path path() {
	return paper.path();
}

public final Path path(String pathString) {
	return paper.path(pathString);
}

//public final Path path(PathCmd cmd) {
//	return paper.path(cmd);
//}

public final Font getFont(String fontFamily) {
	return paper.getFont(fontFamily);
}

public final NativeFont getFont(String fontFamily, String weight) {
	return paper.getFont(fontFamily, weight);
}

public final Font getFont(String fontFamily, String weight, String style) {
	return paper.getFont(fontFamily, weight, style);
}

public final Font getFont(String fontFamily, String weight, String style,
		String stretch) {
	return paper.getFont(fontFamily, weight, style, stretch);
}

public final Paper forEach(ForEachCallback c) {
	return paper.forEach(c);
}

public final Path print(int x, int y, String text, Font font) {
	return paper.print(x, y, text, font);
}

public final Path print(double x, double y, String text, Font font) {
	return paper.print(x, y, text, font);
}

public final Path print(int x, int y, String text, Font font, int size) {
	return paper.print(x, y, text, font, size);
}

public final Path print(int x, int y, String text, Font font, int size,
		String origin) {
	return paper.print(x, y, text, font, size, origin);
}

public final Path print(int x, int y, String text, Font font, int size,
		String origin, double letterSpacing) {
	return paper.print(x, y, text, font, size, origin, letterSpacing);
}

public final Shape getById(int id) {
	return paper.getById(id);
}

public final Shape getElementByPoint(int x, int y) {
	return paper.getElementByPoint(x, y);
}

public final Set getTransfElementsByPoint(int x, int y) {
	return paper.getTransfElementsByPoint(x, y);
}

public final Set getTransfElementsByPoint(Point p) {
	return paper.getTransfElementsByPoint(p);
}

public final Shape getElementByPoint(Point p) {
	return paper.getElementByPoint(p);
}

public final Set getElementsByPoint(int x, int y) {
	return paper.getElementsByPoint(x, y);
}

public final Set getElementsByPoint(Point p) {
	return paper.getElementsByPoint(p);
}

public final Set set() {
	return paper.set();
}

public final void setStart() {
	paper.setStart();
}

public final Set setFinish() {
	return paper.setFinish();
}

public final Ellipse ellipse(int x, int y, int rx, int ry) {
	return paper.ellipse(x, y, rx, ry);
}

public final Ellipse ellipse(double x, double y, double rx, double ry) {
	return paper.ellipse(x, y, rx, ry);
}

public final Element getCanvasElement() {
	return paper.getCanvasElement();
}

public final FreeTransform freeTransform(Shape s) {
	return paper.freeTransform(s);
}

public final FreeTransform freeTransform(Shape s, FTOptions opts, FTCallback c) {
	return paper.freeTransform(s, opts, c);
}

public final Set printLetters(int x, int y, String str, Font font, int size,
		int letter_spacing, int line_height, Path onpath) {
	return paper.printLetters(x, y, str, font, size, letter_spacing,
			line_height, onpath);
}

public final Set printLetters(int x, int y, String str, Font font, int size,
		int letter_spacing, int line_height, String onpath) {
	return paper.printLetters(x, y, str, font, size, letter_spacing,
			line_height, onpath);
}

public final Set printLetters(int x, int y, String str, Font font, int size) {
	return paper.printLetters(x, y, str, font, size);
}

public final Set printLetters(int x, int y, String str, Font font, int size,
		Path onpath) {
	return paper.printLetters(x, y, str, font, size, onpath);
}

public final Set printLetters(int x, int y, String str, Font font, int size,
		String onpath) {
	return paper.printLetters(x, y, str, font, size, onpath);
}

public final JsArray<Attrs> writeToObject() {
	return paper.writeToObject();
}

public final String writeToString() {
	return paper.writeToString();
}

public final Set getAllShapes() {
	return paper.getAllShapes();
}

public final String toSVG() {
	return paper.toSVG();
}

public final Set importSvg(String svgXml) {
	return paper.importSvg(svgXml);
}


}
