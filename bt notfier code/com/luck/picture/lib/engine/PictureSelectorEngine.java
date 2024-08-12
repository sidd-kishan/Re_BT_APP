/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.luck.picture.lib.engine.ImageEngine
 *  com.luck.picture.lib.entity.LocalMedia
 *  com.luck.picture.lib.listener.OnResultCallbackListener
 */
package com.luck.picture.lib.engine;

import com.luck.picture.lib.engine.ImageEngine;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.listener.OnResultCallbackListener;

public interface PictureSelectorEngine {
    public ImageEngine createEngine();

    public OnResultCallbackListener<LocalMedia> getResultCallbackListener();
}
