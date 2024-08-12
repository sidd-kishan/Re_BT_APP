/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  androidx.appcompat.app.AppCompatViewInflater
 *  androidx.appcompat.widget.AppCompatButton
 *  com.google.android.material.button.MaterialButton
 */
package com.google.android.material.theme;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.app.AppCompatViewInflater;
import androidx.appcompat.widget.AppCompatButton;
import com.google.android.material.button.MaterialButton;

public class MaterialComponentsViewInflater
extends AppCompatViewInflater {
    protected AppCompatButton createButton(Context context, AttributeSet attributeSet) {
        return new MaterialButton(context, attributeSet);
    }
}
