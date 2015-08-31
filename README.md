# com.zhxjz.map.plugin.captureScreenSize
获取屏幕尺寸大小<br/>
用法：<br/>
1.获取屏幕尺寸大小<br/>
captureScreenSize.getScreenSize(function(point){<br/>
  var screenWidth = point[0];<br/>
  var screenHeight = point[1];<br/>
},function(){alert('error')});<br/>
<br/>
2.获取状态栏（statusbar）的高度<br/>
captureScreenSize.getStatusBarHeight(function(point){<br/>
  var barHeight = point[0];<br/>
},function(){alert('error')});<br/>
<br/>
备注：<br/>
在cordova-hybrid模式下，js获取不到屏幕的真实尺寸，需要调用原生获取返回<br/>

<h1>enjoy it :)</h1>
