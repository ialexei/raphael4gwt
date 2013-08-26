module.exports = function(grunt) {

// Project configuration.
grunt.initConfig({
	pkg : grunt.file.readJSON('package.json'),
	uglify : {
		options : {
			banner : '/*! <%= pkg.name %> <%= grunt.template.today("yyyy-mm-dd") %> */\n'
//			mangle: false
		},

		my_target : {
			files : {
			
				//raphael
				
				'src/org/sgx/raphael4gwt/public/raphael-min.js' : [  'src/org/sgx/raphael4gwt/public/raphael.js'  ]
			,	'src/org/sgx/raphael4gwt/public/raphael-ext-min.js' : [  'src/org/sgx/raphael4gwt/public/raphael-ext.js'  ]
			,	'src/org/sgx/raphael4gwt/public/raphael.free_transform-min.js' : [  'src/org/sgx/raphael4gwt/public/raphael.free_transform.js'  ]
			,	'src/org/sgx/raphael4gwt/public/raphael-svg-filter-min.js' : [  'src/org/sgx/raphael4gwt/public/raphael-svg-filter.js'  ]
			,	'src/org/sgx/raphael4gwt/public/raphael4gwt-min.js' : [  'src/org/sgx/raphael4gwt/public/raphael4gwt.js'  ]

			,	'src/org/sgx/raphael4gwt/public/raphael4gwt-all-min.js' : [ 
			 	    'src/org/sgx/raphael4gwt/public/raphael-min.js'
			 	,	'src/org/sgx/raphael4gwt/public/raphael-ext-min.js'
			 	,	'src/org/sgx/raphael4gwt/public/raphael.free_transform-min.js' 
			 	,	'src/org/sgx/raphael4gwt/public/raphael-svg-filter-min.js'
			 	,	'src/org/sgx/raphael4gwt/public/raphael4gwt-min.js'
	            ]
		
		
				//raphycharts & gantt
		
			,	'src/org/sgx/raphael4gwt/public/raphycharts-min.js' : [  'src/org/sgx/raphael4gwt/public/raphycharts.js'  ]
			,	'src/org/sgx/raphael4gwt/public/moment-min.js' : [  'src/org/sgx/raphael4gwt/public/moment.js'  ]		
			,	'src/org/sgx/raphael4gwt/public/raphael-gantt-min.js' : [  'src/org/sgx/raphael4gwt/public/raphael-gantt.js'  ]
		
			,	'src/org/sgx/raphael4gwt/public/raphycharts-all-min.js' : [ 
  			 	    'src/org/sgx/raphael4gwt/public/raphycharts-min.js'
  			 	,	'src/org/sgx/raphael4gwt/public/moment-ext-min.js'
  			 	,	'src/org/sgx/raphael4gwt/public/raphael-gantt-min.js' 
  	            ]		
		
		
		
			//graphael
			,	'src/org/sgx/raphael4gwt/public-graphael/graphael/g.raphael-min.js' : [  'src/org/sgx/raphael4gwt/public-graphael/graphael/g.raphael.js'  ]
			,	'src/org/sgx/raphael4gwt/public-graphael/graphael/g.bar-min.js' : [  'src/org/sgx/raphael4gwt/public-graphael/graphael/g.bar.js'  ]
			,	'src/org/sgx/raphael4gwt/public-graphael/graphael/g.dot-min.js' : [  'src/org/sgx/raphael4gwt/public-graphael/graphael/g.dot.js'  ]
			,	'src/org/sgx/raphael4gwt/public-graphael/graphael/g.line-min.js' : [  'src/org/sgx/raphael4gwt/public-graphael/graphael/g.line.js'  ]
			,	'src/org/sgx/raphael4gwt/public-graphael/graphael/g.pie-min.js' : [  'src/org/sgx/raphael4gwt/public-graphael/graphael/g.pie.js'  ]
			,	'src/org/sgx/raphael4gwt/public-graphael/graphael/g.sunburst-min.js' : [  'src/org/sgx/raphael4gwt/public-graphael/graphael/g.sunburst.js'  ]
			,	'src/org/sgx/raphael4gwt/public-graphael/graphael/g.radar-min.js' : [  'src/org/sgx/raphael4gwt/public-graphael/graphael/g.radar.js'  ]		
			,	'src/org/sgx/raphael4gwt/public-graphael/graphael/raphalytics-min.js' : [  'src/org/sgx/raphael4gwt/public-graphael/graphael/raphalytics.js'  ]
			,	'src/org/sgx/raphael4gwt/public-graphael/graphael/g.org-min.js' : [  'src/org/sgx/raphael4gwt/public-graphael/graphael/g.org.js'  ]
			,	'src/org/sgx/raphael4gwt/public-graphael/graphael/donut-min.js' : [  'src/org/sgx/raphael4gwt/public-graphael/graphael/donut.js'  ]
			,	'src/org/sgx/raphael4gwt/public-graphael/graphael/coxcomb-min.js' : [  'src/org/sgx/raphael4gwt/public-graphael/graphael/coxcomb.js'  ]
	
			,	'src/org/sgx/raphael4gwt/public-graphael/graphael/g.raphael.all-min.js' : [ 
			 	    'src/org/sgx/raphael4gwt/public-graphael/graphael/g.raphael-min.js'
			 	,	'src/org/sgx/raphael4gwt/public-graphael/graphael/g.bar-min.js'
			 	, 	'src/org/sgx/raphael4gwt/public-graphael/graphael/g.dot-min.js'
			 	,	'src/org/sgx/raphael4gwt/public-graphael/graphael/g.line-min.js'
			 	,	'src/org/sgx/raphael4gwt/public-graphael/graphael/g.pie-min.js'
			 	,	'src/org/sgx/raphael4gwt/public-graphael/graphael/g.sunburst-min.js'
			 	,	'src/org/sgx/raphael4gwt/public-graphael/graphael/g.radar-min.js'
			 	,	'src/org/sgx/raphael4gwt/public-graphael/graphael/raphalytics-min.js'
			 	,	'src/org/sgx/raphael4gwt/public-graphael/graphael/g.org-min.js'
			 	,	'src/org/sgx/raphael4gwt/public-graphael/graphael/donut-min.js'
			 	,	'src/org/sgx/raphael4gwt/public-graphael/graphael/coxcomb-min.js'
			    ]			
			}
		}
	}
});


// Load the plugin that provides the "uglify" task.
grunt.loadNpmTasks('grunt-contrib-uglify');

// Default task(s).
grunt.registerTask('default', [ 'uglify' ]);

};