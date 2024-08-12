/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.graphics.Canvas
 *  android.graphics.Color
 *  android.graphics.Matrix
 *  android.graphics.Paint
 *  android.graphics.Paint$Style
 *  android.graphics.Point
 *  android.graphics.PointF
 *  android.graphics.Rect
 *  android.graphics.RectF
 *  android.media.ExifInterface
 *  android.net.Uri
 *  android.os.AsyncTask
 *  android.os.Build$VERSION
 *  android.os.Handler
 *  android.os.Handler$Callback
 *  android.util.DisplayMetrics
 *  android.util.Log
 *  android.view.GestureDetector
 *  android.view.GestureDetector$OnGestureListener
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.View$OnLongClickListener
 *  android.view.ViewParent
 *  com.luck.picture.lib.R$styleable
 *  com.luck.picture.lib.widget.longimage.CompatDecoderFactory
 *  com.luck.picture.lib.widget.longimage.DecoderFactory
 *  com.luck.picture.lib.widget.longimage.ImageDecoder
 *  com.luck.picture.lib.widget.longimage.ImageRegionDecoder
 *  com.luck.picture.lib.widget.longimage.ImageSource
 *  com.luck.picture.lib.widget.longimage.ImageViewState
 *  com.luck.picture.lib.widget.longimage.SkiaImageDecoder
 *  com.luck.picture.lib.widget.longimage.SkiaImageRegionDecoder
 *  com.luck.picture.lib.widget.longimage.SubsamplingScaleImageView$Anim
 *  com.luck.picture.lib.widget.longimage.SubsamplingScaleImageView$AnimationBuilder
 *  com.luck.picture.lib.widget.longimage.SubsamplingScaleImageView$BitmapLoadTask
 *  com.luck.picture.lib.widget.longimage.SubsamplingScaleImageView$OnImageEventListener
 *  com.luck.picture.lib.widget.longimage.SubsamplingScaleImageView$OnStateChangedListener
 *  com.luck.picture.lib.widget.longimage.SubsamplingScaleImageView$ScaleAndTranslate
 *  com.luck.picture.lib.widget.longimage.SubsamplingScaleImageView$Tile
 *  com.luck.picture.lib.widget.longimage.SubsamplingScaleImageView$TileLoadTask
 *  com.luck.picture.lib.widget.longimage.SubsamplingScaleImageView$TilesInitTask
 */
package com.luck.picture.lib.widget.longimage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import com.luck.picture.lib.R;
import com.luck.picture.lib.widget.longimage.CompatDecoderFactory;
import com.luck.picture.lib.widget.longimage.DecoderFactory;
import com.luck.picture.lib.widget.longimage.ImageDecoder;
import com.luck.picture.lib.widget.longimage.ImageRegionDecoder;
import com.luck.picture.lib.widget.longimage.ImageSource;
import com.luck.picture.lib.widget.longimage.ImageViewState;
import com.luck.picture.lib.widget.longimage.SkiaImageDecoder;
import com.luck.picture.lib.widget.longimage.SkiaImageRegionDecoder;
import com.luck.picture.lib.widget.longimage.SubsamplingScaleImageView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Executor;

/*
 * Exception performing whole class analysis ignored.
 */
public class SubsamplingScaleImageView
extends View {
    public static final int EASE_IN_OUT_QUAD = 2;
    public static final int EASE_OUT_QUAD = 1;
    private static final int MESSAGE_LONG_CLICK = 1;
    public static final int ORIENTATION_0 = 0;
    public static final int ORIENTATION_180 = 180;
    public static final int ORIENTATION_270 = 270;
    public static final int ORIENTATION_90 = 90;
    public static final int ORIENTATION_USE_EXIF = -1;
    public static final int ORIGIN_ANIM = 1;
    public static final int ORIGIN_DOUBLE_TAP_ZOOM = 4;
    public static final int ORIGIN_FLING = 3;
    public static final int ORIGIN_TOUCH = 2;
    public static final int PAN_LIMIT_CENTER = 3;
    public static final int PAN_LIMIT_INSIDE = 1;
    public static final int PAN_LIMIT_OUTSIDE = 2;
    public static final int SCALE_TYPE_CENTER_CROP = 2;
    public static final int SCALE_TYPE_CENTER_INSIDE = 1;
    public static final int SCALE_TYPE_CUSTOM = 3;
    private static final String TAG = SubsamplingScaleImageView.class.getSimpleName();
    public static int TILE_SIZE_AUTO = 0;
    private static final List<Integer> VALID_EASING_STYLES;
    private static final List<Integer> VALID_ORIENTATIONS;
    private static final List<Integer> VALID_PAN_LIMITS;
    private static final List<Integer> VALID_SCALE_TYPES;
    private static final List<Integer> VALID_ZOOM_STYLES;
    public static final int ZOOM_FOCUS_CENTER = 2;
    public static final int ZOOM_FOCUS_CENTER_IMMEDIATE = 3;
    public static final int ZOOM_FOCUS_FIXED = 1;
    private Anim anim;
    private Bitmap bitmap;
    private DecoderFactory<? extends ImageDecoder> bitmapDecoderFactory;
    private boolean bitmapIsCached;
    private boolean bitmapIsPreview;
    private Paint bitmapPaint;
    private boolean debug;
    private Paint debugPaint;
    private ImageRegionDecoder decoder;
    private final Object decoderLock;
    private float density;
    private GestureDetector detector;
    private int doubleTapZoomDuration;
    private float doubleTapZoomScale;
    private int doubleTapZoomStyle;
    private float[] dstArray;
    private int fullImageSampleSize;
    private Handler handler;
    private boolean imageLoadedSent;
    private boolean isPanning;
    private boolean isQuickScaling;
    private boolean isZooming;
    private Matrix matrix;
    private float maxScale = 2.0f;
    private int maxTileHeight;
    private int maxTileWidth;
    private int maxTouchCount;
    private float minScale = this.minScale();
    private int minimumScaleType = 1;
    private int minimumTileDpi = -1;
    private OnImageEventListener onImageEventListener;
    private View.OnLongClickListener onLongClickListener;
    private OnStateChangedListener onStateChangedListener;
    private int orientation = 0;
    private Rect pRegion;
    private boolean panEnabled;
    private int panLimit = 1;
    private boolean parallelLoadingEnabled;
    private Float pendingScale;
    private boolean quickScaleEnabled;
    private float quickScaleLastDistance;
    private boolean quickScaleMoved;
    private PointF quickScaleSCenter;
    private final float quickScaleThreshold;
    private PointF quickScaleVLastPoint;
    private PointF quickScaleVStart;
    private boolean readySent;
    private DecoderFactory<? extends ImageRegionDecoder> regionDecoderFactory;
    private int sHeight;
    private int sOrientation;
    private PointF sPendingCenter;
    private RectF sRect;
    private Rect sRegion;
    private PointF sRequestedCenter;
    private int sWidth;
    private ScaleAndTranslate satTemp;
    private float scale;
    private float scaleStart;
    private float[] srcArray;
    private Paint tileBgPaint;
    private Map<Integer, List<Tile>> tileMap;
    private Uri uri;
    private PointF vCenterStart;
    private float vDistStart;
    private PointF vTranslate;
    private PointF vTranslateBefore;
    private PointF vTranslateStart;
    private boolean zoomEnabled;

    static {
        Integer n = 1;
        Integer n2 = 2;
        Integer n3 = 3;
        VALID_ORIENTATIONS = Arrays.asList(0, 90, 180, 270, -1);
        VALID_ZOOM_STYLES = Arrays.asList(n, n2, n3);
        VALID_EASING_STYLES = Arrays.asList(n2, n);
        VALID_PAN_LIMITS = Arrays.asList(n, n2, n3);
        VALID_SCALE_TYPES = Arrays.asList(n2, n, n3);
        TILE_SIZE_AUTO = Integer.MAX_VALUE;
    }

    public SubsamplingScaleImageView(Context context) {
        this(context, null);
    }

    public SubsamplingScaleImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int n;
        this.maxTileWidth = n = TILE_SIZE_AUTO;
        this.maxTileHeight = n;
        this.panEnabled = true;
        this.zoomEnabled = true;
        this.quickScaleEnabled = true;
        this.doubleTapZoomScale = 1.0f;
        this.doubleTapZoomStyle = 1;
        this.doubleTapZoomDuration = 500;
        this.decoderLock = new Object();
        this.bitmapDecoderFactory = new CompatDecoderFactory(SkiaImageDecoder.class);
        this.regionDecoderFactory = new CompatDecoderFactory(SkiaImageRegionDecoder.class);
        this.srcArray = new float[8];
        this.dstArray = new float[8];
        this.density = this.getResources().getDisplayMetrics().density;
        this.setMinimumDpi(160);
        this.setDoubleTapZoomDpi(160);
        this.setGestureDetector(context);
        this.handler = new Handler((Handler.Callback)new /* Unavailable Anonymous Inner Class!! */);
        if (attributeSet != null) {
            String string;
            attributeSet = this.getContext().obtainStyledAttributes(attributeSet, R.styleable.PictureLongScaleImageView);
            if (attributeSet.hasValue(R.styleable.PictureLongScaleImageView_assetName) && (string = attributeSet.getString(R.styleable.PictureLongScaleImageView_assetName)) != null && string.length() > 0) {
                this.setImage(ImageSource.asset((String)string).tilingEnabled());
            }
            if (attributeSet.hasValue(R.styleable.PictureLongScaleImageView_src) && (n = attributeSet.getResourceId(R.styleable.PictureLongScaleImageView_src, 0)) > 0) {
                this.setImage(ImageSource.resource((int)n).tilingEnabled());
            }
            if (attributeSet.hasValue(R.styleable.PictureLongScaleImageView_panEnabled)) {
                this.setPanEnabled(attributeSet.getBoolean(R.styleable.PictureLongScaleImageView_panEnabled, true));
            }
            if (attributeSet.hasValue(R.styleable.PictureLongScaleImageView_zoomEnabled)) {
                this.setZoomEnabled(attributeSet.getBoolean(R.styleable.PictureLongScaleImageView_zoomEnabled, true));
            }
            if (attributeSet.hasValue(R.styleable.PictureLongScaleImageView_quickScaleEnabled)) {
                this.setQuickScaleEnabled(attributeSet.getBoolean(R.styleable.PictureLongScaleImageView_quickScaleEnabled, true));
            }
            if (attributeSet.hasValue(R.styleable.PictureLongScaleImageView_tileBackgroundColor)) {
                this.setTileBackgroundColor(attributeSet.getColor(R.styleable.PictureLongScaleImageView_tileBackgroundColor, Color.argb((int)0, (int)0, (int)0, (int)0)));
            }
            attributeSet.recycle();
        }
        this.quickScaleThreshold = TypedValue.applyDimension((int)1, (float)20.0f, (DisplayMetrics)context.getResources().getDisplayMetrics());
    }

    static /* synthetic */ View.OnLongClickListener access$000(SubsamplingScaleImageView subsamplingScaleImageView) {
        return subsamplingScaleImageView.onLongClickListener;
    }

    static /* synthetic */ float access$1000(SubsamplingScaleImageView subsamplingScaleImageView) {
        return subsamplingScaleImageView.scale;
    }

    static /* synthetic */ int access$102(SubsamplingScaleImageView subsamplingScaleImageView, int n) {
        subsamplingScaleImageView.maxTouchCount = n;
        return n;
    }

    static /* synthetic */ boolean access$1400(SubsamplingScaleImageView subsamplingScaleImageView) {
        return subsamplingScaleImageView.zoomEnabled;
    }

    static /* synthetic */ void access$1500(SubsamplingScaleImageView subsamplingScaleImageView, Context context) {
        subsamplingScaleImageView.setGestureDetector(context);
    }

    static /* synthetic */ boolean access$1600(SubsamplingScaleImageView subsamplingScaleImageView) {
        return subsamplingScaleImageView.quickScaleEnabled;
    }

    static /* synthetic */ PointF access$1700(SubsamplingScaleImageView subsamplingScaleImageView) {
        return subsamplingScaleImageView.vCenterStart;
    }

    static /* synthetic */ PointF access$1702(SubsamplingScaleImageView subsamplingScaleImageView, PointF pointF) {
        subsamplingScaleImageView.vCenterStart = pointF;
        return pointF;
    }

    static /* synthetic */ PointF access$1802(SubsamplingScaleImageView subsamplingScaleImageView, PointF pointF) {
        subsamplingScaleImageView.vTranslateStart = pointF;
        return pointF;
    }

    static /* synthetic */ float access$1902(SubsamplingScaleImageView subsamplingScaleImageView, float f) {
        subsamplingScaleImageView.scaleStart = f;
        return f;
    }

    static /* synthetic */ boolean access$2002(SubsamplingScaleImageView subsamplingScaleImageView, boolean bl) {
        subsamplingScaleImageView.isQuickScaling = bl;
        return bl;
    }

    static /* synthetic */ void access$201(SubsamplingScaleImageView subsamplingScaleImageView, View.OnLongClickListener onLongClickListener) {
        super.setOnLongClickListener(onLongClickListener);
    }

    static /* synthetic */ float access$2102(SubsamplingScaleImageView subsamplingScaleImageView, float f) {
        subsamplingScaleImageView.quickScaleLastDistance = f;
        return f;
    }

    static /* synthetic */ PointF access$2200(SubsamplingScaleImageView subsamplingScaleImageView) {
        return subsamplingScaleImageView.quickScaleSCenter;
    }

    static /* synthetic */ PointF access$2202(SubsamplingScaleImageView subsamplingScaleImageView, PointF pointF) {
        subsamplingScaleImageView.quickScaleSCenter = pointF;
        return pointF;
    }

    static /* synthetic */ PointF access$2302(SubsamplingScaleImageView subsamplingScaleImageView, PointF pointF) {
        subsamplingScaleImageView.quickScaleVStart = pointF;
        return pointF;
    }

    static /* synthetic */ PointF access$2402(SubsamplingScaleImageView subsamplingScaleImageView, PointF pointF) {
        subsamplingScaleImageView.quickScaleVLastPoint = pointF;
        return pointF;
    }

    static /* synthetic */ boolean access$2502(SubsamplingScaleImageView subsamplingScaleImageView, boolean bl) {
        subsamplingScaleImageView.quickScaleMoved = bl;
        return bl;
    }

    static /* synthetic */ void access$2600(SubsamplingScaleImageView subsamplingScaleImageView, PointF pointF, PointF pointF2) {
        subsamplingScaleImageView.doubleTapZoom(pointF, pointF2);
    }

    static /* synthetic */ void access$301(SubsamplingScaleImageView subsamplingScaleImageView, View.OnLongClickListener onLongClickListener) {
        super.setOnLongClickListener(onLongClickListener);
    }

    static /* synthetic */ void access$5100(SubsamplingScaleImageView subsamplingScaleImageView, String string, Object[] objectArray) {
        subsamplingScaleImageView.debug(string, objectArray);
    }

    static /* synthetic */ int access$5200(SubsamplingScaleImageView subsamplingScaleImageView, Context context, String string) {
        return subsamplingScaleImageView.getExifOrientation(context, string);
    }

    static /* synthetic */ Rect access$5300(SubsamplingScaleImageView subsamplingScaleImageView) {
        return subsamplingScaleImageView.sRegion;
    }

    static /* synthetic */ String access$5400() {
        return TAG;
    }

    static /* synthetic */ void access$5500(SubsamplingScaleImageView subsamplingScaleImageView, ImageRegionDecoder imageRegionDecoder, int n, int n2, int n3) {
        subsamplingScaleImageView.onTilesInited(imageRegionDecoder, n, n2, n3);
    }

    static /* synthetic */ OnImageEventListener access$5600(SubsamplingScaleImageView subsamplingScaleImageView) {
        return subsamplingScaleImageView.onImageEventListener;
    }

    static /* synthetic */ Object access$5700(SubsamplingScaleImageView subsamplingScaleImageView) {
        return subsamplingScaleImageView.decoderLock;
    }

    static /* synthetic */ void access$5800(SubsamplingScaleImageView subsamplingScaleImageView, Rect rect, Rect rect2) {
        subsamplingScaleImageView.fileSRect(rect, rect2);
    }

    static /* synthetic */ void access$5900(SubsamplingScaleImageView subsamplingScaleImageView) {
        subsamplingScaleImageView.onTileLoaded();
    }

    static /* synthetic */ boolean access$600(SubsamplingScaleImageView subsamplingScaleImageView) {
        return subsamplingScaleImageView.panEnabled;
    }

    static /* synthetic */ void access$6000(SubsamplingScaleImageView subsamplingScaleImageView, Bitmap bitmap) {
        subsamplingScaleImageView.onPreviewLoaded(bitmap);
    }

    static /* synthetic */ void access$6100(SubsamplingScaleImageView subsamplingScaleImageView, Bitmap bitmap, int n, boolean bl) {
        subsamplingScaleImageView.onImageLoaded(bitmap, n, bl);
    }

    static /* synthetic */ List access$6300() {
        return VALID_EASING_STYLES;
    }

    static /* synthetic */ Anim access$6400(SubsamplingScaleImageView subsamplingScaleImageView) {
        return subsamplingScaleImageView.anim;
    }

    static /* synthetic */ Anim access$6402(SubsamplingScaleImageView subsamplingScaleImageView, Anim anim) {
        subsamplingScaleImageView.anim = anim;
        return anim;
    }

    static /* synthetic */ float access$6500(SubsamplingScaleImageView subsamplingScaleImageView, float f) {
        return subsamplingScaleImageView.limitedScale(f);
    }

    static /* synthetic */ PointF access$6600(SubsamplingScaleImageView subsamplingScaleImageView, float f, float f2, float f3, PointF pointF) {
        return subsamplingScaleImageView.limitedSCenter(f, f2, f3, pointF);
    }

    static /* synthetic */ void access$6800(SubsamplingScaleImageView subsamplingScaleImageView, boolean bl, ScaleAndTranslate scaleAndTranslate) {
        subsamplingScaleImageView.fitToBounds(bl, scaleAndTranslate);
    }

    static /* synthetic */ boolean access$700(SubsamplingScaleImageView subsamplingScaleImageView) {
        return subsamplingScaleImageView.readySent;
    }

    static /* synthetic */ PointF access$800(SubsamplingScaleImageView subsamplingScaleImageView) {
        return subsamplingScaleImageView.vTranslate;
    }

    static /* synthetic */ boolean access$900(SubsamplingScaleImageView subsamplingScaleImageView) {
        return subsamplingScaleImageView.isZooming;
    }

    static /* synthetic */ boolean access$902(SubsamplingScaleImageView subsamplingScaleImageView, boolean bl) {
        subsamplingScaleImageView.isZooming = bl;
        return bl;
    }

    private int calculateInSampleSize(float f) {
        float f2 = f;
        if (this.minimumTileDpi > 0) {
            DisplayMetrics displayMetrics = this.getResources().getDisplayMetrics();
            f2 = (displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f;
            f2 = f * ((float)this.minimumTileDpi / f2);
        }
        int n = (int)((float)this.sWidth() * f2);
        int n2 = (int)((float)this.sHeight() * f2);
        if (n == 0) return 32;
        if (n2 == 0) {
            return 32;
        }
        int n3 = this.sHeight();
        int n4 = 1;
        if (n3 <= n2 && this.sWidth() <= n) {
            n3 = 1;
        } else {
            n3 = Math.round((float)this.sHeight() / (float)n2);
            if (n3 >= (n = Math.round((float)this.sWidth() / (float)n))) {
                n3 = n;
            }
        }
        while ((n = n4 * 2) < n3) {
            n4 = n;
        }
        return n4;
    }

    private boolean checkImageLoaded() {
        boolean bl = this.isBaseLayerReady();
        if (this.imageLoadedSent) return bl;
        if (!bl) return bl;
        this.preDraw();
        this.imageLoadedSent = true;
        this.onImageLoaded();
        OnImageEventListener onImageEventListener = this.onImageEventListener;
        if (onImageEventListener == null) return bl;
        onImageEventListener.onImageLoaded();
        return bl;
    }

    private boolean checkReady() {
        boolean bl = this.getWidth() > 0 && this.getHeight() > 0 && this.sWidth > 0 && this.sHeight > 0 && (this.bitmap != null || this.isBaseLayerReady());
        if (this.readySent) return bl;
        if (!bl) return bl;
        this.preDraw();
        this.readySent = true;
        this.onReady();
        OnImageEventListener onImageEventListener = this.onImageEventListener;
        if (onImageEventListener == null) return bl;
        onImageEventListener.onReady();
        return bl;
    }

    private void createPaints() {
        Paint paint;
        if (this.bitmapPaint == null) {
            this.bitmapPaint = paint = new Paint();
            paint.setAntiAlias(true);
            this.bitmapPaint.setFilterBitmap(true);
            this.bitmapPaint.setDither(true);
        }
        if (this.debugPaint != null) return;
        if (!this.debug) return;
        this.debugPaint = paint = new Paint();
        paint.setTextSize(18.0f);
        this.debugPaint.setColor(-65281);
        this.debugPaint.setStyle(Paint.Style.STROKE);
    }

    private void debug(String string, Object ... objectArray) {
        if (!this.debug) return;
        Log.d((String)TAG, (String)String.format(string, objectArray));
    }

    private float distance(float f, float f2, float f3, float f4) {
        f -= f2;
        f2 = f3 - f4;
        return (float)Math.sqrt(f * f + f2 * f2);
    }

    private void doubleTapZoom(PointF pointF, PointF pointF2) {
        if (!this.panEnabled) {
            PointF pointF3 = this.sRequestedCenter;
            if (pointF3 != null) {
                pointF.x = pointF3.x;
                pointF.y = this.sRequestedCenter.y;
            } else {
                pointF.x = this.sWidth() / 2;
                pointF.y = this.sHeight() / 2;
            }
        }
        float f = Math.min(this.maxScale, this.doubleTapZoomScale);
        double d = this.scale;
        double d2 = f;
        Double.isNaN(d2);
        boolean bl = d <= d2 * 0.9;
        if (!bl) {
            f = this.minScale();
        }
        int n = this.doubleTapZoomStyle;
        if (n == 3) {
            this.setScaleAndCenter(f, pointF);
        } else if (n != 2 && bl && this.panEnabled) {
            if (n == 1) {
                AnimationBuilder.access$1300((AnimationBuilder)new AnimationBuilder(this, f, pointF, pointF2, null).withInterruptible(false).withDuration((long)this.doubleTapZoomDuration), (int)4).start();
            }
        } else {
            AnimationBuilder.access$1300((AnimationBuilder)new AnimationBuilder(this, f, pointF, null).withInterruptible(false).withDuration((long)this.doubleTapZoomDuration), (int)4).start();
        }
        this.invalidate();
    }

    private float ease(int n, long l, float f, float f2, long l2) {
        if (n == 1) return this.easeOutQuad(l, f, f2, l2);
        if (n == 2) {
            return this.easeInOutQuad(l, f, f2, l2);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unexpected easing type: ");
        stringBuilder.append(n);
        throw new IllegalStateException(stringBuilder.toString());
    }

    private float easeInOutQuad(long l, float f, float f2, long l2) {
        float f3;
        float f4 = (float)l / ((float)l2 / 2.0f);
        if (f4 < 1.0f) {
            f3 = f2 / 2.0f * f4;
            f2 = f4;
        } else {
            f3 = -f2 / 2.0f;
            f2 = (f4 -= 1.0f) * (f4 - 2.0f) - 1.0f;
        }
        return f3 * f2 + f;
    }

    private float easeOutQuad(long l, float f, float f2, long l2) {
        float f3 = (float)l / (float)l2;
        return -f2 * f3 * (f3 - 2.0f) + f;
    }

    private void execute(AsyncTask<Void, Void, ?> asyncTask) {
        if (this.parallelLoadingEnabled) {
            try {
                Executor executor = (Executor)AsyncTask.class.getField("THREAD_POOL_EXECUTOR").get(null);
                AsyncTask.class.getMethod("executeOnExecutor", Executor.class, Object[].class).invoke(asyncTask, executor, null);
                return;
            }
            catch (Exception exception) {
                Log.i((String)TAG, (String)"Failed to execute AsyncTask on thread pool executor, falling back to single threaded executor", (Throwable)exception);
            }
        }
        asyncTask.execute((Object[])new Void[0]);
    }

    private void fileSRect(Rect rect, Rect rect2) {
        if (this.getRequiredRotation() == 0) {
            rect2.set(rect);
        } else if (this.getRequiredRotation() == 90) {
            rect2.set(rect.top, this.sHeight - rect.right, rect.bottom, this.sHeight - rect.left);
        } else if (this.getRequiredRotation() == 180) {
            rect2.set(this.sWidth - rect.right, this.sHeight - rect.bottom, this.sWidth - rect.left, this.sHeight - rect.top);
        } else {
            rect2.set(this.sWidth - rect.bottom, rect.left, this.sWidth - rect.top, rect.right);
        }
    }

    private void fitToBounds(boolean bl) {
        boolean bl2;
        if (this.vTranslate == null) {
            bl2 = true;
            this.vTranslate = new PointF(0.0f, 0.0f);
        } else {
            bl2 = false;
        }
        if (this.satTemp == null) {
            this.satTemp = new ScaleAndTranslate(0.0f, new PointF(0.0f, 0.0f), null);
        }
        ScaleAndTranslate.access$4702((ScaleAndTranslate)this.satTemp, (float)this.scale);
        ScaleAndTranslate.access$4800((ScaleAndTranslate)this.satTemp).set(this.vTranslate);
        this.fitToBounds(bl, this.satTemp);
        this.scale = ScaleAndTranslate.access$4700((ScaleAndTranslate)this.satTemp);
        this.vTranslate.set(ScaleAndTranslate.access$4800((ScaleAndTranslate)this.satTemp));
        if (!bl2) return;
        this.vTranslate.set(this.vTranslateForSCenter(this.sWidth() / 2, this.sHeight() / 2, this.scale));
    }

    /*
     * Unable to fully structure code
     */
    private void fitToBounds(boolean var1_1, ScaleAndTranslate var2_2) {
        block9: {
            var9_3 = var1_1;
            if (this.panLimit == 2) {
                var9_3 = var1_1;
                if (this.isReady()) {
                    var9_3 = false;
                }
            }
            var10_4 = ScaleAndTranslate.access$4800((ScaleAndTranslate)var2_2);
            var5_5 = this.limitedScale(ScaleAndTranslate.access$4700((ScaleAndTranslate)var2_2));
            var7_6 = (float)this.sWidth() * var5_5;
            var6_7 = (float)this.sHeight() * var5_5;
            if (this.panLimit == 3 && this.isReady()) {
                var10_4.x = Math.max(var10_4.x, (float)(this.getWidth() / 2) - var7_6);
                var10_4.y = Math.max(var10_4.y, (float)(this.getHeight() / 2) - var6_7);
            } else if (var9_3) {
                var10_4.x = Math.max(var10_4.x, (float)this.getWidth() - var7_6);
                var10_4.y = Math.max(var10_4.y, (float)this.getHeight() - var6_7);
            } else {
                var10_4.x = Math.max(var10_4.x, -var7_6);
                var10_4.y = Math.max(var10_4.y, -var6_7);
            }
            var8_8 = this.getPaddingLeft();
            var4_9 = 0.5f;
            var3_10 = var8_8 <= 0 && this.getPaddingRight() <= 0 ? 0.5f : (float)this.getPaddingLeft() / (float)(this.getPaddingLeft() + this.getPaddingRight());
            if (this.getPaddingTop() > 0 || this.getPaddingBottom() > 0) {
                var4_9 = (float)this.getPaddingTop() / (float)(this.getPaddingTop() + this.getPaddingBottom());
            }
            if (this.panLimit != 3 || !this.isReady()) break block9;
            var3_10 = Math.max(0, this.getWidth() / 2);
            var8_8 = Math.max(0, this.getHeight() / 2);
            ** GOTO lbl36
        }
        if (var9_3) {
            var3_10 = Math.max(0.0f, ((float)this.getWidth() - var7_6) * var3_10);
            var4_9 = Math.max(0.0f, ((float)this.getHeight() - var6_7) * var4_9);
        } else {
            var3_10 = Math.max(0, this.getWidth());
            var8_8 = Math.max(0, this.getHeight());
lbl36:
            // 2 sources

            var4_9 = var8_8;
        }
        var10_4.x = Math.min(var10_4.x, var3_10);
        var10_4.y = Math.min(var10_4.y, var4_9);
        ScaleAndTranslate.access$4702((ScaleAndTranslate)var2_2, (float)var5_5);
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled unnecessary exception pruning
     */
    private int getExifOrientation(Context object, String string) {
        boolean bl = string.startsWith("content");
        int n = 0;
        int n2 = 0;
        int n3 = 0;
        if (bl) {
            Throwable throwable2;
            Object object2;
            block14: {
                Object object3 = null;
                object2 = null;
                object = object.getContentResolver().query(Uri.parse((String)string), new String[]{"orientation"}, null, null, null);
                int n4 = n3;
                if (object != null) {
                    n4 = n3;
                    object2 = object;
                    object3 = object;
                    if (object.moveToFirst()) {
                        object2 = object;
                        object3 = object;
                        n4 = object.getInt(0);
                        object2 = object;
                        object3 = object;
                        if (!VALID_ORIENTATIONS.contains(n4) || n4 == -1) {
                            object2 = object;
                            object3 = object;
                            string = TAG;
                            object2 = object;
                            object3 = object;
                            object2 = object;
                            object3 = object;
                            StringBuilder stringBuilder = new StringBuilder();
                            object2 = object;
                            object3 = object;
                            stringBuilder.append("Unsupported orientation: ");
                            object2 = object;
                            object3 = object;
                            stringBuilder.append(n4);
                            object2 = object;
                            object3 = object;
                            Log.w((String)string, (String)stringBuilder.toString());
                            n4 = n3;
                        }
                    }
                }
                n3 = n4;
                if (object == null) return n3;
                n3 = n4;
                {
                    catch (Throwable throwable2) {
                        break block14;
                    }
                    catch (Exception exception) {}
                    object2 = object3;
                    {
                        Log.w((String)TAG, (String)"Could not get orientation of image from media store");
                        n3 = n2;
                        if (object3 == null) return n3;
                        object = object3;
                        n3 = n;
                    }
                }
                object.close();
                return n3;
            }
            if (object2 == null) throw throwable2;
            object2.close();
            throw throwable2;
        }
        n3 = n2;
        if (!string.startsWith("file:///")) return n3;
        n3 = n2;
        if (string.startsWith("file:///android_asset/")) return n3;
        try {
            object = new ExifInterface(string.substring(7));
            int n5 = object.getAttributeInt("Orientation", 1);
            n3 = n2;
            if (n5 == 1) return n3;
            if (n5 == 0) {
                return n2;
            }
            if (n5 == 6) {
                return 90;
            }
            if (n5 == 3) {
                return 180;
            }
            if (n5 == 8) {
                return 270;
            }
            string = TAG;
            object = new StringBuilder();
            ((StringBuilder)object).append("Unsupported EXIF orientation: ");
            ((StringBuilder)object).append(n5);
            Log.w((String)string, (String)((StringBuilder)object).toString());
            return n2;
        }
        catch (Exception exception) {
            Log.w((String)TAG, (String)"Could not get EXIF orientation of image");
            return n2;
        }
    }

    /*
     * Enabled unnecessary exception pruning
     */
    private Point getMaxBitmapDimensions(Canvas canvas) {
        int n;
        int n2;
        int n3;
        block5: {
            n3 = Build.VERSION.SDK_INT;
            n2 = 2048;
            if (n3 >= 14) {
                try {
                    n3 = (Integer)Canvas.class.getMethod("getMaximumBitmapWidth", new Class[0]).invoke(canvas, new Object[0]);
                }
                catch (Exception exception) {
                    n2 = 2048;
                    break block5;
                }
                try {
                    n = n2 = ((Integer)Canvas.class.getMethod("getMaximumBitmapHeight", new Class[0]).invoke(canvas, new Object[0])).intValue();
                    return new Point(Math.min(n3, this.maxTileWidth), Math.min(n, this.maxTileHeight));
                }
                catch (Exception exception) {
                    n2 = n3;
                }
            }
        }
        n = 2048;
        n3 = n2;
        return new Point(Math.min(n3, this.maxTileWidth), Math.min(n, this.maxTileHeight));
    }

    private int getRequiredRotation() {
        int n;
        int n2 = n = this.orientation;
        if (n != -1) return n2;
        n2 = this.sOrientation;
        return n2;
    }

    private void initialiseBaseLayer(Point point2) {
        synchronized (this) {
            try {
                int n;
                this.debug("initialiseBaseLayer maxTileDimensions=%dx%d", point2.x, point2.y);
                PointF pointF = new PointF(0.0f, 0.0f);
                Object object = new ScaleAndTranslate(0.0f, pointF, null);
                this.satTemp = object;
                this.fitToBounds(true, (ScaleAndTranslate)object);
                this.fullImageSampleSize = n = this.calculateInSampleSize(ScaleAndTranslate.access$4700((ScaleAndTranslate)this.satTemp));
                if (n > 1) {
                    this.fullImageSampleSize = n / 2;
                }
                if (this.fullImageSampleSize == 1 && this.sRegion == null && this.sWidth() < point2.x && this.sHeight() < point2.y) {
                    this.decoder.recycle();
                    this.decoder = null;
                    BitmapLoadTask throwable = new BitmapLoadTask(this, this.getContext(), this.bitmapDecoderFactory, this.uri, false);
                    this.execute((AsyncTask<Void, Void, ?>)throwable);
                } else {
                    this.initialiseTileMap(point2);
                    for (Tile tile : this.tileMap.get(this.fullImageSampleSize)) {
                        pointF = new TileLoadTask(this, this.decoder, tile);
                        this.execute((AsyncTask<Void, Void, ?>)pointF);
                    }
                    this.refreshRequiredTiles(true);
                }
                return;
            }
            catch (Throwable throwable) {
                throw throwable;
            }
        }
    }

    private void initialiseTileMap(Point point) {
        this.debug("initialiseTileMap maxTileDimensions=%dx%d", point.x, point.y);
        this.tileMap = new LinkedHashMap<Integer, List<Tile>>();
        int n = this.fullImageSampleSize;
        int n2 = 1;
        int n3 = 1;
        block0: while (true) {
            int n4;
            int n5;
            double d;
            double d2;
            int n6 = this.sWidth() / n2;
            int n7 = this.sHeight() / n3;
            int n8 = n6 / n;
            int n9 = n7 / n;
            while (true) {
                if (n8 + n2 + 1 <= point.x) {
                    d2 = n8;
                    d = this.getWidth();
                    Double.isNaN(d);
                    n8 = n3;
                    n5 = n7;
                    n4 = n9;
                    if (!(d2 > d * 1.25)) break;
                    n8 = n3;
                    n5 = n7;
                    n4 = n9;
                    if (n >= this.fullImageSampleSize) break;
                }
                n6 = this.sWidth() / ++n2;
                n8 = n6 / n;
            }
            while (true) {
                if (n4 + n8 + 1 <= point.y) {
                    d2 = n4;
                    d = this.getHeight();
                    Double.isNaN(d);
                    if (!(d2 > d * 1.25) || n >= this.fullImageSampleSize) break;
                }
                n5 = this.sHeight() / ++n8;
                n4 = n5 / n;
            }
            ArrayList<Tile> arrayList = new ArrayList<Tile>(n2 * n8);
            n3 = 0;
            while (true) {
                if (n3 < n2) {
                } else {
                    this.tileMap.put(n, arrayList);
                    if (n == 1) {
                        return;
                    }
                    n /= 2;
                    n3 = n8;
                    continue block0;
                }
                for (n4 = 0; n4 < n8; ++n4) {
                    Tile tile = new Tile(null);
                    Tile.access$4302((Tile)tile, (int)n);
                    boolean bl = n == this.fullImageSampleSize;
                    Tile.access$402((Tile)tile, (boolean)bl);
                    n9 = n3 == n2 - 1 ? this.sWidth() : (n3 + 1) * n6;
                    n7 = n4 == n8 - 1 ? this.sHeight() : (n4 + 1) * n5;
                    Tile.access$4102((Tile)tile, (Rect)new Rect(n3 * n6, n4 * n5, n9, n7));
                    Tile.access$4202((Tile)tile, (Rect)new Rect(0, 0, 0, 0));
                    Tile.access$5002((Tile)tile, (Rect)new Rect(Tile.access$4100((Tile)tile)));
                    arrayList.add(tile);
                }
                ++n3;
            }
            break;
        }
    }

    /*
     * Unable to fully structure code
     */
    private boolean isBaseLayerReady() {
        var3_1 = this.bitmap;
        var1_2 = true;
        if (var3_1 != null && !this.bitmapIsPreview) {
            return true;
        }
        var3_1 = this.tileMap;
        if (var3_1 == null) return false;
        var3_1 = var3_1.entrySet().iterator();
        block0: while (true) {
            if (var3_1.hasNext() == false) return var1_2;
            var4_4 = (Map.Entry)var3_1.next();
            if ((Integer)var4_4.getKey() != this.fullImageSampleSize) continue;
            var5_5 = ((List)var4_4.getValue()).iterator();
            var2_3 = var1_2;
            while (true) {
                var1_2 = var2_3;
                if (var5_5.hasNext()) ** break;
                continue block0;
                var4_4 = (Tile)var5_5.next();
                if (!Tile.access$4000((Tile)var4_4) && Tile.access$500((Tile)var4_4) != null) continue;
                var2_3 = false;
            }
            break;
        }
    }

    private PointF limitedSCenter(float f, float f2, float f3, PointF pointF) {
        PointF pointF2 = this.vTranslateForSCenter(f, f2, f3);
        int n = this.getPaddingLeft();
        int n2 = (this.getWidth() - this.getPaddingRight() - this.getPaddingLeft()) / 2;
        int n3 = this.getPaddingTop();
        int n4 = (this.getHeight() - this.getPaddingBottom() - this.getPaddingTop()) / 2;
        pointF.set(((float)(n + n2) - pointF2.x) / f3, ((float)(n3 + n4) - pointF2.y) / f3);
        return pointF;
    }

    private float limitedScale(float f) {
        f = Math.max(this.minScale(), f);
        return Math.min(this.maxScale, f);
    }

    private float minScale() {
        int n = this.getPaddingBottom() + this.getPaddingTop();
        int n2 = this.getPaddingLeft() + this.getPaddingRight();
        int n3 = this.minimumScaleType;
        if (n3 == 2) {
            return Math.max((float)(this.getWidth() - n2) / (float)this.sWidth(), (float)(this.getHeight() - n) / (float)this.sHeight());
        }
        if (n3 != 3) return Math.min((float)(this.getWidth() - n2) / (float)this.sWidth(), (float)(this.getHeight() - n) / (float)this.sHeight());
        float f = this.minScale;
        if (!(f > 0.0f)) return Math.min((float)(this.getWidth() - n2) / (float)this.sWidth(), (float)(this.getHeight() - n) / (float)this.sHeight());
        return f;
    }

    private void onImageLoaded(Bitmap bitmap, int n, boolean bl) {
        synchronized (this) {
            this.debug("onImageLoaded", new Object[0]);
            if (this.sWidth > 0 && this.sHeight > 0 && (this.sWidth != bitmap.getWidth() || this.sHeight != bitmap.getHeight())) {
                this.reset(false);
            }
            if (this.bitmap != null && !this.bitmapIsCached) {
                this.bitmap.recycle();
            }
            if (this.bitmap != null && this.bitmapIsCached && this.onImageEventListener != null) {
                this.onImageEventListener.onPreviewReleased();
            }
            this.bitmapIsPreview = false;
            this.bitmapIsCached = bl;
            this.bitmap = bitmap;
            this.sWidth = bitmap.getWidth();
            this.sHeight = bitmap.getHeight();
            this.sOrientation = n;
            boolean bl2 = this.checkReady();
            bl = this.checkImageLoaded();
            if (!bl2) {
                if (!bl) return;
            }
            this.invalidate();
            this.requestLayout();
            return;
        }
    }

    private void onPreviewLoaded(Bitmap bitmap) {
        synchronized (this) {
            this.debug("onPreviewLoaded", new Object[0]);
            if (this.bitmap == null && !this.imageLoadedSent) {
                this.bitmap = this.pRegion != null ? Bitmap.createBitmap((Bitmap)bitmap, (int)this.pRegion.left, (int)this.pRegion.top, (int)this.pRegion.width(), (int)this.pRegion.height()) : bitmap;
                this.bitmapIsPreview = true;
                if (!this.checkReady()) return;
                this.invalidate();
                this.requestLayout();
                return;
            }
            bitmap.recycle();
            return;
        }
    }

    private void onTileLoaded() {
        synchronized (this) {
            this.debug("onTileLoaded", new Object[0]);
            this.checkReady();
            this.checkImageLoaded();
            if (this.isBaseLayerReady() && this.bitmap != null) {
                if (!this.bitmapIsCached) {
                    this.bitmap.recycle();
                }
                this.bitmap = null;
                if (this.onImageEventListener != null && this.bitmapIsCached) {
                    this.onImageEventListener.onPreviewReleased();
                }
                this.bitmapIsPreview = false;
                this.bitmapIsCached = false;
            }
            this.invalidate();
            return;
        }
    }

    private void onTilesInited(ImageRegionDecoder imageRegionDecoder, int n, int n2, int n3) {
        synchronized (this) {
            this.debug("onTilesInited sWidth=%d, sHeight=%d, sOrientation=%d", n, n2, this.orientation);
            if (this.sWidth > 0 && this.sHeight > 0 && (this.sWidth != n || this.sHeight != n2)) {
                this.reset(false);
                if (this.bitmap != null) {
                    if (!this.bitmapIsCached) {
                        this.bitmap.recycle();
                    }
                    this.bitmap = null;
                    if (this.onImageEventListener != null && this.bitmapIsCached) {
                        this.onImageEventListener.onPreviewReleased();
                    }
                    this.bitmapIsPreview = false;
                    this.bitmapIsCached = false;
                }
            }
            this.decoder = imageRegionDecoder;
            this.sWidth = n;
            this.sHeight = n2;
            this.sOrientation = n3;
            this.checkReady();
            if (!this.checkImageLoaded() && this.maxTileWidth > 0 && this.maxTileWidth != TILE_SIZE_AUTO && this.maxTileHeight > 0 && this.maxTileHeight != TILE_SIZE_AUTO && this.getWidth() > 0 && this.getHeight() > 0) {
                imageRegionDecoder = new Point(this.maxTileWidth, this.maxTileHeight);
                this.initialiseBaseLayer((Point)imageRegionDecoder);
            }
            this.invalidate();
            this.requestLayout();
            return;
        }
    }

    /*
     * Unable to fully structure code
     */
    private boolean onTouchEventInternal(MotionEvent var1_1) {
        block29: {
            block30: {
                block37: {
                    block39: {
                        block40: {
                            block41: {
                                block38: {
                                    block32: {
                                        block34: {
                                            block35: {
                                                block36: {
                                                    block33: {
                                                        block31: {
                                                            var16_2 = var1_1.getPointerCount();
                                                            var17_3 = var1_1.getAction();
                                                            if (var17_3 == 0) break block29;
                                                            if (var17_3 == 1) break block30;
                                                            if (var17_3 == 2) break block31;
                                                            if (var17_3 == 5) break block29;
                                                            if (var17_3 == 6) break block30;
                                                            if (var17_3 == 261) break block29;
                                                            if (var17_3 != 262) {
                                                                return false;
                                                            }
                                                            break block30;
                                                        }
                                                        if (this.maxTouchCount <= 0) ** GOTO lbl-1000
                                                        if (var16_2 < 2) break block32;
                                                        var6_4 = this.distance(var1_1.getX(0), var1_1.getX(1), var1_1.getY(0), var1_1.getY(1));
                                                        var7_8 = (var1_1.getX(0) + var1_1.getX(1)) / 2.0f;
                                                        var8_11 = (var1_1.getY(0) + var1_1.getY(1)) / 2.0f;
                                                        if (!this.zoomEnabled || !(this.distance(this.vCenterStart.x, var7_8, this.vCenterStart.y, var8_11) > 5.0f) && !(Math.abs(var6_4 - this.vDistStart) > 5.0f) && !this.isPanning) ** GOTO lbl-1000
                                                        this.isZooming = true;
                                                        this.isPanning = true;
                                                        var2_14 = this.scale;
                                                        this.scale = var9_16 = Math.min(this.maxScale, var6_4 / this.vDistStart * this.scaleStart);
                                                        if (!(var9_16 <= this.minScale())) break block33;
                                                        this.vDistStart = var6_4;
                                                        this.scaleStart = this.minScale();
                                                        this.vCenterStart.set(var7_8, var8_11);
                                                        this.vTranslateStart.set(this.vTranslate);
                                                        break block34;
                                                    }
                                                    if (!this.panEnabled) break block35;
                                                    var11_19 = this.vCenterStart.x;
                                                    var12_21 = this.vTranslateStart.x;
                                                    var10_23 = this.vCenterStart.y;
                                                    var13_26 = this.vTranslateStart.y;
                                                    var15_28 = this.scale;
                                                    var14_29 = this.scaleStart;
                                                    var9_16 = var15_28 / var14_29;
                                                    var14_29 = var15_28 / var14_29;
                                                    this.vTranslate.x = var7_8 - (var11_19 - var12_21) * var9_16;
                                                    this.vTranslate.y = var8_11 - (var10_23 - var13_26) * var14_29;
                                                    var4_30 = this.sHeight();
                                                    Double.isNaN(var2_14);
                                                    Double.isNaN(var4_30);
                                                    if (var4_30 * var2_14 < (double)this.getHeight() && this.scale * (float)this.sHeight() >= (float)this.getHeight()) break block36;
                                                    var4_30 = this.sWidth();
                                                    Double.isNaN(var2_14);
                                                    Double.isNaN(var4_30);
                                                    if (!(var2_14 * var4_30 < (double)this.getWidth()) || !(this.scale * (float)this.sWidth() >= (float)this.getWidth())) break block34;
                                                }
                                                this.fitToBounds(true);
                                                this.vCenterStart.set(var7_8, var8_11);
                                                this.vTranslateStart.set(this.vTranslate);
                                                this.scaleStart = this.scale;
                                                this.vDistStart = var6_4;
                                                break block34;
                                            }
                                            if (this.sRequestedCenter != null) {
                                                this.vTranslate.x = (float)(this.getWidth() / 2) - this.scale * this.sRequestedCenter.x;
                                                this.vTranslate.y = (float)(this.getHeight() / 2) - this.scale * this.sRequestedCenter.y;
                                            } else {
                                                this.vTranslate.x = (float)(this.getWidth() / 2) - this.scale * (float)(this.sWidth() / 2);
                                                this.vTranslate.y = (float)(this.getHeight() / 2) - this.scale * (float)(this.sHeight() / 2);
                                            }
                                        }
                                        this.fitToBounds(true);
                                        this.refreshRequiredTiles(false);
                                        ** GOTO lbl168
                                    }
                                    if (!this.isQuickScaling) break block37;
                                    var7_9 = Math.abs(this.quickScaleVStart.y - var1_1.getY()) * 2.0f + this.quickScaleThreshold;
                                    if (this.quickScaleLastDistance == -1.0f) {
                                        this.quickScaleLastDistance = var7_9;
                                    }
                                    var16_2 = var1_1.getY() > this.quickScaleVLastPoint.y ? 1 : 0;
                                    this.quickScaleVLastPoint.set(0.0f, var1_1.getY());
                                    var6_5 = var7_9 / this.quickScaleLastDistance;
                                    var8_12 = 1.0f;
                                    var9_17 = Math.abs(1.0f - var6_5) * 0.5f;
                                    if (var9_17 > 0.03f) break block38;
                                    var6_5 = var7_9;
                                    if (!this.quickScaleMoved) break block39;
                                }
                                this.quickScaleMoved = true;
                                var6_5 = var8_12;
                                if (this.quickScaleLastDistance > 0.0f) {
                                    var6_5 = var16_2 != 0 ? var9_17 + 1.0f : 1.0f - var9_17;
                                }
                                var2_15 = this.scale;
                                this.scale = Math.max(this.minScale(), Math.min(this.maxScale, this.scale * var6_5));
                                if (!this.panEnabled) break block40;
                                var9_17 = this.vCenterStart.x;
                                var11_20 = this.vTranslateStart.x;
                                var10_24 = this.vCenterStart.y;
                                var6_5 = this.vTranslateStart.y;
                                var13_27 = this.scale;
                                var12_22 = this.scaleStart;
                                var8_12 = var13_27 / var12_22;
                                var12_22 = var13_27 / var12_22;
                                this.vTranslate.x = this.vCenterStart.x - (var9_17 - var11_20) * var8_12;
                                this.vTranslate.y = this.vCenterStart.y - (var10_24 - var6_5) * var12_22;
                                var4_31 = this.sHeight();
                                Double.isNaN(var2_15);
                                Double.isNaN(var4_31);
                                if (var4_31 * var2_15 < (double)this.getHeight() && this.scale * (float)this.sHeight() >= (float)this.getHeight()) break block41;
                                var4_31 = this.sWidth();
                                Double.isNaN(var2_15);
                                Double.isNaN(var4_31);
                                var6_5 = var7_9;
                                if (!(var2_15 * var4_31 < (double)this.getWidth())) break block39;
                                var6_5 = var7_9;
                                if (!(this.scale * (float)this.sWidth() >= (float)this.getWidth())) break block39;
                            }
                            this.fitToBounds(true);
                            this.vCenterStart.set(this.sourceToViewCoord(this.quickScaleSCenter));
                            this.vTranslateStart.set(this.vTranslate);
                            this.scaleStart = this.scale;
                            var6_5 = 0.0f;
                            break block39;
                        }
                        if (this.sRequestedCenter != null) {
                            this.vTranslate.x = (float)(this.getWidth() / 2) - this.scale * this.sRequestedCenter.x;
                            this.vTranslate.y = (float)(this.getHeight() / 2) - this.scale * this.sRequestedCenter.y;
                            var6_5 = var7_9;
                        } else {
                            this.vTranslate.x = (float)(this.getWidth() / 2) - this.scale * (float)(this.sWidth() / 2);
                            this.vTranslate.y = (float)(this.getHeight() / 2) - this.scale * (float)(this.sHeight() / 2);
                            var6_5 = var7_9;
                        }
                    }
                    this.quickScaleLastDistance = var6_5;
                    this.fitToBounds(true);
                    this.refreshRequiredTiles(false);
                    ** GOTO lbl168
                }
                if (this.isZooming) ** GOTO lbl-1000
                var6_6 = Math.abs(var1_1.getX() - this.vCenterStart.x);
                var8_13 = Math.abs(var1_1.getY() - this.vCenterStart.y);
                var9_18 = this.density * 5.0f;
                if (var6_6 > var9_18 || var8_13 > var9_18 || this.isPanning) {
                    this.vTranslate.x = this.vTranslateStart.x + (var1_1.getX() - this.vCenterStart.x);
                    this.vTranslate.y = this.vTranslateStart.y + (var1_1.getY() - this.vCenterStart.y);
                    var10_25 = this.vTranslate.x;
                    var7_10 = this.vTranslate.y;
                    this.fitToBounds(true);
                    var16_2 = var10_25 != this.vTranslate.x ? 1 : 0;
                    var17_3 = var7_10 != this.vTranslate.y ? 1 : 0;
                    var18_32 = var16_2 != 0 && var6_6 > var8_13 && this.isPanning == false;
                    var19_33 = var17_3 != 0 && var8_13 > var6_6 && this.isPanning == false;
                    var20_34 = var7_10 == this.vTranslate.y && var8_13 > 3.0f * var9_18;
                    if (!var18_32 && !var19_33 && (var16_2 == 0 || var17_3 == 0 || var20_34 || this.isPanning)) {
                        this.isPanning = true;
                    } else if (var6_6 > var9_18 || var8_13 > var9_18) {
                        this.maxTouchCount = 0;
                        this.handler.removeMessages(1);
                        this.requestDisallowInterceptTouchEvent(false);
                    }
                    if (!this.panEnabled) {
                        this.vTranslate.x = this.vTranslateStart.x;
                        this.vTranslate.y = this.vTranslateStart.y;
                        this.requestDisallowInterceptTouchEvent(false);
                    }
                    this.refreshRequiredTiles(false);
lbl168:
                    // 3 sources

                    var16_2 = 1;
                } else lbl-1000:
                // 4 sources

                {
                    var16_2 = 0;
                }
                if (var16_2 == 0) return false;
                this.handler.removeMessages(1);
                this.invalidate();
                return true;
            }
            this.handler.removeMessages(1);
            if (this.isQuickScaling) {
                this.isQuickScaling = false;
                if (!this.quickScaleMoved) {
                    this.doubleTapZoom(this.quickScaleSCenter, this.vCenterStart);
                }
            }
            if (this.maxTouchCount > 0 && (this.isZooming || this.isPanning)) {
                if (this.isZooming && var16_2 == 2) {
                    this.isPanning = true;
                    this.vTranslateStart.set(this.vTranslate.x, this.vTranslate.y);
                    if (var1_1.getActionIndex() == 1) {
                        this.vCenterStart.set(var1_1.getX(0), var1_1.getY(0));
                    } else {
                        this.vCenterStart.set(var1_1.getX(1), var1_1.getY(1));
                    }
                }
                if (var16_2 < 3) {
                    this.isZooming = false;
                }
                if (var16_2 < 2) {
                    this.isPanning = false;
                    this.maxTouchCount = 0;
                }
                this.refreshRequiredTiles(true);
                return true;
            }
            if (var16_2 != 1) return true;
            this.isZooming = false;
            this.isPanning = false;
            this.maxTouchCount = 0;
            return true;
        }
        this.anim = null;
        this.requestDisallowInterceptTouchEvent(true);
        this.maxTouchCount = Math.max(this.maxTouchCount, var16_2);
        if (var16_2 >= 2) {
            if (this.zoomEnabled) {
                var6_7 = this.distance(var1_1.getX(0), var1_1.getX(1), var1_1.getY(0), var1_1.getY(1));
                this.scaleStart = this.scale;
                this.vDistStart = var6_7;
                this.vTranslateStart.set(this.vTranslate.x, this.vTranslate.y);
                this.vCenterStart.set((var1_1.getX(0) + var1_1.getX(1)) / 2.0f, (var1_1.getY(0) + var1_1.getY(1)) / 2.0f);
            } else {
                this.maxTouchCount = 0;
            }
            this.handler.removeMessages(1);
        } else {
            if (this.isQuickScaling != false) return true;
            this.vTranslateStart.set(this.vTranslate.x, this.vTranslate.y);
            this.vCenterStart.set(var1_1.getX(), var1_1.getY());
            this.handler.sendEmptyMessageDelayed(1, 600L);
        }
        return true;
    }

    private void preDraw() {
        Float f;
        if (this.getWidth() == 0) return;
        if (this.getHeight() == 0) return;
        if (this.sWidth <= 0) return;
        if (this.sHeight <= 0) return;
        if (this.sPendingCenter != null && (f = this.pendingScale) != null) {
            this.scale = f.floatValue();
            if (this.vTranslate == null) {
                this.vTranslate = new PointF();
            }
            this.vTranslate.x = (float)(this.getWidth() / 2) - this.scale * this.sPendingCenter.x;
            this.vTranslate.y = (float)(this.getHeight() / 2) - this.scale * this.sPendingCenter.y;
            this.sPendingCenter = null;
            this.pendingScale = null;
            this.fitToBounds(true);
            this.refreshRequiredTiles(true);
        }
        this.fitToBounds(false);
    }

    private void refreshRequiredTiles(boolean bl) {
        if (this.decoder == null) return;
        if (this.tileMap == null) {
            return;
        }
        int n = Math.min(this.fullImageSampleSize, this.calculateInSampleSize(this.scale));
        Iterator<Map.Entry<Integer, List<Tile>>> iterator = this.tileMap.entrySet().iterator();
        block0: while (iterator.hasNext()) {
            Iterator<Tile> iterator2 = iterator.next().getValue().iterator();
            while (true) {
                if (!iterator2.hasNext()) continue block0;
                Tile tile = iterator2.next();
                if (Tile.access$4300((Tile)tile) < n || Tile.access$4300((Tile)tile) > n && Tile.access$4300((Tile)tile) != this.fullImageSampleSize) {
                    Tile.access$402((Tile)tile, (boolean)false);
                    if (Tile.access$500((Tile)tile) != null) {
                        Tile.access$500((Tile)tile).recycle();
                        Tile.access$502((Tile)tile, null);
                    }
                }
                if (Tile.access$4300((Tile)tile) == n) {
                    if (this.tileVisible(tile)) {
                        Tile.access$402((Tile)tile, (boolean)true);
                        if (Tile.access$4000((Tile)tile) || Tile.access$500((Tile)tile) != null || !bl) continue;
                        this.execute((AsyncTask<Void, Void, ?>)new TileLoadTask(this, this.decoder, tile));
                        continue;
                    }
                    if (Tile.access$4300((Tile)tile) == this.fullImageSampleSize) continue;
                    Tile.access$402((Tile)tile, (boolean)false);
                    if (Tile.access$500((Tile)tile) == null) continue;
                    Tile.access$500((Tile)tile).recycle();
                    Tile.access$502((Tile)tile, null);
                    continue;
                }
                if (Tile.access$4300((Tile)tile) != this.fullImageSampleSize) continue;
                Tile.access$402((Tile)tile, (boolean)true);
            }
            break;
        }
        return;
    }

    private void requestDisallowInterceptTouchEvent(boolean bl) {
        ViewParent viewParent = this.getParent();
        if (viewParent == null) return;
        viewParent.requestDisallowInterceptTouchEvent(bl);
    }

    private void reset(boolean bl) {
        OnImageEventListener onImageEventListener = new StringBuilder();
        onImageEventListener.append("reset newImage=");
        onImageEventListener.append(bl);
        this.debug(onImageEventListener.toString(), new Object[0]);
        this.scale = 0.0f;
        this.scaleStart = 0.0f;
        this.vTranslate = null;
        this.vTranslateStart = null;
        this.vTranslateBefore = null;
        this.pendingScale = Float.valueOf(0.0f);
        this.sPendingCenter = null;
        this.sRequestedCenter = null;
        this.isZooming = false;
        this.isPanning = false;
        this.isQuickScaling = false;
        this.maxTouchCount = 0;
        this.fullImageSampleSize = 0;
        this.vCenterStart = null;
        this.vDistStart = 0.0f;
        this.quickScaleLastDistance = 0.0f;
        this.quickScaleMoved = false;
        this.quickScaleSCenter = null;
        this.quickScaleVLastPoint = null;
        this.quickScaleVStart = null;
        this.anim = null;
        this.satTemp = null;
        this.matrix = null;
        this.sRect = null;
        if (bl) {
            this.uri = null;
            if (this.decoder != null) {
                Iterator iterator = this.decoderLock;
                synchronized (iterator) {
                    this.decoder.recycle();
                    this.decoder = null;
                }
            }
            if ((onImageEventListener = this.bitmap) != null && !this.bitmapIsCached) {
                onImageEventListener.recycle();
            }
            if (this.bitmap != null && this.bitmapIsCached && (onImageEventListener = this.onImageEventListener) != null) {
                onImageEventListener.onPreviewReleased();
            }
            this.sWidth = 0;
            this.sHeight = 0;
            this.sOrientation = 0;
            this.sRegion = null;
            this.pRegion = null;
            this.readySent = false;
            this.imageLoadedSent = false;
            this.bitmap = null;
            this.bitmapIsPreview = false;
            this.bitmapIsCached = false;
        }
        if ((onImageEventListener = this.tileMap) != null) {
            onImageEventListener = onImageEventListener.entrySet().iterator();
            while (onImageEventListener.hasNext()) {
                for (Tile tile : (List)onImageEventListener.next().getValue()) {
                    Tile.access$402((Tile)tile, (boolean)false);
                    if (Tile.access$500((Tile)tile) == null) continue;
                    Tile.access$500((Tile)tile).recycle();
                    Tile.access$502((Tile)tile, null);
                }
            }
            this.tileMap = null;
        }
        this.setGestureDetector(this.getContext());
    }

    private void restoreState(ImageViewState imageViewState) {
        if (imageViewState == null) return;
        if (imageViewState.getCenter() == null) return;
        if (!VALID_ORIENTATIONS.contains(imageViewState.getOrientation())) return;
        this.orientation = imageViewState.getOrientation();
        this.pendingScale = Float.valueOf(imageViewState.getScale());
        this.sPendingCenter = imageViewState.getCenter();
        this.invalidate();
    }

    private int sHeight() {
        int n = this.getRequiredRotation();
        if (n == 90) return this.sWidth;
        if (n != 270) return this.sHeight;
        return this.sWidth;
    }

    private int sWidth() {
        int n = this.getRequiredRotation();
        if (n == 90) return this.sHeight;
        if (n != 270) return this.sWidth;
        return this.sHeight;
    }

    private void sendStateChanged(float f, PointF pointF, int n) {
        OnStateChangedListener onStateChangedListener = this.onStateChangedListener;
        if (onStateChangedListener == null) return;
        float f2 = this.scale;
        if (f2 != f) {
            onStateChangedListener.onScaleChanged(f2, n);
        }
        if (this.vTranslate.equals((Object)pointF)) return;
        this.onStateChangedListener.onCenterChanged(this.getCenter(), n);
    }

    private void setGestureDetector(Context context) {
        this.detector = new GestureDetector(context, (GestureDetector.OnGestureListener)new /* Unavailable Anonymous Inner Class!! */);
    }

    private void setMatrixArray(float[] fArray, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        fArray[0] = f;
        fArray[1] = f2;
        fArray[2] = f3;
        fArray[3] = f4;
        fArray[4] = f5;
        fArray[5] = f6;
        fArray[6] = f7;
        fArray[7] = f8;
    }

    private Rect sourceToViewRect(Rect rect, Rect rect2) {
        rect2.set((int)this.sourceToViewX(rect.left), (int)this.sourceToViewY(rect.top), (int)this.sourceToViewX(rect.right), (int)this.sourceToViewY(rect.bottom));
        return rect2;
    }

    private float sourceToViewX(float f) {
        PointF pointF = this.vTranslate;
        if (pointF != null) return f * this.scale + pointF.x;
        return Float.NaN;
    }

    private float sourceToViewY(float f) {
        PointF pointF = this.vTranslate;
        if (pointF != null) return f * this.scale + pointF.y;
        return Float.NaN;
    }

    private boolean tileVisible(Tile tile) {
        float f = this.viewToSourceX(0.0f);
        float f2 = this.viewToSourceX(this.getWidth());
        float f3 = this.viewToSourceY(0.0f);
        float f4 = this.viewToSourceY(this.getHeight());
        boolean bl = !(f > (float)Tile.access$4100((Tile)tile).right || (float)Tile.access$4100((Tile)tile).left > f2 || f3 > (float)Tile.access$4100((Tile)tile).bottom || (float)Tile.access$4100((Tile)tile).top > f4);
        return bl;
    }

    private PointF vTranslateForSCenter(float f, float f2, float f3) {
        int n = this.getPaddingLeft();
        int n2 = (this.getWidth() - this.getPaddingRight() - this.getPaddingLeft()) / 2;
        int n3 = this.getPaddingTop();
        int n4 = (this.getHeight() - this.getPaddingBottom() - this.getPaddingTop()) / 2;
        if (this.satTemp == null) {
            this.satTemp = new ScaleAndTranslate(0.0f, new PointF(0.0f, 0.0f), null);
        }
        ScaleAndTranslate.access$4702((ScaleAndTranslate)this.satTemp, (float)f3);
        ScaleAndTranslate.access$4800((ScaleAndTranslate)this.satTemp).set((float)(n + n2) - f * f3, (float)(n3 + n4) - f2 * f3);
        this.fitToBounds(true, this.satTemp);
        return ScaleAndTranslate.access$4800((ScaleAndTranslate)this.satTemp);
    }

    private float viewToSourceX(float f) {
        PointF pointF = this.vTranslate;
        if (pointF != null) return (f - pointF.x) / this.scale;
        return Float.NaN;
    }

    private float viewToSourceY(float f) {
        PointF pointF = this.vTranslate;
        if (pointF != null) return (f - pointF.y) / this.scale;
        return Float.NaN;
    }

    public AnimationBuilder animateCenter(PointF pointF) {
        if (this.isReady()) return new AnimationBuilder(this, pointF, null);
        return null;
    }

    public AnimationBuilder animateScale(float f) {
        if (this.isReady()) return new AnimationBuilder(this, f, null);
        return null;
    }

    public AnimationBuilder animateScaleAndCenter(float f, PointF pointF) {
        if (this.isReady()) return new AnimationBuilder(this, f, pointF, null);
        return null;
    }

    public final int getAppliedOrientation() {
        return this.getRequiredRotation();
    }

    public final PointF getCenter() {
        int n = this.getWidth() / 2;
        int n2 = this.getHeight() / 2;
        return this.viewToSourceCoord(n, n2);
    }

    public float getMaxScale() {
        return this.maxScale;
    }

    public final float getMinScale() {
        return this.minScale();
    }

    public final int getOrientation() {
        return this.orientation;
    }

    public final int getSHeight() {
        return this.sHeight;
    }

    public final int getSWidth() {
        return this.sWidth;
    }

    public final float getScale() {
        return this.scale;
    }

    public final ImageViewState getState() {
        if (this.vTranslate == null) return null;
        if (this.sWidth <= 0) return null;
        if (this.sHeight <= 0) return null;
        return new ImageViewState(this.getScale(), this.getCenter(), this.getOrientation());
    }

    public boolean hasImage() {
        boolean bl = this.uri != null || this.bitmap != null;
        return bl;
    }

    public final boolean isImageLoaded() {
        return this.imageLoadedSent;
    }

    public final boolean isPanEnabled() {
        return this.panEnabled;
    }

    public final boolean isQuickScaleEnabled() {
        return this.quickScaleEnabled;
    }

    public final boolean isReady() {
        return this.readySent;
    }

    public final boolean isZoomEnabled() {
        return this.zoomEnabled;
    }

    /*
     * Enabled force condition propagation
     */
    protected void onDraw(Canvas canvas) {
        PointF pointF;
        Object object32;
        Object object2;
        float f;
        float f2;
        super.onDraw(canvas);
        this.createPaints();
        if (this.sWidth == 0) return;
        if (this.sHeight == 0) return;
        if (this.getWidth() == 0) return;
        if (this.getHeight() == 0) {
            return;
        }
        if (this.tileMap == null && this.decoder != null) {
            this.initialiseBaseLayer(this.getMaxBitmapDimensions(canvas));
        }
        if (!this.checkReady()) {
            return;
        }
        this.preDraw();
        if (this.anim != null) {
            f2 = this.scale;
            if (this.vTranslateBefore == null) {
                this.vTranslateBefore = new PointF(0.0f, 0.0f);
            }
            this.vTranslateBefore.set(this.vTranslate);
            long l = System.currentTimeMillis() - Anim.access$3100((Anim)this.anim);
            boolean bl = l > Anim.access$3200((Anim)this.anim);
            l = Math.min(l, Anim.access$3200((Anim)this.anim));
            this.scale = this.ease(Anim.access$3300((Anim)this.anim), l, Anim.access$3400((Anim)this.anim), Anim.access$3500((Anim)this.anim) - Anim.access$3400((Anim)this.anim), Anim.access$3200((Anim)this.anim));
            f = this.ease(Anim.access$3300((Anim)this.anim), l, Anim.access$3600((Anim)this.anim).x, Anim.access$3700((Anim)this.anim).x - Anim.access$3600((Anim)this.anim).x, Anim.access$3200((Anim)this.anim));
            float f3 = this.ease(Anim.access$3300((Anim)this.anim), l, Anim.access$3600((Anim)this.anim).y, Anim.access$3700((Anim)this.anim).y - Anim.access$3600((Anim)this.anim).y, Anim.access$3200((Anim)this.anim));
            object2 = this.vTranslate;
            ((PointF)object2).x -= this.sourceToViewX(Anim.access$3800((Anim)this.anim).x) - f;
            object2 = this.vTranslate;
            ((PointF)object2).y -= this.sourceToViewY(Anim.access$3800((Anim)this.anim).y) - f3;
            boolean bl2 = bl || Anim.access$3400((Anim)this.anim) == Anim.access$3500((Anim)this.anim);
            this.fitToBounds(bl2);
            this.sendStateChanged(f2, this.vTranslateBefore, Anim.access$3900((Anim)this.anim));
            this.refreshRequiredTiles(bl);
            if (bl) {
                if (Anim.access$2800((Anim)this.anim) != null) {
                    try {
                        Anim.access$2800((Anim)this.anim).onComplete();
                    }
                    catch (Exception exception) {
                        Log.w((String)TAG, (String)"Error thrown by animation listener", (Throwable)exception);
                    }
                }
                this.anim = null;
            }
            this.invalidate();
        }
        if (this.tileMap == null || !this.isBaseLayerReady()) {
            object2 = this.bitmap;
            if (object2 != null) {
                f = this.scale;
                if (this.bitmapIsPreview) {
                    f *= (float)this.sWidth / (float)object2.getWidth();
                    f2 = this.scale * ((float)this.sHeight / (float)this.bitmap.getHeight());
                } else {
                    f2 = f;
                }
                if (this.matrix == null) {
                    this.matrix = new Matrix();
                }
                this.matrix.reset();
                this.matrix.postScale(f, f2);
                this.matrix.postRotate((float)this.getRequiredRotation());
                this.matrix.postTranslate(this.vTranslate.x, this.vTranslate.y);
                if (this.getRequiredRotation() == 180) {
                    object2 = this.matrix;
                    f = this.scale;
                    object2.postTranslate((float)this.sWidth * f, f * (float)this.sHeight);
                } else if (this.getRequiredRotation() == 90) {
                    this.matrix.postTranslate(this.scale * (float)this.sHeight, 0.0f);
                } else if (this.getRequiredRotation() == 270) {
                    this.matrix.postTranslate(0.0f, this.scale * (float)this.sWidth);
                }
                if (this.tileBgPaint != null) {
                    if (this.sRect == null) {
                        this.sRect = new RectF();
                    }
                    object2 = this.sRect;
                    int n = this.bitmapIsPreview ? this.bitmap.getWidth() : this.sWidth;
                    f = n;
                    n = this.bitmapIsPreview ? this.bitmap.getHeight() : this.sHeight;
                    object2.set(0.0f, 0.0f, f, (float)n);
                    this.matrix.mapRect(this.sRect);
                    canvas.drawRect(this.sRect, this.tileBgPaint);
                }
                canvas.drawBitmap(this.bitmap, this.matrix, this.bitmapPaint);
            }
        } else {
            int n = Math.min(this.fullImageSampleSize, this.calculateInSampleSize(this.scale));
            object2 = this.tileMap.entrySet().iterator();
            boolean bl = false;
            block2: while (object2.hasNext()) {
                object32 = (Map.Entry)object2.next();
                if ((Integer)object32.getKey() != n) continue;
                pointF = ((List)object32.getValue()).iterator();
                boolean bl3 = bl;
                while (true) {
                    bl = bl3;
                    if (!pointF.hasNext()) continue block2;
                    object32 = (Tile)pointF.next();
                    if (!Tile.access$400((Tile)object32) || !Tile.access$4000((Tile)object32) && Tile.access$500((Tile)object32) != null) continue;
                    bl3 = true;
                }
            }
            for (Object object32 : this.tileMap.entrySet()) {
                if ((Integer)object32.getKey() != n && !bl) continue;
                for (Object object32 : (List)object32.getValue()) {
                    this.sourceToViewRect(Tile.access$4100((Tile)object32), Tile.access$4200((Tile)object32));
                    if (!Tile.access$4000((Tile)object32) && Tile.access$500((Tile)object32) != null) {
                        if (this.tileBgPaint != null) {
                            canvas.drawRect(Tile.access$4200((Tile)object32), this.tileBgPaint);
                        }
                        if (this.matrix == null) {
                            this.matrix = new Matrix();
                        }
                        this.matrix.reset();
                        this.setMatrixArray(this.srcArray, 0.0f, 0.0f, Tile.access$500((Tile)object32).getWidth(), 0.0f, Tile.access$500((Tile)object32).getWidth(), Tile.access$500((Tile)object32).getHeight(), 0.0f, Tile.access$500((Tile)object32).getHeight());
                        if (this.getRequiredRotation() == 0) {
                            this.setMatrixArray(this.dstArray, Tile.access$4200((Tile)object32).left, Tile.access$4200((Tile)object32).top, Tile.access$4200((Tile)object32).right, Tile.access$4200((Tile)object32).top, Tile.access$4200((Tile)object32).right, Tile.access$4200((Tile)object32).bottom, Tile.access$4200((Tile)object32).left, Tile.access$4200((Tile)object32).bottom);
                        } else if (this.getRequiredRotation() == 90) {
                            this.setMatrixArray(this.dstArray, Tile.access$4200((Tile)object32).right, Tile.access$4200((Tile)object32).top, Tile.access$4200((Tile)object32).right, Tile.access$4200((Tile)object32).bottom, Tile.access$4200((Tile)object32).left, Tile.access$4200((Tile)object32).bottom, Tile.access$4200((Tile)object32).left, Tile.access$4200((Tile)object32).top);
                        } else if (this.getRequiredRotation() == 180) {
                            this.setMatrixArray(this.dstArray, Tile.access$4200((Tile)object32).right, Tile.access$4200((Tile)object32).bottom, Tile.access$4200((Tile)object32).left, Tile.access$4200((Tile)object32).bottom, Tile.access$4200((Tile)object32).left, Tile.access$4200((Tile)object32).top, Tile.access$4200((Tile)object32).right, Tile.access$4200((Tile)object32).top);
                        } else if (this.getRequiredRotation() == 270) {
                            this.setMatrixArray(this.dstArray, Tile.access$4200((Tile)object32).left, Tile.access$4200((Tile)object32).bottom, Tile.access$4200((Tile)object32).left, Tile.access$4200((Tile)object32).top, Tile.access$4200((Tile)object32).right, Tile.access$4200((Tile)object32).top, Tile.access$4200((Tile)object32).right, Tile.access$4200((Tile)object32).bottom);
                        }
                        this.matrix.setPolyToPoly(this.srcArray, 0, this.dstArray, 0, 4);
                        canvas.drawBitmap(Tile.access$500((Tile)object32), this.matrix, this.bitmapPaint);
                        if (this.debug) {
                            canvas.drawRect(Tile.access$4200((Tile)object32), this.debugPaint);
                        }
                    } else if (Tile.access$4000((Tile)object32) && this.debug) {
                        canvas.drawText("LOADING", (float)(Tile.access$4200((Tile)object32).left + 5), (float)(Tile.access$4200((Tile)object32).top + 35), this.debugPaint);
                    }
                    if (!Tile.access$400((Tile)object32) || !this.debug) continue;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("ISS ");
                    stringBuilder.append(Tile.access$4300((Tile)object32));
                    stringBuilder.append(" RECT ");
                    stringBuilder.append(Tile.access$4100((Tile)object32).top);
                    stringBuilder.append(",");
                    stringBuilder.append(Tile.access$4100((Tile)object32).left);
                    stringBuilder.append(",");
                    stringBuilder.append(Tile.access$4100((Tile)object32).bottom);
                    stringBuilder.append(",");
                    stringBuilder.append(Tile.access$4100((Tile)object32).right);
                    canvas.drawText(stringBuilder.toString(), (float)(Tile.access$4200((Tile)object32).left + 5), (float)(Tile.access$4200((Tile)object32).top + 15), this.debugPaint);
                }
            }
        }
        if (!this.debug) return;
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("Scale: ");
        ((StringBuilder)object2).append(String.format(Locale.ENGLISH, "%.2f", Float.valueOf(this.scale)));
        canvas.drawText(((StringBuilder)object2).toString(), 5.0f, 15.0f, this.debugPaint);
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("Translate: ");
        ((StringBuilder)object2).append(String.format(Locale.ENGLISH, "%.2f", Float.valueOf(this.vTranslate.x)));
        ((StringBuilder)object2).append(":");
        ((StringBuilder)object2).append(String.format(Locale.ENGLISH, "%.2f", Float.valueOf(this.vTranslate.y)));
        canvas.drawText(((StringBuilder)object2).toString(), 5.0f, 35.0f, this.debugPaint);
        object2 = this.getCenter();
        object32 = new StringBuilder();
        ((StringBuilder)object32).append("Source center: ");
        ((StringBuilder)object32).append(String.format(Locale.ENGLISH, "%.2f", Float.valueOf(((PointF)object2).x)));
        ((StringBuilder)object32).append(":");
        ((StringBuilder)object32).append(String.format(Locale.ENGLISH, "%.2f", Float.valueOf(((PointF)object2).y)));
        canvas.drawText(((StringBuilder)object32).toString(), 5.0f, 55.0f, this.debugPaint);
        this.debugPaint.setStrokeWidth(2.0f);
        object2 = this.anim;
        if (object2 != null) {
            object2 = this.sourceToViewCoord(Anim.access$4400((Anim)object2));
            object32 = this.sourceToViewCoord(Anim.access$4500((Anim)this.anim));
            pointF = this.sourceToViewCoord(Anim.access$3800((Anim)this.anim));
            canvas.drawCircle(((PointF)object2).x, ((PointF)object2).y, 10.0f, this.debugPaint);
            this.debugPaint.setColor(-65536);
            canvas.drawCircle(((PointF)object32).x, ((PointF)object32).y, 20.0f, this.debugPaint);
            this.debugPaint.setColor(-16776961);
            canvas.drawCircle(pointF.x, pointF.y, 25.0f, this.debugPaint);
            this.debugPaint.setColor(-16711681);
            canvas.drawCircle((float)(this.getWidth() / 2), (float)(this.getHeight() / 2), 30.0f, this.debugPaint);
        }
        if (this.vCenterStart != null) {
            this.debugPaint.setColor(-65536);
            canvas.drawCircle(this.vCenterStart.x, this.vCenterStart.y, 20.0f, this.debugPaint);
        }
        if (this.quickScaleSCenter != null) {
            this.debugPaint.setColor(-16776961);
            canvas.drawCircle(this.sourceToViewX(this.quickScaleSCenter.x), this.sourceToViewY(this.quickScaleSCenter.y), 35.0f, this.debugPaint);
        }
        if (this.quickScaleVStart != null) {
            this.debugPaint.setColor(-16711681);
            canvas.drawCircle(this.quickScaleVStart.x, this.quickScaleVStart.y, 30.0f, this.debugPaint);
        }
        this.debugPaint.setColor(-65281);
        this.debugPaint.setStrokeWidth(1.0f);
    }

    protected void onImageLoaded() {
    }

    protected void onMeasure(int n, int n2) {
        int n3 = View.MeasureSpec.getMode((int)n);
        int n4 = View.MeasureSpec.getMode((int)n2);
        int n5 = View.MeasureSpec.getSize((int)n);
        int n6 = View.MeasureSpec.getSize((int)n2);
        boolean bl = true;
        n3 = n3 != 0x40000000 ? 1 : 0;
        if (n4 == 0x40000000) {
            bl = false;
        }
        n = n5;
        n2 = n6;
        if (this.sWidth > 0) {
            n = n5;
            n2 = n6;
            if (this.sHeight > 0) {
                if (n3 != 0 && bl) {
                    n = this.sWidth();
                    n2 = this.sHeight();
                } else if (bl) {
                    double d = this.sHeight();
                    double d2 = this.sWidth();
                    Double.isNaN(d);
                    Double.isNaN(d2);
                    d2 = d / d2;
                    d = n5;
                    Double.isNaN(d);
                    n2 = (int)(d2 * d);
                    n = n5;
                } else {
                    n = n5;
                    n2 = n6;
                    if (n3 != 0) {
                        double d = this.sWidth();
                        double d3 = this.sHeight();
                        Double.isNaN(d);
                        Double.isNaN(d3);
                        d /= d3;
                        d3 = n6;
                        Double.isNaN(d3);
                        n = (int)(d * d3);
                        n2 = n6;
                    }
                }
            }
        }
        this.setMeasuredDimension(Math.max(n, this.getSuggestedMinimumWidth()), Math.max(n2, this.getSuggestedMinimumHeight()));
    }

    protected void onReady() {
    }

    protected void onSizeChanged(int n, int n2, int n3, int n4) {
        this.debug("onSizeChanged %dx%d -> %dx%d", n3, n4, n, n2);
        PointF pointF = this.getCenter();
        if (!this.readySent) return;
        if (pointF == null) return;
        this.anim = null;
        this.pendingScale = Float.valueOf(this.scale);
        this.sPendingCenter = pointF;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        Anim anim = this.anim;
        boolean bl = true;
        if (anim != null && !Anim.access$2700((Anim)anim)) {
            this.requestDisallowInterceptTouchEvent(true);
            return true;
        }
        anim = this.anim;
        if (anim != null && Anim.access$2800((Anim)anim) != null) {
            try {
                Anim.access$2800((Anim)this.anim).onInterruptedByUser();
            }
            catch (Exception exception) {
                Log.w((String)TAG, (String)"Error thrown by animation listener", (Throwable)exception);
            }
        }
        this.anim = null;
        if (this.vTranslate == null) {
            return true;
        }
        if (!this.isQuickScaling && ((anim = this.detector) == null || anim.onTouchEvent(motionEvent))) {
            this.isZooming = false;
            this.isPanning = false;
            this.maxTouchCount = 0;
            return true;
        }
        if (this.vTranslateStart == null) {
            this.vTranslateStart = new PointF(0.0f, 0.0f);
        }
        if (this.vTranslateBefore == null) {
            this.vTranslateBefore = new PointF(0.0f, 0.0f);
        }
        if (this.vCenterStart == null) {
            this.vCenterStart = new PointF(0.0f, 0.0f);
        }
        float f = this.scale;
        this.vTranslateBefore.set(this.vTranslate);
        boolean bl2 = this.onTouchEventInternal(motionEvent);
        this.sendStateChanged(f, this.vTranslateBefore, 2);
        boolean bl3 = bl;
        if (bl2) return bl3;
        bl3 = super.onTouchEvent(motionEvent) ? bl : false;
        return bl3;
    }

    public void recycle() {
        this.reset(true);
        this.bitmapPaint = null;
        this.debugPaint = null;
        this.tileBgPaint = null;
    }

    public final void resetScaleAndCenter() {
        this.anim = null;
        this.pendingScale = Float.valueOf(this.limitedScale(0.0f));
        this.sPendingCenter = this.isReady() ? new PointF((float)(this.sWidth() / 2), (float)(this.sHeight() / 2)) : new PointF(0.0f, 0.0f);
        this.invalidate();
    }

    public final void setBitmapDecoderClass(Class<? extends ImageDecoder> clazz) {
        if (clazz == null) throw new IllegalArgumentException("Decoder class cannot be set to null");
        this.bitmapDecoderFactory = new CompatDecoderFactory(clazz);
    }

    public final void setBitmapDecoderFactory(DecoderFactory<? extends ImageDecoder> decoderFactory) {
        if (decoderFactory == null) throw new IllegalArgumentException("Decoder factory cannot be set to null");
        this.bitmapDecoderFactory = decoderFactory;
    }

    public final void setDebug(boolean bl) {
        this.debug = bl;
    }

    public final void setDoubleTapZoomDpi(int n) {
        DisplayMetrics displayMetrics = this.getResources().getDisplayMetrics();
        this.setDoubleTapZoomScale((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f / (float)n);
    }

    public final void setDoubleTapZoomDuration(int n) {
        this.doubleTapZoomDuration = Math.max(0, n);
    }

    public final void setDoubleTapZoomScale(float f) {
        this.doubleTapZoomScale = f;
    }

    public final void setDoubleTapZoomStyle(int n) {
        if (VALID_ZOOM_STYLES.contains(n)) {
            this.doubleTapZoomStyle = n;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Invalid zoom style: ");
        stringBuilder.append(n);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public final void setImage(ImageSource imageSource) {
        this.setImage(imageSource, null, null);
    }

    public final void setImage(ImageSource imageSource, ImageSource imageSource2) {
        this.setImage(imageSource, imageSource2, null);
    }

    public final void setImage(ImageSource imageSource, ImageSource object, ImageViewState object2) {
        if (imageSource == null) throw new NullPointerException("imageSource must not be null");
        this.reset(true);
        if (object2 != null) {
            this.restoreState((ImageViewState)object2);
        }
        if (object != null) {
            if (imageSource.getBitmap() != null) throw new IllegalArgumentException("Preview image cannot be used when a bitmap is provided for the main image");
            if (imageSource.getSWidth() <= 0) throw new IllegalArgumentException("Preview image cannot be used unless dimensions are provided for the main image");
            if (imageSource.getSHeight() <= 0) throw new IllegalArgumentException("Preview image cannot be used unless dimensions are provided for the main image");
            this.sWidth = imageSource.getSWidth();
            this.sHeight = imageSource.getSHeight();
            this.pRegion = object.getSRegion();
            if (object.getBitmap() != null) {
                this.bitmapIsCached = object.isCached();
                this.onPreviewLoaded(object.getBitmap());
            } else {
                Uri uri = object.getUri();
                object2 = uri;
                if (uri == null) {
                    object2 = uri;
                    if (object.getResource() != null) {
                        object2 = new StringBuilder();
                        ((StringBuilder)object2).append("android.resource://");
                        ((StringBuilder)object2).append(this.getContext().getPackageName());
                        ((StringBuilder)object2).append("/");
                        ((StringBuilder)object2).append(object.getResource());
                        object2 = Uri.parse((String)((StringBuilder)object2).toString());
                    }
                }
                this.execute((AsyncTask<Void, Void, ?>)new BitmapLoadTask(this, this.getContext(), this.bitmapDecoderFactory, (Uri)object2, true));
            }
        }
        if (imageSource.getBitmap() != null && imageSource.getSRegion() != null) {
            this.onImageLoaded(Bitmap.createBitmap((Bitmap)imageSource.getBitmap(), (int)imageSource.getSRegion().left, (int)imageSource.getSRegion().top, (int)imageSource.getSRegion().width(), (int)imageSource.getSRegion().height()), 0, false);
        } else if (imageSource.getBitmap() != null) {
            this.onImageLoaded(imageSource.getBitmap(), 0, imageSource.isCached());
        } else {
            this.sRegion = imageSource.getSRegion();
            object = imageSource.getUri();
            this.uri = object;
            if (object == null && imageSource.getResource() != null) {
                object = new StringBuilder();
                ((StringBuilder)object).append("android.resource://");
                ((StringBuilder)object).append(this.getContext().getPackageName());
                ((StringBuilder)object).append("/");
                ((StringBuilder)object).append(imageSource.getResource());
                this.uri = Uri.parse((String)((StringBuilder)object).toString());
            }
            if (!imageSource.getTile() && this.sRegion == null) {
                this.execute((AsyncTask<Void, Void, ?>)new BitmapLoadTask(this, this.getContext(), this.bitmapDecoderFactory, this.uri, false));
            } else {
                this.execute((AsyncTask<Void, Void, ?>)new TilesInitTask(this, this.getContext(), this.regionDecoderFactory, this.uri));
            }
        }
    }

    public final void setImage(ImageSource imageSource, ImageViewState imageViewState) {
        this.setImage(imageSource, null, imageViewState);
    }

    public final void setMaxScale(float f) {
        this.maxScale = f;
    }

    public void setMaxTileSize(int n) {
        this.maxTileWidth = n;
        this.maxTileHeight = n;
    }

    public void setMaxTileSize(int n, int n2) {
        this.maxTileWidth = n;
        this.maxTileHeight = n2;
    }

    public final void setMaximumDpi(int n) {
        DisplayMetrics displayMetrics = this.getResources().getDisplayMetrics();
        this.setMinScale((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f / (float)n);
    }

    public final void setMinScale(float f) {
        this.minScale = f;
    }

    public final void setMinimumDpi(int n) {
        DisplayMetrics displayMetrics = this.getResources().getDisplayMetrics();
        this.setMaxScale((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f / (float)n);
    }

    public final void setMinimumScaleType(int n) {
        if (VALID_SCALE_TYPES.contains(n)) {
            this.minimumScaleType = n;
            if (!this.isReady()) return;
            this.fitToBounds(true);
            this.invalidate();
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Invalid scale type: ");
        stringBuilder.append(n);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public void setMinimumTileDpi(int n) {
        DisplayMetrics displayMetrics = this.getResources().getDisplayMetrics();
        this.minimumTileDpi = (int)Math.min((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f, (float)n);
        if (!this.isReady()) return;
        this.reset(false);
        this.invalidate();
    }

    public void setOnImageEventListener(OnImageEventListener onImageEventListener) {
        this.onImageEventListener = onImageEventListener;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
    }

    public void setOnStateChangedListener(OnStateChangedListener onStateChangedListener) {
        this.onStateChangedListener = onStateChangedListener;
    }

    public final void setOrientation(int n) {
        if (VALID_ORIENTATIONS.contains(n)) {
            this.orientation = n;
            this.reset(false);
            this.invalidate();
            this.requestLayout();
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Invalid orientation: ");
        stringBuilder.append(n);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public final void setPanEnabled(boolean bl) {
        this.panEnabled = bl;
        if (bl) return;
        PointF pointF = this.vTranslate;
        if (pointF == null) return;
        pointF.x = (float)(this.getWidth() / 2) - this.scale * (float)(this.sWidth() / 2);
        this.vTranslate.y = (float)(this.getHeight() / 2) - this.scale * (float)(this.sHeight() / 2);
        if (!this.isReady()) return;
        this.refreshRequiredTiles(true);
        this.invalidate();
    }

    public final void setPanLimit(int n) {
        if (VALID_PAN_LIMITS.contains(n)) {
            this.panLimit = n;
            if (!this.isReady()) return;
            this.fitToBounds(true);
            this.invalidate();
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Invalid pan limit: ");
        stringBuilder.append(n);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public void setParallelLoadingEnabled(boolean bl) {
        this.parallelLoadingEnabled = bl;
    }

    public final void setQuickScaleEnabled(boolean bl) {
        this.quickScaleEnabled = bl;
    }

    public final void setRegionDecoderClass(Class<? extends ImageRegionDecoder> clazz) {
        if (clazz == null) throw new IllegalArgumentException("Decoder class cannot be set to null");
        this.regionDecoderFactory = new CompatDecoderFactory(clazz);
    }

    public final void setRegionDecoderFactory(DecoderFactory<? extends ImageRegionDecoder> decoderFactory) {
        if (decoderFactory == null) throw new IllegalArgumentException("Decoder factory cannot be set to null");
        this.regionDecoderFactory = decoderFactory;
    }

    public final void setScaleAndCenter(float f, PointF pointF) {
        this.anim = null;
        this.pendingScale = Float.valueOf(f);
        this.sPendingCenter = pointF;
        this.sRequestedCenter = pointF;
        this.invalidate();
    }

    public final void setTileBackgroundColor(int n) {
        if (Color.alpha((int)n) == 0) {
            this.tileBgPaint = null;
        } else {
            Paint paint;
            this.tileBgPaint = paint = new Paint();
            paint.setStyle(Paint.Style.FILL);
            this.tileBgPaint.setColor(n);
        }
        this.invalidate();
    }

    public final void setZoomEnabled(boolean bl) {
        this.zoomEnabled = bl;
    }

    public final PointF sourceToViewCoord(float f, float f2) {
        return this.sourceToViewCoord(f, f2, new PointF());
    }

    public final PointF sourceToViewCoord(float f, float f2, PointF pointF) {
        if (this.vTranslate == null) {
            return null;
        }
        pointF.set(this.sourceToViewX(f), this.sourceToViewY(f2));
        return pointF;
    }

    public final PointF sourceToViewCoord(PointF pointF) {
        return this.sourceToViewCoord(pointF.x, pointF.y, new PointF());
    }

    public final PointF sourceToViewCoord(PointF pointF, PointF pointF2) {
        return this.sourceToViewCoord(pointF.x, pointF.y, pointF2);
    }

    public final PointF viewToSourceCoord(float f, float f2) {
        return this.viewToSourceCoord(f, f2, new PointF());
    }

    public final PointF viewToSourceCoord(float f, float f2, PointF pointF) {
        if (this.vTranslate == null) {
            return null;
        }
        pointF.set(this.viewToSourceX(f), this.viewToSourceY(f2));
        return pointF;
    }

    public final PointF viewToSourceCoord(PointF pointF) {
        return this.viewToSourceCoord(pointF.x, pointF.y, new PointF());
    }

    public final PointF viewToSourceCoord(PointF pointF, PointF pointF2) {
        return this.viewToSourceCoord(pointF.x, pointF.y, pointF2);
    }
}
