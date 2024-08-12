/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.greenrobot.eventbus.PendingPost
 */
package org.greenrobot.eventbus;

import org.greenrobot.eventbus.PendingPost;

final class PendingPostQueue {
    private PendingPost head;
    private PendingPost tail;

    PendingPostQueue() {
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    void enqueue(PendingPost var1_1) {
        synchronized (this) {
            if (var1_1 /* !! */  == null) ** GOTO lbl15
            try {
                if (this.tail != null) {
                    this.tail.next = var1_1 /* !! */ ;
                    this.tail = var1_1 /* !! */ ;
                } else {
                    if (this.head != null) {
                        var1_1 /* !! */  = new IllegalStateException("Head present, but no tail");
                        throw var1_1 /* !! */ ;
                    }
                    this.tail = var1_1 /* !! */ ;
                    this.head = var1_1 /* !! */ ;
                }
                this.notifyAll();
                return;
lbl15:
                // 1 sources

                var1_1 /* !! */  = new NullPointerException("null cannot be enqueued");
                throw var1_1 /* !! */ ;
            }
            catch (Throwable var1_2) {}
            throw var1_2;
        }
    }

    PendingPost poll() {
        synchronized (this) {
            PendingPost pendingPost;
            PendingPost pendingPost2 = this.head;
            if (this.head == null) return pendingPost2;
            this.head = pendingPost = this.head.next;
            if (pendingPost != null) return pendingPost2;
            this.tail = null;
            return pendingPost2;
        }
    }

    PendingPost poll(int n) throws InterruptedException {
        synchronized (this) {
            if (this.head == null) {
                this.wait(n);
            }
            PendingPost pendingPost = this.poll();
            return pendingPost;
        }
    }
}
