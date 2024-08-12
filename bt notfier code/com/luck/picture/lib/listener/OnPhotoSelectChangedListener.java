/*
 * Decompiled with CFR 0.152.
 */
package com.luck.picture.lib.listener;

import java.util.List;

public interface OnPhotoSelectChangedListener<T> {
    public void onChange(List<T> var1);

    public void onPictureClick(T var1, int var2);

    public void onTakePhoto();
}
