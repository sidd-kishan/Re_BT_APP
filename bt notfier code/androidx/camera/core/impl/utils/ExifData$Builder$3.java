/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.impl.utils.ExifAttribute
 *  androidx.camera.core.impl.utils.ExifData$Builder
 */
package androidx.camera.core.impl.utils;

import androidx.camera.core.impl.utils.ExifAttribute;
import androidx.camera.core.impl.utils.ExifData;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

class ExifData.Builder.3
implements Enumeration<Map<String, ExifAttribute>> {
    final Enumeration<Map<String, ExifAttribute>> mMapEnumeration;
    final ExifData.Builder this$0;

    ExifData.Builder.3(ExifData.Builder builder) {
        this.this$0 = builder;
        this.mMapEnumeration = Collections.enumeration(this.this$0.mAttributes);
    }

    @Override
    public boolean hasMoreElements() {
        return this.mMapEnumeration.hasMoreElements();
    }

    @Override
    public Map<String, ExifAttribute> nextElement() {
        return new HashMap<String, ExifAttribute>(this.mMapEnumeration.nextElement());
    }
}
