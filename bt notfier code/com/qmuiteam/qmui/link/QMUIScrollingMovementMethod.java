/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.text.Spannable
 *  android.text.method.MovementMethod
 *  android.text.method.ScrollingMovementMethod
 *  android.text.method.Touch
 *  android.view.MotionEvent
 *  android.widget.TextView
 *  com.qmuiteam.qmui.link.QMUILinkTouchDecorHelper
 */
package com.qmuiteam.qmui.link;

import android.text.Spannable;
import android.text.method.MovementMethod;
import android.text.method.ScrollingMovementMethod;
import android.text.method.Touch;
import android.view.MotionEvent;
import android.widget.TextView;
import com.qmuiteam.qmui.link.QMUILinkTouchDecorHelper;

public class QMUIScrollingMovementMethod
extends ScrollingMovementMethod {
    private static QMUILinkTouchDecorHelper sHelper = new QMUILinkTouchDecorHelper();
    private static QMUIScrollingMovementMethod sInstance;

    public static MovementMethod getInstance() {
        if (sInstance != null) return sInstance;
        sInstance = new QMUIScrollingMovementMethod();
        return sInstance;
    }

    public boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        boolean bl = sHelper.onTouchEvent(textView, spannable, motionEvent) || Touch.onTouchEvent((TextView)textView, (Spannable)spannable, (MotionEvent)motionEvent);
        return bl;
    }
}
