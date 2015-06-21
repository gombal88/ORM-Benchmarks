package pl.gombal.orm_benchmarks.util;

import android.util.Log;

import pl.gombal.orm_benchmarks.app.AppController;

public class LogUtils {

    private LogUtils() {
    }

    public static void LOGD(final String tag, String message) {
        if (AppController.DEBUG) {
            Log.d(tag, message);
        }
    }

    public static void LOGD(final String tag, String message, Throwable cause) {
        if (AppController.DEBUG) {
            Log.d(tag, message, cause);
        }
    }

    public static void LOGV(final String tag, String message) {
        if (AppController.DEBUG) {
            Log.v(tag, message);
        }
    }

    public static void LOGV(final String tag, String message, Throwable cause) {
        if (AppController.DEBUG) {
            Log.v(tag, message, cause);
        }
    }

    public static void LOGI(final String tag, String message) {
        Log.i(tag, message);
    }

    public static void LOGI(final String tag, String message, Throwable cause) {
        Log.i(tag, message, cause);
    }

    public static void LOGW(final String tag, String message) {
        Log.w(tag, message);
    }

    public static void LOGW(final String tag, String message, Throwable cause) {
        Log.w(tag, message, cause);
    }

    public static void LOGE(final String tag, String message) {
        Log.e(tag, message);
    }

    public static void LOGE(final String tag, String message, Throwable cause) {
        Log.e(tag, message, cause);
    }

}
