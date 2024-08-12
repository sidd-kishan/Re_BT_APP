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
class RxDao.12
implements Callable<Object[]> {
    final RxDao this$0;
    final Object[] val$entities;

    RxDao.12(RxDao rxDao, Object[] objectArray) {
        this.this$0 = rxDao;
        this.val$entities = objectArray;
    }

    @Override
    public Object[] call() throws Exception {
        RxDao.access$000((RxDao)this.this$0).saveInTx(this.val$entities);
        return this.val$entities;
    }
}
