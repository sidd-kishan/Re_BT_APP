/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  android.text.TextUtils
 *  com.luck.picture.lib.entity.LocalMedia
 */
package com.luck.picture.lib.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.luck.picture.lib.entity.LocalMedia;
import java.util.ArrayList;
import java.util.List;

public class LocalMediaFolder
implements Parcelable {
    public static final Parcelable.Creator<LocalMediaFolder> CREATOR = new /* Unavailable Anonymous Inner Class!! */;
    private long bucketId = -1L;
    private int checkedNum;
    private int currentDataPage;
    private List<LocalMedia> data = new ArrayList<LocalMedia>();
    private String firstImagePath;
    private String firstMimeType;
    private int imageNum;
    private boolean isCameraFolder;
    private boolean isChecked;
    private boolean isHasMore;
    private String name;
    private int ofAllType = -1;

    public LocalMediaFolder() {
    }

    protected LocalMediaFolder(Parcel parcel) {
        this.bucketId = parcel.readLong();
        this.name = parcel.readString();
        this.firstImagePath = parcel.readString();
        this.firstMimeType = parcel.readString();
        this.imageNum = parcel.readInt();
        this.checkedNum = parcel.readInt();
        byte by = parcel.readByte();
        boolean bl = true;
        boolean bl2 = by != 0;
        this.isChecked = bl2;
        this.ofAllType = parcel.readInt();
        bl2 = parcel.readByte() != 0;
        this.isCameraFolder = bl2;
        this.data = parcel.createTypedArrayList(LocalMedia.CREATOR);
        this.currentDataPage = parcel.readInt();
        bl2 = parcel.readByte() != 0 ? bl : false;
        this.isHasMore = bl2;
    }

    public int describeContents() {
        return 0;
    }

    public long getBucketId() {
        return this.bucketId;
    }

    public int getCheckedNum() {
        return this.checkedNum;
    }

    public int getCurrentDataPage() {
        return this.currentDataPage;
    }

    public List<LocalMedia> getData() {
        return this.data;
    }

    public String getFirstImagePath() {
        return this.firstImagePath;
    }

    public String getFirstMimeType() {
        return this.firstMimeType;
    }

    public int getImageNum() {
        return this.imageNum;
    }

    public String getName() {
        String string = TextUtils.isEmpty((CharSequence)this.name) ? "unknown" : this.name;
        return string;
    }

    public int getOfAllType() {
        return this.ofAllType;
    }

    public boolean isCameraFolder() {
        return this.isCameraFolder;
    }

    public boolean isChecked() {
        return this.isChecked;
    }

    public boolean isHasMore() {
        return this.isHasMore;
    }

    public void setBucketId(long l) {
        this.bucketId = l;
    }

    public void setCameraFolder(boolean bl) {
        this.isCameraFolder = bl;
    }

    public void setChecked(boolean bl) {
        this.isChecked = bl;
    }

    public void setCheckedNum(int n) {
        this.checkedNum = n;
    }

    public void setCurrentDataPage(int n) {
        this.currentDataPage = n;
    }

    public void setData(List<LocalMedia> list) {
        this.data = list;
    }

    public void setFirstImagePath(String string) {
        this.firstImagePath = string;
    }

    public void setFirstMimeType(String string) {
        this.firstMimeType = string;
    }

    public void setHasMore(boolean bl) {
        this.isHasMore = bl;
    }

    public void setImageNum(int n) {
        this.imageNum = n;
    }

    public void setName(String string) {
        this.name = string;
    }

    public void setOfAllType(int n) {
        this.ofAllType = n;
    }

    public void writeToParcel(Parcel parcel, int n) {
        parcel.writeLong(this.bucketId);
        parcel.writeString(this.name);
        parcel.writeString(this.firstImagePath);
        parcel.writeString(this.firstMimeType);
        parcel.writeInt(this.imageNum);
        parcel.writeInt(this.checkedNum);
        parcel.writeByte((byte)(this.isChecked ? 1 : 0));
        parcel.writeInt(this.ofAllType);
        parcel.writeByte((byte)(this.isCameraFolder ? 1 : 0));
        parcel.writeTypedList(this.data);
        parcel.writeInt(this.currentDataPage);
        parcel.writeByte((byte)(this.isHasMore ? 1 : 0));
    }
}
