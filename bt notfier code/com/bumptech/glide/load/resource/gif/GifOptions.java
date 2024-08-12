/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.load.DecodeFormat
 *  com.bumptech.glide.load.Option
 */
package com.bumptech.glide.load.resource.gif;

import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.Option;

public final class GifOptions {
    public static final Option<DecodeFormat> DECODE_FORMAT = Option.memory((String)"com.bumptech.glide.load.resource.gif.GifOptions.DecodeFormat", (Object)DecodeFormat.DEFAULT);
    public static final Option<Boolean> DISABLE_ANIMATION = Option.memory((String)"com.bumptech.glide.load.resource.gif.GifOptions.DisableAnimation", (Object)false);

    private GifOptions() {
    }
}
