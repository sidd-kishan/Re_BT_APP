/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.core.view.NestedScrollingChild
 */
package androidx.core.view;

import androidx.core.view.NestedScrollingChild;

public interface NestedScrollingChild2
extends NestedScrollingChild {
    public boolean dispatchNestedPreScroll(int var1, int var2, int[] var3, int[] var4, int var5);

    public boolean dispatchNestedScroll(int var1, int var2, int var3, int var4, int[] var5, int var6);

    public boolean hasNestedScrollingParent(int var1);

    public boolean startNestedScroll(int var1, int var2);

    public void stopNestedScroll(int var1);
}
