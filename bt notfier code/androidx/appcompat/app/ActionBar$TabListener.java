/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.appcompat.app.ActionBar$Tab
 *  androidx.fragment.app.FragmentTransaction
 */
package androidx.appcompat.app;

import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.FragmentTransaction;

@Deprecated
public static interface ActionBar.TabListener {
    public void onTabReselected(ActionBar.Tab var1, FragmentTransaction var2);

    public void onTabSelected(ActionBar.Tab var1, FragmentTransaction var2);

    public void onTabUnselected(ActionBar.Tab var1, FragmentTransaction var2);
}
