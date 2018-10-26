package com.example.hiberate.redis;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.util.HashSet;
import java.util.Set;

public class RedisClusterTest {
    private static JedisCluster jedisCluster=null;
    private static Set<HostAndPort> hostAndPorts=null;

    public static  Set<HostAndPort> getHostAndPort(String hostAndPort){
        Set<HostAndPort> hap = new HashSet<HostAndPort>();
        String[] hosts = hostAndPort.split(",");
        String[] hs = null;
        for(String host:hosts){
            hs=host.split(":");
            hap.add(new HostAndPort(hs[0], Integer.parseInt(hs[1])));
        }
        return hap;
    }

    public static JedisCluster getJedisCluster(){
        GenericObjectPoolConfig gopc = new GenericObjectPoolConfig();//JedisPoolConfig
        gopc.setMaxTotal(32);
        gopc.setMaxIdle(4);
        gopc.setMaxWaitMillis(6000);
        hostAndPorts = getHostAndPort("127.0.0.1:6380,127.0.0.1:6381,127.0.0.1:6382,127.0.0.1:6383,127.0.0.1:6384,127.0.0.1:6385");
        jedisCluster = new JedisCluster(hostAndPorts, 2000, 2000, 3,null,gopc);
        return jedisCluster;
    }

    public static void main(String[] args) {
        jedisCluster = getJedisCluster();
        System.out.println(jedisCluster.get("name"));
    }

}
