/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IInterface
 *  android.os.RemoteCallbackList
 *  android.os.RemoteException
 *  android.util.Log
 *  androidx.room.IMultiInstanceInvalidationCallback
 *  androidx.room.IMultiInstanceInvalidationService$Stub
 *  androidx.room.MultiInstanceInvalidationService
 */
package androidx.room;

import android.os.IInterface;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.util.Log;
import androidx.room.IMultiInstanceInvalidationCallback;
import androidx.room.IMultiInstanceInvalidationService;
import androidx.room.MultiInstanceInvalidationService;

class MultiInstanceInvalidationService.2
extends IMultiInstanceInvalidationService.Stub {
    final MultiInstanceInvalidationService this$0;

    MultiInstanceInvalidationService.2(MultiInstanceInvalidationService multiInstanceInvalidationService) {
        this.this$0 = multiInstanceInvalidationService;
    }

    /*
     * Loose catch block
     * Enabled force condition propagation
     */
    public void broadcastInvalidation(int n, String[] stringArray) {
        RemoteCallbackList remoteCallbackList = this.this$0.mCallbackList;
        synchronized (remoteCallbackList) {
            String string = (String)this.this$0.mClientNames.get(n);
            if (string == null) {
                Log.w((String)"ROOM", (String)"Remote invalidation client ID not registered");
                return;
            }
            int n2 = this.this$0.mCallbackList.beginBroadcast();
            {
                catch (Throwable throwable) {
                    throw throwable;
                }
                for (int i = 0; i < n2; ++i) {
                    try {
                        boolean bl;
                        int n3 = (Integer)this.this$0.mCallbackList.getBroadcastCookie(i);
                        String string2 = (String)this.this$0.mClientNames.get(n3);
                        if (n == n3 || !(bl = string.equals(string2))) continue;
                        try {
                            ((IMultiInstanceInvalidationCallback)this.this$0.mCallbackList.getBroadcastItem(i)).onInvalidation(stringArray);
                        }
                        catch (RemoteException remoteException) {
                            Log.w((String)"ROOM", (String)"Error invoking a remote callback", (Throwable)remoteException);
                        }
                        continue;
                    }
                    catch (Throwable throwable) {}
                    this.this$0.mCallbackList.finishBroadcast();
                    throw throwable;
                }
            }
            this.this$0.mCallbackList.finishBroadcast();
            return;
        }
    }

    public int registerCallback(IMultiInstanceInvalidationCallback iMultiInstanceInvalidationCallback, String string) {
        if (string == null) {
            return 0;
        }
        RemoteCallbackList remoteCallbackList = this.this$0.mCallbackList;
        synchronized (remoteCallbackList) {
            int n;
            MultiInstanceInvalidationService multiInstanceInvalidationService = this.this$0;
            multiInstanceInvalidationService.mMaxClientId = n = multiInstanceInvalidationService.mMaxClientId + 1;
            if (this.this$0.mCallbackList.register((IInterface)iMultiInstanceInvalidationCallback, (Object)n)) {
                this.this$0.mClientNames.put(n, string);
                return n;
            }
            iMultiInstanceInvalidationCallback = this.this$0;
            --iMultiInstanceInvalidationCallback.mMaxClientId;
            return 0;
        }
    }

    public void unregisterCallback(IMultiInstanceInvalidationCallback iMultiInstanceInvalidationCallback, int n) {
        RemoteCallbackList remoteCallbackList = this.this$0.mCallbackList;
        synchronized (remoteCallbackList) {
            this.this$0.mCallbackList.unregister((IInterface)iMultiInstanceInvalidationCallback);
            this.this$0.mClientNames.remove(n);
            return;
        }
    }
}
