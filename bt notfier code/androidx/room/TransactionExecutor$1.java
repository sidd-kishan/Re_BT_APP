/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.room.TransactionExecutor
 */
package androidx.room;

import androidx.room.TransactionExecutor;

class TransactionExecutor.1
implements Runnable {
    final TransactionExecutor this$0;
    final Runnable val$command;

    TransactionExecutor.1(TransactionExecutor transactionExecutor, Runnable runnable) {
        this.this$0 = transactionExecutor;
        this.val$command = runnable;
    }

    @Override
    public void run() {
        try {
            this.val$command.run();
            return;
        }
        finally {
            this.this$0.scheduleNext();
        }
    }
}
