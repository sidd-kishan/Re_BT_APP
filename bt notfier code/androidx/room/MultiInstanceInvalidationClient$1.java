/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.room.IMultiInstanceInvalidationCallback$Stub
 *  androidx.room.MultiInstanceInvalidationClient
 */
package androidx.room;

import androidx.room.IMultiInstanceInvalidationCallback;
import androidx.room.MultiInstanceInvalidationClient;

class MultiInstanceInvalidationClient.1
extends IMultiInstanceInvalidationCallback.Stub {
    final MultiInstanceInvalidationClient this$0;

    MultiInstanceInvalidationClient.1(MultiInstanceInvalidationClient multiInstanceInvalidationClient) {
        this.this$0 = multiInstanceInvalidationClient;
    }

    public void onInvalidation(String[] stringArray) {
        this.this$0.mExecutor.execute((Runnable)new /* Unavailable Anonymous Inner Class!! */);
    }
}
