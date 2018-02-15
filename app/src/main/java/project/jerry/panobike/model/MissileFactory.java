package project.jerry.panobike.model;

import java.util.HashMap;
import java.util.Map;

import project.jerry.panobike.R;

/**
 * Created by Migme_Jerry on 2017/5/3.
 */

public class MissileFactory {

    public enum Type {
        Davincci, Bacon, Newton
//        private int mBulletCount;
//        private int mSelectionImage;
//        private int mFireImage;
//        private int mSpeed;
//
//        Type(int bullet, int selectionImage, int fireImage, int speed) {
//            mBulletCount = bullet;
//            mSelectionImage = selectionImage;
//            mFireImage = fireImage;
//            mSpeed = speed;
//        }
//
//        public int getBulletCount() {
//            return mBulletCount;
//        }
//
//        public int getSelectionImage() {
//            return mSelectionImage;
//        }
//
//        public int getFireImage() {
//            return mFireImage;
//        }
//
//        public int getSpeed() {
//            return mSpeed;
//        }
    }

    private static Map<Type, BaseMissile> mMissileMap = new HashMap<>();

    static {
        mMissileMap.put(Type.Davincci, new DavincciMissile());
        mMissileMap.put(Type.Bacon, new BaconMissile());
        mMissileMap.put(Type.Newton, new NewtonMissile());
    }

    public static BaseMissile getMissle(Type type) {
        BaseMissile missile = mMissileMap.get(type);
        if (missile == null) {
            throw new RuntimeException("Such missile doesn't exist" + type);
        }
        return missile;
    }

}
