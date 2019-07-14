package com.imooc.basic.serial;

import com.alibaba.fastjson.JSONObject;
import com.imooc.basic.serial.entity.*;
import com.imooc.basic.serial.entity.hessian.Male;
import com.imooc.basic.serial.entity.hessian.PersonHessian;
import com.imooc.basic.serial.util.*;
import org.jeasy.random.EasyRandom;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class SerialTest {

    private File file = new File("person.data");
    private File fileHessian = new File("personHessian.data");

    private Person person;

    private PersonHessian personHessian;

    private Male male;

    @Before
    public void init() {
        person = new Person();
        person.setId(1L);
        person.setName("张三");
        person.setMale(true);

        Address address = new Address();
        address.setDetail("某某小区xxx栋yy号");
        person.setAddress(address);

        // hession对象
        personHessian = new PersonHessian();
        personHessian.setId(1L);
        personHessian.setMale(false);
        personHessian.setName("hessian");

        // man
        male = new Male();
        male.setId(1L);
        male.setMale(false);
        male.setName("hessian");

    }

    @Test(expected = NotSerializableException.class)
    public void testJDKSerial() throws IOException {
        Person person = new Person();
        person.setId(1L);
        person.setName("张三");
        person.setMale(true);

        Address address = new Address();
        address.setDetail("某某小区xxx栋yy号");
        person.setAddress(address);

        FileOutputStream out = new FileOutputStream("person.data");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(out);
        // 未实现序列化错误!
        objectOutputStream.writeObject(person);
        objectOutputStream.flush();
        objectOutputStream.close();
    }

    @Test(expected = NotSerializableException.class)
    public void testPersonExternalizable() throws IOException, ClassNotFoundException {
        PersonExternalizable person = new PersonExternalizable();
        person.setId(1L);
        person.setName("张三");
        person.setMale(true);
        person.setFriends(new ArrayList<>());

        Address address = new Address();
        address.setDetail("某某小区xxx栋yy号");
        person.setAddress(address);

        // 未实现序列化错误!
        JdkSerialUtil.writeObject(file, person);
        // 反序列化
        PersonExternalizable personTransit = JdkSerialUtil.readObject(file);
        // 判断是否相等
        Assert.assertEquals(personTransit.getName(), person.getName());
        Assert.assertEquals(personTransit.getAddress().getDetail(), person.getAddress().getDetail());
    }

    @Test
    public void testJDKSerialOverwrite() throws IOException, ClassNotFoundException {
        PersonTransit person = new PersonTransit();
        person.setId(1L);
        person.setName("张三");
        person.setMale(true);
        person.setFriends(new ArrayList<>());

        Address address = new Address();
        address.setDetail("某某小区xxx栋yy号");
        person.setAddress(address);

        // 序列化
        JdkSerialUtil.writeObject(file, person);
        // 反序列化
        PersonTransit personTransit = JdkSerialUtil.readObject(file);
        // 判断是否相等
        Assert.assertEquals(personTransit.getName(), person.getName());
        Assert.assertEquals(personTransit.getAddress().getDetail(), person.getAddress().getDetail());
    }

    /**
     * 验证Hessian序列化继承覆盖问题
     */
    @Test
    public void testHessianSerial() throws IOException {
        HessianSerialUtil.writeObject(file, male);
        Male maleGet = HessianSerialUtil.readObject(file);
        // 相等
        Assert.assertEquals(male.getName(), maleGet.getName());
        // male.getId()结果是1，maleGet.getId()结果是null
        Assert.assertNull(maleGet.getId());
        Assert.assertNotEquals(male.getId(), maleGet);
    }

    /**
     * 验证GSON序列化类型错误
     */
    @Test
    public void testGSONS() {
        Map<String, Object> map = new HashMap<>();
        final String name = "name";
        final String id = "id";
        map.put(name, "张三");
        map.put(id, 20L);

        String jsonString = GSONSerialUtil.getJsonString(map);
        Map<String, Object> mapGSON = GSONSerialUtil.parseJson(jsonString, Map.class);
        // 正确
        Assert.assertEquals(map.get(name), mapGSON.get(name));
        // 不等  map.get(id)为Long类型 mapGSON.get(id)为Double类型
        Assert.assertNotEquals(map.get(id).getClass(), mapGSON.get(id).getClass());
        Assert.assertNotEquals(map.get(id), mapGSON.get(id));
    }

    /**
     * 验证FatJson序列化类型错误
     */
    @Test
    public void testFastJson() {
        Map<String, Object> map = new HashMap<>();
        final String name = "name";
        final String id = "id";
        map.put(name, "张三");
        map.put(id, 20L);

        String fastJsonString = FastJsonUtil.getJsonString(map);
        Map<String, Object> mapFastJson = FastJsonUtil.parseJson(fastJsonString, Map.class);

        // 正确
        Assert.assertEquals(map.get(name), mapFastJson.get(name));
        // 错误  map.get(id)为Long类型 mapFastJson.get(id)为Integer类型
        Assert.assertNotEquals(map.get(id).getClass(), mapFastJson.get(id).getClass());
        Assert.assertNotEquals(map.get(id), mapFastJson.get(id));
    }

    /**
     * 验证FatJson对象转换
     */
    @Test
    public void testFastJsonObject() {
        Map<String, Object> map = new HashMap<>();
        final String name = "name";
        final String id = "id";
        map.put(name, "张三");
        map.put(id, 20L);

        String fastJsonString = FastJsonUtil.getJsonString(map);
        // 模拟拿到服务B的数据
        Map<String, Object> mapFastJson = FastJsonUtil.parseJson(fastJsonString, map.getClass());
        // 转成强类型属性的对象
        User user = new JSONObject(map).toJavaObject(User.class);
        // 正确
        Assert.assertEquals(map.get(name), mapFastJson.get(name));
        // 正确
        Assert.assertEquals(map.get(id), user.getId());
    }


    /**
     * 性能对比
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @Test
    public void testJavaPerformance() throws IOException, ClassNotFoundException {
        EasyRandom easyRandom = new EasyRandom();
        Set<User> userSet = easyRandom
                .objects(User.class, 100000)
                .collect(Collectors.toSet());

        SerialData javaSerialData = new SerialData();
        javaSerialData.setStart(getCurrentTime());
        // -------java序列化----------
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        JdkSerialUtil.writeObject(outputStream, userSet);
        javaSerialData.setSerialOver(getCurrentTime());
        byte[] bytes = outputStream.toByteArray();
        javaSerialData.setBytes(bytes.length);
        javaSerialData.setGetByteOver(getCurrentTime());
        ByteArrayInputStream inputStream = new ByteArrayInputStream(bytes);
        Set<User> personSetJdk = JdkSerialUtil.readObject(inputStream);
        javaSerialData.setUnSerialOver(getCurrentTime());
        System.out.println("java序列化:" + javaSerialData);
        System.out.println("--------------");

        // ----------hessian序列化--------
        SerialData hessianSerialData = new SerialData();
        hessianSerialData.setStart(getCurrentTime());
        ByteArrayOutputStream outputStream2 = new ByteArrayOutputStream();
        HessianSerialUtil.writeObject(outputStream2, userSet);
        hessianSerialData.setSerialOver(getCurrentTime());
        byte[] bytes2 = outputStream2.toByteArray();
        hessianSerialData.setBytes(bytes2.length);
        hessianSerialData.setGetByteOver(getCurrentTime());
        ByteArrayInputStream inputStream2 = new ByteArrayInputStream(bytes2);

        Set<User> personSetHessian = HessianSerialUtil.readObject(inputStream2);
        hessianSerialData.setUnSerialOver(getCurrentTime());
        System.out.println("Hessian:" + hessianSerialData);
        System.out.println("--------------");

        // ----------kryo序列化--------
        SerialData kryoSerialData = new SerialData();
        kryoSerialData.setStart(getCurrentTime());
        ByteArrayOutputStream outputStream3 = new ByteArrayOutputStream();
        KryoSerialUtil.writeObject(outputStream3, userSet);
        kryoSerialData.setSerialOver(getCurrentTime());
        byte[] bytes3 = outputStream3.toByteArray();
        kryoSerialData.setBytes(bytes3.length);
        kryoSerialData.setGetByteOver(getCurrentTime());
        ByteArrayInputStream inputStream3 = new ByteArrayInputStream(bytes3);

        Set<User> personSetKryo = KryoSerialUtil.readObject(inputStream3, HashSet.class);
        kryoSerialData.setUnSerialOver(getCurrentTime());
        System.out.println("Kryo:" + kryoSerialData);
        System.out.println("--------------");

        // ----------kryo序列化 自定义序列化器--------
        SerialData kryoSerialData2 = new SerialData();
        kryoSerialData2.setStart(getCurrentTime());
        ByteArrayOutputStream outputStream4 = new ByteArrayOutputStream();
        KryoSerialUtil.writeSet(outputStream4, userSet);
        kryoSerialData2.setSerialOver(getCurrentTime());
        byte[] bytes4 = outputStream4.toByteArray();
        kryoSerialData2.setBytes(bytes4.length);
        kryoSerialData2.setGetByteOver(getCurrentTime());
        ByteArrayInputStream inputStream4 = new ByteArrayInputStream(bytes4);

        Set<User> personSetKryo2 = KryoSerialUtil.readSet(inputStream4, HashSet.class);
        kryoSerialData2.setUnSerialOver(getCurrentTime());
        System.out.println("kryo注册:" + kryoSerialData2);
        System.out.println("--------------");


        // ----------JSON序列化------------
        SerialData gSONSerialData = new SerialData();
        gSONSerialData.setStart(getCurrentTime());
        String jsonString = GSONSerialUtil.getJsonString(userSet);
        gSONSerialData.setSerialOver(getCurrentTime());
        byte[] bytes5 = jsonString.getBytes();
        gSONSerialData.setBytes(bytes5.length);
        gSONSerialData.setGetByteOver(getCurrentTime());
        Set<User> persongSON = GSONSerialUtil.parseJson(jsonString, userSet.getClass());
        gSONSerialData.setUnSerialOver(getCurrentTime());
        System.out.println("GSON:" + gSONSerialData);
        System.out.println("--------------");

    }

    private Long getCurrentTime() {
        return Calendar.getInstance().getTimeInMillis();
    }

}
