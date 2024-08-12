/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Environment
 *  android.text.TextUtils
 *  android.util.Log
 *  com.luck.picture.lib.compress.Checker
 *  com.luck.picture.lib.compress.CompressionPredicate
 *  com.luck.picture.lib.compress.Engine
 *  com.luck.picture.lib.compress.InputStreamProvider
 *  com.luck.picture.lib.compress.Luban$Builder
 *  com.luck.picture.lib.compress.OnCompressListener
 *  com.luck.picture.lib.compress.OnRenameListener
 *  com.luck.picture.lib.config.PictureMimeType
 *  com.luck.picture.lib.entity.LocalMedia
 *  com.luck.picture.lib.thread.PictureThreadUtils
 *  com.luck.picture.lib.thread.PictureThreadUtils$Task
 *  com.luck.picture.lib.tools.AndroidQTransformUtils
 *  com.luck.picture.lib.tools.DateUtils
 *  com.luck.picture.lib.tools.SdkVersionUtils
 *  com.luck.picture.lib.tools.StringUtils
 */
package com.luck.picture.lib.compress;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import com.luck.picture.lib.compress.Checker;
import com.luck.picture.lib.compress.CompressionPredicate;
import com.luck.picture.lib.compress.Engine;
import com.luck.picture.lib.compress.InputStreamProvider;
import com.luck.picture.lib.compress.Luban;
import com.luck.picture.lib.compress.OnCompressListener;
import com.luck.picture.lib.compress.OnRenameListener;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.thread.PictureThreadUtils;
import com.luck.picture.lib.tools.AndroidQTransformUtils;
import com.luck.picture.lib.tools.DateUtils;
import com.luck.picture.lib.tools.SdkVersionUtils;
import com.luck.picture.lib.tools.StringUtils;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
 * Exception performing whole class analysis ignored.
 */
public class Luban {
    private static final String TAG = "Luban";
    private final int compressQuality;
    private final int dataCount;
    private final boolean focusAlpha;
    private int index = -1;
    private boolean isAutoRotating;
    private final boolean isCamera;
    private final OnCompressListener mCompressListener;
    private final CompressionPredicate mCompressionPredicate;
    private final int mLeastCompressSize;
    private final String mNewFileName;
    private final List<String> mPaths;
    private final OnRenameListener mRenameListener;
    private final List<InputStreamProvider> mStreamProviders;
    private String mTargetDir;
    private final List<LocalMedia> mediaList;

    private Luban(Builder builder) {
        this.mPaths = Builder.access$000((Builder)builder);
        this.mediaList = Builder.access$100((Builder)builder);
        this.dataCount = Builder.access$200((Builder)builder);
        this.mTargetDir = Builder.access$300((Builder)builder);
        this.mNewFileName = Builder.access$400((Builder)builder);
        this.mRenameListener = Builder.access$500((Builder)builder);
        this.mStreamProviders = Builder.access$600((Builder)builder);
        this.mCompressListener = Builder.access$700((Builder)builder);
        this.mLeastCompressSize = Builder.access$800((Builder)builder);
        this.mCompressionPredicate = Builder.access$900((Builder)builder);
        this.compressQuality = Builder.access$1000((Builder)builder);
        this.isAutoRotating = Builder.access$1100((Builder)builder);
        this.focusAlpha = Builder.access$1200((Builder)builder);
        this.isCamera = Builder.access$1300((Builder)builder);
    }

    static /* synthetic */ int access$1400(Luban luban) {
        return luban.index;
    }

    static /* synthetic */ int access$1402(Luban luban, int n) {
        luban.index = n;
        return n;
    }

    static /* synthetic */ int access$1408(Luban luban) {
        int n = luban.index;
        luban.index = n + 1;
        return n;
    }

    static /* synthetic */ File access$1500(Luban luban, Context context, InputStreamProvider inputStreamProvider) throws Exception {
        return luban.compress(context, inputStreamProvider);
    }

    static /* synthetic */ List access$1600(Luban luban) {
        return luban.mediaList;
    }

    static /* synthetic */ OnCompressListener access$1700(Luban luban) {
        return luban.mCompressListener;
    }

    static /* synthetic */ void access$2000(Luban luban, Context context) {
        luban.launch(context);
    }

    static /* synthetic */ File access$2100(Luban luban, InputStreamProvider inputStreamProvider, Context context) throws IOException {
        return luban.get(inputStreamProvider, context);
    }

    static /* synthetic */ List access$2200(Luban luban, Context context) throws Exception {
        return luban.get(context);
    }

    private File compress(Context object, InputStreamProvider inputStreamProvider) throws Exception {
        try {
            object = this.compressRealLocalMedia((Context)object, inputStreamProvider);
            return object;
        }
        finally {
            inputStreamProvider.close();
        }
    }

    private File compressReal(Context object, InputStreamProvider inputStreamProvider) throws IOException {
        Object object2 = Checker.SINGLE;
        Object object3 = inputStreamProvider.getMedia() != null ? inputStreamProvider.getMedia().getMimeType() : "";
        object2 = object2.extSuffix((String)object3);
        TextUtils.isEmpty((CharSequence)object2);
        object3 = this.getImageCacheFile((Context)object, inputStreamProvider, (String)object2);
        OnRenameListener onRenameListener = this.mRenameListener;
        if (onRenameListener != null) {
            object3 = this.getImageCustomFile((Context)object, onRenameListener.rename(inputStreamProvider.getPath()));
        }
        object = (onRenameListener = this.mCompressionPredicate) != null ? (onRenameListener.apply(inputStreamProvider.getPath()) && Checker.SINGLE.needCompress(this.mLeastCompressSize, inputStreamProvider.getPath()) ? new Engine(object, inputStreamProvider, (File)object3, this.focusAlpha, this.compressQuality, this.isAutoRotating).compress() : new File(inputStreamProvider.getPath())) : (((String)object2).startsWith(".gif") ? new File(inputStreamProvider.getPath()) : (Checker.SINGLE.needCompress(this.mLeastCompressSize, inputStreamProvider.getPath()) ? new Engine(object, inputStreamProvider, (File)object3, this.focusAlpha, this.compressQuality, this.isAutoRotating).compress() : new File(inputStreamProvider.getPath())));
        return object;
    }

    private File compressRealLocalMedia(Context object, InputStreamProvider inputStreamProvider) throws Exception {
        String string;
        LocalMedia localMedia = inputStreamProvider.getMedia();
        String string2 = localMedia.isCut() && !TextUtils.isEmpty((CharSequence)localMedia.getCutPath()) ? localMedia.getCutPath() : localMedia.getRealPath();
        String string3 = Checker.SINGLE.extSuffix(localMedia.getMimeType());
        File file = this.getImageCacheFile((Context)object, inputStreamProvider, string3);
        if (!TextUtils.isEmpty((CharSequence)this.mNewFileName)) {
            string = !this.isCamera && this.dataCount != 1 ? StringUtils.rename((String)this.mNewFileName) : this.mNewFileName;
            file = this.getImageCustomFile((Context)object, string);
        } else {
            string = "";
        }
        if (file.exists()) {
            return file;
        }
        if (this.mCompressionPredicate != null) {
            if (string3.startsWith(".gif")) {
                object = SdkVersionUtils.checkedAndroid_Q() ? (localMedia.isCut() && !TextUtils.isEmpty((CharSequence)localMedia.getCutPath()) ? new File(localMedia.getCutPath()) : new File(AndroidQTransformUtils.copyPathToAndroidQ((Context)object, (long)inputStreamProvider.getMedia().getId(), (String)inputStreamProvider.getPath(), (int)localMedia.getWidth(), (int)localMedia.getHeight(), (String)localMedia.getMimeType(), (String)string))) : new File(string2);
            } else {
                boolean bl = Checker.SINGLE.needCompressToLocalMedia(this.mLeastCompressSize, string2);
                if (this.mCompressionPredicate.apply(string2) && bl) {
                    object = new Engine(object, inputStreamProvider, file, this.focusAlpha, this.compressQuality, this.isAutoRotating).compress();
                } else if (bl) {
                    object = new Engine(object, inputStreamProvider, file, this.focusAlpha, this.compressQuality, this.isAutoRotating).compress();
                } else if (SdkVersionUtils.checkedAndroid_Q()) {
                    object = localMedia.isCut() ? localMedia.getCutPath() : AndroidQTransformUtils.copyPathToAndroidQ((Context)object, (long)localMedia.getId(), (String)inputStreamProvider.getPath(), (int)localMedia.getWidth(), (int)localMedia.getHeight(), (String)localMedia.getMimeType(), (String)string);
                    if (TextUtils.isEmpty((CharSequence)object)) {
                        object = string2;
                    }
                    object = new File((String)object);
                } else {
                    object = new File(string2);
                }
            }
        } else if (string3.startsWith(".gif")) {
            if (SdkVersionUtils.checkedAndroid_Q()) {
                object = localMedia.isCut() ? localMedia.getCutPath() : AndroidQTransformUtils.copyPathToAndroidQ((Context)object, (long)localMedia.getId(), (String)inputStreamProvider.getPath(), (int)localMedia.getWidth(), (int)localMedia.getHeight(), (String)localMedia.getMimeType(), (String)string);
                if (TextUtils.isEmpty((CharSequence)object)) {
                    object = string2;
                }
                object = new File((String)object);
            } else {
                object = new File(string2);
            }
        } else if (Checker.SINGLE.needCompressToLocalMedia(this.mLeastCompressSize, string2)) {
            object = new Engine(object, inputStreamProvider, file, this.focusAlpha, this.compressQuality, this.isAutoRotating).compress();
        } else if (SdkVersionUtils.checkedAndroid_Q()) {
            object = localMedia.isCut() ? localMedia.getCutPath() : AndroidQTransformUtils.copyPathToAndroidQ((Context)object, (long)localMedia.getId(), (String)inputStreamProvider.getPath(), (int)localMedia.getWidth(), (int)localMedia.getHeight(), (String)localMedia.getMimeType(), (String)string);
            if (TextUtils.isEmpty((CharSequence)object)) {
                object = string2;
            }
            object = new File((String)object);
        } else {
            object = new File(string2);
        }
        return object;
    }

    private File get(InputStreamProvider inputStreamProvider, Context object) throws IOException {
        try {
            Engine engine = new Engine(object, inputStreamProvider, this.getImageCacheFile((Context)object, inputStreamProvider, Checker.SINGLE.extSuffix(inputStreamProvider.getMedia().getMimeType())), this.focusAlpha, this.compressQuality, this.isAutoRotating);
            object = engine.compress();
            return object;
        }
        finally {
            inputStreamProvider.close();
        }
    }

    private List<File> get(Context context) throws Exception {
        ArrayList<File> arrayList = new ArrayList<File>();
        Iterator<InputStreamProvider> iterator = this.mStreamProviders.iterator();
        while (iterator.hasNext()) {
            Object object = iterator.next();
            if (object.getMedia() == null) continue;
            boolean bl = object.getMedia().isCompressed();
            boolean bl2 = true;
            boolean bl3 = true;
            if (bl && !TextUtils.isEmpty((CharSequence)object.getMedia().getCompressPath())) {
                if (object.getMedia().isCut() || !new File(object.getMedia().getCompressPath()).exists()) {
                    bl3 = false;
                }
                object = bl3 ? new File(object.getMedia().getCompressPath()) : this.compress(context, (InputStreamProvider)object);
                arrayList.add((File)object);
            } else {
                bl3 = PictureMimeType.isHasHttp((String)object.getMedia().getPath()) && TextUtils.isEmpty((CharSequence)object.getMedia().getCutPath()) ? bl2 : false;
                bl = PictureMimeType.isHasVideo((String)object.getMedia().getMimeType());
                object = !bl3 && !bl ? this.compress(context, (InputStreamProvider)object) : new File(object.getMedia().getPath());
                arrayList.add((File)object);
            }
            iterator.remove();
        }
        return arrayList;
    }

    private static File getImageCacheDir(Context object) {
        if ((object = object.getExternalFilesDir(Environment.DIRECTORY_PICTURES)) != null) {
            if (((File)object).mkdirs()) return object;
            if (!((File)object).exists()) return null;
            if (((File)object).isDirectory()) return object;
            return null;
        }
        if (!Log.isLoggable((String)"Luban", (int)6)) return null;
        Log.e((String)"Luban", (String)"default disk cache dir is null");
        return null;
    }

    private File getImageCacheFile(Context object, InputStreamProvider object2, String string) {
        if (TextUtils.isEmpty((CharSequence)this.mTargetDir) && (object = Luban.getImageCacheDir(object)) != null) {
            this.mTargetDir = object.getAbsolutePath();
        }
        try {
            object = object2.getMedia();
            String string2 = StringUtils.getEncryptionValue((long)object.getId(), (int)object.getWidth(), (int)object.getHeight());
            object2 = new StringBuilder();
            ((StringBuilder)object2).append(this.mTargetDir);
            boolean bl = TextUtils.isEmpty((CharSequence)string2);
            if (!bl && !object.isCut()) {
                ((StringBuilder)object2).append("/IMG_CMP_");
                ((StringBuilder)object2).append(string2);
                object = string;
                if (TextUtils.isEmpty((CharSequence)string)) {
                    object = ".jpeg";
                }
                ((StringBuilder)object2).append((String)object);
                object = ((StringBuilder)object2).toString();
            } else {
                object = DateUtils.getCreateFileName((String)"IMG_CMP_");
                ((StringBuilder)object2).append("/");
                ((StringBuilder)object2).append((String)object);
                object = string;
                if (TextUtils.isEmpty((CharSequence)string)) {
                    object = ".jpeg";
                }
                ((StringBuilder)object2).append((String)object);
                object = ((StringBuilder)object2).toString();
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
            object = "";
        }
        return new File((String)object);
    }

    private File getImageCustomFile(Context object, String string) {
        if (TextUtils.isEmpty((CharSequence)this.mTargetDir)) {
            object = (object = Luban.getImageCacheDir((Context)object)) != null ? ((File)object).getAbsolutePath() : "";
            this.mTargetDir = object;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append(this.mTargetDir);
        ((StringBuilder)object).append("/");
        ((StringBuilder)object).append(string);
        return new File(((StringBuilder)object).toString());
    }

    private void launch(Context context) {
        List<InputStreamProvider> list = this.mStreamProviders;
        if (list != null && this.mPaths != null && (list.size() != 0 || this.mCompressListener == null)) {
            list = this.mStreamProviders.iterator();
            OnCompressListener onCompressListener = this.mCompressListener;
            if (onCompressListener != null) {
                onCompressListener.onStart();
            }
            PictureThreadUtils.executeBySingle((PictureThreadUtils.Task)new /* Unavailable Anonymous Inner Class!! */);
            return;
        }
        this.mCompressListener.onError((Throwable)new NullPointerException("image file cannot be null"));
    }

    public static Builder with(Context context) {
        return new Builder(context);
    }
}
