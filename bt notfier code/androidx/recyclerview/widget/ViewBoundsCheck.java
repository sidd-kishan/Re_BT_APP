/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  androidx.recyclerview.widget.ViewBoundsCheck$BoundFlags
 *  androidx.recyclerview.widget.ViewBoundsCheck$Callback
 */
package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.ViewBoundsCheck;

class ViewBoundsCheck {
    static final int CVE_PVE_POS = 12;
    static final int CVE_PVS_POS = 8;
    static final int CVS_PVE_POS = 4;
    static final int CVS_PVS_POS = 0;
    static final int EQ = 2;
    static final int FLAG_CVE_EQ_PVE = 8192;
    static final int FLAG_CVE_EQ_PVS = 512;
    static final int FLAG_CVE_GT_PVE = 4096;
    static final int FLAG_CVE_GT_PVS = 256;
    static final int FLAG_CVE_LT_PVE = 16384;
    static final int FLAG_CVE_LT_PVS = 1024;
    static final int FLAG_CVS_EQ_PVE = 32;
    static final int FLAG_CVS_EQ_PVS = 2;
    static final int FLAG_CVS_GT_PVE = 16;
    static final int FLAG_CVS_GT_PVS = 1;
    static final int FLAG_CVS_LT_PVE = 64;
    static final int FLAG_CVS_LT_PVS = 4;
    static final int GT = 1;
    static final int LT = 4;
    static final int MASK = 7;
    BoundFlags mBoundFlags;
    final Callback mCallback;

    ViewBoundsCheck(Callback callback) {
        this.mCallback = callback;
        this.mBoundFlags = new BoundFlags();
    }

    View findOneViewWithinBoundFlags(int n, int n2, int n3, int n4) {
        int n5 = this.mCallback.getParentStart();
        int n6 = this.mCallback.getParentEnd();
        int n7 = n2 > n ? 1 : -1;
        View view = null;
        while (n != n2) {
            View view2 = this.mCallback.getChildAt(n);
            int n8 = this.mCallback.getChildStart(view2);
            int n9 = this.mCallback.getChildEnd(view2);
            this.mBoundFlags.setBounds(n5, n6, n8, n9);
            if (n3 != 0) {
                this.mBoundFlags.resetFlags();
                this.mBoundFlags.addFlags(n3);
                if (this.mBoundFlags.boundsMatch()) {
                    return view2;
                }
            }
            View view3 = view;
            if (n4 != 0) {
                this.mBoundFlags.resetFlags();
                this.mBoundFlags.addFlags(n4);
                view3 = view;
                if (this.mBoundFlags.boundsMatch()) {
                    view3 = view2;
                }
            }
            n += n7;
            view = view3;
        }
        return view;
    }

    boolean isViewWithinBoundFlags(View view, int n) {
        this.mBoundFlags.setBounds(this.mCallback.getParentStart(), this.mCallback.getParentEnd(), this.mCallback.getChildStart(view), this.mCallback.getChildEnd(view));
        if (n == 0) return false;
        this.mBoundFlags.resetFlags();
        this.mBoundFlags.addFlags(n);
        return this.mBoundFlags.boundsMatch();
    }
}
