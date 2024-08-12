/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  androidx.versionedparcelable.VersionedParcelable
 */
package androidx.media;

import android.os.Bundle;
import androidx.versionedparcelable.VersionedParcelable;

interface AudioAttributesImpl
extends VersionedParcelable {
    public Object getAudioAttributes();

    public int getContentType();

    public int getFlags();

    public int getLegacyStreamType();

    public int getRawLegacyStreamType();

    public int getUsage();

    public int getVolumeControlStream();

    public Bundle toBundle();
}
