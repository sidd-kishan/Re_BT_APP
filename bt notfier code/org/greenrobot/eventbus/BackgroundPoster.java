/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.greenrobot.eventbus.EventBus
 *  org.greenrobot.eventbus.Logger
 *  org.greenrobot.eventbus.PendingPost
 *  org.greenrobot.eventbus.PendingPostQueue
 *  org.greenrobot.eventbus.Poster
 *  org.greenrobot.eventbus.Subscription
 */
package org.greenrobot.eventbus;

import java.util.logging.Level;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Logger;
import org.greenrobot.eventbus.PendingPost;
import org.greenrobot.eventbus.PendingPostQueue;
import org.greenrobot.eventbus.Poster;
import org.greenrobot.eventbus.Subscription;

final class BackgroundPoster
implements Runnable,
Poster {
    private final EventBus eventBus;
    private volatile boolean executorRunning;
    private final PendingPostQueue queue;

    BackgroundPoster(EventBus eventBus) {
        this.eventBus = eventBus;
        this.queue = new PendingPostQueue();
    }

    public void enqueue(Subscription subscription, Object object) {
        subscription = PendingPost.obtainPendingPost((Subscription)subscription, (Object)object);
        synchronized (this) {
            this.queue.enqueue((PendingPost)subscription);
            if (this.executorRunning) return;
            this.executorRunning = true;
            this.eventBus.getExecutorService().execute(this);
            return;
        }
    }

    /*
     * Enabled unnecessary exception pruning
     */
    @Override
    public void run() {
        Throwable throwable2;
        while (true) {
            PendingPost pendingPost;
            block10: {
                try {
                    PendingPost pendingPost2;
                    pendingPost = pendingPost2 = this.queue.poll(1000);
                    if (pendingPost2 != null) break block10;
                    synchronized (this) {
                    }
                }
                catch (Throwable throwable2) {
                    break;
                }
                catch (InterruptedException interruptedException) {
                    Logger logger = this.eventBus.getLogger();
                    Level level = Level.WARNING;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(Thread.currentThread().getName());
                    stringBuilder.append(" was interruppted");
                    logger.log(level, stringBuilder.toString(), (Throwable)interruptedException);
                    this.executorRunning = false;
                    return;
                }
                {
                    pendingPost = this.queue.poll();
                    if (pendingPost == null) {
                        this.executorRunning = false;
                        // MONITOREXIT @DISABLED, blocks:[5, 8, 9] lbl23 : MonitorExitStatement: MONITOREXIT : this
                        this.executorRunning = false;
                        return;
                    }
                }
            }
            this.eventBus.invokeSubscriber(pendingPost);
        }
        this.executorRunning = false;
        throw throwable2;
    }
}
