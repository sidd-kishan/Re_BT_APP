/*
 * Decompiled with CFR 0.152.
 */
package androidx.camera.core.impl.utils;

import java.text.SimpleDateFormat;
import java.util.Locale;

class Exif.1
extends ThreadLocal<SimpleDateFormat> {
    Exif.1() {
    }

    @Override
    public SimpleDateFormat initialValue() {
        return new SimpleDateFormat("yyyy:MM:dd", Locale.US);
    }
}
