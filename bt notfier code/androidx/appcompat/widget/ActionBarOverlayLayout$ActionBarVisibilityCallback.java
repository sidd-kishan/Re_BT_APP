/*
 * Decompiled with CFR 0.152.
 */
package androidx.appcompat.widget;

public static interface ActionBarOverlayLayout.ActionBarVisibilityCallback {
    public void enableContentAnimations(boolean var1);

    public void hideForSystem();

    public void onContentScrollStarted();

    public void onContentScrollStopped();

    public void onWindowVisibilityChanged(int var1);

    public void showForSystem();
}
