package com.chengzhang.circleimageview.app.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.*;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by Steven on 2015/5/18.
 * describe:
 *  创建一个遮罩层去覆盖原有图片，
 *  MaskImage 使用的是Xfermode 的DST_IN 即 取两层绘制交集。显示下层。
 */
public abstract class MaskImage extends ImageView {
    private static Xfermode MASK_XFERMODE;
    private Bitmap mask;
    private Paint paint;

    public MaskImage(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MaskImage(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    public MaskImage(Context context) {
        super(context);
    }
    static {
        PorterDuff.Mode localMode = PorterDuff.Mode.DST_IN;
        MASK_XFERMODE = new PorterDuffXfermode(localMode);
    }
    @SuppressLint("DrawAllocation")
    @Override
    protected void onDraw(@NonNull Canvas canvas) {
//        super.onDraw(canvas);
        Drawable localDrawable = getDrawable();
        if (localDrawable == null)
            return;
        try {
            if (this.paint == null) {
                this.paint = new Paint();
                this.paint.setFilterBitmap(false);
                Paint localPaint2 = this.paint;
                Xfermode localXfermode1 = MASK_XFERMODE;
                @SuppressWarnings("unused")
                Xfermode localXfermode2 = localPaint2.setXfermode(localXfermode1);
            }
            float f1 = getWidth();
            float f2 = getHeight();
            int i = canvas.saveLayer(0.0F, 0.0F, f1, f2, null, 31);
            int j = getWidth();
            int k = getHeight();
            localDrawable.setBounds(0, 0, j, k);
            localDrawable.draw(canvas);
            if ((this.mask == null) || (this.mask.isRecycled())) {
                this.mask = createMask();
            }
            Bitmap localBitmap2 = this.mask;
            Paint localPaint3 = this.paint;
            canvas.drawBitmap(localBitmap2, 0.0F, 0.0F, localPaint3);
            canvas.restoreToCount(i);
            return ;
        } catch (Exception localException) {
            StringBuilder localStringBuilder;
            localStringBuilder = new StringBuilder()
                    .append("Attempting to draw with recycled bitmap. View ID = ");
            System.out.println("localStringBuilder=="+localStringBuilder);
        }
    }

    public abstract Bitmap createMask();
}
