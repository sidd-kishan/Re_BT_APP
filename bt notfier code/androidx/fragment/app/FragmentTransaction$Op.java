/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.fragment.app.Fragment
 *  androidx.lifecycle.Lifecycle$State
 */
package androidx.fragment.app;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;

static final class FragmentTransaction.Op {
    int mCmd;
    Lifecycle.State mCurrentMaxState;
    int mEnterAnim;
    int mExitAnim;
    Fragment mFragment;
    Lifecycle.State mOldMaxState;
    int mPopEnterAnim;
    int mPopExitAnim;

    FragmentTransaction.Op() {
    }

    FragmentTransaction.Op(int n, Fragment fragment) {
        this.mCmd = n;
        this.mFragment = fragment;
        this.mOldMaxState = Lifecycle.State.RESUMED;
        this.mCurrentMaxState = Lifecycle.State.RESUMED;
    }

    FragmentTransaction.Op(int n, Fragment fragment, Lifecycle.State state) {
        this.mCmd = n;
        this.mFragment = fragment;
        this.mOldMaxState = fragment.mMaxState;
        this.mCurrentMaxState = state;
    }
}
