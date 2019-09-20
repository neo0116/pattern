package com.ByteDance.observer.javaObserver;

/**
 * @ClassName ObserverTest
 * @Description TODO
 * @Version 1.0
 **/
public class ObserverTest {

    public static void main(String[] args) {
        //被观察者
        GirlFriend girlFriend = new GirlFriend("CMY");


        //发微信朋友圈
        FriendshipCircle friendshipCircle = new FriendshipCircle();
        friendshipCircle.setDesc("上班好累哦，好想吃了睡 睡了吃~~");

        //把观察者加入集合中
        girlFriend.addObserver(new BoyFriend());
        girlFriend.addObserver(new BPlan());
        girlFriend.sendFriendshipCircle(friendshipCircle);
    }
}
