package com.imooc.basic.nullpoint;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class NullDemoTest {

    @Test(expected = IllegalArgumentException.class)
    public void doSomething() {
        List<String> params = new ArrayList<>();
        NullDemo.doSomething2(params);
    }

    @Test
    public void doSomething5() {
        String param = null;
        NullDemo.doSomething7(param);
    }

    @Test
    public void mock() {

      /*  if (Boolean.TRUE.equals(someRemoteCall())) {
             // 业务代码
        }*/

    }

  /*  private Boolean someRemoteCall() {
        // 可能返回null

    }*/
}

