/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.TimeInterpolator
 *  android.content.Context
 *  android.graphics.Color
 *  android.text.TextUtils
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.animation.AccelerateInterpolator
 *  android.widget.TextView
 *  androidx.core.content.ContextCompat
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$Adapter
 *  androidx.recyclerview.widget.RecyclerView$ItemDecoration
 *  androidx.recyclerview.widget.RecyclerView$LayoutManager
 *  com.luck.picture.lib.PicturePreviewActivity
 *  com.luck.picture.lib.R$color
 *  com.luck.picture.lib.R$drawable
 *  com.luck.picture.lib.R$id
 *  com.luck.picture.lib.R$layout
 *  com.luck.picture.lib.R$string
 *  com.luck.picture.lib._$$Lambda$PictureSelectorPreviewWeChatStyleActivity$97r5QCu_IyU6ssyaPnvNBU2xzfw
 *  com.luck.picture.lib.adapter.PictureWeChatPreviewGalleryAdapter
 *  com.luck.picture.lib.adapter.PictureWeChatPreviewGalleryAdapter$OnItemClickListener
 *  com.luck.picture.lib.config.PictureMimeType
 *  com.luck.picture.lib.config.PictureSelectionConfig
 *  com.luck.picture.lib.decoration.GridSpacingItemDecoration
 *  com.luck.picture.lib.decoration.WrapContentLinearLayoutManager
 *  com.luck.picture.lib.entity.LocalMedia
 *  com.luck.picture.lib.tools.ScreenUtils
 */
package com.luck.picture.lib;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.luck.picture.lib.PicturePreviewActivity;
import com.luck.picture.lib.R;
import com.luck.picture.lib._$;
import com.luck.picture.lib.adapter.PictureWeChatPreviewGalleryAdapter;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.config.PictureSelectionConfig;
import com.luck.picture.lib.decoration.GridSpacingItemDecoration;
import com.luck.picture.lib.decoration.WrapContentLinearLayoutManager;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.tools.ScreenUtils;

public class PictureSelectorPreviewWeChatStyleActivity
extends PicturePreviewActivity {
    private static final int ALPHA_DURATION = 300;
    private View bottomLine;
    private PictureWeChatPreviewGalleryAdapter mGalleryAdapter;
    private RecyclerView mRvGallery;
    private TextView mTvSelected;

    private void goneParent() {
        if (this.tvMediaNum.getVisibility() == 0) {
            this.tvMediaNum.setVisibility(8);
        }
        if (this.mTvPictureOk.getVisibility() == 0) {
            this.mTvPictureOk.setVisibility(8);
        }
        if (TextUtils.isEmpty((CharSequence)this.check.getText())) return;
        this.check.setText((CharSequence)"");
    }

    private boolean isEqualsDirectory(String string2, String string3) {
        boolean bl = this.isBottomPreview || TextUtils.isEmpty((CharSequence)string2) || TextUtils.isEmpty((CharSequence)string3) || string3.equals(this.getString(R.string.picture_camera_roll)) || string2.equals(string3);
        return bl;
    }

    private void onChangeMediaStatus(LocalMedia localMedia) {
        PictureWeChatPreviewGalleryAdapter pictureWeChatPreviewGalleryAdapter = this.mGalleryAdapter;
        if (pictureWeChatPreviewGalleryAdapter == null) return;
        int n = pictureWeChatPreviewGalleryAdapter.getItemCount();
        if (n <= 0) return;
        int n2 = 0;
        boolean bl = false;
        while (true) {
            boolean bl2;
            block5: {
                boolean bl3;
                block7: {
                    block9: {
                        boolean bl4;
                        boolean bl5;
                        block8: {
                            block6: {
                                if (n2 >= n) {
                                    if (!bl) return;
                                    this.mGalleryAdapter.notifyDataSetChanged();
                                    return;
                                }
                                pictureWeChatPreviewGalleryAdapter = this.mGalleryAdapter.getItem(n2);
                                bl2 = bl;
                                if (pictureWeChatPreviewGalleryAdapter == null) break block5;
                                if (!TextUtils.isEmpty((CharSequence)pictureWeChatPreviewGalleryAdapter.getPath())) break block6;
                                bl2 = bl;
                                break block5;
                            }
                            bl5 = pictureWeChatPreviewGalleryAdapter.isChecked();
                            bl3 = pictureWeChatPreviewGalleryAdapter.getPath().equals(localMedia.getPath());
                            bl4 = true;
                            bl3 = bl3 || pictureWeChatPreviewGalleryAdapter.getId() == localMedia.getId();
                            bl2 = bl;
                            if (bl) break block7;
                            if (!bl5) break block8;
                            bl = bl4;
                            if (!bl3) break block9;
                        }
                        bl = !bl5 && bl3 ? bl4 : false;
                    }
                    bl2 = bl;
                }
                pictureWeChatPreviewGalleryAdapter.setChecked(bl3);
            }
            ++n2;
            bl = bl2;
        }
    }

    public int getResourceId() {
        return R.layout.picture_wechat_style_preview;
    }

    protected void initCompleteText(int n) {
        Object object = PictureSelectionConfig.style;
        Integer n2 = 1;
        boolean bl = object != null;
        if (this.config.isWithVideoImage) {
            if (this.config.selectionMode == 1) {
                if (n <= 0) {
                    n2 = this.mTvPictureRight;
                    object = bl && !TextUtils.isEmpty((CharSequence)PictureSelectionConfig.style.pictureUnCompleteText) ? PictureSelectionConfig.style.pictureUnCompleteText : this.getString(R.string.picture_send);
                    n2.setText((CharSequence)object);
                } else {
                    n = bl && PictureSelectionConfig.style.isCompleteReplaceNum ? 1 : 0;
                    if (n != 0 && !TextUtils.isEmpty((CharSequence)PictureSelectionConfig.style.pictureCompleteText)) {
                        this.mTvPictureRight.setText((CharSequence)String.format(PictureSelectionConfig.style.pictureCompleteText, this.selectData.size(), n2));
                    } else {
                        n2 = this.mTvPictureRight;
                        object = bl && !TextUtils.isEmpty((CharSequence)PictureSelectionConfig.style.pictureCompleteText) ? PictureSelectionConfig.style.pictureCompleteText : this.getString(R.string.picture_send);
                        n2.setText((CharSequence)object);
                    }
                }
            } else {
                n = bl && PictureSelectionConfig.style.isCompleteReplaceNum ? 1 : 0;
                if (n != 0 && !TextUtils.isEmpty((CharSequence)PictureSelectionConfig.style.pictureCompleteText)) {
                    this.mTvPictureRight.setText((CharSequence)String.format(PictureSelectionConfig.style.pictureCompleteText, this.selectData.size(), this.config.maxSelectNum));
                } else {
                    n2 = this.mTvPictureRight;
                    object = bl && !TextUtils.isEmpty((CharSequence)PictureSelectionConfig.style.pictureUnCompleteText) ? PictureSelectionConfig.style.pictureUnCompleteText : this.getString(R.string.picture_send_num, new Object[]{this.selectData.size(), this.config.maxSelectNum});
                    n2.setText((CharSequence)object);
                }
            }
        } else {
            object = this.selectData.size() > 0 ? ((LocalMedia)this.selectData.get(0)).getMimeType() : "";
            int n3 = PictureMimeType.isHasVideo((String)object) && this.config.maxVideoSelectNum > 0 ? this.config.maxVideoSelectNum : this.config.maxSelectNum;
            if (this.config.selectionMode == 1) {
                if (n <= 0) {
                    n2 = this.mTvPictureRight;
                    object = bl && !TextUtils.isEmpty((CharSequence)PictureSelectionConfig.style.pictureUnCompleteText) ? PictureSelectionConfig.style.pictureUnCompleteText : this.getString(R.string.picture_send);
                    n2.setText((CharSequence)object);
                } else {
                    n = bl && PictureSelectionConfig.style.isCompleteReplaceNum ? 1 : 0;
                    if (n != 0 && !TextUtils.isEmpty((CharSequence)PictureSelectionConfig.style.pictureCompleteText)) {
                        this.mTvPictureRight.setText((CharSequence)String.format(PictureSelectionConfig.style.pictureCompleteText, this.selectData.size(), n2));
                    } else {
                        n2 = this.mTvPictureRight;
                        object = bl && !TextUtils.isEmpty((CharSequence)PictureSelectionConfig.style.pictureCompleteText) ? PictureSelectionConfig.style.pictureCompleteText : this.getString(R.string.picture_send);
                        n2.setText((CharSequence)object);
                    }
                }
            } else {
                n = bl && PictureSelectionConfig.style.isCompleteReplaceNum ? 1 : 0;
                if (n != 0 && !TextUtils.isEmpty((CharSequence)PictureSelectionConfig.style.pictureCompleteText)) {
                    this.mTvPictureRight.setText((CharSequence)String.format(PictureSelectionConfig.style.pictureCompleteText, this.selectData.size(), n3));
                } else {
                    n2 = this.mTvPictureRight;
                    object = bl && !TextUtils.isEmpty((CharSequence)PictureSelectionConfig.style.pictureUnCompleteText) ? PictureSelectionConfig.style.pictureUnCompleteText : this.getString(R.string.picture_send_num, new Object[]{this.selectData.size(), n3});
                    n2.setText((CharSequence)object);
                }
            }
        }
    }

    public void initPictureSelectorStyle() {
        super.initPictureSelectorStyle();
        if (PictureSelectionConfig.uiStyle != null) {
            if (PictureSelectionConfig.uiStyle.picture_top_titleRightDefaultText != 0) {
                this.mTvPictureRight.setText((CharSequence)this.getString(PictureSelectionConfig.uiStyle.picture_top_titleRightDefaultText));
            }
            if (PictureSelectionConfig.uiStyle.picture_top_titleRightTextNormalBackground != 0) {
                this.mTvPictureRight.setBackgroundResource(PictureSelectionConfig.uiStyle.picture_top_titleRightTextNormalBackground);
            } else {
                this.mTvPictureRight.setBackgroundResource(R.drawable.picture_send_button_bg);
            }
            if (PictureSelectionConfig.uiStyle.picture_top_titleRightTextSize != 0) {
                this.mTvPictureRight.setTextSize((float)PictureSelectionConfig.uiStyle.picture_top_titleRightTextSize);
            }
            if (PictureSelectionConfig.uiStyle.picture_bottom_selectedText != 0) {
                this.mTvSelected.setText((CharSequence)this.getString(PictureSelectionConfig.uiStyle.picture_bottom_selectedText));
            }
            if (PictureSelectionConfig.uiStyle.picture_bottom_selectedTextSize != 0) {
                this.mTvSelected.setTextSize((float)PictureSelectionConfig.uiStyle.picture_bottom_selectedTextSize);
            }
            if (PictureSelectionConfig.uiStyle.picture_bottom_selectedTextColor != 0) {
                this.mTvSelected.setTextColor(PictureSelectionConfig.uiStyle.picture_bottom_selectedTextColor);
            }
            if (PictureSelectionConfig.uiStyle.picture_bottom_barBackgroundColor != 0) {
                this.selectBarLayout.setBackgroundColor(PictureSelectionConfig.uiStyle.picture_bottom_barBackgroundColor);
            } else {
                this.selectBarLayout.setBackgroundColor(ContextCompat.getColor((Context)this.getContext(), (int)R.color.picture_color_half_grey));
            }
            this.mTvPictureRight.setTextColor(ContextCompat.getColor((Context)this.getContext(), (int)R.color.picture_color_white));
            if (PictureSelectionConfig.uiStyle.picture_bottom_selectedCheckStyle != 0) {
                this.check.setBackgroundResource(PictureSelectionConfig.uiStyle.picture_bottom_selectedCheckStyle);
            } else {
                this.check.setBackgroundResource(R.drawable.picture_wechat_select_cb);
            }
            if (PictureSelectionConfig.uiStyle.picture_top_leftBack != 0) {
                this.pictureLeftBack.setImageResource(PictureSelectionConfig.uiStyle.picture_top_leftBack);
            } else {
                this.pictureLeftBack.setImageResource(R.drawable.picture_icon_back);
            }
            if (PictureSelectionConfig.uiStyle.picture_bottom_gallery_backgroundColor != 0) {
                this.mRvGallery.setBackgroundColor(PictureSelectionConfig.uiStyle.picture_bottom_gallery_backgroundColor);
            }
            if (PictureSelectionConfig.uiStyle.picture_bottom_gallery_height > 0) {
                this.mRvGallery.getLayoutParams().height = PictureSelectionConfig.uiStyle.picture_bottom_gallery_height;
            }
            if (this.config.isOriginalControl) {
                if (PictureSelectionConfig.uiStyle.picture_bottom_originalPictureText != 0) {
                    this.mCbOriginal.setText((CharSequence)this.getString(PictureSelectionConfig.uiStyle.picture_bottom_originalPictureText));
                } else {
                    this.mCbOriginal.setText((CharSequence)this.getString(R.string.picture_original_image));
                }
                if (PictureSelectionConfig.uiStyle.picture_bottom_originalPictureTextSize != 0) {
                    this.mCbOriginal.setTextSize((float)PictureSelectionConfig.uiStyle.picture_bottom_originalPictureTextSize);
                } else {
                    this.mCbOriginal.setTextSize(14.0f);
                }
                if (PictureSelectionConfig.uiStyle.picture_bottom_originalPictureTextColor != 0) {
                    this.mCbOriginal.setTextColor(PictureSelectionConfig.uiStyle.picture_bottom_originalPictureTextColor);
                } else {
                    this.mCbOriginal.setTextColor(Color.parseColor((String)"#FFFFFF"));
                }
                if (PictureSelectionConfig.uiStyle.picture_bottom_originalPictureCheckStyle != 0) {
                    this.mCbOriginal.setButtonDrawable(PictureSelectionConfig.uiStyle.picture_bottom_originalPictureCheckStyle);
                } else {
                    this.mCbOriginal.setButtonDrawable(R.drawable.picture_original_wechat_checkbox);
                }
            }
        } else if (PictureSelectionConfig.style != null) {
            if (PictureSelectionConfig.style.pictureCompleteBackgroundStyle != 0) {
                this.mTvPictureRight.setBackgroundResource(PictureSelectionConfig.style.pictureCompleteBackgroundStyle);
            } else {
                this.mTvPictureRight.setBackgroundResource(R.drawable.picture_send_button_bg);
            }
            if (PictureSelectionConfig.style.pictureRightTextSize != 0) {
                this.mTvPictureRight.setTextSize((float)PictureSelectionConfig.style.pictureRightTextSize);
            }
            if (!TextUtils.isEmpty((CharSequence)PictureSelectionConfig.style.pictureWeChatPreviewSelectedText)) {
                this.mTvSelected.setText((CharSequence)PictureSelectionConfig.style.pictureWeChatPreviewSelectedText);
            }
            if (PictureSelectionConfig.style.pictureWeChatPreviewSelectedTextSize != 0) {
                this.mTvSelected.setTextSize((float)PictureSelectionConfig.style.pictureWeChatPreviewSelectedTextSize);
            }
            if (PictureSelectionConfig.style.picturePreviewBottomBgColor != 0) {
                this.selectBarLayout.setBackgroundColor(PictureSelectionConfig.style.picturePreviewBottomBgColor);
            } else {
                this.selectBarLayout.setBackgroundColor(ContextCompat.getColor((Context)this.getContext(), (int)R.color.picture_color_half_grey));
            }
            if (PictureSelectionConfig.style.pictureCompleteTextColor != 0) {
                this.mTvPictureRight.setTextColor(PictureSelectionConfig.style.pictureCompleteTextColor);
            } else if (PictureSelectionConfig.style.pictureCancelTextColor != 0) {
                this.mTvPictureRight.setTextColor(PictureSelectionConfig.style.pictureCancelTextColor);
            } else {
                this.mTvPictureRight.setTextColor(ContextCompat.getColor((Context)this.getContext(), (int)R.color.picture_color_white));
            }
            if (PictureSelectionConfig.style.pictureOriginalFontColor == 0) {
                this.mCbOriginal.setTextColor(ContextCompat.getColor((Context)this, (int)R.color.picture_color_white));
            }
            if (PictureSelectionConfig.style.pictureWeChatChooseStyle != 0) {
                this.check.setBackgroundResource(PictureSelectionConfig.style.pictureWeChatChooseStyle);
            } else {
                this.check.setBackgroundResource(R.drawable.picture_wechat_select_cb);
            }
            if (this.config.isOriginalControl && PictureSelectionConfig.style.pictureOriginalControlStyle == 0) {
                this.mCbOriginal.setButtonDrawable(ContextCompat.getDrawable((Context)this, (int)R.drawable.picture_original_wechat_checkbox));
            }
            if (PictureSelectionConfig.style.pictureWeChatLeftBackStyle != 0) {
                this.pictureLeftBack.setImageResource(PictureSelectionConfig.style.pictureWeChatLeftBackStyle);
            } else {
                this.pictureLeftBack.setImageResource(R.drawable.picture_icon_back);
            }
            if (!TextUtils.isEmpty((CharSequence)PictureSelectionConfig.style.pictureUnCompleteText)) {
                this.mTvPictureRight.setText((CharSequence)PictureSelectionConfig.style.pictureUnCompleteText);
            }
        } else {
            this.mTvPictureRight.setBackgroundResource(R.drawable.picture_send_button_bg);
            this.mTvPictureRight.setTextColor(ContextCompat.getColor((Context)this.getContext(), (int)R.color.picture_color_white));
            this.selectBarLayout.setBackgroundColor(ContextCompat.getColor((Context)this.getContext(), (int)R.color.picture_color_half_grey));
            this.check.setBackgroundResource(R.drawable.picture_wechat_select_cb);
            this.pictureLeftBack.setImageResource(R.drawable.picture_icon_back);
            this.mCbOriginal.setTextColor(ContextCompat.getColor((Context)this, (int)R.color.picture_color_white));
            if (this.config.isOriginalControl) {
                this.mCbOriginal.setButtonDrawable(ContextCompat.getDrawable((Context)this, (int)R.drawable.picture_original_wechat_checkbox));
            }
        }
        this.onSelectNumChange(false);
    }

    protected void initWidgets() {
        super.initWidgets();
        this.goneParent();
        this.mRvGallery = (RecyclerView)this.findViewById(R.id.rv_gallery);
        this.bottomLine = this.findViewById(R.id.bottomLine);
        this.mTvPictureRight.setVisibility(0);
        this.mTvPictureRight.setText((CharSequence)this.getString(R.string.picture_send));
        this.mCbOriginal.setTextSize(16.0f);
        this.mTvSelected = (TextView)this.findViewById(R.id.tv_selected);
        this.mTvPictureRight.setOnClickListener((View.OnClickListener)this);
        this.mGalleryAdapter = new PictureWeChatPreviewGalleryAdapter(this.config);
        WrapContentLinearLayoutManager wrapContentLinearLayoutManager = new WrapContentLinearLayoutManager(this.getContext());
        wrapContentLinearLayoutManager.setOrientation(0);
        this.mRvGallery.setLayoutManager((RecyclerView.LayoutManager)wrapContentLinearLayoutManager);
        this.mRvGallery.addItemDecoration((RecyclerView.ItemDecoration)new GridSpacingItemDecoration(Integer.MAX_VALUE, ScreenUtils.dip2px((Context)this, (float)8.0f), false));
        this.mRvGallery.setAdapter((RecyclerView.Adapter)this.mGalleryAdapter);
        this.mGalleryAdapter.setItemClickListener((PictureWeChatPreviewGalleryAdapter.OnItemClickListener)new _$.Lambda.PictureSelectorPreviewWeChatStyleActivity.97r5QCu_IyU6ssyaPnvNBU2xzfw(this));
        if (this.isBottomPreview) {
            if (this.selectData.size() <= this.position) return;
            int n = this.selectData.size();
            int n2 = 0;
            while (true) {
                if (n2 >= n) {
                    ((LocalMedia)this.selectData.get(this.position)).setChecked(true);
                    return;
                }
                ((LocalMedia)this.selectData.get(n2)).setChecked(false);
                ++n2;
            }
        }
        int n = this.selectData.size();
        int n3 = 0;
        while (n3 < n) {
            wrapContentLinearLayoutManager = (LocalMedia)this.selectData.get(n3);
            if (this.isEqualsDirectory(wrapContentLinearLayoutManager.getParentFolderName(), this.currentDirectory)) {
                boolean bl = this.isShowCamera ? wrapContentLinearLayoutManager.position - 1 == this.position : wrapContentLinearLayoutManager.position == this.position;
                wrapContentLinearLayoutManager.setChecked(bl);
            }
            ++n3;
        }
    }

    public /* synthetic */ void lambda$initWidgets$0$PictureSelectorPreviewWeChatStyleActivity(int n, LocalMedia localMedia, View view) {
        if (this.viewPager == null) return;
        if (localMedia == null) return;
        if (!this.isEqualsDirectory(localMedia.getParentFolderName(), this.currentDirectory)) return;
        if (!this.isBottomPreview) {
            n = this.isShowCamera ? localMedia.position - 1 : localMedia.position;
        }
        this.viewPager.setCurrentItem(n);
    }

    public void onClick(View view) {
        super.onClick(view);
        if (view.getId() != R.id.picture_right) return;
        int n = this.selectData.size();
        int n2 = 1;
        n = n != 0 ? 1 : 0;
        if (n != 0) {
            this.mTvPictureOk.performClick();
        } else {
            this.btnCheck.performClick();
            n = this.selectData.size() != 0 ? n2 : 0;
            if (n == 0) return;
            this.mTvPictureOk.performClick();
        }
    }

    protected void onPageSelectedChange(LocalMedia localMedia) {
        super.onPageSelectedChange(localMedia);
        this.goneParent();
        if (this.config.previewEggs) return;
        this.onChangeMediaStatus(localMedia);
    }

    protected void onSelectNumChange(boolean bl) {
        this.goneParent();
        boolean bl2 = this.selectData.size() != 0;
        if (bl2) {
            this.initCompleteText(this.selectData.size());
            if (this.mRvGallery.getVisibility() == 8) {
                this.mRvGallery.animate().alpha(1.0f).setDuration(300L).setInterpolator((TimeInterpolator)new AccelerateInterpolator());
                this.mRvGallery.setVisibility(0);
                this.bottomLine.animate().alpha(1.0f).setDuration(300L).setInterpolator((TimeInterpolator)new AccelerateInterpolator());
                this.bottomLine.setVisibility(0);
                this.mGalleryAdapter.setNewData(this.selectData);
            }
            if (PictureSelectionConfig.style != null) {
                if (PictureSelectionConfig.style.pictureCompleteTextColor != 0) {
                    this.mTvPictureRight.setTextColor(PictureSelectionConfig.style.pictureCompleteTextColor);
                }
                if (PictureSelectionConfig.style.pictureCompleteBackgroundStyle == 0) return;
                this.mTvPictureRight.setBackgroundResource(PictureSelectionConfig.style.pictureCompleteBackgroundStyle);
            } else {
                this.mTvPictureRight.setTextColor(ContextCompat.getColor((Context)this.getContext(), (int)R.color.picture_color_white));
                this.mTvPictureRight.setBackgroundResource(R.drawable.picture_send_button_bg);
            }
        } else {
            if (PictureSelectionConfig.style != null && !TextUtils.isEmpty((CharSequence)PictureSelectionConfig.style.pictureUnCompleteText)) {
                this.mTvPictureRight.setText((CharSequence)PictureSelectionConfig.style.pictureUnCompleteText);
            } else {
                this.mTvPictureRight.setText((CharSequence)this.getString(R.string.picture_send));
            }
            this.mRvGallery.animate().alpha(0.0f).setDuration(300L).setInterpolator((TimeInterpolator)new AccelerateInterpolator());
            this.mRvGallery.setVisibility(8);
            this.bottomLine.animate().alpha(0.0f).setDuration(300L).setInterpolator((TimeInterpolator)new AccelerateInterpolator());
            this.bottomLine.setVisibility(8);
        }
    }

    protected void onSelectedChange(boolean bl, LocalMedia localMedia) {
        int n;
        if (bl) {
            localMedia.setChecked(true);
            if (this.config.selectionMode == 1) {
                this.mGalleryAdapter.addSingleMediaToData(localMedia);
            }
        } else {
            localMedia.setChecked(false);
            this.mGalleryAdapter.removeMediaToData(localMedia);
            if (this.isBottomPreview) {
                if (this.selectData.size() > this.position) {
                    ((LocalMedia)this.selectData.get(this.position)).setChecked(true);
                }
                if (this.mGalleryAdapter.isDataEmpty()) {
                    this.onActivityBackPressed();
                } else {
                    n = this.viewPager.getCurrentItem();
                    this.adapter.remove(n);
                    this.adapter.removeCacheView(n);
                    this.position = n;
                    this.tvTitle.setText((CharSequence)this.getString(R.string.picture_preview_image_num, new Object[]{this.position + 1, this.adapter.getSize()}));
                    this.check.setSelected(true);
                    this.adapter.notifyDataSetChanged();
                }
            }
        }
        if ((n = this.mGalleryAdapter.getItemCount()) <= 5) return;
        this.mRvGallery.smoothScrollToPosition(n - 1);
    }

    protected void onUpdateSelectedChange(LocalMedia localMedia) {
        this.onChangeMediaStatus(localMedia);
    }
}
