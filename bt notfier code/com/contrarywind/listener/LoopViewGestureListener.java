/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.GestureDetector$SimpleOnGestureListener
 *  android.view.MotionEvent
 *  com.contrarywind.view.WheelView
 */
package com.contrarywind.listener;

import android.view.GestureDetector;
import android.view.MotionEvent;
import com.contrarywind.view.WheelView;

public final class LoopViewGestureListener
extends GestureDetector.SimpleOnGestureListener {
    private final WheelView wheelView;

    public LoopViewGestureListener(WheelView wheelView) {
        this.wheelView = wheelView;
    }

    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        this.wheelView.scrollBy(f2);
        return true;
    }
}
