/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources$NotFoundException
 *  android.util.Log
 */
package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;

public class ViewUtils {
    private ViewUtils() {
    }

    public static String getXmlAttributeString(String charSequence, String string, Context object, AttributeSet object2, boolean bl, boolean bl2, String string2) {
        charSequence = object2 == null ? null : object2.getAttributeValue((String)charSequence, string);
        object2 = charSequence;
        if (charSequence != null) {
            object2 = charSequence;
            if (charSequence.startsWith("@string/")) {
                object2 = charSequence;
                if (bl) {
                    String string3 = charSequence.substring(8);
                    String string4 = object.getPackageName();
                    object2 = new TypedValue();
                    try {
                        object = object.getResources();
                        int n = String.valueOf(string4).length();
                        int n2 = String.valueOf(string3).length();
                        StringBuilder stringBuilder = new StringBuilder(n + 8 + n2);
                        stringBuilder.append(string4);
                        stringBuilder.append(":string/");
                        stringBuilder.append(string3);
                        object.getValue(stringBuilder.toString(), (TypedValue)object2, true);
                    }
                    catch (Resources.NotFoundException notFoundException) {
                        object = new StringBuilder(String.valueOf(string).length() + 30 + charSequence.length());
                        ((StringBuilder)object).append("Could not find resource for ");
                        ((StringBuilder)object).append(string);
                        ((StringBuilder)object).append(": ");
                        ((StringBuilder)object).append((String)charSequence);
                        Log.w((String)string2, (String)((StringBuilder)object).toString());
                    }
                    if (((TypedValue)object2).string != null) {
                        object2 = ((TypedValue)object2).string.toString();
                    } else {
                        object = String.valueOf(object2);
                        object2 = new StringBuilder(String.valueOf(string).length() + 28 + String.valueOf(object).length());
                        ((StringBuilder)object2).append("Resource ");
                        ((StringBuilder)object2).append(string);
                        ((StringBuilder)object2).append(" was not a string: ");
                        ((StringBuilder)object2).append((String)object);
                        Log.w((String)string2, (String)((StringBuilder)object2).toString());
                        object2 = charSequence;
                    }
                }
            }
        }
        if (!bl2) return object2;
        if (object2 != null) return object2;
        charSequence = new StringBuilder(String.valueOf(string).length() + 33);
        ((StringBuilder)charSequence).append("Required XML attribute \"");
        ((StringBuilder)charSequence).append(string);
        ((StringBuilder)charSequence).append("\" missing");
        Log.w((String)string2, (String)((StringBuilder)charSequence).toString());
        return object2;
    }
}
