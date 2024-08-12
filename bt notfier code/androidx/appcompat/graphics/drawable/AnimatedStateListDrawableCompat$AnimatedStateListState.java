/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.res.Resources
 *  android.graphics.drawable.Drawable
 *  android.util.StateSet
 *  androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat
 *  androidx.appcompat.graphics.drawable.StateListDrawable
 *  androidx.appcompat.graphics.drawable.StateListDrawable$StateListState
 *  androidx.collection.LongSparseArray
 *  androidx.collection.SparseArrayCompat
 */
package androidx.appcompat.graphics.drawable;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.StateSet;
import androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat;
import androidx.appcompat.graphics.drawable.StateListDrawable;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;

static class AnimatedStateListDrawableCompat.AnimatedStateListState
extends StateListDrawable.StateListState {
    private static final long REVERSED_BIT = 0x100000000L;
    private static final long REVERSIBLE_FLAG_BIT = 0x200000000L;
    SparseArrayCompat<Integer> mStateIds;
    LongSparseArray<Long> mTransitions;

    AnimatedStateListDrawableCompat.AnimatedStateListState(AnimatedStateListDrawableCompat.AnimatedStateListState animatedStateListState, AnimatedStateListDrawableCompat animatedStateListDrawableCompat, Resources resources) {
        super((StateListDrawable.StateListState)animatedStateListState, (StateListDrawable)animatedStateListDrawableCompat, resources);
        if (animatedStateListState != null) {
            this.mTransitions = animatedStateListState.mTransitions;
            this.mStateIds = animatedStateListState.mStateIds;
        } else {
            this.mTransitions = new LongSparseArray();
            this.mStateIds = new SparseArrayCompat();
        }
    }

    private static long generateTransitionKey(int n, int n2) {
        long l = n;
        return (long)n2 | l << 32;
    }

    int addStateSet(int[] nArray, Drawable drawable, int n) {
        int n2 = super.addStateSet(nArray, drawable);
        this.mStateIds.put(n2, (Object)n);
        return n2;
    }

    int addTransition(int n, int n2, Drawable longSparseArray, boolean bl) {
        int n3 = super.addChild((Drawable)longSparseArray);
        long l = AnimatedStateListDrawableCompat.AnimatedStateListState.generateTransitionKey(n, n2);
        long l2 = bl ? 0x200000000L : 0L;
        longSparseArray = this.mTransitions;
        long l3 = n3;
        longSparseArray.append(l, (Object)(l3 | l2));
        if (!bl) return n3;
        l = AnimatedStateListDrawableCompat.AnimatedStateListState.generateTransitionKey(n2, n);
        this.mTransitions.append(l, (Object)(0x100000000L | l3 | l2));
        return n3;
    }

    int getKeyframeIdAt(int n) {
        int n2 = 0;
        n = n < 0 ? n2 : (Integer)this.mStateIds.get(n, (Object)0);
        return n;
    }

    int indexOfKeyframe(int[] nArray) {
        int n = super.indexOfStateSet(nArray);
        if (n < 0) return super.indexOfStateSet(StateSet.WILD_CARD);
        return n;
    }

    int indexOfTransition(int n, int n2) {
        long l = AnimatedStateListDrawableCompat.AnimatedStateListState.generateTransitionKey(n, n2);
        return (int)((Long)this.mTransitions.get(l, (Object)-1L)).longValue();
    }

    boolean isTransitionReversed(int n, int n2) {
        long l = AnimatedStateListDrawableCompat.AnimatedStateListState.generateTransitionKey(n, n2);
        boolean bl = ((Long)this.mTransitions.get(l, (Object)-1L) & 0x100000000L) != 0L;
        return bl;
    }

    void mutate() {
        this.mTransitions = this.mTransitions.clone();
        this.mStateIds = this.mStateIds.clone();
    }

    public Drawable newDrawable() {
        return new AnimatedStateListDrawableCompat(this, null);
    }

    public Drawable newDrawable(Resources resources) {
        return new AnimatedStateListDrawableCompat(this, resources);
    }

    boolean transitionHasReversibleFlag(int n, int n2) {
        long l = AnimatedStateListDrawableCompat.AnimatedStateListState.generateTransitionKey(n, n2);
        boolean bl = ((Long)this.mTransitions.get(l, (Object)-1L) & 0x200000000L) != 0L;
        return bl;
    }
}
