/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.support.v4.os.ResultReceiver
 */
package android.support.v4.os;

import android.os.Bundle;
import android.support.v4.os.ResultReceiver;

class ResultReceiver.MyRunnable
implements Runnable {
    final int mResultCode;
    final Bundle mResultData;
    final ResultReceiver this$0;

    ResultReceiver.MyRunnable(ResultReceiver resultReceiver, int n, Bundle bundle) {
        this.this$0 = resultReceiver;
        this.mResultCode = n;
        this.mResultData = bundle;
    }

    @Override
    public void run() {
        this.this$0.onReceiveResult(this.mResultCode, this.mResultData);
    }
}
