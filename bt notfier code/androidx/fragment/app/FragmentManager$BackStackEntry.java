/*
 * Decompiled with CFR 0.152.
 */
package androidx.fragment.app;

public static interface FragmentManager.BackStackEntry {
    @Deprecated
    public CharSequence getBreadCrumbShortTitle();

    @Deprecated
    public int getBreadCrumbShortTitleRes();

    @Deprecated
    public CharSequence getBreadCrumbTitle();

    @Deprecated
    public int getBreadCrumbTitleRes();

    public int getId();

    public String getName();
}
