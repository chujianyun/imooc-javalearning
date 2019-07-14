package com.imooc.basic.serial.util;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.FastOutput;
import com.esotericsoftware.kryo.io.Input;
import com.imooc.basic.serial.entity.User;

import java.io.*;
import java.util.Set;

public class KryoSerialUtil {

    static {
        try {
            KryoManager.init(Class.forName(User.class.getName()));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static <T> void writeObject(File file, T data) throws IOException {
        FastOutput output = new FastOutput(new FileOutputStream(file));
        Kryo kryo = new Kryo();
        kryo.writeClassAndObject(output, data);
        output.flush();
        output.close();
    }

    public static <T> void writeObject(ByteArrayOutputStream outputStream, T data) {
        Kryo kryo = new Kryo();
        FastOutput output = new FastOutput(outputStream, 1024 * 1024);
        kryo.writeClassAndObject(output, data);
        output.flush();
        output.close();
    }

    public static <T> void writeSet(ByteArrayOutputStream outputStream, Set<T> set) {
        FastOutput output = new FastOutput(outputStream, 1024 * 1024);
        KryoManager.writeSet(output, set);
    }

    public static <T> T readObject(File file, Class clazz) throws IOException {
        Kryo kryo = new Kryo();
        return (T) kryo.readObject(new Input(new FileInputStream(file)), clazz);
    }

    public static <T> T readObject(ByteArrayInputStream inputStream, Class clazz) {
        Kryo kryo = new Kryo();
        return (T) kryo.readObject(new Input(inputStream), clazz);
    }

    public static <T> Set<T> readSet(ByteArrayInputStream inputStream, Class<? extends Set> type) {
        return KryoManager.readSet(inputStream);
    }
}
