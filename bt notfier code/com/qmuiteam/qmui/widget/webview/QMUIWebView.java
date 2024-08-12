/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Rect
 *  android.util.Log
 *  android.view.KeyEvent
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.WindowInsets
 *  android.webkit.WebView
 *  android.webkit.WebViewClient
 *  androidx.core.view.ViewCompat
 *  androidx.core.view.WindowInsetsCompat
 *  com.qmuiteam.qmui.util.QMUIDisplayHelper
 *  com.qmuiteam.qmui.util.QMUINotchHelper
 *  com.qmuiteam.qmui.util.QMUIWindowInsetHelper
 *  com.qmuiteam.qmui.widget.IWindowInsetLayout
 *  com.qmuiteam.qmui.widget.webview.QMUIWebView$Callback
 *  com.qmuiteam.qmui.widget.webview.QMUIWebView$OnScrollChangeListener
 *  com.qmuiteam.qmui.widget.webview.QMUIWebViewClient
 */
package com.qmuiteam.qmui.widget.webview;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.qmuiteam.qmui.util.QMUIDisplayHelper;
import com.qmuiteam.qmui.util.QMUINotchHelper;
import com.qmuiteam.qmui.util.QMUIWindowInsetHelper;
import com.qmuiteam.qmui.widget.IWindowInsetLayout;
import com.qmuiteam.qmui.widget.webview.QMUIWebView;
import com.qmuiteam.qmui.widget.webview.QMUIWebViewClient;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class QMUIWebView
extends WebView
implements IWindowInsetLayout {
    private static final String TAG = "QMUIWebView";
    private static boolean sIsReflectionOccurError;
    private Object mAwContents;
    private Callback mCallback;
    private boolean mNeedDispatchSafeAreaInset = false;
    private List<OnScrollChangeListener> mOnScrollChangeListeners = new ArrayList<OnScrollChangeListener>();
    private Rect mSafeAreaRectCache;
    private Method mSetDisplayCutoutSafeAreaMethod;
    private Object mWebContents;
    private QMUIWindowInsetHelper mWindowInsetHelper;

    public QMUIWebView(Context context) {
        super(context);
        this.init();
    }

    public QMUIWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.init();
    }

    public QMUIWebView(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
        this.init();
    }

    private void doNotSupportChangeCssEnv() {
        sIsReflectionOccurError = true;
        Callback callback = this.mCallback;
        if (callback == null) return;
        callback.onSureNotSupportChangeCssEnv();
    }

    private Object getAwContentsFieldValueInProvider(Object object) throws IllegalAccessException, NoSuchFieldException {
        Object object2;
        try {
            object2 = object.getClass().getDeclaredField("mAwContents");
            if (object2 != null) {
                object2.setAccessible(true);
                object2 = object2.get(object);
                return object2;
            }
        }
        catch (NoSuchFieldException noSuchFieldException) {}
        object2 = object.getClass().getDeclaredFields();
        int n = ((Field[])object2).length;
        int n2 = 0;
        while (n2 < n) {
            Object object3 = object2[n2];
            ((AccessibleObject)object3).setAccessible(true);
            object3 = ((Field)object3).get(object);
            if (object3 != null && object3.getClass().getSimpleName().equals("AwContents")) {
                return object3;
            }
            ++n2;
        }
        return null;
    }

    private Method getSetDisplayCutoutSafeAreaMethodInWebContents(Object object) {
        Object object2;
        try {
            object2 = object.getClass().getDeclaredMethod("setDisplayCutoutSafeArea", Rect.class);
            if (object2 != null) {
                return object2;
            }
        }
        catch (NoSuchMethodException noSuchMethodException) {}
        object2 = object.getClass().getDeclaredMethods();
        int n = ((Method[])object2).length;
        int n2 = 0;
        while (n2 < n) {
            object = object2[n2];
            if (((Method)object).getReturnType() == Void.TYPE && ((Method)object).getParameterTypes().length == 1 && ((Method)object).getParameterTypes()[0] == Rect.class) {
                return object;
            }
            ++n2;
        }
        return null;
    }

    private Object getWebContentsFieldValueInAwContents(Object object) throws IllegalAccessException {
        Object object2;
        try {
            object2 = object.getClass().getDeclaredField("mWebContents");
            if (object2 != null) {
                object2.setAccessible(true);
                object2 = object2.get(object);
                return object2;
            }
        }
        catch (NoSuchFieldException noSuchFieldException) {}
        object2 = object.getClass().getDeclaredFields();
        int n = ((Field[])object2).length;
        int n2 = 0;
        while (n2 < n) {
            Object object3 = object2[n2];
            ((AccessibleObject)object3).setAccessible(true);
            object3 = ((Field)object3).get(object);
            if (object3 != null && object3.getClass().getSimpleName().equals("WebContentsImpl")) {
                return object3;
            }
            ++n2;
        }
        return null;
    }

    private void init() {
        this.removeJavascriptInterface("searchBoxJavaBridge_");
        this.removeJavascriptInterface("accessibility");
        this.removeJavascriptInterface("accessibilityTraversal");
        this.mWindowInsetHelper = new QMUIWindowInsetHelper((ViewGroup)this, (IWindowInsetLayout)this);
    }

    private void setStyleDisplayCutoutSafeArea(Rect object) {
        if (sIsReflectionOccurError) {
            return;
        }
        Object object2 = this.mSafeAreaRectCache;
        if (object == object2) {
            return;
        }
        if (object2 == null) {
            this.mSafeAreaRectCache = new Rect((Rect)object);
        } else {
            object2.set((Rect)object);
        }
        long l = System.currentTimeMillis();
        if (this.mAwContents == null || this.mWebContents == null || this.mSetDisplayCutoutSafeAreaMethod == null) {
            try {
                object2 = WebView.class.getDeclaredField("mProvider");
                ((AccessibleObject)object2).setAccessible(true);
                this.mAwContents = object2 = this.getAwContentsFieldValueInProvider(((Field)object2).get((Object)this));
                if (object2 == null) {
                    return;
                }
                this.mWebContents = object2 = this.getWebContentsFieldValueInAwContents(object2);
                if (object2 == null) {
                    return;
                }
                this.mSetDisplayCutoutSafeAreaMethod = object2 = this.getSetDisplayCutoutSafeAreaMethodInWebContents(object2);
                if (object2 == null) {
                    this.doNotSupportChangeCssEnv();
                    return;
                }
            }
            catch (Exception exception) {
                this.doNotSupportChangeCssEnv();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("setStyleDisplayCutoutSafeArea error: ");
                stringBuilder.append(exception);
                Log.i((String)TAG, (String)stringBuilder.toString());
            }
        }
        try {
            this.mSetDisplayCutoutSafeAreaMethod.setAccessible(true);
            this.mSetDisplayCutoutSafeAreaMethod.invoke(this.mWebContents, object);
        }
        catch (Exception exception) {
            sIsReflectionOccurError = true;
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("setStyleDisplayCutoutSafeArea error: ");
            ((StringBuilder)object2).append(exception);
            Log.i((String)TAG, (String)((StringBuilder)object2).toString());
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("setDisplayCutoutSafeArea speed time: ");
        ((StringBuilder)object).append(System.currentTimeMillis() - l);
        Log.i((String)TAG, (String)((StringBuilder)object).toString());
    }

    public void addCustomOnScrollChangeListener(OnScrollChangeListener onScrollChangeListener) {
        if (this.mOnScrollChangeListeners.contains(onScrollChangeListener)) return;
        this.mOnScrollChangeListeners.add(onScrollChangeListener);
    }

    public void addJavascriptInterface(Object object, String string) {
    }

    public boolean applySystemWindowInsets19(Rect rect) {
        return false;
    }

    public boolean applySystemWindowInsets21(Object object) {
        int n;
        int n2;
        int n3;
        int n4;
        if (!this.mNeedDispatchSafeAreaInset) {
            return false;
        }
        float f = QMUIDisplayHelper.getDensity((Context)this.getContext());
        if (QMUINotchHelper.isNotchOfficialSupport()) {
            object = (WindowInsets)object;
            n4 = object.getSystemWindowInsetLeft();
            n3 = object.getSystemWindowInsetTop();
            n2 = object.getSystemWindowInsetRight();
            n = object.getSystemWindowInsetBottom();
        } else {
            object = (WindowInsetsCompat)object;
            n4 = object.getSystemWindowInsetLeft();
            n3 = object.getSystemWindowInsetTop();
            n2 = object.getSystemWindowInsetRight();
            n = object.getSystemWindowInsetBottom();
        }
        this.setStyleDisplayCutoutSafeArea(new Rect((int)((float)n4 / f + (float)this.getExtraInsetLeft(f)), (int)((float)n3 / f + (float)this.getExtraInsetTop(f)), (int)((float)n2 / f + (float)this.getExtraInsetRight(f)), (int)((float)n / f + (float)this.getExtraInsetBottom(f))));
        return true;
    }

    public void destroy() {
        this.mAwContents = null;
        this.mWebContents = null;
        this.mSetDisplayCutoutSafeAreaMethod = null;
        this.stopLoading();
        super.destroy();
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    protected int getExtraInsetBottom(float f) {
        return 0;
    }

    protected int getExtraInsetLeft(float f) {
        return 0;
    }

    protected int getExtraInsetRight(float f) {
        return 0;
    }

    protected int getExtraInsetTop(float f) {
        return 0;
    }

    public boolean isNeedDispatchSafeAreaInset() {
        return this.mNeedDispatchSafeAreaInset;
    }

    boolean isNotSupportChangeCssEnv() {
        return sIsReflectionOccurError;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewCompat.requestApplyInsets((View)this);
    }

    protected void onScrollChanged(int n, int n2, int n3, int n4) {
        super.onScrollChanged(n, n2, n3, n4);
        Iterator<OnScrollChangeListener> iterator = this.mOnScrollChangeListeners.iterator();
        while (iterator.hasNext()) {
            iterator.next().onScrollChange((WebView)this, n, n2, n3, n4);
        }
    }

    public void removeAllOnScrollChangeListener() {
        this.mOnScrollChangeListeners.clear();
    }

    public void removeOnScrollChangeListener(OnScrollChangeListener onScrollChangeListener) {
        this.mOnScrollChangeListeners.remove(onScrollChangeListener);
    }

    public void setCallback(Callback callback) {
        this.mCallback = callback;
    }

    @Deprecated
    public void setCustomOnScrollChangeListener(OnScrollChangeListener onScrollChangeListener) {
        this.addCustomOnScrollChangeListener(onScrollChangeListener);
    }

    public void setNeedDispatchSafeAreaInset(boolean bl) {
        if (this.mNeedDispatchSafeAreaInset == bl) return;
        this.mNeedDispatchSafeAreaInset = bl;
        if (!ViewCompat.isAttachedToWindow((View)this)) return;
        if (bl) {
            ViewCompat.requestApplyInsets((View)this);
        } else {
            this.setStyleDisplayCutoutSafeArea(new Rect());
        }
    }

    public void setWebViewClient(WebViewClient webViewClient) {
        if (webViewClient != null) {
            if (!(webViewClient instanceof QMUIWebViewClient)) throw new IllegalArgumentException("must use the instance of QMUIWebViewClient");
        }
        super.setWebViewClient(webViewClient);
    }
}
