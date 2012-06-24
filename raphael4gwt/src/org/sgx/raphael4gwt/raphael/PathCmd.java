package org.sgx.raphael4gwt.raphael;

import org.sgx.raphael4gwt.raphael.base.Point;
import org.sgx.raphael4gwt.raphael.util.Util;

import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsArrayMixed;
import com.google.gwt.user.client.Window;

/**
 * an java tool for creating pths programatically. this is not part of 
 * raphael api, but an artificial path helper written 100% in java.
 * 
 * i'm also responsible of knowing how to build myself from 
 * Raphael.parsePathString()
 * 
 * Usecase examples: #see PathCmdsTest1 - 
 * <pre>
PathCmd pc = new PathCmd(10,10);
pc.L(20, 20).M(10,180).L(0,0).T(10,100).T(100,10).Z();
Path p1 = getPaper().path(pc.toPathString());
 * 
 * 
 * TODO: parse a path attr string and build a chain of commands
 * @author sg
 *
 */
public class PathCmd {
	
	//we will use this internal model class for presenting points 
	
	private static final class PCPoint {
		double x, y;		
		public PCPoint(double x, double y) {
			super();
			this.x = x;
			this.y = y;
		}
		public double getX() {
			return x;
		}
		public void setX(double x) {
			this.x = x;
		}
		public double getY() {
			return y;
		}
		public void setY(double y) {
			this.y = y;
		}		
		@Override
		public String toString() {
			return "point("+x+","+y+")";
		}
	}

	/**
	 * a shape is a chain of commands.
	 */
	PathCmd next=null;
	
	/**
	 * one of Raphael.PATH_* constants
	 */
	String type=null;
	
	/**
	 * PCPoint[][] will represents all this command path values, 
	 * from x+ (a sumple double value) to (xyx1y2x2y2)+ 
	 */
	PCPoint [][] points;
	
	/**
	 * paths must start with moveto, so the first is always a moveto command
	 * and user must provide initial moveto coords.
	 * @param x
	 * @param y
	 */
	public PathCmd(double x, double y) {
		points=new PCPoint[][]{{new PCPoint(x, y)}};
		type=Raphael.PATH_MOVETO;
	}
	public PathCmd(Point p) {
		this(p.getX(), p.getY());
	}
	/**
	 * build from path array using Raphael.parsePathString() . it will build all the chain of path commands.
	 * @param pathString
	 */
	public PathCmd(String pathString) {
		this();
		JsArray<JsArrayMixed> pp = Raphael.parsePathString(pathString);
		if(pp==null||pp.length()==0)
			return;
		
		PathCmd cmd = this;
		for (int i = 0; i < pp.length(); i++) {
			JsArrayMixed ppc = pp.get(i);
			
			PathCmd nextCmd = new PathCmd();
			cmd.setNext(nextCmd);
			
			if(ppc==null||ppc.length()==0)
				continue;
			
			String type = ppc.getString(0);
			if(type==null||type.equals(""))
				continue;
				
			cmd.setType(type);
			
			if(type.equals(Raphael.PATH_LINETO)||
				type.equals(Raphael.PATH_MOVETO)||
				(type.equals(Raphael.PATH_SMOOTH_QUADBESIER_CURVETO) && ppc.length()==3) ) {
				cmd.setPoints(new PCPoint[][]{{new PCPoint(ppc.getNumber(1), ppc.getNumber(2))}});
			}
			else if(type.equals(Raphael.PATH_ELLIPTICAL_ARC)&&ppc.length()==8) { //7 numbers in four points
//				cmd.setPoints(new PCPoint[][]{
//						{new PCPoint(ppc.getNumber(1), ppc.getNumber(2))},
//						{new PCPoint(ppc.getNumber(3), ppc.getNumber(4))},
//						{new PCPoint(ppc.getNumber(5), ppc.getNumber(6))},
//						{new PCPoint(ppc.getNumber(7), 0)}});
				cmd.setPoints(new PCPoint[][]{{
					new PCPoint(ppc.getNumber(1), ppc.getNumber(2)),
					new PCPoint(ppc.getNumber(3), ppc.getNumber(4)),
					new PCPoint(ppc.getNumber(5), ppc.getNumber(6)),
					new PCPoint(ppc.getNumber(7), 0)
				}});
			}
			cmd=nextCmd;
			
			//TODO: do the folowing better, case by case...
//			PCPoint[][] points = new PCPoint[Math.round(ppc.length()/2+0.5)]
//			for (int j = 1; j < ppc.length(); j+=2) {
//				Util.parseInt(ppc.getNumber(j), 0);
//			}
		}
	}
	
	private PathCmd() {
		this(0,0);
	}
	
	
	
	
	
	// to string 

	public void toPathString(StringBuffer sb) {
		PathCmd c =this;
		while(c!=null) {
			cmdToString(c, sb);
			c=c.getNext();
		}
	}
	public String toPathString() {
		StringBuffer sb = new StringBuffer();
		toPathString(sb);
		String ret = sb.toString();
//		Window.alert(ret);
		return ret;
	}
	public static void removeLast(PathCmd c) {
		PathCmd a = c, prev=null;
		while(a!=null) {
			if(a.getNext()==null && prev!=null) {
				prev.next=null;
			}
			prev=a;
			a=a.getNext();
		}
	}
	private void cmdToString(PathCmd c, StringBuffer sb) {
		PCPoint[][] _points = c.getPoints();
		int len = Util.getLength(_points);
		
		if(c.getType()==null)
			return;
		
		//no args
		else if(c.getType().equals(Raphael.PATH_CLOSEPATH)) {
			sb.append(c.getType());
		}
		
		//1 number only args
		else if(c.getType().equals(Raphael.PATH_HLINETO) ||
				c.getType().equals(Raphael.PATH_VLINETO) ) {				
			if(len==0)
				return;
			for (int i = 0; i < len; i++) {
				PCPoint[] a = _points[i];
				if(a!=null&&a.length>0) {
					sb.append(c.getType()+a[0].getX()
						);					
				}
			}
		}
		
		//2 numbers (point) args
		else if(c.getType().equals(Raphael.PATH_MOVETO) ||
			c.getType().equals(Raphael.PATH_LINETO) ||
			c.getType().equals(Raphael.PATH_SMOOTH_QUADBESIER_CURVETO)) {
			
			if(len==0)
				return;
			for (int i = 0; i < len; i++) {
				PCPoint[] a = _points[i];
				if(a!=null&&a.length>0) {
					sb.append(c.getType()+a[0].getX()+","+a[0].getY());					
				}
			}
		}		
		
		//4 numbers (2 point) args
		else if(c.getType().equals(Raphael.PATH_SMOOTH_CURVETO) ||
			c.getType().equals(Raphael.PATH_QUADBESIER_CURVETO) ||
			c.getType().equals(Raphael.PATH_CATMULLROM_CURVETO)) {
			
			if(len==0)
				return;
			for (int i = 0; i < len; i++) {
				PCPoint[] a = _points[i];
				if(a!=null&&a.length>0) {
					sb.append(c.getType()+a[0].getX()+","+a[0].getY());	
					if(a.length>=2) { //catmul second point is optional
						sb.append(","+a[1].getX()+","+a[2].getY());
					}
				}
			}
		}
		
		//7 numbers - 4 points
		else if(c.getType().equals(Raphael.PATH_ELLIPTICAL_ARC)) {
			if(len==0)
				return;
			for (int i = 0; i < len; i++) {
				PCPoint[] a = _points[i];
				if(a!=null&&a.length>0) {
					sb.append(c.getType()+a[0].getX()+","+a[0].getY()+
						","+a[1].getX()+","+a[1].getY()+
						","+a[2].getX()+","+a[2].getY()+","+a[3].getX());
				}
			}			
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	//commands API
	
	//lineto
	
	/**
	 * creates a new PathCmd of type "lineto" and values "points" and concatenates afther this PathCmd.
	 * Use: 
	 * path1.lineto(); 
	 * @param points
	 * @return the new PathCmd 
	 */
	public PathCmd lineto(double[][] p) {
		PCPoint [][] points2 = new PCPoint[p.length][1];
		for (int i = 0; i < p.length; i++) {
			points2[i][0] = new PCPoint(p[i][0], p[i][1]);
		}
		PathCmd pathCmd2 = new PathCmd();
		pathCmd2.setPoints(points2);
		pathCmd2.setType(Raphael.PATH_LINETO);
		this.setNext(pathCmd2);
		return pathCmd2;
	}
	/**
	 * alias for smoothQuadBezierCurveTo
	 */
	public PathCmd L(double[][] p) {
		return lineto(p);
	}
	/**
	 * creates a new PathCmd of type "moveto" and values "points" and concatenates after this PathCmd.
	 * Use: 
	 * path1.lineto(new double[][]{{20,30}, {50,120}}); 
	 * @param points
	 * @return the new PathCmd 
	 */
	public PathCmd lineto(double x, double y) {
		return this.lineto(new double[][]{{x,y}});
	}
	/**
	 * creates a new PathCmd of type "moveto" and values "points" and concatenates after this PathCmd.
	 * Use: 
	 * path1.lineto(new double[][]{{20,30}, {50,120}}); 
	 * @param points
	 * @return the new PathCmd 
	 */
	public PathCmd lineto(Point p) {
		return lineto(p.getX(), p.getY());
	}
	/**
	 * alias for smoothQuadBezierCurveTo
	 */
	public PathCmd L(double x, double y) {
		return this.lineto(x,y);
	}
	
	
	//moveto
	
	/**
	 * creates a new PathCmd of type "moveto" and values "points" and concatenates afther this PathCmd.
	 * Use: 
	 * path1.lineto(); 
	 * @param points
	 * @return the new PathCmd 
	 */
	public PathCmd moveto(double[][] p) {
		PCPoint [][] points2 = new PCPoint[p.length][1];
		for (int i = 0; i < p.length; i++) {
			points2[i][0] = new PCPoint(p[i][0], p[i][1]);
		}
		PathCmd pathCmd2 = new PathCmd();
		pathCmd2.setPoints(points2);
		pathCmd2.setType(Raphael.PATH_MOVETO);
		this.setNext(pathCmd2);
		return pathCmd2;
	}	
	/**
	 * creates a new PathCmd of type "moveto" and values "points" and concatenates afther this PathCmd.
	 * Use: 
	 * path1.lineto(); 
	 * @param points
	 * @return the new PathCmd 
	 */
	public PathCmd moveto(Point p) {
		return lineto(p.getX(), p.getY());
	}	
	/**
	 * alias for moveto
	 */
	public PathCmd M(double[][] p) {
		return moveto(p);
	}
	/**
	 * creates a new PathCmd of type "moveto" and values "points" and concatenates after this PathCmd.
	 * Use: 
	 * path1.lineto(new double[][]{{20,30}, {50,120}}); 
	 * @param points
	 * @return the new PathCmd 
	 */
	public PathCmd moveto(double x, double y) {
		return this.moveto(new double[][]{{x,y}});
	}
	/**
	 * alias for moveto
	 */
	public PathCmd M(double x, double y) {
		return this.moveto(x,y);
	}
	
	
	
	//quad bezier
	/**
	 * creates a new PathCmd of type "quadBezierCurveTo" and values "points" and concatenates after this PathCmd.
	 * Use: 
	 * <pre>path1.quadBezierCurveTo(new double[][]{{20,30,40,50}, {50,120,40,50}});</pre>
	 * <br/>
	 * From SVG spec: Draws a quadratic Bézier curve from the current point to (x,y) using (x1,y1) as the control point. Q (uppercase) indicates that absolute coordinates will follow; q (lowercase) indicates that relative coordinates will follow. Multiple sets of coordinates may be specified to draw a polybézier. At the end of the command, the new current point becomes the final (x,y) coordinate pair used in the polybézier.
	 * @see http://www.w3.org/TR/SVG/paths.html#PathDataQuadraticBezierCommands
	 * @param points
	 * @return the new PathCmd 
	 */
	public PathCmd quadBezierCurveTo(boolean rel, double[][] p) {
		if(p.length==0)return null;
		PCPoint [][] points2 = new PCPoint[p.length][2];
		for (int i = 0; i < p.length; i++) {
			if(p[i]!=null&&p[i].length==4) {
				points2[i][0] = new PCPoint(p[i][0], p[i][1]);
				points2[i][1] = new PCPoint(p[i][2], p[i][3]);
			}
		}
		PathCmd pathCmd2 = new PathCmd();
		pathCmd2.setPoints(points2);
		pathCmd2.setType(rel?Raphael.PATH_QUADBESIER_CURVETO_REL:Raphael.PATH_QUADBESIER_CURVETO);
		this.setNext(pathCmd2);
		return pathCmd2;
	}
	
	/**
	 * creates a new PathCmd of type "quadBezierCurveTo" and values "points" and concatenates after this PathCmd.
	 * Use: 
	 * <pre>path1.quadBezierCurveTo(new double[][]{{20,30,40,50}, {50,120,40,50}});</pre>
	 * <br/>
	 * From SVG spec: Draws a quadratic Bézier curve from the current point to (x,y) using (x1,y1) as the control point. Q (uppercase) indicates that absolute coordinates will follow; q (lowercase) indicates that relative coordinates will follow. Multiple sets of coordinates may be specified to draw a polybézier. At the end of the command, the new current point becomes the final (x,y) coordinate pair used in the polybézier.
	 * @see http://www.w3.org/TR/SVG/paths.html#PathDataQuadraticBezierCommands
	 * @param points
	 * @return the new PathCmd 
	 */
	public PathCmd quadBezierCurveTo(boolean rel, double  x1, double y1, double x, double y) {
		return quadBezierCurveTo(rel, new double[][]{{x1, y1, x, y}});
	}
	/**
	 * alias for quadBezierCurveTo rel=false
	 */
	public PathCmd Q(double[][] p) {
		return quadBezierCurveTo(false, p);
	}
	/**
	 * alias for quadBezierCurveTo rel=true
	 */
	public PathCmd q(double[][] p) {
		return quadBezierCurveTo(true, p);
	}
	/**
	 * alias for quadBezierCurveTo rel=false
	 */
	public PathCmd Q(double  x1, double y1, double x, double y) {
		return quadBezierCurveTo(false, new double[][]{{x1, y1, x, y}});
	}
	/**
	 * alias for quadBezierCurveTo rel=true
	 */
	public PathCmd q(double  x1, double y1, double x, double y) {
		return quadBezierCurveTo(true, new double[][]{{x1, y1, x, y}});
	}
	
	
	//smoothQuadBezierCurveTo
	
	/**
	 * creates a new PathCmd of type "smoothQuadBezierCurveTo" and values "points" and concatenates after this PathCmd.
	 * Use: 
	 * <pre>path1.smoothQuadBezierCurveTo(new double[][]{{20,30}, {50,120}});</pre>
	 * <br/>
	 * From SVG spec: Draws a cubic Bézier curve from the current point to (x,y). The first control point is assumed to be the reflection of the second control point on the previous command relative to the current point. (If there is no previous command or if the previous command was not an C, c, S or s, assume the first control point is coincident with the current point.) (x2,y2) is the second control point (i.e., the control point at the end of the curve). S (uppercase) indicates that absolute coordinates will follow; s (lowercase) indicates that relative coordinates will follow. Multiple sets of coordinates may be specified to draw a polybézier. At the end of the command, the new current point becomes the final (x,y) coordinate pair used in the polybézier.
	 * @see http://www.w3.org/TR/SVG/paths.html#PathDataQuadraticBezierCommands
	 * @param points
	 * @return the new PathCmd 
	 */
	public PathCmd smoothQuadBezierCurveTo(double[][] p) {
		PCPoint [][] points2 = new PCPoint[p.length][1];
		for (int i = 0; i < p.length; i++) {
			points2[i][0] = new PCPoint(p[i][0], p[i][1]);
		}
		PathCmd pathCmd2 = new PathCmd();
		pathCmd2.setPoints(points2);
		pathCmd2.setType(Raphael.PATH_SMOOTH_QUADBESIER_CURVETO);
		this.setNext(pathCmd2);
		return pathCmd2;
	}
	/**
	 * creates a new PathCmd of type "smoothQuadBezierCurveTo" and values "points" and concatenates after this PathCmd.
	 * Use: 
	 * <pre>path1.smoothQuadBezierCurveTo(new double[][]{{20,30}, {50,120}});</pre>
	 * <br/>
	 * From SVG spec: Draws a cubic Bézier curve from the current point to (x,y). The first control point is assumed to be the reflection of the second control point on the previous command relative to the current point. (If there is no previous command or if the previous command was not an C, c, S or s, assume the first control point is coincident with the current point.) (x2,y2) is the second control point (i.e., the control point at the end of the curve). S (uppercase) indicates that absolute coordinates will follow; s (lowercase) indicates that relative coordinates will follow. Multiple sets of coordinates may be specified to draw a polybézier. At the end of the command, the new current point becomes the final (x,y) coordinate pair used in the polybézier.
	 * @see http://www.w3.org/TR/SVG/paths.html#PathDataQuadraticBezierCommands 
	 * @param points
	 * @return the new PathCmd 
	 */
	public PathCmd smoothQuadBezierCurveTo(Point p) {
		return smoothQuadBezierCurveTo(p.getX(), p.getY());
	}
	
	/**
	 * creates a new PathCmd of type "smoothQuadBezierCurveTo" and values "points" and concatenates after this PathCmd.
	 * Use: 
	 * <pre>path1.smoothQuadBezierCurveTo(new double[][]{{20,30}, {50,120}});</pre>
	 * <br/>
	 * From SVG spec: Draws a cubic Bézier curve from the current point to (x,y). The first control point is assumed to be the reflection of the second control point on the previous command relative to the current point. (If there is no previous command or if the previous command was not an C, c, S or s, assume the first control point is coincident with the current point.) (x2,y2) is the second control point (i.e., the control point at the end of the curve). S (uppercase) indicates that absolute coordinates will follow; s (lowercase) indicates that relative coordinates will follow. Multiple sets of coordinates may be specified to draw a polybézier. At the end of the command, the new current point becomes the final (x,y) coordinate pair used in the polybézier.
	 * @see http://www.w3.org/TR/SVG/paths.html#PathDataQuadraticBezierCommands
	 * @param points
	 * @return the new PathCmd 
	 */
	public PathCmd smoothQuadBezierCurveTo(double x, double y) {
		return this.smoothQuadBezierCurveTo(new double[][]{{x,y}});
	}
	/**
	 * alias for smoothQuadBezierCurveTo
	 */
	public PathCmd T(double[][] p) {
		return smoothQuadBezierCurveTo(p);
	}
	/**
	 * alias for smoothQuadBezierCurveTo
	 */
	public PathCmd T(double x, double y) {
		return this.smoothQuadBezierCurveTo(x,y);
	}
	
	
	
	
	
	//close
	
	/**
	 * adds a new close command, append it to th chain and return it
	 */
	public PathCmd close() {
		PathCmd pathCmd2 = new PathCmd();
		pathCmd2.setType(Raphael.PATH_CLOSEPATH);
		this.setNext(pathCmd2);
		return pathCmd2;
	}
	/**
	 * alias for close
	 */
	public PathCmd Z() {
		return close();
	}
	
	
	
	//arc - adds an elliptical arc	(rx ry x-axis-rotation large-arc-flag sweep-flag x y)+
	/**
	 * adds an elliptical arc command, append it to the chain and return it. @see http://www.w3.org/TR/SVG/paths.html#PathDataEllipticalArcCommands
	 * <br/>
	 * From SVG spec: Draws an elliptical arc from the current point to (x, y). The size and orientation of the ellipse are defined by two radii (rx, ry) and an x-axis-rotation, which indicates how the ellipse as a whole is rotated relative to the current coordinate system. The center (cx, cy) of the ellipse is calculated automatically to satisfy the constraints imposed by the other parameters. large-arc-flag and sweep-flag contribute to the automatic calculations and help determine how the arc is drawn.
	 * @param rx radius-x for the ellipse
	 * @param ry radius-y for the ellipse
	 * @param xAxisRotation x-rotation for the ellipse which indicates how the ellipse as a whole is rotated relative to the current coordinate system
	 * @param largeArcFlag possible values 0 or 1
	 * @param sweepFlag possible values 0 or 1
	 * @param x x-coord of arc's end
	 * @param y y-coord of arc's end
	 * @return the new PathCmd 
	 */
	public PathCmd ellipticalArc(double[][]p) {
		PathCmd pathCmd2 = new PathCmd();
		PCPoint [][] points2 = new PCPoint[p.length][4];
		for (int i = 0; i < p.length; i++) {
			points2[i][0] = new PCPoint(p[i][0], p[i][1]);
			points2[i][1] = new PCPoint(p[i][2], p[i][3]);
			points2[i][2] = new PCPoint(p[i][4], p[i][5]);
			points2[i][3] = new PCPoint(p[i][6], p[i][7]);
			
		}
		pathCmd2.setPoints(points2);
		pathCmd2.setType(Raphael.PATH_ELLIPTICAL_ARC);
		this.setNext(pathCmd2);
		return pathCmd2;
	}
	/**
	 * adds an elliptical arc command, append it to the chain and return it. @see http://www.w3.org/TR/SVG/paths.html#PathDataEllipticalArcCommands
	 * <br/>
	 * From SVG spec: Draws an elliptical arc from the current point to (x, y). The size and orientation of the ellipse are defined by two radii (rx, ry) and an x-axis-rotation, which indicates how the ellipse as a whole is rotated relative to the current coordinate system. The center (cx, cy) of the ellipse is calculated automatically to satisfy the constraints imposed by the other parameters. large-arc-flag and sweep-flag contribute to the automatic calculations and help determine how the arc is drawn.
	 * @param rx radius-x for the ellipse
	 * @param ry radius-y for the ellipse
	 * @param xAxisRotation x-rotation for the ellipse which indicates how the ellipse as a whole is rotated relative to the current coordinate system
	 * @param largeArcFlag possible values 0 or 1
	 * @param sweepFlag possible values 0 or 1
	 * @param x x-coord of arc's end
	 * @param y y-coord of arc's end
	 * @return the new PathCmd 
	 */
	public PathCmd ellipticalArc(double rx, double ry, double xAxisRotation, 
			double largeArcFlag, double sweepFlag, double x, double y) {
		return ellipticalArc(new double[][]{{rx, ry, 
			xAxisRotation, largeArcFlag, sweepFlag, x, y, 0}});
//		return ellipticalArc(new double[][]{{rx, ry}, {xAxisRotation, 
//			largeArcFlag}, {sweepFlag, x}, {y,0}});
	}
	/**
	 * adds an elliptical arc command, append it to the chain and return it. @see http://www.w3.org/TR/SVG/paths.html#PathDataEllipticalArcCommands
	 * <br/>
	 * From SVG spec: Draws an elliptical arc from the current point to (x, y). The size and orientation of the ellipse are defined by two radii (rx, ry) and an x-axis-rotation, which indicates how the ellipse as a whole is rotated relative to the current coordinate system. The center (cx, cy) of the ellipse is calculated automatically to satisfy the constraints imposed by the other parameters. large-arc-flag and sweep-flag contribute to the automatic calculations and help determine how the arc is drawn.
	 * @param rx radius-x for the ellipse
	 * @param ry radius-y for the ellipse
	 * @param xAxisRotation x-rotation for the ellipse which indicates how the ellipse as a whole is rotated relative to the current coordinate system
	 * @param largeArcFlag possible values 0 or 1
	 * @param sweepFlag possible values 0 or 1
	 * @param x x-coord of arc's end
	 * @param y y-coord of arc's end
	 * @return the new PathCmd 
	 */
	public PathCmd A(double rx, double ry, double xAxisRotation, 
			double largeArcFlag, double sweepFlag, double x, double y) {
		return ellipticalArc(new double[][]{{rx, ry, xAxisRotation, 
			largeArcFlag, sweepFlag, x, y}});
	}
	/**
	 * adds an elliptical arc command, append it to the chain and return it. @see http://www.w3.org/TR/SVG/paths.html#PathDataEllipticalArcCommands
	 * <br/>
	 * From SVG spec: Draws an elliptical arc from the current point to (x, y). The size and orientation of the ellipse are defined by two radii (rx, ry) and an x-axis-rotation, which indicates how the ellipse as a whole is rotated relative to the current coordinate system. The center (cx, cy) of the ellipse is calculated automatically to satisfy the constraints imposed by the other parameters. large-arc-flag and sweep-flag contribute to the automatic calculations and help determine how the arc is drawn.
	 * @param rx radius-x for the ellipse
	 * @param ry radius-y for the ellipse
	 * @param xAxisRotation x-rotation for the ellipse which indicates how the ellipse as a whole is rotated relative to the current coordinate system
	 * @param largeArcFlag possible values 0 or 1
	 * @param sweepFlag possible values 0 or 1
	 * @param x x-coord of arc's end
	 * @param y y-coord of arc's end
	 * @return the new PathCmd 
	 */
	public PathCmd A(double[][]p) {
		PathCmd pathCmd2 = new PathCmd();
		PCPoint [][] points2 = new PCPoint[p.length][1];
		for (int i = 0; i < p.length; i++) {
			points2[i][0] = new PCPoint(p[i][0], p[i][1]);
		}
		pathCmd2.setType(Raphael.PATH_ELLIPTICAL_ARC);
		this.setNext(pathCmd2);
		return pathCmd2;
	}
	
	
	
	
	//accessors
	
	public PathCmd getNext() {
		return next;
	}

	public void setNext(PathCmd next) {
		this.next = next;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public PCPoint[][] getPoints() {
		return points;
	}

	public void setPoints(PCPoint[][] points) {
		this.points = points;
	}
	
	
}
