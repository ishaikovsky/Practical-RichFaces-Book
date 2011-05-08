(function($) {
	$.fn.Spinner = function(attachTo, opts) {
		if (opts) {
			var options = $.extend({}, defaultOptions, opts);
		}
		this.step = options.step;
		this.maxValue = options.maxValue;
		this.minValue = options.minValue;
		this.currentValue = options.value;
		this.id = attachTo;
		this.input = document.getElementById(attachTo + "Input");
		this.incControl = document.getElementById(attachTo + 'Inc');
		this.decControl = document.getElementById(attachTo + 'Dec');
		$(this.incControl).bind('click', {
			component : this
		}, inc);
		$(this.decControl).bind('click', {
			component : this
		}, dec);
		$(this.input).bind('keydown', {
			component : this
		}, handleKey);
		$(this.input).bind('change', {
			component : this
		}, verify);		
	};
	var defaultOptions = {
		step : 1,
		maxValue : 100,
		minValue : 0
	};
	function inc(event) {
		var component = event.data.component;
		newValue = Number(component.input.value) + (component.step);
		if (newValue < component.maxValue){
			component.input.value=newValue;
			component.currentValue=newValue;
		}
	}
	;
	function dec(event) {
		var component = event.data.component;
		newValue = Number(component.input.value) - (component.step);
		if (newValue > component.minValue){
			component.input.value=newValue;
			component.currentValue=newValue;
		}
	}
	;
	function verify(event) {
		var component = event.data.component;
		var	valueToVerify = component.input.value;
		if (isNaN(valueToVerify)) {
			component.input.value = component.currentValue; return;
		}
		if (Number(valueToVerify) < component.minValue){
			component.input.value = component.minValue; 
			component.currentValue = component.minValue;
			return ;
		}
		if (Number(valueToVerify) > component.maxValue) {
			component.currentValue = component.maxValue;
			component.input.value = component.maxValue;
			return ;
		} 
		component.currentValue = component.input.value;
	}
	;
	function handleKey(event) {
		switch (event.keyCode) {
		case 38:
			inc(event);
			break;
		case 40:
			dec(event);
			break;
		}
	}
})(jQuery);