/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.Rect
 *  android.net.Uri
 */
package com.luck.picture.lib.widget.longimage;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public final class ImageSource {
    static final String ASSET_SCHEME = "file:///android_asset/";
    static final String FILE_SCHEME = "file:///";
    private final Bitmap bitmap;
    private boolean cached;
    private final Integer resource;
    private int sHeight;
    private Rect sRegion;
    private int sWidth;
    private boolean tile;
    private final Uri uri;

    private ImageSource(int n) {
        this.bitmap = null;
        this.uri = null;
        this.resource = n;
        this.tile = true;
    }

    private ImageSource(Bitmap bitmap, boolean bl) {
        this.bitmap = bitmap;
        this.uri = null;
        this.resource = null;
        this.tile = false;
        this.sWidth = bitmap.getWidth();
        this.sHeight = bitmap.getHeight();
        this.cached = bl;
    }

    private ImageSource(Uri uri) {
        String string = uri.toString();
        Uri uri2 = uri;
        if (string.startsWith(FILE_SCHEME)) {
            uri2 = uri;
            if (!new File(string.substring(7)).exists()) {
                try {
                    uri2 = Uri.parse((String)URLDecoder.decode(string, "UTF-8"));
                }
                catch (UnsupportedEncodingException unsupportedEncodingException) {
                    uri2 = uri;
                }
            }
        }
        this.bitmap = null;
        this.uri = uri2;
        this.resource = null;
        this.tile = true;
    }

    public static ImageSource asset(String string) {
        if (string == null) throw new NullPointerException("Asset name must not be null");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(ASSET_SCHEME);
        stringBuilder.append(string);
        return ImageSource.uri(stringBuilder.toString());
    }

    public static ImageSource bitmap(Bitmap bitmap) {
        if (bitmap == null) throw new NullPointerException("Bitmap must not be null");
        return new ImageSource(bitmap, false);
    }

    public static ImageSource cachedBitmap(Bitmap bitmap) {
        if (bitmap == null) throw new NullPointerException("Bitmap must not be null");
        return new ImageSource(bitmap, true);
    }

    public static ImageSource resource(int n) {
        return new ImageSource(n);
    }

    private void setInvariants() {
        Rect rect = this.sRegion;
        if (rect == null) return;
        this.tile = true;
        this.sWidth = rect.width();
        this.sHeight = this.sRegion.height();
    }

    public static ImageSource uri(Uri uri) {
        if (uri == null) throw new NullPointerException("Uri must not be null");
        return new ImageSource(uri);
    }

    public static ImageSource uri(String charSequence) {
        if (charSequence == null) throw new NullPointerException("Uri must not be null");
        String string = charSequence;
        if (((String)charSequence).contains("://")) return new ImageSource(Uri.parse((String)string));
        string = charSequence;
        if (((String)charSequence).startsWith("/")) {
            string = ((String)charSequence).substring(1);
        }
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append(FILE_SCHEME);
        ((StringBuilder)charSequence).append(string);
        string = ((StringBuilder)charSequence).toString();
        return new ImageSource(Uri.parse((String)string));
    }

    public ImageSource dimensions(int n, int n2) {
        if (this.bitmap == null) {
            this.sWidth = n;
            this.sHeight = n2;
        }
        this.setInvariants();
        return this;
    }

    protected final Bitmap getBitmap() {
        return this.bitmap;
    }

    protected final Integer getResource() {
        return this.resource;
    }

    protected final int getSHeight() {
        return this.sHeight;
    }

    protected final Rect getSRegion() {
        return this.sRegion;
    }

    protected final int getSWidth() {
        return this.sWidth;
    }

    protected final boolean getTile() {
        return this.tile;
    }

    protected final Uri getUri() {
        return this.uri;
    }

    protected final boolean isCached() {
        return this.cached;
    }

    public ImageSource region(Rect rect) {
        this.sRegion = rect;
        this.setInvariants();
        return this;
    }

    public ImageSource tiling(boolean bl) {
        this.tile = bl;
        return this;
    }

    public ImageSource tilingDisabled() {
        return this.tiling(false);
    }

    public ImageSource tilingEnabled() {
        return this.tiling(true);
    }
}
