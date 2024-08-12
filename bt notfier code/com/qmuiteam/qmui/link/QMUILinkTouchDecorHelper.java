/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.text.Selection
 *  android.text.Spannable
 *  android.view.MotionEvent
 *  android.view.View
 *  android.widget.TextView
 *  com.qmuiteam.qmui.link.ITouchableSpan
 *  com.qmuiteam.qmui.widget.textview.ISpanTouchFix
 */
package com.qmuiteam.qmui.link;

import android.text.Selection;
import android.text.Spannable;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.qmuiteam.qmui.link.ITouchableSpan;
import com.qmuiteam.qmui.widget.textview.ISpanTouchFix;

public class QMUILinkTouchDecorHelper {
    private ITouchableSpan mPressedSpan;

    public ITouchableSpan getPressedSpan(TextView textView, Spannable iTouchableSpanArray, MotionEvent motionEvent) {
        block3: {
            int n = (int)motionEvent.getX();
            int n2 = (int)motionEvent.getY();
            int n3 = textView.getTotalPaddingLeft();
            int n4 = textView.getTotalPaddingTop();
            int n5 = textView.getScrollX();
            int n6 = textView.getScrollY();
            textView = textView.getLayout();
            n2 = textView.getLineForVertical(n2 - n4 + n6);
            float f = n - n3 + n5;
            motionEvent = null;
            try {
                n = textView.getOffsetForHorizontal(n2, f);
                if (f < textView.getLineLeft(n2) || f > textView.getLineRight(n2)) {
                    n = -1;
                }
                iTouchableSpanArray = (ITouchableSpan[])iTouchableSpanArray.getSpans(n, n, ITouchableSpan.class);
                textView = motionEvent;
                if (iTouchableSpanArray.length <= 0) return textView;
            }
            catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                textView = motionEvent;
                break block3;
            }
            textView = iTouchableSpanArray[0];
        }
        return textView;
    }

    public boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        int n = motionEvent.getAction();
        boolean bl = true;
        boolean bl2 = true;
        boolean bl3 = true;
        if (n == 0) {
            motionEvent = this.getPressedSpan(textView, spannable, motionEvent);
            this.mPressedSpan = motionEvent;
            if (motionEvent != null) {
                motionEvent.setPressed(true);
                Selection.setSelection((Spannable)spannable, (int)spannable.getSpanStart((Object)this.mPressedSpan), (int)spannable.getSpanEnd((Object)this.mPressedSpan));
            }
            if (textView instanceof ISpanTouchFix) {
                textView = (ISpanTouchFix)textView;
                bl2 = this.mPressedSpan != null;
                textView.setTouchSpanHit(bl2);
            }
            bl2 = this.mPressedSpan != null ? bl3 : false;
            return bl2;
        }
        if (motionEvent.getAction() == 2) {
            ITouchableSpan iTouchableSpan = this.getPressedSpan(textView, spannable, motionEvent);
            motionEvent = this.mPressedSpan;
            if (motionEvent != null && iTouchableSpan != motionEvent) {
                motionEvent.setPressed(false);
                this.mPressedSpan = null;
                Selection.removeSelection((Spannable)spannable);
            }
            if (textView instanceof ISpanTouchFix) {
                textView = (ISpanTouchFix)textView;
                bl2 = this.mPressedSpan != null;
                textView.setTouchSpanHit(bl2);
            }
            bl2 = this.mPressedSpan != null ? bl : false;
            return bl2;
        }
        if (motionEvent.getAction() == 1) {
            motionEvent = this.mPressedSpan;
            if (motionEvent != null) {
                motionEvent.setPressed(false);
                this.mPressedSpan.onClick((View)textView);
            } else {
                bl2 = false;
            }
            this.mPressedSpan = null;
            Selection.removeSelection((Spannable)spannable);
            if (!(textView instanceof ISpanTouchFix)) return bl2;
            ((ISpanTouchFix)textView).setTouchSpanHit(bl2);
            return bl2;
        }
        motionEvent = this.mPressedSpan;
        if (motionEvent != null) {
            motionEvent.setPressed(false);
        }
        if (textView instanceof ISpanTouchFix) {
            ((ISpanTouchFix)textView).setTouchSpanHit(false);
        }
        Selection.removeSelection((Spannable)spannable);
        return false;
    }
}
