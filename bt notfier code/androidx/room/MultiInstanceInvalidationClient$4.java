/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.room.MultiInstanceInvalidationClient
 */
package androidx.room;

import androidx.room.MultiInstanceInvalidationClient;

class MultiInstanceInvalidationClient.4
implements Runnable {
    final MultiInstanceInvalidationClient this$0;

    MultiInstanceInvalidationClient.4(MultiInstanceInvalidationClient multiInstanceInvalidationClient) {
        this.this$0 = multiInstanceInvalidationClient;
    }

    @Override
    public void run() {
        this.this$0.mInvalidationTracker.removeObserver(this.this$0.mObserver);
    }
}
