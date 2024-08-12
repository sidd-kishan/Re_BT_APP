/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.Parcelable
 *  android.support.v4.media.MediaMetadataCompat
 *  android.support.v4.media.RatingCompat
 *  android.support.v4.media.session.MediaSessionCompat
 */
package android.support.v4.media;

import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.RatingCompat;
import android.support.v4.media.session.MediaSessionCompat;

public static final class MediaMetadataCompat.Builder {
    private final Bundle mBundle;

    public MediaMetadataCompat.Builder() {
        this.mBundle = new Bundle();
    }

    public MediaMetadataCompat.Builder(MediaMetadataCompat mediaMetadataCompat) {
        mediaMetadataCompat = new Bundle(mediaMetadataCompat.mBundle);
        this.mBundle = mediaMetadataCompat;
        MediaSessionCompat.ensureClassLoader((Bundle)mediaMetadataCompat);
    }

    public MediaMetadataCompat.Builder(MediaMetadataCompat object, int n) {
        this((MediaMetadataCompat)object);
        object = this.mBundle.keySet().iterator();
        while (object.hasNext()) {
            String string = (String)object.next();
            Object object2 = this.mBundle.get(string);
            if (!(object2 instanceof Bitmap) || (object2 = (Bitmap)object2).getHeight() <= n && object2.getWidth() <= n) continue;
            this.putBitmap(string, this.scaleBitmap((Bitmap)object2, n));
        }
    }

    private Bitmap scaleBitmap(Bitmap bitmap, int n) {
        float f = n;
        f = Math.min(f / (float)bitmap.getWidth(), f / (float)bitmap.getHeight());
        n = (int)((float)bitmap.getHeight() * f);
        return Bitmap.createScaledBitmap((Bitmap)bitmap, (int)((int)((float)bitmap.getWidth() * f)), (int)n, (boolean)true);
    }

    public MediaMetadataCompat build() {
        return new MediaMetadataCompat(this.mBundle);
    }

    public MediaMetadataCompat.Builder putBitmap(String string, Bitmap object) {
        if (MediaMetadataCompat.METADATA_KEYS_TYPE.containsKey((Object)string) && (Integer)MediaMetadataCompat.METADATA_KEYS_TYPE.get((Object)string) != 2) {
            object = new StringBuilder();
            ((StringBuilder)object).append("The ");
            ((StringBuilder)object).append(string);
            ((StringBuilder)object).append(" key cannot be used to put a Bitmap");
            throw new IllegalArgumentException(((StringBuilder)object).toString());
        }
        this.mBundle.putParcelable(string, (Parcelable)object);
        return this;
    }

    public MediaMetadataCompat.Builder putLong(String string, long l) {
        if (MediaMetadataCompat.METADATA_KEYS_TYPE.containsKey((Object)string) && (Integer)MediaMetadataCompat.METADATA_KEYS_TYPE.get((Object)string) != 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("The ");
            stringBuilder.append(string);
            stringBuilder.append(" key cannot be used to put a long");
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        this.mBundle.putLong(string, l);
        return this;
    }

    public MediaMetadataCompat.Builder putRating(String string, RatingCompat object) {
        if (MediaMetadataCompat.METADATA_KEYS_TYPE.containsKey((Object)string) && (Integer)MediaMetadataCompat.METADATA_KEYS_TYPE.get((Object)string) != 3) {
            object = new StringBuilder();
            ((StringBuilder)object).append("The ");
            ((StringBuilder)object).append(string);
            ((StringBuilder)object).append(" key cannot be used to put a Rating");
            throw new IllegalArgumentException(((StringBuilder)object).toString());
        }
        if (Build.VERSION.SDK_INT >= 19) {
            this.mBundle.putParcelable(string, (Parcelable)object.getRating());
        } else {
            this.mBundle.putParcelable(string, (Parcelable)object);
        }
        return this;
    }

    public MediaMetadataCompat.Builder putString(String string, String charSequence) {
        if (MediaMetadataCompat.METADATA_KEYS_TYPE.containsKey((Object)string) && (Integer)MediaMetadataCompat.METADATA_KEYS_TYPE.get((Object)string) != 1) {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append("The ");
            ((StringBuilder)charSequence).append(string);
            ((StringBuilder)charSequence).append(" key cannot be used to put a String");
            throw new IllegalArgumentException(((StringBuilder)charSequence).toString());
        }
        this.mBundle.putCharSequence(string, charSequence);
        return this;
    }

    public MediaMetadataCompat.Builder putText(String string, CharSequence charSequence) {
        if (MediaMetadataCompat.METADATA_KEYS_TYPE.containsKey((Object)string) && (Integer)MediaMetadataCompat.METADATA_KEYS_TYPE.get((Object)string) != 1) {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append("The ");
            ((StringBuilder)charSequence).append(string);
            ((StringBuilder)charSequence).append(" key cannot be used to put a CharSequence");
            throw new IllegalArgumentException(((StringBuilder)charSequence).toString());
        }
        this.mBundle.putCharSequence(string, charSequence);
        return this;
    }
}
