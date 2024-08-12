/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.ColorFilter
 *  android.text.TextUtils
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.animation.AnimationUtils
 *  android.widget.TextView
 *  androidx.core.content.ContextCompat
 *  androidx.core.graphics.BlendModeColorFilterCompat
 *  androidx.core.graphics.BlendModeCompat
 *  androidx.recyclerview.widget.RecyclerView$Adapter
 *  androidx.recyclerview.widget.RecyclerView$ViewHolder
 *  com.luck.picture.lib.R$anim
 *  com.luck.picture.lib.R$color
 *  com.luck.picture.lib.R$drawable
 *  com.luck.picture.lib.R$id
 *  com.luck.picture.lib.R$layout
 *  com.luck.picture.lib.R$string
 *  com.luck.picture.lib.adapter.PictureImageGridAdapter$CameraViewHolder
 *  com.luck.picture.lib.adapter.PictureImageGridAdapter$ViewHolder
 *  com.luck.picture.lib.adapter._$$Lambda$PictureImageGridAdapter$1q0XTI3eiIDqJ0__H9QeoIzYh1w
 *  com.luck.picture.lib.adapter._$$Lambda$PictureImageGridAdapter$PgVgZMJtlqgUy4Fuo95Ra5c5haQ
 *  com.luck.picture.lib.adapter._$$Lambda$PictureImageGridAdapter$jK8zND_ULBbVcD8KDiSr5ySgn_Y
 *  com.luck.picture.lib.adapter._$$Lambda$PictureImageGridAdapter$qvbHL3G2CY7hZL16_NieLEof5nI
 *  com.luck.picture.lib.config.PictureMimeType
 *  com.luck.picture.lib.config.PictureSelectionConfig
 *  com.luck.picture.lib.dialog.PictureCustomDialog
 *  com.luck.picture.lib.entity.LocalMedia
 *  com.luck.picture.lib.listener.OnPhotoSelectChangedListener
 *  com.luck.picture.lib.tools.AnimUtils
 *  com.luck.picture.lib.tools.DateUtils
 *  com.luck.picture.lib.tools.MediaUtils
 *  com.luck.picture.lib.tools.StringUtils
 *  com.luck.picture.lib.tools.ToastUtils
 *  com.luck.picture.lib.tools.ValueOf
 *  com.luck.picture.lib.tools.VoiceUtils
 */
package com.luck.picture.lib.adapter;

import android.content.Context;
import android.graphics.ColorFilter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.BlendModeColorFilterCompat;
import androidx.core.graphics.BlendModeCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.luck.picture.lib.R;
import com.luck.picture.lib.adapter.PictureImageGridAdapter;
import com.luck.picture.lib.adapter._$;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.config.PictureSelectionConfig;
import com.luck.picture.lib.dialog.PictureCustomDialog;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.listener.OnPhotoSelectChangedListener;
import com.luck.picture.lib.tools.AnimUtils;
import com.luck.picture.lib.tools.DateUtils;
import com.luck.picture.lib.tools.MediaUtils;
import com.luck.picture.lib.tools.StringUtils;
import com.luck.picture.lib.tools.ToastUtils;
import com.luck.picture.lib.tools.ValueOf;
import com.luck.picture.lib.tools.VoiceUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class PictureImageGridAdapter
extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final PictureSelectionConfig config;
    private final Context context;
    private List<LocalMedia> data = new ArrayList<LocalMedia>();
    private OnPhotoSelectChangedListener<LocalMedia> imageSelectChangedListener;
    private List<LocalMedia> selectData = new ArrayList<LocalMedia>();
    private boolean showCamera;

    public PictureImageGridAdapter(Context context, PictureSelectionConfig pictureSelectionConfig) {
        this.context = context;
        this.config = pictureSelectionConfig;
        this.showCamera = pictureSelectionConfig.isCamera;
    }

    static /* synthetic */ PictureSelectionConfig access$000(PictureImageGridAdapter pictureImageGridAdapter) {
        return pictureImageGridAdapter.config;
    }

    static /* synthetic */ Context access$100(PictureImageGridAdapter pictureImageGridAdapter) {
        return pictureImageGridAdapter.context;
    }

    private void changeCheckboxState(ViewHolder onPhotoSelectChangedListener, LocalMedia localMedia) {
        int n;
        boolean bl;
        block44: {
            block47: {
                int n2;
                int n3;
                block48: {
                    int n4;
                    block45: {
                        int n5;
                        block46: {
                            bl = onPhotoSelectChangedListener.tvCheck.isSelected();
                            int n6 = this.selectData.size();
                            n5 = 0;
                            n4 = 0;
                            n3 = 0;
                            int n7 = 0;
                            int n8 = 0;
                            String string2 = n6 > 0 ? this.selectData.get(0).getMimeType() : "";
                            if (this.config.isWithVideoImage) {
                                n = 0;
                                for (n2 = 0; n2 < n6; ++n2) {
                                    int n9 = n;
                                    if (PictureMimeType.isHasVideo((String)this.selectData.get(n2).getMimeType())) {
                                        n9 = n + 1;
                                    }
                                    n = n9;
                                }
                                if (PictureMimeType.isHasVideo((String)localMedia.getMimeType())) {
                                    if (this.config.maxVideoSelectNum <= 0) {
                                        this.showPromptDialog(this.context.getString(R.string.picture_rule));
                                        return;
                                    }
                                    if (n6 >= this.config.maxSelectNum && !bl) {
                                        this.showPromptDialog(this.context.getString(R.string.picture_message_max_num, new Object[]{this.config.maxSelectNum}));
                                        return;
                                    }
                                    if (n >= this.config.maxVideoSelectNum && !bl) {
                                        this.showPromptDialog(StringUtils.getMsg((Context)this.context, (String)localMedia.getMimeType(), (int)this.config.maxVideoSelectNum));
                                        return;
                                    }
                                    if (!bl && this.config.videoMinSecond > 0 && localMedia.getDuration() < (long)this.config.videoMinSecond) {
                                        this.showPromptDialog(this.context.getString(R.string.picture_choose_min_seconds, new Object[]{this.config.videoMinSecond / 1000}));
                                        return;
                                    }
                                    if (!bl && this.config.videoMaxSecond > 0 && localMedia.getDuration() > (long)this.config.videoMaxSecond) {
                                        this.showPromptDialog(this.context.getString(R.string.picture_choose_max_seconds, new Object[]{this.config.videoMaxSecond / 1000}));
                                        return;
                                    }
                                } else if (n6 >= this.config.maxSelectNum && !bl) {
                                    this.showPromptDialog(this.context.getString(R.string.picture_message_max_num, new Object[]{this.config.maxSelectNum}));
                                    return;
                                }
                            } else {
                                if (!TextUtils.isEmpty((CharSequence)string2) && !PictureMimeType.isMimeTypeSame((String)string2, (String)localMedia.getMimeType())) {
                                    this.showPromptDialog(this.context.getString(R.string.picture_rule));
                                    return;
                                }
                                if (PictureMimeType.isHasVideo((String)string2) && this.config.maxVideoSelectNum > 0) {
                                    if (n6 >= this.config.maxVideoSelectNum && !bl) {
                                        this.showPromptDialog(StringUtils.getMsg((Context)this.context, (String)string2, (int)this.config.maxVideoSelectNum));
                                        return;
                                    }
                                    if (!bl && this.config.videoMinSecond > 0 && localMedia.getDuration() < (long)this.config.videoMinSecond) {
                                        this.showPromptDialog(this.context.getString(R.string.picture_choose_min_seconds, new Object[]{this.config.videoMinSecond / 1000}));
                                        return;
                                    }
                                    if (!bl && this.config.videoMaxSecond > 0 && localMedia.getDuration() > (long)this.config.videoMaxSecond) {
                                        this.showPromptDialog(this.context.getString(R.string.picture_choose_max_seconds, new Object[]{this.config.videoMaxSecond / 1000}));
                                        return;
                                    }
                                } else {
                                    if (n6 >= this.config.maxSelectNum && !bl) {
                                        this.showPromptDialog(StringUtils.getMsg((Context)this.context, (String)string2, (int)this.config.maxSelectNum));
                                        return;
                                    }
                                    if (PictureMimeType.isHasVideo((String)localMedia.getMimeType())) {
                                        if (!bl && this.config.videoMinSecond > 0 && localMedia.getDuration() < (long)this.config.videoMinSecond) {
                                            this.showPromptDialog(this.context.getString(R.string.picture_choose_min_seconds, new Object[]{this.config.videoMinSecond / 1000}));
                                            return;
                                        }
                                        if (!bl && this.config.videoMaxSecond > 0 && localMedia.getDuration() > (long)this.config.videoMaxSecond) {
                                            this.showPromptDialog(this.context.getString(R.string.picture_choose_max_seconds, new Object[]{this.config.videoMaxSecond / 1000}));
                                            return;
                                        }
                                    }
                                }
                            }
                            if (!bl) {
                                if (this.config.selectionMode == 1) {
                                    this.singleRadioMediaImage();
                                }
                                if (localMedia.getWidth() == 0 || localMedia.getHeight() == 0) {
                                    if (PictureMimeType.isHasVideo((String)localMedia.getMimeType())) {
                                        string2 = MediaUtils.getVideoSize((Context)onPhotoSelectChangedListener.itemView.getContext(), (String)localMedia.getPath());
                                        localMedia.setWidth(string2.getWidth());
                                        localMedia.setHeight(string2.getHeight());
                                    } else if (PictureMimeType.isHasImage((String)localMedia.getMimeType())) {
                                        string2 = MediaUtils.getImageSize((Context)onPhotoSelectChangedListener.itemView.getContext(), (String)localMedia.getPath());
                                        localMedia.setWidth(string2.getWidth());
                                        localMedia.setHeight(string2.getHeight());
                                    }
                                }
                                this.selectData.add(localMedia);
                                localMedia.setNum(this.selectData.size());
                                VoiceUtils.getInstance().play();
                                AnimUtils.zoom((View)onPhotoSelectChangedListener.ivPicture, (boolean)this.config.zoomAnim);
                                onPhotoSelectChangedListener.tvCheck.startAnimation(AnimationUtils.loadAnimation((Context)this.context, (int)R.anim.picture_anim_modal_in));
                            } else {
                                for (n = 0; n < n6; ++n) {
                                    string2 = this.selectData.get(n);
                                    if (string2 == null || TextUtils.isEmpty((CharSequence)string2.getPath()) || !string2.getPath().equals(localMedia.getPath()) && string2.getId() != localMedia.getId()) continue;
                                    this.selectData.remove(string2);
                                    this.subSelectPosition();
                                    AnimUtils.disZoom((View)onPhotoSelectChangedListener.ivPicture, (boolean)this.config.zoomAnim);
                                    break;
                                }
                            }
                            n = n7;
                            if (!this.config.isMaxSelectEnabledMask) break block44;
                            if (this.config.chooseMode != PictureMimeType.ofAll()) break block45;
                            if (!this.config.isWithVideoImage || this.config.maxVideoSelectNum <= 0) break block46;
                            n2 = n8;
                            if (this.getSelectedSize() >= this.config.maxSelectNum) {
                                n2 = 1;
                            }
                            n = n2;
                            if (!bl) break block44;
                            n = n2;
                            if (this.getSelectedSize() != this.config.maxSelectNum - 1) break block44;
                            break block47;
                        }
                        n2 = n5;
                        if (!bl) {
                            n2 = n5;
                            if (this.getSelectedSize() == 1) {
                                n2 = 1;
                            }
                        }
                        n = n2;
                        if (!bl) break block44;
                        n = n2;
                        if (this.getSelectedSize() != 0) break block44;
                        break block47;
                    }
                    if (this.config.chooseMode != PictureMimeType.ofVideo() || this.config.maxVideoSelectNum <= 0) break block48;
                    n2 = n4;
                    if (!bl) {
                        n2 = n4;
                        if (this.getSelectedSize() == this.config.maxVideoSelectNum) {
                            n2 = 1;
                        }
                    }
                    n = n2;
                    if (!bl) break block44;
                    n = n2;
                    if (this.getSelectedSize() != this.config.maxVideoSelectNum - 1) break block44;
                    break block47;
                }
                n2 = n3;
                if (!bl) {
                    n2 = n3;
                    if (this.getSelectedSize() == this.config.maxSelectNum) {
                        n2 = 1;
                    }
                }
                n = n2;
                if (!bl) break block44;
                n = n2;
                if (this.getSelectedSize() != this.config.maxSelectNum - 1) break block44;
            }
            n = 1;
        }
        if (n != 0) {
            this.notifyDataSetChanged();
        } else {
            this.notifyItemChanged(onPhotoSelectChangedListener.getAdapterPosition());
        }
        this.selectImage((ViewHolder)onPhotoSelectChangedListener, bl ^ true);
        onPhotoSelectChangedListener = this.imageSelectChangedListener;
        if (onPhotoSelectChangedListener == null) return;
        onPhotoSelectChangedListener.onChange(this.selectData);
    }

    private void dispatchHandleMask(ViewHolder viewHolder, LocalMedia localMedia) {
        boolean bl = this.config.isWithVideoImage;
        boolean bl2 = true;
        boolean bl3 = true;
        if (bl && this.config.maxVideoSelectNum > 0) {
            if (this.getSelectedSize() >= this.config.maxSelectNum) {
                bl2 = viewHolder.tvCheck.isSelected();
                int n = bl2 ? ContextCompat.getColor((Context)this.context, (int)R.color.picture_color_80) : ContextCompat.getColor((Context)this.context, (int)R.color.picture_color_half_white);
                ColorFilter colorFilter = BlendModeColorFilterCompat.createBlendModeColorFilterCompat((int)n, (BlendModeCompat)BlendModeCompat.SRC_ATOP);
                viewHolder.ivPicture.setColorFilter(colorFilter);
                localMedia.setMaxSelectEnabledMask(bl2 ^ true);
            } else {
                localMedia.setMaxSelectEnabledMask(false);
            }
        } else {
            LocalMedia localMedia2 = this.selectData.size() > 0 ? this.selectData.get(0) : null;
            if (localMedia2 == null) return;
            bl = viewHolder.tvCheck.isSelected();
            if (this.config.chooseMode == PictureMimeType.ofAll()) {
                if (PictureMimeType.isHasImage((String)localMedia2.getMimeType())) {
                    if (!bl && !PictureMimeType.isHasImage((String)localMedia.getMimeType())) {
                        localMedia2 = this.context;
                        int n = PictureMimeType.isHasVideo((String)localMedia.getMimeType()) ? R.color.picture_color_half_white : R.color.picture_color_20;
                        localMedia2 = BlendModeColorFilterCompat.createBlendModeColorFilterCompat((int)ContextCompat.getColor((Context)localMedia2, (int)n), (BlendModeCompat)BlendModeCompat.SRC_ATOP);
                        viewHolder.ivPicture.setColorFilter((ColorFilter)localMedia2);
                    }
                    localMedia.setMaxSelectEnabledMask(PictureMimeType.isHasVideo((String)localMedia.getMimeType()));
                } else {
                    if (!PictureMimeType.isHasVideo((String)localMedia2.getMimeType())) return;
                    if (!bl && !PictureMimeType.isHasVideo((String)localMedia.getMimeType())) {
                        localMedia2 = this.context;
                        int n = PictureMimeType.isHasImage((String)localMedia.getMimeType()) ? R.color.picture_color_half_white : R.color.picture_color_20;
                        localMedia2 = BlendModeColorFilterCompat.createBlendModeColorFilterCompat((int)ContextCompat.getColor((Context)localMedia2, (int)n), (BlendModeCompat)BlendModeCompat.SRC_ATOP);
                        viewHolder.ivPicture.setColorFilter((ColorFilter)localMedia2);
                    }
                    localMedia.setMaxSelectEnabledMask(PictureMimeType.isHasImage((String)localMedia.getMimeType()));
                }
            } else if (this.config.chooseMode == PictureMimeType.ofVideo() && this.config.maxVideoSelectNum > 0) {
                if (!bl && this.getSelectedSize() == this.config.maxVideoSelectNum) {
                    localMedia2 = BlendModeColorFilterCompat.createBlendModeColorFilterCompat((int)ContextCompat.getColor((Context)this.context, (int)R.color.picture_color_half_white), (BlendModeCompat)BlendModeCompat.SRC_ATOP);
                    viewHolder.ivPicture.setColorFilter((ColorFilter)localMedia2);
                }
                bl2 = !bl && this.getSelectedSize() == this.config.maxVideoSelectNum ? bl3 : false;
                localMedia.setMaxSelectEnabledMask(bl2);
            } else {
                if (!bl && this.getSelectedSize() == this.config.maxSelectNum) {
                    localMedia2 = BlendModeColorFilterCompat.createBlendModeColorFilterCompat((int)ContextCompat.getColor((Context)this.context, (int)R.color.picture_color_half_white), (BlendModeCompat)BlendModeCompat.SRC_ATOP);
                    viewHolder.ivPicture.setColorFilter((ColorFilter)localMedia2);
                }
                if (bl || this.getSelectedSize() != this.config.maxSelectNum) {
                    bl2 = false;
                }
                localMedia.setMaxSelectEnabledMask(bl2);
            }
        }
    }

    static /* synthetic */ void lambda$showPromptDialog$3(PictureCustomDialog pictureCustomDialog, View view) {
        pictureCustomDialog.dismiss();
    }

    private void notifyCheckChanged(ViewHolder viewHolder, LocalMedia localMedia) {
        viewHolder.tvCheck.setText((CharSequence)"");
        int n = this.selectData.size();
        int n2 = 0;
        while (n2 < n) {
            LocalMedia localMedia2 = this.selectData.get(n2);
            if (localMedia2.getPath().equals(localMedia.getPath()) || localMedia2.getId() == localMedia.getId()) {
                localMedia.setNum(localMedia2.getNum());
                localMedia2.setPosition(localMedia.getPosition());
                viewHolder.tvCheck.setText((CharSequence)ValueOf.toString((Object)localMedia.getNum()));
            }
            ++n2;
        }
    }

    private void showPromptDialog(String string2) {
        PictureCustomDialog pictureCustomDialog = new PictureCustomDialog(this.context, R.layout.picture_prompt_dialog);
        TextView textView = (TextView)pictureCustomDialog.findViewById(R.id.btnOk);
        ((TextView)pictureCustomDialog.findViewById(R.id.tv_content)).setText((CharSequence)string2);
        textView.setOnClickListener((View.OnClickListener)new _$.Lambda.PictureImageGridAdapter.1q0XTI3eiIDqJ0__H9QeoIzYh1w(pictureCustomDialog));
        pictureCustomDialog.show();
    }

    private void singleRadioMediaImage() {
        List<LocalMedia> list = this.selectData;
        if (list == null) return;
        if (list.size() <= 0) return;
        this.notifyItemChanged(this.selectData.get((int)0).position);
        this.selectData.clear();
    }

    private void subSelectPosition() {
        if (!this.config.checkNumMode) return;
        int n = this.selectData.size();
        int n2 = 0;
        while (n2 < n) {
            LocalMedia localMedia = this.selectData.get(n2);
            localMedia.setNum(++n2);
            this.notifyItemChanged(localMedia.position);
        }
    }

    public void bindData(List<LocalMedia> list) {
        List<LocalMedia> list2 = list;
        if (list == null) {
            list2 = new ArrayList<LocalMedia>();
        }
        this.data = list2;
        this.notifyDataSetChanged();
    }

    public void bindSelectData(List<LocalMedia> list) {
        ArrayList<LocalMedia> arrayList = new ArrayList<LocalMedia>();
        int n = list.size();
        int n2 = 0;
        while (true) {
            if (n2 >= n) {
                this.selectData = arrayList;
                if (this.config.isSingleDirectReturn) return;
                this.subSelectPosition();
                list = this.imageSelectChangedListener;
                if (list == null) return;
                list.onChange(this.selectData);
                return;
            }
            arrayList.add(list.get(n2));
            ++n2;
        }
    }

    public void clear() {
        if (this.getSize() <= 0) return;
        this.data.clear();
    }

    public List<LocalMedia> getData() {
        List<LocalMedia> list;
        List<LocalMedia> list2 = list = this.data;
        if (list != null) return list2;
        list2 = new ArrayList<LocalMedia>();
        return list2;
    }

    public LocalMedia getItem(int n) {
        LocalMedia localMedia = this.getSize() > 0 ? this.data.get(n) : null;
        return localMedia;
    }

    public int getItemCount() {
        int n = this.showCamera ? this.data.size() + 1 : this.data.size();
        return n;
    }

    public int getItemViewType(int n) {
        if (!this.showCamera) return 2;
        if (n != 0) return 2;
        return 1;
    }

    public List<LocalMedia> getSelectedData() {
        List<LocalMedia> list;
        List<LocalMedia> list2 = list = this.selectData;
        if (list != null) return list2;
        list2 = new ArrayList<LocalMedia>();
        return list2;
    }

    public int getSelectedSize() {
        List<LocalMedia> list = this.selectData;
        int n = list == null ? 0 : list.size();
        return n;
    }

    public int getSize() {
        List<LocalMedia> list = this.data;
        int n = list == null ? 0 : list.size();
        return n;
    }

    public boolean isDataEmpty() {
        List<LocalMedia> list = this.data;
        boolean bl = list == null || list.size() == 0;
        return bl;
    }

    public boolean isSelected(LocalMedia localMedia) {
        int n = this.selectData.size();
        int n2 = 0;
        while (n2 < n) {
            LocalMedia localMedia2 = this.selectData.get(n2);
            if (localMedia2 != null && !TextUtils.isEmpty((CharSequence)localMedia2.getPath())) {
                if (localMedia2.getPath().equals(localMedia.getPath())) return true;
                if (localMedia2.getId() == localMedia.getId()) {
                    return true;
                }
            }
            ++n2;
        }
        return false;
    }

    public boolean isShowCamera() {
        return this.showCamera;
    }

    public /* synthetic */ void lambda$onBindViewHolder$0$PictureImageGridAdapter(View onPhotoSelectChangedListener) {
        onPhotoSelectChangedListener = this.imageSelectChangedListener;
        if (onPhotoSelectChangedListener == null) return;
        onPhotoSelectChangedListener.onTakePhoto();
    }

    public /* synthetic */ void lambda$onBindViewHolder$1$PictureImageGridAdapter(LocalMedia localMedia, ViewHolder viewHolder, String string, View object) {
        if (this.config.isMaxSelectEnabledMask) {
            if (this.config.isWithVideoImage) {
                int n;
                int n2 = this.getSelectedSize();
                int n3 = 0;
                int n4 = 0;
                int n5 = 0;
                for (n = 0; n < n2; ++n) {
                    int n6 = n5;
                    if (PictureMimeType.isHasVideo((String)this.selectData.get(n).getMimeType())) {
                        n6 = n5 + 1;
                    }
                    n5 = n6;
                }
                if (PictureMimeType.isHasVideo((String)localMedia.getMimeType())) {
                    n = n4;
                    if (!viewHolder.tvCheck.isSelected()) {
                        n = n4;
                        if (n5 >= this.config.maxVideoSelectNum) {
                            n = 1;
                        }
                    }
                    object = StringUtils.getMsg((Context)this.context, (String)localMedia.getMimeType(), (int)this.config.maxVideoSelectNum);
                } else {
                    n = n3;
                    if (!viewHolder.tvCheck.isSelected()) {
                        n = n3;
                        if (n2 >= this.config.maxSelectNum) {
                            n = 1;
                        }
                    }
                    object = StringUtils.getMsg((Context)this.context, (String)localMedia.getMimeType(), (int)this.config.maxSelectNum);
                }
                if (n != 0) {
                    this.showPromptDialog((String)object);
                    return;
                }
            } else if (!viewHolder.tvCheck.isSelected() && this.getSelectedSize() >= this.config.maxSelectNum) {
                this.showPromptDialog(StringUtils.getMsg((Context)this.context, (String)localMedia.getMimeType(), (int)this.config.maxSelectNum));
                return;
            }
        }
        if (!TextUtils.isEmpty((CharSequence)(object = localMedia.getRealPath())) && !new File((String)object).exists()) {
            localMedia = this.context;
            ToastUtils.s((Context)localMedia, (String)PictureMimeType.s((Context)localMedia, (String)string));
            return;
        }
        this.changeCheckboxState(viewHolder, localMedia);
    }

    public /* synthetic */ void lambda$onBindViewHolder$2$PictureImageGridAdapter(LocalMedia localMedia, String string2, int n, ViewHolder viewHolder, View object) {
        if (this.config.isMaxSelectEnabledMask && localMedia.isMaxSelectEnabledMask()) {
            return;
        }
        object = localMedia.getRealPath();
        if (!TextUtils.isEmpty((CharSequence)object) && !new File((String)object).exists()) {
            localMedia = this.context;
            ToastUtils.s((Context)localMedia, (String)PictureMimeType.s((Context)localMedia, (String)string2));
            return;
        }
        int n2 = n;
        if (this.showCamera) {
            n2 = n - 1;
        }
        if (n2 == -1) {
            return;
        }
        n = !(PictureMimeType.isHasImage((String)string2) && this.config.enablePreview || this.config.isSingleDirectReturn || PictureMimeType.isHasVideo((String)string2) && (this.config.enPreviewVideo || this.config.selectionMode == 1) || PictureMimeType.isHasAudio((String)string2) && (this.config.enablePreviewAudio || this.config.selectionMode == 1)) ? 0 : 1;
        if (n != 0) {
            if (PictureMimeType.isHasVideo((String)localMedia.getMimeType())) {
                if (this.config.videoMinSecond > 0 && localMedia.getDuration() < (long)this.config.videoMinSecond) {
                    this.showPromptDialog(this.context.getString(R.string.picture_choose_min_seconds, new Object[]{this.config.videoMinSecond / 1000}));
                    return;
                }
                if (this.config.videoMaxSecond > 0 && localMedia.getDuration() > (long)this.config.videoMaxSecond) {
                    this.showPromptDialog(this.context.getString(R.string.picture_choose_max_seconds, new Object[]{this.config.videoMaxSecond / 1000}));
                    return;
                }
            }
            this.imageSelectChangedListener.onPictureClick((Object)localMedia, n2);
        } else {
            this.changeCheckboxState(viewHolder, localMedia);
        }
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int n) {
        if (this.getItemViewType(n) == 1) {
            ((CameraViewHolder)viewHolder).itemView.setOnClickListener((View.OnClickListener)new _$.Lambda.PictureImageGridAdapter.qvbHL3G2CY7hZL16_NieLEof5nI(this));
        } else {
            viewHolder = (ViewHolder)viewHolder;
            Object object = this.data;
            int n2 = this.showCamera ? n - 1 : n;
            LocalMedia localMedia = object.get(n2);
            localMedia.position = viewHolder.getAbsoluteAdapterPosition();
            String string2 = localMedia.getPath();
            object = localMedia.getMimeType();
            if (this.config.checkNumMode) {
                this.notifyCheckChanged((ViewHolder)viewHolder, localMedia);
            }
            if (this.config.isSingleDirectReturn) {
                viewHolder.tvCheck.setVisibility(8);
                viewHolder.btnCheck.setVisibility(8);
            } else {
                this.selectImage((ViewHolder)viewHolder, this.isSelected(localMedia));
                viewHolder.tvCheck.setVisibility(0);
                viewHolder.btnCheck.setVisibility(0);
                if (this.config.isMaxSelectEnabledMask) {
                    this.dispatchHandleMask((ViewHolder)viewHolder, localMedia);
                }
            }
            TextView textView = viewHolder.tvIsGif;
            n2 = PictureMimeType.isGif((String)object) ? 0 : 8;
            textView.setVisibility(n2);
            if (PictureMimeType.isHasImage((String)localMedia.getMimeType())) {
                if (localMedia.loadLongImageStatus == -1) {
                    localMedia.isLongImage = MediaUtils.isLongImg((LocalMedia)localMedia);
                    localMedia.loadLongImageStatus = 0;
                }
                textView = viewHolder.tvLongChart;
                n2 = localMedia.isLongImage ? 0 : 8;
                textView.setVisibility(n2);
            } else {
                localMedia.loadLongImageStatus = -1;
                viewHolder.tvLongChart.setVisibility(8);
            }
            boolean bl = PictureMimeType.isHasVideo((String)object);
            if (!bl && !PictureMimeType.isHasAudio((String)object)) {
                viewHolder.tvDuration.setVisibility(8);
            } else {
                viewHolder.tvDuration.setVisibility(0);
                viewHolder.tvDuration.setText((CharSequence)DateUtils.formatDurationTime((long)localMedia.getDuration()));
                if (PictureSelectionConfig.uiStyle != null) {
                    if (bl) {
                        if (PictureSelectionConfig.uiStyle.picture_adapter_item_video_textLeftDrawable != 0) {
                            viewHolder.tvDuration.setCompoundDrawablesRelativeWithIntrinsicBounds(PictureSelectionConfig.uiStyle.picture_adapter_item_video_textLeftDrawable, 0, 0, 0);
                        } else {
                            viewHolder.tvDuration.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.picture_icon_video, 0, 0, 0);
                        }
                    } else if (PictureSelectionConfig.uiStyle.picture_adapter_item_audio_textLeftDrawable != 0) {
                        viewHolder.tvDuration.setCompoundDrawablesRelativeWithIntrinsicBounds(PictureSelectionConfig.uiStyle.picture_adapter_item_audio_textLeftDrawable, 0, 0, 0);
                    } else {
                        viewHolder.tvDuration.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.picture_icon_audio, 0, 0, 0);
                    }
                } else {
                    textView = viewHolder.tvDuration;
                    n2 = bl ? R.drawable.picture_icon_video : R.drawable.picture_icon_audio;
                    textView.setCompoundDrawablesRelativeWithIntrinsicBounds(n2, 0, 0, 0);
                }
            }
            if (this.config.chooseMode == PictureMimeType.ofAudio()) {
                viewHolder.ivPicture.setImageResource(R.drawable.picture_audio_placeholder);
            } else if (PictureSelectionConfig.imageEngine != null) {
                PictureSelectionConfig.imageEngine.loadGridImage(this.context, string2, viewHolder.ivPicture);
            }
            if (this.config.enablePreview || this.config.enPreviewVideo || this.config.enablePreviewAudio) {
                viewHolder.btnCheck.setOnClickListener((View.OnClickListener)new _$.Lambda.PictureImageGridAdapter.jK8zND_ULBbVcD8KDiSr5ySgn_Y(this, localMedia, (ViewHolder)viewHolder, (String)object));
            }
            viewHolder.contentView.setOnClickListener((View.OnClickListener)new _$.Lambda.PictureImageGridAdapter.PgVgZMJtlqgUy4Fuo95Ra5c5haQ(this, localMedia, (String)object, n, (ViewHolder)viewHolder));
        }
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int n) {
        if (n != 1) return new ViewHolder(LayoutInflater.from((Context)this.context).inflate(R.layout.picture_image_grid_item, viewGroup, false));
        return new CameraViewHolder(this, LayoutInflater.from((Context)this.context).inflate(R.layout.picture_item_camera, viewGroup, false));
    }

    public void selectImage(ViewHolder viewHolder, boolean bl) {
        viewHolder.tvCheck.setSelected(bl);
        int n = bl ? ContextCompat.getColor((Context)this.context, (int)R.color.picture_color_80) : ContextCompat.getColor((Context)this.context, (int)R.color.picture_color_20);
        ColorFilter colorFilter = BlendModeColorFilterCompat.createBlendModeColorFilterCompat((int)n, (BlendModeCompat)BlendModeCompat.SRC_ATOP);
        viewHolder.ivPicture.setColorFilter(colorFilter);
    }

    public void setOnPhotoSelectChangedListener(OnPhotoSelectChangedListener onPhotoSelectChangedListener) {
        this.imageSelectChangedListener = onPhotoSelectChangedListener;
    }

    public void setShowCamera(boolean bl) {
        this.showCamera = bl;
    }
}
