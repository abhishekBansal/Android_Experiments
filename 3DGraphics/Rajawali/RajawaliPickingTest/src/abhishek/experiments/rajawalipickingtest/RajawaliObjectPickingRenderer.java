package abhishek.experiments.rajawalipickingtest;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import rajawali.BaseObject3D;
import rajawali.materials.SimpleMaterial;
import rajawali.math.Number3D;
import rajawali.primitives.Cube;
import rajawali.renderer.RajawaliRenderer;
import rajawali.util.ObjectColorPicker;
import rajawali.util.OnObjectPickedListener;
import android.content.Context;
import android.graphics.Color;
import android.util.Log;

public class RajawaliObjectPickingRenderer extends RajawaliRenderer implements OnObjectPickedListener
{
    private BaseObject3D _rootObject;
    private ObjectColorPicker _picker;

    public RajawaliObjectPickingRenderer(Context context)
    {
        super(context);
        setFrameRate(60);
    }

    protected void initScene()
    {
        mCamera.setZ(9.0f);
        
        _rootObject = new BaseObject3D();
        
        _picker = new ObjectColorPicker(this);
        _picker.setOnObjectPickedListener(this);
        
        setBackgroundColor(Color.WHITE);
        
        float distanceFactor = 1.5f;
        int tileNo = 9;
        for (int i = -1; i <= 1; i++)
        {
            for (int j = -1; j <= 1; j++)
            {
                BaseObject3D tile = new Cube(1.0f);
                SimpleMaterial sm = new SimpleMaterial();
                tile.setMaterial(sm);
                tile.setColor(new Number3D(i, j, (i+1.2)/2.0));
                tile.setPosition(i * distanceFactor, j * distanceFactor, 0.0f);
                tile.setName("Tile#" + tileNo);
                _rootObject.addChild(tile);
                _picker.registerObject(tile);

                tileNo--;
            }
        }
        
        addChild(_rootObject);
    }

    public void onSurfaceCreated(GL10 gl, EGLConfig config)
    {
        ((RajawaliExampleActivity) mContext).showLoader();
        super.onSurfaceCreated(gl, config);
        ((RajawaliExampleActivity) mContext).hideLoader();
    }

    public void onDrawFrame(GL10 glUnused)
    {
        super.onDrawFrame(glUnused);
    }
    
    public void pick(float x, float y)
    {
        _picker.getObjectAt(x, y);
    }

    @Override
    public void onObjectPicked(BaseObject3D object)
    {
        Log.d(RajawaliExampleActivity.LOG_TAG, 
                "Picking " + object.getName() + " Position:" 
                           + object.getPosition().toString());
    }
}
