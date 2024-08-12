/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Notification
 *  io.reactivex.functions.Consumer
 */
package io.reactivex.internal.functions;

import io.reactivex.Notification;
import io.reactivex.functions.Consumer;

static final class Functions.NotificationOnNext<T>
implements Consumer<T> {
    final Consumer<? super Notification<T>> onNotification;

    Functions.NotificationOnNext(Consumer<? super Notification<T>> consumer) {
        this.onNotification = consumer;
    }

    public void accept(T t) throws Exception {
        this.onNotification.accept((Object)Notification.createOnNext(t));
    }
}
