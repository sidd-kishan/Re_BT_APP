/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$OnTouchListener
 *  androidx.core.view.DragStartHelper
 */
package androidx.core.view;

import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.DragStartHelper;

class DragStartHelper.2
implements View.OnTouchListener {
    final DragStartHelper this$0;

    DragStartHelper.2(DragStartHelper dragStartHelper) {
        this.this$0 = dragStartHelper;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        return this.this$0.onTouch(view, motionEvent);
    }
}
