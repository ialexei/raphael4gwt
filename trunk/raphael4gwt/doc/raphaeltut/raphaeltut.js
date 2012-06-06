//javascript for the raphael tut 
//author: sgurin
(function(){
		
	window.rt={};
	rt.raphaelRefUrl="raphael-ref/index.html";//"http://raphaeljs.com/reference.html";
	
	
	
	
	
	rt.showReference_visited=false;
	rt.showReference_ = function(ref) {
		$("#refererenceDialogFrame").attr("src", rt.raphaelRefUrl+"#"+ref);
		if(!rt.showReference_visited) {
			rt.showReference_visited=true;
			rt.showRefTimer = setTimeout("rt.showReference_('"+ref+"')", 1000);
		}
	}
	rt.showReference = function(ref) {
		if(rt.showRefTimer)
			clearTimeout(rt.showRefTimer);
		rt.showReference_visited=false;
		$("#refererenceDialog").show();
		rt.showReference_(ref);
	}
	
	
	
	//doc init
	$(window).load(function(){
		
		raphaeltutCoreRunPaper = Raphael("exampleDialogContent", 500,500);
		
		$("#refererenceDialogContent").append(
			'<iframe id="refererenceDialogFrame" src="'+rt.raphaelRefUrl+'"></iframe>');
			
		$(".note").before('<div class="note-icon">!</div>')
		$(".note").next().css({clear: "both"})
		
//		$("#generated-toc>p").hide();
		
		
		//code - run -dialog
		
		$(".code-run").each(function(){
			$(this).addClass("prettyprint");
			$(this).after('<div class="code-run-button">Run</div>')
			$(this).next().click(function(){
				var code = "var paper = raphaeltutCoreRunPaper;paper.clear();"+$(this).prev().text();
				eval(code);
				$("#exampleDialog").show();
			});
		});
		
		$(".code-run, .code").each(function(){
			if($(this).attr("href")) {
				var target = null; 
				try {
					target = $("#"+$(this).attr("href"));
				} catch (e) {
					// TODO: handle exception
				}
				
				if(target!=null&&target.size()>0) {				
					var codeEl = target.clone(true, true);			
					$(this).after(codeEl);
					codeEl.addClass("prettyprint");
					$(this).remove();
				}
				
			}
		});
		
		$(".raphael-ref").each(function(){
			var onclick = 'rt.showReference(\''+
					$(this).attr("href")+'\');';
			$(this).after('<span class="raphael-ref-link" onclick="'+onclick+'">'+$(this).text()+'</span>');
		});
				
		//index
		
		if($("#generated-index").size()>0) {
			rt.indexCounter=0;
			rt.indexTerms={};
			$(".index").each(function(){				
				if(!$(this).attr("id")) {
					$(this).attr("id", "index-term-"+rt.indexCounter);
					rt.indexCounter++;
				}
				var text = $(this).text().toLowerCase();
				if(!rt.indexTerms[text]) 
					rt.indexTerms[text]=[];
				rt.indexTerms[text].push($(this).attr("id"));
			});
			var sb = [];
			sb.push("<ul>");
			var names = [];
			for(var i in rt.indexTerms) {
				names.push(i);
			}
			names.sort();
			for(var i = 0; i < names.length; i++) {
				sb.push("<li><b>"+names[i]+"</b>: ");
				for (var j = 0; j < rt.indexTerms[names[i]].length; j++) {
					sb.push("<a href=\"#"+rt.indexTerms[names[i]][j]+"\">"+j+"</a>");
				}
				sb.push("</li>");
			}
			sb.push("</ul>");
			
			$("#generated-index").after(sb.join(""));
		}
		
		/* code-method-doc: method signature documentation like javadoc formatting. 
		 * tags: @return @param @signature, use like this and please respect the order of annotations:
		 * 
		 * <p class="code-method-doc">
		 * @signature paper.rect(x, y, width, height)
		 * @param x the x coord (number)
		 * @param y the y coord (number)
		 * @return a new rectangle shape
		 * </p>
		 * 
		 * will generate
		 * 
		 * <p class="code-method-doc">
		 * <span class="signature">paper.rect(x, y, width, height)</span>
		 * <span class="param">x - the x cood (number) </span>
		 * <span class="param">y - the y cood (number) </span>
		 * <span class="return">a new rectangle shape</span>
		 * </p>
		 */
		$(".code-method-doc").each(function(){
			var t = $(this).text(), returnStr="", signatureStr=null, params=[];
			if(t.indexOf("@return")!=-1) {
				t=t.split("@return");
				if(t.length >= 2)
					returnStr = t[1];
				t=t[0];
			}
			if(t.indexOf("@param")!=-1) {
				t=t.split("@param");
				if(t.length >= 2) {
					for ( var i = 1; i < t.length; i++) {
						params.push(t[i]);
					}
				}
				t=t[0];
			}
			if(t.indexOf("@signature")!=-1) {
				t=t.split("@signature");
				if(t.length >= 2) {
					signatureStr=t[1];
				}
				t=t[0];
			}
			var sb = [];
			if(signatureStr)
				sb.push('Signature: <span class="signature">'+signatureStr+'</span> ');
			if(params.length>0)
				sb.push('Parameters: ');
			for ( var i = 0; i < params.length; i++) 
				sb.push('<span class="param">'+params[i]+'</span>')
			if(returnStr)
				sb.push('Returns: <span class="return">'+returnStr+'</span>');
			
			var s = sb.join("");
//			alert(s);
			$(this).prop("innerHTML", s);//.html(s);
			
		});
		
		prettyPrint();
		
		if(window.raphaeltutTimer1)
			alert("Tutorial loaded in "+(new Date().getTime()-window.raphaeltutTimer1));
		
	});
	
})();