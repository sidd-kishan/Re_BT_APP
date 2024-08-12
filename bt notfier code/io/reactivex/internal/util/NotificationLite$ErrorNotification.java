/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.internal.functions.ObjectHelper
 */
package io.reactivex.internal.util;

import io.reactivex.internal.functions.ObjectHelper;
import java.io.Serializable;

static final class NotificationLite.ErrorNotification
implements Serializable {
    private static final long serialVersionUID = -8759979445933046293L;
    final Throwable e;

    NotificationLite.ErrorNotification(Throwable throwable) {
        this.e = throwable;
    }

    public boolean equals(Object object) {
        if (!(object instanceof NotificationLite.ErrorNotification)) return false;
        object = (NotificationLite.ErrorNotification)object;
        return ObjectHelper.equals((Object)this.e, (Object)((NotificationLite.ErrorNotification)object).e);
    }

    public int hashCode() {
        return this.e.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("NotificationLite.Error[");
        stringBuilder.append(this.e);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
