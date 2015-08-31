var cordova = require('cordova');

var captureScreenSize = {

	"getScreenSize" : function(onSuccessFn, onErrorFn){
		cordova.exec(onSuccessFn, onErrorFn, 'CaptureScreenSizePlugin', 'getScreenSize', []); 
	},
	
	"getStatusBarHeight" : function(onSuccessFn, onErrorFn){
		cordova.exec(onSuccessFn, onErrorFn, 'CaptureScreenSizePlugin', 'getStatusBarHeight', []); 
	}

};

module.exports = captureScreenSize;

