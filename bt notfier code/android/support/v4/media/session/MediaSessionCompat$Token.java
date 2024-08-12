/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  android.support.v4.media.session.IMediaSession
 *  android.support.v4.media.session.IMediaSession$Stub
 *  android.support.v4.media.session.MediaSessionCompatApi21
 *  androidx.core.app.BundleCompat
 */
package android.support.v4.media.session;

import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.session.IMediaSession;
import android.support.v4.media.session.MediaSessionCompatApi21;
import androidx.core.app.BundleCompat;

public static final class MediaSessionCompat.Token
implements Parcelable {
    public static final Parcelable.Creator<MediaSessionCompat.Token> CREATOR = new /* Unavailable Anonymous Inner Class!! */;
    private IMediaSession mExtraBinder;
    private final Object mInner;
    private Bundle mSessionToken2Bundle;

    MediaSessionCompat.Token(Object object) {
        this(object, null, null);
    }

    MediaSessionCompat.Token(Object object, IMediaSession iMediaSession) {
        this(object, iMediaSession, null);
    }

    MediaSessionCompat.Token(Object object, IMediaSession iMediaSession, Bundle bundle) {
        this.mInner = object;
        this.mExtraBinder = iMediaSession;
        this.mSessionToken2Bundle = bundle;
    }

    public static MediaSessionCompat.Token fromBundle(Bundle object) {
        Object var1_1 = null;
        if (object == null) {
            return null;
        }
        IMediaSession iMediaSession = IMediaSession.Stub.asInterface((IBinder)BundleCompat.getBinder((Bundle)object, (String)"android.support.v4.media.session.EXTRA_BINDER"));
        Bundle bundle = object.getBundle("android.support.v4.media.session.SESSION_TOKEN2_BUNDLE");
        object = (object = (MediaSessionCompat.Token)object.getParcelable("android.support.v4.media.session.TOKEN")) == null ? var1_1 : new MediaSessionCompat.Token(object.mInner, iMediaSession, bundle);
        return object;
    }

    public static MediaSessionCompat.Token fromToken(Object object) {
        return MediaSessionCompat.Token.fromToken(object, null);
    }

    public static MediaSessionCompat.Token fromToken(Object object, IMediaSession iMediaSession) {
        if (object == null) return null;
        if (Build.VERSION.SDK_INT < 21) return null;
        return new MediaSessionCompat.Token(MediaSessionCompatApi21.verifyToken((Object)object), iMediaSession);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object object) {
        boolean bl = true;
        if (this == object) {
            return true;
        }
        if (!(object instanceof MediaSessionCompat.Token)) {
            return false;
        }
        Object object2 = (MediaSessionCompat.Token)object;
        object = this.mInner;
        if (object != null) {
            object2 = ((MediaSessionCompat.Token)object2).mInner;
            if (object2 != null) return object.equals(object2);
            return false;
        }
        if (((MediaSessionCompat.Token)object2).mInner == null) return bl;
        bl = false;
        return bl;
    }

    public IMediaSession getExtraBinder() {
        return this.mExtraBinder;
    }

    public Bundle getSessionToken2Bundle() {
        return this.mSessionToken2Bundle;
    }

    public Object getToken() {
        return this.mInner;
    }

    public int hashCode() {
        Object object = this.mInner;
        if (object != null) return object.hashCode();
        return 0;
    }

    public void setExtraBinder(IMediaSession iMediaSession) {
        this.mExtraBinder = iMediaSession;
    }

    public void setSessionToken2Bundle(Bundle bundle) {
        this.mSessionToken2Bundle = bundle;
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("android.support.v4.media.session.TOKEN", (Parcelable)this);
        IMediaSession iMediaSession = this.mExtraBinder;
        if (iMediaSession != null) {
            BundleCompat.putBinder((Bundle)bundle, (String)"android.support.v4.media.session.EXTRA_BINDER", (IBinder)iMediaSession.asBinder());
        }
        if ((iMediaSession = this.mSessionToken2Bundle) == null) return bundle;
        bundle.putBundle("android.support.v4.media.session.SESSION_TOKEN2_BUNDLE", (Bundle)iMediaSession);
        return bundle;
    }

    public void writeToParcel(Parcel parcel, int n) {
        if (Build.VERSION.SDK_INT >= 21) {
            parcel.writeParcelable((Parcelable)this.mInner, n);
        } else {
            parcel.writeStrongBinder((IBinder)this.mInner);
        }
    }
}
