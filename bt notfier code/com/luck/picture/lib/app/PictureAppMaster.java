/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.luck.picture.lib.app.IApp
 *  com.luck.picture.lib.engine.PictureSelectorEngine
 */
package com.luck.picture.lib.app;

import android.content.Context;
import com.luck.picture.lib.app.IApp;
import com.luck.picture.lib.engine.PictureSelectorEngine;

public class PictureAppMaster
implements IApp {
    private static PictureAppMaster mInstance;
    private IApp app;

    private PictureAppMaster() {
    }

    public static PictureAppMaster getInstance() {
        if (mInstance != null) return mInstance;
        synchronized (PictureAppMaster.class) {
            PictureAppMaster pictureAppMaster;
            if (mInstance != null) return mInstance;
            mInstance = pictureAppMaster = new PictureAppMaster();
        }
        return mInstance;
    }

    public IApp getApp() {
        return this.app;
    }

    public Context getAppContext() {
        IApp iApp = this.app;
        if (iApp != null) return iApp.getAppContext();
        return null;
    }

    public PictureSelectorEngine getPictureSelectorEngine() {
        IApp iApp = this.app;
        if (iApp != null) return iApp.getPictureSelectorEngine();
        return null;
    }

    public void setApp(IApp iApp) {
        this.app = iApp;
    }
}
