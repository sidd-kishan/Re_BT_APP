/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$OnTouchListener
 *  androidx.appcompat.widget.ListPopupWindow
 */
package androidx.appcompat.widget;

import android.view.MotionEvent;
import android.view.View;
import androidx.appcompat.widget.ListPopupWindow;

private class ListPopupWindow.PopupTouchInterceptor
implements View.OnTouchListener {
    final ListPopupWindow this$0;

    ListPopupWindow.PopupTouchInterceptor(ListPopupWindow listPopupWindow) {
        this.this$0 = listPopupWindow;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        int n = motionEvent.getAction();
        int n2 = (int)motionEvent.getX();
        int n3 = (int)motionEvent.getY();
        if (n == 0 && this.this$0.mPopup != null && this.this$0.mPopup.isShowing() && n2 >= 0 && n2 < this.this$0.mPopup.getWidth() && n3 >= 0 && n3 < this.this$0.mPopup.getHeight()) {
            this.this$0.mHandler.postDelayed((Runnable)this.this$0.mResizePopupRunnable, 250L);
        } else {
            if (n != 1) return false;
            this.this$0.mHandler.removeCallbacks((Runnable)this.this$0.mResizePopupRunnable);
        }
        return false;
    }
}
