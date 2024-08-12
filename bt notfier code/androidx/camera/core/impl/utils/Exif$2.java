/*
 * Decompiled with CFR 0.152.
 */
package androidx.camera.core.impl.utils;

import java.text.SimpleDateFormat;
import java.util.Locale;

class Exif.2
extends ThreadLocal<SimpleDateFormat> {
    Exif.2() {
    }

    @Override
    public SimpleDateFormat initialValue() {
        return new SimpleDateFormat("HH:mm:ss", Locale.US);
    }
}
