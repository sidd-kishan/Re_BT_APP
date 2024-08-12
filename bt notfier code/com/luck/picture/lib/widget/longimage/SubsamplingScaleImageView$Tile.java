/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.Rect
 */
package com.luck.picture.lib.widget.longimage;

import android.graphics.Bitmap;
import android.graphics.Rect;

private static class SubsamplingScaleImageView.Tile {
    private Bitmap bitmap;
    private Rect fileSRect;
    private boolean loading;
    private Rect sRect;
    private int sampleSize;
    private Rect vRect;
    private boolean visible;

    private SubsamplingScaleImageView.Tile() {
    }

    static /* synthetic */ boolean access$400(SubsamplingScaleImageView.Tile tile) {
        return tile.visible;
    }

    static /* synthetic */ boolean access$4000(SubsamplingScaleImageView.Tile tile) {
        return tile.loading;
    }

    static /* synthetic */ boolean access$4002(SubsamplingScaleImageView.Tile tile, boolean bl) {
        tile.loading = bl;
        return bl;
    }

    static /* synthetic */ boolean access$402(SubsamplingScaleImageView.Tile tile, boolean bl) {
        tile.visible = bl;
        return bl;
    }

    static /* synthetic */ Rect access$4100(SubsamplingScaleImageView.Tile tile) {
        return tile.sRect;
    }

    static /* synthetic */ Rect access$4102(SubsamplingScaleImageView.Tile tile, Rect rect) {
        tile.sRect = rect;
        return rect;
    }

    static /* synthetic */ Rect access$4200(SubsamplingScaleImageView.Tile tile) {
        return tile.vRect;
    }

    static /* synthetic */ Rect access$4202(SubsamplingScaleImageView.Tile tile, Rect rect) {
        tile.vRect = rect;
        return rect;
    }

    static /* synthetic */ int access$4300(SubsamplingScaleImageView.Tile tile) {
        return tile.sampleSize;
    }

    static /* synthetic */ int access$4302(SubsamplingScaleImageView.Tile tile, int n) {
        tile.sampleSize = n;
        return n;
    }

    static /* synthetic */ Bitmap access$500(SubsamplingScaleImageView.Tile tile) {
        return tile.bitmap;
    }

    static /* synthetic */ Rect access$5000(SubsamplingScaleImageView.Tile tile) {
        return tile.fileSRect;
    }

    static /* synthetic */ Rect access$5002(SubsamplingScaleImageView.Tile tile, Rect rect) {
        tile.fileSRect = rect;
        return rect;
    }

    static /* synthetic */ Bitmap access$502(SubsamplingScaleImageView.Tile tile, Bitmap bitmap) {
        tile.bitmap = bitmap;
        return bitmap;
    }
}
