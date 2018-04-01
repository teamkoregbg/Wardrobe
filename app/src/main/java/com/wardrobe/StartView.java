package com.wardrobe;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class StartView extends View {
    private Activity mMainActivity;
    private Bitmap mBitmapWardrobe;
    private Bitmap mBitmapNewClothes;
    private List <CustomButtons> mButtons = new ArrayList<>(); ;
    private float mWidth;
    private float mHeight;


    public StartView(Context context, AttributeSet attrib)
    {
        super(context, attrib);
        mMainActivity = (MainActivity)context;
    }

    private void initBitmapWardobe()
    {
        mBitmapWardrobe = BitmapFactory.decodeResource(getResources(), R.drawable.wardrobe_liten);
        mBitmapWardrobe = Bitmap.createScaledBitmap(mBitmapWardrobe, (int)mWidth, (int)mHeight, true);
    }

    private void initBitmapCustomButtons()
    {
        mBitmapNewClothes = BitmapFactory.decodeResource(getResources(), R.drawable.hang_in_nya_klader);
        mBitmapNewClothes = Bitmap.createScaledBitmap(mBitmapNewClothes, (int)mWidth /3, (int)mHeight / 4, true);
        mButtons.add(new CustomButtons("Add_Clothes", mBitmapNewClothes, mWidth / 5.7f, mHeight / 4));
    }

    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //mScreenWidth = canvas.getWidth();
        mHeight = canvas.getHeight();
        /*if ((getResources().getConfiguration().screenLayout &
                Configuration.SCREENLAYOUT_SIZE_MASK) ==
                Configuration.SCREENLAYOUT_SIZE_LARGE || (getResources().getConfiguration().screenLayout &
                Configuration.SCREENLAYOUT_SIZE_MASK) ==
                Configuration.SCREENLAYOUT_SIZE_XLARGE)
        {
            if (mMainActivity.getOrientation() == 2)
            {
                mWidth = mScreenWidth / 1.3f;
            }
            else
            {
                mWidth = mScreenWidth / 2;
            }
        }
        else
        {
            mWidth = canvas.getWidth();
        }*/
        mWidth = canvas.getWidth();
        initBitmapWardobe();
        initBitmapCustomButtons();
        canvas.drawBitmap(mBitmapWardrobe, 0, 0, null);
        drawCustomButtons(canvas);
    }

    private void drawCustomButtons(Canvas canvas)
    {
        if(mButtons.size() > 0)
        {
            for(int i = 0; i < mButtons.size(); i++)
            {
                mButtons.get(i).drawNote(canvas);
            }
        }
    }

    private void loadCameraActivity()
    {
        Intent intent = new Intent(getContext(), CameraActivity.class);
        getContext().startActivity(intent);
    }

    @Override
    public boolean onTouchEvent( MotionEvent event)
    {
        super.onTouchEvent(event);
        final int action = event.getActionMasked();
        switch(action)
        {
            case MotionEvent.ACTION_DOWN: {
                int pointerIndex = event.getActionIndex();
                float x = event.getX(pointerIndex);
                float y = event.getY(pointerIndex);

                if (x >= getBitmapPositionX("Add_Clothes") && x <= getBitmapXend("Add_Clothes")
                        && y >= getBitmapPositionY("Add_Clothes")  && y <= getBitmapEndY("Add_Clothes")) {
                    try
                    {
                        loadCameraActivity();
                        //Toast.makeText(getContext(), "Kamera", Toast.LENGTH_LONG).show();
                    }
                    catch(Exception e)
                    {

                    }

                    break;
                }

            }

        }

        return true;
    }

    private float getBitmapPositionX(String id)
    {
        float textViewX = 0;
        for(int i = 0; i < mButtons.size(); i++)
        {
            if(mButtons.get(i).getId().matches(id))
            {
                textViewX = mButtons.get(i).getmPositionX();
                break;
            }
        }
        return textViewX;
    }

    private float getBitmapPositionY(String id)
    {
        float textViewY = 0;
        for(int i = 0; i < mButtons.size(); i++)
        {
            if(mButtons.get(i).getId().matches(id))
            {
                textViewY = mButtons.get(i).getmPositionY();
                break;
            }
        }
        return textViewY;
    }

    private float getBitmapXend(String id)
    {
        float textViewWidth = 0;
        for(int i = 0; i < mButtons.size(); i++)
        {
            if(mButtons.get(i).getId().matches(id))
            {
                textViewWidth = mButtons.get(i).getBitmapWidth() + mButtons.get(i).getmPositionX();
                break;
            }
        }
        return textViewWidth;
    }

    private float getBitmapEndY(String id)
    {
        float textViewHeight = 0;
        for(int i = 0; i < mButtons.size(); i++)
        {
            if(mButtons.get(i).getId().matches(id))
            {
                textViewHeight = mButtons.get(i).getBitmapHeight() + mButtons.get(i).getmPositionY();
                break;
            }
        }
        return textViewHeight;
    }

}
