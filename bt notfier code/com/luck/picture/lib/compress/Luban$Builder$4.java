/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.luck.picture.lib.compress.InputStreamAdapter
 *  com.luck.picture.lib.compress.Luban$Builder
 *  com.luck.picture.lib.entity.LocalMedia
 */
package com.luck.picture.lib.compress;

import com.luck.picture.lib.compress.InputStreamAdapter;
import com.luck.picture.lib.compress.Luban;
import com.luck.picture.lib.entity.LocalMedia;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

class Luban.Builder.4
extends InputStreamAdapter {
    final Luban.Builder this$0;
    final String val$string;

    Luban.Builder.4(Luban.Builder builder, String string) {
        this.this$0 = builder;
        this.val$string = string;
    }

    public LocalMedia getMedia() {
        return null;
    }

    public String getPath() {
        return this.val$string;
    }

    public InputStream openInternal() throws IOException {
        return new FileInputStream(this.val$string);
    }
}
