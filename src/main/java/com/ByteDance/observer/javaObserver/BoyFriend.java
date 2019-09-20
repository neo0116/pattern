package com.ByteDance.observer.javaObserver;

import java.util.Observable;
import java.util.Observer;

/**
 * @ClassName BoyFriendFiendshipCircle
 * @Description TODO 男朋友
 * @Version 1.0
 **/
public class BoyFriend implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        GirlFriend girlFriend = (GirlFriend) o;
        FriendshipCircle friendshipCircle = (FriendshipCircle) arg;

        System.out.println("我女朋友发了朋友圈，赶紧去看看");
        System.out.println("女朋友发了：" + friendshipCircle.getDesc());
    }
}
