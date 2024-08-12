/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.greenrobot.eventbus.EventBus
 *  org.greenrobot.eventbus.PendingPost
 *  org.greenrobot.eventbus.PendingPostQueue
 *  org.greenrobot.eventbus.Poster
 *  org.greenrobot.eventbus.Subscription
 */
package org.greenrobot.eventbus;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.PendingPost;
import org.greenrobot.eventbus.PendingPostQueue;
import org.greenrobot.eventbus.Poster;
import org.greenrobot.eventbus.Subscription;

class AsyncPoster
implements Runnable,
Poster {
    private final EventBus eventBus;
    private final PendingPostQueue queue;

    AsyncPoster(EventBus eventBus) {
        this.eventBus = eventBus;
        this.queue = new PendingPostQueue();
    }

    public void enqueue(Subscription subscription, Object object) {
        subscription = PendingPost.obtainPendingPost((Subscription)subscription, (Object)object);
        this.queue.enqueue((PendingPost)subscription);
        this.eventBus.getExecutorService().execute(this);
    }

    @Override
    public void run() {
        PendingPost pendingPost = this.queue.poll();
        if (pendingPost == null) throw new IllegalStateException("No pending post available");
        this.eventBus.invokeSubscriber(pendingPost);
    }
}
