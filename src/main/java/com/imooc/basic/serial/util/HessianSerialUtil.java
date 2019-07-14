package com.imooc.basic.serial.util;

import com.caucho.hessian.io.Hessian2Input;
import com.caucho.hessian.io.Hessian2Output;
import com.caucho.hessian.io.HessianInput;
import com.caucho.hessian.io.HessianOutput;

import java.io.*;

/**
 * Hessian序列化工具
 */
public class HessianSerialUtil {

    public static <T> void writeObject(File file, T data) throws IOException {
        FileOutputStream fo = new FileOutputStream(file);
        Hessian2Output ho = new Hessian2Output(fo);
        ho.writeObject(data);
        ho.close();
    }

    public static <T> void writeObject(ByteArrayOutputStream outputStream, T data) throws IOException {
        Hessian2Output ho = new Hessian2Output(outputStream);
        ho.writeObject(data);
        ho.close();
    }

    public static <T> T readObject(File file) throws IOException {
        FileInputStream fin = new FileInputStream(file);
        Hessian2Input hessianInput = new Hessian2Input(fin);
        return (T) hessianInput.readObject();
    }

    public static <T> T readObject(ByteArrayInputStream inputStream) throws IOException {
        Hessian2Input hessianInput = new Hessian2Input(inputStream);
        return (T) hessianInput.readObject();
    }
}
