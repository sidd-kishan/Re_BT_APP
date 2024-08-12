/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.Message
 *  io.reactivex.Scheduler
 *  io.reactivex.android.plugins.RxAndroidPlugins
 *  io.reactivex.android.schedulers.HandlerScheduler
 */
package io.reactivex.android.schedulers;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import io.reactivex.Scheduler;
import io.reactivex.android.plugins.RxAndroidPlugins;
import io.reactivex.android.schedulers.HandlerScheduler;
import java.util.concurrent.Callable;

public final class AndroidSchedulers {
    private static final Scheduler MAIN_THREAD = RxAndroidPlugins.initMainThreadScheduler((Callable)new /* Unavailable Anonymous Inner Class!! */);

    private AndroidSchedulers() {
        throw new AssertionError((Object)"No instances.");
    }

    public static Scheduler from(Looper looper) {
        return AndroidSchedulers.from(looper, false);
    }

    public static Scheduler from(Looper looper, boolean bl) {
        boolean bl2;
        if (looper == null) throw new NullPointerException("looper == null");
        if (Build.VERSION.SDK_INT < 16) {
            bl2 = false;
        } else {
            bl2 = bl;
            if (!bl) return new HandlerScheduler(new Handler(looper), bl2);
            bl2 = bl;
            if (Build.VERSION.SDK_INT >= 22) return new HandlerScheduler(new Handler(looper), bl2);
            Message message = Message.obtain();
            try {
                message.setAsynchronous(true);
            }
            catch (NoSuchMethodError noSuchMethodError) {
                bl = false;
            }
            message.recycle();
            bl2 = bl;
        }
        return new HandlerScheduler(new Handler(looper), bl2);
    }

    public static Scheduler mainThread() {
        return RxAndroidPlugins.onMainThreadScheduler((Scheduler)MAIN_THREAD);
    }
}
