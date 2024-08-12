/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.luck.picture.lib.engine.PictureSelectorEngine
 */
package com.luck.picture.lib.app;

import android.content.Context;
import com.luck.picture.lib.engine.PictureSelectorEngine;

public interface IApp {
    public Context getAppContext();

    public PictureSelectorEngine getPictureSelectorEngine();
}
