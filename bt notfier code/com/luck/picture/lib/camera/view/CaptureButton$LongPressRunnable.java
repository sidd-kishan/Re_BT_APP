/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.luck.picture.lib.camera.CheckPermission
 *  com.luck.picture.lib.camera.view.CaptureButton
 */
package com.luck.picture.lib.camera.view;

import com.luck.picture.lib.camera.CheckPermission;
import com.luck.picture.lib.camera.view.CaptureButton;

/*
 * Exception performing whole class analysis ignored.
 */
private class CaptureButton.LongPressRunnable
implements Runnable {
    final CaptureButton this$0;

    private CaptureButton.LongPressRunnable(CaptureButton captureButton) {
        this.this$0 = captureButton;
    }

    @Override
    public void run() {
        CaptureButton.access$202((CaptureButton)this.this$0, (int)3);
        if (CheckPermission.getRecordState() != 1) {
            CaptureButton.access$202((CaptureButton)this.this$0, (int)1);
            if (CaptureButton.access$100((CaptureButton)this.this$0) != null) {
                CaptureButton.access$100((CaptureButton)this.this$0).recordError();
                return;
            }
        }
        CaptureButton captureButton = this.this$0;
        CaptureButton.access$900((CaptureButton)captureButton, (float)CaptureButton.access$500((CaptureButton)captureButton), (float)(CaptureButton.access$500((CaptureButton)this.this$0) + (float)CaptureButton.access$600((CaptureButton)this.this$0)), (float)CaptureButton.access$700((CaptureButton)this.this$0), (float)(CaptureButton.access$700((CaptureButton)this.this$0) - (float)CaptureButton.access$800((CaptureButton)this.this$0)));
    }
}
