package project.jerry.panobike.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import project.jerry.panobike.R;

/**
 * Created by Migme_Jerry on 2017/5/4.
 */

public class ClickEffectButton extends ImageView implements View.OnTouchListener {

    public ClickEffectButton(Context context) {
        super(context);
        init();
    }

    public ClickEffectButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ClickEffectButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        this.setOnTouchListener(this);
    }


    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getActionMasked()) {
            case MotionEvent.ACTION_DOWN:
                setColorFilter(R.color.colorPrimary);
                break;
            case MotionEvent.ACTION_UP:
                setColorFilter(null);
                break;
        }
        return false;
    }
}
