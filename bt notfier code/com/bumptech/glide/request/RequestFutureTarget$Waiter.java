/*
 * Decompiled with CFR 0.152.
 */
package com.bumptech.glide.request;

static class RequestFutureTarget.Waiter {
    RequestFutureTarget.Waiter() {
    }

    void notifyAll(Object object) {
        object.notifyAll();
    }

    void waitForTimeout(Object object, long l) throws InterruptedException {
        object.wait(l);
    }
}
