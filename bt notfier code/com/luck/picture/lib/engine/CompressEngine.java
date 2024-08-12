/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.luck.picture.lib.entity.LocalMedia
 *  com.luck.picture.lib.listener.OnCallbackListener
 */
package com.luck.picture.lib.engine;

import android.content.Context;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.listener.OnCallbackListener;
import java.util.List;

public interface CompressEngine {
    public void onCompress(Context var1, List<LocalMedia> var2, OnCallbackListener<List<LocalMedia>> var3);
}
