package project.jerry.panobike.model;

import project.jerry.panobike.R;

/**
 * Created by Migme_Jerry on 2017/5/3.
 */

public class NewtonMissile extends BaseMissile {

    @Override
    public int getBulletCount() {
        return 3;
    }

    @Override
    public int getMissileImage() {
        return R.mipmap.missile3;
    }

    @Override
    public int getSelectionImage() {
        return R.mipmap.missile_type_3;
    }

    @Override
    public int getSpeed() {
        return 500;
    }

    @Override
    public MissileFactory.Type getType() {
        return MissileFactory.Type.Newton;
    }
}
