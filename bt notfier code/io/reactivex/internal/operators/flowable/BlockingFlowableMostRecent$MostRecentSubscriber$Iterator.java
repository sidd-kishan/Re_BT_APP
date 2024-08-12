/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.internal.operators.flowable.BlockingFlowableMostRecent$MostRecentSubscriber
 *  io.reactivex.internal.util.ExceptionHelper
 *  io.reactivex.internal.util.NotificationLite
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.operators.flowable.BlockingFlowableMostRecent;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.NotificationLite;
import java.util.Iterator;
import java.util.NoSuchElementException;

final class BlockingFlowableMostRecent.MostRecentSubscriber.Iterator
implements Iterator<T> {
    private Object buf;
    final BlockingFlowableMostRecent.MostRecentSubscriber this$0;

    BlockingFlowableMostRecent.MostRecentSubscriber.Iterator(BlockingFlowableMostRecent.MostRecentSubscriber mostRecentSubscriber) {
        this.this$0 = mostRecentSubscriber;
    }

    @Override
    public boolean hasNext() {
        Object object;
        this.buf = object = this.this$0.value;
        return NotificationLite.isComplete((Object)object) ^ true;
    }

    @Override
    public T next() {
        try {
            if (this.buf == null) {
                this.buf = this.this$0.value;
            }
            if (!NotificationLite.isComplete((Object)this.buf)) {
                if (NotificationLite.isError((Object)this.buf)) throw ExceptionHelper.wrapOrThrow((Throwable)NotificationLite.getError((Object)this.buf));
                Object object = NotificationLite.getValue((Object)this.buf);
                return object;
            }
            NoSuchElementException noSuchElementException = new NoSuchElementException();
            throw noSuchElementException;
        }
        finally {
            this.buf = null;
        }
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Read only iterator");
    }
}
