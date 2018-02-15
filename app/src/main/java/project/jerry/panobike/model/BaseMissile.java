package project.jerry.panobike.model;

/**
 * Created by Migme_Jerry on 2017/5/3.
 */

public abstract class BaseMissile {

    public abstract int getBulletCount();
    public abstract int getMissileImage();
    public abstract int getSelectionImage();
    public abstract int getSpeed();
    public abstract MissileFactory.Type getType();


}
