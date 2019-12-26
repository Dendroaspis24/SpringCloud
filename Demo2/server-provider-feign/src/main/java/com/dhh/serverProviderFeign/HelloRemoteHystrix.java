package com.dhh.serverProviderFeign;

import org.springframework.stereotype.Component;

// 回调类
@Component
public class HelloRemoteHystrix implements HelloRemote {
    @Override
    public String hello(String name) {
        return  "调用hello方法,失败回调";
    }

    @Override
    public String getAge(int age) {
        return  "调用getAge方法,失败回调";
    }
}
