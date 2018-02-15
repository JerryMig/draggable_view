package project.jerry.panobike.controller;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import project.jerry.panobike.R;
import project.jerry.panobike.model.BaseMissile;
import project.jerry.panobike.model.BulletCount;
import project.jerry.panobike.model.MissileFactory;
import project.jerry.panobike.util.OutOfBulletException;
import project.jerry.panobike.view.DraggableView;
import project.jerry.panobike.view.InformationView;

public class MainActivity extends AppCompatActivity {

    private final String TAG = MainActivity.this.getClass().getSimpleName();
    private final int BULLET_COUNT = 100;

    private RelativeLayout mMainContainer;
    private InformationView mInformationView;
    private DraggableView mDraggableView;

    private BulletCount mBulletCount;
    private BaseMissile mCurrentMissile;
    private View.OnClickListener mSelectionListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            BaseMissile newType = (BaseMissile) view.getTag();
            mInformationView.selectMissile(mCurrentMissile, newType);
            mCurrentMissile = newType;
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMainContainer = (RelativeLayout) this.findViewById(R.id.main_container);
        mDraggableView = (DraggableView) this.findViewById(R.id.draggable_image);

        mCurrentMissile = MissileFactory.getMissle(MissileFactory.Type.Davincci);
        mBulletCount = new BulletCount(BULLET_COUNT);

        initInfoView();
    }

    private void initInfoView() {
        mInformationView = (InformationView) this.findViewById(R.id.information_view);
        // add missile to selection board
        for (MissileFactory.Type type : MissileFactory.Type.values()) {
            BaseMissile missile = MissileFactory.getMissle(type);
            mInformationView.addMissileToBoard(missile, mSelectionListener);
        }
        mInformationView.firstSelection(mCurrentMissile);
    }

    public void fireMissile(View view) {
        try {
            int remainingCount = mBulletCount.fire(mCurrentMissile);
            mInformationView.updateBulletCount(remainingCount);
            addMissileToView();
        } catch (OutOfBulletException e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }

    private void addMissileToView() {
        // set up view
        final ImageView missile = new ImageView(this);
        missile.setImageResource(mCurrentMissile.getMissileImage());
        mMainContainer.addView(missile);

        // set up animation
        float startX = mDraggableView.getX() + (float) (mDraggableView.getWidth() / 2.5);
        float startY = mDraggableView.getY() - (float) (mDraggableView.getHeight() / 2.5);
        Animation slide = new TranslateAnimation(startX, startX, startY, 0);
        slide.setDuration(mCurrentMissile.getSpeed());
        slide.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                mMainContainer.removeView(missile);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        missile.startAnimation(slide);
    }

}
