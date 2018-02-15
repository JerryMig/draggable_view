package project.jerry.panobike.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

import project.jerry.panobike.R;
import project.jerry.panobike.model.BaseMissile;
import project.jerry.panobike.model.MissileFactory;

/**
 * Created by Migme_Jerry on 2017/5/3.
 */

public class InformationView extends LinearLayout {

    private Context mContext;
    private TextView mBulletCount;
    private LinearLayout mMissileBoard;
    private Map<String, ImageView> mMissileToIconMap;

    public InformationView(Context context) {
        super(context);
        mContext = context;
        initView();
    }

    public InformationView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        initView();
    }

    public InformationView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        initView();
    }

    private void initView() {
        View view = inflate(mContext, R.layout.view_information, this);
        mBulletCount = (TextView) view.findViewById(R.id.bullet_count);
        mMissileBoard = (LinearLayout) view.findViewById(R.id.missile_board);
    }

    public void updateBulletCount(int count) {
        if (mBulletCount != null) {
            mBulletCount.setText(String.valueOf(count));

        }
    }

    public void addMissileToBoard(BaseMissile missile, OnClickListener listener) {
        if (mMissileBoard != null) {
            ImageView icon = createIcon(missile, listener);
            mMissileBoard.addView(icon);

            if (mMissileToIconMap == null) {
                mMissileToIconMap = new HashMap<>();
            }
            mMissileToIconMap.put(missile.getType().name(), icon);
        }
    }

    private ImageView createIcon(BaseMissile missile, OnClickListener listener) {
        ImageView icon = new ImageView(mContext);
        icon.setImageResource(missile.getSelectionImage());
        icon.setOnClickListener(listener);
        icon.setColorFilter(R.color.colorPrimary);
        icon.setTag(missile);
        icon.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,
                LayoutParams.MATCH_PARENT));
        return icon;
    }

    public void firstSelection(BaseMissile missile) {
        setMissileSelected(missile.getType());
    }

    public void selectMissile(BaseMissile oldMissile,
                              BaseMissile newMissile) {
        setMissileUnselected(oldMissile.getType());
        setMissileSelected(newMissile.getType());
    }

    private void setMissileSelected(MissileFactory.Type type) {
        if (mMissileToIconMap != null) {
            // Set new button selected
            ImageView newSelect = mMissileToIconMap.get(type.name());
            newSelect.setColorFilter(null);
        }
    }

    private void setMissileUnselected(MissileFactory.Type type) {
        if (mMissileToIconMap != null) {
            // Set old button back
            ImageView oldIcon = mMissileToIconMap.get(type.name());
            oldIcon.setColorFilter(R.color.colorPrimary);
        }
    }

}
