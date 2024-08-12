/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.ViewParent
 *  androidx.core.view.ViewCompat
 *  androidx.core.view.ViewParentCompat
 */
package androidx.core.view;

import android.view.View;
import android.view.ViewParent;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewParentCompat;

public class NestedScrollingChildHelper {
    private boolean mIsNestedScrollingEnabled;
    private ViewParent mNestedScrollingParentNonTouch;
    private ViewParent mNestedScrollingParentTouch;
    private int[] mTempNestedScrollConsumed;
    private final View mView;

    public NestedScrollingChildHelper(View view) {
        this.mView = view;
    }

    private boolean dispatchNestedScrollInternal(int n, int n2, int n3, int n4, int[] nArray, int n5, int[] nArray2) {
        int n6;
        int n7;
        if (!this.isNestedScrollingEnabled()) return false;
        ViewParent viewParent = this.getNestedScrollingParentForType(n5);
        if (viewParent == null) {
            return false;
        }
        if (n == 0 && n2 == 0 && n3 == 0 && n4 == 0) {
            if (nArray == null) return false;
            nArray[0] = 0;
            nArray[1] = 0;
            return false;
        }
        if (nArray != null) {
            this.mView.getLocationInWindow(nArray);
            n7 = nArray[0];
            n6 = nArray[1];
        } else {
            n7 = 0;
            n6 = 0;
        }
        if (nArray2 == null) {
            nArray2 = this.getTempNestedScrollConsumed();
            nArray2[0] = 0;
            nArray2[1] = 0;
        }
        ViewParentCompat.onNestedScroll((ViewParent)viewParent, (View)this.mView, (int)n, (int)n2, (int)n3, (int)n4, (int)n5, (int[])nArray2);
        if (nArray == null) return true;
        this.mView.getLocationInWindow(nArray);
        nArray[0] = nArray[0] - n7;
        nArray[1] = nArray[1] - n6;
        return true;
    }

    private ViewParent getNestedScrollingParentForType(int n) {
        if (n == 0) return this.mNestedScrollingParentTouch;
        if (n == 1) return this.mNestedScrollingParentNonTouch;
        return null;
    }

    private int[] getTempNestedScrollConsumed() {
        if (this.mTempNestedScrollConsumed != null) return this.mTempNestedScrollConsumed;
        this.mTempNestedScrollConsumed = new int[2];
        return this.mTempNestedScrollConsumed;
    }

    private void setNestedScrollingParentForType(int n, ViewParent viewParent) {
        if (n != 0) {
            if (n != 1) return;
            this.mNestedScrollingParentNonTouch = viewParent;
        } else {
            this.mNestedScrollingParentTouch = viewParent;
        }
    }

    public boolean dispatchNestedFling(float f, float f2, boolean bl) {
        if (!this.isNestedScrollingEnabled()) return false;
        ViewParent viewParent = this.getNestedScrollingParentForType(0);
        if (viewParent == null) return false;
        return ViewParentCompat.onNestedFling((ViewParent)viewParent, (View)this.mView, (float)f, (float)f2, (boolean)bl);
    }

    public boolean dispatchNestedPreFling(float f, float f2) {
        if (!this.isNestedScrollingEnabled()) return false;
        ViewParent viewParent = this.getNestedScrollingParentForType(0);
        if (viewParent == null) return false;
        return ViewParentCompat.onNestedPreFling((ViewParent)viewParent, (View)this.mView, (float)f, (float)f2);
    }

    public boolean dispatchNestedPreScroll(int n, int n2, int[] nArray, int[] nArray2) {
        return this.dispatchNestedPreScroll(n, n2, nArray, nArray2, 0);
    }

    public boolean dispatchNestedPreScroll(int n, int n2, int[] nArray, int[] nArray2, int n3) {
        boolean bl;
        boolean bl2 = this.isNestedScrollingEnabled();
        boolean bl3 = bl = false;
        if (!bl2) return bl3;
        ViewParent viewParent = this.getNestedScrollingParentForType(n3);
        if (viewParent == null) {
            return false;
        }
        if (n == 0 && n2 == 0) {
            bl3 = bl;
            if (nArray2 == null) return bl3;
            nArray2[0] = 0;
            nArray2[1] = 0;
            bl3 = bl;
        } else {
            int n4;
            int n5;
            if (nArray2 != null) {
                this.mView.getLocationInWindow(nArray2);
                n5 = nArray2[0];
                n4 = nArray2[1];
            } else {
                n5 = 0;
                n4 = 0;
            }
            int[] nArray3 = nArray;
            if (nArray == null) {
                nArray3 = this.getTempNestedScrollConsumed();
            }
            nArray3[0] = 0;
            nArray3[1] = 0;
            ViewParentCompat.onNestedPreScroll((ViewParent)viewParent, (View)this.mView, (int)n, (int)n2, (int[])nArray3, (int)n3);
            if (nArray2 != null) {
                this.mView.getLocationInWindow(nArray2);
                nArray2[0] = nArray2[0] - n5;
                nArray2[1] = nArray2[1] - n4;
            }
            if (nArray3[0] == 0) {
                bl3 = bl;
                if (nArray3[1] == 0) return bl3;
            }
            bl3 = true;
        }
        return bl3;
    }

    public void dispatchNestedScroll(int n, int n2, int n3, int n4, int[] nArray, int n5, int[] nArray2) {
        this.dispatchNestedScrollInternal(n, n2, n3, n4, nArray, n5, nArray2);
    }

    public boolean dispatchNestedScroll(int n, int n2, int n3, int n4, int[] nArray) {
        return this.dispatchNestedScrollInternal(n, n2, n3, n4, nArray, 0, null);
    }

    public boolean dispatchNestedScroll(int n, int n2, int n3, int n4, int[] nArray, int n5) {
        return this.dispatchNestedScrollInternal(n, n2, n3, n4, nArray, n5, null);
    }

    public boolean hasNestedScrollingParent() {
        return this.hasNestedScrollingParent(0);
    }

    public boolean hasNestedScrollingParent(int n) {
        boolean bl = this.getNestedScrollingParentForType(n) != null;
        return bl;
    }

    public boolean isNestedScrollingEnabled() {
        return this.mIsNestedScrollingEnabled;
    }

    public void onDetachedFromWindow() {
        ViewCompat.stopNestedScroll((View)this.mView);
    }

    public void onStopNestedScroll(View view) {
        ViewCompat.stopNestedScroll((View)this.mView);
    }

    public void setNestedScrollingEnabled(boolean bl) {
        if (this.mIsNestedScrollingEnabled) {
            ViewCompat.stopNestedScroll((View)this.mView);
        }
        this.mIsNestedScrollingEnabled = bl;
    }

    public boolean startNestedScroll(int n) {
        return this.startNestedScroll(n, 0);
    }

    public boolean startNestedScroll(int n, int n2) {
        if (this.hasNestedScrollingParent(n2)) {
            return true;
        }
        if (!this.isNestedScrollingEnabled()) return false;
        ViewParent viewParent = this.mView.getParent();
        View view = this.mView;
        while (viewParent != null) {
            if (ViewParentCompat.onStartNestedScroll((ViewParent)viewParent, (View)view, (View)this.mView, (int)n, (int)n2)) {
                this.setNestedScrollingParentForType(n2, viewParent);
                ViewParentCompat.onNestedScrollAccepted((ViewParent)viewParent, (View)view, (View)this.mView, (int)n, (int)n2);
                return true;
            }
            if (viewParent instanceof View) {
                view = (View)viewParent;
            }
            viewParent = viewParent.getParent();
        }
        return false;
    }

    public void stopNestedScroll() {
        this.stopNestedScroll(0);
    }

    public void stopNestedScroll(int n) {
        ViewParent viewParent = this.getNestedScrollingParentForType(n);
        if (viewParent == null) return;
        ViewParentCompat.onStopNestedScroll((ViewParent)viewParent, (View)this.mView, (int)n);
        this.setNestedScrollingParentForType(n, null);
    }
}
