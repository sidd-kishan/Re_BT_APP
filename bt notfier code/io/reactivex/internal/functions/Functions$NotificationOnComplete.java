/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Notification
 *  io.reactivex.functions.Action
 *  io.reactivex.functions.Consumer
 */
package io.reactivex.internal.functions;

import io.reactivex.Notification;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;

static final class Functions.NotificationOnComplete<T>
implements Action {
    final Consumer<? super Notification<T>> onNotification;

    Functions.NotificationOnComplete(Consumer<? super Notification<T>> consumer) {
        this.onNotification = consumer;
    }

    public void run() throws Exception {
        this.onNotification.accept((Object)Notification.createOnComplete());
    }
}
