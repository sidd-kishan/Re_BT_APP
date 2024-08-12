/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.os.Build$VERSION
 *  androidx.work.Constraints
 *  androidx.work.ContentUriTriggers
 *  androidx.work.NetworkType
 */
package androidx.work;

import android.net.Uri;
import android.os.Build;
import androidx.work.Constraints;
import androidx.work.ContentUriTriggers;
import androidx.work.NetworkType;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public static final class Constraints.Builder {
    ContentUriTriggers mContentUriTriggers;
    NetworkType mRequiredNetworkType;
    boolean mRequiresBatteryNotLow;
    boolean mRequiresCharging;
    boolean mRequiresDeviceIdle;
    boolean mRequiresStorageNotLow;
    long mTriggerContentMaxDelay;
    long mTriggerContentUpdateDelay;

    public Constraints.Builder() {
        this.mRequiresCharging = false;
        this.mRequiresDeviceIdle = false;
        this.mRequiredNetworkType = NetworkType.NOT_REQUIRED;
        this.mRequiresBatteryNotLow = false;
        this.mRequiresStorageNotLow = false;
        this.mTriggerContentUpdateDelay = -1L;
        this.mTriggerContentMaxDelay = -1L;
        this.mContentUriTriggers = new ContentUriTriggers();
    }

    public Constraints.Builder(Constraints constraints) {
        boolean bl = false;
        this.mRequiresCharging = false;
        this.mRequiresDeviceIdle = false;
        this.mRequiredNetworkType = NetworkType.NOT_REQUIRED;
        this.mRequiresBatteryNotLow = false;
        this.mRequiresStorageNotLow = false;
        this.mTriggerContentUpdateDelay = -1L;
        this.mTriggerContentMaxDelay = -1L;
        this.mContentUriTriggers = new ContentUriTriggers();
        this.mRequiresCharging = constraints.requiresCharging();
        boolean bl2 = bl;
        if (Build.VERSION.SDK_INT >= 23) {
            bl2 = bl;
            if (constraints.requiresDeviceIdle()) {
                bl2 = true;
            }
        }
        this.mRequiresDeviceIdle = bl2;
        this.mRequiredNetworkType = constraints.getRequiredNetworkType();
        this.mRequiresBatteryNotLow = constraints.requiresBatteryNotLow();
        this.mRequiresStorageNotLow = constraints.requiresStorageNotLow();
        if (Build.VERSION.SDK_INT < 24) return;
        this.mTriggerContentUpdateDelay = constraints.getTriggerContentUpdateDelay();
        this.mTriggerContentMaxDelay = constraints.getTriggerMaxContentDelay();
        this.mContentUriTriggers = constraints.getContentUriTriggers();
    }

    public Constraints.Builder addContentUriTrigger(Uri uri, boolean bl) {
        this.mContentUriTriggers.add(uri, bl);
        return this;
    }

    public Constraints build() {
        return new Constraints(this);
    }

    public Constraints.Builder setRequiredNetworkType(NetworkType networkType) {
        this.mRequiredNetworkType = networkType;
        return this;
    }

    public Constraints.Builder setRequiresBatteryNotLow(boolean bl) {
        this.mRequiresBatteryNotLow = bl;
        return this;
    }

    public Constraints.Builder setRequiresCharging(boolean bl) {
        this.mRequiresCharging = bl;
        return this;
    }

    public Constraints.Builder setRequiresDeviceIdle(boolean bl) {
        this.mRequiresDeviceIdle = bl;
        return this;
    }

    public Constraints.Builder setRequiresStorageNotLow(boolean bl) {
        this.mRequiresStorageNotLow = bl;
        return this;
    }

    public Constraints.Builder setTriggerContentMaxDelay(long l, TimeUnit timeUnit) {
        this.mTriggerContentMaxDelay = timeUnit.toMillis(l);
        return this;
    }

    public Constraints.Builder setTriggerContentMaxDelay(Duration duration) {
        this.mTriggerContentMaxDelay = duration.toMillis();
        return this;
    }

    public Constraints.Builder setTriggerContentUpdateDelay(long l, TimeUnit timeUnit) {
        this.mTriggerContentUpdateDelay = timeUnit.toMillis(l);
        return this;
    }

    public Constraints.Builder setTriggerContentUpdateDelay(Duration duration) {
        this.mTriggerContentUpdateDelay = duration.toMillis();
        return this;
    }
}
