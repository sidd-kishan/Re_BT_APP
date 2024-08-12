/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.greenrobot.greendao.rx.RxTransaction
 */
package org.greenrobot.greendao.rx;

import java.util.concurrent.Callable;
import org.greenrobot.greendao.rx.RxTransaction;

/*
 * Exception performing whole class analysis ignored.
 */
class RxTransaction.1
implements Callable<Void> {
    final RxTransaction this$0;
    final Runnable val$runnable;

    RxTransaction.1(RxTransaction rxTransaction, Runnable runnable) {
        this.this$0 = rxTransaction;
        this.val$runnable = runnable;
    }

    @Override
    public Void call() throws Exception {
        RxTransaction.access$000((RxTransaction)this.this$0).runInTx(this.val$runnable);
        return null;
    }
}
