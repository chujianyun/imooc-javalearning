package com.imooc.basic.serial.util;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.FastOutput;
import com.esotericsoftware.kryo.io.Input;
import org.objenesis.strategy.StdInstantiatorStrategy;

import java.io.*;

public class KryoSerialUtil {


    public static <T> void writeObject(File file, T data) throws IOException {
        FastOutput output = new FastOutput(new FileOutputStream(file));
        Kryo kryo = new Kryo();
        kryo.writeClassAndObject(output, data);
        output.flush();
    }

    public static <T> void writeObject(ByteArrayOutputStream outputStream, T data) throws IOException {
        Kryo kryo = new Kryo();
        FastOutput output = new FastOutput(outputStream, 1024 * 1024);
        kryo.writeClassAndObject(output, data);
        output.flush();

    }

    public static <T> T readObject(File file, Class clazz) throws IOException {
        Kryo kryo = new Kryo();
        return (T) kryo.readObject(new Input(new FileInputStream(file)), clazz);
    }

    public static <T> T readObject(ByteArrayInputStream inputStream, Class clazz) throws IOException, ClassNotFoundException {
        Kryo kryo = new Kryo();
        return (T) kryo.readObject(new Input(inputStream), clazz);
    }

}
