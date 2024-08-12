/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Notification
 */
package androidx.work;

import android.app.Notification;

public final class ForegroundInfo {
    private final int mForegroundServiceType;
    private final Notification mNotification;
    private final int mNotificationId;

    public ForegroundInfo(int n, Notification notification) {
        this(n, notification, 0);
    }

    public ForegroundInfo(int n, Notification notification, int n2) {
        this.mNotificationId = n;
        this.mNotification = notification;
        this.mForegroundServiceType = n2;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) return false;
        if (this.getClass() != object.getClass()) {
            return false;
        }
        object = (ForegroundInfo)object;
        if (this.mNotificationId != ((ForegroundInfo)object).mNotificationId) {
            return false;
        }
        if (this.mForegroundServiceType == ((ForegroundInfo)object).mForegroundServiceType) return this.mNotification.equals(((ForegroundInfo)object).mNotification);
        return false;
    }

    public int getForegroundServiceType() {
        return this.mForegroundServiceType;
    }

    public Notification getNotification() {
        return this.mNotification;
    }

    public int getNotificationId() {
        return this.mNotificationId;
    }

    public int hashCode() {
        return (this.mNotificationId * 31 + this.mForegroundServiceType) * 31 + this.mNotification.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("ForegroundInfo{");
        stringBuilder.append("mNotificationId=");
        stringBuilder.append(this.mNotificationId);
        stringBuilder.append(", mForegroundServiceType=");
        stringBuilder.append(this.mForegroundServiceType);
        stringBuilder.append(", mNotification=");
        stringBuilder.append(this.mNotification);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
