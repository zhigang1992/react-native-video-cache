package com.reactnative.videocache;

import com.danikula.videocache.HttpProxyCacheServer;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

public class VideoCacheModule extends ReactContextBaseJavaModule {

    private final ReactApplicationContext reactContext;
    private HttpProxyCacheServer proxy;

    public VideoCacheModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
    }

    @Override
    public String getName() {
        return "VideoCache";
    }

    @ReactMethod
    public void convert(
            String url,
            String authToken,
            Promise promise) {
        if (this.proxy == null) {
//            this.proxy = new HttpProxyCacheServer(this.reactContext);
            if (authToken != null && !authToken.isEmpty()) {
                this.proxy = new HttpProxyCacheServer.Builder(this.reactContext)
                        .headerInjector(new UserAgentHeaderInjection(authToken))
                        .build();
            } else {
                this.proxy = new HttpProxyCacheServer.Builder(this.reactContext)
                        .build();
            }

        }

        promise.resolve(this.proxy.getProxyUrl(url));
    }
}
