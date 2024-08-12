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
class RxDao.22
implements Callable<Void> {
    final RxDao this$0;
    final Object[] val$keys;

    RxDao.22(RxDao rxDao, Object[] objectArray) {
        this.this$0 = rxDao;
        this.val$keys = objectArray;
    }

    @Override
    public Void call() throws Exception {
        RxDao.access$000((RxDao)this.this$0).deleteByKeyInTx(this.val$keys);
        return null;
    }
}
