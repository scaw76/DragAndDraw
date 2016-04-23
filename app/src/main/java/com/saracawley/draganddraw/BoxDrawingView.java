package com.saracawley.draganddraw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by scawley on 4/6/16.
 */
public class BoxDrawingView extends View {

    private static final String TAG = "BoxDrawingView";
    private Box mCurrentBox;
    private List<Box> mBoxen = new ArrayList<>();

    private Paint mBoxPaint;
    private Paint mBackgroundPaint;
    private Paint mOutlinePaint;


    public BoxDrawingView(Context context){
        this(context, null);
    }
    public BoxDrawingView(Context context, AttributeSet attrs){
        super(context, attrs);

        // paint baxes
        mBoxPaint = new Paint();
        mBoxPaint.setColor(0x220000ff);

        //Paint the background
        mBackgroundPaint = new Paint();
        mBackgroundPaint.setColor(0xff8efe0);

        mOutlinePaint = new Paint();
        mOutlinePaint.setColor(0xff0000ff);
        mOutlinePaint.setStyle((Paint.Style.STROKE));
        mOutlinePaint.setStrokeWidth(4);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawPaint(mBackgroundPaint);

        for(Box box : mBoxen){
            /*
            float left = Math.min(box.getOrigin().x, box.getCurrent().x);
            float right = Math.max(box.getOrigin().x, box.getCurrent().x);
            float top = Math.min(box.getOrigin().y, box.getCurrent().y);
            float bottom = Math.max(box.getOrigin().y, box.getCurrent().y);
*/

            float radius = (float) Math.sqrt(Math.pow((box.getCurrent().x - box.getOrigin().x),2) + Math.pow( (box.getCurrent().y -box.getOrigin().y),2));

            //canvas.drawRect(left, top, right, bottom, mBoxPaint);
            canvas.drawCircle(box.getOrigin().x,box.getOrigin().y, radius, mBoxPaint);
            canvas.drawCircle(box.getOrigin().x,box.getOrigin().y, radius, mOutlinePaint);


        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        PointF current = new PointF( event.getX(),event.getY() );
        String action = "";
        switch(event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                action = "ACTION_DOWN";
                // reset drawing state
                mCurrentBox = new Box(current);
                mBoxen.add(mCurrentBox);
                break;

            case MotionEvent.ACTION_MOVE:
                action = "ACTION_MOVE";
                if(mCurrentBox != null){
                    mCurrentBox.setCurrent(current);
                    invalidate();
                }
                break;
            case MotionEvent.ACTION_UP:
                action = "ACTION_UP";
                mCurrentBox = null;
                break;
            case MotionEvent.ACTION_CANCEL:
                action = "ACTION_CANCEL";
                mCurrentBox = null;
                break;
        }
        //Log.i(TAG, action + " at x: " + event.getX() + " at y: " + event.getY());
        return true;
    }
}
