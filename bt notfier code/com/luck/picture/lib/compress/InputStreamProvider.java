/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.luck.picture.lib.entity.LocalMedia
 */
package com.luck.picture.lib.compress;

import com.luck.picture.lib.entity.LocalMedia;
import java.io.IOException;
import java.io.InputStream;

public interface InputStreamProvider {
    public void close();

    public LocalMedia getMedia();

    public String getPath();

    public InputStream open() throws IOException;
}
