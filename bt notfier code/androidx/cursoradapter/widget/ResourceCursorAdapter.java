/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.database.Cursor
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  androidx.cursoradapter.widget.CursorAdapter
 */
package androidx.cursoradapter.widget;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.cursoradapter.widget.CursorAdapter;

public abstract class ResourceCursorAdapter
extends CursorAdapter {
    private int mDropDownLayout;
    private LayoutInflater mInflater;
    private int mLayout;

    @Deprecated
    public ResourceCursorAdapter(Context context, int n, Cursor cursor) {
        super(context, cursor);
        this.mDropDownLayout = n;
        this.mLayout = n;
        this.mInflater = (LayoutInflater)context.getSystemService("layout_inflater");
    }

    public ResourceCursorAdapter(Context context, int n, Cursor cursor, int n2) {
        super(context, cursor, n2);
        this.mDropDownLayout = n;
        this.mLayout = n;
        this.mInflater = (LayoutInflater)context.getSystemService("layout_inflater");
    }

    @Deprecated
    public ResourceCursorAdapter(Context context, int n, Cursor cursor, boolean bl) {
        super(context, cursor, bl);
        this.mDropDownLayout = n;
        this.mLayout = n;
        this.mInflater = (LayoutInflater)context.getSystemService("layout_inflater");
    }

    public View newDropDownView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.mInflater.inflate(this.mDropDownLayout, viewGroup, false);
    }

    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.mInflater.inflate(this.mLayout, viewGroup, false);
    }

    public void setDropDownViewResource(int n) {
        this.mDropDownLayout = n;
    }

    public void setViewResource(int n) {
        this.mLayout = n;
    }
}
