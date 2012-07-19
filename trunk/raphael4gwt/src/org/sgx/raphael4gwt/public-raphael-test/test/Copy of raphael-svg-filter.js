/* Raphael extensions to support SVG filters on Raphael shapes. 
 * 
 * @author: Sebastián Gurin (sg - sgurin - cancerbero_sgx)
 * 
 * The api consist on  a general API for administer "filter". the API for this is general and is very similar to SVG: 
 * Concepts: 
 * 
 * Filter: define a filter for one or more shapes to use. Each filter is added in paper.defs
 * 	and one or more shapes can use this filter. A filter contains one or more FilterOperations. 
 * 
 * FilterOperation: a filter contains an array of FilterOperations that correspond to one SVG filter operation like 
 * feSpecularLighting, feComposwite, etc. 
 * 
 * FilterOperationParams - an object that contains the filter operation parameters. 
 * 
 *  Use case
 *  var paper = Raphael(...); 
 *  var filter1 = paper.createFilter("filter1");
 *  
 *  var fop1Params = {funcR: {..}, ...}, //def of a svg componentTransfer
 *  	fop1 = Raphael.filter.componentTransfer(fop1Params); //the filteroperation object
 *  
 *  //add the filter operation to the filter object
 *  filter1.appendOperation(fop1); 
 *  
 *  var img1 = paper.image(...)
 *  img1.installFilter(filter1); 
 *  ..
 *  aSet.installFilter(filter1); 
 *  ..
 *  img1.uninstallFilter(filter1); 
 *  
 *  
 *  
 *  Reference: 
 *  
 *  - Filter: an object{filterId}  
 *  
 *  - FilterOperation: an object {name, appendFilterEl} - where name is 
 *  the name of the filter operation such as feGaussianBlur, feSpecularLighting, etc. 
 *  and where appendFilterEl is a function that appends  a SVG filter 
 *  operation inside the passed SVG filter element.
 *  Note: SVG filter operations are currently expressed as XML elements. 
 *  the appendFilterEl defines de filter operation by creating this element according to the
 *  FilterOperationParams object. So the user work with json objects that 
 *  currently will create the svg filter children.  
 *   
 *  TODO: svg filter common attributes, and filter output, referencing and composing....
 *  
 *  common attributes sollution: 
 * */

(function() {
	
var $ = function (el, attr) {
    if (attr) {
        for (var key in attr) if (attr.hasOwnProperty(key)) {
            el.setAttribute(key, attr[key]);
        }
    } else {
        return document.createElementNS("http://www.w3.org/2000/svg", el);
    }
};

Raphael.fn.filterCreate = function(filterId) {	
	var paper = this; 	
	if(!paper._filters)
		paper._filters = {}; 
	
	var filterEl = $("filter");
	paper._filters[filterId] = filterEl;
	$(filterEl, {id: filterId});	
    paper.defs.appendChild(filterEl);
	return {
		"paper": paper, 
		"filterId": filterId, 
		appendOperation: function(filterOp) {
			paper.filterAddOperation(this, filterOp); 
		}
	}; 		
}; 
Raphael.fn.removeFilter = function(filterI) {
	//TODO: 
};
Raphael.fn.filterAddOperation = function(filter, filterOperation) {
	var paper = this; 
	var filterEl = paper._filters[filter.filterId]; 
	filterOperation.appendFilterEl(filterEl); 
}; 
/**
 * installs a filter to this shape. 
 */
Raphael.el.installFilter = function(filter) {
	$(this.node, {filter: "url(#"+filter.filterId+")"}); 
}; 
/**
 * removes the filter from the shape. 
 */
Raphael.el.uninstallFilter = function(filter) {
	$(this.node, {filter: ""}); //TODO: test
}; 


//now filter operations definitions

Raphael.filterOps = {}; 

/* feGaussianBlurElement - http://www.w3.org/TR/SVG/filters.html#feGaussianBlurElement
 * FilterOperation : {name: "feGaussianBlurElement", params: {}, appendFilterEl}
 * 
 * svg example: 
 * <filter id="MyFilter" filterUnits="userSpaceOnUse" x="0" y="0" width="200" height="120">
      <feGaussianBlur in="SourceAlpha" stdDeviation="4" result="blur"/>
      
 */
Raphael.filterOps.feGaussianBlur = function(stdDeviation) {
	return {
		params: {"stdDeviation": stdDeviation}, 
		appendFilterEl: function(filterEl) {
			var filterOpEl = $("feGaussianBlur");
			filterOpEl.setAttribute("stdDeviation", this.params.stdDeviation); 
			filterEl.appendChild(filterOpEl); 
		}
	}; 
}; 


//feDistantLightElement - http://www.w3.org/TR/SVG/filters.html#feDistantLightElement


})(); //end of extension 
