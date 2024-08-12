/*
 * Decompiled with CFR 0.152.
 */
package com.luck.picture.lib.entity;

public class MediaExtraInfo {
    private long duration;
    private int height;
    private int width;

    public long getDuration() {
        return this.duration;
    }

    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return this.width;
    }

    public void setDuration(long l) {
        this.duration = l;
    }

    public void setHeight(int n) {
        this.height = n;
    }

    public void setWidth(int n) {
        this.width = n;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("MediaExtraInfo{width=");
        stringBuilder.append(this.width);
        stringBuilder.append(", height=");
        stringBuilder.append(this.height);
        stringBuilder.append(", duration=");
        stringBuilder.append(this.duration);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
