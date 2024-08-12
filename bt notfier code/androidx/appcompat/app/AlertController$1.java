/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Message
 *  android.view.View
 *  android.view.View$OnClickListener
 *  androidx.appcompat.app.AlertController
 */
package androidx.appcompat.app;

import android.os.Message;
import android.view.View;
import androidx.appcompat.app.AlertController;

class AlertController.1
implements View.OnClickListener {
    final AlertController this$0;

    AlertController.1(AlertController alertController) {
        this.this$0 = alertController;
    }

    public void onClick(View object) {
        if ((object = object == this.this$0.mButtonPositive && this.this$0.mButtonPositiveMessage != null ? Message.obtain((Message)this.this$0.mButtonPositiveMessage) : (object == this.this$0.mButtonNegative && this.this$0.mButtonNegativeMessage != null ? Message.obtain((Message)this.this$0.mButtonNegativeMessage) : (object == this.this$0.mButtonNeutral && this.this$0.mButtonNeutralMessage != null ? Message.obtain((Message)this.this$0.mButtonNeutralMessage) : null))) != null) {
            object.sendToTarget();
        }
        this.this$0.mHandler.obtainMessage(1, (Object)this.this$0.mDialog).sendToTarget();
    }
}
