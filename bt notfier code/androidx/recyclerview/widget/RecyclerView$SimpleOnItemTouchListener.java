/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.MotionEvent
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$OnItemTouchListener
 */
package androidx.recyclerview.widget;

import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;

public static class RecyclerView.SimpleOnItemTouchListener
implements RecyclerView.OnItemTouchListener {
    public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        return false;
    }

    public void onRequestDisallowInterceptTouchEvent(boolean bl) {
    }

    public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
    }
}
