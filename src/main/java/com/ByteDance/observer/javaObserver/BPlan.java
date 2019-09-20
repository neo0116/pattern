package com.ByteDance.observer.javaObserver;

import java.util.Observable;
import java.util.Observer;

/**
 * @ClassName BPlan
 * @Description TODO 备胎
 * @Version 1.0
 **/
public class BPlan implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        GirlFriend girlFriend = (GirlFriend) o;
        FriendshipCircle friendshipCircle = (FriendshipCircle) arg;

        System.out.println("我是备胎，我女神发了朋友圈，赶紧去看看");
        System.out.println("女神发了：" + friendshipCircle.getDesc());
    }
}
