/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  androidx.core.util.ObjectsCompat
 *  androidx.media.MediaSessionManager$RemoteUserInfoImpl
 */
package androidx.media;

import android.text.TextUtils;
import androidx.core.util.ObjectsCompat;
import androidx.media.MediaSessionManager;

static class MediaSessionManagerImplBase.RemoteUserInfoImplBase
implements MediaSessionManager.RemoteUserInfoImpl {
    private String mPackageName;
    private int mPid;
    private int mUid;

    MediaSessionManagerImplBase.RemoteUserInfoImplBase(String string, int n, int n2) {
        this.mPackageName = string;
        this.mPid = n;
        this.mUid = n2;
    }

    public boolean equals(Object object) {
        boolean bl = true;
        if (this == object) {
            return true;
        }
        if (!(object instanceof MediaSessionManagerImplBase.RemoteUserInfoImplBase)) {
            return false;
        }
        object = (MediaSessionManagerImplBase.RemoteUserInfoImplBase)object;
        if (TextUtils.equals((CharSequence)this.mPackageName, (CharSequence)((MediaSessionManagerImplBase.RemoteUserInfoImplBase)object).mPackageName) && this.mPid == ((MediaSessionManagerImplBase.RemoteUserInfoImplBase)object).mPid && this.mUid == ((MediaSessionManagerImplBase.RemoteUserInfoImplBase)object).mUid) return bl;
        bl = false;
        return bl;
    }

    public String getPackageName() {
        return this.mPackageName;
    }

    public int getPid() {
        return this.mPid;
    }

    public int getUid() {
        return this.mUid;
    }

    public int hashCode() {
        return ObjectsCompat.hash((Object[])new Object[]{this.mPackageName, this.mPid, this.mUid});
    }
}
