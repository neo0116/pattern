package com.ByteDance.proxy.bdproxy;

import java.util.List;

/**
 * @Description //TODO 漫威
 * @Author wfq
 * @Date 9:25 2019/9/18
 **/
public interface Marvel {


    void attackBadPerson();

    String getSlogan();

    String getSlogan1(String name);

    String getSlogan2(List<String> name);

    String getSlogan3(String[] name);

    String getSlogan4(int[] name);

    String getSlogan5(double[] name);

    String getSlogan6(String name, int num);

    List<String> getSlogan7();

}
