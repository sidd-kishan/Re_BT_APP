/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Application
 *  android.app.Application$ActivityLifecycleCallbacks
 *  android.content.Context
 *  android.os.Handler
 *  androidx.lifecycle.Lifecycle
 *  androidx.lifecycle.Lifecycle$Event
 *  androidx.lifecycle.LifecycleOwner
 *  androidx.lifecycle.LifecycleRegistry
 *  androidx.lifecycle.ReportFragment$ActivityInitializationListener
 */
package androidx.lifecycle;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ReportFragment;

public class ProcessLifecycleOwner
implements LifecycleOwner {
    static final long TIMEOUT_MS = 700L;
    private static final ProcessLifecycleOwner sInstance = new ProcessLifecycleOwner();
    private Runnable mDelayedPauseRunnable;
    private Handler mHandler;
    ReportFragment.ActivityInitializationListener mInitializationListener;
    private boolean mPauseSent = true;
    private final LifecycleRegistry mRegistry = new LifecycleRegistry((LifecycleOwner)this);
    private int mResumedCounter = 0;
    private int mStartedCounter = 0;
    private boolean mStopSent = true;

    private ProcessLifecycleOwner() {
        this.mDelayedPauseRunnable = new /* Unavailable Anonymous Inner Class!! */;
        this.mInitializationListener = new /* Unavailable Anonymous Inner Class!! */;
    }

    public static LifecycleOwner get() {
        return sInstance;
    }

    static void init(Context context) {
        sInstance.attach(context);
    }

    void activityPaused() {
        int n;
        this.mResumedCounter = n = this.mResumedCounter - 1;
        if (n != 0) return;
        this.mHandler.postDelayed(this.mDelayedPauseRunnable, 700L);
    }

    void activityResumed() {
        int n;
        this.mResumedCounter = n = this.mResumedCounter + 1;
        if (n != 1) return;
        if (this.mPauseSent) {
            this.mRegistry.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
            this.mPauseSent = false;
        } else {
            this.mHandler.removeCallbacks(this.mDelayedPauseRunnable);
        }
    }

    void activityStarted() {
        int n;
        this.mStartedCounter = n = this.mStartedCounter + 1;
        if (n != 1) return;
        if (!this.mStopSent) return;
        this.mRegistry.handleLifecycleEvent(Lifecycle.Event.ON_START);
        this.mStopSent = false;
    }

    void activityStopped() {
        --this.mStartedCounter;
        this.dispatchStopIfNeeded();
    }

    void attach(Context context) {
        this.mHandler = new Handler();
        this.mRegistry.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
        ((Application)context.getApplicationContext()).registerActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)new /* Unavailable Anonymous Inner Class!! */);
    }

    void dispatchPauseIfNeeded() {
        if (this.mResumedCounter != 0) return;
        this.mPauseSent = true;
        this.mRegistry.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
    }

    void dispatchStopIfNeeded() {
        if (this.mStartedCounter != 0) return;
        if (!this.mPauseSent) return;
        this.mRegistry.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
        this.mStopSent = true;
    }

    public Lifecycle getLifecycle() {
        return this.mRegistry;
    }
}
