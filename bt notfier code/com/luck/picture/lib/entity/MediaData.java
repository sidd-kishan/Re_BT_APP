/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.luck.picture.lib.entity.LocalMedia
 */
package com.luck.picture.lib.entity;

import com.luck.picture.lib.entity.LocalMedia;
import java.util.List;

public class MediaData {
    public List<LocalMedia> data;
    public boolean isHasNextMore;

    public MediaData() {
    }

    public MediaData(boolean bl, List<LocalMedia> list) {
        this.isHasNextMore = bl;
        this.data = list;
    }
}
