/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.graphics.Canvas
 *  android.graphics.ColorFilter
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.Shader$TileMode
 *  android.graphics.drawable.BitmapDrawable
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.LayerDrawable
 *  androidx.appcompat.R$attr
 *  androidx.appcompat.R$color
 *  androidx.appcompat.R$dimen
 *  androidx.appcompat.R$drawable
 *  androidx.appcompat.content.res.AppCompatResources
 *  androidx.appcompat.widget.AppCompatDrawableManager
 *  androidx.appcompat.widget.DrawableUtils
 *  androidx.appcompat.widget.ResourceManagerInternal
 *  androidx.appcompat.widget.ResourceManagerInternal$ResourceManagerHooks
 *  androidx.appcompat.widget.ThemeUtils
 *  androidx.core.graphics.ColorUtils
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import androidx.appcompat.R;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.DrawableUtils;
import androidx.appcompat.widget.ResourceManagerInternal;
import androidx.appcompat.widget.ThemeUtils;
import androidx.core.graphics.ColorUtils;

/*
 * Exception performing whole class analysis ignored.
 */
class AppCompatDrawableManager.1
implements ResourceManagerInternal.ResourceManagerHooks {
    private final int[] COLORFILTER_COLOR_BACKGROUND_MULTIPLY;
    private final int[] COLORFILTER_COLOR_CONTROL_ACTIVATED;
    private final int[] COLORFILTER_TINT_COLOR_CONTROL_NORMAL = new int[]{R.drawable.abc_textfield_search_default_mtrl_alpha, R.drawable.abc_textfield_default_mtrl_alpha, R.drawable.abc_ab_share_pack_mtrl_alpha};
    private final int[] TINT_CHECKABLE_BUTTON_LIST;
    private final int[] TINT_COLOR_CONTROL_NORMAL = new int[]{R.drawable.abc_ic_commit_search_api_mtrl_alpha, R.drawable.abc_seekbar_tick_mark_material, R.drawable.abc_ic_menu_share_mtrl_alpha, R.drawable.abc_ic_menu_copy_mtrl_am_alpha, R.drawable.abc_ic_menu_cut_mtrl_alpha, R.drawable.abc_ic_menu_selectall_mtrl_alpha, R.drawable.abc_ic_menu_paste_mtrl_am_alpha};
    private final int[] TINT_COLOR_CONTROL_STATE_LIST;

    AppCompatDrawableManager.1() {
        this.COLORFILTER_COLOR_CONTROL_ACTIVATED = new int[]{R.drawable.abc_textfield_activated_mtrl_alpha, R.drawable.abc_textfield_search_activated_mtrl_alpha, R.drawable.abc_cab_background_top_mtrl_alpha, R.drawable.abc_text_cursor_material, R.drawable.abc_text_select_handle_left_mtrl, R.drawable.abc_text_select_handle_middle_mtrl, R.drawable.abc_text_select_handle_right_mtrl};
        this.COLORFILTER_COLOR_BACKGROUND_MULTIPLY = new int[]{R.drawable.abc_popup_background_mtrl_mult, R.drawable.abc_cab_background_internal_bg, R.drawable.abc_menu_hardkey_panel_mtrl_mult};
        this.TINT_COLOR_CONTROL_STATE_LIST = new int[]{R.drawable.abc_tab_indicator_material, R.drawable.abc_textfield_search_material};
        this.TINT_CHECKABLE_BUTTON_LIST = new int[]{R.drawable.abc_btn_check_material, R.drawable.abc_btn_radio_material, R.drawable.abc_btn_check_material_anim, R.drawable.abc_btn_radio_material_anim};
    }

    private boolean arrayContains(int[] nArray, int n) {
        int n2 = nArray.length;
        int n3 = 0;
        while (n3 < n2) {
            if (nArray[n3] == n) {
                return true;
            }
            ++n3;
        }
        return false;
    }

    private ColorStateList createBorderlessButtonColorStateList(Context context) {
        return this.createButtonColorStateList(context, 0);
    }

    private ColorStateList createButtonColorStateList(Context object, int n) {
        int n2 = ThemeUtils.getThemeAttrColor((Context)object, (int)R.attr.colorControlHighlight);
        int n3 = ThemeUtils.getDisabledThemeAttrColor((Context)object, (int)R.attr.colorButtonNormal);
        int[] nArray = ThemeUtils.DISABLED_STATE_SET;
        int[] nArray2 = ThemeUtils.PRESSED_STATE_SET;
        int n4 = ColorUtils.compositeColors((int)n2, (int)n);
        object = ThemeUtils.FOCUSED_STATE_SET;
        n2 = ColorUtils.compositeColors((int)n2, (int)n);
        return new ColorStateList((int[][])new int[][]{nArray, nArray2, (int[])object, ThemeUtils.EMPTY_STATE_SET}, new int[]{n3, n4, n2, n});
    }

    private ColorStateList createColoredButtonColorStateList(Context context) {
        return this.createButtonColorStateList(context, ThemeUtils.getThemeAttrColor((Context)context, (int)R.attr.colorAccent));
    }

    private ColorStateList createDefaultButtonColorStateList(Context context) {
        return this.createButtonColorStateList(context, ThemeUtils.getThemeAttrColor((Context)context, (int)R.attr.colorButtonNormal));
    }

    private ColorStateList createSwitchThumbColorStateList(Context context) {
        int[][] nArrayArray = new int[3][];
        int[] nArray = new int[3];
        ColorStateList colorStateList = ThemeUtils.getThemeAttrColorStateList((Context)context, (int)R.attr.colorSwitchThumbNormal);
        if (colorStateList != null && colorStateList.isStateful()) {
            nArrayArray[0] = ThemeUtils.DISABLED_STATE_SET;
            nArray[0] = colorStateList.getColorForState(nArrayArray[0], 0);
            nArrayArray[1] = ThemeUtils.CHECKED_STATE_SET;
            nArray[1] = ThemeUtils.getThemeAttrColor((Context)context, (int)R.attr.colorControlActivated);
            nArrayArray[2] = ThemeUtils.EMPTY_STATE_SET;
            nArray[2] = colorStateList.getDefaultColor();
        } else {
            nArrayArray[0] = ThemeUtils.DISABLED_STATE_SET;
            nArray[0] = ThemeUtils.getDisabledThemeAttrColor((Context)context, (int)R.attr.colorSwitchThumbNormal);
            nArrayArray[1] = ThemeUtils.CHECKED_STATE_SET;
            nArray[1] = ThemeUtils.getThemeAttrColor((Context)context, (int)R.attr.colorControlActivated);
            nArrayArray[2] = ThemeUtils.EMPTY_STATE_SET;
            nArray[2] = ThemeUtils.getThemeAttrColor((Context)context, (int)R.attr.colorSwitchThumbNormal);
        }
        return new ColorStateList((int[][])nArrayArray, nArray);
    }

    private LayerDrawable getRatingBarLayerDrawable(ResourceManagerInternal resourceManagerInternal, Context context, int n) {
        n = context.getResources().getDimensionPixelSize(n);
        Drawable drawable2 = resourceManagerInternal.getDrawable(context, R.drawable.abc_star_black_48dp);
        Drawable drawable3 = resourceManagerInternal.getDrawable(context, R.drawable.abc_star_half_black_48dp);
        if (drawable2 instanceof BitmapDrawable && drawable2.getIntrinsicWidth() == n && drawable2.getIntrinsicHeight() == n) {
            context = (BitmapDrawable)drawable2;
            resourceManagerInternal = new BitmapDrawable(context.getBitmap());
        } else {
            resourceManagerInternal = Bitmap.createBitmap((int)n, (int)n, (Bitmap.Config)Bitmap.Config.ARGB_8888);
            context = new Canvas((Bitmap)resourceManagerInternal);
            drawable2.setBounds(0, 0, n, n);
            drawable2.draw((Canvas)context);
            context = new BitmapDrawable((Bitmap)resourceManagerInternal);
            resourceManagerInternal = new BitmapDrawable((Bitmap)resourceManagerInternal);
        }
        resourceManagerInternal.setTileModeX(Shader.TileMode.REPEAT);
        if (drawable3 instanceof BitmapDrawable && drawable3.getIntrinsicWidth() == n && drawable3.getIntrinsicHeight() == n) {
            drawable3 = (BitmapDrawable)drawable3;
        } else {
            drawable2 = Bitmap.createBitmap((int)n, (int)n, (Bitmap.Config)Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas((Bitmap)drawable2);
            drawable3.setBounds(0, 0, n, n);
            drawable3.draw(canvas);
            drawable3 = new BitmapDrawable((Bitmap)drawable2);
        }
        resourceManagerInternal = new LayerDrawable(new Drawable[]{context, drawable3, resourceManagerInternal});
        resourceManagerInternal.setId(0, 0x1020000);
        resourceManagerInternal.setId(1, 16908303);
        resourceManagerInternal.setId(2, 16908301);
        return resourceManagerInternal;
    }

    private void setPorterDuffColorFilter(Drawable drawable2, int n, PorterDuff.Mode mode) {
        Drawable drawable3 = drawable2;
        if (DrawableUtils.canSafelyMutateDrawable((Drawable)drawable2)) {
            drawable3 = drawable2.mutate();
        }
        drawable2 = mode;
        if (mode == null) {
            drawable2 = AppCompatDrawableManager.access$000();
        }
        drawable3.setColorFilter((ColorFilter)AppCompatDrawableManager.getPorterDuffColorFilter((int)n, (PorterDuff.Mode)drawable2));
    }

    public Drawable createDrawableFor(ResourceManagerInternal resourceManagerInternal, Context context, int n) {
        if (n == R.drawable.abc_cab_background_top_material) {
            return new LayerDrawable(new Drawable[]{resourceManagerInternal.getDrawable(context, R.drawable.abc_cab_background_internal_bg), resourceManagerInternal.getDrawable(context, R.drawable.abc_cab_background_top_mtrl_alpha)});
        }
        if (n == R.drawable.abc_ratingbar_material) {
            return this.getRatingBarLayerDrawable(resourceManagerInternal, context, R.dimen.abc_star_big);
        }
        if (n == R.drawable.abc_ratingbar_indicator_material) {
            return this.getRatingBarLayerDrawable(resourceManagerInternal, context, R.dimen.abc_star_medium);
        }
        if (n != R.drawable.abc_ratingbar_small_material) return null;
        return this.getRatingBarLayerDrawable(resourceManagerInternal, context, R.dimen.abc_star_small);
    }

    public ColorStateList getTintListForDrawableRes(Context context, int n) {
        if (n == R.drawable.abc_edit_text_material) {
            return AppCompatResources.getColorStateList((Context)context, (int)R.color.abc_tint_edittext);
        }
        if (n == R.drawable.abc_switch_track_mtrl_alpha) {
            return AppCompatResources.getColorStateList((Context)context, (int)R.color.abc_tint_switch_track);
        }
        if (n == R.drawable.abc_switch_thumb_material) {
            return this.createSwitchThumbColorStateList(context);
        }
        if (n == R.drawable.abc_btn_default_mtrl_shape) {
            return this.createDefaultButtonColorStateList(context);
        }
        if (n == R.drawable.abc_btn_borderless_material) {
            return this.createBorderlessButtonColorStateList(context);
        }
        if (n == R.drawable.abc_btn_colored_material) {
            return this.createColoredButtonColorStateList(context);
        }
        if (n == R.drawable.abc_spinner_mtrl_am_alpha) return AppCompatResources.getColorStateList((Context)context, (int)R.color.abc_tint_spinner);
        if (n == R.drawable.abc_spinner_textfield_background_material) {
            return AppCompatResources.getColorStateList((Context)context, (int)R.color.abc_tint_spinner);
        }
        if (this.arrayContains(this.TINT_COLOR_CONTROL_NORMAL, n)) {
            return ThemeUtils.getThemeAttrColorStateList((Context)context, (int)R.attr.colorControlNormal);
        }
        if (this.arrayContains(this.TINT_COLOR_CONTROL_STATE_LIST, n)) {
            return AppCompatResources.getColorStateList((Context)context, (int)R.color.abc_tint_default);
        }
        if (this.arrayContains(this.TINT_CHECKABLE_BUTTON_LIST, n)) {
            return AppCompatResources.getColorStateList((Context)context, (int)R.color.abc_tint_btn_checkable);
        }
        if (n != R.drawable.abc_seekbar_thumb_material) return null;
        return AppCompatResources.getColorStateList((Context)context, (int)R.color.abc_tint_seek_thumb);
    }

    public PorterDuff.Mode getTintModeForDrawableRes(int n) {
        Object object = n == R.drawable.abc_switch_thumb_material ? PorterDuff.Mode.MULTIPLY : null;
        return object;
    }

    public boolean tintDrawable(Context context, int n, Drawable drawable2) {
        if (n == R.drawable.abc_seekbar_track_material) {
            drawable2 = (LayerDrawable)drawable2;
            this.setPorterDuffColorFilter(drawable2.findDrawableByLayerId(0x1020000), ThemeUtils.getThemeAttrColor((Context)context, (int)R.attr.colorControlNormal), AppCompatDrawableManager.access$000());
            this.setPorterDuffColorFilter(drawable2.findDrawableByLayerId(16908303), ThemeUtils.getThemeAttrColor((Context)context, (int)R.attr.colorControlNormal), AppCompatDrawableManager.access$000());
            this.setPorterDuffColorFilter(drawable2.findDrawableByLayerId(16908301), ThemeUtils.getThemeAttrColor((Context)context, (int)R.attr.colorControlActivated), AppCompatDrawableManager.access$000());
            return true;
        }
        if (n != R.drawable.abc_ratingbar_material && n != R.drawable.abc_ratingbar_indicator_material) {
            if (n != R.drawable.abc_ratingbar_small_material) return false;
        }
        drawable2 = (LayerDrawable)drawable2;
        this.setPorterDuffColorFilter(drawable2.findDrawableByLayerId(0x1020000), ThemeUtils.getDisabledThemeAttrColor((Context)context, (int)R.attr.colorControlNormal), AppCompatDrawableManager.access$000());
        this.setPorterDuffColorFilter(drawable2.findDrawableByLayerId(16908303), ThemeUtils.getThemeAttrColor((Context)context, (int)R.attr.colorControlActivated), AppCompatDrawableManager.access$000());
        this.setPorterDuffColorFilter(drawable2.findDrawableByLayerId(16908301), ThemeUtils.getThemeAttrColor((Context)context, (int)R.attr.colorControlActivated), AppCompatDrawableManager.access$000());
        return true;
    }

    /*
     * Unable to fully structure code
     */
    public boolean tintDrawableUsingColorFilter(Context var1_1, int var2_2, Drawable var3_3) {
        block6: {
            block5: {
                block4: {
                    block3: {
                        var7_4 = AppCompatDrawableManager.access$000();
                        var6_5 = this.arrayContains(this.COLORFILTER_TINT_COLOR_CONTROL_NORMAL, var2_2);
                        var4_6 = 0x1010031;
                        if (!var6_5) break block3;
                        var2_2 = R.attr.colorControlNormal;
                        ** GOTO lbl24
                    }
                    if (!this.arrayContains(this.COLORFILTER_COLOR_CONTROL_ACTIVATED, var2_2)) break block4;
                    var2_2 = R.attr.colorControlActivated;
                    ** GOTO lbl24
                }
                if (!this.arrayContains(this.COLORFILTER_COLOR_BACKGROUND_MULTIPLY, var2_2)) break block5;
                var7_4 = PorterDuff.Mode.MULTIPLY;
                var2_2 = var4_6;
                ** GOTO lbl24
            }
            if (var2_2 != R.drawable.abc_list_divider_mtrl_alpha) break block6;
            var2_2 = 0x1010030;
            var4_6 = Math.round(40.8f);
            ** GOTO lbl25
        }
        if (var2_2 == R.drawable.abc_dialog_material_background) {
            var2_2 = var4_6;
lbl24:
            // 4 sources

            var4_6 = -1;
lbl25:
            // 2 sources

            var5_7 = true;
        } else {
            var4_6 = -1;
            var5_7 = false;
            var2_2 = 0;
        }
        if (var5_7 == false) return false;
        var8_8 = var3_3;
        if (DrawableUtils.canSafelyMutateDrawable((Drawable)var3_3)) {
            var8_8 = var3_3.mutate();
        }
        var8_8.setColorFilter((ColorFilter)AppCompatDrawableManager.getPorterDuffColorFilter((int)ThemeUtils.getThemeAttrColor((Context)var1_1, (int)var2_2), (PorterDuff.Mode)var7_4));
        if (var4_6 == -1) return true;
        var8_8.setAlpha(var4_6);
        return true;
    }
}
