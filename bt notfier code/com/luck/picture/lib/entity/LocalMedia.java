/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  android.text.TextUtils
 */
package com.luck.picture.lib.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

public class LocalMedia
implements Parcelable {
    public static final Parcelable.Creator<LocalMedia> CREATOR = new /* Unavailable Anonymous Inner Class!! */;
    private String androidQToPath;
    private long bucketId = -1L;
    private int chooseModel;
    private String compressPath;
    private boolean compressed;
    private int cropImageHeight;
    private int cropImageWidth;
    private int cropOffsetX;
    private int cropOffsetY;
    private float cropResultAspectRatio;
    private String cutPath;
    private long dateAddedTime;
    private long duration;
    private String fileName;
    private int height;
    private long id;
    private boolean isChecked;
    private boolean isCut;
    public boolean isLongImage;
    private boolean isMaxSelectEnabledMask;
    private boolean isOriginal;
    public int loadLongImageStatus = -1;
    private String mimeType;
    private int num;
    @Deprecated
    private int orientation = -1;
    private String originalPath;
    private String parentFolderName;
    private String path;
    public int position;
    private String realPath;
    private long size;
    private int width;

    public LocalMedia() {
    }

    public LocalMedia(long l, String string, String string2, String string3, String string4, long l2, int n, String string5, int n2, int n3, long l3, long l4, long l5) {
        this.id = l;
        this.path = string;
        this.realPath = string2;
        this.fileName = string3;
        this.parentFolderName = string4;
        this.duration = l2;
        this.chooseModel = n;
        this.mimeType = string5;
        this.width = n2;
        this.height = n3;
        this.size = l3;
        this.bucketId = l4;
        this.dateAddedTime = l5;
    }

    protected LocalMedia(Parcel parcel) {
        this.id = parcel.readLong();
        this.path = parcel.readString();
        this.realPath = parcel.readString();
        this.originalPath = parcel.readString();
        this.compressPath = parcel.readString();
        this.cutPath = parcel.readString();
        this.androidQToPath = parcel.readString();
        this.duration = parcel.readLong();
        byte by = parcel.readByte();
        boolean bl = true;
        boolean bl2 = by != 0;
        this.isChecked = bl2;
        bl2 = parcel.readByte() != 0;
        this.isCut = bl2;
        this.position = parcel.readInt();
        this.num = parcel.readInt();
        this.mimeType = parcel.readString();
        this.chooseModel = parcel.readInt();
        bl2 = parcel.readByte() != 0;
        this.compressed = bl2;
        this.width = parcel.readInt();
        this.height = parcel.readInt();
        this.cropImageWidth = parcel.readInt();
        this.cropImageHeight = parcel.readInt();
        this.cropOffsetX = parcel.readInt();
        this.cropOffsetY = parcel.readInt();
        this.cropResultAspectRatio = parcel.readFloat();
        this.size = parcel.readLong();
        bl2 = parcel.readByte() != 0;
        this.isOriginal = bl2;
        this.fileName = parcel.readString();
        this.parentFolderName = parcel.readString();
        this.orientation = parcel.readInt();
        this.loadLongImageStatus = parcel.readInt();
        bl2 = parcel.readByte() != 0;
        this.isLongImage = bl2;
        this.bucketId = parcel.readLong();
        bl2 = parcel.readByte() != 0 ? bl : false;
        this.isMaxSelectEnabledMask = bl2;
        this.dateAddedTime = parcel.readLong();
    }

    public LocalMedia(String string, long l, boolean bl, int n, int n2, int n3) {
        this.path = string;
        this.duration = l;
        this.isChecked = bl;
        this.position = n;
        this.num = n2;
        this.chooseModel = n3;
    }

    public int describeContents() {
        return 0;
    }

    public String getAndroidQToPath() {
        return this.androidQToPath;
    }

    public long getBucketId() {
        return this.bucketId;
    }

    public int getChooseModel() {
        return this.chooseModel;
    }

    public String getCompressPath() {
        return this.compressPath;
    }

    public int getCropImageHeight() {
        return this.cropImageHeight;
    }

    public int getCropImageWidth() {
        return this.cropImageWidth;
    }

    public int getCropOffsetX() {
        return this.cropOffsetX;
    }

    public int getCropOffsetY() {
        return this.cropOffsetY;
    }

    public float getCropResultAspectRatio() {
        return this.cropResultAspectRatio;
    }

    public String getCutPath() {
        return this.cutPath;
    }

    public long getDateAddedTime() {
        return this.dateAddedTime;
    }

    public long getDuration() {
        return this.duration;
    }

    public String getFileName() {
        return this.fileName;
    }

    public int getHeight() {
        return this.height;
    }

    public long getId() {
        return this.id;
    }

    public String getMimeType() {
        String string = TextUtils.isEmpty((CharSequence)this.mimeType) ? "image/jpeg" : this.mimeType;
        return string;
    }

    public int getNum() {
        return this.num;
    }

    @Deprecated
    public int getOrientation() {
        return this.orientation;
    }

    public String getOriginalPath() {
        return this.originalPath;
    }

    public String getParentFolderName() {
        return this.parentFolderName;
    }

    public String getPath() {
        return this.path;
    }

    public int getPosition() {
        return this.position;
    }

    public String getRealPath() {
        return this.realPath;
    }

    public long getSize() {
        return this.size;
    }

    public int getWidth() {
        return this.width;
    }

    public boolean isChecked() {
        return this.isChecked;
    }

    public boolean isCompressed() {
        return this.compressed;
    }

    public boolean isCut() {
        return this.isCut;
    }

    public boolean isMaxSelectEnabledMask() {
        return this.isMaxSelectEnabledMask;
    }

    public boolean isOriginal() {
        return this.isOriginal;
    }

    public void setAndroidQToPath(String string) {
        this.androidQToPath = string;
    }

    public void setBucketId(long l) {
        this.bucketId = l;
    }

    public void setChecked(boolean bl) {
        this.isChecked = bl;
    }

    public void setChooseModel(int n) {
        this.chooseModel = n;
    }

    public void setCompressPath(String string) {
        this.compressPath = string;
    }

    public void setCompressed(boolean bl) {
        this.compressed = bl;
    }

    public void setCropImageHeight(int n) {
        this.cropImageHeight = n;
    }

    public void setCropImageWidth(int n) {
        this.cropImageWidth = n;
    }

    public void setCropOffsetX(int n) {
        this.cropOffsetX = n;
    }

    public void setCropOffsetY(int n) {
        this.cropOffsetY = n;
    }

    public void setCropResultAspectRatio(float f) {
        this.cropResultAspectRatio = f;
    }

    public void setCut(boolean bl) {
        this.isCut = bl;
    }

    public void setCutPath(String string) {
        this.cutPath = string;
    }

    public void setDateAddedTime(long l) {
        this.dateAddedTime = l;
    }

    public void setDuration(long l) {
        this.duration = l;
    }

    public void setFileName(String string) {
        this.fileName = string;
    }

    public void setHeight(int n) {
        this.height = n;
    }

    public void setId(long l) {
        this.id = l;
    }

    public void setMaxSelectEnabledMask(boolean bl) {
        this.isMaxSelectEnabledMask = bl;
    }

    public void setMimeType(String string) {
        this.mimeType = string;
    }

    public void setNum(int n) {
        this.num = n;
    }

    @Deprecated
    public void setOrientation(int n) {
        this.orientation = n;
    }

    public void setOriginal(boolean bl) {
        this.isOriginal = bl;
    }

    public void setOriginalPath(String string) {
        this.originalPath = string;
    }

    public void setParentFolderName(String string) {
        this.parentFolderName = string;
    }

    public void setPath(String string) {
        this.path = string;
    }

    public void setPosition(int n) {
        this.position = n;
    }

    public void setRealPath(String string) {
        this.realPath = string;
    }

    public void setSize(long l) {
        this.size = l;
    }

    public void setWidth(int n) {
        this.width = n;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("LocalMedia{id=");
        stringBuilder.append(this.id);
        stringBuilder.append(", path='");
        stringBuilder.append(this.path);
        stringBuilder.append('\'');
        stringBuilder.append(", realPath='");
        stringBuilder.append(this.realPath);
        stringBuilder.append('\'');
        stringBuilder.append(", originalPath='");
        stringBuilder.append(this.originalPath);
        stringBuilder.append('\'');
        stringBuilder.append(", compressPath='");
        stringBuilder.append(this.compressPath);
        stringBuilder.append('\'');
        stringBuilder.append(", cutPath='");
        stringBuilder.append(this.cutPath);
        stringBuilder.append('\'');
        stringBuilder.append(", androidQToPath='");
        stringBuilder.append(this.androidQToPath);
        stringBuilder.append('\'');
        stringBuilder.append(", duration=");
        stringBuilder.append(this.duration);
        stringBuilder.append(", isChecked=");
        stringBuilder.append(this.isChecked);
        stringBuilder.append(", isCut=");
        stringBuilder.append(this.isCut);
        stringBuilder.append(", position=");
        stringBuilder.append(this.position);
        stringBuilder.append(", num=");
        stringBuilder.append(this.num);
        stringBuilder.append(", mimeType='");
        stringBuilder.append(this.mimeType);
        stringBuilder.append('\'');
        stringBuilder.append(", chooseModel=");
        stringBuilder.append(this.chooseModel);
        stringBuilder.append(", compressed=");
        stringBuilder.append(this.compressed);
        stringBuilder.append(", width=");
        stringBuilder.append(this.width);
        stringBuilder.append(", height=");
        stringBuilder.append(this.height);
        stringBuilder.append(", cropImageWidth=");
        stringBuilder.append(this.cropImageWidth);
        stringBuilder.append(", cropImageHeight=");
        stringBuilder.append(this.cropImageHeight);
        stringBuilder.append(", cropOffsetX=");
        stringBuilder.append(this.cropOffsetX);
        stringBuilder.append(", cropOffsetY=");
        stringBuilder.append(this.cropOffsetY);
        stringBuilder.append(", cropResultAspectRatio=");
        stringBuilder.append(this.cropResultAspectRatio);
        stringBuilder.append(", size=");
        stringBuilder.append(this.size);
        stringBuilder.append(", isOriginal=");
        stringBuilder.append(this.isOriginal);
        stringBuilder.append(", fileName='");
        stringBuilder.append(this.fileName);
        stringBuilder.append('\'');
        stringBuilder.append(", parentFolderName='");
        stringBuilder.append(this.parentFolderName);
        stringBuilder.append('\'');
        stringBuilder.append(", orientation=");
        stringBuilder.append(this.orientation);
        stringBuilder.append(", loadLongImageStatus=");
        stringBuilder.append(this.loadLongImageStatus);
        stringBuilder.append(", isLongImage=");
        stringBuilder.append(this.isLongImage);
        stringBuilder.append(", bucketId=");
        stringBuilder.append(this.bucketId);
        stringBuilder.append(", isMaxSelectEnabledMask=");
        stringBuilder.append(this.isMaxSelectEnabledMask);
        stringBuilder.append(", dateAddedTime=");
        stringBuilder.append(this.dateAddedTime);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int n) {
        parcel.writeLong(this.id);
        parcel.writeString(this.path);
        parcel.writeString(this.realPath);
        parcel.writeString(this.originalPath);
        parcel.writeString(this.compressPath);
        parcel.writeString(this.cutPath);
        parcel.writeString(this.androidQToPath);
        parcel.writeLong(this.duration);
        parcel.writeByte((byte)(this.isChecked ? 1 : 0));
        parcel.writeByte((byte)(this.isCut ? 1 : 0));
        parcel.writeInt(this.position);
        parcel.writeInt(this.num);
        parcel.writeString(this.mimeType);
        parcel.writeInt(this.chooseModel);
        parcel.writeByte((byte)(this.compressed ? 1 : 0));
        parcel.writeInt(this.width);
        parcel.writeInt(this.height);
        parcel.writeInt(this.cropImageWidth);
        parcel.writeInt(this.cropImageHeight);
        parcel.writeInt(this.cropOffsetX);
        parcel.writeInt(this.cropOffsetY);
        parcel.writeFloat(this.cropResultAspectRatio);
        parcel.writeLong(this.size);
        parcel.writeByte((byte)(this.isOriginal ? 1 : 0));
        parcel.writeString(this.fileName);
        parcel.writeString(this.parentFolderName);
        parcel.writeInt(this.orientation);
        parcel.writeInt(this.loadLongImageStatus);
        parcel.writeByte((byte)(this.isLongImage ? 1 : 0));
        parcel.writeLong(this.bucketId);
        parcel.writeByte((byte)(this.isMaxSelectEnabledMask ? 1 : 0));
        parcel.writeLong(this.dateAddedTime);
    }
}
