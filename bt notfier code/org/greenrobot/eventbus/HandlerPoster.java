/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.Message
 *  android.os.SystemClock
 *  org.greenrobot.eventbus.EventBus
 *  org.greenrobot.eventbus.EventBusException
 *  org.greenrobot.eventbus.PendingPost
 *  org.greenrobot.eventbus.PendingPostQueue
 *  org.greenrobot.eventbus.Poster
 *  org.greenrobot.eventbus.Subscription
 */
package org.greenrobot.eventbus;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.EventBusException;
import org.greenrobot.eventbus.PendingPost;
import org.greenrobot.eventbus.PendingPostQueue;
import org.greenrobot.eventbus.Poster;
import org.greenrobot.eventbus.Subscription;

public class HandlerPoster
extends Handler
implements Poster {
    private final EventBus eventBus;
    private boolean handlerActive;
    private final int maxMillisInsideHandleMessage;
    private final PendingPostQueue queue;

    protected HandlerPoster(EventBus eventBus, Looper looper, int n) {
        super(looper);
        this.eventBus = eventBus;
        this.maxMillisInsideHandleMessage = n;
        this.queue = new PendingPostQueue();
    }

    public void enqueue(Subscription subscription, Object object) {
        subscription = PendingPost.obtainPendingPost((Subscription)subscription, (Object)object);
        synchronized (this) {
            this.queue.enqueue((PendingPost)subscription);
            if (this.handlerActive) return;
            this.handlerActive = true;
            if (this.sendMessage(this.obtainMessage())) {
                return;
            }
            subscription = new EventBusException("Could not send handler message");
            throw subscription;
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled unnecessary exception pruning
     */
    public void handleMessage(Message var1_1) {
        block9: {
            try {
                var3_3 = SystemClock.uptimeMillis();
lbl3:
                // 2 sources

                while (true) {
                    var5_4 = this.queue.poll();
                    var1_1 = var5_4;
                    if (var5_4 != null) break block9;
                    synchronized (this) {
                    }
                    break;
                }
            }
            catch (Throwable var1_2) {
                this.handlerActive = false;
                throw var1_2;
            }
            {
                var1_1 = this.queue.poll();
                if (var1_1 == null) {
                    this.handlerActive = false;
                    // MONITOREXIT @DISABLED, blocks:[5, 8] lbl15 : MonitorExitStatement: MONITOREXIT : this
                    this.handlerActive = false;
                    return;
                }
            }
        }
        this.eventBus.invokeSubscriber((PendingPost)var1_1);
        ** while (SystemClock.uptimeMillis() - var3_3 < (long)this.maxMillisInsideHandleMessage)
lbl21:
        // 1 sources

        var2_5 = this.sendMessage(this.obtainMessage());
        if (!var2_5) ** GOTO lbl-1000
        this.handlerActive = true;
        return;
lbl-1000:
        // 1 sources

        {
            var1_1 = new EventBusException("Could not send handler message");
            throw var1_1;
        }
    }
}
