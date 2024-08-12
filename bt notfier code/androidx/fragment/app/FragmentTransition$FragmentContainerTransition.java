/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.fragment.app.BackStackRecord
 *  androidx.fragment.app.Fragment
 */
package androidx.fragment.app;

import androidx.fragment.app.BackStackRecord;
import androidx.fragment.app.Fragment;

static class FragmentTransition.FragmentContainerTransition {
    public Fragment firstOut;
    public boolean firstOutIsPop;
    public BackStackRecord firstOutTransaction;
    public Fragment lastIn;
    public boolean lastInIsPop;
    public BackStackRecord lastInTransaction;

    FragmentTransition.FragmentContainerTransition() {
    }
}
