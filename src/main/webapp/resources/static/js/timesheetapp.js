(function($) {
	$(function() {
	
		Globalize.loadMessages({
	        "de": {
	          'welcome': 'Wilkommen, {name}!'
	            },
            "en": {
  	          'welcome': 'Welcome, {name}!'
  	            }
		    });
		var globalize = new Globalize("de");
		i18n.load("de","DE");
		var welcome_message = globalize.messageFormatter('welcome');
		$('#saveButton').click(function() {
			alert(welcome_message({name: 'John'}));
			alert(i18n._("registrationForm.firstName"));
			return false;
		});

		var translate = function (text) {
	        return Globalize("en").formatMessage(text);
	    };
	});
}(jQuery));