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
class RxDao.2
implements Callable<T> {
    final RxDao this$0;
    final Object val$key;

    RxDao.2(RxDao rxDao, Object object) {
        this.this$0 = rxDao;
        this.val$key = object;
    }

    @Override
    public T call() throws Exception {
        return RxDao.access$000((RxDao)this.this$0).load(this.val$key);
    }
}
