/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.animation.Interpolator
 *  androidx.core.view.ViewPropertyAnimatorCompat
 *  androidx.core.view.ViewPropertyAnimatorListener
 *  androidx.core.view.ViewPropertyAnimatorListenerAdapter
 */
package androidx.appcompat.view;

import android.view.animation.Interpolator;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListener;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;
import java.util.ArrayList;
import java.util.Iterator;

public class ViewPropertyAnimatorCompatSet {
    final ArrayList<ViewPropertyAnimatorCompat> mAnimators;
    private long mDuration = -1L;
    private Interpolator mInterpolator;
    private boolean mIsStarted;
    ViewPropertyAnimatorListener mListener;
    private final ViewPropertyAnimatorListenerAdapter mProxyListener = new /* Unavailable Anonymous Inner Class!! */;

    public ViewPropertyAnimatorCompatSet() {
        this.mAnimators = new ArrayList();
    }

    public void cancel() {
        if (!this.mIsStarted) {
            return;
        }
        Iterator<ViewPropertyAnimatorCompat> iterator = this.mAnimators.iterator();
        while (true) {
            if (!iterator.hasNext()) {
                this.mIsStarted = false;
                return;
            }
            iterator.next().cancel();
        }
    }

    void onAnimationsEnded() {
        this.mIsStarted = false;
    }

    public ViewPropertyAnimatorCompatSet play(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat) {
        if (this.mIsStarted) return this;
        this.mAnimators.add(viewPropertyAnimatorCompat);
        return this;
    }

    public ViewPropertyAnimatorCompatSet playSequentially(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2) {
        this.mAnimators.add(viewPropertyAnimatorCompat);
        viewPropertyAnimatorCompat2.setStartDelay(viewPropertyAnimatorCompat.getDuration());
        this.mAnimators.add(viewPropertyAnimatorCompat2);
        return this;
    }

    public ViewPropertyAnimatorCompatSet setDuration(long l) {
        if (this.mIsStarted) return this;
        this.mDuration = l;
        return this;
    }

    public ViewPropertyAnimatorCompatSet setInterpolator(Interpolator interpolator) {
        if (this.mIsStarted) return this;
        this.mInterpolator = interpolator;
        return this;
    }

    public ViewPropertyAnimatorCompatSet setListener(ViewPropertyAnimatorListener viewPropertyAnimatorListener) {
        if (this.mIsStarted) return this;
        this.mListener = viewPropertyAnimatorListener;
        return this;
    }

    public void start() {
        if (this.mIsStarted) {
            return;
        }
        Iterator<ViewPropertyAnimatorCompat> iterator = this.mAnimators.iterator();
        while (true) {
            Interpolator interpolator;
            if (!iterator.hasNext()) {
                this.mIsStarted = true;
                return;
            }
            ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = iterator.next();
            long l = this.mDuration;
            if (l >= 0L) {
                viewPropertyAnimatorCompat.setDuration(l);
            }
            if ((interpolator = this.mInterpolator) != null) {
                viewPropertyAnimatorCompat.setInterpolator(interpolator);
            }
            if (this.mListener != null) {
                viewPropertyAnimatorCompat.setListener((ViewPropertyAnimatorListener)this.mProxyListener);
            }
            viewPropertyAnimatorCompat.start();
        }
    }
}
