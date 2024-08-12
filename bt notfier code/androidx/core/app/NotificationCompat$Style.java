/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Notification
 *  android.app.Notification$BigPictureStyle
 *  android.app.Notification$BigTextStyle
 *  android.app.Notification$DecoratedCustomViewStyle
 *  android.app.Notification$InboxStyle
 *  android.app.Notification$MessagingStyle
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.graphics.Canvas
 *  android.graphics.ColorFilter
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.PorterDuffColorFilter
 *  android.graphics.drawable.Drawable
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.SystemClock
 *  android.widget.RemoteViews
 *  androidx.core.R$dimen
 *  androidx.core.R$drawable
 *  androidx.core.R$id
 *  androidx.core.R$integer
 *  androidx.core.R$string
 *  androidx.core.app.NotificationBuilderWithBuilderAccessor
 *  androidx.core.app.NotificationCompat
 *  androidx.core.app.NotificationCompat$BigPictureStyle
 *  androidx.core.app.NotificationCompat$BigTextStyle
 *  androidx.core.app.NotificationCompat$Builder
 *  androidx.core.app.NotificationCompat$DecoratedCustomViewStyle
 *  androidx.core.app.NotificationCompat$InboxStyle
 *  androidx.core.app.NotificationCompat$MessagingStyle
 *  androidx.core.graphics.drawable.IconCompat
 */
package androidx.core.app;

import android.app.Notification;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.widget.RemoteViews;
import androidx.core.R;
import androidx.core.app.NotificationBuilderWithBuilderAccessor;
import androidx.core.app.NotificationCompat;
import androidx.core.graphics.drawable.IconCompat;
import java.text.NumberFormat;

/*
 * Exception performing whole class analysis ignored.
 */
public static abstract class NotificationCompat.Style {
    CharSequence mBigContentTitle;
    protected NotificationCompat.Builder mBuilder;
    CharSequence mSummaryText;
    boolean mSummaryTextSet = false;

    private int calculateTopPadding() {
        Resources resources = this.mBuilder.mContext.getResources();
        int n = resources.getDimensionPixelSize(R.dimen.notification_top_pad);
        int n2 = resources.getDimensionPixelSize(R.dimen.notification_top_pad_large_text);
        float f = (NotificationCompat.Style.constrain(resources.getConfiguration().fontScale, 1.0f, 1.3f) - 1.0f) / 0.29999995f;
        return Math.round((1.0f - f) * (float)n + f * (float)n2);
    }

    private static float constrain(float f, float f2, float f3) {
        if (f < f2) return f2;
        f2 = f;
        if (!(f > f3)) return f2;
        f2 = f3;
        return f2;
    }

    static NotificationCompat.Style constructCompatStyleByName(String string) {
        if (string == null) return null;
        int n = -1;
        switch (string.hashCode()) {
            default: {
                break;
            }
            case 2090799565: {
                if (!string.equals("androidx.core.app.NotificationCompat$MessagingStyle")) break;
                n = 4;
                break;
            }
            case 919595044: {
                if (!string.equals("androidx.core.app.NotificationCompat$BigTextStyle")) break;
                n = 0;
                break;
            }
            case 912942987: {
                if (!string.equals("androidx.core.app.NotificationCompat$InboxStyle")) break;
                n = 2;
                break;
            }
            case -171946061: {
                if (!string.equals("androidx.core.app.NotificationCompat$BigPictureStyle")) break;
                n = 1;
                break;
            }
            case -716705180: {
                if (!string.equals("androidx.core.app.NotificationCompat$DecoratedCustomViewStyle")) break;
                n = 3;
            }
        }
        if (n == 0) return new NotificationCompat.BigTextStyle();
        if (n == 1) return new NotificationCompat.BigPictureStyle();
        if (n == 2) return new NotificationCompat.InboxStyle();
        if (n == 3) return new NotificationCompat.DecoratedCustomViewStyle();
        if (n == 4) return new NotificationCompat.MessagingStyle();
        return null;
    }

    private static NotificationCompat.Style constructCompatStyleByPlatformName(String string) {
        if (string == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT < 16) return null;
        if (string.equals(Notification.BigPictureStyle.class.getName())) {
            return new NotificationCompat.BigPictureStyle();
        }
        if (string.equals(Notification.BigTextStyle.class.getName())) {
            return new NotificationCompat.BigTextStyle();
        }
        if (string.equals(Notification.InboxStyle.class.getName())) {
            return new NotificationCompat.InboxStyle();
        }
        if (Build.VERSION.SDK_INT < 24) return null;
        if (string.equals(Notification.MessagingStyle.class.getName())) {
            return new NotificationCompat.MessagingStyle();
        }
        if (!string.equals(Notification.DecoratedCustomViewStyle.class.getName())) return null;
        return new NotificationCompat.DecoratedCustomViewStyle();
    }

    static NotificationCompat.Style constructCompatStyleForBundle(Bundle bundle) {
        NotificationCompat.Style style = NotificationCompat.Style.constructCompatStyleByName(bundle.getString("androidx.core.app.extra.COMPAT_TEMPLATE"));
        if (style != null) {
            return style;
        }
        if (bundle.containsKey("android.selfDisplayName")) return new NotificationCompat.MessagingStyle();
        if (bundle.containsKey("android.messagingStyleUser")) {
            return new NotificationCompat.MessagingStyle();
        }
        if (bundle.containsKey("android.picture")) {
            return new NotificationCompat.BigPictureStyle();
        }
        if (bundle.containsKey("android.bigText")) {
            return new NotificationCompat.BigTextStyle();
        }
        if (!bundle.containsKey("android.textLines")) return NotificationCompat.Style.constructCompatStyleByPlatformName(bundle.getString("android.template"));
        return new NotificationCompat.InboxStyle();
    }

    static NotificationCompat.Style constructStyleForExtras(Bundle bundle) {
        NotificationCompat.Style style = NotificationCompat.Style.constructCompatStyleForBundle(bundle);
        if (style == null) {
            return null;
        }
        try {
            style.restoreFromCompatExtras(bundle);
            return style;
        }
        catch (ClassCastException classCastException) {
            return null;
        }
    }

    private Bitmap createColoredBitmap(int n, int n2, int n3) {
        return this.createColoredBitmap(IconCompat.createWithResource((Context)this.mBuilder.mContext, (int)n), n2, n3);
    }

    private Bitmap createColoredBitmap(IconCompat iconCompat, int n, int n2) {
        Drawable drawable = iconCompat.loadDrawable(this.mBuilder.mContext);
        int n3 = n2 == 0 ? drawable.getIntrinsicWidth() : n2;
        int n4 = n2;
        if (n2 == 0) {
            n4 = drawable.getIntrinsicHeight();
        }
        iconCompat = Bitmap.createBitmap((int)n3, (int)n4, (Bitmap.Config)Bitmap.Config.ARGB_8888);
        drawable.setBounds(0, 0, n3, n4);
        if (n != 0) {
            drawable.mutate().setColorFilter((ColorFilter)new PorterDuffColorFilter(n, PorterDuff.Mode.SRC_IN));
        }
        drawable.draw(new Canvas((Bitmap)iconCompat));
        return iconCompat;
    }

    private Bitmap createIconWithBackground(int n, int n2, int n3, int n4) {
        int n5 = R.drawable.notification_icon_background;
        int n6 = n4;
        if (n4 == 0) {
            n6 = 0;
        }
        Bitmap bitmap = this.createColoredBitmap(n5, n6, n2);
        Canvas canvas = new Canvas(bitmap);
        Drawable drawable2 = this.mBuilder.mContext.getResources().getDrawable(n).mutate();
        drawable2.setFilterBitmap(true);
        n = (n2 - n3) / 2;
        n2 = n3 + n;
        drawable2.setBounds(n, n, n2, n2);
        drawable2.setColorFilter((ColorFilter)new PorterDuffColorFilter(-1, PorterDuff.Mode.SRC_ATOP));
        drawable2.draw(canvas);
        return bitmap;
    }

    public static NotificationCompat.Style extractStyleFromNotification(Notification notification) {
        if ((notification = NotificationCompat.getExtras((Notification)notification)) != null) return NotificationCompat.Style.constructStyleForExtras((Bundle)notification);
        return null;
    }

    private void hideNormalContent(RemoteViews remoteViews) {
        remoteViews.setViewVisibility(R.id.title, 8);
        remoteViews.setViewVisibility(R.id.text2, 8);
        remoteViews.setViewVisibility(R.id.text, 8);
    }

    public void addCompatExtras(Bundle bundle) {
        CharSequence charSequence;
        if (this.mSummaryTextSet) {
            bundle.putCharSequence("android.summaryText", this.mSummaryText);
        }
        if ((charSequence = this.mBigContentTitle) != null) {
            bundle.putCharSequence("android.title.big", charSequence);
        }
        if ((charSequence = this.getClassName()) == null) return;
        bundle.putString("androidx.core.app.extra.COMPAT_TEMPLATE", (String)charSequence);
    }

    public void apply(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
    }

    /*
     * Unable to fully structure code
     */
    public RemoteViews applyStandardTemplate(boolean var1_1, int var2_2, boolean var3_3) {
        block29: {
            var10_4 = this.mBuilder.mContext.getResources();
            var9_5 = new RemoteViews(this.mBuilder.mContext.getPackageName(), var2_2);
            var2_2 = this.mBuilder.getPriority();
            var8_6 = 1;
            var7_7 = 0;
            var2_2 = var2_2 < -1 ? 1 : 0;
            if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT < 21) {
                if (var2_2 != 0) {
                    var9_5.setInt(R.id.notification_background, "setBackgroundResource", R.drawable.notification_bg_low);
                    var9_5.setInt(R.id.icon, "setBackgroundResource", R.drawable.notification_template_icon_low_bg);
                } else {
                    var9_5.setInt(R.id.notification_background, "setBackgroundResource", R.drawable.notification_bg);
                    var9_5.setInt(R.id.icon, "setBackgroundResource", R.drawable.notification_template_icon_bg);
                }
            }
            if (this.mBuilder.mLargeIcon != null) {
                if (Build.VERSION.SDK_INT >= 16) {
                    var9_5.setViewVisibility(R.id.icon, 0);
                    var9_5.setImageViewBitmap(R.id.icon, this.mBuilder.mLargeIcon);
                } else {
                    var9_5.setViewVisibility(R.id.icon, 8);
                }
                if (var1_1 && this.mBuilder.mNotification.icon != 0) {
                    var5_8 = var10_4.getDimensionPixelSize(R.dimen.notification_right_icon_size);
                    var2_2 = var10_4.getDimensionPixelSize(R.dimen.notification_small_icon_background_padding);
                    if (Build.VERSION.SDK_INT >= 21) {
                        var11_9 = this.createIconWithBackground(this.mBuilder.mNotification.icon, var5_8, var5_8 - var2_2 * 2, this.mBuilder.getColor());
                        var9_5.setImageViewBitmap(R.id.right_icon, (Bitmap)var11_9);
                    } else {
                        var9_5.setImageViewBitmap(R.id.right_icon, this.createColoredBitmap(this.mBuilder.mNotification.icon, -1));
                    }
                    var9_5.setViewVisibility(R.id.right_icon, 0);
                }
            } else if (var1_1 && this.mBuilder.mNotification.icon != 0) {
                var9_5.setViewVisibility(R.id.icon, 0);
                if (Build.VERSION.SDK_INT >= 21) {
                    var2_2 = var10_4.getDimensionPixelSize(R.dimen.notification_large_icon_width);
                    var5_8 = var10_4.getDimensionPixelSize(R.dimen.notification_big_circle_margin);
                    var6_10 = var10_4.getDimensionPixelSize(R.dimen.notification_small_icon_size_as_large);
                    var11_9 = this.createIconWithBackground(this.mBuilder.mNotification.icon, var2_2 - var5_8, var6_10, this.mBuilder.getColor());
                    var9_5.setImageViewBitmap(R.id.icon, (Bitmap)var11_9);
                } else {
                    var9_5.setImageViewBitmap(R.id.icon, this.createColoredBitmap(this.mBuilder.mNotification.icon, -1));
                }
            }
            if (this.mBuilder.mContentTitle != null) {
                var9_5.setTextViewText(R.id.title, this.mBuilder.mContentTitle);
            }
            if (this.mBuilder.mContentText != null) {
                var9_5.setTextViewText(R.id.text, this.mBuilder.mContentText);
                var5_8 = 1;
            } else {
                var5_8 = 0;
            }
            var2_2 = Build.VERSION.SDK_INT < 21 && this.mBuilder.mLargeIcon != null ? 1 : 0;
            if (this.mBuilder.mContentInfo == null) break block29;
            var9_5.setTextViewText(R.id.info, this.mBuilder.mContentInfo);
            var9_5.setViewVisibility(R.id.info, 0);
            ** GOTO lbl61
        }
        if (this.mBuilder.mNumber > 0) {
            var2_2 = var10_4.getInteger(R.integer.status_bar_notification_info_maxnum);
            if (this.mBuilder.mNumber > var2_2) {
                var9_5.setTextViewText(R.id.info, (CharSequence)var10_4.getString(R.string.status_bar_notification_info_overflow));
            } else {
                var11_9 = NumberFormat.getIntegerInstance();
                var9_5.setTextViewText(R.id.info, (CharSequence)var11_9.format(this.mBuilder.mNumber));
            }
            var9_5.setViewVisibility(R.id.info, 0);
lbl61:
            // 2 sources

            var5_8 = 1;
            var2_2 = 1;
        } else {
            var9_5.setViewVisibility(R.id.info, 8);
        }
        if (this.mBuilder.mSubText == null || Build.VERSION.SDK_INT < 16) ** GOTO lbl73
        var9_5.setTextViewText(R.id.text, this.mBuilder.mSubText);
        if (this.mBuilder.mContentText != null) {
            var9_5.setTextViewText(R.id.text2, this.mBuilder.mContentText);
            var9_5.setViewVisibility(R.id.text2, 0);
            var6_10 = 1;
        } else {
            var9_5.setViewVisibility(R.id.text2, 8);
lbl73:
            // 2 sources

            var6_10 = 0;
        }
        if (var6_10 != 0 && Build.VERSION.SDK_INT >= 16) {
            if (var3_3) {
                var4_11 = var10_4.getDimensionPixelSize(R.dimen.notification_subtext_size);
                var9_5.setTextViewTextSize(R.id.text, 0, var4_11);
            }
            var9_5.setViewPadding(R.id.line1, 0, 0, 0, 0);
        }
        if (this.mBuilder.getWhenIfShowing() != 0L) {
            if (this.mBuilder.mUseChronometer && Build.VERSION.SDK_INT >= 16) {
                var9_5.setViewVisibility(R.id.chronometer, 0);
                var9_5.setLong(R.id.chronometer, "setBase", this.mBuilder.getWhenIfShowing() + (SystemClock.elapsedRealtime() - System.currentTimeMillis()));
                var9_5.setBoolean(R.id.chronometer, "setStarted", true);
                var2_2 = var8_6;
                if (this.mBuilder.mChronometerCountDown) {
                    var2_2 = var8_6;
                    if (Build.VERSION.SDK_INT >= 24) {
                        var9_5.setChronometerCountDown(R.id.chronometer, this.mBuilder.mChronometerCountDown);
                        var2_2 = var8_6;
                    }
                }
            } else {
                var9_5.setViewVisibility(R.id.time, 0);
                var9_5.setLong(R.id.time, "setTime", this.mBuilder.getWhenIfShowing());
                var2_2 = var8_6;
            }
        }
        var6_10 = R.id.right_side;
        var2_2 = var2_2 != 0 ? 0 : 8;
        var9_5.setViewVisibility(var6_10, var2_2);
        var6_10 = R.id.line3;
        var2_2 = var5_8 != 0 ? var7_7 : 8;
        var9_5.setViewVisibility(var6_10, var2_2);
        return var9_5;
    }

    public Notification build() {
        Object object = this.mBuilder;
        object = object != null ? object.build() : null;
        return object;
    }

    public void buildIntoRemoteViews(RemoteViews remoteViews, RemoteViews remoteViews2) {
        this.hideNormalContent(remoteViews);
        remoteViews.removeAllViews(R.id.notification_main_column);
        remoteViews.addView(R.id.notification_main_column, remoteViews2.clone());
        remoteViews.setViewVisibility(R.id.notification_main_column, 0);
        if (Build.VERSION.SDK_INT < 21) return;
        remoteViews.setViewPadding(R.id.notification_main_column_container, 0, this.calculateTopPadding(), 0, 0);
    }

    protected void clearCompatExtraKeys(Bundle bundle) {
        bundle.remove("android.summaryText");
        bundle.remove("android.title.big");
        bundle.remove("androidx.core.app.extra.COMPAT_TEMPLATE");
    }

    public Bitmap createColoredBitmap(int n, int n2) {
        return this.createColoredBitmap(n, n2, 0);
    }

    Bitmap createColoredBitmap(IconCompat iconCompat, int n) {
        return this.createColoredBitmap(iconCompat, n, 0);
    }

    public boolean displayCustomViewInline() {
        return false;
    }

    protected String getClassName() {
        return null;
    }

    public RemoteViews makeBigContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
        return null;
    }

    public RemoteViews makeContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
        return null;
    }

    public RemoteViews makeHeadsUpContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
        return null;
    }

    protected void restoreFromCompatExtras(Bundle bundle) {
        if (bundle.containsKey("android.summaryText")) {
            this.mSummaryText = bundle.getCharSequence("android.summaryText");
            this.mSummaryTextSet = true;
        }
        this.mBigContentTitle = bundle.getCharSequence("android.title.big");
    }

    public void setBuilder(NotificationCompat.Builder builder) {
        if (this.mBuilder == builder) return;
        this.mBuilder = builder;
        if (builder == null) return;
        builder.setStyle(this);
    }
}
