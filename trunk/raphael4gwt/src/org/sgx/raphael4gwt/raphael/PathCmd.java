package org.sgx.raphael4gwt.raphael;

import org.sgx.raphael4gwt.raphael.util.Util;

/**
 * a java tool for creating pths programatically
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
		return sb.toString();
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
//			sb.append(c.getType());
			for (int i = 0; i < len; i++) {
				PCPoint[] a = _points[i];
				if(a!=null&&a.length>0) {
					sb.append(c.getType()+a[0].getX()
//							+
//						(i==len-1 ? "":",")
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
//			sb.append(c.getType());
			for (int i = 0; i < len; i++) {
				PCPoint[] a = _points[i];
				if(a!=null&&a.length>0) {
					sb.append(c.getType()+a[0].getX()+","+a[0].getY()
//							+
//						(i==len-1 ? "":",")
						);					
				}
			}
		}		
		
		//4 numbers (2 point) args
		else if(c.getType().equals(Raphael.PATH_SMOOTH_CURVETO) ||
			c.getType().equals(Raphael.PATH_QUADBESIER_CURVETO) ||
			c.getType().equals(Raphael.PATH_CATMULLROM_CURVETO)) {
			
			if(len==0)
				return;
//			sb.append(c.getType());
			for (int i = 0; i < len; i++) {
				PCPoint[] a = _points[i];
				if(a!=null&&a.length>0) {
					sb.append(c.getType()+Math.round(a[0].getX())+","+Math.round(a[0].getY()));	
					if(a.length>=2) { //catmul second point is optional
						sb.append(","+a[1].getX()+","+a[2].getY());
					}
//					sb.append(i<len-1 ? "":",");
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
	
	
	//smoothQuadBezierCurveTo
	
	/**
	 * creates a new PathCmd of type "smoothQuadBezierCurveTo" and values "points" and concatenates after this PathCmd.
	 * Use: 
	 * path1.smoothQuadBezierCurveTo(new double[][]{{20,30}, {50,120}}); 
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
	
	/**
	 * adds a new close command, append it to th chain and return it
	 */
	public PathCmd close() {
		PathCmd pathCmd2 = new PathCmd();
		pathCmd2.setType(Raphael.PATH_CLOSEPATH);
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
