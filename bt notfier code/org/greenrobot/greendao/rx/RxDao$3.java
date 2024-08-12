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
class RxDao.3
implements Callable<T> {
    final RxDao this$0;
    final Object val$entity;

    RxDao.3(RxDao rxDao, Object object) {
        this.this$0 = rxDao;
        this.val$entity = object;
    }

    @Override
    public T call() throws Exception {
        RxDao.access$000((RxDao)this.this$0).refresh(this.val$entity);
        return this.val$entity;
    }
}
