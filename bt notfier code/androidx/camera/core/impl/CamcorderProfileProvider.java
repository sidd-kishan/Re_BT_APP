/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.impl.CamcorderProfileProxy
 */
package androidx.camera.core.impl;

import androidx.camera.core.impl.CamcorderProfileProxy;

public interface CamcorderProfileProvider {
    public static final CamcorderProfileProvider EMPTY = new /* Unavailable Anonymous Inner Class!! */;

    public CamcorderProfileProxy get(int var1);

    public boolean hasProfile(int var1);
}
