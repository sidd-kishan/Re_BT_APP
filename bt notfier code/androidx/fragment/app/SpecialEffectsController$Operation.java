/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  androidx.core.os.CancellationSignal
 *  androidx.core.os.CancellationSignal$OnCancelListener
 *  androidx.fragment.app.Fragment
 *  androidx.fragment.app.FragmentManager
 *  androidx.fragment.app.SpecialEffectsController$3
 *  androidx.fragment.app.SpecialEffectsController$Operation$LifecycleImpact
 *  androidx.fragment.app.SpecialEffectsController$Operation$State
 */
package androidx.fragment.app;

import android.util.Log;
import androidx.core.os.CancellationSignal;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.SpecialEffectsController;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

static class SpecialEffectsController.Operation {
    private final List<Runnable> mCompletionListeners = new ArrayList<Runnable>();
    private State mFinalState;
    private final Fragment mFragment;
    private boolean mIsCanceled = false;
    private boolean mIsComplete = false;
    private LifecycleImpact mLifecycleImpact;
    private final HashSet<CancellationSignal> mSpecialEffectsSignals = new HashSet();

    SpecialEffectsController.Operation(State state, LifecycleImpact lifecycleImpact, Fragment fragment, CancellationSignal cancellationSignal) {
        this.mFinalState = state;
        this.mLifecycleImpact = lifecycleImpact;
        this.mFragment = fragment;
        cancellationSignal.setOnCancelListener((CancellationSignal.OnCancelListener)new /* Unavailable Anonymous Inner Class!! */);
    }

    final void addCompletionListener(Runnable runnable) {
        this.mCompletionListeners.add(runnable);
    }

    final void cancel() {
        if (this.isCanceled()) {
            return;
        }
        this.mIsCanceled = true;
        if (this.mSpecialEffectsSignals.isEmpty()) {
            this.complete();
            return;
        }
        Iterator<CancellationSignal> iterator = new ArrayList<CancellationSignal>(this.mSpecialEffectsSignals).iterator();
        while (iterator.hasNext()) {
            iterator.next().cancel();
        }
    }

    public void complete() {
        Object object;
        if (this.mIsComplete) {
            return;
        }
        if (FragmentManager.isLoggingEnabled((int)2)) {
            object = new StringBuilder();
            ((StringBuilder)object).append("SpecialEffectsController: ");
            ((StringBuilder)object).append(this);
            ((StringBuilder)object).append(" has called complete.");
            Log.v((String)"FragmentManager", (String)((StringBuilder)object).toString());
        }
        this.mIsComplete = true;
        object = this.mCompletionListeners.iterator();
        while (object.hasNext()) {
            ((Runnable)object.next()).run();
        }
    }

    public final void completeSpecialEffect(CancellationSignal cancellationSignal) {
        if (!this.mSpecialEffectsSignals.remove(cancellationSignal)) return;
        if (!this.mSpecialEffectsSignals.isEmpty()) return;
        this.complete();
    }

    public State getFinalState() {
        return this.mFinalState;
    }

    public final Fragment getFragment() {
        return this.mFragment;
    }

    LifecycleImpact getLifecycleImpact() {
        return this.mLifecycleImpact;
    }

    final boolean isCanceled() {
        return this.mIsCanceled;
    }

    final boolean isComplete() {
        return this.mIsComplete;
    }

    public final void markStartedSpecialEffect(CancellationSignal cancellationSignal) {
        this.onStart();
        this.mSpecialEffectsSignals.add(cancellationSignal);
    }

    final void mergeWith(State object, LifecycleImpact object2) {
        int n = SpecialEffectsController.3.$SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$LifecycleImpact[object2.ordinal()];
        if (n != 1) {
            if (n != 2) {
                if (n != 3) return;
                if (this.mFinalState == State.REMOVED) return;
                if (FragmentManager.isLoggingEnabled((int)2)) {
                    object2 = new StringBuilder();
                    ((StringBuilder)object2).append("SpecialEffectsController: For fragment ");
                    ((StringBuilder)object2).append(this.mFragment);
                    ((StringBuilder)object2).append(" mFinalState = ");
                    ((StringBuilder)object2).append(this.mFinalState);
                    ((StringBuilder)object2).append(" -> ");
                    ((StringBuilder)object2).append(object);
                    ((StringBuilder)object2).append(". ");
                    Log.v((String)"FragmentManager", (String)((StringBuilder)object2).toString());
                }
                this.mFinalState = object;
            } else {
                if (FragmentManager.isLoggingEnabled((int)2)) {
                    object = new StringBuilder();
                    ((StringBuilder)object).append("SpecialEffectsController: For fragment ");
                    ((StringBuilder)object).append(this.mFragment);
                    ((StringBuilder)object).append(" mFinalState = ");
                    ((StringBuilder)object).append(this.mFinalState);
                    ((StringBuilder)object).append(" -> REMOVED. mLifecycleImpact  = ");
                    ((StringBuilder)object).append(this.mLifecycleImpact);
                    ((StringBuilder)object).append(" to REMOVING.");
                    Log.v((String)"FragmentManager", (String)((StringBuilder)object).toString());
                }
                this.mFinalState = State.REMOVED;
                this.mLifecycleImpact = LifecycleImpact.REMOVING;
            }
        } else {
            if (this.mFinalState != State.REMOVED) return;
            if (FragmentManager.isLoggingEnabled((int)2)) {
                object = new StringBuilder();
                ((StringBuilder)object).append("SpecialEffectsController: For fragment ");
                ((StringBuilder)object).append(this.mFragment);
                ((StringBuilder)object).append(" mFinalState = REMOVED -> VISIBLE. mLifecycleImpact = ");
                ((StringBuilder)object).append(this.mLifecycleImpact);
                ((StringBuilder)object).append(" to ADDING.");
                Log.v((String)"FragmentManager", (String)((StringBuilder)object).toString());
            }
            this.mFinalState = State.VISIBLE;
            this.mLifecycleImpact = LifecycleImpact.ADDING;
        }
    }

    void onStart() {
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Operation ");
        stringBuilder.append("{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringBuilder.append("} ");
        stringBuilder.append("{");
        stringBuilder.append("mFinalState = ");
        stringBuilder.append(this.mFinalState);
        stringBuilder.append("} ");
        stringBuilder.append("{");
        stringBuilder.append("mLifecycleImpact = ");
        stringBuilder.append(this.mLifecycleImpact);
        stringBuilder.append("} ");
        stringBuilder.append("{");
        stringBuilder.append("mFragment = ");
        stringBuilder.append(this.mFragment);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
