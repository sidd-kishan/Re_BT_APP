/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.impl.Config$Option
 *  androidx.camera.core.impl.ReadableConfig
 */
package androidx.camera.core.impl;

import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.ReadableConfig;

public interface ImageInputConfig
extends ReadableConfig {
    public static final Config.Option<Integer> OPTION_INPUT_FORMAT = Config.Option.create((String)"camerax.core.imageInput.inputFormat", Integer.TYPE);

    public int getInputFormat();
}
