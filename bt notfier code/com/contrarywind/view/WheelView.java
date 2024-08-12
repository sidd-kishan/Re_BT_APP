/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  android.graphics.Rect
 *  android.graphics.Typeface
 *  android.os.Handler
 *  android.text.TextUtils
 *  android.util.Log
 *  android.view.GestureDetector
 *  android.view.GestureDetector$OnGestureListener
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  com.contrarywind.adapter.WheelAdapter
 *  com.contrarywind.interfaces.IPickerViewData
 *  com.contrarywind.listener.LoopViewGestureListener
 *  com.contrarywind.listener.OnItemSelectedListener
 *  com.contrarywind.timer.InertiaTimerTask
 *  com.contrarywind.timer.MessageHandler
 *  com.contrarywind.timer.SmoothScrollTimerTask
 *  com.contrarywind.view.R$dimen
 *  com.contrarywind.view.R$styleable
 *  com.contrarywind.view.WheelView$ACTION
 *  com.contrarywind.view.WheelView$DividerType
 */
package com.contrarywind.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.contrarywind.adapter.WheelAdapter;
import com.contrarywind.interfaces.IPickerViewData;
import com.contrarywind.listener.LoopViewGestureListener;
import com.contrarywind.listener.OnItemSelectedListener;
import com.contrarywind.timer.InertiaTimerTask;
import com.contrarywind.timer.MessageHandler;
import com.contrarywind.timer.SmoothScrollTimerTask;
import com.contrarywind.view.R;
import com.contrarywind.view.WheelView;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class WheelView
extends View {
    private static final float SCALE_CONTENT = 0.8f;
    private static final String[] TIME_NUM = new String[]{"00", "01", "02", "03", "04", "05", "06", "07", "08", "09"};
    private static final int VELOCITY_FLING = 5;
    private float CENTER_CONTENT_OFFSET;
    private final float DEFAULT_TEXT_TARGET_SKEW_X;
    private WheelAdapter adapter;
    private float centerY;
    private int change;
    private Context context;
    private int dividerColor;
    private DividerType dividerType;
    private int drawCenterContentStart = 0;
    private int drawOutContentStart = 0;
    private float firstLineY;
    private GestureDetector gestureDetector;
    private Handler handler;
    private int initPosition;
    private boolean isCenterLabel = true;
    private boolean isLoop;
    private boolean isOptions = false;
    private float itemHeight;
    private int itemsVisible = 11;
    private String label;
    private float lineSpacingMultiplier = 1.6f;
    private ScheduledExecutorService mExecutor = Executors.newSingleThreadScheduledExecutor();
    private ScheduledFuture<?> mFuture;
    private int mGravity = 17;
    private int mOffset = 0;
    private int maxTextHeight;
    private int maxTextWidth;
    private int measuredHeight;
    private int measuredWidth;
    private OnItemSelectedListener onItemSelectedListener;
    private Paint paintCenterText;
    private Paint paintIndicator;
    private Paint paintOuterText;
    private int preCurrentIndex;
    private float previousY = 0.0f;
    private int radius;
    private float secondLineY;
    private int selectedItem;
    private long startTime = 0L;
    private int textColorCenter;
    private int textColorOut;
    private int textSize;
    private int textXOffset;
    private float totalScrollY;
    private Typeface typeface = Typeface.MONOSPACE;
    private int widthMeasureSpec;

    public WheelView(Context context) {
        this(context, null);
    }

    public WheelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.DEFAULT_TEXT_TARGET_SKEW_X = 0.5f;
        this.textSize = this.getResources().getDimensionPixelSize(R.dimen.pickerview_textsize);
        float f = this.getResources().getDisplayMetrics().density;
        if (f < 1.0f) {
            this.CENTER_CONTENT_OFFSET = 2.4f;
        } else if (1.0f <= f && f < 2.0f) {
            this.CENTER_CONTENT_OFFSET = 3.6f;
        } else if (1.0f <= f && f < 2.0f) {
            this.CENTER_CONTENT_OFFSET = 4.5f;
        } else if (2.0f <= f && f < 3.0f) {
            this.CENTER_CONTENT_OFFSET = 6.0f;
        } else if (f >= 3.0f) {
            this.CENTER_CONTENT_OFFSET = f * 2.5f;
        }
        if (attributeSet != null) {
            attributeSet = context.obtainStyledAttributes(attributeSet, R.styleable.pickerview, 0, 0);
            this.mGravity = attributeSet.getInt(R.styleable.pickerview_wheelview_gravity, 17);
            this.textColorOut = attributeSet.getColor(R.styleable.pickerview_wheelview_textColorOut, -5723992);
            this.textColorCenter = attributeSet.getColor(R.styleable.pickerview_wheelview_textColorCenter, -14013910);
            this.dividerColor = attributeSet.getColor(R.styleable.pickerview_wheelview_dividerColor, -2763307);
            this.textSize = attributeSet.getDimensionPixelOffset(R.styleable.pickerview_wheelview_textSize, this.textSize);
            this.lineSpacingMultiplier = attributeSet.getFloat(R.styleable.pickerview_wheelview_lineSpacingMultiplier, this.lineSpacingMultiplier);
            attributeSet.recycle();
        }
        this.judgeLineSpace();
        this.initLoopView(context);
    }

    static /* synthetic */ OnItemSelectedListener access$000(WheelView wheelView) {
        return wheelView.onItemSelectedListener;
    }

    private String getContentText(Object object) {
        if (object == null) {
            return "";
        }
        if (object instanceof IPickerViewData) {
            return ((IPickerViewData)object).getPickerViewText();
        }
        if (!(object instanceof Integer)) return object.toString();
        return this.getFixNum((Integer)object);
    }

    private String getFixNum(int n) {
        String string = n >= 0 && n < 10 ? TIME_NUM[n] : String.valueOf(n);
        return string;
    }

    private int getLoopMappingIndex(int n) {
        int n2;
        if (n < 0) {
            n2 = this.getLoopMappingIndex(n + this.adapter.getItemsCount());
        } else {
            n2 = n;
            if (n <= this.adapter.getItemsCount() - 1) return n2;
            n2 = this.getLoopMappingIndex(n - this.adapter.getItemsCount());
        }
        return n2;
    }

    private void initLoopView(Context context) {
        this.context = context;
        this.handler = new MessageHandler(this);
        context = new GestureDetector(context, (GestureDetector.OnGestureListener)new LoopViewGestureListener(this));
        this.gestureDetector = context;
        context.setIsLongpressEnabled(false);
        this.isLoop = true;
        this.totalScrollY = 0.0f;
        this.initPosition = -1;
        this.initPaints();
    }

    private void initPaints() {
        Paint paint;
        this.paintOuterText = paint = new Paint();
        paint.setColor(this.textColorOut);
        this.paintOuterText.setAntiAlias(true);
        this.paintOuterText.setTypeface(this.typeface);
        this.paintOuterText.setTextSize((float)this.textSize);
        this.paintCenterText = paint = new Paint();
        paint.setColor(this.textColorCenter);
        this.paintCenterText.setAntiAlias(true);
        this.paintCenterText.setTextScaleX(1.1f);
        this.paintCenterText.setTypeface(this.typeface);
        this.paintCenterText.setTextSize((float)this.textSize);
        this.paintIndicator = paint = new Paint();
        paint.setColor(this.dividerColor);
        this.paintIndicator.setAntiAlias(true);
        this.setLayerType(1, null);
    }

    private void judgeLineSpace() {
        float f = this.lineSpacingMultiplier;
        if (f < 1.0f) {
            this.lineSpacingMultiplier = 1.0f;
        } else {
            if (!(f > 4.0f)) return;
            this.lineSpacingMultiplier = 4.0f;
        }
    }

    private void measureTextWidthHeight() {
        Rect rect = new Rect();
        int n = 0;
        while (true) {
            if (n >= this.adapter.getItemsCount()) {
                this.paintCenterText.getTextBounds("\u661f\u671f", 0, 2, rect);
                this.maxTextHeight = n = rect.height() + 2;
                this.itemHeight = this.lineSpacingMultiplier * (float)n;
                return;
            }
            String string = this.getContentText(this.adapter.getItem(n));
            this.paintCenterText.getTextBounds(string, 0, string.length(), rect);
            int n2 = rect.width();
            if (n2 > this.maxTextWidth) {
                this.maxTextWidth = n2;
            }
            ++n;
        }
    }

    private void measuredCenterContentStart(String string) {
        Rect rect = new Rect();
        this.paintCenterText.getTextBounds(string, 0, string.length(), rect);
        int n = this.mGravity;
        if (n != 3) {
            if (n != 5) {
                if (n != 17) return;
                if (!this.isOptions && (string = this.label) != null && !string.equals("") && this.isCenterLabel) {
                    double d = this.measuredWidth - rect.width();
                    Double.isNaN(d);
                    this.drawCenterContentStart = (int)(d * 0.25);
                } else {
                    double d = this.measuredWidth - rect.width();
                    Double.isNaN(d);
                    this.drawCenterContentStart = (int)(d * 0.5);
                }
            } else {
                this.drawCenterContentStart = this.measuredWidth - rect.width() - (int)this.CENTER_CONTENT_OFFSET;
            }
        } else {
            this.drawCenterContentStart = 0;
        }
    }

    private void measuredOutContentStart(String string) {
        Rect rect = new Rect();
        this.paintOuterText.getTextBounds(string, 0, string.length(), rect);
        int n = this.mGravity;
        if (n != 3) {
            if (n != 5) {
                if (n != 17) return;
                if (!this.isOptions && (string = this.label) != null && !string.equals("") && this.isCenterLabel) {
                    double d = this.measuredWidth - rect.width();
                    Double.isNaN(d);
                    this.drawOutContentStart = (int)(d * 0.25);
                } else {
                    double d = this.measuredWidth - rect.width();
                    Double.isNaN(d);
                    this.drawOutContentStart = (int)(d * 0.5);
                }
            } else {
                this.drawOutContentStart = this.measuredWidth - rect.width() - (int)this.CENTER_CONTENT_OFFSET;
            }
        } else {
            this.drawOutContentStart = 0;
        }
    }

    private void reMeasure() {
        if (this.adapter == null) {
            return;
        }
        this.measureTextWidthHeight();
        int n = (int)(this.itemHeight * (float)(this.itemsVisible - 1));
        double d = n * 2;
        Double.isNaN(d);
        this.measuredHeight = (int)(d / Math.PI);
        d = n;
        Double.isNaN(d);
        this.radius = (int)(d / Math.PI);
        this.measuredWidth = View.MeasureSpec.getSize((int)this.widthMeasureSpec);
        n = this.measuredHeight;
        float f = n;
        float f2 = this.itemHeight;
        this.firstLineY = (f - f2) / 2.0f;
        this.secondLineY = f = ((float)n + f2) / 2.0f;
        this.centerY = f - (f2 - (float)this.maxTextHeight) / 2.0f - this.CENTER_CONTENT_OFFSET;
        if (this.initPosition == -1) {
            this.initPosition = this.isLoop ? (this.adapter.getItemsCount() + 1) / 2 : 0;
        }
        this.preCurrentIndex = this.initPosition;
    }

    private void reMeasureTextSize(String string) {
        Rect rect = new Rect();
        this.paintCenterText.getTextBounds(string, 0, string.length(), rect);
        int n = rect.width();
        int n2 = this.textSize;
        while (true) {
            if (n <= this.measuredWidth) {
                this.paintOuterText.setTextSize((float)n2);
                return;
            }
            this.paintCenterText.setTextSize((float)(--n2));
            this.paintCenterText.getTextBounds(string, 0, string.length(), rect);
            n = rect.width();
        }
    }

    public void cancelFuture() {
        ScheduledFuture<?> scheduledFuture = this.mFuture;
        if (scheduledFuture == null) return;
        if (scheduledFuture.isCancelled()) return;
        this.mFuture.cancel(true);
        this.mFuture = null;
    }

    public final WheelAdapter getAdapter() {
        return this.adapter;
    }

    public final int getCurrentItem() {
        WheelAdapter wheelAdapter = this.adapter;
        if (wheelAdapter == null) {
            return 0;
        }
        if (!this.isLoop) return Math.max(0, Math.min(this.selectedItem, this.adapter.getItemsCount() - 1));
        int n = this.selectedItem;
        if (n < 0) return Math.max(0, Math.min(Math.abs(Math.abs(this.selectedItem) - this.adapter.getItemsCount()), this.adapter.getItemsCount() - 1));
        if (n < wheelAdapter.getItemsCount()) return Math.max(0, Math.min(this.selectedItem, this.adapter.getItemsCount() - 1));
        return Math.max(0, Math.min(Math.abs(Math.abs(this.selectedItem) - this.adapter.getItemsCount()), this.adapter.getItemsCount() - 1));
    }

    public Handler getHandler() {
        return this.handler;
    }

    public int getInitPosition() {
        return this.initPosition;
    }

    public float getItemHeight() {
        return this.itemHeight;
    }

    public int getItemsCount() {
        WheelAdapter wheelAdapter = this.adapter;
        int n = wheelAdapter != null ? wheelAdapter.getItemsCount() : 0;
        return n;
    }

    public int getTextWidth(Paint paint, String string) {
        int n = 0;
        int n2 = 0;
        int n3 = n;
        if (string == null) return n3;
        n3 = n;
        if (string.length() <= 0) return n3;
        n = string.length();
        float[] fArray = new float[n];
        paint.getTextWidths(string, fArray);
        n3 = 0;
        while (n2 < n) {
            n3 += (int)Math.ceil(fArray[n2]);
            ++n2;
        }
        return n3;
    }

    public float getTotalScrollY() {
        return this.totalScrollY;
    }

    public void isCenterLabel(boolean bl) {
        this.isCenterLabel = bl;
    }

    public boolean isLoop() {
        return this.isLoop;
    }

    protected void onDraw(Canvas canvas) {
        float f;
        float f2;
        float f3;
        int n;
        int n2;
        if (this.adapter == null) {
            return;
        }
        this.initPosition = n2 = Math.min(Math.max(0, this.initPosition), this.adapter.getItemsCount() - 1);
        Object[] objectArray = new Object[this.itemsVisible];
        this.change = n = (int)(this.totalScrollY / this.itemHeight);
        try {
            this.preCurrentIndex = n2 + n % this.adapter.getItemsCount();
        }
        catch (ArithmeticException arithmeticException) {
            Log.e((String)"WheelView", (String)"\u51fa\u9519\u4e86\uff01adapter.getItemsCount() == 0\uff0c\u8054\u52a8\u6570\u636e\u4e0d\u5339\u914d");
        }
        if (!this.isLoop) {
            if (this.preCurrentIndex < 0) {
                this.preCurrentIndex = 0;
            }
            if (this.preCurrentIndex > this.adapter.getItemsCount() - 1) {
                this.preCurrentIndex = this.adapter.getItemsCount() - 1;
            }
        } else {
            if (this.preCurrentIndex < 0) {
                this.preCurrentIndex = this.adapter.getItemsCount() + this.preCurrentIndex;
            }
            if (this.preCurrentIndex > this.adapter.getItemsCount() - 1) {
                this.preCurrentIndex -= this.adapter.getItemsCount();
            }
        }
        float f4 = this.totalScrollY;
        float f5 = this.itemHeight;
        for (n2 = 0; n2 < (n = this.itemsVisible); ++n2) {
            n = this.preCurrentIndex - (n / 2 - n2);
            if (this.isLoop) {
                n = this.getLoopMappingIndex(n);
                objectArray[n2] = this.adapter.getItem(n);
                continue;
            }
            objectArray[n2] = n < 0 ? "" : (n > this.adapter.getItemsCount() - 1 ? "" : this.adapter.getItem(n));
        }
        if (this.dividerType == DividerType.WRAP) {
            n2 = TextUtils.isEmpty((CharSequence)this.label) ? (this.measuredWidth - this.maxTextWidth) / 2 : (this.measuredWidth - this.maxTextWidth) / 4;
            f3 = n2 - 12;
            if (f3 <= 0.0f) {
                f3 = 10.0f;
            }
            f2 = (float)this.measuredWidth - f3;
            f = this.firstLineY;
            canvas.drawLine(f3, f, f2, f, this.paintIndicator);
            f = this.secondLineY;
            canvas.drawLine(f3, f, f2, f, this.paintIndicator);
        } else {
            f3 = this.firstLineY;
            canvas.drawLine(0.0f, f3, (float)this.measuredWidth, f3, this.paintIndicator);
            f3 = this.secondLineY;
            canvas.drawLine(0.0f, f3, (float)this.measuredWidth, f3, this.paintIndicator);
        }
        if (!TextUtils.isEmpty((CharSequence)this.label) && this.isCenterLabel) {
            n2 = this.measuredWidth;
            n = this.getTextWidth(this.paintCenterText, this.label);
            canvas.drawText(this.label, (float)(n2 - n) - this.CENTER_CONTENT_OFFSET, this.centerY, this.paintCenterText);
        }
        n = 0;
        while (n < this.itemsVisible) {
            canvas.save();
            double d = (this.itemHeight * (float)n - f4 % f5) / (float)this.radius;
            Double.isNaN(d);
            f2 = (float)(90.0 - d / Math.PI * 180.0);
            if (!(f2 >= 90.0f) && !(f2 <= -90.0f)) {
                CharSequence charSequence;
                f = (float)Math.pow(Math.abs(f2) / 90.0f, 2.2);
                if (!(this.isCenterLabel || TextUtils.isEmpty((CharSequence)this.label) || TextUtils.isEmpty((CharSequence)this.getContentText(objectArray[n])))) {
                    charSequence = new StringBuilder();
                    ((StringBuilder)charSequence).append(this.getContentText(objectArray[n]));
                    ((StringBuilder)charSequence).append(this.label);
                    charSequence = ((StringBuilder)charSequence).toString();
                } else {
                    charSequence = this.getContentText(objectArray[n]);
                }
                this.reMeasureTextSize((String)charSequence);
                this.measuredCenterContentStart((String)charSequence);
                this.measuredOutContentStart((String)charSequence);
                double d2 = this.radius;
                double d3 = Math.cos(d);
                double d4 = this.radius;
                Double.isNaN(d4);
                Double.isNaN(d2);
                double d5 = Math.sin(d);
                double d6 = this.maxTextHeight;
                Double.isNaN(d6);
                f3 = (float)(d2 - d3 * d4 - d5 * d6 / 2.0);
                canvas.translate(0.0f, f3);
                float f6 = this.firstLineY;
                if (f3 <= f6 && (float)this.maxTextHeight + f3 >= f6) {
                    canvas.save();
                    canvas.clipRect(0.0f, 0.0f, (float)this.measuredWidth, this.firstLineY - f3);
                    canvas.scale(1.0f, (float)Math.sin(d) * 0.8f);
                    canvas.drawText((String)charSequence, (float)this.drawOutContentStart, (float)this.maxTextHeight, this.paintOuterText);
                    canvas.restore();
                    canvas.save();
                    canvas.clipRect(0.0f, this.firstLineY - f3, (float)this.measuredWidth, (float)((int)this.itemHeight));
                    canvas.scale(1.0f, (float)Math.sin(d) * 1.0f);
                    canvas.drawText((String)charSequence, (float)this.drawCenterContentStart, (float)this.maxTextHeight - this.CENTER_CONTENT_OFFSET, this.paintCenterText);
                    canvas.restore();
                } else {
                    f6 = this.secondLineY;
                    if (f3 <= f6 && (float)this.maxTextHeight + f3 >= f6) {
                        canvas.save();
                        canvas.clipRect(0.0f, 0.0f, (float)this.measuredWidth, this.secondLineY - f3);
                        canvas.scale(1.0f, (float)Math.sin(d) * 1.0f);
                        canvas.drawText((String)charSequence, (float)this.drawCenterContentStart, (float)this.maxTextHeight - this.CENTER_CONTENT_OFFSET, this.paintCenterText);
                        canvas.restore();
                        canvas.save();
                        canvas.clipRect(0.0f, this.secondLineY - f3, (float)this.measuredWidth, (float)((int)this.itemHeight));
                        canvas.scale(1.0f, (float)Math.sin(d) * 0.8f);
                        canvas.drawText((String)charSequence, (float)this.drawOutContentStart, (float)this.maxTextHeight, this.paintOuterText);
                        canvas.restore();
                    } else if (f3 >= this.firstLineY && (float)(n2 = this.maxTextHeight) + f3 <= this.secondLineY) {
                        f3 = n2;
                        f2 = this.CENTER_CONTENT_OFFSET;
                        canvas.drawText((String)charSequence, (float)this.drawCenterContentStart, f3 - f2, this.paintCenterText);
                        this.selectedItem = this.preCurrentIndex - (this.itemsVisible / 2 - n);
                    } else {
                        canvas.save();
                        canvas.clipRect(0, 0, this.measuredWidth, (int)this.itemHeight);
                        canvas.scale(1.0f, (float)Math.sin(d) * 0.8f);
                        Paint paint = this.paintOuterText;
                        n2 = this.textXOffset;
                        int n3 = -1;
                        n2 = n2 == 0 ? 0 : (n2 > 0 ? 1 : -1);
                        if (!(f2 > 0.0f)) {
                            n3 = 1;
                        }
                        paint.setTextSkewX((float)(n2 * n3) * 0.5f * f);
                        this.paintOuterText.setAlpha((int)((1.0f - f) * 255.0f));
                        canvas.drawText((String)charSequence, (float)this.drawOutContentStart + (float)this.textXOffset * f, (float)this.maxTextHeight, this.paintOuterText);
                        canvas.restore();
                    }
                }
                canvas.restore();
                this.paintCenterText.setTextSize((float)this.textSize);
            } else {
                canvas.restore();
            }
            ++n;
        }
    }

    public final void onItemSelected() {
        if (this.onItemSelectedListener == null) return;
        this.postDelayed((Runnable)new /* Unavailable Anonymous Inner Class!! */, 200L);
    }

    protected void onMeasure(int n, int n2) {
        this.widthMeasureSpec = n;
        this.reMeasure();
        this.setMeasuredDimension(this.measuredWidth, this.measuredHeight);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int n;
        block7: {
            int n2;
            block5: {
                float f;
                block8: {
                    float f2;
                    float f3;
                    float f4;
                    float f5;
                    float f6;
                    block6: {
                        boolean bl = this.gestureDetector.onTouchEvent(motionEvent);
                        f6 = -this.initPosition;
                        f5 = this.itemHeight;
                        f4 = this.adapter.getItemsCount() - 1 - this.initPosition;
                        f3 = this.itemHeight;
                        n = motionEvent.getAction();
                        n2 = 0;
                        if (n == 0) break block5;
                        if (n == 2) break block6;
                        n = n2;
                        if (!bl) {
                            float f7 = motionEvent.getY();
                            n = this.radius;
                            double d = Math.acos(((float)n - f7) / (float)n);
                            double d2 = this.radius;
                            Double.isNaN(d2);
                            f7 = this.itemHeight;
                            double d3 = f7 / 2.0f;
                            Double.isNaN(d3);
                            double d4 = f7;
                            Double.isNaN(d4);
                            n = (int)((d * d2 + d3) / d4);
                            f4 = this.totalScrollY;
                            this.mOffset = (int)((float)(n - this.itemsVisible / 2) * f7 - (f4 % f7 + f7) % f7);
                            if (System.currentTimeMillis() - this.startTime > 120L) {
                                this.smoothScroll(ACTION.DAGGLE);
                                n = n2;
                            } else {
                                this.smoothScroll(ACTION.CLICK);
                                n = n2;
                            }
                        }
                        break block7;
                    }
                    f = this.previousY - motionEvent.getRawY();
                    this.previousY = motionEvent.getRawY();
                    this.totalScrollY = f2 = this.totalScrollY + f;
                    n = n2;
                    if (this.isLoop) break block7;
                    if (f2 - this.itemHeight * 0.25f < f6 * f5 && f < 0.0f) break block8;
                    n = n2;
                    if (!(this.totalScrollY + this.itemHeight * 0.25f > f4 * f3)) break block7;
                    n = n2;
                    if (!(f > 0.0f)) break block7;
                }
                this.totalScrollY -= f;
                n = 1;
                break block7;
            }
            this.startTime = System.currentTimeMillis();
            this.cancelFuture();
            this.previousY = motionEvent.getRawY();
            n = n2;
        }
        if (n != 0) return true;
        if (motionEvent.getAction() == 0) return true;
        this.invalidate();
        return true;
    }

    public final void scrollBy(float f) {
        this.cancelFuture();
        this.mFuture = this.mExecutor.scheduleWithFixedDelay((Runnable)new InertiaTimerTask(this, f), 0L, 5L, TimeUnit.MILLISECONDS);
    }

    public final void setAdapter(WheelAdapter wheelAdapter) {
        this.adapter = wheelAdapter;
        this.reMeasure();
        this.invalidate();
    }

    public final void setCurrentItem(int n) {
        this.selectedItem = n;
        this.initPosition = n;
        this.totalScrollY = 0.0f;
        this.invalidate();
    }

    public final void setCyclic(boolean bl) {
        this.isLoop = bl;
    }

    public void setDividerColor(int n) {
        this.dividerColor = n;
        this.paintIndicator.setColor(n);
    }

    public void setDividerType(DividerType dividerType) {
        this.dividerType = dividerType;
    }

    public void setGravity(int n) {
        this.mGravity = n;
    }

    public void setIsOptions(boolean bl) {
        this.isOptions = bl;
    }

    public void setLabel(String string) {
        this.label = string;
    }

    public void setLineSpacingMultiplier(float f) {
        if (f == 0.0f) return;
        this.lineSpacingMultiplier = f;
        this.judgeLineSpace();
    }

    public final void setOnItemSelectedListener(OnItemSelectedListener onItemSelectedListener) {
        this.onItemSelectedListener = onItemSelectedListener;
    }

    public void setTextColorCenter(int n) {
        this.textColorCenter = n;
        this.paintCenterText.setColor(n);
    }

    public void setTextColorOut(int n) {
        this.textColorOut = n;
        this.paintOuterText.setColor(n);
    }

    public final void setTextSize(float f) {
        int n;
        if (!(f > 0.0f)) return;
        this.textSize = n = (int)(this.context.getResources().getDisplayMetrics().density * f);
        this.paintOuterText.setTextSize((float)n);
        this.paintCenterText.setTextSize((float)this.textSize);
    }

    public void setTextXOffset(int n) {
        this.textXOffset = n;
        if (n == 0) return;
        this.paintCenterText.setTextScaleX(1.0f);
    }

    public void setTotalScrollY(float f) {
        this.totalScrollY = f;
    }

    public final void setTypeface(Typeface typeface) {
        this.typeface = typeface;
        this.paintOuterText.setTypeface(typeface);
        this.paintCenterText.setTypeface(this.typeface);
    }

    public void smoothScroll(ACTION aCTION) {
        this.cancelFuture();
        if (aCTION == ACTION.FLING || aCTION == ACTION.DAGGLE) {
            int n;
            float f = this.totalScrollY;
            float f2 = this.itemHeight;
            this.mOffset = n = (int)((f % f2 + f2) % f2);
            this.mOffset = (float)n > f2 / 2.0f ? (int)(f2 - (float)n) : -n;
        }
        this.mFuture = this.mExecutor.scheduleWithFixedDelay((Runnable)new SmoothScrollTimerTask(this, this.mOffset), 0L, 10L, TimeUnit.MILLISECONDS);
    }
}
