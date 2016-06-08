$(document).ready(function() {
	$('#businesses').click(function(){

		$.get( 
                "actions/bus",
                function(data) {
                  alert('Done.');
                }
             );
		
		 alert('Done!');
	});
});