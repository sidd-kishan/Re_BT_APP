/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.graphics.drawable.Drawable
 *  android.net.Uri
 *  com.bumptech.glide.load.Options
 *  com.bumptech.glide.load.ResourceDecoder
 *  com.bumptech.glide.load.engine.Resource
 *  com.bumptech.glide.load.resource.drawable.DrawableDecoderCompat
 *  com.bumptech.glide.load.resource.drawable.NonOwnedDrawableResource
 */
package com.bumptech.glide.load.resource.drawable;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.drawable.DrawableDecoderCompat;
import com.bumptech.glide.load.resource.drawable.NonOwnedDrawableResource;

public class ResourceDrawableDecoder
implements ResourceDecoder<Uri, Drawable> {
    private static final int ID_PATH_SEGMENTS = 1;
    private static final int NAME_PATH_SEGMENT_INDEX = 1;
    private static final int NAME_URI_PATH_SEGMENTS = 2;
    private static final int RESOURCE_ID_SEGMENT_INDEX = 0;
    private static final int TYPE_PATH_SEGMENT_INDEX = 0;
    private final Context context;

    public ResourceDrawableDecoder(Context context) {
        this.context = context.getApplicationContext();
    }

    private Context getContextForPackage(Uri uri, String charSequence) {
        try {
            charSequence = this.context.createPackageContext((String)charSequence, 0);
            return charSequence;
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append("Failed to obtain context or unrecognized Uri format for: ");
            ((StringBuilder)charSequence).append(uri);
            throw new IllegalArgumentException(((StringBuilder)charSequence).toString(), nameNotFoundException);
        }
    }

    private int loadResourceIdFromUri(Uri uri) {
        Object object;
        Object object2 = uri.getPathSegments();
        if (object2.size() == 2) {
            String string = uri.getAuthority();
            object = (String)object2.get(0);
            object2 = (String)object2.get(1);
            object = this.context.getResources().getIdentifier((String)object2, (String)object, string);
        } else {
            if (object2.size() == 1) {
                try {
                    object = Integer.valueOf((String)object2.get(0));
                }
                catch (NumberFormatException numberFormatException) {}
            }
            object = null;
        }
        if (object == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append("Unrecognized Uri format: ");
            ((StringBuilder)object).append(uri);
            throw new IllegalArgumentException(((StringBuilder)object).toString());
        }
        if ((Integer)object != 0) {
            return (Integer)object;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Failed to obtain resource id for: ");
        ((StringBuilder)object).append(uri);
        throw new IllegalArgumentException(((StringBuilder)object).toString());
    }

    public Resource<Drawable> decode(Uri uri, int n, int n2, Options object) {
        n = this.loadResourceIdFromUri(uri);
        object = uri.getAuthority();
        uri = ((String)object).equals(this.context.getPackageName()) ? this.context : this.getContextForPackage(uri, (String)object);
        return NonOwnedDrawableResource.newInstance((Drawable)DrawableDecoderCompat.getDrawable((Context)uri, (int)n));
    }

    public boolean handles(Uri uri, Options options) {
        return uri.getScheme().equals("android.resource");
    }
}
