/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.RemoteCallbackList
 *  androidx.room.IMultiInstanceInvalidationCallback
 *  androidx.room.MultiInstanceInvalidationService
 */
package androidx.room;

import android.os.RemoteCallbackList;
import androidx.room.IMultiInstanceInvalidationCallback;
import androidx.room.MultiInstanceInvalidationService;

class MultiInstanceInvalidationService.1
extends RemoteCallbackList<IMultiInstanceInvalidationCallback> {
    final MultiInstanceInvalidationService this$0;

    MultiInstanceInvalidationService.1(MultiInstanceInvalidationService multiInstanceInvalidationService) {
        this.this$0 = multiInstanceInvalidationService;
    }

    public void onCallbackDied(IMultiInstanceInvalidationCallback iMultiInstanceInvalidationCallback, Object object) {
        this.this$0.mClientNames.remove((int)((Integer)object));
    }
}
