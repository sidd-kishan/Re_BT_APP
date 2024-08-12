/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Configuration
 *  android.graphics.Point
 *  android.graphics.drawable.ColorDrawable
 *  android.graphics.drawable.Drawable
 *  android.os.Build$VERSION
 *  android.util.Log
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.View$OnAttachStateChangeListener
 *  android.view.View$OnTouchListener
 *  android.view.ViewGroup$LayoutParams
 *  android.view.WindowManager
 *  android.view.WindowManager$LayoutParams
 *  android.widget.PopupWindow
 *  android.widget.PopupWindow$OnDismissListener
 *  androidx.core.view.ViewCompat
 *  com.qmuiteam.qmui.util.QMUIDisplayHelper
 *  com.qmuiteam.qmui.widget.popup.QMUIBasePopup$RootView
 */
package com.qmuiteam.qmui.widget.popup;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.PopupWindow;
import androidx.core.view.ViewCompat;
import com.qmuiteam.qmui.util.QMUIDisplayHelper;
import com.qmuiteam.qmui.widget.popup.QMUIBasePopup;

public abstract class QMUIBasePopup {
    private static final String TAG = "QMUIBasePopup";
    protected Drawable mBackground = null;
    protected Context mContext;
    private PopupWindow.OnDismissListener mDismissListener;
    private View mParentViewForShow;
    protected View mRootView;
    private RootView mRootViewWrapper;
    protected Point mScreenSize = new Point();
    protected PopupWindow mWindow;
    protected int mWindowHeight = 0;
    protected WindowManager mWindowManager;
    protected int mWindowWidth = 0;

    public QMUIBasePopup(Context context) {
        PopupWindow popupWindow;
        this.mContext = context;
        this.mWindow = popupWindow = new PopupWindow(context);
        popupWindow.setTouchInterceptor((View.OnTouchListener)new /* Unavailable Anonymous Inner Class!! */);
        this.mWindowManager = (WindowManager)context.getSystemService("window");
    }

    static /* synthetic */ PopupWindow.OnDismissListener access$000(QMUIBasePopup qMUIBasePopup) {
        return qMUIBasePopup.mDismissListener;
    }

    public void dimBehind(float f) {
        if (!this.isShowing()) throw new RuntimeException("should call after method show() or in onShowEnd()");
        View view = this.getDecorView();
        if (view == null) return;
        WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams)view.getLayoutParams();
        layoutParams.flags |= 2;
        layoutParams.dimAmount = f;
        this.mWindowManager.updateViewLayout(view, (ViewGroup.LayoutParams)layoutParams);
    }

    public void dismiss() {
        this.mWindow.dismiss();
    }

    public View getDecorView() {
        View view;
        try {
            view = this.mWindow.getBackground() == null ? (Build.VERSION.SDK_INT >= 23 ? (View)this.mWindow.getContentView().getParent() : this.mWindow.getContentView()) : (Build.VERSION.SDK_INT >= 23 ? (View)this.mWindow.getContentView().getParent().getParent() : (View)this.mWindow.getContentView().getParent());
        }
        catch (Exception exception) {
            view = null;
        }
        return view;
    }

    public View getParentViewForShow() {
        return this.mParentViewForShow;
    }

    public boolean isShowing() {
        PopupWindow popupWindow = this.mWindow;
        boolean bl = popupWindow != null && popupWindow.isShowing();
        return bl;
    }

    protected int makeHeightMeasureSpec(View view) {
        return View.MeasureSpec.makeMeasureSpec((int)QMUIDisplayHelper.getScreenHeight((Context)this.mContext), (int)Integer.MIN_VALUE);
    }

    protected int makeWidthMeasureSpec(View view) {
        return View.MeasureSpec.makeMeasureSpec((int)QMUIDisplayHelper.getScreenWidth((Context)this.mContext), (int)Integer.MIN_VALUE);
    }

    protected void measureWindowSize() {
        int n = this.makeWidthMeasureSpec((View)this.mRootViewWrapper);
        int n2 = this.makeHeightMeasureSpec((View)this.mRootViewWrapper);
        this.mRootView.measure(n, n2);
        this.mWindowWidth = this.mRootView.getMeasuredWidth();
        this.mWindowHeight = this.mRootView.getMeasuredHeight();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("measureWindowSize: mWindowWidth = ");
        stringBuilder.append(this.mWindowWidth);
        stringBuilder.append(" ;mWindowHeight = ");
        stringBuilder.append(this.mWindowHeight);
        Log.i((String)TAG, (String)stringBuilder.toString());
    }

    protected void onConfigurationChanged(Configuration configuration) {
    }

    protected void onDismiss() {
    }

    protected abstract Point onShowBegin(View var1, View var2);

    protected void onShowConfig() {
        if (this.mRootViewWrapper == null) throw new IllegalStateException("setContentView was not called with a view to display.");
        Drawable drawable = this.mBackground;
        if (drawable == null) {
            this.mWindow.setBackgroundDrawable((Drawable)new ColorDrawable(0));
        } else {
            this.mWindow.setBackgroundDrawable(drawable);
        }
        this.mWindow.setTouchable(true);
        this.mWindow.setFocusable(true);
        this.mWindow.setOutsideTouchable(true);
        this.mWindow.setContentView((View)this.mRootViewWrapper);
        this.mWindowManager.getDefaultDisplay().getSize(this.mScreenSize);
    }

    protected void onShowEnd() {
    }

    protected abstract void onWindowSizeChange();

    public void setBackgroundDrawable(Drawable drawable) {
        this.mBackground = drawable;
    }

    public void setContentView(int n) {
        this.setContentView(((LayoutInflater)this.mContext.getSystemService("layout_inflater")).inflate(n, null));
    }

    public void setContentView(View view) {
        RootView rootView;
        if (view == null) throw new IllegalStateException("setContentView was not called with a view to display.");
        this.mRootViewWrapper = rootView = new RootView(this, this.mContext);
        rootView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        this.mRootView = view;
        this.mRootViewWrapper.addView(view);
        this.mWindow.setContentView((View)this.mRootViewWrapper);
        this.mWindow.setOnDismissListener((PopupWindow.OnDismissListener)new /* Unavailable Anonymous Inner Class!! */);
    }

    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.mDismissListener = onDismissListener;
    }

    protected boolean shouldForceReMeasure() {
        return false;
    }

    public final void show(View view) {
        this.show(view, view);
    }

    public final void show(View view, View view2) {
        if (!ViewCompat.isAttachedToWindow((View)view2)) {
            return;
        }
        this.onShowConfig();
        if (this.mWindowWidth == 0 || this.mWindowHeight == 0 || this.mRootViewWrapper.isLayoutRequested() || this.shouldForceReMeasure()) {
            this.measureWindowSize();
        }
        this.mWindow.setWidth(this.mWindowWidth);
        this.mWindow.setHeight(this.mWindowHeight);
        if (Build.VERSION.SDK_INT >= 22) {
            this.mWindow.setAttachedInDecor(false);
        }
        view2 = this.onShowBegin(view, view2);
        this.mWindow.showAtLocation(view, 0, view2.x, view2.y);
        this.mParentViewForShow = view;
        this.onShowEnd();
        view.addOnAttachStateChangeListener((View.OnAttachStateChangeListener)new /* Unavailable Anonymous Inner Class!! */);
    }
}
