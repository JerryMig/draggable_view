package project.jerry.panobike.model;

import project.jerry.panobike.R;

/**
 * Created by Migme_Jerry on 2017/5/3.
 */

public class BaconMissile extends BaseMissile {

    @Override
    public int getBulletCount() {
        return 2;
    }

    @Override
    public int getMissileImage() {
        return R.mipmap.missile2;
    }

    @Override
    public int getSelectionImage() {
        return R.mipmap.missile_type_2;
    }

    @Override
    public int getSpeed() {
        return 1000;
    }

    @Override
    public MissileFactory.Type getType() {
        return MissileFactory.Type.Bacon;
    }

}
