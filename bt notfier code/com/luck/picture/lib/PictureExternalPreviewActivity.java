/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.content.ContentValues
 *  android.content.Context
 *  android.graphics.PointF
 *  android.net.Uri
 *  android.os.Bundle
 *  android.os.Environment
 *  android.provider.MediaStore$Images$Media
 *  android.text.TextUtils
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.Button
 *  android.widget.ImageButton
 *  android.widget.TextView
 *  androidx.viewpager.widget.PagerAdapter
 *  androidx.viewpager.widget.ViewPager$OnPageChangeListener
 *  com.luck.picture.lib.PictureBaseActivity
 *  com.luck.picture.lib.PictureExternalPreviewActivity$SimpleFragmentAdapter
 *  com.luck.picture.lib.PictureMediaScannerConnection
 *  com.luck.picture.lib.PictureMediaScannerConnection$ScanListener
 *  com.luck.picture.lib.R$anim
 *  com.luck.picture.lib.R$attr
 *  com.luck.picture.lib.R$id
 *  com.luck.picture.lib.R$layout
 *  com.luck.picture.lib.R$string
 *  com.luck.picture.lib._$$Lambda$PictureExternalPreviewActivity$gva7b6rUctWQr62K08HaUc0SYxs
 *  com.luck.picture.lib._$$Lambda$PictureExternalPreviewActivity$qKVtHY2I5kxeVkmP4Pw0AdtjFDU
 *  com.luck.picture.lib._$$Lambda$PictureExternalPreviewActivity$wteLrkruQxV_Pz_YQfcha8xSBUA
 *  com.luck.picture.lib.broadcast.BroadcastManager
 *  com.luck.picture.lib.config.PictureMimeType
 *  com.luck.picture.lib.config.PictureSelectionConfig
 *  com.luck.picture.lib.dialog.PictureCustomDialog
 *  com.luck.picture.lib.entity.LocalMedia
 *  com.luck.picture.lib.thread.PictureThreadUtils
 *  com.luck.picture.lib.thread.PictureThreadUtils$Task
 *  com.luck.picture.lib.tools.AttrsUtils
 *  com.luck.picture.lib.tools.DateUtils
 *  com.luck.picture.lib.tools.PictureFileUtils
 *  com.luck.picture.lib.tools.SdkVersionUtils
 *  com.luck.picture.lib.tools.ToastUtils
 *  com.luck.picture.lib.tools.ValueOf
 *  com.luck.picture.lib.widget.PreviewViewPager
 *  com.luck.picture.lib.widget.longimage.ImageSource
 *  com.luck.picture.lib.widget.longimage.ImageViewState
 *  com.luck.picture.lib.widget.longimage.SubsamplingScaleImageView
 *  okio.BufferedSource
 *  okio.Okio
 *  okio.Source
 */
package com.luck.picture.lib;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.graphics.PointF;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.luck.picture.lib.PictureBaseActivity;
import com.luck.picture.lib.PictureExternalPreviewActivity;
import com.luck.picture.lib.PictureMediaScannerConnection;
import com.luck.picture.lib.R;
import com.luck.picture.lib._$;
import com.luck.picture.lib.broadcast.BroadcastManager;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.config.PictureSelectionConfig;
import com.luck.picture.lib.dialog.PictureCustomDialog;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.thread.PictureThreadUtils;
import com.luck.picture.lib.tools.AttrsUtils;
import com.luck.picture.lib.tools.DateUtils;
import com.luck.picture.lib.tools.PictureFileUtils;
import com.luck.picture.lib.tools.SdkVersionUtils;
import com.luck.picture.lib.tools.ToastUtils;
import com.luck.picture.lib.tools.ValueOf;
import com.luck.picture.lib.widget.PreviewViewPager;
import com.luck.picture.lib.widget.longimage.ImageSource;
import com.luck.picture.lib.widget.longimage.ImageViewState;
import com.luck.picture.lib.widget.longimage.SubsamplingScaleImageView;
import java.io.Closeable;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import okio.BufferedSource;
import okio.Okio;
import okio.Source;

/*
 * Exception performing whole class analysis ignored.
 */
public class PictureExternalPreviewActivity
extends PictureBaseActivity
implements View.OnClickListener {
    private SimpleFragmentAdapter adapter;
    private String downloadPath;
    private ImageButton ibDelete;
    private ImageButton ibLeftBack;
    private final List<LocalMedia> images = new ArrayList<LocalMedia>();
    private String mMimeType;
    private View mTitleBar;
    private int position = 0;
    private TextView tvTitle;
    private PreviewViewPager viewPager;

    static /* synthetic */ List access$000(PictureExternalPreviewActivity pictureExternalPreviewActivity) {
        return pictureExternalPreviewActivity.images;
    }

    static /* synthetic */ TextView access$100(PictureExternalPreviewActivity pictureExternalPreviewActivity) {
        return pictureExternalPreviewActivity.tvTitle;
    }

    static /* synthetic */ int access$202(PictureExternalPreviewActivity pictureExternalPreviewActivity, int n) {
        pictureExternalPreviewActivity.position = n;
        return n;
    }

    static /* synthetic */ void access$300(PictureExternalPreviewActivity pictureExternalPreviewActivity, Uri uri, SubsamplingScaleImageView subsamplingScaleImageView) {
        pictureExternalPreviewActivity.displayLongPic(uri, subsamplingScaleImageView);
    }

    static /* synthetic */ String access$400(PictureExternalPreviewActivity pictureExternalPreviewActivity) {
        return pictureExternalPreviewActivity.downloadPath;
    }

    static /* synthetic */ String access$402(PictureExternalPreviewActivity pictureExternalPreviewActivity, String string) {
        pictureExternalPreviewActivity.downloadPath = string;
        return string;
    }

    static /* synthetic */ String access$502(PictureExternalPreviewActivity pictureExternalPreviewActivity, String string) {
        pictureExternalPreviewActivity.mMimeType = string;
        return string;
    }

    static /* synthetic */ void access$600(PictureExternalPreviewActivity pictureExternalPreviewActivity) {
        pictureExternalPreviewActivity.showDownLoadDialog();
    }

    static /* synthetic */ void access$700(PictureExternalPreviewActivity pictureExternalPreviewActivity) {
        pictureExternalPreviewActivity.exitAnimation();
    }

    static /* synthetic */ void access$800(PictureExternalPreviewActivity pictureExternalPreviewActivity, String string) {
        pictureExternalPreviewActivity.onSuccessful(string);
    }

    private Uri createOutImageUri() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("_display_name", DateUtils.getCreateFileName((String)"IMG_"));
        contentValues.put("datetaken", ValueOf.toString((Object)System.currentTimeMillis()));
        contentValues.put("mime_type", this.mMimeType);
        contentValues.put("relative_path", "DCIM/Camera");
        return this.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
    }

    private void displayLongPic(Uri uri, SubsamplingScaleImageView subsamplingScaleImageView) {
        subsamplingScaleImageView.setQuickScaleEnabled(true);
        subsamplingScaleImageView.setZoomEnabled(true);
        subsamplingScaleImageView.setDoubleTapZoomDuration(100);
        subsamplingScaleImageView.setMinimumScaleType(2);
        subsamplingScaleImageView.setDoubleTapZoomDpi(2);
        subsamplingScaleImageView.setImage(ImageSource.uri((Uri)uri), new ImageViewState(0.0f, new PointF(0.0f, 0.0f), 0));
    }

    private void exitAnimation() {
        this.overridePendingTransition(R.anim.picture_anim_fade_in, PictureSelectionConfig.windowAnimationStyle.activityPreviewExitAnimation);
    }

    private void initViewPageAdapterData() {
        SimpleFragmentAdapter simpleFragmentAdapter;
        this.tvTitle.setText((CharSequence)this.getString(R.string.picture_preview_image_num, new Object[]{this.position + 1, this.images.size()}));
        this.adapter = simpleFragmentAdapter = new SimpleFragmentAdapter(this);
        this.viewPager.setAdapter((PagerAdapter)simpleFragmentAdapter);
        this.viewPager.setCurrentItem(this.position);
        this.viewPager.addOnPageChangeListener((ViewPager.OnPageChangeListener)new /* Unavailable Anonymous Inner Class!! */);
    }

    static /* synthetic */ void lambda$onSuccessful$2() {
    }

    private void onSuccessful(String string2) {
        this.dismissDialog();
        if (!TextUtils.isEmpty((CharSequence)string2)) {
            try {
                Serializable serializable;
                if (!SdkVersionUtils.checkedAndroid_Q()) {
                    serializable = new File(string2);
                    MediaStore.Images.Media.insertImage((ContentResolver)this.getContentResolver(), (String)((File)serializable).getAbsolutePath(), (String)((File)serializable).getName(), null);
                    new PictureMediaScannerConnection(this.getContext(), ((File)serializable).getAbsolutePath(), (PictureMediaScannerConnection.ScanListener)_$.Lambda.PictureExternalPreviewActivity.gva7b6rUctWQr62K08HaUc0SYxs.INSTANCE);
                }
                Context context = this.getContext();
                serializable = new StringBuilder();
                ((StringBuilder)serializable).append(this.getString(R.string.picture_save_success));
                ((StringBuilder)serializable).append("\n");
                ((StringBuilder)serializable).append(string2);
                ToastUtils.s((Context)context, (String)((StringBuilder)serializable).toString());
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        } else {
            ToastUtils.s((Context)this.getContext(), (String)this.getString(R.string.picture_save_error));
        }
    }

    private void savePictureAlbum() throws Exception {
        String string2 = PictureMimeType.getLastImgSuffix((String)this.mMimeType);
        Object object = Environment.getExternalStorageState();
        Object object2 = ((String)object).equals("mounted") ? Environment.getExternalStoragePublicDirectory((String)Environment.DIRECTORY_DCIM) : this.getContext().getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        if (object2 != null && !((File)object2).exists()) {
            ((File)object2).mkdirs();
        }
        if (!SdkVersionUtils.checkedAndroid_Q() && ((String)object).equals("mounted")) {
            object = new StringBuilder();
            ((StringBuilder)object).append(((File)object2).getAbsolutePath());
            ((StringBuilder)object).append(File.separator);
            ((StringBuilder)object).append("Camera");
            ((StringBuilder)object).append(File.separator);
            object2 = ((StringBuilder)object).toString();
        } else {
            object2 = ((File)object2).getAbsolutePath();
        }
        object = new File((String)object2);
        if (!((File)object).exists()) {
            ((File)object).mkdirs();
        }
        object2 = new StringBuilder();
        ((StringBuilder)object2).append(DateUtils.getCreateFileName((String)"IMG_"));
        ((StringBuilder)object2).append(string2);
        object2 = new File((File)object, ((StringBuilder)object2).toString());
        PictureFileUtils.copyFile((String)this.downloadPath, (String)((File)object2).getAbsolutePath());
        this.onSuccessful(((File)object2).getAbsolutePath());
    }

    private void savePictureAlbumAndroidQ(Uri uri) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("_display_name", DateUtils.getCreateFileName((String)"IMG_"));
        contentValues.put("datetaken", ValueOf.toString((Object)System.currentTimeMillis()));
        contentValues.put("mime_type", this.mMimeType);
        contentValues.put("relative_path", "DCIM/Camera");
        contentValues = this.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
        if (contentValues == null) {
            ToastUtils.s((Context)this.getContext(), (String)this.getString(R.string.picture_save_error));
            return;
        }
        PictureThreadUtils.executeBySingle((PictureThreadUtils.Task)new /* Unavailable Anonymous Inner Class!! */);
    }

    private void showDownLoadDialog() {
        if (this.isFinishing()) return;
        if (TextUtils.isEmpty((CharSequence)this.downloadPath)) return;
        PictureCustomDialog pictureCustomDialog = new PictureCustomDialog(this.getContext(), R.layout.picture_wind_base_dialog);
        Button button = (Button)pictureCustomDialog.findViewById(R.id.btn_cancel);
        Button button2 = (Button)pictureCustomDialog.findViewById(R.id.btn_commit);
        TextView textView = (TextView)pictureCustomDialog.findViewById(R.id.tvTitle);
        TextView textView2 = (TextView)pictureCustomDialog.findViewById(R.id.tv_content);
        textView.setText((CharSequence)this.getString(R.string.picture_prompt));
        textView2.setText((CharSequence)this.getString(R.string.picture_prompt_content));
        button.setOnClickListener((View.OnClickListener)new _$.Lambda.PictureExternalPreviewActivity.qKVtHY2I5kxeVkmP4Pw0AdtjFDU(this, pictureCustomDialog));
        button2.setOnClickListener((View.OnClickListener)new _$.Lambda.PictureExternalPreviewActivity.wteLrkruQxV_Pz_YQfcha8xSBUA(this, pictureCustomDialog));
        pictureCustomDialog.show();
    }

    public int getResourceId() {
        return R.layout.picture_activity_external_preview;
    }

    public void initPictureSelectorStyle() {
        if (PictureSelectionConfig.style != null) {
            if (PictureSelectionConfig.style.pictureTitleTextColor != 0) {
                this.tvTitle.setTextColor(PictureSelectionConfig.style.pictureTitleTextColor);
            }
            if (PictureSelectionConfig.style.pictureTitleTextSize != 0) {
                this.tvTitle.setTextSize((float)PictureSelectionConfig.style.pictureTitleTextSize);
            }
            if (PictureSelectionConfig.style.pictureLeftBackIcon != 0) {
                this.ibLeftBack.setImageResource(PictureSelectionConfig.style.pictureLeftBackIcon);
            }
            if (PictureSelectionConfig.style.pictureExternalPreviewDeleteStyle != 0) {
                this.ibDelete.setImageResource(PictureSelectionConfig.style.pictureExternalPreviewDeleteStyle);
            }
            if (PictureSelectionConfig.style.pictureTitleBarBackgroundColor == 0) return;
            this.mTitleBar.setBackgroundColor(this.colorPrimary);
        } else {
            int n = AttrsUtils.getTypeValueColor((Context)this.getContext(), (int)R.attr.picture_ac_preview_title_bg);
            if (n != 0) {
                this.mTitleBar.setBackgroundColor(n);
            } else {
                this.mTitleBar.setBackgroundColor(this.colorPrimary);
            }
        }
    }

    protected void initWidgets() {
        super.initWidgets();
        this.mTitleBar = this.findViewById(R.id.titleBar);
        this.tvTitle = (TextView)this.findViewById(R.id.picture_title);
        this.ibLeftBack = (ImageButton)this.findViewById(R.id.left_back);
        this.ibDelete = (ImageButton)this.findViewById(R.id.ib_delete);
        this.viewPager = (PreviewViewPager)this.findViewById(R.id.preview_pager);
        Object object = this.getIntent();
        int n = 0;
        this.position = object.getIntExtra("position", 0);
        object = this.getIntent().getParcelableArrayListExtra("previewSelectList");
        if (object != null && object.size() > 0) {
            this.images.addAll((Collection<LocalMedia>)object);
        }
        this.ibLeftBack.setOnClickListener((View.OnClickListener)this);
        this.ibDelete.setOnClickListener((View.OnClickListener)this);
        object = this.ibDelete;
        if (PictureSelectionConfig.style == null || !PictureSelectionConfig.style.pictureExternalPreviewGonePreviewDelete) {
            n = 8;
        }
        object.setVisibility(n);
        this.initViewPageAdapterData();
    }

    public /* synthetic */ void lambda$showDownLoadDialog$0$PictureExternalPreviewActivity(PictureCustomDialog pictureCustomDialog, View view) {
        if (this.isFinishing()) return;
        pictureCustomDialog.dismiss();
    }

    public /* synthetic */ void lambda$showDownLoadDialog$1$PictureExternalPreviewActivity(PictureCustomDialog pictureCustomDialog, View object) {
        boolean bl = PictureMimeType.isHasHttp((String)this.downloadPath);
        this.showPleaseDialog();
        if (bl) {
            PictureThreadUtils.executeBySingle((PictureThreadUtils.Task)new /* Unavailable Anonymous Inner Class!! */);
        } else {
            try {
                if (PictureMimeType.isContent((String)this.downloadPath)) {
                    if (PictureMimeType.isContent((String)this.downloadPath)) {
                        object = Uri.parse((String)this.downloadPath);
                    } else {
                        object = new File(this.downloadPath);
                        object = Uri.fromFile((File)object);
                    }
                    this.savePictureAlbumAndroidQ((Uri)object);
                } else {
                    this.savePictureAlbum();
                }
            }
            catch (Exception exception) {
                Context context = this.getContext();
                object = new StringBuilder();
                ((StringBuilder)object).append(this.getString(R.string.picture_save_error));
                ((StringBuilder)object).append("\n");
                ((StringBuilder)object).append(exception.getMessage());
                ToastUtils.s((Context)context, (String)((StringBuilder)object).toString());
                this.dismissDialog();
                exception.printStackTrace();
            }
        }
        if (this.isFinishing()) return;
        pictureCustomDialog.dismiss();
    }

    public void onBackPressed() {
        if (SdkVersionUtils.checkedAndroid_Q()) {
            this.finishAfterTransition();
        } else {
            super.onBackPressed();
        }
        this.finish();
        this.exitAnimation();
    }

    public void onClick(View view) {
        int n = view.getId();
        if (n == R.id.left_back) {
            this.finish();
            this.exitAnimation();
        } else {
            if (n != R.id.ib_delete) return;
            if (this.images.size() <= 0) return;
            n = this.viewPager.getCurrentItem();
            this.images.remove(n);
            this.adapter.removeCacheView(n);
            view = new Bundle();
            view.putInt("position", n);
            BroadcastManager.getInstance((Context)this.getContext()).action("com.luck.picture.lib.action.delete_preview_position").extras((Bundle)view).broadcast();
            if (this.images.size() == 0) {
                this.onBackPressed();
                return;
            }
            this.tvTitle.setText((CharSequence)this.getString(R.string.picture_preview_image_num, new Object[]{this.position + 1, this.images.size()}));
            this.position = n;
            this.adapter.notifyDataSetChanged();
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        SimpleFragmentAdapter simpleFragmentAdapter = this.adapter;
        if (simpleFragmentAdapter != null) {
            SimpleFragmentAdapter.access$900((SimpleFragmentAdapter)simpleFragmentAdapter);
        }
        PictureSelectionConfig.destroy();
    }

    public void onRequestPermissionsResult(int n, String[] stringArray, int[] nArray) {
        super.onRequestPermissionsResult(n, stringArray, nArray);
        if (n != 1) return;
        int n2 = nArray.length;
        n = 0;
        while (n < n2) {
            if (nArray[n] == 0) {
                this.showDownLoadDialog();
            } else {
                ToastUtils.s((Context)this.getContext(), (String)this.getString(R.string.picture_jurisdiction));
            }
            ++n;
        }
    }

    /*
     * Loose catch block
     * WARNING - void declaration
     * Enabled unnecessary exception pruning
     */
    public String showLoadingImage(String string2) {
        void var9_36;
        void var8_30;
        Object object;
        block26: {
            void var1_10;
            Object object2;
            CharSequence charSequence;
            Object object3;
            block29: {
                Object object4;
                block28: {
                    Object object5;
                    Object object6;
                    block27: {
                        block30: {
                            Object var5_11 = null;
                            try {
                                Object var8_26;
                                block25: {
                                    String string3;
                                    try {
                                        if (SdkVersionUtils.checkedAndroid_Q()) {
                                            object3 = this.createOutImageUri();
                                        } else {
                                            object4 = PictureMimeType.getLastImgSuffix((String)this.mMimeType);
                                            charSequence = Environment.getExternalStorageState();
                                            object2 = ((String)charSequence).equals("mounted") ? Environment.getExternalStoragePublicDirectory((String)Environment.DIRECTORY_DCIM) : this.getContext().getExternalFilesDir(Environment.DIRECTORY_PICTURES);
                                            if (object2 != null) {
                                                if (!((File)object2).exists()) {
                                                    ((File)object2).mkdirs();
                                                }
                                                if (!((String)charSequence).equals("mounted")) {
                                                    object2 = ((File)object2).getAbsolutePath();
                                                } else {
                                                    charSequence = new StringBuilder();
                                                    ((StringBuilder)charSequence).append(((File)object2).getAbsolutePath());
                                                    ((StringBuilder)charSequence).append(File.separator);
                                                    ((StringBuilder)charSequence).append("Camera");
                                                    ((StringBuilder)charSequence).append(File.separator);
                                                    object2 = ((StringBuilder)charSequence).toString();
                                                }
                                                object3 = new File((String)object2);
                                                if (!((File)object3).exists()) {
                                                    ((File)object3).mkdirs();
                                                }
                                                object2 = new StringBuilder();
                                                ((StringBuilder)object2).append(DateUtils.getCreateFileName((String)"IMG_"));
                                                ((StringBuilder)object2).append((String)object4);
                                                object2 = ((StringBuilder)object2).toString();
                                                object4 = new File((File)object3, (String)object2);
                                                object3 = Uri.fromFile((File)object4);
                                            } else {
                                                object3 = null;
                                            }
                                        }
                                        if (object3 == null) break block25;
                                    }
                                    catch (Exception exception) {
                                        object4 = null;
                                    }
                                    try {
                                        object2 = Objects.requireNonNull(this.getContentResolver().openOutputStream((Uri)object3));
                                    }
                                    catch (Exception exception) {
                                        object4 = object3;
                                        break block30;
                                    }
                                    object4 = new URL(string2);
                                    object4 = ((URL)object4).openStream();
                                    string2 = Okio.buffer((Source)Okio.source((InputStream)object4));
                                    Object object7 = object2;
                                    charSequence = string2;
                                    object6 = object4;
                                    Object object8 = object2;
                                    String string4 = string2;
                                    object = object4;
                                    try {
                                        if (!PictureFileUtils.bufferCopy((BufferedSource)string2, (OutputStream)object2)) break block26;
                                        Object object9 = object2;
                                        charSequence = string2;
                                        object6 = object4;
                                        string3 = PictureFileUtils.getPath((Context)this, (Uri)object3);
                                    }
                                    catch (Exception exception) {
                                        object5 = object3;
                                        object3 = object2;
                                        object2 = object4;
                                        break block27;
                                    }
                                    PictureFileUtils.close((Closeable)object4);
                                    PictureFileUtils.close((Closeable)object2);
                                    PictureFileUtils.close((Closeable)((Object)string2));
                                    return string3;
                                    catch (Throwable throwable) {
                                        charSequence = null;
                                        break block28;
                                    }
                                    catch (Exception exception) {
                                        string2 = null;
                                        object5 = object3;
                                        object3 = object2;
                                        object2 = object4;
                                        break block27;
                                    }
                                    catch (Throwable throwable) {
                                        charSequence = null;
                                        object3 = var5_11;
                                        break block29;
                                    }
                                    catch (Exception exception) {
                                        object4 = null;
                                        string2 = null;
                                        object5 = object3;
                                        object3 = object2;
                                        object2 = object4;
                                        break block27;
                                    }
                                }
                                object = null;
                                Object var9_32 = var8_26 = null;
                                break block26;
                            }
                            catch (Throwable throwable) {
                                object2 = null;
                                charSequence = null;
                                object3 = var5_11;
                                break block29;
                            }
                        }
                        object2 = null;
                        object3 = null;
                        string2 = null;
                        object5 = object4;
                    }
                    Uri uri = object3;
                    String string5 = string2;
                    object = object2;
                    if (object5 == null) break block26;
                    Uri uri2 = object3;
                    charSequence = string2;
                    object6 = object2;
                    Object object10 = object3;
                    String string6 = string2;
                    object = object2;
                    try {
                        if (SdkVersionUtils.checkedAndroid_Q()) {
                            Object object11 = object3;
                            charSequence = string2;
                            object6 = object2;
                            this.getContentResolver().delete((Uri)object5, null, null);
                            Object object12 = object3;
                            String string7 = string2;
                            object = object2;
                        }
                        break block26;
                    }
                    catch (Throwable throwable) {
                        void var5_18;
                        object4 = object6;
                        object2 = var5_18;
                    }
                }
                object3 = object4;
            }
            PictureFileUtils.close((Closeable)object3);
            PictureFileUtils.close(object2);
            PictureFileUtils.close((Closeable)((Object)charSequence));
            throw var1_10;
        }
        PictureFileUtils.close(object);
        PictureFileUtils.close((Closeable)var8_30);
        PictureFileUtils.close((Closeable)var9_36);
        return null;
    }
}
