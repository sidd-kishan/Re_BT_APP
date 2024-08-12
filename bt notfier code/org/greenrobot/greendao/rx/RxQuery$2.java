/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.greenrobot.greendao.rx.RxQuery
 */
package org.greenrobot.greendao.rx;

import java.util.concurrent.Callable;
import org.greenrobot.greendao.rx.RxQuery;

/*
 * Exception performing whole class analysis ignored.
 */
class RxQuery.2
implements Callable<T> {
    final RxQuery this$0;

    RxQuery.2(RxQuery rxQuery) {
        this.this$0 = rxQuery;
    }

    @Override
    public T call() throws Exception {
        return RxQuery.access$000((RxQuery)this.this$0).forCurrentThread().unique();
    }
}
