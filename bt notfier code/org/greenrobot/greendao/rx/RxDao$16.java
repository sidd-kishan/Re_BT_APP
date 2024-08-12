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
class RxDao.16
implements Callable<Void> {
    final RxDao this$0;
    final Object val$entity;

    RxDao.16(RxDao rxDao, Object object) {
        this.this$0 = rxDao;
        this.val$entity = object;
    }

    @Override
    public Void call() throws Exception {
        RxDao.access$000((RxDao)this.this$0).delete(this.val$entity);
        return null;
    }
}
