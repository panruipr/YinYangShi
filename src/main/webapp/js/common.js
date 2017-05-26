(function(window, undefined) {
	
	var Pr = window.Pr || {};
	
	Pr.jsonDataRequest=function(config){
		$.ajax({
			url : config.url?config.url:'comm/test.action?noCache='+ new Date().getTime(),	// 若传递值，则使用传递的地址，若没有则使用默认的地址
			dataType : 'json',
			data : config.params,
			timeout : 30000,
			type : config.method,
			success : function(json) {
				if (config.sCallback) {
					config.sCallback(json);
				} else {

				}
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				if (config.eCallback) {
					config.eCallback(XMLHttpRequest, textStatus, errorThrown);
				} else {

				}
			}
		});
	};
	
})(window);