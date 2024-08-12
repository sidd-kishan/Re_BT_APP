/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.luck.picture.lib.entity.LocalMedia
 */
package com.luck.picture.lib.compress;

import com.luck.picture.lib.entity.LocalMedia;
import java.util.List;

public interface OnCompressListener {
    public void onError(Throwable var1);

    public void onStart();

    public void onSuccess(List<LocalMedia> var1);
}
