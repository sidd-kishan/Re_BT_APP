/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.SpannableString
 *  android.text.style.RelativeSizeSpan
 *  android.widget.TextView
 *  com.luck.picture.lib.R$string
 *  com.luck.picture.lib.config.PictureMimeType
 *  com.luck.picture.lib.tools.DateUtils
 *  com.luck.picture.lib.tools.ValueOf
 */
package com.luck.picture.lib.tools;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.RelativeSizeSpan;
import android.widget.TextView;
import com.luck.picture.lib.R;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.tools.DateUtils;
import com.luck.picture.lib.tools.ValueOf;
import java.util.regex.Pattern;

public class StringUtils {
    public static String getEncryptionValue(long l, int n, int n2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(l);
        stringBuilder.append("_");
        stringBuilder.append(n);
        stringBuilder.append(n2);
        return stringBuilder.toString();
    }

    public static String getMsg(Context context, String string2, int n) {
        if (PictureMimeType.isHasVideo((String)string2)) {
            return context.getString(R.string.picture_message_video_max_num, new Object[]{n});
        }
        if (!PictureMimeType.isHasAudio((String)string2)) return context.getString(R.string.picture_message_max_num, new Object[]{n});
        return context.getString(R.string.picture_message_audio_max_num, new Object[]{n});
    }

    public static String rename(String charSequence) {
        String string2 = ((String)charSequence).substring(0, ((String)charSequence).lastIndexOf("."));
        String string3 = ((String)charSequence).substring(((String)charSequence).lastIndexOf("."));
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append(string2);
        ((StringBuilder)charSequence).append("_");
        ((StringBuilder)charSequence).append(DateUtils.getCreateFileName());
        ((StringBuilder)charSequence).append(string3);
        return ((StringBuilder)charSequence).toString();
    }

    public static String renameSuffix(String string2, String string3) {
        string2 = string2.substring(0, string2.lastIndexOf("."));
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        stringBuilder.append(string3);
        return stringBuilder.toString();
    }

    public static int stringToInt(String string2) {
        int n = Pattern.compile("^[-\\+]?[\\d]+$").matcher(string2).matches() ? ValueOf.toInt((Object)string2) : 0;
        return n;
    }

    public static void tempTextFont(TextView textView, int n) {
        String string2 = textView.getText().toString().trim();
        String string3 = n == PictureMimeType.ofAudio() ? textView.getContext().getString(R.string.picture_empty_audio_title) : textView.getContext().getString(R.string.picture_empty_title);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string3);
        stringBuilder.append(string2);
        string2 = stringBuilder.toString();
        stringBuilder = new SpannableString((CharSequence)string2);
        stringBuilder.setSpan(new RelativeSizeSpan(0.8f), string3.length(), string2.length(), 33);
        textView.setText((CharSequence)stringBuilder);
    }
}
