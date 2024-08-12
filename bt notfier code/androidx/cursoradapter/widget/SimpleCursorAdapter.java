/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.database.Cursor
 *  android.net.Uri
 *  android.view.View
 *  android.widget.ImageView
 *  android.widget.TextView
 *  androidx.cursoradapter.widget.ResourceCursorAdapter
 *  androidx.cursoradapter.widget.SimpleCursorAdapter$CursorToStringConverter
 *  androidx.cursoradapter.widget.SimpleCursorAdapter$ViewBinder
 */
package androidx.cursoradapter.widget;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cursoradapter.widget.ResourceCursorAdapter;
import androidx.cursoradapter.widget.SimpleCursorAdapter;

public class SimpleCursorAdapter
extends ResourceCursorAdapter {
    private CursorToStringConverter mCursorToStringConverter;
    protected int[] mFrom;
    String[] mOriginalFrom;
    private int mStringConversionColumn = -1;
    protected int[] mTo;
    private ViewBinder mViewBinder;

    @Deprecated
    public SimpleCursorAdapter(Context context, int n, Cursor cursor, String[] stringArray, int[] nArray) {
        super(context, n, cursor);
        this.mTo = nArray;
        this.mOriginalFrom = stringArray;
        this.findColumns(cursor, stringArray);
    }

    public SimpleCursorAdapter(Context context, int n, Cursor cursor, String[] stringArray, int[] nArray, int n2) {
        super(context, n, cursor, n2);
        this.mTo = nArray;
        this.mOriginalFrom = stringArray;
        this.findColumns(cursor, stringArray);
    }

    private void findColumns(Cursor cursor, String[] stringArray) {
        if (cursor == null) {
            this.mFrom = null;
            return;
        }
        int n = stringArray.length;
        int[] nArray = this.mFrom;
        if (nArray == null || nArray.length != n) {
            this.mFrom = new int[n];
        }
        int n2 = 0;
        while (n2 < n) {
            this.mFrom[n2] = cursor.getColumnIndexOrThrow(stringArray[n2]);
            ++n2;
        }
    }

    public void bindView(View object, Context object2, Cursor cursor) {
        ViewBinder viewBinder = this.mViewBinder;
        int[] nArray = this.mTo;
        int n = nArray.length;
        int[] nArray2 = this.mFrom;
        int n2 = 0;
        while (n2 < n) {
            boolean bl;
            View view = object.findViewById(nArray[n2]);
            if (view != null && !(bl = viewBinder != null ? viewBinder.setViewValue(view, cursor, nArray2[n2]) : false)) {
                String string = cursor.getString(nArray2[n2]);
                object2 = string;
                if (string == null) {
                    object2 = "";
                }
                if (view instanceof TextView) {
                    this.setViewText((TextView)view, (String)object2);
                } else {
                    if (!(view instanceof ImageView)) {
                        object = new StringBuilder();
                        ((StringBuilder)object).append(view.getClass().getName());
                        ((StringBuilder)object).append(" is not a ");
                        ((StringBuilder)object).append(" view that can be bounds by this SimpleCursorAdapter");
                        throw new IllegalStateException(((StringBuilder)object).toString());
                    }
                    this.setViewImage((ImageView)view, (String)object2);
                }
            }
            ++n2;
        }
    }

    public void changeCursorAndColumns(Cursor cursor, String[] stringArray, int[] nArray) {
        this.mOriginalFrom = stringArray;
        this.mTo = nArray;
        this.findColumns(cursor, stringArray);
        super.changeCursor(cursor);
    }

    public CharSequence convertToString(Cursor cursor) {
        CursorToStringConverter cursorToStringConverter = this.mCursorToStringConverter;
        if (cursorToStringConverter != null) {
            return cursorToStringConverter.convertToString(cursor);
        }
        int n = this.mStringConversionColumn;
        if (n <= -1) return super.convertToString(cursor);
        return cursor.getString(n);
    }

    public CursorToStringConverter getCursorToStringConverter() {
        return this.mCursorToStringConverter;
    }

    public int getStringConversionColumn() {
        return this.mStringConversionColumn;
    }

    public ViewBinder getViewBinder() {
        return this.mViewBinder;
    }

    public void setCursorToStringConverter(CursorToStringConverter cursorToStringConverter) {
        this.mCursorToStringConverter = cursorToStringConverter;
    }

    public void setStringConversionColumn(int n) {
        this.mStringConversionColumn = n;
    }

    public void setViewBinder(ViewBinder viewBinder) {
        this.mViewBinder = viewBinder;
    }

    public void setViewImage(ImageView imageView, String string) {
        try {
            imageView.setImageResource(Integer.parseInt(string));
        }
        catch (NumberFormatException numberFormatException) {
            imageView.setImageURI(Uri.parse((String)string));
        }
    }

    public void setViewText(TextView textView, String string) {
        textView.setText((CharSequence)string);
    }

    public Cursor swapCursor(Cursor cursor) {
        this.findColumns(cursor, this.mOriginalFrom);
        return super.swapCursor(cursor);
    }
}
