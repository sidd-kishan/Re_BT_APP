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
class RxTransaction.2
implements Callable<T> {
    final RxTransaction this$0;
    final Callable val$callable;

    RxTransaction.2(RxTransaction rxTransaction, Callable callable) {
        this.this$0 = rxTransaction;
        this.val$callable = callable;
    }

    @Override
    public T call() throws Exception {
        return RxTransaction.access$000((RxTransaction)this.this$0).callInTx(this.val$callable);
    }
}
