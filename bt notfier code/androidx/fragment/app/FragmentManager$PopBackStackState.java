/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.fragment.app.BackStackRecord
 *  androidx.fragment.app.FragmentManager
 *  androidx.fragment.app.FragmentManager$OpGenerator
 */
package androidx.fragment.app;

import androidx.fragment.app.BackStackRecord;
import androidx.fragment.app.FragmentManager;
import java.util.ArrayList;

private class FragmentManager.PopBackStackState
implements FragmentManager.OpGenerator {
    final int mFlags;
    final int mId;
    final String mName;
    final FragmentManager this$0;

    FragmentManager.PopBackStackState(FragmentManager fragmentManager, String string, int n, int n2) {
        this.this$0 = fragmentManager;
        this.mName = string;
        this.mId = n;
        this.mFlags = n2;
    }

    public boolean generateOps(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2) {
        if (this.this$0.mPrimaryNav == null) return this.this$0.popBackStackState(arrayList, arrayList2, this.mName, this.mId, this.mFlags);
        if (this.mId >= 0) return this.this$0.popBackStackState(arrayList, arrayList2, this.mName, this.mId, this.mFlags);
        if (this.mName != null) return this.this$0.popBackStackState(arrayList, arrayList2, this.mName, this.mId, this.mFlags);
        if (!this.this$0.mPrimaryNav.getChildFragmentManager().popBackStackImmediate()) return this.this$0.popBackStackState(arrayList, arrayList2, this.mName, this.mId, this.mFlags);
        return false;
    }
}
