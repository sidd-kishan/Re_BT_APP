/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.Animator$AnimatorListener
 *  android.animation.TimeInterpolator
 *  android.os.Build$VERSION
 *  android.view.View
 *  android.view.animation.Interpolator
 *  androidx.core.view.ViewPropertyAnimatorCompat$2
 *  androidx.core.view.ViewPropertyAnimatorCompat$ViewPropertyAnimatorListenerApi14
 *  androidx.core.view.ViewPropertyAnimatorListener
 *  androidx.core.view.ViewPropertyAnimatorUpdateListener
 */
package androidx.core.view;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.os.Build;
import android.view.View;
import android.view.animation.Interpolator;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListener;
import androidx.core.view.ViewPropertyAnimatorUpdateListener;
import java.lang.ref.WeakReference;

public final class ViewPropertyAnimatorCompat {
    static final int LISTENER_TAG_ID = 0x7E000000;
    Runnable mEndAction = null;
    int mOldLayerType = -1;
    Runnable mStartAction = null;
    private WeakReference<View> mView;

    ViewPropertyAnimatorCompat(View view) {
        this.mView = new WeakReference<View>(view);
    }

    private void setListenerInternal(View view, ViewPropertyAnimatorListener viewPropertyAnimatorListener) {
        if (viewPropertyAnimatorListener != null) {
            view.animate().setListener((Animator.AnimatorListener)new /* Unavailable Anonymous Inner Class!! */);
        } else {
            view.animate().setListener(null);
        }
    }

    public ViewPropertyAnimatorCompat alpha(float f) {
        View view = (View)this.mView.get();
        if (view == null) return this;
        view.animate().alpha(f);
        return this;
    }

    public ViewPropertyAnimatorCompat alphaBy(float f) {
        View view = (View)this.mView.get();
        if (view == null) return this;
        view.animate().alphaBy(f);
        return this;
    }

    public void cancel() {
        View view = (View)this.mView.get();
        if (view == null) return;
        view.animate().cancel();
    }

    public long getDuration() {
        View view = (View)this.mView.get();
        if (view == null) return 0L;
        return view.animate().getDuration();
    }

    public Interpolator getInterpolator() {
        View view = (View)this.mView.get();
        if (view == null) return null;
        if (Build.VERSION.SDK_INT < 18) return null;
        return (Interpolator)view.animate().getInterpolator();
    }

    public long getStartDelay() {
        View view = (View)this.mView.get();
        if (view == null) return 0L;
        return view.animate().getStartDelay();
    }

    public ViewPropertyAnimatorCompat rotation(float f) {
        View view = (View)this.mView.get();
        if (view == null) return this;
        view.animate().rotation(f);
        return this;
    }

    public ViewPropertyAnimatorCompat rotationBy(float f) {
        View view = (View)this.mView.get();
        if (view == null) return this;
        view.animate().rotationBy(f);
        return this;
    }

    public ViewPropertyAnimatorCompat rotationX(float f) {
        View view = (View)this.mView.get();
        if (view == null) return this;
        view.animate().rotationX(f);
        return this;
    }

    public ViewPropertyAnimatorCompat rotationXBy(float f) {
        View view = (View)this.mView.get();
        if (view == null) return this;
        view.animate().rotationXBy(f);
        return this;
    }

    public ViewPropertyAnimatorCompat rotationY(float f) {
        View view = (View)this.mView.get();
        if (view == null) return this;
        view.animate().rotationY(f);
        return this;
    }

    public ViewPropertyAnimatorCompat rotationYBy(float f) {
        View view = (View)this.mView.get();
        if (view == null) return this;
        view.animate().rotationYBy(f);
        return this;
    }

    public ViewPropertyAnimatorCompat scaleX(float f) {
        View view = (View)this.mView.get();
        if (view == null) return this;
        view.animate().scaleX(f);
        return this;
    }

    public ViewPropertyAnimatorCompat scaleXBy(float f) {
        View view = (View)this.mView.get();
        if (view == null) return this;
        view.animate().scaleXBy(f);
        return this;
    }

    public ViewPropertyAnimatorCompat scaleY(float f) {
        View view = (View)this.mView.get();
        if (view == null) return this;
        view.animate().scaleY(f);
        return this;
    }

    public ViewPropertyAnimatorCompat scaleYBy(float f) {
        View view = (View)this.mView.get();
        if (view == null) return this;
        view.animate().scaleYBy(f);
        return this;
    }

    public ViewPropertyAnimatorCompat setDuration(long l) {
        View view = (View)this.mView.get();
        if (view == null) return this;
        view.animate().setDuration(l);
        return this;
    }

    public ViewPropertyAnimatorCompat setInterpolator(Interpolator interpolator) {
        View view = (View)this.mView.get();
        if (view == null) return this;
        view.animate().setInterpolator((TimeInterpolator)interpolator);
        return this;
    }

    public ViewPropertyAnimatorCompat setListener(ViewPropertyAnimatorListener viewPropertyAnimatorListener) {
        View view = (View)this.mView.get();
        if (view == null) return this;
        if (Build.VERSION.SDK_INT >= 16) {
            this.setListenerInternal(view, viewPropertyAnimatorListener);
        } else {
            view.setTag(0x7E000000, (Object)viewPropertyAnimatorListener);
            this.setListenerInternal(view, (ViewPropertyAnimatorListener)new ViewPropertyAnimatorListenerApi14(this));
        }
        return this;
    }

    public ViewPropertyAnimatorCompat setStartDelay(long l) {
        View view = (View)this.mView.get();
        if (view == null) return this;
        view.animate().setStartDelay(l);
        return this;
    }

    public ViewPropertyAnimatorCompat setUpdateListener(ViewPropertyAnimatorUpdateListener viewPropertyAnimatorUpdateListener) {
        View view = (View)this.mView.get();
        if (view == null) return this;
        if (Build.VERSION.SDK_INT < 19) return this;
        2 var2_3 = null;
        if (viewPropertyAnimatorUpdateListener != null) {
            var2_3 = new /* Unavailable Anonymous Inner Class!! */;
        }
        view.animate().setUpdateListener(var2_3);
        return this;
    }

    public void start() {
        View view = (View)this.mView.get();
        if (view == null) return;
        view.animate().start();
    }

    public ViewPropertyAnimatorCompat translationX(float f) {
        View view = (View)this.mView.get();
        if (view == null) return this;
        view.animate().translationX(f);
        return this;
    }

    public ViewPropertyAnimatorCompat translationXBy(float f) {
        View view = (View)this.mView.get();
        if (view == null) return this;
        view.animate().translationXBy(f);
        return this;
    }

    public ViewPropertyAnimatorCompat translationY(float f) {
        View view = (View)this.mView.get();
        if (view == null) return this;
        view.animate().translationY(f);
        return this;
    }

    public ViewPropertyAnimatorCompat translationYBy(float f) {
        View view = (View)this.mView.get();
        if (view == null) return this;
        view.animate().translationYBy(f);
        return this;
    }

    public ViewPropertyAnimatorCompat translationZ(float f) {
        View view = (View)this.mView.get();
        if (view == null) return this;
        if (Build.VERSION.SDK_INT < 21) return this;
        view.animate().translationZ(f);
        return this;
    }

    public ViewPropertyAnimatorCompat translationZBy(float f) {
        View view = (View)this.mView.get();
        if (view == null) return this;
        if (Build.VERSION.SDK_INT < 21) return this;
        view.animate().translationZBy(f);
        return this;
    }

    public ViewPropertyAnimatorCompat withEndAction(Runnable runnable) {
        View view = (View)this.mView.get();
        if (view == null) return this;
        if (Build.VERSION.SDK_INT >= 16) {
            view.animate().withEndAction(runnable);
        } else {
            this.setListenerInternal(view, (ViewPropertyAnimatorListener)new ViewPropertyAnimatorListenerApi14(this));
            this.mEndAction = runnable;
        }
        return this;
    }

    public ViewPropertyAnimatorCompat withLayer() {
        View view = (View)this.mView.get();
        if (view == null) return this;
        if (Build.VERSION.SDK_INT >= 16) {
            view.animate().withLayer();
        } else {
            this.mOldLayerType = view.getLayerType();
            this.setListenerInternal(view, (ViewPropertyAnimatorListener)new ViewPropertyAnimatorListenerApi14(this));
        }
        return this;
    }

    public ViewPropertyAnimatorCompat withStartAction(Runnable runnable) {
        View view = (View)this.mView.get();
        if (view == null) return this;
        if (Build.VERSION.SDK_INT >= 16) {
            view.animate().withStartAction(runnable);
        } else {
            this.setListenerInternal(view, (ViewPropertyAnimatorListener)new ViewPropertyAnimatorListenerApi14(this));
            this.mStartAction = runnable;
        }
        return this;
    }

    public ViewPropertyAnimatorCompat x(float f) {
        View view = (View)this.mView.get();
        if (view == null) return this;
        view.animate().x(f);
        return this;
    }

    public ViewPropertyAnimatorCompat xBy(float f) {
        View view = (View)this.mView.get();
        if (view == null) return this;
        view.animate().xBy(f);
        return this;
    }

    public ViewPropertyAnimatorCompat y(float f) {
        View view = (View)this.mView.get();
        if (view == null) return this;
        view.animate().y(f);
        return this;
    }

    public ViewPropertyAnimatorCompat yBy(float f) {
        View view = (View)this.mView.get();
        if (view == null) return this;
        view.animate().yBy(f);
        return this;
    }

    public ViewPropertyAnimatorCompat z(float f) {
        View view = (View)this.mView.get();
        if (view == null) return this;
        if (Build.VERSION.SDK_INT < 21) return this;
        view.animate().z(f);
        return this;
    }

    public ViewPropertyAnimatorCompat zBy(float f) {
        View view = (View)this.mView.get();
        if (view == null) return this;
        if (Build.VERSION.SDK_INT < 21) return this;
        view.animate().zBy(f);
        return this;
    }
}
