package org.sgx.raphael4gwt.raphael.svg.filter.params;


/**
 * http://www.w3.org/TR/SVG/filters.html#feTurbulenceElement
 * 
 * This filter primitive creates an image using the Perlin turbulence function. It allows the synthesis of artificial textures like clouds or marble. For a detailed description the
 * of the Perlin turbulence function, see "Texturing and Modeling", Ebert et al, AP Professional, 1994. The resulting image will fill the entire filter primitive subregion for this
 * filter primitive.
 * 
 * @author sg
 * 
 */
public class Turbulence extends FilterOperationParam {
	protected Turbulence() {
	}

	public static final native Turbulence create()/*-{
		return {
			"_filterName" : "feTurbulence", 
			"type": "turbulence", 
			"baseFrequency": 0.05, 
			"numOctaves": 2
		};
	}-*/;
	
	/**
	 * baseFrequency = "<number-optional-number>" The base frequency (frequencies) parameter(s) for the noise function. If two <number>s are provided, the first number represents a
	 * base frequency in the X direction and the second value represents a base frequency in the Y direction. If one number is provided, then that value is used for both X and Y. A
	 * negative value for base frequency is an error (see Error processing). If the attribute is not specified, then the effect is as if a value of 0 were specified.
	 * 
	 * @return
	 */
	public native final String baseFrequency() /*-{
		return this.baseFrequency;
	}-*/;

	/**
	 * baseFrequency = "<number-optional-number>" The base frequency (frequencies) parameter(s) for the noise function. If two <number>s are provided, the first number represents a
	 * base frequency in the X direction and the second value represents a base frequency in the Y direction. If one number is provided, then that value is used for both X and Y. A
	 * negative value for base frequency is an error (see Error processing). If the attribute is not specified, then the effect is as if a value of 0 were specified.
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final Turbulence baseFrequency(String val) /*-{
		this.baseFrequency = val;
		return this;
	}-*/;
	/**
	 * baseFrequency = "<number-optional-number>" The base frequency (frequencies) parameter(s) for the noise function. If two <number>s are provided, the first number represents a
	 * base frequency in the X direction and the second value represents a base frequency in the Y direction. If one number is provided, then that value is used for both X and Y. A
	 * negative value for base frequency is an error (see Error processing). If the attribute is not specified, then the effect is as if a value of 0 were specified.
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final Turbulence baseFrequency(double val) /*-{
		this.baseFrequency = val+"";
		return this;
	}-*/;

	/**
	 * The numOctaves parameter for the noise function. If the attribute is not specified, then the effect is as if a value of 1 were specified.
	 * 
	 * @return
	 */
	public native final int numOctaves() /*-{
		return this.numOctaves;
	}-*/;

	/**
	 * The numOctaves parameter for the noise function. If the attribute is not specified, then the effect is as if a value of 1 were specified.
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final Turbulence numOctaves(int val) /*-{
		this.numOctaves = val;
		return this;
	}-*/;

	/**
	 * The starting number for the pseudo random number generator. If the attribute is not specified, then the effect is as if a value of 0 were specified. When the seed number is
	 * handed over to the algorithm above it must first be truncated, i.e. rounded to the closest integer value towards zero.
	 * 
	 * @return
	 */
	public native final double seed() /*-{
		return this.seed;
	}-*/;

	/**
	 * The starting number for the pseudo random number generator. If the attribute is not specified, then the effect is as if a value of 0 were specified. When the seed number is
	 * handed over to the algorithm above it must first be truncated, i.e. rounded to the closest integer value towards zero.
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final Turbulence seed(double val) /*-{
		this.seed = val;
		return this;
	}-*/;

	/**
	 * 
	 * If stitchTiles="noStitch", no attempt it made to achieve smooth transitions at the border of tiles which contain a turbulence function. Sometimes the result will show clear
	 * discontinuities at the tile borders. If stitchTiles="stitch", then the user agent will automatically adjust baseFrequency-x and baseFrequency-y values such that the
	 * feTurbulence node's width and height (i.e., the width and height of the current subregion) contains an integral number of the Perlin tile width and height for the first
	 * octave. The baseFrequency will be adjusted up or down depending on which way has the smallest relative (not absolute) change as follows: Given the frequency, calculate
	 * lowFreq=floor(width*frequency)/width and hiFreq=ceil(width*frequency)/width. If frequency/lowFreq < hiFreq/frequency then use lowFreq, else use hiFreq. While generating
	 * turbulence values, generate lattice vectors as normal for Perlin Noise, except for those lattice points that lie on the right or bottom edges of the active area (the size of
	 * the resulting tile). In those cases, copy the lattice vector from the opposite edge of the active area.
	 * 
	 * <p>
	 * If attribute ‘stitchTiles’ is not specified, then the effect is as if a value of noStitch were specified.
	 * </p>
	 * 
	 * @return
	 */
	public native final String stitchTiles() /*-{
		return this.stitchTiles;
	}-*/;

	/**
	 * If stitchTiles="noStitch", no attempt it made to achieve smooth transitions at the border of tiles which contain a turbulence function. Sometimes the result will show clear
	 * discontinuities at the tile borders. If stitchTiles="stitch", then the user agent will automatically adjust baseFrequency-x and baseFrequency-y values such that the
	 * feTurbulence node's width and height (i.e., the width and height of the current subregion) contains an integral number of the Perlin tile width and height for the first
	 * octave. The baseFrequency will be adjusted up or down depending on which way has the smallest relative (not absolute) change as follows: Given the frequency, calculate
	 * lowFreq=floor(width*frequency)/width and hiFreq=ceil(width*frequency)/width. If frequency/lowFreq < hiFreq/frequency then use lowFreq, else use hiFreq. While generating
	 * turbulence values, generate lattice vectors as normal for Perlin Noise, except for those lattice points that lie on the right or bottom edges of the active area (the size of
	 * the resulting tile). In those cases, copy the lattice vector from the opposite edge of the active area.
	 * 
	 * <p>
	 * If attribute ‘stitchTiles’ is not specified, then the effect is as if a value of noStitch were specified.
	 * </p>
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final Turbulence stitchTiles(String val) /*-{
		this.stitchTiles = val;
		return this;
	}-*/;

	/**
	 * type = "fractalNoise | turbulence" Indicates whether the filter primitive should perform a noise or turbulence function. If attribute ‘type’ is not specified, then the
	 * effect is as if a value of turbulence were specified.
	 * 
	 * @return
	 */
	public native final String type() /*-{
		return this.type;
	}-*/;

	/**
	 * type = "fractalNoise | turbulence" Indicates whether the filter primitive should perform a noise or turbulence function. If attribute ‘type’ is not specified, then the
	 * effect is as if a value of turbulence were specified.
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final Turbulence type(String val) /*-{
		this.type = val;
		return this;
	}-*/;
}
