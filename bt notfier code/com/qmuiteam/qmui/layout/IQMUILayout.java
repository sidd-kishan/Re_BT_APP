/*
 * Decompiled with CFR 0.152.
 */
package com.qmuiteam.qmui.layout;

public interface IQMUILayout {
    public static final int HIDE_RADIUS_SIDE_BOTTOM = 3;
    public static final int HIDE_RADIUS_SIDE_LEFT = 4;
    public static final int HIDE_RADIUS_SIDE_NONE = 0;
    public static final int HIDE_RADIUS_SIDE_RIGHT = 2;
    public static final int HIDE_RADIUS_SIDE_TOP = 1;

    public int getHideRadiusSide();

    public int getRadius();

    public float getShadowAlpha();

    public int getShadowColor();

    public int getShadowElevation();

    public void onlyShowBottomDivider(int var1, int var2, int var3, int var4);

    public void onlyShowLeftDivider(int var1, int var2, int var3, int var4);

    public void onlyShowRightDivider(int var1, int var2, int var3, int var4);

    public void onlyShowTopDivider(int var1, int var2, int var3, int var4);

    public void setBorderColor(int var1);

    public void setBorderWidth(int var1);

    public void setBottomDividerAlpha(int var1);

    public boolean setHeightLimit(int var1);

    public void setHideRadiusSide(int var1);

    public void setLeftDividerAlpha(int var1);

    public void setOuterNormalColor(int var1);

    public void setOutlineExcludePadding(boolean var1);

    public void setOutlineInset(int var1, int var2, int var3, int var4);

    public void setRadius(int var1);

    public void setRadius(int var1, int var2);

    public void setRadiusAndShadow(int var1, int var2, float var3);

    public void setRadiusAndShadow(int var1, int var2, int var3, float var4);

    public void setRadiusAndShadow(int var1, int var2, int var3, int var4, float var5);

    public void setRightDividerAlpha(int var1);

    public void setShadowAlpha(float var1);

    public void setShadowColor(int var1);

    public void setShadowElevation(int var1);

    public void setShowBorderOnlyBeforeL(boolean var1);

    public void setTopDividerAlpha(int var1);

    public void setUseThemeGeneralShadowElevation();

    public boolean setWidthLimit(int var1);

    public void updateBottomDivider(int var1, int var2, int var3, int var4);

    public void updateLeftDivider(int var1, int var2, int var3, int var4);

    public void updateRightDivider(int var1, int var2, int var3, int var4);

    public void updateTopDivider(int var1, int var2, int var3, int var4);
}
