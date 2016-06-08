$(document)
		.ready(
				function() {

					var location = 'nyc';

					$("#location").keyup(function() {
						location = $("#location").val();

					});

					var templ = Hogan
							.compile([
									'<div data-id=\"{{id}}\"><img width=\"10%\"class=\"img-thumbnail\" src=\"{{pic}}\"/>',
									'<strong>{{name}}</strong> - {{title}}</div>' ]
									.join(''));

					$('#name-search .typeahead').typeahead({
						minLength : 1,
						hint : true
					}, {
						limit : 7,
						source : function(query, syncresults, process) {

							if (typeof searching != 'undefined') {
								clearTimeout(searching);
								// process([]);
							}

							searching = setTimeout(function() {
								return $.getJSON('api/i/v1/serach/ac?', {

									token : query,
									loc : location
								}, function(data) {

									// only search if stop typing for 300ms aka
									// fast typers
									return process(data.results);
								});
							}, 300); // 300 ms
						},
						display : 'name',
						templates : {
							suggestion : function(data) {
								return templ.render(data);
							}
						}
					});
					;

				});
