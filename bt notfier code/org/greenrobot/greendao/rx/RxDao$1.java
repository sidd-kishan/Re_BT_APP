/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.greenrobot.greendao.rx.RxDao
 */
package org.greenrobot.greendao.rx;

import java.util.List;
import java.util.concurrent.Callable;
import org.greenrobot.greendao.rx.RxDao;

/*
 * Exception performing whole class analysis ignored.
 */
class RxDao.1
implements Callable<List<T>> {
    final RxDao this$0;

    RxDao.1(RxDao rxDao) {
        this.this$0 = rxDao;
    }

    @Override
    public List<T> call() throws Exception {
        return RxDao.access$000((RxDao)this.this$0).loadAll();
    }
}
