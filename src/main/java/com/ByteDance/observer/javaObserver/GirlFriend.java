package com.ByteDance.observer.javaObserver;

import java.util.Observable;

/**
 * @ClassName GirlFriendFriendshipCircle
 * @Description TODO  女朋友
 * @Version 1.0
 **/
public class GirlFriend extends Observable {

    private String name;

    public GirlFriend(String name) {
        this.name = name;
    }

    public void sendFriendshipCircle(FriendshipCircle friendshipCircle) {
        //有新的朋友圈发布
        setChanged();
        //通知
        notifyObservers(friendshipCircle);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
