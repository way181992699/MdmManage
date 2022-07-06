package com.seven.sbinit.redis;

import org.springframework.data.redis.connection.DataType;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @author:July 2022/7/6
 * redis 常用5大类型演示
 * String , List , Set , ZSet ,Hash
 */
@Service
public class RedisService {
    @Resource(name = "redisStringTemplate")
    RedisTemplate redisStringTemplate;

    @Resource(name = "redisTemplate")
    RedisTemplate redisTemplate;

    /**
     * redis各类型储存结构的操作演示：
     * <p>
     * 非绑定key操作
     * ValueOperations<K, V> opsForValue();
     * <HK, HV> HashOperations<K, HK, HV> opsForHash();
     * ListOperations<K, V> opsForList();
     * SetOperations<K, V> opsForSet();
     * ZSetOperations<K, V> opsForZSet();
     * 绑定key操作
     * BoundValueOperations<K, V> boundValueOps(K key);
     * <HK, HV> BoundHashOperations<K, HK, HV> boundHashOps(K key);
     * BoundListOperations<K, V> boundListOps(K key);
     * BoundSetOperations<K, V> boundSetOps(K key);
     * BoundZSetOperations<K, V> boundZSetOps(K key);
     */
    public void demonstration() {
        stringOperation();
        hashOperation();
    }

    /**
     * 1.String
     * 可以是字符串、整数或浮点数
     * 对整个字符串或字符串的一部分进行操作；对整数或浮点数进行自增或自减操作；
     */
    private void stringOperation() {
        //1.1 普通储存
        redisStringTemplate.opsForValue().set("july", "handsome");
        Object july = redisStringTemplate.opsForValue().get("july");
        System.out.println("key=july,value=" + july);
        //1.2 +过期时间 redisStringTemplate.opsForValue().set(key, value, timeout, unit) unit: TimeUnit.DAYS-天 TimeUnit.HOURS-小时 TimeUnit.MINUTES-分钟 TimeUnit.SECONDS-秒 TimeUnit.MILLISECONDS-毫秒
        redisStringTemplate.opsForValue().set("num", "123", 10, TimeUnit.SECONDS);
        Object num = redisStringTemplate.opsForValue().get("num");
        System.out.println("key=num,value=" + num);
        //1.3 将旧的 key 设置为 value，并且返回旧的 key（设置 key 的字符串 value 并返回其旧值）
        Object numR = redisStringTemplate.opsForValue().getAndSet("num", "123321");
        Object numReplace = redisStringTemplate.opsForValue().get("num");
        System.out.println("after of replace...");
        System.out.println("key=num,value=" + numReplace);
        //1.4 获取长度
        Long numSize = redisStringTemplate.opsForValue().size("num");
        System.out.println("numSize = " + numSize);
        //1.5 自增
        Long numIncrement = redisStringTemplate.opsForValue().increment("num");
        System.out.println("after num increment... ");
        System.out.println("key=num,value=" + numIncrement);
        //1.6 添加新字符串到末尾
        redisStringTemplate.opsForValue().append("july", ",very handsome!");
        Object julyAppend = redisStringTemplate.opsForValue().get("july");
        System.out.println("after july append... ");
        System.out.println("julyAppend = " + julyAppend);
        //1.6 设置Map 到redis
        Map valueMap = new HashMap();
        valueMap.put("valueMap1", "map1");
        valueMap.put("valueMap2", "map2");
        valueMap.put("valueMap3", "map3");
        redisStringTemplate.opsForValue().multiSet(valueMap);
        //1.7 如果对应的 map 集合名称不存在，则添加否则不做修改
        Map valueMapNew = new HashMap();
        valueMap.put("valueMap1", "mapNew");
        valueMap.put("valueMap2", "map2");
        valueMap.put("valueMap3", "map3");
        redisStringTemplate.opsForValue().multiSetIfAbsent(valueMapNew);
        //1.8 批量获取值
        Set keys = redisStringTemplate.keys("value*");
        List<String> list = redisStringTemplate.opsForValue().multiGet(keys);
        System.out.println("list = " + list);
        //1.9 获取key的数据类型
        DataType numType = redisStringTemplate.type("num");
        DataType julyType = redisStringTemplate.type("july");
        System.out.println("numType.toString() = " + numType.toString());
        System.out.println("julyType.toString() = " + julyType.toString());
        //1.10 key改名
//        redisStringTemplate.rename("julywe","julyNew");
        redisStringTemplate.renameIfAbsent("july", "julyNew123");
        //1.11 判断key是否存在
        Boolean keyIsExist = redisStringTemplate.hasKey("july");
        System.out.println("keyIsExist = " + keyIsExist);
        //1.12 设置过期时间
        redisStringTemplate.expire("julyNew123", 1000, TimeUnit.SECONDS);
        Date date = new Date();
        date.setTime(1688624958000L);
        redisStringTemplate.expireAt("num", date);
        //1.13 获取剩余时间
        Long aLong = redisStringTemplate.getExpire("num");
        Long expireDay = redisStringTemplate.getExpire("num", TimeUnit.DAYS);
        System.out.println("expireDay = " + expireDay);
        //1.14 持久化key
        redisStringTemplate.persist("julyNew123");
        //1.15 移动key到指定的redis数据库（0~15）
        redisTemplate.move("julyNew123", 2);
    }

    /**
     * 2.hash 「Redis hash 是一个 string 类型的 field 和 value 的映射表，hash 特别适合用于存储对象。」 「Redis 中每个 hash 可以存储 2^32 - 1 键值对（40多亿）。」
     * 包含键值对的无序散列表
     * 包含方法有添加、获取、删除单个元素
     */
    private void hashOperation() {
        //2. 新 绑定key，后续操作默认对该key做操作
        BoundHashOperations student = redisTemplate.boundHashOps("student");
        //2.1 传统储存
        redisTemplate.opsForHash().put("student0", "name", "陈浩南");
        redisTemplate.opsForHash().put("student0", "age", 18);
        redisTemplate.opsForHash().put("student0", "sex", "男");
        redisTemplate.opsForHash().put("student0", "score", "100");
        //2.2 后续全部用绑定储存 逐个储存
        student.put("name", "星少");
        student.put("hobby", "snooker");
        student.put("age", 18);
        //2.3 map储存
        Map<String, Object> map = new HashMap();
        map.put("score", 100);
        map.put("height", 170);
        map.put("weight", 60);
        student.putAll(map);

    }

    /**
     * 3.list
     * 一个链表，链表上的每个节点都包含一个字符串
     * 对链表的两端进行push和pop操作，读取单个或多个元素；根据值查找或删除元素；
     */
    private void listOperation() {

    }

    /**
     * 4.set
     * 包含字符串的无序集合
     * 字符串的集合，包含基础的方法有看是否存在添加、获取、删除；还包含计算交集、并集、差集等
     */
    private void setOperation() {

    }

    /**
     * 2.zSet
     * 和散列一样，用于存储键值对
     * 字符串成员与浮点数分数之间的有序映射；元素的排列顺序由分数的大小决定；包含方法有添加、获取、删除单个元素以及根据分值范围或成员来获取元素
     */
    private void zSetOperation() {

    }

    public void delKey(String key) {
        redisStringTemplate.delete(key);
    }

    public void delAll() {
        Set keys = redisStringTemplate.keys("*");
        redisStringTemplate.delete(keys);
    }
}
