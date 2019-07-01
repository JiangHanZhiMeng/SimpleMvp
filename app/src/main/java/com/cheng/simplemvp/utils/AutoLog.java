package com.cheng.simplemvp.utils;

import android.support.annotation.Nullable;
import android.util.Log;

/**
 * 日志管理工具
 * 时间： 2016/11/18 11:34
 * ---ZWQ---
 */
public class AutoLog {
    private static final String TAG = "AutoLog";

    public static boolean IS_DEBUG = true;
    public static boolean SHOW_ACTIVITY_STATE = true;//是否打印状态信息

    public static final void openActivityState(boolean enable) {
        SHOW_ACTIVITY_STATE = enable;
    }

    /**
     * v:调试颜色为黑色的，任何消息都会输出(零个或多个参数)
     */
    public static final void v(Object... format) {
        if (!IS_DEBUG) return;
        String log = creatTagInfo(format);
        if (log == null) return;
        if (IS_DEBUG) {
            Log.v(getCodeInfo(true), log);
        }
    }

    /**
     * 创建标记的信息
     *
     * @param format
     * @return
     */
    @Nullable
    private static String creatTagInfo(Object[] format) {
        int len = format.length;
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < len; i++) {
            String str = format[i] + "";
            if (i != len - 1) {
                sb.append(str).append(", ");
            } else {
                sb.append(str);
            }
        }
        String log = sb.toString().trim() + " ";//结尾加空字符是为了显示打印为null的字符

        return log;
    }

    /**
     * 可开关，定位到行
     * v:调试颜色为黑色的，任何消息都会输出
     */
    public static final void v(String tag, String msg) {
        if (IS_DEBUG) {
            Log.v(getCodeInfo(true) + "-" + tag, msg + "");
        }
    }

    public static final void v(String tag, String msg, Throwable tr) {
        if (IS_DEBUG) {
            Log.v(tag, msg + "", tr);
        }
    }

    /**
     * d:输出颜色是蓝色的，仅输出debug调试的意思，但他会输出上层的信息
     */
    public static final void d(Object... format) {
        if (!IS_DEBUG) return;
        String log = creatTagInfo(format);
        if (log == null) return;
        if (IS_DEBUG) {
            Log.d(getCodeInfo(true), log);
        }
    }

    /**
     * d:输出颜色是蓝色的，仅输出debug调试的意思，但他会输出上层的信息
     */
    public static final void d(String tag, String msg) {
        if (IS_DEBUG) {
            Log.d(tag, msg + "");
        }
    }

    public static final void d(String tag, String msg, Throwable tr) {
        if (IS_DEBUG) {
            Log.d(tag, msg + "", tr);
        }
    }

    /**
     * i:输出为绿色，一般提示性的消息information，它不会输出Log.v和Log.d的信息，但会显示i、w和e的信息
     */
    public static final void i(Object... format) {
        if (!IS_DEBUG) return;
        String log = creatTagInfo(format);
        if (log == null) return;
        if (IS_DEBUG) {
            Log.i(getCodeInfo(true), log);
        }
    }

    /**
     * i:输出为绿色，一般提示性的消息information，它不会输出Log.v和Log.d的信息，但会显示i、w和e的信息
     */
    public static final void i(String tag, String msg) {
        if (IS_DEBUG) {
            Log.i(tag, msg + "");
        }
    }

    public static final void i(String tag, String msg, Throwable tr) {
        if (IS_DEBUG) {
            Log.i(tag, msg + "", tr);
        }
    }

    /**
     * w:颜色为橙色，可以看作为warning警告，一般需要我们注意优化Android代码，同时选择它后还会输出Log.e的信息
     */
    public static final void w(Object... format) {
        if (!IS_DEBUG) return;
        String log = creatTagInfo(format);
        if (log == null) return;
        if (IS_DEBUG) {
            Log.w(getCodeInfo(true), log);
        }
    }

    /**
     * w:颜色为橙色，可以看作为warning警告，一般需要我们注意优化Android代码，同时选择它后还会输出Log.e的信息
     */
    public static final void w(String tag, String msg) {
        if (IS_DEBUG) {
            Log.w(tag, msg + "");
        }
    }

    public static final void w(String tag, String msg, Throwable tr) {
        if (IS_DEBUG) {
            Log.w(tag, msg + "", tr);
        }
    }

    public static final void w(String tag, Throwable tr) {
        if (IS_DEBUG) {
            Log.w(tag, tr);
        }
    }

    /**
     * e:颜色为红色，可以想到error错误，这里仅显示红色的错误信息
     */
    public static final void e(Object... format) {
        if (!IS_DEBUG) return;
        String log = creatTagInfo(format);
        if (log == null) return;
        if (IS_DEBUG) {
            Log.e(getCodeInfo(true), log);
        }
    }

    /**
     * e:颜色为红色，可以想到error错误，这里仅显示红色的错误信息
     */
    public static final void e(String tag, String msg) {
        if (IS_DEBUG) {
            Log.e(tag, msg + "");
        }
    }

    public static final void e(String tag, String msg, Throwable tr) {
        if (IS_DEBUG) {
            Log.e(tag, msg + "", tr);
        }
    }

    /**
     * 打印状态
     */
    public static final void state(String packName, String state) {
        if (SHOW_ACTIVITY_STATE) {
            Log.d("activity_state", packName + " ^.^ " + state);
        }
    }

    /**
     * 获得当前代码所在文件，方法，行
     *
     * @return
     */
    public static String getCodeInfo(boolean isShowClassName) {
        StackTraceElement traceElement = ((new Exception()).getStackTrace())[2];
        StringBuffer sb = new StringBuffer();
        if (isShowClassName) {
            String fileName = traceElement.getFileName();
            fileName = fileName.replace(".java", "");
            sb.append(fileName).append("/");

        }
        sb.append(traceElement.getMethodName()).append("/").append(traceElement.getLineNumber());
        return sb.toString().trim();
    }
}

