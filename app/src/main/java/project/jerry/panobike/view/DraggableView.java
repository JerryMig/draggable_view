package project.jerry.panobike.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import project.jerry.panobike.R;

/**
 * Created by Migme_Jerry on 2017/5/3.
 */

public class DraggableView extends ImageView implements View.OnTouchListener {

    public DraggableView(Context context) {
        super(context);
        init();
    }

    public DraggableView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public DraggableView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        setImageResource(R.mipmap.plane);
        setOnTouchListener(this);
    }

    float dX;
    float dY;
    int lastAction;
    @Override
    public boolean onTouch(View view, MotionEvent event) {
        switch (event.getActionMasked()) {
            case MotionEvent.ACTION_DOWN:
                dX = view.getX() - event.getRawX();
                dY = view.getY() - event.getRawY();
                lastAction = MotionEvent.ACTION_DOWN;
                break;

            case MotionEvent.ACTION_MOVE:
                view.setX(event.getRawX() + dX);
                view.setY(event.getRawY() + dY);
                lastAction = MotionEvent.ACTION_MOVE;
                break;

            case MotionEvent.ACTION_UP:
                if (lastAction == MotionEvent.ACTION_DOWN) {
                    Log.d("test", "on view clicked");
                }
                break;
            default:
                return false;
        }
        return true;
    }
}