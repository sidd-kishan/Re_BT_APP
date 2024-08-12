/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.RemoteException
 *  android.util.Log
 *  androidx.room.IMultiInstanceInvalidationService
 *  androidx.room.MultiInstanceInvalidationClient
 */
package androidx.room;

import android.os.RemoteException;
import android.util.Log;
import androidx.room.IMultiInstanceInvalidationService;
import androidx.room.MultiInstanceInvalidationClient;

class MultiInstanceInvalidationClient.3
implements Runnable {
    final MultiInstanceInvalidationClient this$0;

    MultiInstanceInvalidationClient.3(MultiInstanceInvalidationClient multiInstanceInvalidationClient) {
        this.this$0 = multiInstanceInvalidationClient;
    }

    @Override
    public void run() {
        try {
            IMultiInstanceInvalidationService iMultiInstanceInvalidationService = this.this$0.mService;
            if (iMultiInstanceInvalidationService == null) return;
            this.this$0.mClientId = iMultiInstanceInvalidationService.registerCallback(this.this$0.mCallback, this.this$0.mName);
            this.this$0.mInvalidationTracker.addObserver(this.this$0.mObserver);
        }
        catch (RemoteException remoteException) {
            Log.w((String)"ROOM", (String)"Cannot register multi-instance invalidation callback", (Throwable)remoteException);
        }
    }
}
