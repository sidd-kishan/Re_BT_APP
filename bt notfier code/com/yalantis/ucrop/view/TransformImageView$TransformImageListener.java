/*
 * Decompiled with CFR 0.152.
 */
package com.yalantis.ucrop.view;

public static interface TransformImageView.TransformImageListener {
    public void onLoadComplete();

    public void onLoadFailure(Exception var1);

    public void onRotate(float var1);

    public void onScale(float var1);
}
