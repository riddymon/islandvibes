package com.islandvibesguelph.islandvibes.widgets;

/**
 * Created by djriddy on 2015-12-29.
 */
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageButton;

import com.islandvibesguelph.islandvibes.R;

public class SquareImageButton extends ImageButton {

    private static final int WIDTH_DIMENSION = 0;
    private static final int HEIGHT_DIMENSION = 1;
    private int mMatchDimension;

    public SquareImageButton(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.SquareImageButton, 0, 0);
        mMatchDimension = a.getInteger(R.styleable.SquareImageButton_matchDimension, WIDTH_DIMENSION);
        a.recycle();

    }

    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec){
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int dimension = -1;
        int measuredWidth = getDefaultSize(getSuggestedMinimumWidth(),
                widthMeasureSpec);
        int measuredHeight = getDefaultSize(getSuggestedMinimumHeight(),
                heightMeasureSpec);


        if (mMatchDimension == HEIGHT_DIMENSION) {
            dimension = measuredHeight;
        } else if (mMatchDimension == WIDTH_DIMENSION) {
            dimension = measuredWidth;
        }

        setMeasuredDimension(dimension, dimension);

    }

    public void setIcon (Drawable drawable) {
        setImageDrawable(drawable);
    }

}
