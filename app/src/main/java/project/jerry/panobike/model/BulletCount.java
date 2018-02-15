package project.jerry.panobike.model;

import project.jerry.panobike.util.OutOfBulletException;

/**
 * Created by Migme_Jerry on 2017/5/3.
 */

public class BulletCount {

    private int mBulletCount;

    public BulletCount(int initialCount) {
        mBulletCount = initialCount;
    }

    public int fire(BaseMissile missile) throws OutOfBulletException {
        int bulletConsumption = missile.getBulletCount();
        if (mBulletCount < bulletConsumption) {
            throw new OutOfBulletException("Sorry! You're out of bullets.");
        } else {
            // return remaining bullet count
            return mBulletCount -= bulletConsumption;
        }
    }

}
