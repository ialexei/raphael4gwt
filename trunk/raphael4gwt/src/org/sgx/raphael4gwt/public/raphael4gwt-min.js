(function(){window.r4g={_castToBoolean:function(a){if(typeof(a)=="object"){return(a+"")=="true"}else{return a}},dump:function(d,a){var c="{";for(var b in d){if(a){c+=b+": "+d[b]+", "}else{c+=b+", "}}return c+"}"
},_isPointInside:function(b,a,c){return a>b.x&&a<b.x+b.width&&c>b.y&&c<b.y+b.height},function_throttle:function(b,c,g,f){var e,a=0;if(typeof c!=="boolean"){f=g;g=c;c=undefined}function d(){var l=this,j=+new Date()-a,k=arguments;
function i(){a=+new Date();g.apply(l,k)}function h(){e=undefined}if(f&&!e){i()}e&&clearTimeout(e);if(f===undefined&&j>b){i()}else{if(c!==true){e=setTimeout(f?h:i,f===undefined?b-j:b)}}}return d},"":""}
})();