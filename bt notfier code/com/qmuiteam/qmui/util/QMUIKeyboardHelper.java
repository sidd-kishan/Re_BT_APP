/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Application$ActivityLifecycleCallbacks
 *  android.content.Context
 *  android.graphics.Rect
 *  android.util.Log
 *  android.view.View
 *  android.view.ViewTreeObserver$OnGlobalLayoutListener
 *  android.view.inputmethod.InputMethodManager
 *  android.widget.EditText
 *  com.qmuiteam.qmui.util.QMUIDisplayHelper
 *  com.qmuiteam.qmui.util.QMUIKeyboardHelper$KeyboardVisibilityEventListener
 *  com.qmuiteam.qmui.util.QMUIViewHelper
 */
package com.qmuiteam.qmui.util;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.qmuiteam.qmui.util.QMUIDisplayHelper;
import com.qmuiteam.qmui.util.QMUIKeyboardHelper;
import com.qmuiteam.qmui.util.QMUIViewHelper;

public class QMUIKeyboardHelper {
    public static final int KEYBOARD_VISIBLE_THRESHOLD_DP = 100;
    public static final int SHOW_KEYBOARD_DELAY_TIME = 200;
    private static final String TAG = "QMUIKeyboardHelper";

    public static boolean hideKeyboard(View view) {
        if (view != null) return ((InputMethodManager)view.getContext().getApplicationContext().getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 2);
        return false;
    }

    public static boolean isKeyboardVisible(Activity activity) {
        Rect rect = new Rect();
        View view = QMUIViewHelper.getActivityRoot((Activity)activity);
        int n = Math.round(QMUIDisplayHelper.dp2px((Context)activity, (int)100));
        view.getWindowVisibleDisplayFrame(rect);
        boolean bl = view.getRootView().getHeight() - rect.height() > n;
        return bl;
    }

    public static void setVisibilityEventListener(Activity activity, KeyboardVisibilityEventListener keyboardVisibilityEventListener) {
        if (activity == null) throw new NullPointerException("Parameter:activity must not be null");
        if (keyboardVisibilityEventListener == null) throw new NullPointerException("Parameter:listener must not be null");
        View view = QMUIViewHelper.getActivityRoot((Activity)activity);
        keyboardVisibilityEventListener = new /* Unavailable Anonymous Inner Class!! */;
        view.getViewTreeObserver().addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)keyboardVisibilityEventListener);
        activity.getApplication().registerActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)new /* Unavailable Anonymous Inner Class!! */);
    }

    public static void showKeyboard(EditText editText, int n) {
        if (editText == null) {
            return;
        }
        if (!editText.requestFocus()) {
            Log.w((String)TAG, (String)"showSoftInput() can not get focus");
            return;
        }
        if (n > 0) {
            editText.postDelayed((Runnable)new /* Unavailable Anonymous Inner Class!! */, (long)n);
        } else {
            ((InputMethodManager)editText.getContext().getApplicationContext().getSystemService("input_method")).showSoftInput((View)editText, 1);
        }
    }

    public static void showKeyboard(EditText editText, boolean bl) {
        int n = bl ? 200 : 0;
        QMUIKeyboardHelper.showKeyboard(editText, n);
    }
}
