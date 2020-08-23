package com.reactnative.videocache;

import com.danikula.videocache.HttpProxyCacheServer;
import com.danikula.videocache.headers.HeaderInjector;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

import java.util.HashMap;
import java.util.Map;

public class UserAgentHeaderInjection implements HeaderInjector {

    private String authToken;

    public UserAgentHeaderInjection(String authToken) {
        this.authToken = authToken;
    }

    @Override
    public Map<String, String> addHeaders(String url) {
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Authorization", authToken);
        return headers;
    }
}
