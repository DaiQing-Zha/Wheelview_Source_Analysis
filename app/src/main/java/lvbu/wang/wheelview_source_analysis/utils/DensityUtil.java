package lvbu.wang.wheelview_source_analysis.utils;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

/**
 * Created by Administrator on 2016/7/4.
 */
public class DensityUtil {

    /**
     * px转dp
     * @param context
     * @param pxVal
     * @return
     */
    public static float px2dp(Context context, float pxVal) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int)(pxVal/scale+0.5f);
    }

    /**
     * dp转px
     * @param context
     * @param dpVal
     * @return
     */
    public static float dp2px(Context context, float dpVal) {
        final float scale=context.getResources().getDisplayMetrics().density;
        return (int)(dpVal*scale+0.5f);
    }

    /**
     * 获取屏幕密度
     * @param activity
     * 比例形式
     * @return
     */
    public static float getDensity(Activity activity){
        DisplayMetrics metric = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(metric);
        return metric.density;
    }

    /**
     * 获取屏幕密度
     * dpi形式
     * @param activity
     * @return
     */
    public static int getDensityDpi(Activity activity){

        DisplayMetrics metric = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(metric);
        return metric.densityDpi;
    }

    /**
     * 获取屏幕宽度
     * @param context
     * @return
     */
    public static int getScreenWidth(Context context){

        WindowManager wm = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);

        int width = wm.getDefaultDisplay().getWidth();
        return width;
    }

    /**
     * 获取屏幕高度
     * @param context
     * @return
     */
    public static int getScreenHeight(Context context){

        WindowManager wm = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);

        int height = wm.getDefaultDisplay().getHeight();
        return height;
    }
}
