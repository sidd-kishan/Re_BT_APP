/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.luck.picture.lib.entity.LocalMedia
 */
package com.luck.picture.lib.observable;

import com.luck.picture.lib.entity.LocalMedia;
import java.util.ArrayList;
import java.util.List;

public class ImagesObservable {
    private static ImagesObservable sObserver;
    private List<LocalMedia> mData = new ArrayList<LocalMedia>();

    public static ImagesObservable getInstance() {
        if (sObserver != null) return sObserver;
        synchronized (ImagesObservable.class) {
            ImagesObservable imagesObservable;
            if (sObserver != null) return sObserver;
            sObserver = imagesObservable = new ImagesObservable();
        }
        return sObserver;
    }

    public void clearPreviewMediaData() {
        this.mData.clear();
    }

    public List<LocalMedia> readPreviewMediaData() {
        return this.mData;
    }

    public void savePreviewMediaData(List<LocalMedia> list) {
        this.mData = list;
    }
}
