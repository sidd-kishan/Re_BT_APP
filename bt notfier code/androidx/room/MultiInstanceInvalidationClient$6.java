/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.RemoteException
 *  android.util.Log
 *  androidx.room.IMultiInstanceInvalidationService
 *  androidx.room.InvalidationTracker$Observer
 *  androidx.room.MultiInstanceInvalidationClient
 */
package androidx.room;

import android.os.RemoteException;
import android.util.Log;
import androidx.room.IMultiInstanceInvalidationService;
import androidx.room.InvalidationTracker;
import androidx.room.MultiInstanceInvalidationClient;
import java.util.Set;

class MultiInstanceInvalidationClient.6
extends InvalidationTracker.Observer {
    final MultiInstanceInvalidationClient this$0;

    MultiInstanceInvalidationClient.6(MultiInstanceInvalidationClient multiInstanceInvalidationClient, String[] stringArray) {
        this.this$0 = multiInstanceInvalidationClient;
        super(stringArray);
    }

    boolean isRemote() {
        return true;
    }

    public void onInvalidated(Set<String> set) {
        if (this.this$0.mStopped.get()) {
            return;
        }
        try {
            IMultiInstanceInvalidationService iMultiInstanceInvalidationService = this.this$0.mService;
            if (iMultiInstanceInvalidationService == null) return;
            iMultiInstanceInvalidationService.broadcastInvalidation(this.this$0.mClientId, set.toArray(new String[0]));
        }
        catch (RemoteException remoteException) {
            Log.w((String)"ROOM", (String)"Cannot broadcast invalidation", (Throwable)remoteException);
        }
    }
}
