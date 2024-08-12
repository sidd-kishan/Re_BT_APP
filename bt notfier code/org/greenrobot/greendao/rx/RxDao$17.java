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
class RxDao.17
implements Callable<Void> {
    final RxDao this$0;
    final Object val$key;

    RxDao.17(RxDao rxDao, Object object) {
        this.this$0 = rxDao;
        this.val$key = object;
    }

    @Override
    public Void call() throws Exception {
        RxDao.access$000((RxDao)this.this$0).deleteByKey(this.val$key);
        return null;
    }
}
