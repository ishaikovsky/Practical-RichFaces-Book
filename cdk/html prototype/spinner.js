(function($) {
   var defaultOptions = {
      step : 1,
      maxValue : 100,
      minValue : 0
   };
   $.fn.Spinner = function(opts) {
      var options = $.extend({}, defaultOptions, opts);	
      return this.each(function() {
         var input = document.getElementById(this.id + "Input");
         var incControl = document.getElementById(this.id + 'Inc');
         var decControl = document.getElementById(this.id + 'Dec');
         var inc = function (event) {
            var newValue = Number(input.value) + (options.step);
            if (newValue < options.maxValue){
               input.value=currentValue=newValue;
            } else {
               input.value=currentValue=options.maxValue;
            }
         };
         var dec = function(event) {
            var newValue = Number(input.value) - (options.step);
            if (newValue > options.minValue){
               input.value=currentValue=newValue;
            } else {
               input.value=currentValue=options.minValue;
            }
         };
         var handleKey = function(event) {
            switch (event.keyCode) {
               case 38:
                  inc(event); break;
               case 40:
                  dec(event); break;
               }
         };
         var verify = function(event) {
            var valueToVerify = input.value;
            if (isNaN(valueToVerify)) {
               input.value = currentValue;
               return;
            }
            if (Number(valueToVerify) < options.minValue){
               input.value = currentValue = options.minValue; 
               return ;
            }
            if (Number(valueToVerify) > options.maxValue) {
               input.value = currentValue = options.maxValue;
               return ;
            } 
            currentValue = input.value;
         };
         $(incControl).click(inc);
         $(decControl).click(dec);
         $(input).keydown(handleKey);
         $(input).change(verify);			
         if (!isNaN(options.value)) {
            input.value = options.value;
            verify();
         }
      });		
   };
})(jQuery) ;
