package abhishek.experiments.rajawalipickingtest;

import android.os.Bundle;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.GestureDetector;
import android.view.MotionEvent;

/**
 * This is picking test for Rajawali SDk It was written with v0.9 Tag of SDK It
 * prints out picked object name and position on single tap
 * 
 * @author Abhishek Bansal
 * 
 */
public class MainActivity extends RajawaliExampleActivity implements OnGestureListener, OnDoubleTapListener
{
    private RajawaliObjectPickingRenderer mRenderer;
    private GestureDetector mGestureDetector;

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        
        // Instantiate the gesture detector with the
        // application context and an implementation of
        // GestureDetector.OnGestureListener
        mGestureDetector = new GestureDetector(this, this);
        // Set the gesture detector as the double tap
        // listener.
        mGestureDetector.setOnDoubleTapListener(this);
        
        mRenderer = new RajawaliObjectPickingRenderer(this);
        mRenderer.setSurfaceView(mSurfaceView);
        super.setRenderer(mRenderer);
        initLoader();
    }
    
    @Override
    public boolean onTouchEvent(MotionEvent e)
    {
        return mGestureDetector.onTouchEvent(e);
    }

    @Override
    public boolean onDoubleTap(MotionEvent arg0)
    {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent arg0)
    {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent arg0)
    {
        mRenderer.pick(arg0.getX(), arg0.getY());
        return true;
    }

    @Override
    public boolean onDown(MotionEvent arg0)
    {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean onFling(MotionEvent arg0, MotionEvent arg1, float arg2, float arg3)
    {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void onLongPress(MotionEvent arg0)
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public boolean onScroll(MotionEvent arg0, MotionEvent arg1, float arg2, float arg3)
    {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void onShowPress(MotionEvent arg0)
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public boolean onSingleTapUp(MotionEvent arg0)
    {
        // TODO Auto-generated method stub
        return true;
    }
}
