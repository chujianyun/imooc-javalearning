package com.imooc.basic.inheritance;

import java.util.Collection;
import java.util.Iterator;

public class Parent<E> {

    public void eat(E e) {
        System.out.println("P:eat-->" + e);
    }

    public void eatAll(Collection<? extends E> c) {
        System.out.println("P:eatAll");
        Iterator<? extends E> iterator = c.iterator();
        while (iterator.hasNext()) {
            // 修改下面这行代码
           eat(iterator.next());
        }
    }
}
