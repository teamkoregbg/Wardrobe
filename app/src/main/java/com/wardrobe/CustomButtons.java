package com.wardrobe;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class CustomButtons {

    private Bitmap mBitmap;
    private String mId;
    private float mPositionX;
    private float mPositionY;

    public CustomButtons(String id, Bitmap bitmap, float positionX, float positionY)
    {
        mId = id;
        mBitmap = bitmap;
        mPositionX = positionX;
        mPositionY = positionY;
    }

    public float getBitmapHeight()
    {
        return mBitmap.getHeight();
    }

    public float getBitmapWidth()
    {
        return mBitmap.getWidth();
    }

    public float getmPositionX()
    {
        return mPositionX;
    }

    public float getmPositionY()
    {
        return mPositionY;
    }

    public String getId()
    {
        return mId;
    }

    public void drawNote(Canvas canvas)
    {
        canvas.drawBitmap(mBitmap, mPositionX, mPositionY, null);
    }


}
