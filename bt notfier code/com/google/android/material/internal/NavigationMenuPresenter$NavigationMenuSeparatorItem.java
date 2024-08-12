/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.material.internal.NavigationMenuPresenter$NavigationMenuItem
 */
package com.google.android.material.internal;

import com.google.android.material.internal.NavigationMenuPresenter;

private static class NavigationMenuPresenter.NavigationMenuSeparatorItem
implements NavigationMenuPresenter.NavigationMenuItem {
    private final int paddingBottom;
    private final int paddingTop;

    public NavigationMenuPresenter.NavigationMenuSeparatorItem(int n, int n2) {
        this.paddingTop = n;
        this.paddingBottom = n2;
    }

    public int getPaddingBottom() {
        return this.paddingBottom;
    }

    public int getPaddingTop() {
        return this.paddingTop;
    }
}
