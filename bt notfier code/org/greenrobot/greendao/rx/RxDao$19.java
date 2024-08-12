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
class RxDao.19
implements Callable<Void> {
    final RxDao this$0;
    final Iterable val$entities;

    RxDao.19(RxDao rxDao, Iterable iterable) {
        this.this$0 = rxDao;
        this.val$entities = iterable;
    }

    @Override
    public Void call() throws Exception {
        RxDao.access$000((RxDao)this.this$0).deleteInTx(this.val$entities);
        return null;
    }
}
