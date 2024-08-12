/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 *  android.util.DisplayMetrics
 *  androidx.appcompat.widget.AppCompatImageView
 *  androidx.core.content.ContextCompat
 *  androidx.swiperefreshlayout.widget.CircularProgressDrawable
 *  com.qmuiteam.qmui.R$attr
 *  com.qmuiteam.qmui.util.QMUIResHelper
 *  com.qmuiteam.qmui.widget.pullRefreshLayout.QMUIPullRefreshLayout$IRefreshView
 */
package com.qmuiteam.qmui.widget.pullRefreshLayout;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import androidx.swiperefreshlayout.widget.CircularProgressDrawable;
import com.qmuiteam.qmui.R;
import com.qmuiteam.qmui.util.QMUIResHelper;
import com.qmuiteam.qmui.widget.pullRefreshLayout.QMUIPullRefreshLayout;

public static class QMUIPullRefreshLayout.RefreshView
extends AppCompatImageView
implements QMUIPullRefreshLayout.IRefreshView {
    static final int CIRCLE_DIAMETER = 40;
    static final int CIRCLE_DIAMETER_LARGE = 56;
    private static final int MAX_ALPHA = 255;
    private static final float TRIM_OFFSET = 0.4f;
    private static final float TRIM_RATE = 0.85f;
    private int mCircleDiameter;
    private CircularProgressDrawable mProgress;

    public QMUIPullRefreshLayout.RefreshView(Context context) {
        super(context);
        this.mProgress = new CircularProgressDrawable(context);
        this.setColorSchemeColors(QMUIResHelper.getAttrColor((Context)context, (int)R.attr.qmui_config_color_blue));
        this.mProgress.setStyle(0);
        this.mProgress.setAlpha(255);
        this.mProgress.setArrowScale(0.8f);
        this.setImageDrawable((Drawable)this.mProgress);
        this.mCircleDiameter = (int)(this.getResources().getDisplayMetrics().density * 40.0f);
    }

    public void doRefresh() {
        this.mProgress.start();
    }

    protected void onMeasure(int n, int n2) {
        n = this.mCircleDiameter;
        this.setMeasuredDimension(n, n);
    }

    public void onPull(int n, int n2, int n3) {
        float f;
        if (this.mProgress.isRunning()) {
            return;
        }
        float f2 = n;
        float f3 = n2;
        float f4 = 0.85f * f2 / f3;
        f2 = f = f2 * 0.4f / f3;
        if (n3 > 0) {
            f2 = f + (float)n3 * 0.4f / f3;
        }
        this.mProgress.setArrowEnabled(true);
        this.mProgress.setStartEndTrim(0.0f, f4);
        this.mProgress.setProgressRotation(f2);
    }

    public void setColorSchemeColors(int ... nArray) {
        this.mProgress.setColorSchemeColors(nArray);
    }

    public void setColorSchemeResources(int ... nArray) {
        Context context = this.getContext();
        int[] nArray2 = new int[nArray.length];
        int n = 0;
        while (true) {
            if (n >= nArray.length) {
                this.setColorSchemeColors(nArray2);
                return;
            }
            nArray2[n] = ContextCompat.getColor((Context)context, (int)nArray[n]);
            ++n;
        }
    }

    public void setSize(int n) {
        if (n != 0 && n != 1) {
            return;
        }
        DisplayMetrics displayMetrics = this.getResources().getDisplayMetrics();
        this.mCircleDiameter = n == 0 ? (int)(displayMetrics.density * 56.0f) : (int)(displayMetrics.density * 40.0f);
        this.setImageDrawable(null);
        this.mProgress.setStyle(n);
        this.setImageDrawable((Drawable)this.mProgress);
    }

    public void stop() {
        this.mProgress.stop();
    }
}
