/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.load.Options
 *  com.bumptech.glide.load.ResourceDecoder
 *  com.bumptech.glide.load.engine.Resource
 *  com.bumptech.glide.load.resource.file.FileResource
 */
package com.bumptech.glide.load.resource.file;

import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.file.FileResource;
import java.io.File;

public class FileDecoder
implements ResourceDecoder<File, File> {
    public Resource<File> decode(File file, int n, int n2, Options options) {
        return new FileResource(file);
    }

    public boolean handles(File file, Options options) {
        return true;
    }
}
