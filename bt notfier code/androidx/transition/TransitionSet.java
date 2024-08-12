/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.TimeInterpolator
 *  android.content.Context
 *  android.content.res.TypedArray
 *  android.util.AndroidRuntimeException
 *  android.view.View
 *  android.view.ViewGroup
 *  androidx.core.content.res.TypedArrayUtils
 *  androidx.transition.PathMotion
 *  androidx.transition.Styleable
 *  androidx.transition.Transition
 *  androidx.transition.Transition$EpicenterCallback
 *  androidx.transition.Transition$TransitionListener
 *  androidx.transition.TransitionPropagation
 *  androidx.transition.TransitionSet$TransitionSetListener
 *  androidx.transition.TransitionValues
 *  androidx.transition.TransitionValuesMaps
 */
package androidx.transition;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.res.TypedArrayUtils;
import androidx.transition.PathMotion;
import androidx.transition.Styleable;
import androidx.transition.Transition;
import androidx.transition.TransitionPropagation;
import androidx.transition.TransitionSet;
import androidx.transition.TransitionValues;
import androidx.transition.TransitionValuesMaps;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;

public class TransitionSet
extends Transition {
    private static final int FLAG_CHANGE_EPICENTER = 8;
    private static final int FLAG_CHANGE_INTERPOLATOR = 1;
    private static final int FLAG_CHANGE_PATH_MOTION = 4;
    private static final int FLAG_CHANGE_PROPAGATION = 2;
    public static final int ORDERING_SEQUENTIAL = 1;
    public static final int ORDERING_TOGETHER = 0;
    private int mChangeFlags = 0;
    int mCurrentListeners;
    private boolean mPlayTogether = true;
    boolean mStarted = false;
    private ArrayList<Transition> mTransitions = new ArrayList();

    public TransitionSet() {
    }

    public TransitionSet(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        context = context.obtainStyledAttributes(attributeSet, Styleable.TRANSITION_SET);
        this.setOrdering(TypedArrayUtils.getNamedInt((TypedArray)context, (XmlPullParser)((XmlResourceParser)attributeSet), (String)"transitionOrdering", (int)0, (int)0));
        context.recycle();
    }

    private void addTransitionInternal(Transition transition) {
        this.mTransitions.add(transition);
        transition.mParent = this;
    }

    private void setupStartEndListeners() {
        TransitionSetListener transitionSetListener = new TransitionSetListener(this);
        Iterator<Transition> iterator = this.mTransitions.iterator();
        while (true) {
            if (!iterator.hasNext()) {
                this.mCurrentListeners = this.mTransitions.size();
                return;
            }
            iterator.next().addListener((Transition.TransitionListener)transitionSetListener);
        }
    }

    public TransitionSet addListener(Transition.TransitionListener transitionListener) {
        return (TransitionSet)super.addListener(transitionListener);
    }

    public TransitionSet addTarget(int n) {
        int n2 = 0;
        while (n2 < this.mTransitions.size()) {
            this.mTransitions.get(n2).addTarget(n);
            ++n2;
        }
        return (TransitionSet)super.addTarget(n);
    }

    public TransitionSet addTarget(View view) {
        int n = 0;
        while (n < this.mTransitions.size()) {
            this.mTransitions.get(n).addTarget(view);
            ++n;
        }
        return (TransitionSet)super.addTarget(view);
    }

    public TransitionSet addTarget(Class<?> clazz) {
        int n = 0;
        while (n < this.mTransitions.size()) {
            this.mTransitions.get(n).addTarget(clazz);
            ++n;
        }
        return (TransitionSet)super.addTarget(clazz);
    }

    public TransitionSet addTarget(String string) {
        int n = 0;
        while (n < this.mTransitions.size()) {
            this.mTransitions.get(n).addTarget(string);
            ++n;
        }
        return (TransitionSet)super.addTarget(string);
    }

    public TransitionSet addTransition(Transition transition) {
        this.addTransitionInternal(transition);
        if (this.mDuration >= 0L) {
            transition.setDuration(this.mDuration);
        }
        if ((this.mChangeFlags & 1) != 0) {
            transition.setInterpolator(this.getInterpolator());
        }
        if ((this.mChangeFlags & 2) != 0) {
            transition.setPropagation(this.getPropagation());
        }
        if ((this.mChangeFlags & 4) != 0) {
            transition.setPathMotion(this.getPathMotion());
        }
        if ((this.mChangeFlags & 8) == 0) return this;
        transition.setEpicenterCallback(this.getEpicenterCallback());
        return this;
    }

    protected void cancel() {
        super.cancel();
        int n = this.mTransitions.size();
        int n2 = 0;
        while (n2 < n) {
            this.mTransitions.get(n2).cancel();
            ++n2;
        }
    }

    public void captureEndValues(TransitionValues transitionValues) {
        if (!this.isValidTarget(transitionValues.view)) return;
        Iterator<Transition> iterator = this.mTransitions.iterator();
        while (iterator.hasNext()) {
            Transition transition = iterator.next();
            if (!transition.isValidTarget(transitionValues.view)) continue;
            transition.captureEndValues(transitionValues);
            transitionValues.mTargetedTransitions.add(transition);
        }
    }

    void capturePropagationValues(TransitionValues transitionValues) {
        super.capturePropagationValues(transitionValues);
        int n = this.mTransitions.size();
        int n2 = 0;
        while (n2 < n) {
            this.mTransitions.get(n2).capturePropagationValues(transitionValues);
            ++n2;
        }
    }

    public void captureStartValues(TransitionValues transitionValues) {
        if (!this.isValidTarget(transitionValues.view)) return;
        Iterator<Transition> iterator = this.mTransitions.iterator();
        while (iterator.hasNext()) {
            Transition transition = iterator.next();
            if (!transition.isValidTarget(transitionValues.view)) continue;
            transition.captureStartValues(transitionValues);
            transitionValues.mTargetedTransitions.add(transition);
        }
    }

    public Transition clone() {
        TransitionSet transitionSet = (TransitionSet)super.clone();
        transitionSet.mTransitions = new ArrayList();
        int n = this.mTransitions.size();
        int n2 = 0;
        while (n2 < n) {
            transitionSet.addTransitionInternal(this.mTransitions.get(n2).clone());
            ++n2;
        }
        return transitionSet;
    }

    protected void createAnimators(ViewGroup viewGroup, TransitionValuesMaps transitionValuesMaps, TransitionValuesMaps transitionValuesMaps2, ArrayList<TransitionValues> arrayList, ArrayList<TransitionValues> arrayList2) {
        long l = this.getStartDelay();
        int n = this.mTransitions.size();
        int n2 = 0;
        while (n2 < n) {
            Transition transition = this.mTransitions.get(n2);
            if (l > 0L && (this.mPlayTogether || n2 == 0)) {
                long l2 = transition.getStartDelay();
                if (l2 > 0L) {
                    transition.setStartDelay(l2 + l);
                } else {
                    transition.setStartDelay(l);
                }
            }
            transition.createAnimators(viewGroup, transitionValuesMaps, transitionValuesMaps2, arrayList, arrayList2);
            ++n2;
        }
    }

    public Transition excludeTarget(int n, boolean bl) {
        int n2 = 0;
        while (n2 < this.mTransitions.size()) {
            this.mTransitions.get(n2).excludeTarget(n, bl);
            ++n2;
        }
        return super.excludeTarget(n, bl);
    }

    public Transition excludeTarget(View view, boolean bl) {
        int n = 0;
        while (n < this.mTransitions.size()) {
            this.mTransitions.get(n).excludeTarget(view, bl);
            ++n;
        }
        return super.excludeTarget(view, bl);
    }

    public Transition excludeTarget(Class<?> clazz, boolean bl) {
        int n = 0;
        while (n < this.mTransitions.size()) {
            this.mTransitions.get(n).excludeTarget(clazz, bl);
            ++n;
        }
        return super.excludeTarget(clazz, bl);
    }

    public Transition excludeTarget(String string, boolean bl) {
        int n = 0;
        while (n < this.mTransitions.size()) {
            this.mTransitions.get(n).excludeTarget(string, bl);
            ++n;
        }
        return super.excludeTarget(string, bl);
    }

    void forceToEnd(ViewGroup viewGroup) {
        super.forceToEnd(viewGroup);
        int n = this.mTransitions.size();
        int n2 = 0;
        while (n2 < n) {
            this.mTransitions.get(n2).forceToEnd(viewGroup);
            ++n2;
        }
    }

    public int getOrdering() {
        return this.mPlayTogether ^ 1;
    }

    public Transition getTransitionAt(int n) {
        if (n < 0) return null;
        if (n < this.mTransitions.size()) return this.mTransitions.get(n);
        return null;
    }

    public int getTransitionCount() {
        return this.mTransitions.size();
    }

    public void pause(View view) {
        super.pause(view);
        int n = this.mTransitions.size();
        int n2 = 0;
        while (n2 < n) {
            this.mTransitions.get(n2).pause(view);
            ++n2;
        }
    }

    public TransitionSet removeListener(Transition.TransitionListener transitionListener) {
        return (TransitionSet)super.removeListener(transitionListener);
    }

    public TransitionSet removeTarget(int n) {
        int n2 = 0;
        while (n2 < this.mTransitions.size()) {
            this.mTransitions.get(n2).removeTarget(n);
            ++n2;
        }
        return (TransitionSet)super.removeTarget(n);
    }

    public TransitionSet removeTarget(View view) {
        int n = 0;
        while (n < this.mTransitions.size()) {
            this.mTransitions.get(n).removeTarget(view);
            ++n;
        }
        return (TransitionSet)super.removeTarget(view);
    }

    public TransitionSet removeTarget(Class<?> clazz) {
        int n = 0;
        while (n < this.mTransitions.size()) {
            this.mTransitions.get(n).removeTarget(clazz);
            ++n;
        }
        return (TransitionSet)super.removeTarget(clazz);
    }

    public TransitionSet removeTarget(String string) {
        int n = 0;
        while (n < this.mTransitions.size()) {
            this.mTransitions.get(n).removeTarget(string);
            ++n;
        }
        return (TransitionSet)super.removeTarget(string);
    }

    public TransitionSet removeTransition(Transition transition) {
        this.mTransitions.remove(transition);
        transition.mParent = null;
        return this;
    }

    public void resume(View view) {
        super.resume(view);
        int n = this.mTransitions.size();
        int n2 = 0;
        while (n2 < n) {
            this.mTransitions.get(n2).resume(view);
            ++n2;
        }
    }

    protected void runAnimators() {
        if (this.mTransitions.isEmpty()) {
            this.start();
            this.end();
            return;
        }
        this.setupStartEndListeners();
        if (!this.mPlayTogether) {
            int n = 1;
            while (true) {
                if (n >= this.mTransitions.size()) {
                    Transition transition = this.mTransitions.get(0);
                    if (transition == null) return;
                    transition.runAnimators();
                    return;
                }
                this.mTransitions.get(n - 1).addListener((Transition.TransitionListener)new /* Unavailable Anonymous Inner Class!! */);
                ++n;
            }
        }
        Iterator<Transition> iterator = this.mTransitions.iterator();
        while (iterator.hasNext()) {
            iterator.next().runAnimators();
        }
    }

    void setCanRemoveViews(boolean bl) {
        super.setCanRemoveViews(bl);
        int n = this.mTransitions.size();
        int n2 = 0;
        while (n2 < n) {
            this.mTransitions.get(n2).setCanRemoveViews(bl);
            ++n2;
        }
    }

    public TransitionSet setDuration(long l) {
        super.setDuration(l);
        if (this.mDuration < 0L) return this;
        ArrayList<Transition> arrayList = this.mTransitions;
        if (arrayList == null) return this;
        int n = arrayList.size();
        int n2 = 0;
        while (n2 < n) {
            this.mTransitions.get(n2).setDuration(l);
            ++n2;
        }
        return this;
    }

    public void setEpicenterCallback(Transition.EpicenterCallback epicenterCallback) {
        super.setEpicenterCallback(epicenterCallback);
        this.mChangeFlags |= 8;
        int n = this.mTransitions.size();
        int n2 = 0;
        while (n2 < n) {
            this.mTransitions.get(n2).setEpicenterCallback(epicenterCallback);
            ++n2;
        }
    }

    public TransitionSet setInterpolator(TimeInterpolator timeInterpolator) {
        this.mChangeFlags |= 1;
        ArrayList<Transition> arrayList = this.mTransitions;
        if (arrayList == null) return (TransitionSet)super.setInterpolator(timeInterpolator);
        int n = arrayList.size();
        int n2 = 0;
        while (n2 < n) {
            this.mTransitions.get(n2).setInterpolator(timeInterpolator);
            ++n2;
        }
        return (TransitionSet)super.setInterpolator(timeInterpolator);
    }

    public TransitionSet setOrdering(int n) {
        if (n != 0) {
            if (n != 1) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Invalid parameter for TransitionSet ordering: ");
                stringBuilder.append(n);
                throw new AndroidRuntimeException(stringBuilder.toString());
            }
            this.mPlayTogether = false;
        } else {
            this.mPlayTogether = true;
        }
        return this;
    }

    public void setPathMotion(PathMotion pathMotion) {
        super.setPathMotion(pathMotion);
        this.mChangeFlags |= 4;
        if (this.mTransitions == null) return;
        int n = 0;
        while (n < this.mTransitions.size()) {
            this.mTransitions.get(n).setPathMotion(pathMotion);
            ++n;
        }
    }

    public void setPropagation(TransitionPropagation transitionPropagation) {
        super.setPropagation(transitionPropagation);
        this.mChangeFlags |= 2;
        int n = this.mTransitions.size();
        int n2 = 0;
        while (n2 < n) {
            this.mTransitions.get(n2).setPropagation(transitionPropagation);
            ++n2;
        }
    }

    public TransitionSet setStartDelay(long l) {
        return (TransitionSet)super.setStartDelay(l);
    }

    String toString(String string) {
        CharSequence charSequence = super.toString(string);
        int n = 0;
        while (n < this.mTransitions.size()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append((String)charSequence);
            stringBuilder.append("\n");
            Transition transition = this.mTransitions.get(n);
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append(string);
            ((StringBuilder)charSequence).append("  ");
            stringBuilder.append(transition.toString(((StringBuilder)charSequence).toString()));
            charSequence = stringBuilder.toString();
            ++n;
        }
        return charSequence;
    }
}
