package project.jerry.panobike.model;

import project.jerry.panobike.R;

/**
 * Created by Migme_Jerry on 2017/5/3.
 */

public class DavincciMissile extends BaseMissile {

    @Override
    public int getBulletCount() {
        return 1;
    }

    @Override
    public int getMissileImage() {
        return R.mipmap.missile1;
    }

    @Override
    public int getSelectionImage() {
        return R.mipmap.missile_type_1;
    }

    @Override
    public int getSpeed() {
        return 1500;
    }

    @Override
    public MissileFactory.Type getType() {
        return MissileFactory.Type.Davincci;
    }

}
