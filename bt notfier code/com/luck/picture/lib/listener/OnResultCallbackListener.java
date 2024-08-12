/*
 * Decompiled with CFR 0.152.
 */
package com.luck.picture.lib.listener;

import java.util.List;

public interface OnResultCallbackListener<T> {
    public void onCancel();

    public void onResult(List<T> var1);
}
