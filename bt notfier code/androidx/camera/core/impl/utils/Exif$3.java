/*
 * Decompiled with CFR 0.152.
 */
package androidx.camera.core.impl.utils;

import java.text.SimpleDateFormat;
import java.util.Locale;

class Exif.3
extends ThreadLocal<SimpleDateFormat> {
    Exif.3() {
    }

    @Override
    public SimpleDateFormat initialValue() {
        return new SimpleDateFormat("yyyy:MM:dd HH:mm:ss", Locale.US);
    }
}
