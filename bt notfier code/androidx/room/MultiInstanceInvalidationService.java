/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Service
 *  android.content.Intent
 *  android.os.IBinder
 *  android.os.RemoteCallbackList
 *  androidx.room.IMultiInstanceInvalidationCallback
 *  androidx.room.IMultiInstanceInvalidationService$Stub
 */
package androidx.room;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import androidx.room.IMultiInstanceInvalidationCallback;
import androidx.room.IMultiInstanceInvalidationService;
import java.util.HashMap;

public class MultiInstanceInvalidationService
extends Service {
    private final IMultiInstanceInvalidationService.Stub mBinder;
    final RemoteCallbackList<IMultiInstanceInvalidationCallback> mCallbackList;
    final HashMap<Integer, String> mClientNames = new HashMap();
    int mMaxClientId = 0;

    public MultiInstanceInvalidationService() {
        this.mCallbackList = new /* Unavailable Anonymous Inner Class!! */;
        this.mBinder = new /* Unavailable Anonymous Inner Class!! */;
    }

    public IBinder onBind(Intent intent) {
        return this.mBinder;
    }
}
