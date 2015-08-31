package com.zhxjz.map.plugin;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

import android.content.res.Resources;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

/**
 *
 * 获取屏幕尺寸插件
 * @author yangxy
 * 
 */
public class CaptureScreenSize extends CordovaPlugin {

	@Override
	public boolean execute(String action, JSONArray args,
			CallbackContext callbackContext) throws JSONException {

		try {
			JSONArray arr = new JSONArray();
			if(action.equals("getScreenSize")) {
				Point point = getScreenSize();
				arr.put(0, point.x);
				arr.put(1, point.y);
			}
			else if(action.equals("getStatusBarHeight")) {
				int statusBarHeight = getStatusBarHeight();
				arr.put(0, statusBarHeight);
			}
			else {
				throw new Exception("调用未知方法：" + action);
			}
			callbackContext.success(arr);
			return true;
		} catch (Exception e) {
			callbackContext.error(e.getMessage());
			return false;
		}
	}

	private Point getScreenSize() {
		WindowManager wm = (WindowManager) this.webView.getContext()
				.getSystemService("window");
		Display display = wm.getDefaultDisplay();
		DisplayMetrics dm = new DisplayMetrics();
		display.getMetrics(dm);
		float density = dm.density; // 屏幕密度（像素比例：0.75/1.0/1.5/2.0）
		Point point = new Point();
		display.getRealSize(point);
		point.x = (int) (point.x / density);
		point.y = (int) (point.y / density);
		return point;
	}

	private int getStatusBarHeight() {
		Resources resources = this.webView.getContext().getResources();
		int result = 0;
		int resourceId = resources.getIdentifier("status_bar_height", "dimen",
				"android");
		if (resourceId > 0) {
			result = resources.getDimensionPixelSize(resourceId);
		}
		return result;
	}

}
