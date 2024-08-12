/*
 * Decompiled with CFR 0.152.
 */
package com.lianhezhuli.btnotification.bean;

public class UserInfoBean {
    private int age;
    private String birth;
    private String headImgPath;
    private String height;
    private String nickname;
    private int sex;
    private String weight;

    public int getAge() {
        return this.age;
    }

    public String getBirth() {
        return this.birth;
    }

    public String getHeadImgPath() {
        return this.headImgPath;
    }

    public String getHeight() {
        return this.height;
    }

    public String getNickname() {
        return this.nickname;
    }

    public int getSex() {
        return this.sex;
    }

    public String getWeight() {
        return this.weight;
    }

    public void setAge(int n) {
        this.age = n;
    }

    public void setBirth(String string) {
        this.birth = string;
    }

    public void setHeadImgPath(String string) {
        this.headImgPath = string;
    }

    public void setHeight(String string) {
        this.height = string;
    }

    public void setNickname(String string) {
        this.nickname = string;
    }

    public void setSex(int n) {
        this.sex = n;
    }

    public void setWeight(String string) {
        this.weight = string;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("UserInfoBean{headImgPath='");
        stringBuilder.append(this.headImgPath);
        stringBuilder.append('\'');
        stringBuilder.append(", nickname='");
        stringBuilder.append(this.nickname);
        stringBuilder.append('\'');
        stringBuilder.append(", sex=");
        stringBuilder.append(this.sex);
        stringBuilder.append(", age=");
        stringBuilder.append(this.age);
        stringBuilder.append(", height=");
        stringBuilder.append(this.height);
        stringBuilder.append(", weight=");
        stringBuilder.append(this.weight);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
