/**
 *
 */
package com.zhengyuli.lzyapp.util;

import android.util.Log;

/**
 * @author
 */
public class DebugLog {
    private static int mLogLever = Log.DEBUG;
    private static boolean mbDebug = true;

    private static String TAG = "wonderlife";

    public static void loge(String msg) {
        log(msg, Log.ERROR);
    }

    public static void logd(String msg) {
        log(msg, Log.DEBUG);
    }

    public static void logw(String msg) {
        log(msg, Log.WARN);
    }

    public static void logi(String msg) {
        log(msg, Log.INFO);
    }

    public static void logv(String msg) {
        log(msg, Log.VERBOSE);
    }

    public static void loge(String tag, String msg) {
        log(tag, msg, Log.ERROR);
    }

    public static void logd(String tag, String msg) {
        log(tag, msg, Log.DEBUG);
    }

    public static void logw(String tag, String msg) {
        log(tag, msg, Log.WARN);
    }

    public static void logi(String tag, String msg) {
        log(tag, msg, Log.INFO);
    }

    public static void logv(String tag, String msg) {
        log(tag, msg, Log.VERBOSE);
    }

    private static void log(String msg, int level) {
        log(TAG, msg, level);
    }

    private static void log(String tag, String msg, int level) {
        LogFile.getLogFile().writeLog(tag, msg, level);
        if (level < mLogLever) {
            return;
        }
        if (mbDebug) {
            StackTraceElement[] elements = (new Throwable()).getStackTrace();
            try {
                StackTraceElement ste = elements[3];
                Log.println(
                        level,
                        tag,
                        msg + "----" + ste.getFileName().split("\\.")[0] + ":"
                                + ste.getLineNumber() + ":"
                                + ste.getMethodName() + "()");
            } catch (Exception e) {
                Log.println(level, tag, msg);
            }
        } else {
            Log.println(level, tag, msg);
        }
    }

    public static void logd(String tag, String msg, Throwable tr) {
        if (mLogLever > Log.DEBUG)
            return;
//		if (DebugReceiver.isSm_debug()) {
//			Log.d(tag, msg, tr);
//		}
    }

    public static int getLOG_LEVEL() {
        return mLogLever;
    }

    public static void setLOG_LEVEL(int lOG_LEVEL) {
        mLogLever = lOG_LEVEL;
    }
}