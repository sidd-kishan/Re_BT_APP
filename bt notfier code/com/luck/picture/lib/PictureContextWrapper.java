/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.ContextWrapper
 *  com.luck.picture.lib.language.PictureLanguageUtils
 */
package com.luck.picture.lib;

import android.content.Context;
import android.content.ContextWrapper;
import com.luck.picture.lib.language.PictureLanguageUtils;

public class PictureContextWrapper
extends ContextWrapper {
    public PictureContextWrapper(Context context) {
        super(context);
    }

    public static ContextWrapper wrap(Context context, int n) {
        PictureLanguageUtils.setAppLanguage((Context)context, (int)n);
        return new PictureContextWrapper(context);
    }
}
