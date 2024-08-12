/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.fragment.app.BackStackRecord
 *  androidx.fragment.app.Fragment
 *  androidx.fragment.app.Fragment$OnStartEnterTransitionListener
 */
package androidx.fragment.app;

import androidx.fragment.app.BackStackRecord;
import androidx.fragment.app.Fragment;
import java.util.Iterator;

static class FragmentManager.StartEnterTransitionListener
implements Fragment.OnStartEnterTransitionListener {
    final boolean mIsBack;
    private int mNumPostponed;
    final BackStackRecord mRecord;

    FragmentManager.StartEnterTransitionListener(BackStackRecord backStackRecord, boolean bl) {
        this.mIsBack = bl;
        this.mRecord = backStackRecord;
    }

    void cancelTransaction() {
        this.mRecord.mManager.completeExecute(this.mRecord, this.mIsBack, false, false);
    }

    void completeTransaction() {
        boolean bl = this.mNumPostponed > 0;
        Iterator iterator = this.mRecord.mManager.getFragments().iterator();
        while (true) {
            if (!iterator.hasNext()) {
                this.mRecord.mManager.completeExecute(this.mRecord, this.mIsBack, bl ^ true, true);
                return;
            }
            Fragment fragment = (Fragment)iterator.next();
            fragment.setOnStartEnterTransitionListener(null);
            if (!bl || !fragment.isPostponed()) continue;
            fragment.startPostponedEnterTransition();
        }
    }

    public boolean isReady() {
        boolean bl = this.mNumPostponed == 0;
        return bl;
    }

    public void onStartEnterTransition() {
        int n;
        this.mNumPostponed = n = this.mNumPostponed - 1;
        if (n != 0) {
            return;
        }
        this.mRecord.mManager.scheduleCommit();
    }

    public void startListening() {
        ++this.mNumPostponed;
    }
}
