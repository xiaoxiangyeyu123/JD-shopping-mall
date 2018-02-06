package top.linsir.jd_shopping_mall.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

import top.linsir.jd_shopping_mall.R;

/**
 * Created by linSir
 * date at 2018/2/5.
 * describe: http://blog.csdn.net/zhuod/article/details/52432409
 *           暂时应用的第三方的自定义View - 带圆角的TextView
 */

public class RadioTextView extends View {

    /**
     * title文本
     */
    private String mTitleText;
    /**
     * title文本的颜色
     */
    private int mTitleTextColor;
    /**
     * titel文本的大小
     */
    private int mTitleTextSize;

    /**
     * background
     *
     * @param context
     * @param attrs
     */
    private int background;

    /**
     * 圆角大小
     */
    private int mCornerSize;

    /**
     * 绘制时控制文本绘制的范围
     */
    private Rect mtitleBound;
    private Paint mtitlePaint;

    public RadioTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RadioTextView(Context context) {
        this(context, null);
    }

    /**
     * 获得我自定义的样式属性
     *
     * @param context
     * @param attrs
     * @param defStyle
     */
    public RadioTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        /**
         * 获得我们所定义的自定义样式属性
         */
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.RaidoTextView, defStyle, 0);
        int n = a.getIndexCount();
        for (int i = 0; i < n; i++) {
            int attr = a.getIndex(i);
            switch (attr) {
                case R.styleable.RaidoTextView_titleText:
                    mTitleText = a.getString(attr);
                    break;
                case R.styleable.RaidoTextView_titleTextColor:
                    // 默认颜色设置为黑色
                    mTitleTextColor = a.getColor(attr, Color.BLACK);
                    break;
                case R.styleable.RaidoTextView_titleTextSize:
                    // 默认设置为16sp，TypeValue也可以把sp转化为px
                    mTitleTextSize = a.getDimensionPixelSize(attr, (int) TypedValue.applyDimension(
                            TypedValue.COMPLEX_UNIT_SP, 16, getResources().getDisplayMetrics()));
                    break;
                case R.styleable.RaidoTextView_background2:
                    //默认为白色
                    background = a.getColor(attr, Color.WHITE);
                    break;
                case R.styleable.RaidoTextView_mCornerSize:
                    //默认圆角为0
                    mCornerSize = a.getInteger(attr, 0);
                    break;

            }

        }
        a.recycle();
        /**
         * 获得绘制文本的宽和高
         */
        mtitlePaint = new Paint();
        mtitlePaint.setTextSize(mTitleTextSize);
        mtitleBound = new Rect();
        mtitlePaint.getTextBounds(mTitleText, 0, mTitleText.length(), mtitleBound);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        int width;
        int height;
        if (widthMode == MeasureSpec.EXACTLY) {
            width = widthSize;
        } else {
            mtitlePaint.setTextSize(mTitleTextSize);
            mtitlePaint.getTextBounds(mTitleText, 0, mTitleText.length(), mtitleBound);

            int desired = getPaddingLeft() + mtitleBound.width() + getPaddingRight();
            width = desired <= widthSize ? desired : widthSize;
        }

        if (heightMode == MeasureSpec.EXACTLY) {
            height = heightSize;
        } else {
            mtitlePaint.setTextSize(mTitleTextSize);
            mtitlePaint.getTextBounds(mTitleText, 0, mTitleText.length(), mtitleBound);
            int desired = getPaddingTop() + mtitleBound.height() + getPaddingBottom();
            height = desired <= heightSize ? desired : heightSize;
        }
        setMeasuredDimension(width, height);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        Paint paint = new Paint(Paint.FILTER_BITMAP_FLAG);
        paint.setAntiAlias(true);
        paint.setColor(background);
        RectF rec = new RectF(0, 0, getMeasuredWidth(), getMeasuredHeight());
        canvas.drawRoundRect(rec, mCornerSize, mCornerSize, paint);

        mtitlePaint.setColor(mTitleTextColor);
        Paint.FontMetricsInt fontMetrics = mtitlePaint.getFontMetricsInt();
        int baseline = (getMeasuredHeight() - fontMetrics.bottom + fontMetrics.top) / 2 - fontMetrics.top;
        canvas.drawText(mTitleText, getPaddingLeft(), baseline, mtitlePaint);
    }
}
