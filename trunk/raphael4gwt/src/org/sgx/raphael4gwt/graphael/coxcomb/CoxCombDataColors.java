package org.sgx.raphael4gwt.graphael.coxcomb;
/**
 * the data.colors property.
 * @see https://github.com/guilespi/coxcomb-chart
 * @author sg
 *
 */
public class CoxCombDataColors extends CoxCombDataColor {
	protected CoxCombDataColors() {
	}

	/**
	 * color of the category
	 * 
	 * @return
	 */
	public native final String category() /*-{
		return this["category"];
	}-*/;

	/**
	 * color of the category
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final CoxCombDataColors category(String val) /*-{
		this["category"] = val;
		return this;
	}-*/;

	/**
	 * <p>
	 * This coloring scheme assumes categories are not related and lets you specify a different color for each category bars.
	 * </p>
	 * 
	 * <div class="highlight">
	 * 
	 * <pre>
	 * <span class="nx">byCategory</span> <span class="o">:</span> <span class="p">{</span>
	 *         <span class="nx">Tools</span> <span class="o">:</span> <span class="p">{</span>
	 *             <span class="nx">color</span> <span class="o">:</span> <span class="s2">"#E9E581"</span><span class="p">,</span>
	 *             <span class="nx">opacity</span> <span class="o">:</span> <span class="mf">0.8</span><span class="p">,</span>
	 *             <span class="nx">fontColor</span><span class="o">:</span> <span class="s2">"#000000"</span>
	 *         <span class="p">},</span>
	 *         <span class="nx">Languages</span> <span class="o">:</span> <span class="p">{</span>
	 *             <span class="nx">color</span><span class="o">:</span> <span class="s2">"#DE1B1B"</span><span class="p">,</span>
	 *             <span class="nx">opacity</span><span class="o">:</span> <span class="mf">0.7</span><span class="p">,</span>
	 *             <span class="nx">fontColor</span><span class="o">:</span> <span class="s2">"#fff"</span>
	 *         <span class="p">},</span>
	 *     <span class="p">}</span>
	 * </pre>
	 * 
	 * </div>
	 * 
	 * <p>
	 * You can check out a running sample <a href="http://resume.guillermowinkler.com">here</a>
	 * </p>
	 * 
	 * @return
	 */
	public native final JsMap<CoxCombDataColor> byCategory() /*-{
		return this["byCategory"];
	}-*/;

	/**
	 * <p>
	 * This coloring scheme assumes categories are not related and lets you specify a different color for each category bars.
	 * </p>
	 * 
	 * <div class="highlight">
	 * 
	 * <pre>
	 * <span class="nx">byCategory</span> <span class="o">:</span> <span class="p">{</span>
	 *         <span class="nx">Tools</span> <span class="o">:</span> <span class="p">{</span>
	 *             <span class="nx">color</span> <span class="o">:</span> <span class="s2">"#E9E581"</span><span class="p">,</span>
	 *             <span class="nx">opacity</span> <span class="o">:</span> <span class="mf">0.8</span><span class="p">,</span>
	 *             <span class="nx">fontColor</span><span class="o">:</span> <span class="s2">"#000000"</span>
	 *         <span class="p">},</span>
	 *         <span class="nx">Languages</span> <span class="o">:</span> <span class="p">{</span>
	 *             <span class="nx">color</span><span class="o">:</span> <span class="s2">"#DE1B1B"</span><span class="p">,</span>
	 *             <span class="nx">opacity</span><span class="o">:</span> <span class="mf">0.7</span><span class="p">,</span>
	 *             <span class="nx">fontColor</span><span class="o">:</span> <span class="s2">"#fff"</span>
	 *         <span class="p">},</span>
	 *     <span class="p">}</span>
	 * </pre>
	 * 
	 * </div>
	 * 
	 * <p>
	 * You can check out a running sample <a href="http://resume.guillermowinkler.com">here</a>
	 * </p>
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final CoxCombDataColors byCategory(JsMap<CoxCombDataColor> val) /*-{
		this["byCategory"] = val;
		return this;
	}-*/;

	/**
	 * 
	 <p>
	 * This coloring scheme assumes the same series repeat for each category and you want the same color for the same serie in each category.
	 * </p>
	 * 
	 * <div class="highlight">
	 * 
	 * <pre>
	 * <span class="nx">bySeries</span> <span class="o">:</span> <span class="p">{</span>
	 *         <span class="nx">disease</span>  <span class="o">:</span> <span class="p">{</span>
	 *           <span class="nx">color</span> <span class="o">:</span> <span class="s2">"#E9E581"</span><span class="p">,</span>
	 *           <span class="nx">opacity</span> <span class="o">:</span> <span class="mf">0.8</span><span class="p">,</span>
	 *           <span class="nx">fontColor</span><span class="o">:</span> <span class="s2">"#000"</span><span class="p">,</span>
	 *         <span class="p">},</span>
	 *         <span class="nx">wounds</span> <span class="o">:</span> <span class="p">{</span>
	 *           <span class="nx">color</span><span class="o">:</span> <span class="s2">"#DE1B1B"</span><span class="p">,</span>
	 *           <span class="nx">opacity</span><span class="o">:</span> <span class="mf">0.7</span><span class="p">,</span>
	 *           <span class="nx">fontColor</span><span class="o">:</span> <span class="s2">"#fff"</span>
	 *         <span class="p">}</span>
	 *     <span class="p">}</span>
	 * </pre>
	 * 
	 * </div>
	 * 
	 * <p>
	 * You can check out a running sample <a href="http://blog.guillermowinkler.com/blog/2012/11/25/coxcomb-charts-with-raphael-dot-js/">here</a>
	 * </p>
	 * 
	 * @return
	 */
	public native final JsMap<CoxCombDataColor> bySeries() /*-{
		return this["bySeries"];
	}-*/;

	/**
	 * 
	 <p>
	 * This coloring scheme assumes the same series repeat for each category and you want the same color for the same serie in each category.
	 * </p>
	 * 
	 * <div class="highlight">
	 * 
	 * <pre>
	 * <span class="nx">bySeries</span> <span class="o">:</span> <span class="p">{</span>
	 *         <span class="nx">disease</span>  <span class="o">:</span> <span class="p">{</span>
	 *           <span class="nx">color</span> <span class="o">:</span> <span class="s2">"#E9E581"</span><span class="p">,</span>
	 *           <span class="nx">opacity</span> <span class="o">:</span> <span class="mf">0.8</span><span class="p">,</span>
	 *           <span class="nx">fontColor</span><span class="o">:</span> <span class="s2">"#000"</span><span class="p">,</span>
	 *         <span class="p">},</span>
	 *         <span class="nx">wounds</span> <span class="o">:</span> <span class="p">{</span>
	 *           <span class="nx">color</span><span class="o">:</span> <span class="s2">"#DE1B1B"</span><span class="p">,</span>
	 *           <span class="nx">opacity</span><span class="o">:</span> <span class="mf">0.7</span><span class="p">,</span>
	 *           <span class="nx">fontColor</span><span class="o">:</span> <span class="s2">"#fff"</span>
	 *         <span class="p">}</span>
	 *     <span class="p">}</span>
	 * </pre>
	 * 
	 * </div>
	 * 
	 * <p>
	 * You can check out a running sample <a href="http://blog.guillermowinkler.com/blog/2012/11/25/coxcomb-charts-with-raphael-dot-js/">here</a>
	 * </p>
	 * 
	 * @param val
	 * @return this - for setter chaining
	 */
	public native final CoxCombDataColors bySeries(JsMap<CoxCombDataColor> val) /*-{
		this["bySeries"] = val;
		return this;
	}-*/;

}
