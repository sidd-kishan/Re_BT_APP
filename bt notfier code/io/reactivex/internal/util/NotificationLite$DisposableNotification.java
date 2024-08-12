/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.disposables.Disposable
 */
package io.reactivex.internal.util;

import io.reactivex.disposables.Disposable;
import java.io.Serializable;

static final class NotificationLite.DisposableNotification
implements Serializable {
    private static final long serialVersionUID = -7482590109178395495L;
    final Disposable upstream;

    NotificationLite.DisposableNotification(Disposable disposable) {
        this.upstream = disposable;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("NotificationLite.Disposable[");
        stringBuilder.append(this.upstream);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
