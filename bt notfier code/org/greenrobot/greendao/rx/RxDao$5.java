/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.greenrobot.greendao.rx.RxDao
 */
package org.greenrobot.greendao.rx;

import java.util.concurrent.Callable;
import org.greenrobot.greendao.rx.RxDao;

/*
 * Exception performing whole class analysis ignored.
 */
class RxDao.5
implements Callable<Iterable<T>> {
    final RxDao this$0;
    final Iterable val$entities;

    RxDao.5(RxDao rxDao, Iterable iterable) {
        this.this$0 = rxDao;
        this.val$entities = iterable;
    }

    @Override
    public Iterable<T> call() throws Exception {
        RxDao.access$000((RxDao)this.this$0).insertInTx(this.val$entities);
        return this.val$entities;
    }
}
