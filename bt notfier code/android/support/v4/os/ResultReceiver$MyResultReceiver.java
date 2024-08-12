/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.support.v4.os.IResultReceiver$Stub
 *  android.support.v4.os.ResultReceiver
 *  android.support.v4.os.ResultReceiver$MyRunnable
 */
package android.support.v4.os;

import android.os.Bundle;
import android.support.v4.os.IResultReceiver;
import android.support.v4.os.ResultReceiver;

class ResultReceiver.MyResultReceiver
extends IResultReceiver.Stub {
    final ResultReceiver this$0;

    ResultReceiver.MyResultReceiver(ResultReceiver resultReceiver) {
        this.this$0 = resultReceiver;
    }

    public void send(int n, Bundle bundle) {
        if (this.this$0.mHandler != null) {
            this.this$0.mHandler.post((Runnable)new ResultReceiver.MyRunnable(this.this$0, n, bundle));
        } else {
            this.this$0.onReceiveResult(n, bundle);
        }
    }
}
