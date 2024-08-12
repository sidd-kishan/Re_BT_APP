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

class MultiInstanceInvalidationClient.5
implements Runnable {
    final MultiInstanceInvalidationClient this$0;

    MultiInstanceInvalidationClient.5(MultiInstanceInvalidationClient multiInstanceInvalidationClient) {
        this.this$0 = multiInstanceInvalidationClient;
    }

    @Override
    public void run() {
        this.this$0.mInvalidationTracker.removeObserver(this.this$0.mObserver);
        try {
            IMultiInstanceInvalidationService iMultiInstanceInvalidationService = this.this$0.mService;
            if (iMultiInstanceInvalidationService != null) {
                iMultiInstanceInvalidationService.unregisterCallback(this.this$0.mCallback, this.this$0.mClientId);
            }
        }
        catch (RemoteException remoteException) {
            Log.w((String)"ROOM", (String)"Cannot unregister multi-instance invalidation callback", (Throwable)remoteException);
        }
        this.this$0.mAppContext.unbindService(this.this$0.mServiceConnection);
    }
}
