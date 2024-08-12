/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Message
 *  androidx.core.view.GestureDetectorCompat$GestureDetectorCompatImplBase
 */
package androidx.core.view;

import android.os.Handler;
import android.os.Message;
import androidx.core.view.GestureDetectorCompat;

private class GestureDetectorCompat.GestureDetectorCompatImplBase.GestureHandler
extends Handler {
    final GestureDetectorCompat.GestureDetectorCompatImplBase this$0;

    GestureDetectorCompat.GestureDetectorCompatImplBase.GestureHandler(GestureDetectorCompat.GestureDetectorCompatImplBase gestureDetectorCompatImplBase) {
        this.this$0 = gestureDetectorCompatImplBase;
    }

    GestureDetectorCompat.GestureDetectorCompatImplBase.GestureHandler(GestureDetectorCompat.GestureDetectorCompatImplBase gestureDetectorCompatImplBase, Handler handler) {
        this.this$0 = gestureDetectorCompatImplBase;
        super(handler.getLooper());
    }

    public void handleMessage(Message message) {
        int n = message.what;
        if (n != 1) {
            if (n != 2) {
                if (n != 3) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Unknown message ");
                    stringBuilder.append(message);
                    throw new RuntimeException(stringBuilder.toString());
                }
                if (this.this$0.mDoubleTapListener == null) return;
                if (!this.this$0.mStillDown) {
                    this.this$0.mDoubleTapListener.onSingleTapConfirmed(this.this$0.mCurrentDownEvent);
                } else {
                    this.this$0.mDeferConfirmSingleTap = true;
                }
            } else {
                this.this$0.dispatchLongPress();
            }
        } else {
            this.this$0.mListener.onShowPress(this.this$0.mCurrentDownEvent);
        }
    }
}
