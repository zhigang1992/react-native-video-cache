package com.reactnative.videocache;

import android.net.Uri;
import com.danikula.videocache.HttpProxyCacheServer;
import com.danikula.videocache.file.FileNameGenerator;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

class UrlParamOmitter implements FileNameGenerator {
    public String generate(String url) {
        Uri uri = Uri.parse(url).buildUpon().clearQuery().build();
        return uri.toString();
    }
}

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

    @ReactMethod(isBlockingSynchronousMethod = true)
    public String convert(String url) {
        if (this.proxy == null) {
            this.proxy = new HttpProxyCacheServer(this.reactContext);
        }
        return this.proxy.getProxyUrl(url);
    }

    @ReactMethod
    public void convertAsync(String url, Promise promise) {
        if (this.proxy == null) {
            this.proxy = new HttpProxyCacheServer(this.reactContext);
        }
        promise.resolve(this.proxy.getProxyUrl(url));
    }

    @ReactMethod
    public void setIgnoreUrlParams(Boolean shouldIgnore, Promise promise) {
        if (this.proxy == null) {
            if (shouldIgnore) {
                this.proxy = new HttpProxyCacheServer.Builder(this.reactContext)
                        .fileNameGenerator(new UrlParamOmitter())
                        .build();
            } else {
                this.proxy = new HttpProxyCacheServer(this.reactContext);
            }
        }

        promise.resolve("success");
    }

}
