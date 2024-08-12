/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.greenrobot.eventbus.Subscription
 */
package org.greenrobot.eventbus;

import java.util.ArrayList;
import java.util.List;
import org.greenrobot.eventbus.Subscription;

final class PendingPost {
    private static final List<PendingPost> pendingPostPool = new ArrayList<PendingPost>();
    Object event;
    PendingPost next;
    Subscription subscription;

    private PendingPost(Object object, Subscription subscription) {
        this.event = object;
        this.subscription = subscription;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    static PendingPost obtainPendingPost(Subscription subscription, Object object) {
        List<PendingPost> list = pendingPostPool;
        synchronized (list) {
            int n = pendingPostPool.size();
            if (n <= 0) return new PendingPost(object, subscription);
            PendingPost pendingPost = pendingPostPool.remove(n - 1);
            pendingPost.event = object;
            pendingPost.subscription = subscription;
            pendingPost.next = null;
            return pendingPost;
        }
    }

    static void releasePendingPost(PendingPost pendingPost) {
        pendingPost.event = null;
        pendingPost.subscription = null;
        pendingPost.next = null;
        List<PendingPost> list = pendingPostPool;
        synchronized (list) {
            if (pendingPostPool.size() >= 10000) return;
            pendingPostPool.add(pendingPost);
            return;
        }
    }
}
