package com.imooc.basic.serial.util;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class KryoManager {
    private static List<Class> registerList = new ArrayList<Class>();

    public static ThreadLocal<Kryo> kryos = ThreadLocal.withInitial(() -> {
        Kryo kryo = new Kryo();
        kryo.setReferences(false);
        for (int i = 0; i < registerList.size(); i++) {
            kryo.register(registerList.get(i));
        }
        return kryo;
    });


    public static void init(Class class1) {
        registerList.add(class1);
    }

    public static void writeObjects(OutputStream os, Object[] objects) {
        Output op = new Output(os);
        try {
            kryos.get().writeClassAndObject(op, objects.length);
            for (Object object : objects) {
                kryos.get().writeClassAndObject(op, object);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            op.close();
        }
    }

    public static <T> void writeSet(OutputStream os, Set<T> objects) {
        Output op = new Output(os);
        try {
            // 写长度
            kryos.get().writeClassAndObject(op, objects.size());

            // 写每个对象
            objects.forEach(o -> kryos.get().writeClassAndObject(op, objects.size()));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            op.close();
        }
    }


    public static Object[] readObjects(InputStream is) {
        try {
            Input input = new Input(is);
            int length = (Integer) kryos.get().readClassAndObject(input);
            Object[] objects = new Object[length];
            for (int i = 0; i < objects.length; i++) {
                objects[i] = kryos.get().readClassAndObject(input);
            }
            return objects;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }

    }

    public static <T> Set<T> readSet(InputStream is) {
        try {
            Input input = new Input(is);
            int length = (Integer) kryos.get().readClassAndObject(input);
            Set<T> result = new HashSet<>();
            for (int i = 0; i < length; i++) {
                result.add((T) kryos.get().readClassAndObject(input));
            }
            return result;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }

    }
}
