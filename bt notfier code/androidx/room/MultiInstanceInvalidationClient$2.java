/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.ServiceConnection
 *  android.os.IBinder
 *  androidx.room.IMultiInstanceInvalidationService$Stub
 *  androidx.room.MultiInstanceInvalidationClient
 */
package androidx.room;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import androidx.room.IMultiInstanceInvalidationService;
import androidx.room.MultiInstanceInvalidationClient;

class MultiInstanceInvalidationClient.2
implements ServiceConnection {
    final MultiInstanceInvalidationClient this$0;

    MultiInstanceInvalidationClient.2(MultiInstanceInvalidationClient multiInstanceInvalidationClient) {
        this.this$0 = multiInstanceInvalidationClient;
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.this$0.mService = IMultiInstanceInvalidationService.Stub.asInterface((IBinder)iBinder);
        this.this$0.mExecutor.execute(this.this$0.mSetUpRunnable);
    }

    public void onServiceDisconnected(ComponentName componentName) {
        this.this$0.mExecutor.execute(this.this$0.mRemoveObserverRunnable);
        this.this$0.mService = null;
    }
}
