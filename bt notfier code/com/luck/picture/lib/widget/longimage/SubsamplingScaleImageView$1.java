/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Handler$Callback
 *  android.os.Message
 *  android.view.View$OnLongClickListener
 *  com.luck.picture.lib.widget.longimage.SubsamplingScaleImageView
 */
package com.luck.picture.lib.widget.longimage;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import com.luck.picture.lib.widget.longimage.SubsamplingScaleImageView;

/*
 * Exception performing whole class analysis ignored.
 */
class SubsamplingScaleImageView.1
implements Handler.Callback {
    final SubsamplingScaleImageView this$0;

    SubsamplingScaleImageView.1(SubsamplingScaleImageView subsamplingScaleImageView) {
        this.this$0 = subsamplingScaleImageView;
    }

    public boolean handleMessage(Message message) {
        if (message.what != 1) return true;
        if (SubsamplingScaleImageView.access$000((SubsamplingScaleImageView)this.this$0) == null) return true;
        SubsamplingScaleImageView.access$102((SubsamplingScaleImageView)this.this$0, (int)0);
        message = this.this$0;
        SubsamplingScaleImageView.access$201((SubsamplingScaleImageView)message, (View.OnLongClickListener)SubsamplingScaleImageView.access$000((SubsamplingScaleImageView)message));
        this.this$0.performLongClick();
        SubsamplingScaleImageView.access$301((SubsamplingScaleImageView)this.this$0, null);
        return true;
    }
}
