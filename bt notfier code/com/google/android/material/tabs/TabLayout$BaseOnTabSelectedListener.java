/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.material.tabs.TabLayout$Tab
 */
package com.google.android.material.tabs;

import com.google.android.material.tabs.TabLayout;

public static interface TabLayout.BaseOnTabSelectedListener<T extends TabLayout.Tab> {
    public void onTabReselected(T var1);

    public void onTabSelected(T var1);

    public void onTabUnselected(T var1);
}
