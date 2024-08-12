/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.room.MultiInstanceInvalidationClient$1
 */
package androidx.room;

import androidx.room.MultiInstanceInvalidationClient;

class MultiInstanceInvalidationClient.1
implements Runnable {
    final MultiInstanceInvalidationClient.1 this$1;
    final String[] val$tables;

    MultiInstanceInvalidationClient.1(MultiInstanceInvalidationClient.1 var1_1, String[] stringArray) {
        this.this$1 = var1_1;
        this.val$tables = stringArray;
    }

    @Override
    public void run() {
        this.this$1.this$0.mInvalidationTracker.notifyObserversByTableNames(this.val$tables);
    }
}
