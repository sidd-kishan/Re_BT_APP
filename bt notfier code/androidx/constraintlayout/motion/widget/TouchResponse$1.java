/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$OnTouchListener
 *  androidx.constraintlayout.motion.widget.TouchResponse
 */
package androidx.constraintlayout.motion.widget;

import android.view.MotionEvent;
import android.view.View;
import androidx.constraintlayout.motion.widget.TouchResponse;

class TouchResponse.1
implements View.OnTouchListener {
    final TouchResponse this$0;

    TouchResponse.1(TouchResponse touchResponse) {
        this.this$0 = touchResponse;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        return false;
    }
}
