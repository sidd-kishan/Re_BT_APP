/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  com.luck.picture.lib.R$anim
 */
package com.luck.picture.lib.style;

import android.os.Parcel;
import android.os.Parcelable;
import com.luck.picture.lib.R;

public class PictureWindowAnimationStyle
implements Parcelable {
    public static final Parcelable.Creator<PictureWindowAnimationStyle> CREATOR = new /* Unavailable Anonymous Inner Class!! */;
    public int activityCropEnterAnimation;
    public int activityCropExitAnimation;
    public int activityEnterAnimation;
    public int activityExitAnimation;
    public int activityPreviewEnterAnimation;
    public int activityPreviewExitAnimation;

    public PictureWindowAnimationStyle() {
    }

    public PictureWindowAnimationStyle(int n, int n2) {
        this.activityEnterAnimation = n;
        this.activityExitAnimation = n2;
        this.activityPreviewEnterAnimation = n;
        this.activityPreviewExitAnimation = n2;
        this.activityCropEnterAnimation = n;
        this.activityCropExitAnimation = n2;
    }

    public PictureWindowAnimationStyle(int n, int n2, int n3, int n4) {
        this.activityEnterAnimation = n;
        this.activityExitAnimation = n2;
        this.activityPreviewEnterAnimation = n3;
        this.activityPreviewExitAnimation = n4;
    }

    protected PictureWindowAnimationStyle(Parcel parcel) {
        this.activityEnterAnimation = parcel.readInt();
        this.activityExitAnimation = parcel.readInt();
        this.activityPreviewEnterAnimation = parcel.readInt();
        this.activityPreviewExitAnimation = parcel.readInt();
        this.activityCropEnterAnimation = parcel.readInt();
        this.activityCropExitAnimation = parcel.readInt();
    }

    public static PictureWindowAnimationStyle ofCustomWindowAnimationStyle(int n, int n2) {
        return new PictureWindowAnimationStyle(n, n2);
    }

    public static PictureWindowAnimationStyle ofDefaultWindowAnimationStyle() {
        return new PictureWindowAnimationStyle(R.anim.picture_anim_enter, R.anim.picture_anim_exit);
    }

    public int describeContents() {
        return 0;
    }

    public void ofAllAnimation(int n, int n2) {
        this.activityEnterAnimation = n;
        this.activityExitAnimation = n2;
        this.activityPreviewEnterAnimation = n;
        this.activityPreviewExitAnimation = n2;
        this.activityCropEnterAnimation = n;
        this.activityCropExitAnimation = n2;
    }

    public void writeToParcel(Parcel parcel, int n) {
        parcel.writeInt(this.activityEnterAnimation);
        parcel.writeInt(this.activityExitAnimation);
        parcel.writeInt(this.activityPreviewEnterAnimation);
        parcel.writeInt(this.activityPreviewExitAnimation);
        parcel.writeInt(this.activityCropEnterAnimation);
        parcel.writeInt(this.activityCropExitAnimation);
    }
}
