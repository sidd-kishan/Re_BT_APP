/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.impl.utils.ExifAttribute
 *  androidx.camera.core.impl.utils.ExifData
 *  androidx.camera.core.impl.utils.ExifData$Builder
 */
package androidx.camera.core.impl.utils;

import androidx.camera.core.impl.utils.ExifAttribute;
import androidx.camera.core.impl.utils.ExifData;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

class ExifData.Builder.2
implements Enumeration<Map<String, ExifAttribute>> {
    int mIfdIndex;
    final ExifData.Builder this$0;

    ExifData.Builder.2(ExifData.Builder builder) {
        this.this$0 = builder;
        this.mIfdIndex = 0;
    }

    @Override
    public boolean hasMoreElements() {
        boolean bl = this.mIfdIndex < ExifData.EXIF_TAGS.length;
        return bl;
    }

    @Override
    public Map<String, ExifAttribute> nextElement() {
        ++this.mIfdIndex;
        return new HashMap<String, ExifAttribute>();
    }
}
