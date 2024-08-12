/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 *  android.os.Build$VERSION
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.ImageView
 *  android.widget.PopupWindow
 *  androidx.core.content.ContextCompat
 *  androidx.recyclerview.widget.LinearLayoutManager
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.recyclerview.widget.RecyclerView$Adapter
 *  androidx.recyclerview.widget.RecyclerView$LayoutManager
 *  com.luck.picture.lib.R$attr
 *  com.luck.picture.lib.R$drawable
 *  com.luck.picture.lib.R$id
 *  com.luck.picture.lib.R$layout
 *  com.luck.picture.lib.R$style
 *  com.luck.picture.lib.adapter.PictureAlbumDirectoryAdapter
 *  com.luck.picture.lib.config.PictureSelectionConfig
 *  com.luck.picture.lib.entity.LocalMedia
 *  com.luck.picture.lib.entity.LocalMediaFolder
 *  com.luck.picture.lib.listener.OnAlbumItemClickListener
 *  com.luck.picture.lib.tools.AnimUtils
 *  com.luck.picture.lib.tools.AttrsUtils
 *  com.luck.picture.lib.tools.ScreenUtils
 *  com.luck.picture.lib.widget._$$Lambda$FolderPopWindow$JfIt2u0SzY7s5fGYi42ZJ5bYzNA
 *  com.luck.picture.lib.widget._$$Lambda$FolderPopWindow$fAawcR6IyRSaOKtDL1Gr6XZmPzA
 */
package com.luck.picture.lib.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.luck.picture.lib.R;
import com.luck.picture.lib.adapter.PictureAlbumDirectoryAdapter;
import com.luck.picture.lib.config.PictureSelectionConfig;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.entity.LocalMediaFolder;
import com.luck.picture.lib.listener.OnAlbumItemClickListener;
import com.luck.picture.lib.tools.AnimUtils;
import com.luck.picture.lib.tools.AttrsUtils;
import com.luck.picture.lib.tools.ScreenUtils;
import com.luck.picture.lib.widget._$;
import java.util.List;

public class FolderPopWindow
extends PopupWindow {
    private PictureAlbumDirectoryAdapter adapter;
    private int chooseMode;
    private PictureSelectionConfig config;
    private Context context;
    private Drawable drawableDown;
    private Drawable drawableUp;
    private boolean isDismiss = false;
    private ImageView ivArrowView;
    private RecyclerView mRecyclerView;
    private int maxHeight;
    private View rootViewBg;
    private View window;

    public FolderPopWindow(Context context) {
        PictureSelectionConfig pictureSelectionConfig;
        this.context = context;
        this.config = pictureSelectionConfig = PictureSelectionConfig.getInstance();
        this.chooseMode = pictureSelectionConfig.chooseMode;
        pictureSelectionConfig = LayoutInflater.from((Context)context).inflate(R.layout.picture_window_folder, null);
        this.window = pictureSelectionConfig;
        this.setContentView((View)pictureSelectionConfig);
        this.setWidth(-1);
        this.setHeight(-2);
        this.setAnimationStyle(R.style.PictureThemeWindowStyle);
        this.setFocusable(true);
        this.setOutsideTouchable(true);
        this.update();
        if (PictureSelectionConfig.uiStyle != null) {
            if (PictureSelectionConfig.uiStyle.picture_top_titleArrowUpDrawable != 0) {
                this.drawableUp = ContextCompat.getDrawable((Context)context, (int)PictureSelectionConfig.uiStyle.picture_top_titleArrowUpDrawable);
            }
            if (PictureSelectionConfig.uiStyle.picture_top_titleArrowDownDrawable != 0) {
                this.drawableDown = ContextCompat.getDrawable((Context)context, (int)PictureSelectionConfig.uiStyle.picture_top_titleArrowDownDrawable);
            }
        } else if (PictureSelectionConfig.style != null) {
            if (PictureSelectionConfig.style.pictureTitleUpResId != 0) {
                this.drawableUp = ContextCompat.getDrawable((Context)context, (int)PictureSelectionConfig.style.pictureTitleUpResId);
            }
            if (PictureSelectionConfig.style.pictureTitleDownResId != 0) {
                this.drawableDown = ContextCompat.getDrawable((Context)context, (int)PictureSelectionConfig.style.pictureTitleDownResId);
            }
        } else if (this.config.isWeChatStyle) {
            this.drawableUp = ContextCompat.getDrawable((Context)context, (int)R.drawable.picture_icon_wechat_up);
            this.drawableDown = ContextCompat.getDrawable((Context)context, (int)R.drawable.picture_icon_wechat_down);
        } else {
            this.drawableUp = this.config.upResId != 0 ? ContextCompat.getDrawable((Context)context, (int)this.config.upResId) : AttrsUtils.getTypeValueDrawable((Context)context, (int)R.attr.picture_arrow_up_icon, (int)R.drawable.picture_icon_arrow_up);
            this.drawableDown = this.config.downResId != 0 ? ContextCompat.getDrawable((Context)context, (int)this.config.downResId) : AttrsUtils.getTypeValueDrawable((Context)context, (int)R.attr.picture_arrow_down_icon, (int)R.drawable.picture_icon_arrow_down);
        }
        double d = ScreenUtils.getScreenHeight((Context)context);
        Double.isNaN(d);
        this.maxHeight = (int)(d * 0.6);
        this.initView();
    }

    public void bindFolder(List<LocalMediaFolder> list) {
        this.adapter.setChooseMode(this.chooseMode);
        this.adapter.bindFolderData(list);
        ViewGroup.LayoutParams layoutParams = this.mRecyclerView.getLayoutParams();
        int n = list != null && list.size() > 8 ? this.maxHeight : -2;
        layoutParams.height = n;
    }

    public void dismiss() {
        if (this.isDismiss) {
            return;
        }
        this.rootViewBg.animate().alpha(0.0f).setDuration(50L).start();
        this.ivArrowView.setImageDrawable(this.drawableDown);
        AnimUtils.rotateArrow((ImageView)this.ivArrowView, (boolean)false);
        this.isDismiss = true;
        FolderPopWindow.super.dismiss();
        this.isDismiss = false;
    }

    public LocalMediaFolder getFolder(int n) {
        LocalMediaFolder localMediaFolder = this.adapter.getFolderData().size() > 0 && n < this.adapter.getFolderData().size() ? (LocalMediaFolder)this.adapter.getFolderData().get(n) : null;
        return localMediaFolder;
    }

    public List<LocalMediaFolder> getFolderData() {
        return this.adapter.getFolderData();
    }

    public void initView() {
        RecyclerView recyclerView;
        this.rootViewBg = this.window.findViewById(R.id.rootViewBg);
        this.adapter = new PictureAlbumDirectoryAdapter(this.config);
        this.mRecyclerView = recyclerView = (RecyclerView)this.window.findViewById(R.id.folder_list);
        recyclerView.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager(this.context));
        this.mRecyclerView.setAdapter((RecyclerView.Adapter)this.adapter);
        recyclerView = this.window.findViewById(R.id.rootView);
        this.rootViewBg.setOnClickListener((View.OnClickListener)new _$.Lambda.FolderPopWindow.fAawcR6IyRSaOKtDL1Gr6XZmPzA(this));
        if (Build.VERSION.SDK_INT >= 21) return;
        recyclerView.setOnClickListener((View.OnClickListener)new _$.Lambda.FolderPopWindow.JfIt2u0SzY7s5fGYi42ZJ5bYzNA(this));
    }

    public boolean isEmpty() {
        boolean bl = this.adapter.getFolderData().size() == 0;
        return bl;
    }

    public /* synthetic */ void lambda$initView$0$FolderPopWindow(View view) {
        this.dismiss();
    }

    public /* synthetic */ void lambda$initView$1$FolderPopWindow(View view) {
        this.dismiss();
    }

    public void setArrowImageView(ImageView imageView) {
        this.ivArrowView = imageView;
    }

    public void setOnAlbumItemClickListener(OnAlbumItemClickListener onAlbumItemClickListener) {
        this.adapter.setOnAlbumItemClickListener(onAlbumItemClickListener);
    }

    public void showAsDropDown(View view) {
        try {
            if (Build.VERSION.SDK_INT == 24) {
                int[] nArray = new int[2];
                view.getLocationInWindow(nArray);
                this.showAtLocation(view, 0, 0, nArray[1] + view.getHeight());
            } else {
                super.showAsDropDown(view);
            }
            this.isDismiss = false;
            this.ivArrowView.setImageDrawable(this.drawableUp);
            AnimUtils.rotateArrow((ImageView)this.ivArrowView, (boolean)true);
            this.rootViewBg.animate().alpha(1.0f).setDuration(250L).setStartDelay(250L).start();
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public void updateFolderCheckStatus(List<LocalMedia> list) {
        try {
            List list2 = this.adapter.getFolderData();
            int n = list2.size();
            int n2 = list.size();
            block4: for (int i = 0; i < n; ++i) {
                LocalMediaFolder localMediaFolder = (LocalMediaFolder)list2.get(i);
                localMediaFolder.setCheckedNum(0);
                for (int j = 0; j < n2; ++j) {
                    LocalMedia localMedia = list.get(j);
                    if (!localMediaFolder.getName().equals(localMedia.getParentFolderName()) && localMediaFolder.getBucketId() != -1L) {
                        continue;
                    }
                    localMediaFolder.setCheckedNum(1);
                    continue block4;
                }
            }
            this.adapter.bindFolderData(list2);
            return;
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
