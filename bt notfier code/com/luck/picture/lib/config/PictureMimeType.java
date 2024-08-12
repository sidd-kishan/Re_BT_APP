/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.net.Uri
 *  android.text.TextUtils
 *  android.webkit.MimeTypeMap
 *  com.luck.picture.lib.R$string
 */
package com.luck.picture.lib.config;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.luck.picture.lib.R;
import java.io.File;
import java.io.Serializable;

public final class PictureMimeType {
    public static final String AVI_Q = "video/avi";
    public static final String CAMERA = "Camera";
    public static final String DCIM = "DCIM/Camera";
    public static final String JPEG = ".jpeg";
    public static final String JPEG_Q = "image/jpeg";
    private static final String MIME_TYPE_3GP = "video/3gp";
    public static final String MIME_TYPE_AUDIO = "audio/mpeg";
    public static final String MIME_TYPE_AUDIO_AMR = "audio/amr";
    private static final String MIME_TYPE_AVI = "video/avi";
    private static final String MIME_TYPE_BMP = "image/bmp";
    private static final String MIME_TYPE_GIF = "image/gif";
    public static final String MIME_TYPE_IMAGE = "image/jpeg";
    public static final String MIME_TYPE_JPEG = "image/jpeg";
    private static final String MIME_TYPE_JPG = "image/jpg";
    private static final String MIME_TYPE_MP4 = "video/mp4";
    private static final String MIME_TYPE_MPEG = "video/mpeg";
    private static final String MIME_TYPE_PNG = "image/png";
    public static final String MIME_TYPE_PREFIX_AUDIO = "audio";
    public static final String MIME_TYPE_PREFIX_IMAGE = "image";
    public static final String MIME_TYPE_PREFIX_VIDEO = "video";
    public static final String MIME_TYPE_VIDEO = "video/mp4";
    private static final String MIME_TYPE_WEBP = "image/webp";
    public static final String MP4 = ".mp4";
    public static final String MP4_Q = "video/mp4";
    public static final String PNG = ".png";
    public static final String PNG_Q = "image/png";

    public static String getImageMimeType(String string) {
        try {
            if (TextUtils.isEmpty((CharSequence)string)) return "image/jpeg";
            Serializable serializable = new File(string);
            int n = (string = ((File)serializable).getName()).lastIndexOf(".");
            string = n == -1 ? "jpeg" : string.substring(n + 1);
            serializable = new StringBuilder();
            ((StringBuilder)serializable).append("image/");
            ((StringBuilder)serializable).append(string);
            string = ((StringBuilder)serializable).toString();
            return string;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return "image/jpeg";
        }
    }

    public static String getLastImgSuffix(String string) {
        try {
            int n = string.lastIndexOf("/") + 1;
            if (n <= 0) return PNG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(".");
            stringBuilder.append(string.substring(n));
            string = stringBuilder.toString();
            return string;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return PNG;
        }
    }

    public static String getLastImgType(String string) {
        int n;
        try {
            n = string.lastIndexOf(".");
            if (n <= 0) return PNG;
            string = string.substring(n);
            n = -1;
            switch (string.hashCode()) {
                default: {
                    break;
                }
                case 46127306: {
                    if (!string.equals(".webp")) break;
                    n = 8;
                    break;
                }
                case 45750678: {
                    if (!string.equals(JPEG)) break;
                    n = 3;
                    break;
                }
                case 45142218: {
                    if (!string.equals(".WEBP")) break;
                    n = 5;
                    break;
                }
                case 44765590: {
                    if (!string.equals(".JPEG")) break;
                    n = 4;
                    break;
                }
                case 1481531: {
                    if (!string.equals(PNG)) break;
                    n = 0;
                    break;
                }
                case 1475827: {
                    if (!string.equals(".jpg")) break;
                    n = 2;
                    break;
                }
                case 1472726: {
                    if (!string.equals(".gif")) break;
                    n = 9;
                    break;
                }
                case 1468055: {
                    if (!string.equals(".bmp")) break;
                    n = 6;
                    break;
                }
                case 1449755: {
                    if (!string.equals(".PNG")) break;
                    n = 1;
                    break;
                }
                case 1440950: {
                    if (!string.equals(".GIF")) break;
                    n = 10;
                    break;
                }
                case 1436279: {
                    boolean bl = string.equals(".BMP");
                    if (!bl) break;
                    n = 7;
                    break;
                }
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return PNG;
        }
        switch (n) {
            default: {
                break;
            }
            case 0: 
            case 1: 
            case 2: 
            case 3: 
            case 4: 
            case 5: 
            case 6: 
            case 7: 
            case 8: 
            case 9: 
            case 10: {
                return string;
            }
        }
        return PNG;
    }

    public static int getMimeType(String string) {
        if (TextUtils.isEmpty((CharSequence)string)) {
            return 1;
        }
        if (string.startsWith(MIME_TYPE_PREFIX_VIDEO)) {
            return 2;
        }
        if (!string.startsWith(MIME_TYPE_PREFIX_AUDIO)) return 1;
        return 3;
    }

    public static String getMimeType(int n) {
        if (n == 2) return "video/mp4";
        if (n == 3) return MIME_TYPE_AUDIO_AMR;
        return "image/jpeg";
    }

    public static String getMimeTypeFromMediaContentUri(Context object, Uri object2) {
        if (object2.getScheme().equals("content")) {
            object = object.getContentResolver().getType(object2);
        } else {
            object = MimeTypeMap.getFileExtensionFromUrl((String)object2.toString());
            object = MimeTypeMap.getSingleton().getMimeTypeFromExtension(((String)object).toLowerCase());
        }
        object2 = object;
        if (!TextUtils.isEmpty((CharSequence)object)) return object2;
        object2 = "image/jpeg";
        return object2;
    }

    public static boolean isContent(String string) {
        if (!TextUtils.isEmpty((CharSequence)string)) return string.startsWith("content://");
        return false;
    }

    public static boolean isGif(String string) {
        boolean bl = string != null && (string.equals(MIME_TYPE_GIF) || string.equals("image/GIF"));
        return bl;
    }

    public static boolean isGifForSuffix(String string) {
        boolean bl = TextUtils.isEmpty((CharSequence)string);
        boolean bl2 = false;
        if (bl) {
            return false;
        }
        if (!string.startsWith(".gif")) {
            if (!string.startsWith(".GIF")) return bl2;
        }
        bl2 = true;
        return bl2;
    }

    public static boolean isHasAudio(String string) {
        boolean bl = string != null && string.startsWith(MIME_TYPE_PREFIX_AUDIO);
        return bl;
    }

    public static boolean isHasHttp(String string) {
        boolean bl = TextUtils.isEmpty((CharSequence)string);
        boolean bl2 = false;
        if (bl) {
            return false;
        }
        if (!(string.startsWith("http") || string.startsWith("https") || string.startsWith("/http"))) {
            if (!string.startsWith("/https")) return bl2;
        }
        bl2 = true;
        return bl2;
    }

    public static boolean isHasImage(String string) {
        boolean bl = string != null && string.startsWith(MIME_TYPE_PREFIX_IMAGE);
        return bl;
    }

    public static boolean isHasVideo(String string) {
        boolean bl = string != null && string.startsWith(MIME_TYPE_PREFIX_VIDEO);
        return bl;
    }

    public static boolean isJPEG(String string) {
        boolean bl = TextUtils.isEmpty((CharSequence)string);
        boolean bl2 = false;
        if (bl) {
            return false;
        }
        if (!string.startsWith("image/jpeg")) {
            if (!string.startsWith(MIME_TYPE_JPG)) return bl2;
        }
        bl2 = true;
        return bl2;
    }

    public static boolean isJPG(String string) {
        if (!TextUtils.isEmpty((CharSequence)string)) return string.startsWith(MIME_TYPE_JPG);
        return false;
    }

    public static boolean isMimeTypeSame(String string, String string2) {
        boolean bl = PictureMimeType.getMimeType(string) == PictureMimeType.getMimeType(string2);
        return bl;
    }

    public static boolean isSuffixOfImage(String string) {
        boolean bl = !TextUtils.isEmpty((CharSequence)string) && string.endsWith(".PNG") || string.endsWith(PNG) || string.endsWith(JPEG) || string.endsWith(".gif") || string.endsWith(".GIF") || string.endsWith(".jpg") || string.endsWith(".webp") || string.endsWith(".WEBP") || string.endsWith(".JPEG") || string.endsWith(".bmp");
        return bl;
    }

    public static boolean isUrlHasVideo(String string) {
        return string.endsWith(MP4);
    }

    public static String of3GP() {
        return MIME_TYPE_3GP;
    }

    public static String ofAVI() {
        return "video/avi";
    }

    public static int ofAll() {
        return 0;
    }

    @Deprecated
    public static int ofAudio() {
        return 3;
    }

    public static String ofBMP() {
        return MIME_TYPE_BMP;
    }

    public static String ofGIF() {
        return MIME_TYPE_GIF;
    }

    public static int ofImage() {
        return 1;
    }

    public static String ofJPEG() {
        return "image/jpeg";
    }

    public static String ofMP4() {
        return "video/mp4";
    }

    public static String ofMPEG() {
        return MIME_TYPE_MPEG;
    }

    public static String ofPNG() {
        return "image/png";
    }

    public static int ofVideo() {
        return 2;
    }

    public static String ofWEBP() {
        return MIME_TYPE_WEBP;
    }

    public static String s(Context context, String string2) {
        context = context.getApplicationContext();
        if (PictureMimeType.isHasVideo(string2)) {
            return context.getString(R.string.picture_video_error);
        }
        if (!PictureMimeType.isHasAudio(string2)) return context.getString(R.string.picture_error);
        return context.getString(R.string.picture_audio_error);
    }
}
