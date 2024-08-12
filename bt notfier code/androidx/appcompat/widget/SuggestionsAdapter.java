/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.SearchableInfo
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.pm.ActivityInfo
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.content.res.ColorStateList
 *  android.content.res.Resources
 *  android.content.res.Resources$NotFoundException
 *  android.database.Cursor
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Drawable$ConstantState
 *  android.net.Uri
 *  android.net.Uri$Builder
 *  android.text.SpannableString
 *  android.text.TextUtils
 *  android.text.style.TextAppearanceSpan
 *  android.util.Log
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.widget.ImageView
 *  android.widget.TextView
 *  androidx.appcompat.R$attr
 *  androidx.appcompat.R$id
 *  androidx.appcompat.widget.SearchView
 *  androidx.appcompat.widget.SuggestionsAdapter$ChildViewCache
 *  androidx.core.content.ContextCompat
 *  androidx.cursoradapter.widget.ResourceCursorAdapter
 */
package androidx.appcompat.widget;

import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.SuggestionsAdapter;
import androidx.core.content.ContextCompat;
import androidx.cursoradapter.widget.ResourceCursorAdapter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.WeakHashMap;

class SuggestionsAdapter
extends ResourceCursorAdapter
implements View.OnClickListener {
    private static final boolean DBG = false;
    static final int INVALID_INDEX = -1;
    private static final String LOG_TAG = "SuggestionsAdapter";
    private static final int QUERY_LIMIT = 50;
    static final int REFINE_ALL = 2;
    static final int REFINE_BY_ENTRY = 1;
    static final int REFINE_NONE = 0;
    private boolean mClosed = false;
    private final int mCommitIconResId;
    private int mFlagsCol = -1;
    private int mIconName1Col = -1;
    private int mIconName2Col = -1;
    private final WeakHashMap<String, Drawable.ConstantState> mOutsideDrawablesCache;
    private final Context mProviderContext;
    private int mQueryRefinement = 1;
    private final SearchView mSearchView;
    private final SearchableInfo mSearchable;
    private int mText1Col = -1;
    private int mText2Col = -1;
    private int mText2UrlCol = -1;
    private ColorStateList mUrlColor;

    public SuggestionsAdapter(Context context, SearchView searchView, SearchableInfo searchableInfo, WeakHashMap<String, Drawable.ConstantState> weakHashMap) {
        super(context, searchView.getSuggestionRowLayout(), null, true);
        this.mSearchView = searchView;
        this.mSearchable = searchableInfo;
        this.mCommitIconResId = searchView.getSuggestionCommitIconResId();
        this.mProviderContext = context;
        this.mOutsideDrawablesCache = weakHashMap;
    }

    private Drawable checkIconCache(String string) {
        if ((string = this.mOutsideDrawablesCache.get(string)) != null) return string.newDrawable();
        return null;
    }

    private CharSequence formatUrl(CharSequence charSequence) {
        TypedValue typedValue;
        if (this.mUrlColor == null) {
            typedValue = new TypedValue();
            this.mProviderContext.getTheme().resolveAttribute(R.attr.textColorSearchUrl, typedValue, true);
            this.mUrlColor = this.mProviderContext.getResources().getColorStateList(typedValue.resourceId);
        }
        typedValue = new SpannableString(charSequence);
        typedValue.setSpan(new TextAppearanceSpan(null, 0, 0, this.mUrlColor, null), 0, charSequence.length(), 33);
        return typedValue;
    }

    private Drawable getActivityIcon(ComponentName componentName) {
        ActivityInfo activityInfo;
        Object object = this.mProviderContext.getPackageManager();
        try {
            activityInfo = object.getActivityInfo(componentName, 128);
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            Log.w((String)LOG_TAG, (String)nameNotFoundException.toString());
            return null;
        }
        int n = activityInfo.getIconResource();
        if (n == 0) {
            return null;
        }
        if ((object = object.getDrawable(componentName.getPackageName(), n, activityInfo.applicationInfo)) != null) return object;
        object = new StringBuilder();
        ((StringBuilder)object).append("Invalid icon resource ");
        ((StringBuilder)object).append(n);
        ((StringBuilder)object).append(" for ");
        ((StringBuilder)object).append(componentName.flattenToShortString());
        Log.w((String)LOG_TAG, (String)((StringBuilder)object).toString());
        return null;
    }

    private Drawable getActivityIconWithCache(ComponentName object) {
        String string = object.flattenToShortString();
        boolean bl = this.mOutsideDrawablesCache.containsKey(string);
        Object var4_4 = null;
        Drawable drawable = null;
        if (bl) {
            object = this.mOutsideDrawablesCache.get(string);
            object = object == null ? drawable : object.newDrawable(this.mProviderContext.getResources());
            return object;
        }
        drawable = this.getActivityIcon((ComponentName)object);
        object = drawable == null ? var4_4 : drawable.getConstantState();
        this.mOutsideDrawablesCache.put(string, (Drawable.ConstantState)object);
        return drawable;
    }

    public static String getColumnString(Cursor cursor, String string) {
        return SuggestionsAdapter.getStringOrNull(cursor, cursor.getColumnIndex(string));
    }

    private Drawable getDefaultIcon1() {
        Drawable drawable = this.getActivityIconWithCache(this.mSearchable.getSearchActivity());
        if (drawable == null) return this.mProviderContext.getPackageManager().getDefaultActivityIcon();
        return drawable;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     */
    private Drawable getDrawable(Uri var1_1) {
        try {
            var2_2 = "android.resource".equals(var1_1.getScheme());
            if (var2_2) {
                try {
                    var3_3 = this.getDrawableFromResourceUri(var1_1);
                    return var3_3;
                }
                catch (Resources.NotFoundException var3_4) {
                    var3_5 = new StringBuilder();
                    var3_5.append("Resource does not exist: ");
                    var3_5.append(var1_1);
                    var4_10 = new FileNotFoundException(var3_5.toString());
                    throw var4_10;
                }
            }
            var4_11 = this.mProviderContext.getContentResolver().openInputStream(var1_1);
            if (var4_11 != null) {
            }
            ** GOTO lbl49
        }
        catch (FileNotFoundException var3_9) {
            var4_11 = new StringBuilder();
            var4_11.append("Icon not found: ");
            var4_11.append(var1_1);
            var4_11.append(", ");
            var4_11.append(var3_9.getMessage());
            Log.w((String)"SuggestionsAdapter", (String)var4_11.toString());
            return null;
        }
        try {
            var3_6 = Drawable.createFromStream((InputStream)var4_11, null);
        }
        finally {
            try {
                var4_11.close();
            }
            catch (IOException var4_12) {
                var5_14 = new StringBuilder();
                var5_14.append("Error closing icon stream for ");
                var5_14.append(var1_1);
                Log.e((String)"SuggestionsAdapter", (String)var5_14.toString(), (Throwable)var4_12);
            }
        }
        {
            return var3_6;
lbl49:
            // 1 sources

            var4_11 = new StringBuilder();
            var4_11.append("Failed to open ");
            var4_11.append(var1_1);
            var3_8 = new FileNotFoundException(var4_11.toString());
            throw var3_8;
        }
    }

    private Drawable getDrawableFromResourceValue(String string) {
        StringBuilder stringBuilder;
        CharSequence charSequence = stringBuilder = null;
        if (string == null) return charSequence;
        charSequence = stringBuilder;
        if (string.isEmpty()) return charSequence;
        if ("0".equals(string)) {
            charSequence = stringBuilder;
        } else {
            try {
                int n = Integer.parseInt(string);
                charSequence = new StringBuilder();
                charSequence.append("android.resource://");
                charSequence.append(this.mProviderContext.getPackageName());
                charSequence.append("/");
                charSequence.append(n);
                charSequence = charSequence.toString();
                stringBuilder = this.checkIconCache((String)charSequence);
                if (stringBuilder != null) {
                    return stringBuilder;
                }
                stringBuilder = ContextCompat.getDrawable((Context)this.mProviderContext, (int)n);
                this.storeInIconCache((String)charSequence, (Drawable)stringBuilder);
                return stringBuilder;
            }
            catch (Resources.NotFoundException notFoundException) {
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("Icon resource not found: ");
                stringBuilder2.append(string);
                Log.w((String)LOG_TAG, (String)stringBuilder2.toString());
                return null;
            }
            catch (NumberFormatException numberFormatException) {
                charSequence = this.checkIconCache(string);
                if (charSequence != null) {
                    return charSequence;
                }
                charSequence = this.getDrawable(Uri.parse((String)string));
                this.storeInIconCache(string, (Drawable)charSequence);
            }
        }
        return charSequence;
    }

    private Drawable getIcon1(Cursor cursor) {
        int n = this.mIconName1Col;
        if (n == -1) {
            return null;
        }
        if ((cursor = this.getDrawableFromResourceValue(cursor.getString(n))) == null) return this.getDefaultIcon1();
        return cursor;
    }

    private Drawable getIcon2(Cursor cursor) {
        int n = this.mIconName2Col;
        if (n != -1) return this.getDrawableFromResourceValue(cursor.getString(n));
        return null;
    }

    private static String getStringOrNull(Cursor object, int n) {
        if (n == -1) {
            return null;
        }
        try {
            object = object.getString(n);
            return object;
        }
        catch (Exception exception) {
            Log.e((String)LOG_TAG, (String)"unexpected error retrieving valid column from cursor, did the remote process die?", (Throwable)exception);
            return null;
        }
    }

    private void setViewDrawable(ImageView imageView, Drawable drawable, int n) {
        imageView.setImageDrawable(drawable);
        if (drawable == null) {
            imageView.setVisibility(n);
        } else {
            imageView.setVisibility(0);
            drawable.setVisible(false, false);
            drawable.setVisible(true, false);
        }
    }

    private void setViewText(TextView textView, CharSequence charSequence) {
        textView.setText(charSequence);
        if (TextUtils.isEmpty((CharSequence)charSequence)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
        }
    }

    private void storeInIconCache(String string, Drawable drawable) {
        if (drawable == null) return;
        this.mOutsideDrawablesCache.put(string, drawable.getConstantState());
    }

    private void updateSpinnerState(Cursor object) {
        object = object != null ? object.getExtras() : null;
        if (object == null) return;
        if (!object.getBoolean("in_progress")) return;
    }

    public void bindView(View object, Context context, Cursor cursor) {
        int n;
        context = (ChildViewCache)object.getTag();
        int n2 = this.mFlagsCol;
        n2 = n2 != -1 ? cursor.getInt(n2) : 0;
        if (context.mText1 != null) {
            object = SuggestionsAdapter.getStringOrNull(cursor, this.mText1Col);
            this.setViewText(context.mText1, (CharSequence)object);
        }
        if (context.mText2 != null) {
            object = SuggestionsAdapter.getStringOrNull(cursor, this.mText2UrlCol);
            object = object != null ? this.formatUrl((CharSequence)object) : SuggestionsAdapter.getStringOrNull(cursor, this.mText2Col);
            if (TextUtils.isEmpty((CharSequence)object)) {
                if (context.mText1 != null) {
                    context.mText1.setSingleLine(false);
                    context.mText1.setMaxLines(2);
                }
            } else if (context.mText1 != null) {
                context.mText1.setSingleLine(true);
                context.mText1.setMaxLines(1);
            }
            this.setViewText(context.mText2, (CharSequence)object);
        }
        if (context.mIcon1 != null) {
            this.setViewDrawable(context.mIcon1, this.getIcon1(cursor), 4);
        }
        if (context.mIcon2 != null) {
            this.setViewDrawable(context.mIcon2, this.getIcon2(cursor), 8);
        }
        if ((n = this.mQueryRefinement) != 2 && (n != 1 || (n2 & 1) == 0)) {
            context.mIconRefine.setVisibility(8);
        } else {
            context.mIconRefine.setVisibility(0);
            context.mIconRefine.setTag((Object)context.mText1.getText());
            context.mIconRefine.setOnClickListener((View.OnClickListener)this);
        }
    }

    public void changeCursor(Cursor cursor) {
        if (this.mClosed) {
            Log.w((String)LOG_TAG, (String)"Tried to change cursor after adapter was closed.");
            if (cursor == null) return;
            cursor.close();
            return;
        }
        try {
            super.changeCursor(cursor);
            if (cursor == null) return;
            this.mText1Col = cursor.getColumnIndex("suggest_text_1");
            this.mText2Col = cursor.getColumnIndex("suggest_text_2");
            this.mText2UrlCol = cursor.getColumnIndex("suggest_text_2_url");
            this.mIconName1Col = cursor.getColumnIndex("suggest_icon_1");
            this.mIconName2Col = cursor.getColumnIndex("suggest_icon_2");
            this.mFlagsCol = cursor.getColumnIndex("suggest_flags");
        }
        catch (Exception exception) {
            Log.e((String)LOG_TAG, (String)"error changing cursor and caching columns", (Throwable)exception);
        }
    }

    public void close() {
        this.changeCursor(null);
        this.mClosed = true;
    }

    public CharSequence convertToString(Cursor object) {
        if (object == null) {
            return null;
        }
        String string = SuggestionsAdapter.getColumnString(object, "suggest_intent_query");
        if (string != null) {
            return string;
        }
        if (this.mSearchable.shouldRewriteQueryFromData() && (string = SuggestionsAdapter.getColumnString(object, "suggest_intent_data")) != null) {
            return string;
        }
        if (!this.mSearchable.shouldRewriteQueryFromText()) return null;
        if ((object = SuggestionsAdapter.getColumnString(object, "suggest_text_1")) == null) return null;
        return object;
    }

    Drawable getDrawableFromResourceUri(Uri uri) throws FileNotFoundException {
        Resources resources;
        String string = uri.getAuthority();
        if (TextUtils.isEmpty((CharSequence)string)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("No authority: ");
            stringBuilder.append(uri);
            throw new FileNotFoundException(stringBuilder.toString());
        }
        try {
            resources = this.mProviderContext.getPackageManager().getResourcesForApplication(string);
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("No package found for authority: ");
            stringBuilder.append(uri);
            throw new FileNotFoundException(stringBuilder.toString());
        }
        Object object = uri.getPathSegments();
        if (object == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append("No path: ");
            ((StringBuilder)object).append(uri);
            throw new FileNotFoundException(((StringBuilder)object).toString());
        }
        int n = object.size();
        if (n == 1) {
            try {
                n = Integer.parseInt((String)object.get(0));
            }
            catch (NumberFormatException numberFormatException) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Single path segment is not a resource ID: ");
                stringBuilder.append(uri);
                throw new FileNotFoundException(stringBuilder.toString());
            }
        } else {
            if (n != 2) {
                object = new StringBuilder();
                ((StringBuilder)object).append("More than two path segments: ");
                ((StringBuilder)object).append(uri);
                throw new FileNotFoundException(((StringBuilder)object).toString());
            }
            n = resources.getIdentifier((String)object.get(1), (String)object.get(0), string);
        }
        if (n != 0) {
            return resources.getDrawable(n);
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("No resource found for: ");
        ((StringBuilder)object).append(uri);
        throw new FileNotFoundException(((StringBuilder)object).toString());
    }

    public View getDropDownView(int n, View view, ViewGroup viewGroup) {
        try {
            view = super.getDropDownView(n, view, viewGroup);
            return view;
        }
        catch (RuntimeException runtimeException) {
            Log.w((String)LOG_TAG, (String)"Search suggestions cursor threw exception.", (Throwable)runtimeException);
            viewGroup = this.newDropDownView(this.mProviderContext, this.getCursor(), viewGroup);
            if (viewGroup == null) return viewGroup;
            ((ChildViewCache)viewGroup.getTag()).mText1.setText((CharSequence)runtimeException.toString());
            return viewGroup;
        }
    }

    public int getQueryRefinement() {
        return this.mQueryRefinement;
    }

    Cursor getSearchManagerSuggestions(SearchableInfo stringArray, String string, int n) {
        Object var4_4 = null;
        if (stringArray == null) {
            return null;
        }
        String string2 = stringArray.getSuggestAuthority();
        if (string2 == null) {
            return null;
        }
        string2 = new Uri.Builder().scheme("content").authority(string2).query("").fragment("");
        String string3 = stringArray.getSuggestPath();
        if (string3 != null) {
            string2.appendEncodedPath(string3);
        }
        string2.appendPath("search_suggest_query");
        string3 = stringArray.getSuggestSelection();
        if (string3 != null) {
            stringArray = new String[]{string};
        } else {
            string2.appendPath(string);
            stringArray = var4_4;
        }
        if (n > 0) {
            string2.appendQueryParameter("limit", String.valueOf(n));
        }
        string = string2.build();
        return this.mProviderContext.getContentResolver().query((Uri)string, null, string3, stringArray, null);
    }

    public View getView(int n, View view, ViewGroup viewGroup) {
        try {
            view = super.getView(n, view, viewGroup);
            return view;
        }
        catch (RuntimeException runtimeException) {
            Log.w((String)LOG_TAG, (String)"Search suggestions cursor threw exception.", (Throwable)runtimeException);
            viewGroup = this.newView(this.mProviderContext, this.getCursor(), viewGroup);
            if (viewGroup == null) return viewGroup;
            ((ChildViewCache)viewGroup.getTag()).mText1.setText((CharSequence)runtimeException.toString());
            return viewGroup;
        }
    }

    public boolean hasStableIds() {
        return false;
    }

    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        context = super.newView(context, cursor, viewGroup);
        context.setTag((Object)new ChildViewCache((View)context));
        ((ImageView)context.findViewById(R.id.edit_query)).setImageResource(this.mCommitIconResId);
        return context;
    }

    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        this.updateSpinnerState(this.getCursor());
    }

    public void notifyDataSetInvalidated() {
        super.notifyDataSetInvalidated();
        this.updateSpinnerState(this.getCursor());
    }

    public void onClick(View object) {
        if (!((object = object.getTag()) instanceof CharSequence)) return;
        this.mSearchView.onQueryRefine((CharSequence)object);
    }

    public Cursor runQueryOnBackgroundThread(CharSequence charSequence) {
        charSequence = charSequence == null ? "" : charSequence.toString();
        if (this.mSearchView.getVisibility() != 0) return null;
        if (this.mSearchView.getWindowVisibility() != 0) return null;
        try {
            charSequence = this.getSearchManagerSuggestions(this.mSearchable, (String)charSequence, 50);
            if (charSequence == null) return null;
            charSequence.getCount();
            return charSequence;
        }
        catch (RuntimeException runtimeException) {
            Log.w((String)LOG_TAG, (String)"Search suggestions query threw an exception.", (Throwable)runtimeException);
        }
        return null;
    }

    public void setQueryRefinement(int n) {
        this.mQueryRefinement = n;
    }
}
