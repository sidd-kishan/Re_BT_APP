/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.graphics.drawable.Drawable
 *  android.text.TextUtils
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.RelativeLayout
 *  android.widget.RelativeLayout$LayoutParams
 *  android.widget.TextView
 *  androidx.core.content.ContextCompat
 *  com.luck.picture.lib.PictureSelectorActivity
 *  com.luck.picture.lib.R$attr
 *  com.luck.picture.lib.R$color
 *  com.luck.picture.lib.R$drawable
 *  com.luck.picture.lib.R$id
 *  com.luck.picture.lib.R$layout
 *  com.luck.picture.lib.R$string
 *  com.luck.picture.lib.config.PictureMimeType
 *  com.luck.picture.lib.config.PictureSelectionConfig
 *  com.luck.picture.lib.entity.LocalMedia
 *  com.luck.picture.lib.style.PictureParameterStyle
 *  com.luck.picture.lib.tools.AttrsUtils
 */
package com.luck.picture.lib;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.luck.picture.lib.PictureSelectorActivity;
import com.luck.picture.lib.R;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.config.PictureSelectionConfig;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.style.PictureParameterStyle;
import com.luck.picture.lib.tools.AttrsUtils;
import java.util.List;

public class PictureSelectorWeChatStyleActivity
extends PictureSelectorActivity {
    private RelativeLayout rlAlbum;

    private void goneParentView() {
        this.mTvPictureImgNum.setVisibility(8);
        this.mTvPictureOk.setVisibility(8);
    }

    protected void changeImageNumber(List<LocalMedia> colorStateList) {
        int n = colorStateList.size();
        boolean bl = n != 0;
        if (bl) {
            this.mTvPictureRight.setEnabled(true);
            this.mTvPictureRight.setSelected(true);
            this.mTvPicturePreview.setEnabled(true);
            this.mTvPicturePreview.setSelected(true);
            this.initCompleteText((List<LocalMedia>)colorStateList);
            if (PictureSelectionConfig.uiStyle != null) {
                if (PictureSelectionConfig.uiStyle.picture_top_titleRightTextNormalBackground != 0) {
                    this.mTvPictureRight.setBackgroundResource(PictureSelectionConfig.uiStyle.picture_top_titleRightTextNormalBackground);
                } else {
                    this.mTvPictureRight.setBackgroundResource(R.drawable.picture_send_button_bg);
                }
                if (PictureSelectionConfig.uiStyle.picture_bottom_previewTextColor.length > 0) {
                    colorStateList = AttrsUtils.getColorStateList((int[])PictureSelectionConfig.uiStyle.picture_bottom_previewTextColor);
                    if (colorStateList != null) {
                        this.mTvPicturePreview.setTextColor(colorStateList);
                    }
                } else {
                    this.mTvPicturePreview.setTextColor(ContextCompat.getColor((Context)this.getContext(), (int)R.color.picture_color_white));
                }
                if (PictureSelectionConfig.uiStyle.picture_bottom_previewNormalText != 0) {
                    if (PictureSelectionConfig.uiStyle.isCompleteReplaceNum) {
                        this.mTvPicturePreview.setText((CharSequence)String.format(this.getString(PictureSelectionConfig.uiStyle.picture_bottom_previewNormalText), n));
                    } else {
                        this.mTvPicturePreview.setText(PictureSelectionConfig.uiStyle.picture_bottom_previewNormalText);
                    }
                } else {
                    this.mTvPicturePreview.setText((CharSequence)this.getString(R.string.picture_preview_num, new Object[]{n}));
                }
            } else if (PictureSelectionConfig.style != null) {
                if (PictureSelectionConfig.style.pictureCompleteBackgroundStyle != 0) {
                    this.mTvPictureRight.setBackgroundResource(PictureSelectionConfig.style.pictureCompleteBackgroundStyle);
                } else {
                    this.mTvPictureRight.setBackgroundResource(R.drawable.picture_send_button_bg);
                }
                if (PictureSelectionConfig.style.pictureCompleteTextColor != 0) {
                    this.mTvPictureRight.setTextColor(PictureSelectionConfig.style.pictureCompleteTextColor);
                } else {
                    this.mTvPictureRight.setTextColor(ContextCompat.getColor((Context)this.getContext(), (int)R.color.picture_color_white));
                }
                if (PictureSelectionConfig.style.picturePreviewTextColor != 0) {
                    this.mTvPicturePreview.setTextColor(PictureSelectionConfig.style.picturePreviewTextColor);
                } else {
                    this.mTvPicturePreview.setTextColor(ContextCompat.getColor((Context)this.getContext(), (int)R.color.picture_color_white));
                }
                if (!TextUtils.isEmpty((CharSequence)PictureSelectionConfig.style.picturePreviewText)) {
                    this.mTvPicturePreview.setText((CharSequence)PictureSelectionConfig.style.picturePreviewText);
                } else {
                    this.mTvPicturePreview.setText((CharSequence)this.getString(R.string.picture_preview_num, new Object[]{n}));
                }
            } else {
                this.mTvPictureRight.setBackgroundResource(R.drawable.picture_send_button_bg);
                this.mTvPictureRight.setTextColor(ContextCompat.getColor((Context)this.getContext(), (int)R.color.picture_color_white));
                this.mTvPicturePreview.setTextColor(ContextCompat.getColor((Context)this.getContext(), (int)R.color.picture_color_white));
                this.mTvPicturePreview.setText((CharSequence)this.getString(R.string.picture_preview_num, new Object[]{n}));
            }
        } else {
            this.mTvPictureRight.setEnabled(false);
            this.mTvPictureRight.setSelected(false);
            this.mTvPicturePreview.setEnabled(false);
            this.mTvPicturePreview.setSelected(false);
            if (PictureSelectionConfig.uiStyle != null) {
                if (PictureSelectionConfig.uiStyle.picture_top_titleRightTextDefaultBackground != 0) {
                    this.mTvPictureRight.setBackgroundResource(PictureSelectionConfig.uiStyle.picture_top_titleRightTextDefaultBackground);
                } else {
                    this.mTvPictureRight.setBackgroundResource(R.drawable.picture_send_button_default_bg);
                }
                if (PictureSelectionConfig.uiStyle.picture_top_titleRightDefaultText != 0) {
                    this.mTvPictureRight.setText((CharSequence)this.getString(PictureSelectionConfig.uiStyle.picture_top_titleRightDefaultText));
                } else {
                    this.mTvPictureRight.setText((CharSequence)this.getString(R.string.picture_send));
                }
                if (PictureSelectionConfig.uiStyle.picture_bottom_previewDefaultText != 0) {
                    this.mTvPicturePreview.setText((CharSequence)this.getString(PictureSelectionConfig.uiStyle.picture_bottom_previewDefaultText));
                } else {
                    this.mTvPicturePreview.setText((CharSequence)this.getString(R.string.picture_preview));
                }
            } else if (PictureSelectionConfig.style != null) {
                if (PictureSelectionConfig.style.pictureUnCompleteBackgroundStyle != 0) {
                    this.mTvPictureRight.setBackgroundResource(PictureSelectionConfig.style.pictureUnCompleteBackgroundStyle);
                } else {
                    this.mTvPictureRight.setBackgroundResource(R.drawable.picture_send_button_default_bg);
                }
                if (PictureSelectionConfig.style.pictureUnCompleteTextColor != 0) {
                    this.mTvPictureRight.setTextColor(PictureSelectionConfig.style.pictureUnCompleteTextColor);
                } else {
                    this.mTvPictureRight.setTextColor(ContextCompat.getColor((Context)this.getContext(), (int)R.color.picture_color_53575e));
                }
                if (PictureSelectionConfig.style.pictureUnPreviewTextColor != 0) {
                    this.mTvPicturePreview.setTextColor(PictureSelectionConfig.style.pictureUnPreviewTextColor);
                } else {
                    this.mTvPicturePreview.setTextColor(ContextCompat.getColor((Context)this.getContext(), (int)R.color.picture_color_9b));
                }
                if (!TextUtils.isEmpty((CharSequence)PictureSelectionConfig.style.pictureUnCompleteText)) {
                    this.mTvPictureRight.setText((CharSequence)PictureSelectionConfig.style.pictureUnCompleteText);
                } else {
                    this.mTvPictureRight.setText((CharSequence)this.getString(R.string.picture_send));
                }
                if (!TextUtils.isEmpty((CharSequence)PictureSelectionConfig.style.pictureUnPreviewText)) {
                    this.mTvPicturePreview.setText((CharSequence)PictureSelectionConfig.style.pictureUnPreviewText);
                } else {
                    this.mTvPicturePreview.setText((CharSequence)this.getString(R.string.picture_preview));
                }
            } else {
                this.mTvPictureRight.setBackgroundResource(R.drawable.picture_send_button_default_bg);
                this.mTvPictureRight.setTextColor(ContextCompat.getColor((Context)this.getContext(), (int)R.color.picture_color_53575e));
                this.mTvPicturePreview.setTextColor(ContextCompat.getColor((Context)this.getContext(), (int)R.color.picture_color_9b));
                this.mTvPicturePreview.setText((CharSequence)this.getString(R.string.picture_preview));
                this.mTvPictureRight.setText((CharSequence)this.getString(R.string.picture_send));
            }
        }
    }

    public int getResourceId() {
        return R.layout.picture_wechat_style_selector;
    }

    protected void initCompleteText(List<LocalMedia> object) {
        int n = object.size();
        PictureParameterStyle pictureParameterStyle = PictureSelectionConfig.style;
        Integer n2 = 1;
        boolean bl = pictureParameterStyle != null;
        if (this.config.isWithVideoImage) {
            if (this.config.selectionMode == 1) {
                if (n <= 0) {
                    n2 = this.mTvPictureRight;
                    object = bl && !TextUtils.isEmpty((CharSequence)PictureSelectionConfig.style.pictureUnCompleteText) ? PictureSelectionConfig.style.pictureUnCompleteText : this.getString(R.string.picture_send);
                    n2.setText((CharSequence)object);
                } else {
                    boolean bl2 = bl && PictureSelectionConfig.style.isCompleteReplaceNum;
                    if (bl2 && !TextUtils.isEmpty((CharSequence)PictureSelectionConfig.style.pictureCompleteText)) {
                        this.mTvPictureRight.setText((CharSequence)String.format(PictureSelectionConfig.style.pictureCompleteText, n, n2));
                    } else {
                        n2 = this.mTvPictureRight;
                        object = bl && !TextUtils.isEmpty((CharSequence)PictureSelectionConfig.style.pictureCompleteText) ? PictureSelectionConfig.style.pictureCompleteText : this.getString(R.string.picture_send);
                        n2.setText((CharSequence)object);
                    }
                }
            } else {
                boolean bl3 = bl && PictureSelectionConfig.style.isCompleteReplaceNum;
                if (bl3 && !TextUtils.isEmpty((CharSequence)PictureSelectionConfig.style.pictureCompleteText)) {
                    this.mTvPictureRight.setText((CharSequence)String.format(PictureSelectionConfig.style.pictureCompleteText, n, this.config.maxSelectNum));
                } else {
                    n2 = this.mTvPictureRight;
                    object = bl && !TextUtils.isEmpty((CharSequence)PictureSelectionConfig.style.pictureUnCompleteText) ? PictureSelectionConfig.style.pictureUnCompleteText : this.getString(R.string.picture_send_num, new Object[]{n, this.config.maxSelectNum});
                    n2.setText((CharSequence)object);
                }
            }
        } else {
            int n3 = PictureMimeType.isHasVideo((String)object.get(0).getMimeType()) && this.config.maxVideoSelectNum > 0 ? this.config.maxVideoSelectNum : this.config.maxSelectNum;
            if (this.config.selectionMode == 1) {
                n3 = bl && PictureSelectionConfig.style.isCompleteReplaceNum ? 1 : 0;
                if (n3 != 0 && !TextUtils.isEmpty((CharSequence)PictureSelectionConfig.style.pictureCompleteText)) {
                    this.mTvPictureRight.setText((CharSequence)String.format(PictureSelectionConfig.style.pictureCompleteText, n, n2));
                } else {
                    n2 = this.mTvPictureRight;
                    object = bl && !TextUtils.isEmpty((CharSequence)PictureSelectionConfig.style.pictureCompleteText) ? PictureSelectionConfig.style.pictureCompleteText : this.getString(R.string.picture_send);
                    n2.setText((CharSequence)object);
                }
            } else {
                boolean bl4 = bl && PictureSelectionConfig.style.isCompleteReplaceNum;
                if (bl4 && !TextUtils.isEmpty((CharSequence)PictureSelectionConfig.style.pictureCompleteText)) {
                    this.mTvPictureRight.setText((CharSequence)String.format(PictureSelectionConfig.style.pictureCompleteText, n, n3));
                } else {
                    n2 = this.mTvPictureRight;
                    object = bl && !TextUtils.isEmpty((CharSequence)PictureSelectionConfig.style.pictureUnCompleteText) ? PictureSelectionConfig.style.pictureUnCompleteText : this.getString(R.string.picture_send_num, new Object[]{n, n3});
                    n2.setText((CharSequence)object);
                }
            }
        }
    }

    public void initPictureSelectorStyle() {
        if (PictureSelectionConfig.uiStyle != null) {
            if (PictureSelectionConfig.uiStyle.picture_top_titleRightTextDefaultBackground != 0) {
                this.mTvPictureRight.setBackgroundResource(PictureSelectionConfig.uiStyle.picture_top_titleRightTextDefaultBackground);
            } else {
                this.mTvPictureRight.setBackgroundResource(R.drawable.picture_send_button_default_bg);
            }
            if (PictureSelectionConfig.uiStyle.picture_bottom_barBackgroundColor != 0) {
                this.mBottomLayout.setBackgroundColor(PictureSelectionConfig.uiStyle.picture_bottom_barBackgroundColor);
            } else {
                this.mBottomLayout.setBackgroundColor(ContextCompat.getColor((Context)this.getContext(), (int)R.color.picture_color_grey));
            }
            if (PictureSelectionConfig.uiStyle.picture_top_titleRightTextColor.length > 0) {
                ColorStateList colorStateList = AttrsUtils.getColorStateList((int[])PictureSelectionConfig.uiStyle.picture_top_titleRightTextColor);
                if (colorStateList != null) {
                    this.mTvPictureRight.setTextColor(colorStateList);
                }
            } else {
                this.mTvPictureRight.setTextColor(ContextCompat.getColor((Context)this.getContext(), (int)R.color.picture_color_53575e));
            }
            if (PictureSelectionConfig.uiStyle.picture_top_titleRightTextSize != 0) {
                this.mTvPictureRight.setTextSize((float)PictureSelectionConfig.uiStyle.picture_top_titleRightTextSize);
            }
            if (this.config.isOriginalControl) {
                if (PictureSelectionConfig.uiStyle.picture_bottom_originalPictureCheckStyle != 0) {
                    this.mCbOriginal.setButtonDrawable(PictureSelectionConfig.uiStyle.picture_bottom_originalPictureCheckStyle);
                }
                if (PictureSelectionConfig.uiStyle.picture_bottom_originalPictureTextColor != 0) {
                    this.mCbOriginal.setTextColor(PictureSelectionConfig.uiStyle.picture_bottom_originalPictureTextColor);
                }
                if (PictureSelectionConfig.uiStyle.picture_bottom_originalPictureTextSize != 0) {
                    this.mCbOriginal.setTextSize((float)PictureSelectionConfig.uiStyle.picture_bottom_originalPictureTextSize);
                }
            }
            if (PictureSelectionConfig.uiStyle.picture_container_backgroundColor != 0) {
                this.container.setBackgroundColor(PictureSelectionConfig.uiStyle.picture_container_backgroundColor);
            }
            if (PictureSelectionConfig.uiStyle.picture_top_titleAlbumBackground != 0) {
                this.rlAlbum.setBackgroundResource(PictureSelectionConfig.uiStyle.picture_top_titleAlbumBackground);
            } else {
                this.rlAlbum.setBackgroundResource(R.drawable.picture_album_bg);
            }
            if (PictureSelectionConfig.uiStyle.picture_top_titleRightDefaultText != 0) {
                this.mTvPictureRight.setText((CharSequence)this.getString(PictureSelectionConfig.uiStyle.picture_top_titleRightDefaultText));
            }
        } else if (PictureSelectionConfig.style != null) {
            if (PictureSelectionConfig.style.pictureUnCompleteBackgroundStyle != 0) {
                this.mTvPictureRight.setBackgroundResource(PictureSelectionConfig.style.pictureUnCompleteBackgroundStyle);
            } else {
                this.mTvPictureRight.setBackgroundResource(R.drawable.picture_send_button_default_bg);
            }
            if (PictureSelectionConfig.style.pictureBottomBgColor != 0) {
                this.mBottomLayout.setBackgroundColor(PictureSelectionConfig.style.pictureBottomBgColor);
            } else {
                this.mBottomLayout.setBackgroundColor(ContextCompat.getColor((Context)this.getContext(), (int)R.color.picture_color_grey));
            }
            if (PictureSelectionConfig.style.pictureUnCompleteTextColor != 0) {
                this.mTvPictureRight.setTextColor(PictureSelectionConfig.style.pictureUnCompleteTextColor);
            } else if (PictureSelectionConfig.style.pictureCancelTextColor != 0) {
                this.mTvPictureRight.setTextColor(PictureSelectionConfig.style.pictureCancelTextColor);
            } else {
                this.mTvPictureRight.setTextColor(ContextCompat.getColor((Context)this.getContext(), (int)R.color.picture_color_53575e));
            }
            if (PictureSelectionConfig.style.pictureRightTextSize != 0) {
                this.mTvPictureRight.setTextSize((float)PictureSelectionConfig.style.pictureRightTextSize);
            }
            if (PictureSelectionConfig.style.pictureOriginalFontColor == 0) {
                this.mCbOriginal.setTextColor(ContextCompat.getColor((Context)this, (int)R.color.picture_color_white));
            }
            if (this.config.isOriginalControl && PictureSelectionConfig.style.pictureOriginalControlStyle == 0) {
                this.mCbOriginal.setButtonDrawable(ContextCompat.getDrawable((Context)this, (int)R.drawable.picture_original_wechat_checkbox));
            }
            if (PictureSelectionConfig.style.pictureContainerBackgroundColor != 0) {
                this.container.setBackgroundColor(PictureSelectionConfig.style.pictureContainerBackgroundColor);
            }
            if (PictureSelectionConfig.style.pictureWeChatTitleBackgroundStyle != 0) {
                this.rlAlbum.setBackgroundResource(PictureSelectionConfig.style.pictureWeChatTitleBackgroundStyle);
            } else {
                this.rlAlbum.setBackgroundResource(R.drawable.picture_album_bg);
            }
            if (!TextUtils.isEmpty((CharSequence)PictureSelectionConfig.style.pictureUnCompleteText)) {
                this.mTvPictureRight.setText((CharSequence)PictureSelectionConfig.style.pictureUnCompleteText);
            }
        } else {
            this.mTvPictureRight.setBackgroundResource(R.drawable.picture_send_button_default_bg);
            this.rlAlbum.setBackgroundResource(R.drawable.picture_album_bg);
            this.mTvPictureRight.setTextColor(ContextCompat.getColor((Context)this.getContext(), (int)R.color.picture_color_53575e));
            int n = AttrsUtils.getTypeValueColor((Context)this.getContext(), (int)R.attr.picture_bottom_bg);
            RelativeLayout relativeLayout = this.mBottomLayout;
            if (n == 0) {
                n = ContextCompat.getColor((Context)this.getContext(), (int)R.color.picture_color_grey);
            }
            relativeLayout.setBackgroundColor(n);
            this.mCbOriginal.setTextColor(ContextCompat.getColor((Context)this, (int)R.color.picture_color_white));
            relativeLayout = ContextCompat.getDrawable((Context)this, (int)R.drawable.picture_icon_wechat_down);
            this.mIvArrow.setImageDrawable((Drawable)relativeLayout);
            if (this.config.isOriginalControl) {
                this.mCbOriginal.setButtonDrawable(ContextCompat.getDrawable((Context)this, (int)R.drawable.picture_original_wechat_checkbox));
            }
        }
        super.initPictureSelectorStyle();
        this.goneParentView();
    }

    protected void initWidgets() {
        super.initWidgets();
        this.rlAlbum = (RelativeLayout)this.findViewById(R.id.rlAlbum);
        this.mTvPictureRight.setOnClickListener((View.OnClickListener)this);
        this.mTvPictureRight.setText((CharSequence)this.getString(R.string.picture_send));
        this.mTvPicturePreview.setTextSize(16.0f);
        this.mCbOriginal.setTextSize(16.0f);
        int n = this.config.selectionMode;
        int n2 = 0;
        n = n == 1 && this.config.isSingleDirectReturn ? 1 : 0;
        TextView textView = this.mTvPictureRight;
        if (n != 0) {
            n2 = 8;
        }
        textView.setVisibility(n2);
        this.mTvPictureRight.setOnClickListener((View.OnClickListener)this);
        if (!(this.rlAlbum.getLayoutParams() instanceof RelativeLayout.LayoutParams)) return;
        textView = (RelativeLayout.LayoutParams)this.rlAlbum.getLayoutParams();
        if (n != 0) {
            textView.addRule(14);
        } else {
            textView.addRule(1, R.id.pictureLeftBack);
        }
    }

    protected void onChangeData(List<LocalMedia> list) {
        super.onChangeData(list);
        this.initCompleteText(list);
    }

    public void onClick(View view) {
        if (view.getId() == R.id.picture_right) {
            if (this.folderWindow != null && this.folderWindow.isShowing()) {
                this.folderWindow.dismiss();
            } else {
                this.mTvPictureOk.performClick();
            }
        } else {
            super.onClick(view);
        }
    }
}
