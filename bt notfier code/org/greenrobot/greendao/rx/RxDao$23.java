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
class RxDao.23
implements Callable<Long> {
    final RxDao this$0;

    RxDao.23(RxDao rxDao) {
        this.this$0 = rxDao;
    }

    @Override
    public Long call() throws Exception {
        return RxDao.access$000((RxDao)this.this$0).count();
    }
}
