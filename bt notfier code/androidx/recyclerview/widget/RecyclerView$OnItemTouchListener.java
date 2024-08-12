/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.MotionEvent
 *  androidx.recyclerview.widget.RecyclerView
 */
package androidx.recyclerview.widget;

import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;

public static interface RecyclerView.OnItemTouchListener {
    public boolean onInterceptTouchEvent(RecyclerView var1, MotionEvent var2);

    public void onRequestDisallowInterceptTouchEvent(boolean var1);

    public void onTouchEvent(RecyclerView var1, MotionEvent var2);
}
