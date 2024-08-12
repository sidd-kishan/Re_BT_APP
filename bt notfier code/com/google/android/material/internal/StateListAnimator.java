/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.Animator$AnimatorListener
 *  android.animation.ValueAnimator
 *  android.util.StateSet
 *  com.google.android.material.internal.StateListAnimator$Tuple
 */
package com.google.android.material.internal;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.util.StateSet;
import com.google.android.material.internal.StateListAnimator;
import java.util.ArrayList;

public final class StateListAnimator {
    private final Animator.AnimatorListener animationListener;
    private Tuple lastMatch = null;
    ValueAnimator runningAnimator = null;
    private final ArrayList<Tuple> tuples = new ArrayList();

    public StateListAnimator() {
        this.animationListener = new /* Unavailable Anonymous Inner Class!! */;
    }

    private void cancel() {
        ValueAnimator valueAnimator = this.runningAnimator;
        if (valueAnimator == null) return;
        valueAnimator.cancel();
        this.runningAnimator = null;
    }

    private void start(Tuple tuple) {
        tuple = tuple.animator;
        this.runningAnimator = tuple;
        tuple.start();
    }

    public void addState(int[] object, ValueAnimator valueAnimator) {
        object = new Tuple(object, valueAnimator);
        valueAnimator.addListener(this.animationListener);
        this.tuples.add((Tuple)object);
    }

    public void jumpToCurrentState() {
        ValueAnimator valueAnimator = this.runningAnimator;
        if (valueAnimator == null) return;
        valueAnimator.end();
        this.runningAnimator = null;
    }

    public void setState(int[] object) {
        Tuple tuple;
        block3: {
            int n = this.tuples.size();
            for (int i = 0; i < n; ++i) {
                tuple = this.tuples.get(i);
                if (!StateSet.stateSetMatches((int[])tuple.specs, (int[])object)) continue;
                object = tuple;
                break block3;
            }
            object = null;
        }
        tuple = this.lastMatch;
        if (object == tuple) {
            return;
        }
        if (tuple != null) {
            this.cancel();
        }
        this.lastMatch = (Tuple)object;
        if (object == null) return;
        this.start((Tuple)object);
    }
}
