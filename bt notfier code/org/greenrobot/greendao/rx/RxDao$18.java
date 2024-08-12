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
class RxDao.18
implements Callable<Void> {
    final RxDao this$0;

    RxDao.18(RxDao rxDao) {
        this.this$0 = rxDao;
    }

    @Override
    public Void call() throws Exception {
        RxDao.access$000((RxDao)this.this$0).deleteAll();
        return null;
    }
}
