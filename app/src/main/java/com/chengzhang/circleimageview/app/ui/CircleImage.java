package com.chengzhang.circleimageview.app.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;

/**
 * Created by Steven on 2015/5/18.
 * describe:
 */
public class CircleImage extends MaskImage {
    public CircleImage(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CircleImage(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public CircleImage(Context context) {
        super(context);
    }

    @Override
    public Bitmap createMask() {
        int i = getWidth();
        int j = getHeight();
        Bitmap.Config localConfig = Bitmap.Config.ARGB_8888;
        Bitmap localBitmap = Bitmap.createBitmap(i, j, localConfig);
        Canvas localCanvas = new Canvas(localBitmap);
        Paint localPaint = new Paint(1);
        localPaint.setColor(-16777216);
        float width = getWidth();
        float height = getHeight();
        RectF localRectF = new RectF(0.0F, 0.0F, width, height);
        localCanvas.drawOval(localRectF, localPaint);
        return localBitmap;
    }
}
