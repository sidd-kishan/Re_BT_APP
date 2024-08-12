/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  androidx.work.Constraints$Builder
 *  androidx.work.ContentUriTriggers
 *  androidx.work.NetworkType
 */
package androidx.work;

import android.os.Build;
import androidx.work.Constraints;
import androidx.work.ContentUriTriggers;
import androidx.work.NetworkType;

public final class Constraints {
    public static final Constraints NONE = new Builder().build();
    private ContentUriTriggers mContentUriTriggers;
    private NetworkType mRequiredNetworkType = NetworkType.NOT_REQUIRED;
    private boolean mRequiresBatteryNotLow;
    private boolean mRequiresCharging;
    private boolean mRequiresDeviceIdle;
    private boolean mRequiresStorageNotLow;
    private long mTriggerContentUpdateDelay = -1L;
    private long mTriggerMaxContentDelay = -1L;

    public Constraints() {
        this.mContentUriTriggers = new ContentUriTriggers();
    }

    Constraints(Builder builder) {
        this.mContentUriTriggers = new ContentUriTriggers();
        this.mRequiresCharging = builder.mRequiresCharging;
        boolean bl = Build.VERSION.SDK_INT >= 23 && builder.mRequiresDeviceIdle;
        this.mRequiresDeviceIdle = bl;
        this.mRequiredNetworkType = builder.mRequiredNetworkType;
        this.mRequiresBatteryNotLow = builder.mRequiresBatteryNotLow;
        this.mRequiresStorageNotLow = builder.mRequiresStorageNotLow;
        if (Build.VERSION.SDK_INT < 24) return;
        this.mContentUriTriggers = builder.mContentUriTriggers;
        this.mTriggerContentUpdateDelay = builder.mTriggerContentUpdateDelay;
        this.mTriggerMaxContentDelay = builder.mTriggerContentMaxDelay;
    }

    public Constraints(Constraints constraints) {
        this.mContentUriTriggers = new ContentUriTriggers();
        this.mRequiresCharging = constraints.mRequiresCharging;
        this.mRequiresDeviceIdle = constraints.mRequiresDeviceIdle;
        this.mRequiredNetworkType = constraints.mRequiredNetworkType;
        this.mRequiresBatteryNotLow = constraints.mRequiresBatteryNotLow;
        this.mRequiresStorageNotLow = constraints.mRequiresStorageNotLow;
        this.mContentUriTriggers = constraints.mContentUriTriggers;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) return false;
        if (this.getClass() != object.getClass()) {
            return false;
        }
        object = (Constraints)object;
        if (this.mRequiresCharging != ((Constraints)object).mRequiresCharging) {
            return false;
        }
        if (this.mRequiresDeviceIdle != ((Constraints)object).mRequiresDeviceIdle) {
            return false;
        }
        if (this.mRequiresBatteryNotLow != ((Constraints)object).mRequiresBatteryNotLow) {
            return false;
        }
        if (this.mRequiresStorageNotLow != ((Constraints)object).mRequiresStorageNotLow) {
            return false;
        }
        if (this.mTriggerContentUpdateDelay != ((Constraints)object).mTriggerContentUpdateDelay) {
            return false;
        }
        if (this.mTriggerMaxContentDelay != ((Constraints)object).mTriggerMaxContentDelay) {
            return false;
        }
        if (this.mRequiredNetworkType == ((Constraints)object).mRequiredNetworkType) return this.mContentUriTriggers.equals((Object)((Constraints)object).mContentUriTriggers);
        return false;
    }

    public ContentUriTriggers getContentUriTriggers() {
        return this.mContentUriTriggers;
    }

    public NetworkType getRequiredNetworkType() {
        return this.mRequiredNetworkType;
    }

    public long getTriggerContentUpdateDelay() {
        return this.mTriggerContentUpdateDelay;
    }

    public long getTriggerMaxContentDelay() {
        return this.mTriggerMaxContentDelay;
    }

    public boolean hasContentUriTriggers() {
        boolean bl = this.mContentUriTriggers.size() > 0;
        return bl;
    }

    public int hashCode() {
        int n = this.mRequiredNetworkType.hashCode();
        int n2 = this.mRequiresCharging;
        int n3 = this.mRequiresDeviceIdle;
        int n4 = this.mRequiresBatteryNotLow;
        int n5 = this.mRequiresStorageNotLow;
        long l = this.mTriggerContentUpdateDelay;
        int n6 = (int)(l ^ l >>> 32);
        l = this.mTriggerMaxContentDelay;
        return ((((((n * 31 + n2) * 31 + n3) * 31 + n4) * 31 + n5) * 31 + n6) * 31 + (int)(l ^ l >>> 32)) * 31 + this.mContentUriTriggers.hashCode();
    }

    public boolean requiresBatteryNotLow() {
        return this.mRequiresBatteryNotLow;
    }

    public boolean requiresCharging() {
        return this.mRequiresCharging;
    }

    public boolean requiresDeviceIdle() {
        return this.mRequiresDeviceIdle;
    }

    public boolean requiresStorageNotLow() {
        return this.mRequiresStorageNotLow;
    }

    public void setContentUriTriggers(ContentUriTriggers contentUriTriggers) {
        this.mContentUriTriggers = contentUriTriggers;
    }

    public void setRequiredNetworkType(NetworkType networkType) {
        this.mRequiredNetworkType = networkType;
    }

    public void setRequiresBatteryNotLow(boolean bl) {
        this.mRequiresBatteryNotLow = bl;
    }

    public void setRequiresCharging(boolean bl) {
        this.mRequiresCharging = bl;
    }

    public void setRequiresDeviceIdle(boolean bl) {
        this.mRequiresDeviceIdle = bl;
    }

    public void setRequiresStorageNotLow(boolean bl) {
        this.mRequiresStorageNotLow = bl;
    }

    public void setTriggerContentUpdateDelay(long l) {
        this.mTriggerContentUpdateDelay = l;
    }

    public void setTriggerMaxContentDelay(long l) {
        this.mTriggerMaxContentDelay = l;
    }
}
