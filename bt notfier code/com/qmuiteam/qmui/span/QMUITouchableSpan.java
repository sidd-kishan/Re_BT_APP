/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.text.TextPaint
 *  android.text.style.ClickableSpan
 *  android.view.View
 *  androidx.core.view.ViewCompat
 *  com.qmuiteam.qmui.link.ITouchableSpan
 */
package com.qmuiteam.qmui.span;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import androidx.core.view.ViewCompat;
import com.qmuiteam.qmui.link.ITouchableSpan;

public abstract class QMUITouchableSpan
extends ClickableSpan
implements ITouchableSpan {
    private boolean mIsNeedUnderline = false;
    private boolean mIsPressed;
    private int mNormalBackgroundColor;
    private int mNormalTextColor;
    private int mPressedBackgroundColor;
    private int mPressedTextColor;

    public QMUITouchableSpan(int n, int n2, int n3, int n4) {
        this.mNormalTextColor = n;
        this.mPressedTextColor = n2;
        this.mNormalBackgroundColor = n3;
        this.mPressedBackgroundColor = n4;
    }

    public int getNormalBackgroundColor() {
        return this.mNormalBackgroundColor;
    }

    public int getNormalTextColor() {
        return this.mNormalTextColor;
    }

    public int getPressedBackgroundColor() {
        return this.mPressedBackgroundColor;
    }

    public int getPressedTextColor() {
        return this.mPressedTextColor;
    }

    public boolean isPressed() {
        return this.mIsPressed;
    }

    public final void onClick(View view) {
        if (!ViewCompat.isAttachedToWindow((View)view)) return;
        this.onSpanClick(view);
    }

    public abstract void onSpanClick(View var1);

    public void setIsNeedUnderline(boolean bl) {
        this.mIsNeedUnderline = bl;
    }

    public void setNormalTextColor(int n) {
        this.mNormalTextColor = n;
    }

    public void setPressed(boolean bl) {
        this.mIsPressed = bl;
    }

    public void setPressedTextColor(int n) {
        this.mPressedTextColor = n;
    }

    public void updateDrawState(TextPaint textPaint) {
        int n = this.mIsPressed ? this.mPressedTextColor : this.mNormalTextColor;
        textPaint.setColor(n);
        n = this.mIsPressed ? this.mPressedBackgroundColor : this.mNormalBackgroundColor;
        textPaint.bgColor = n;
        textPaint.setUnderlineText(this.mIsNeedUnderline);
    }
}
