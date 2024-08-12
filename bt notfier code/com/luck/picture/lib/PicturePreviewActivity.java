/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.content.res.ColorStateList
 *  android.graphics.drawable.Drawable
 *  android.os.Bundle
 *  android.os.Handler
 *  android.text.TextUtils
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.animation.Animation
 *  android.view.animation.AnimationUtils
 *  android.widget.CheckBox
 *  android.widget.CompoundButton
 *  android.widget.CompoundButton$OnCheckedChangeListener
 *  android.widget.ImageView
 *  android.widget.RelativeLayout
 *  android.widget.TextView
 *  androidx.core.content.ContextCompat
 *  androidx.viewpager.widget.PagerAdapter
 *  androidx.viewpager.widget.ViewPager$OnPageChangeListener
 *  com.luck.picture.lib.PictureBaseActivity
 *  com.luck.picture.lib.PictureSelector
 *  com.luck.picture.lib.R$anim
 *  com.luck.picture.lib.R$attr
 *  com.luck.picture.lib.R$color
 *  com.luck.picture.lib.R$drawable
 *  com.luck.picture.lib.R$id
 *  com.luck.picture.lib.R$layout
 *  com.luck.picture.lib.R$string
 *  com.luck.picture.lib._$$Lambda$PicturePreviewActivity$3_jAuvOj7JQFdqpUoQW_lDGW_pk
 *  com.luck.picture.lib._$$Lambda$PicturePreviewActivity$HLaLkMj8zYGZQPr53YXN8Zf36Fo
 *  com.luck.picture.lib._$$Lambda$PicturePreviewActivity$a5nLn2iN4Zdw1HgJtil8LcrnM5k
 *  com.luck.picture.lib.adapter.PictureSimpleFragmentAdapter
 *  com.luck.picture.lib.adapter.PictureSimpleFragmentAdapter$OnCallBackActivity
 *  com.luck.picture.lib.config.PictureMimeType
 *  com.luck.picture.lib.config.PictureSelectionConfig
 *  com.luck.picture.lib.entity.LocalMedia
 *  com.luck.picture.lib.listener.OnQueryDataResultListener
 *  com.luck.picture.lib.manager.UCropManager
 *  com.luck.picture.lib.model.LocalMediaPageLoader
 *  com.luck.picture.lib.observable.ImagesObservable
 *  com.luck.picture.lib.tools.AttrsUtils
 *  com.luck.picture.lib.tools.MediaUtils
 *  com.luck.picture.lib.tools.ScreenUtils
 *  com.luck.picture.lib.tools.StringUtils
 *  com.luck.picture.lib.tools.ToastUtils
 *  com.luck.picture.lib.tools.ValueOf
 *  com.luck.picture.lib.tools.VoiceUtils
 *  com.luck.picture.lib.widget.PreviewViewPager
 *  com.yalantis.ucrop.UCrop
 */
package com.luck.picture.lib;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.luck.picture.lib.PictureBaseActivity;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.R;
import com.luck.picture.lib._$;
import com.luck.picture.lib.adapter.PictureSimpleFragmentAdapter;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.config.PictureSelectionConfig;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.listener.OnQueryDataResultListener;
import com.luck.picture.lib.manager.UCropManager;
import com.luck.picture.lib.model.LocalMediaPageLoader;
import com.luck.picture.lib.observable.ImagesObservable;
import com.luck.picture.lib.tools.AttrsUtils;
import com.luck.picture.lib.tools.MediaUtils;
import com.luck.picture.lib.tools.ScreenUtils;
import com.luck.picture.lib.tools.StringUtils;
import com.luck.picture.lib.tools.ToastUtils;
import com.luck.picture.lib.tools.ValueOf;
import com.luck.picture.lib.tools.VoiceUtils;
import com.luck.picture.lib.widget.PreviewViewPager;
import com.yalantis.ucrop.UCrop;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class PicturePreviewActivity
extends PictureBaseActivity
implements View.OnClickListener,
PictureSimpleFragmentAdapter.OnCallBackActivity {
    private static final String TAG = PicturePreviewActivity.class.getSimpleName();
    protected PictureSimpleFragmentAdapter adapter;
    protected Animation animation;
    protected View btnCheck;
    protected TextView check;
    protected String currentDirectory;
    protected int index;
    protected boolean isBottomPreview;
    protected boolean isChangeSelectedData;
    protected boolean isCompleteOrSelected;
    protected boolean isShowCamera;
    protected CheckBox mCbOriginal;
    protected Handler mHandler;
    protected ImageView mIvArrow;
    private int mPage = 0;
    protected View mPicturePreview;
    protected ViewGroup mTitleBar;
    protected TextView mTvPictureOk;
    protected TextView mTvPictureRight;
    protected ImageView pictureLeftBack;
    protected int position;
    protected boolean refresh;
    protected int screenWidth;
    protected RelativeLayout selectBarLayout;
    protected List<LocalMedia> selectData = new ArrayList<LocalMedia>();
    private int totalNumber;
    protected TextView tvMediaNum;
    protected TextView tvTitle;
    protected PreviewViewPager viewPager;

    static /* synthetic */ void access$000(PicturePreviewActivity picturePreviewActivity, boolean bl, int n, int n2) {
        picturePreviewActivity.isPreviewEggs(bl, n, n2);
    }

    static /* synthetic */ void access$100(PicturePreviewActivity picturePreviewActivity) {
        picturePreviewActivity.setTitle();
    }

    static /* synthetic */ void access$200(PicturePreviewActivity picturePreviewActivity, LocalMedia localMedia) {
        picturePreviewActivity.notifyCheckChanged(localMedia);
    }

    static /* synthetic */ void access$300(PicturePreviewActivity picturePreviewActivity) {
        picturePreviewActivity.loadMoreData();
    }

    private void bothMimeTypeWith(String string, LocalMedia localMedia) {
        block9: {
            int n;
            int n2;
            block10: {
                block7: {
                    block8: {
                        if (!this.config.enableCrop) break block7;
                        this.isCompleteOrSelected = false;
                        boolean bl = PictureMimeType.isHasImage((String)string);
                        if (this.config.selectionMode != 1 || !bl) break block8;
                        this.config.originalPath = localMedia.getPath();
                        UCropManager.ofCrop((Activity)this, (String)this.config.originalPath, (String)localMedia.getMimeType());
                        break block9;
                    }
                    n2 = this.selectData.size();
                    n = 0;
                    break block10;
                }
                this.onBackPressed();
                break block9;
            }
            for (int i = 0; i < n2; ++i) {
                string = this.selectData.get(i);
                int n3 = n;
                if (string != null) {
                    if (TextUtils.isEmpty((CharSequence)string.getPath())) {
                        n3 = n;
                    } else {
                        n3 = n;
                        if (PictureMimeType.isHasImage((String)string.getMimeType())) {
                            n3 = n + 1;
                        }
                    }
                }
                n = n3;
            }
            if (n <= 0) {
                this.isCompleteOrSelected = true;
                this.onBackPressed();
            } else {
                UCropManager.ofCrop((Activity)this, (ArrayList)((ArrayList)this.selectData));
            }
        }
    }

    private void initViewPageAdapterData(List<LocalMedia> localMedia) {
        PictureSimpleFragmentAdapter pictureSimpleFragmentAdapter;
        this.adapter = pictureSimpleFragmentAdapter = new PictureSimpleFragmentAdapter(this.config, (PictureSimpleFragmentAdapter.OnCallBackActivity)this);
        pictureSimpleFragmentAdapter.bindData(localMedia);
        this.viewPager.setAdapter((PagerAdapter)this.adapter);
        this.viewPager.setCurrentItem(this.position);
        this.setTitle();
        this.onImageChecked(this.position);
        localMedia = this.adapter.getItem(this.position);
        if (localMedia == null) return;
        this.index = localMedia.getPosition();
        if (!this.config.checkNumMode) return;
        this.tvMediaNum.setSelected(true);
        this.check.setText((CharSequence)ValueOf.toString((Object)localMedia.getNum()));
        this.notifyCheckChanged(localMedia);
    }

    private void isPreviewEggs(boolean bl, int n, int n2) {
        if (!bl) return;
        if (this.adapter.getSize() <= 0) return;
        if (n2 < this.screenWidth / 2) {
            LocalMedia localMedia = this.adapter.getItem(n);
            if (localMedia == null) return;
            this.check.setSelected(this.isSelected(localMedia));
            if (this.config.isWeChatStyle) {
                this.onUpdateSelectedChange(localMedia);
            } else {
                if (!this.config.checkNumMode) return;
                n2 = localMedia.getNum();
                this.check.setText((CharSequence)ValueOf.toString((Object)n2));
                this.notifyCheckChanged(localMedia);
                this.onImageChecked(n);
            }
        } else {
            PictureSimpleFragmentAdapter pictureSimpleFragmentAdapter = this.adapter;
            n2 = n + 1;
            if ((pictureSimpleFragmentAdapter = pictureSimpleFragmentAdapter.getItem(n2)) == null) return;
            this.check.setSelected(this.isSelected((LocalMedia)pictureSimpleFragmentAdapter));
            if (this.config.isWeChatStyle) {
                this.onUpdateSelectedChange((LocalMedia)pictureSimpleFragmentAdapter);
            } else {
                if (!this.config.checkNumMode) return;
                n = pictureSimpleFragmentAdapter.getNum();
                this.check.setText((CharSequence)ValueOf.toString((Object)n));
                this.notifyCheckChanged((LocalMedia)pictureSimpleFragmentAdapter);
                this.onImageChecked(n2);
            }
        }
    }

    private void loadData() {
        long l = this.getIntent().getLongExtra("bucket_id", -1L);
        ++this.mPage;
        LocalMediaPageLoader.getInstance((Context)this.getContext()).loadPageMediaData(l, this.mPage, this.config.pageSize, (OnQueryDataResultListener)new _$.Lambda.PicturePreviewActivity.HLaLkMj8zYGZQPr53YXN8Zf36Fo(this));
    }

    private void loadMoreData() {
        long l = this.getIntent().getLongExtra("bucket_id", -1L);
        ++this.mPage;
        LocalMediaPageLoader.getInstance((Context)this.getContext()).loadPageMediaData(l, this.mPage, this.config.pageSize, (OnQueryDataResultListener)new _$.Lambda.PicturePreviewActivity.a5nLn2iN4Zdw1HgJtil8LcrnM5k(this));
    }

    private void notifyCheckChanged(LocalMedia localMedia) {
        if (!this.config.checkNumMode) return;
        this.check.setText((CharSequence)"");
        int n = this.selectData.size();
        int n2 = 0;
        while (n2 < n) {
            LocalMedia localMedia2 = this.selectData.get(n2);
            if (localMedia2.getPath().equals(localMedia.getPath()) || localMedia2.getId() == localMedia.getId()) {
                localMedia.setNum(localMedia2.getNum());
                this.check.setText((CharSequence)ValueOf.toString((Object)localMedia.getNum()));
            }
            ++n2;
        }
    }

    private void separateMimeTypeWith(String string, LocalMedia localMedia) {
        if (this.config.enableCrop && PictureMimeType.isHasImage((String)string)) {
            this.isCompleteOrSelected = false;
            if (this.config.selectionMode == 1) {
                this.config.originalPath = localMedia.getPath();
                UCropManager.ofCrop((Activity)this, (String)this.config.originalPath, (String)localMedia.getMimeType());
            } else {
                UCropManager.ofCrop((Activity)this, (ArrayList)((ArrayList)this.selectData));
            }
        } else {
            this.onBackPressed();
        }
    }

    private void setNewTitle() {
        this.mPage = 0;
        this.position = 0;
        this.setTitle();
    }

    private void setTitle() {
        if (this.config.isPageStrategy && !this.isBottomPreview) {
            this.tvTitle.setText((CharSequence)this.getString(R.string.picture_preview_image_num, new Object[]{this.position + 1, this.totalNumber}));
        } else {
            this.tvTitle.setText((CharSequence)this.getString(R.string.picture_preview_image_num, new Object[]{this.position + 1, this.adapter.getSize()}));
        }
    }

    private void subSelectPosition() {
        int n = this.selectData.size();
        int n2 = 0;
        while (n2 < n) {
            LocalMedia localMedia = this.selectData.get(n2);
            localMedia.setNum(++n2);
        }
    }

    private void updateResult() {
        Intent intent = new Intent();
        if (this.isChangeSelectedData) {
            intent.putExtra("isCompleteOrSelected", this.isCompleteOrSelected);
            intent.putParcelableArrayListExtra("selectList", (ArrayList)this.selectData);
        }
        if (this.config.isOriginalControl) {
            intent.putExtra("isOriginal", this.config.isCheckOriginalImage);
        }
        this.setResult(0, intent);
    }

    public int getResourceId() {
        return R.layout.picture_preview;
    }

    protected void initCompleteText(int n) {
        int n2 = this.config.selectionMode;
        Object object = 1;
        if (n2 == 1) {
            if (n <= 0) {
                if (PictureSelectionConfig.uiStyle != null) {
                    object = this.mTvPictureOk;
                    n = PictureSelectionConfig.uiStyle.picture_bottom_completeDefaultText != 0 ? PictureSelectionConfig.uiStyle.picture_bottom_completeDefaultText : R.string.picture_please_select;
                    object.setText((CharSequence)this.getString(n));
                } else {
                    if (PictureSelectionConfig.style == null) return;
                    TextView textView = this.mTvPictureOk;
                    object = !TextUtils.isEmpty((CharSequence)PictureSelectionConfig.style.pictureUnCompleteText) ? PictureSelectionConfig.style.pictureUnCompleteText : this.getString(R.string.picture_please_select);
                    textView.setText((CharSequence)object);
                }
            } else if (PictureSelectionConfig.uiStyle != null) {
                if (PictureSelectionConfig.uiStyle.isCompleteReplaceNum && PictureSelectionConfig.uiStyle.picture_bottom_completeNormalText != 0) {
                    this.mTvPictureOk.setText((CharSequence)String.format(this.getString(PictureSelectionConfig.uiStyle.picture_bottom_completeNormalText), n, object));
                } else {
                    object = this.mTvPictureOk;
                    n = PictureSelectionConfig.uiStyle.picture_bottom_completeNormalText != 0 ? PictureSelectionConfig.uiStyle.picture_bottom_completeNormalText : R.string.picture_done;
                    object.setText((CharSequence)this.getString(n));
                }
            } else {
                if (PictureSelectionConfig.style == null) return;
                if (PictureSelectionConfig.style.isCompleteReplaceNum && !TextUtils.isEmpty((CharSequence)PictureSelectionConfig.style.pictureCompleteText)) {
                    this.mTvPictureOk.setText((CharSequence)String.format(PictureSelectionConfig.style.pictureCompleteText, n, object));
                } else {
                    TextView textView = this.mTvPictureOk;
                    object = !TextUtils.isEmpty((CharSequence)PictureSelectionConfig.style.pictureCompleteText) ? PictureSelectionConfig.style.pictureCompleteText : this.getString(R.string.picture_done);
                    textView.setText((CharSequence)object);
                }
            }
        } else if (n <= 0) {
            if (PictureSelectionConfig.uiStyle != null) {
                TextView textView = this.mTvPictureOk;
                object = PictureSelectionConfig.uiStyle.isCompleteReplaceNum && PictureSelectionConfig.uiStyle.picture_bottom_completeDefaultText != 0 ? String.format(this.getString(PictureSelectionConfig.uiStyle.picture_bottom_completeDefaultText), n, this.config.maxSelectNum) : this.getString(R.string.picture_done_front_num, new Object[]{n, this.config.maxSelectNum});
                textView.setText((CharSequence)object);
            } else {
                if (PictureSelectionConfig.style == null) return;
                TextView textView = this.mTvPictureOk;
                object = PictureSelectionConfig.style.isCompleteReplaceNum && !TextUtils.isEmpty((CharSequence)PictureSelectionConfig.style.pictureUnCompleteText) ? PictureSelectionConfig.style.pictureUnCompleteText : this.getString(R.string.picture_done_front_num, new Object[]{n, this.config.maxSelectNum});
                textView.setText((CharSequence)object);
            }
        } else if (PictureSelectionConfig.uiStyle != null) {
            if (PictureSelectionConfig.uiStyle.isCompleteReplaceNum && PictureSelectionConfig.uiStyle.picture_bottom_completeNormalText != 0) {
                this.mTvPictureOk.setText((CharSequence)String.format(this.getString(PictureSelectionConfig.uiStyle.picture_bottom_completeNormalText), n, this.config.maxSelectNum));
            } else {
                this.mTvPictureOk.setText((CharSequence)this.getString(R.string.picture_done_front_num, new Object[]{n, this.config.maxSelectNum}));
            }
        } else {
            if (PictureSelectionConfig.style == null) return;
            if (PictureSelectionConfig.style.isCompleteReplaceNum && !TextUtils.isEmpty((CharSequence)PictureSelectionConfig.style.pictureCompleteText)) {
                this.mTvPictureOk.setText((CharSequence)String.format(PictureSelectionConfig.style.pictureCompleteText, n, this.config.maxSelectNum));
            } else {
                this.mTvPictureOk.setText((CharSequence)this.getString(R.string.picture_done_front_num, new Object[]{n, this.config.maxSelectNum}));
            }
        }
    }

    public void initPictureSelectorStyle() {
        if (PictureSelectionConfig.uiStyle != null) {
            ColorStateList colorStateList;
            if (PictureSelectionConfig.uiStyle.picture_top_titleTextColor != 0) {
                this.tvTitle.setTextColor(PictureSelectionConfig.uiStyle.picture_top_titleTextColor);
            }
            if (PictureSelectionConfig.uiStyle.picture_top_titleTextSize != 0) {
                this.tvTitle.setTextSize((float)PictureSelectionConfig.uiStyle.picture_top_titleTextSize);
            }
            if (PictureSelectionConfig.uiStyle.picture_top_leftBack != 0) {
                this.pictureLeftBack.setImageResource(PictureSelectionConfig.uiStyle.picture_top_leftBack);
            }
            if (PictureSelectionConfig.uiStyle.picture_bottom_barBackgroundColor != 0) {
                this.selectBarLayout.setBackgroundColor(PictureSelectionConfig.uiStyle.picture_bottom_barBackgroundColor);
            }
            if (PictureSelectionConfig.uiStyle.picture_bottom_completeRedDotBackground != 0) {
                this.tvMediaNum.setBackgroundResource(PictureSelectionConfig.uiStyle.picture_bottom_completeRedDotBackground);
            }
            if (PictureSelectionConfig.uiStyle.picture_check_style != 0) {
                this.check.setBackgroundResource(PictureSelectionConfig.uiStyle.picture_check_style);
            }
            if (PictureSelectionConfig.uiStyle.picture_bottom_completeTextColor.length > 0 && (colorStateList = AttrsUtils.getColorStateList((int[])PictureSelectionConfig.uiStyle.picture_bottom_completeTextColor)) != null) {
                this.mTvPictureOk.setTextColor(colorStateList);
            }
            if (PictureSelectionConfig.uiStyle.picture_bottom_completeDefaultText != 0) {
                this.mTvPictureOk.setText(PictureSelectionConfig.uiStyle.picture_bottom_completeDefaultText);
            }
            if (PictureSelectionConfig.uiStyle.picture_top_titleBarHeight > 0) {
                this.mTitleBar.getLayoutParams().height = PictureSelectionConfig.uiStyle.picture_top_titleBarHeight;
            }
            if (PictureSelectionConfig.uiStyle.picture_bottom_barHeight > 0) {
                this.selectBarLayout.getLayoutParams().height = PictureSelectionConfig.uiStyle.picture_bottom_barHeight;
            }
            if (this.config.isOriginalControl) {
                if (PictureSelectionConfig.uiStyle.picture_bottom_originalPictureCheckStyle != 0) {
                    this.mCbOriginal.setButtonDrawable(PictureSelectionConfig.uiStyle.picture_bottom_originalPictureCheckStyle);
                } else {
                    this.mCbOriginal.setButtonDrawable(ContextCompat.getDrawable((Context)this, (int)R.drawable.picture_original_checkbox));
                }
                if (PictureSelectionConfig.uiStyle.picture_bottom_originalPictureTextColor != 0) {
                    this.mCbOriginal.setTextColor(PictureSelectionConfig.uiStyle.picture_bottom_originalPictureTextColor);
                } else {
                    this.mCbOriginal.setTextColor(ContextCompat.getColor((Context)this, (int)R.color.picture_color_53575e));
                }
                if (PictureSelectionConfig.uiStyle.picture_bottom_originalPictureTextSize != 0) {
                    this.mCbOriginal.setTextSize((float)PictureSelectionConfig.uiStyle.picture_bottom_originalPictureTextSize);
                }
            } else {
                this.mCbOriginal.setButtonDrawable(ContextCompat.getDrawable((Context)this, (int)R.drawable.picture_original_checkbox));
                this.mCbOriginal.setTextColor(ContextCompat.getColor((Context)this, (int)R.color.picture_color_53575e));
            }
        } else if (PictureSelectionConfig.style != null) {
            if (PictureSelectionConfig.style.pictureTitleTextColor != 0) {
                this.tvTitle.setTextColor(PictureSelectionConfig.style.pictureTitleTextColor);
            }
            if (PictureSelectionConfig.style.pictureTitleTextSize != 0) {
                this.tvTitle.setTextSize((float)PictureSelectionConfig.style.pictureTitleTextSize);
            }
            if (PictureSelectionConfig.style.pictureLeftBackIcon != 0) {
                this.pictureLeftBack.setImageResource(PictureSelectionConfig.style.pictureLeftBackIcon);
            }
            if (PictureSelectionConfig.style.picturePreviewBottomBgColor != 0) {
                this.selectBarLayout.setBackgroundColor(PictureSelectionConfig.style.picturePreviewBottomBgColor);
            }
            if (PictureSelectionConfig.style.pictureCheckNumBgStyle != 0) {
                this.tvMediaNum.setBackgroundResource(PictureSelectionConfig.style.pictureCheckNumBgStyle);
            }
            if (PictureSelectionConfig.style.pictureCheckedStyle != 0) {
                this.check.setBackgroundResource(PictureSelectionConfig.style.pictureCheckedStyle);
            }
            if (PictureSelectionConfig.style.pictureUnCompleteTextColor != 0) {
                this.mTvPictureOk.setTextColor(PictureSelectionConfig.style.pictureUnCompleteTextColor);
            }
            if (!TextUtils.isEmpty((CharSequence)PictureSelectionConfig.style.pictureUnCompleteText)) {
                this.mTvPictureOk.setText((CharSequence)PictureSelectionConfig.style.pictureUnCompleteText);
            }
            if (PictureSelectionConfig.style.pictureTitleBarHeight > 0) {
                this.mTitleBar.getLayoutParams().height = PictureSelectionConfig.style.pictureTitleBarHeight;
            }
            if (this.config.isOriginalControl) {
                if (PictureSelectionConfig.style.pictureOriginalControlStyle != 0) {
                    this.mCbOriginal.setButtonDrawable(PictureSelectionConfig.style.pictureOriginalControlStyle);
                } else {
                    this.mCbOriginal.setButtonDrawable(ContextCompat.getDrawable((Context)this, (int)R.drawable.picture_original_checkbox));
                }
                if (PictureSelectionConfig.style.pictureOriginalFontColor != 0) {
                    this.mCbOriginal.setTextColor(PictureSelectionConfig.style.pictureOriginalFontColor);
                } else {
                    this.mCbOriginal.setTextColor(ContextCompat.getColor((Context)this, (int)R.color.picture_color_53575e));
                }
                if (PictureSelectionConfig.style.pictureOriginalTextSize != 0) {
                    this.mCbOriginal.setTextSize((float)PictureSelectionConfig.style.pictureOriginalTextSize);
                }
            } else {
                this.mCbOriginal.setButtonDrawable(ContextCompat.getDrawable((Context)this, (int)R.drawable.picture_original_checkbox));
                this.mCbOriginal.setTextColor(ContextCompat.getColor((Context)this, (int)R.color.picture_color_53575e));
            }
        } else {
            Drawable drawable2 = AttrsUtils.getTypeValueDrawable((Context)this.getContext(), (int)R.attr.picture_checked_style, (int)R.drawable.picture_checkbox_selector);
            this.check.setBackground(drawable2);
            drawable2 = AttrsUtils.getTypeValueColorStateList((Context)this.getContext(), (int)R.attr.picture_ac_preview_complete_textColor);
            if (drawable2 != null) {
                this.mTvPictureOk.setTextColor((ColorStateList)drawable2);
            }
            drawable2 = AttrsUtils.getTypeValueDrawable((Context)this.getContext(), (int)R.attr.picture_preview_leftBack_icon, (int)R.drawable.picture_icon_back);
            this.pictureLeftBack.setImageDrawable(drawable2);
            int n = AttrsUtils.getTypeValueColor((Context)this.getContext(), (int)R.attr.picture_ac_preview_title_textColor);
            if (n != 0) {
                this.tvTitle.setTextColor(n);
            }
            drawable2 = AttrsUtils.getTypeValueDrawable((Context)this.getContext(), (int)R.attr.picture_num_style, (int)R.drawable.picture_num_oval);
            this.tvMediaNum.setBackground(drawable2);
            n = AttrsUtils.getTypeValueColor((Context)this.getContext(), (int)R.attr.picture_ac_preview_bottom_bg);
            if (n != 0) {
                this.selectBarLayout.setBackgroundColor(n);
            }
            if ((n = AttrsUtils.getTypeValueSizeForInt((Context)this.getContext(), (int)R.attr.picture_titleBar_height)) > 0) {
                this.mTitleBar.getLayoutParams().height = n;
            }
            if (this.config.isOriginalControl) {
                drawable2 = AttrsUtils.getTypeValueDrawable((Context)this.getContext(), (int)R.attr.picture_original_check_style, (int)R.drawable.picture_original_wechat_checkbox);
                this.mCbOriginal.setButtonDrawable(drawable2);
                n = AttrsUtils.getTypeValueColor((Context)this.getContext(), (int)R.attr.picture_original_text_color);
                if (n != 0) {
                    this.mCbOriginal.setTextColor(n);
                }
            }
        }
        this.mTitleBar.setBackgroundColor(this.colorPrimary);
        this.onSelectNumChange(false);
    }

    protected void initWidgets() {
        super.initWidgets();
        this.mHandler = new Handler();
        this.mTitleBar = (ViewGroup)this.findViewById(R.id.titleBar);
        this.screenWidth = ScreenUtils.getScreenWidth((Context)this);
        this.animation = AnimationUtils.loadAnimation((Context)this, (int)R.anim.picture_anim_modal_in);
        this.pictureLeftBack = (ImageView)this.findViewById(R.id.pictureLeftBack);
        this.mTvPictureRight = (TextView)this.findViewById(R.id.picture_right);
        this.mIvArrow = (ImageView)this.findViewById(R.id.ivArrow);
        this.viewPager = (PreviewViewPager)this.findViewById(R.id.preview_pager);
        this.mPicturePreview = this.findViewById(R.id.picture_id_preview);
        this.btnCheck = this.findViewById(R.id.btnCheck);
        this.check = (TextView)this.findViewById(R.id.check);
        this.pictureLeftBack.setOnClickListener((View.OnClickListener)this);
        this.mTvPictureOk = (TextView)this.findViewById(R.id.picture_tv_ok);
        this.mCbOriginal = (CheckBox)this.findViewById(R.id.cb_original);
        this.tvMediaNum = (TextView)this.findViewById(R.id.tv_media_num);
        this.selectBarLayout = (RelativeLayout)this.findViewById(R.id.select_bar_layout);
        this.mTvPictureOk.setOnClickListener((View.OnClickListener)this);
        this.tvMediaNum.setOnClickListener((View.OnClickListener)this);
        this.tvTitle = (TextView)this.findViewById(R.id.picture_title);
        this.mPicturePreview.setVisibility(8);
        this.mIvArrow.setVisibility(8);
        this.mTvPictureRight.setVisibility(8);
        this.check.setVisibility(0);
        this.btnCheck.setVisibility(0);
        this.position = this.getIntent().getIntExtra("position", 0);
        if (this.numComplete) {
            this.initCompleteText(0);
        }
        this.tvMediaNum.setSelected(this.config.checkNumMode);
        this.btnCheck.setOnClickListener((View.OnClickListener)this);
        if (this.getIntent().getParcelableArrayListExtra("selectList") != null) {
            this.selectData = this.getIntent().getParcelableArrayListExtra("selectList");
        }
        this.isBottomPreview = this.getIntent().getBooleanExtra("bottom_preview", false);
        this.isShowCamera = this.getIntent().getBooleanExtra("isShowCamera", this.config.isCamera);
        this.currentDirectory = this.getIntent().getStringExtra("currentDirectory");
        if (this.isBottomPreview) {
            this.initViewPageAdapterData(this.getIntent().getParcelableArrayListExtra("previewSelectList"));
        } else {
            ArrayList<LocalMedia> arrayList = new ArrayList<LocalMedia>(ImagesObservable.getInstance().readPreviewMediaData());
            boolean bl = arrayList.size() == 0;
            this.totalNumber = this.getIntent().getIntExtra("count", 0);
            if (this.config.isPageStrategy) {
                if (bl) {
                    this.setNewTitle();
                } else {
                    this.mPage = this.getIntent().getIntExtra("page", 0);
                }
                this.initViewPageAdapterData(arrayList);
                this.loadData();
                this.setTitle();
            } else {
                this.initViewPageAdapterData(arrayList);
                if (bl) {
                    this.config.isPageStrategy = true;
                    this.setNewTitle();
                    this.loadData();
                }
            }
        }
        this.viewPager.addOnPageChangeListener((ViewPager.OnPageChangeListener)new /* Unavailable Anonymous Inner Class!! */);
        if (!this.config.isOriginalControl) return;
        boolean bl = this.getIntent().getBooleanExtra("isOriginal", this.config.isCheckOriginalImage);
        this.mCbOriginal.setVisibility(0);
        this.config.isCheckOriginalImage = bl;
        this.mCbOriginal.setChecked(this.config.isCheckOriginalImage);
        this.mCbOriginal.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener)new _$.Lambda.PicturePreviewActivity.3_jAuvOj7JQFdqpUoQW_lDGW_pk(this));
    }

    protected boolean isSelected(LocalMedia localMedia) {
        int n = this.selectData.size();
        int n2 = 0;
        while (n2 < n) {
            LocalMedia localMedia2 = this.selectData.get(n2);
            if (localMedia2.getPath().equals(localMedia.getPath())) return true;
            if (localMedia2.getId() == localMedia.getId()) {
                return true;
            }
            ++n2;
        }
        return false;
    }

    public /* synthetic */ void lambda$initWidgets$0$PicturePreviewActivity(CompoundButton compoundButton, boolean bl) {
        this.config.isCheckOriginalImage = bl;
    }

    public /* synthetic */ void lambda$loadData$1$PicturePreviewActivity(List list, int n, boolean bl) {
        PictureSimpleFragmentAdapter pictureSimpleFragmentAdapter;
        if (this.isFinishing()) return;
        this.isHasMore = bl;
        if (!bl) return;
        if (list.size() > 0 && (pictureSimpleFragmentAdapter = this.adapter) != null) {
            pictureSimpleFragmentAdapter.getData().addAll(list);
            this.adapter.notifyDataSetChanged();
        } else {
            this.loadMoreData();
        }
    }

    public /* synthetic */ void lambda$loadMoreData$2$PicturePreviewActivity(List list, int n, boolean bl) {
        PictureSimpleFragmentAdapter pictureSimpleFragmentAdapter;
        if (this.isFinishing()) return;
        this.isHasMore = bl;
        if (!bl) return;
        if (list.size() > 0 && (pictureSimpleFragmentAdapter = this.adapter) != null) {
            pictureSimpleFragmentAdapter.getData().addAll(list);
            this.adapter.notifyDataSetChanged();
        } else {
            this.loadMoreData();
        }
    }

    public void onActivityBackPressed() {
        this.onBackPressed();
    }

    protected void onActivityResult(int n, int n2, Intent object) {
        super.onActivityResult(n, n2, (Intent)object);
        if (n2 == -1) {
            if (n != 69) {
                if (n != 609) return;
                object.putParcelableArrayListExtra("com.yalantis.ucrop.OutputUriList", UCrop.getMultipleOutput((Intent)object));
                object.putParcelableArrayListExtra("selectList", (ArrayList)this.selectData);
                this.setResult(-1, (Intent)object);
                this.finish();
            } else {
                if (object != null) {
                    object.putParcelableArrayListExtra("selectList", (ArrayList)this.selectData);
                    this.setResult(-1, (Intent)object);
                }
                this.finish();
            }
        } else {
            if (n2 != 96) return;
            if ((object = (Throwable)object.getSerializableExtra("com.yalantis.ucrop.Error")) == null) return;
            ToastUtils.s((Context)this.getContext(), (String)((Throwable)object).getMessage());
        }
    }

    public void onBackPressed() {
        this.updateResult();
        this.finish();
        this.overridePendingTransition(0, PictureSelectionConfig.windowAnimationStyle.activityPreviewExitAnimation);
    }

    protected void onCheckedComplete() {
        block33: {
            int n;
            int n2;
            String string2;
            LocalMedia localMedia;
            block32: {
                if (this.adapter.getSize() <= 0) return;
                localMedia = this.adapter.getItem(this.viewPager.getCurrentItem());
                string2 = localMedia.getRealPath();
                if (!TextUtils.isEmpty((CharSequence)string2) && !new File(string2).exists()) {
                    ToastUtils.s((Context)this.getContext(), (String)PictureMimeType.s((Context)this.getContext(), (String)localMedia.getMimeType()));
                    return;
                }
                string2 = this.selectData.size() > 0 ? this.selectData.get(0).getMimeType() : "";
                int n3 = this.selectData.size();
                if (this.config.isWithVideoImage) {
                    n2 = 0;
                    for (n = 0; n < n3; ++n) {
                        int n4 = n2;
                        if (PictureMimeType.isHasVideo((String)this.selectData.get(n).getMimeType())) {
                            n4 = n2 + 1;
                        }
                        n2 = n4;
                    }
                    if (PictureMimeType.isHasVideo((String)localMedia.getMimeType())) {
                        if (this.config.maxVideoSelectNum <= 0) {
                            this.showPromptDialog(this.getString(R.string.picture_rule));
                            return;
                        }
                        if (n3 >= this.config.maxSelectNum && !this.check.isSelected()) {
                            this.showPromptDialog(this.getString(R.string.picture_message_max_num, new Object[]{this.config.maxSelectNum}));
                            return;
                        }
                        if (n2 >= this.config.maxVideoSelectNum && !this.check.isSelected()) {
                            this.showPromptDialog(StringUtils.getMsg((Context)this.getContext(), (String)localMedia.getMimeType(), (int)this.config.maxVideoSelectNum));
                            return;
                        }
                        if (!this.check.isSelected() && this.config.videoMinSecond > 0 && localMedia.getDuration() < (long)this.config.videoMinSecond) {
                            this.showPromptDialog(this.getContext().getString(R.string.picture_choose_min_seconds, new Object[]{this.config.videoMinSecond / 1000}));
                            return;
                        }
                        if (!this.check.isSelected() && this.config.videoMaxSecond > 0 && localMedia.getDuration() > (long)this.config.videoMaxSecond) {
                            this.showPromptDialog(this.getContext().getString(R.string.picture_choose_max_seconds, new Object[]{this.config.videoMaxSecond / 1000}));
                            return;
                        }
                    } else if (n3 >= this.config.maxSelectNum && !this.check.isSelected()) {
                        this.showPromptDialog(this.getString(R.string.picture_message_max_num, new Object[]{this.config.maxSelectNum}));
                        return;
                    }
                } else {
                    if (!TextUtils.isEmpty((CharSequence)string2) && !PictureMimeType.isMimeTypeSame((String)string2, (String)localMedia.getMimeType())) {
                        this.showPromptDialog(this.getString(R.string.picture_rule));
                        return;
                    }
                    if (PictureMimeType.isHasVideo((String)string2) && this.config.maxVideoSelectNum > 0) {
                        if (n3 >= this.config.maxVideoSelectNum && !this.check.isSelected()) {
                            this.showPromptDialog(StringUtils.getMsg((Context)this.getContext(), (String)string2, (int)this.config.maxVideoSelectNum));
                            return;
                        }
                        if (!this.check.isSelected() && this.config.videoMinSecond > 0 && localMedia.getDuration() < (long)this.config.videoMinSecond) {
                            this.showPromptDialog(this.getContext().getString(R.string.picture_choose_min_seconds, new Object[]{this.config.videoMinSecond / 1000}));
                            return;
                        }
                        if (!this.check.isSelected() && this.config.videoMaxSecond > 0 && localMedia.getDuration() > (long)this.config.videoMaxSecond) {
                            this.showPromptDialog(this.getContext().getString(R.string.picture_choose_max_seconds, new Object[]{this.config.videoMaxSecond / 1000}));
                            return;
                        }
                    } else {
                        if (n3 >= this.config.maxSelectNum && !this.check.isSelected()) {
                            this.showPromptDialog(StringUtils.getMsg((Context)this.getContext(), (String)string2, (int)this.config.maxSelectNum));
                            return;
                        }
                        if (PictureMimeType.isHasVideo((String)localMedia.getMimeType())) {
                            if (!this.check.isSelected() && this.config.videoMinSecond > 0 && localMedia.getDuration() < (long)this.config.videoMinSecond) {
                                this.showPromptDialog(this.getContext().getString(R.string.picture_choose_min_seconds, new Object[]{this.config.videoMinSecond / 1000}));
                                return;
                            }
                            if (!this.check.isSelected() && this.config.videoMaxSecond > 0 && localMedia.getDuration() > (long)this.config.videoMaxSecond) {
                                this.showPromptDialog(this.getContext().getString(R.string.picture_choose_max_seconds, new Object[]{this.config.videoMaxSecond / 1000}));
                                return;
                            }
                        }
                    }
                }
                if (!this.check.isSelected()) {
                    this.check.setSelected(true);
                    this.check.startAnimation(this.animation);
                    n = 1;
                } else {
                    this.check.setSelected(false);
                    n = 0;
                }
                this.isChangeSelectedData = true;
                if (n == 0) break block32;
                VoiceUtils.getInstance().play();
                if (this.config.selectionMode == 1) {
                    this.selectData.clear();
                }
                if (localMedia.getWidth() == 0 || localMedia.getHeight() == 0) {
                    if (PictureMimeType.isHasVideo((String)localMedia.getMimeType())) {
                        string2 = MediaUtils.getVideoSize((Context)this.getContext(), (String)localMedia.getPath());
                        localMedia.setWidth(string2.getWidth());
                        localMedia.setHeight(string2.getHeight());
                    } else if (PictureMimeType.isHasImage((String)localMedia.getMimeType())) {
                        string2 = MediaUtils.getImageSize((Context)this.getContext(), (String)localMedia.getPath());
                        localMedia.setWidth(string2.getWidth());
                        localMedia.setHeight(string2.getHeight());
                    }
                }
                this.selectData.add(localMedia);
                this.onSelectedChange(true, localMedia);
                localMedia.setNum(this.selectData.size());
                if (!this.config.checkNumMode) break block33;
                this.check.setText((CharSequence)ValueOf.toString((Object)localMedia.getNum()));
                break block33;
            }
            n2 = this.selectData.size();
            for (n = 0; n < n2; ++n) {
                string2 = this.selectData.get(n);
                if (!string2.getPath().equals(localMedia.getPath()) && string2.getId() != localMedia.getId()) {
                    continue;
                }
                this.selectData.remove(string2);
                this.onSelectedChange(false, localMedia);
                this.subSelectPosition();
                this.notifyCheckChanged((LocalMedia)string2);
                break;
            }
        }
        this.onSelectNumChange(true);
    }

    public void onClick(View view) {
        int n = view.getId();
        if (n == R.id.pictureLeftBack) {
            this.onBackPressed();
        } else if (n != R.id.picture_tv_ok && n != R.id.tv_media_num) {
            if (n != R.id.btnCheck) return;
            this.onCheckedComplete();
        } else {
            this.onComplete();
        }
    }

    protected void onComplete() {
        int n = this.selectData.size();
        LocalMedia localMedia = this.selectData.size() > 0 ? this.selectData.get(0) : null;
        String string2 = localMedia != null ? localMedia.getMimeType() : "";
        if (!this.config.isWithVideoImage) {
            if (this.config.selectionMode == 2) {
                if (PictureMimeType.isHasImage((String)string2) && this.config.minSelectNum > 0 && n < this.config.minSelectNum) {
                    this.showPromptDialog(this.getString(R.string.picture_min_img_num, new Object[]{this.config.minSelectNum}));
                    return;
                }
                if (PictureMimeType.isHasVideo((String)string2) && this.config.minVideoSelectNum > 0 && n < this.config.minVideoSelectNum) {
                    this.showPromptDialog(this.getString(R.string.picture_min_video_num, new Object[]{this.config.minVideoSelectNum}));
                    return;
                }
            }
        } else {
            int n2 = this.selectData.size();
            int n3 = 0;
            int n4 = 0;
            for (n = 0; n < n2; ++n) {
                if (PictureMimeType.isHasVideo((String)this.selectData.get(n).getMimeType())) {
                    ++n4;
                    continue;
                }
                ++n3;
            }
            if (this.config.selectionMode == 2) {
                if (this.config.minSelectNum > 0 && n3 < this.config.minSelectNum) {
                    this.showPromptDialog(this.getString(R.string.picture_min_img_num, new Object[]{this.config.minSelectNum}));
                    return;
                }
                if (this.config.minVideoSelectNum > 0 && n4 < this.config.minVideoSelectNum) {
                    this.showPromptDialog(this.getString(R.string.picture_min_video_num, new Object[]{this.config.minVideoSelectNum}));
                    return;
                }
            }
        }
        this.isCompleteOrSelected = true;
        this.isChangeSelectedData = true;
        if (this.config.chooseMode == PictureMimeType.ofAll() && this.config.isWithVideoImage) {
            this.bothMimeTypeWith(string2, localMedia);
        } else {
            this.separateMimeTypeWith(string2, localMedia);
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) return;
        List<LocalMedia> list = PictureSelector.obtainSelectorList((Bundle)bundle);
        if (list == null) {
            list = this.selectData;
        }
        this.selectData = list;
        this.isCompleteOrSelected = bundle.getBoolean("isCompleteOrSelected", false);
        this.isChangeSelectedData = bundle.getBoolean("isChangeSelectedData", false);
        this.onImageChecked(this.position);
        this.onSelectNumChange(false);
    }

    protected void onDestroy() {
        Handler handler;
        super.onDestroy();
        if (!this.isOnSaveInstanceState) {
            ImagesObservable.getInstance().clearPreviewMediaData();
        }
        if ((handler = this.mHandler) != null) {
            handler.removeCallbacksAndMessages(null);
            this.mHandler = null;
        }
        if ((handler = this.animation) != null) {
            handler.cancel();
            this.animation = null;
        }
        if ((handler = this.adapter) == null) return;
        handler.clear();
    }

    public void onImageChecked(int n) {
        if (this.adapter.getSize() > 0) {
            LocalMedia localMedia = this.adapter.getItem(n);
            if (localMedia == null) return;
            this.check.setSelected(this.isSelected(localMedia));
        } else {
            this.check.setSelected(false);
        }
    }

    protected void onPageSelectedChange(LocalMedia localMedia) {
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("isCompleteOrSelected", this.isCompleteOrSelected);
        bundle.putBoolean("isChangeSelectedData", this.isChangeSelectedData);
        PictureSelector.saveSelectorList((Bundle)bundle, this.selectData);
    }

    protected void onSelectNumChange(boolean bl) {
        this.refresh = bl;
        boolean bl2 = this.selectData.size() != 0;
        if (bl2) {
            this.mTvPictureOk.setEnabled(true);
            this.mTvPictureOk.setSelected(true);
            if (PictureSelectionConfig.style != null) {
                if (PictureSelectionConfig.style.pictureCompleteTextColor != 0) {
                    this.mTvPictureOk.setTextColor(PictureSelectionConfig.style.pictureCompleteTextColor);
                } else {
                    this.mTvPictureOk.setTextColor(ContextCompat.getColor((Context)this.getContext(), (int)R.color.picture_color_fa632d));
                }
            }
            if (this.numComplete) {
                this.initCompleteText(this.selectData.size());
            } else {
                if (this.refresh) {
                    this.tvMediaNum.startAnimation(this.animation);
                }
                this.tvMediaNum.setVisibility(0);
                this.tvMediaNum.setText((CharSequence)ValueOf.toString((Object)this.selectData.size()));
                if (PictureSelectionConfig.uiStyle != null) {
                    if (PictureSelectionConfig.uiStyle.picture_bottom_completeNormalText == 0) return;
                    this.mTvPictureOk.setText(PictureSelectionConfig.uiStyle.picture_bottom_completeNormalText);
                } else if (PictureSelectionConfig.style != null) {
                    if (TextUtils.isEmpty((CharSequence)PictureSelectionConfig.style.pictureCompleteText)) return;
                    this.mTvPictureOk.setText((CharSequence)PictureSelectionConfig.style.pictureCompleteText);
                } else {
                    this.mTvPictureOk.setText((CharSequence)this.getString(R.string.picture_completed));
                }
            }
        } else {
            this.mTvPictureOk.setEnabled(false);
            this.mTvPictureOk.setSelected(false);
            if (PictureSelectionConfig.style != null) {
                if (PictureSelectionConfig.style.pictureUnCompleteTextColor != 0) {
                    this.mTvPictureOk.setTextColor(PictureSelectionConfig.style.pictureUnCompleteTextColor);
                } else {
                    this.mTvPictureOk.setTextColor(ContextCompat.getColor((Context)this.getContext(), (int)R.color.picture_color_9b));
                }
            }
            if (this.numComplete) {
                this.initCompleteText(0);
            } else {
                this.tvMediaNum.setVisibility(4);
                if (PictureSelectionConfig.uiStyle != null) {
                    if (PictureSelectionConfig.uiStyle.picture_bottom_completeDefaultText == 0) return;
                    this.mTvPictureOk.setText(PictureSelectionConfig.uiStyle.picture_bottom_completeDefaultText);
                } else if (PictureSelectionConfig.style != null) {
                    if (TextUtils.isEmpty((CharSequence)PictureSelectionConfig.style.pictureUnCompleteText)) return;
                    this.mTvPictureOk.setText((CharSequence)PictureSelectionConfig.style.pictureUnCompleteText);
                } else {
                    this.mTvPictureOk.setText((CharSequence)this.getString(R.string.picture_please_select));
                }
            }
        }
    }

    protected void onSelectedChange(boolean bl, LocalMedia localMedia) {
    }

    protected void onUpdateSelectedChange(LocalMedia localMedia) {
    }
}
