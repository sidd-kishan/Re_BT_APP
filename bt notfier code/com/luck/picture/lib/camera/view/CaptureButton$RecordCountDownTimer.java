/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.CountDownTimer
 *  com.luck.picture.lib.camera.view.CaptureButton
 */
package com.luck.picture.lib.camera.view;

import android.os.CountDownTimer;
import com.luck.picture.lib.camera.view.CaptureButton;

/*
 * Exception performing whole class analysis ignored.
 */
private class CaptureButton.RecordCountDownTimer
extends CountDownTimer {
    final CaptureButton this$0;

    CaptureButton.RecordCountDownTimer(CaptureButton captureButton, long l, long l2) {
        this.this$0 = captureButton;
        super(l, l2);
    }

    public void onFinish() {
        this.this$0.recordEnd();
    }

    public void onTick(long l) {
        CaptureButton.access$400((CaptureButton)this.this$0, (long)l);
    }
}
