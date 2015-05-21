# CirCleImageView  

----------
## Note 

对于系统的ImageView，显示图片时是方形的（当然对于背景透明的图片时无所谓的），但是人是对于
圆形是有偏爱的，圆形给人一种更为柔和的感觉。为此，设计了一个圆形的ImageView。

----------
## Key Knowledge 
	
圆形的图片最简单的实现有几种：

- 就是使用原有的ImageView，将图片的原有图片设计为圆形的，但是这样其实是一将圆形图片放入到一个方形的区域，如果srcImage 为正方形的无所谓，肯定可以满足要求，但是如果图片为矩形的，那么将会浪费空间
- 使用函数对原有图片剪切，返回一个圆形的图片，可以参考一下代码：
	
		/**
         * 将图片截取为圆角图片
         * @param bitmap 原图片
         * @param ratio 截取比例，如果是8，则圆角半径是宽高的1/8，如果是2，则是圆形图片
         * @return 圆角矩形图片
         */
        public static Bitmap getRoundedCornerBitmap(Bitmap bitmap, float ratio) {
                
                Bitmap output = Bitmap.createBitmap(bitmap.getWidth(),
                                bitmap.getHeight(), Config.ARGB_8888);
                Canvas canvas = new Canvas(output);

                final Paint paint = new Paint();
                final Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
                final RectF rectF = new RectF(rect);

                paint.setAntiAlias(true);
                canvas.drawARGB(0, 0, 0, 0);
                canvas.drawRoundRect(rectF, bitmap.getWidth()/ratio, 
                                bitmap.getHeight()/ratio, paint);

                paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
                canvas.drawBitmap(bitmap, rect, rect, paint);
                return output;
        }
-使用本Demo中的CirCleImage自定义控件，在需要使用圆形的ImageView处使用替换为CircleImageView即可，视为一般的自定义空间即可。
    
    >     <com.chengzhang.circleimageview.app.ui.CircleImage
    >     android:id="@+id/iv_circleImages"
    >     android:layout_width="30dp"
    >     android:layout_height="30dp"/>
	

