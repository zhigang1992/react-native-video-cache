# react-native-video-cache

* Fixed its android conflict with react native v0.67 (gradle > 0.7)

Boost performance on online video loading and caching

Use following libraries to do the heavy lifting.

- iOS: https://github.com/ChangbaDevs/KTVHTTPCache
- Android: https://github.com/danikula/AndroidVideoCache

## Getting started

`$ yarn add react-native-video-cache`

### Mostly automatic installation

`$ react-native link react-native-video-cache`

## Usage

```javascript
import convertToProxyURL from 'react-native-video-cache';
...
<Video source={{uri: convertToProxyURL(originalURL)}} />
```

### Ignoring url parameters
It might be useful to disregard url parameters when generating the cache key if you are using a CDN which uses url parameters for authentication.

At application startup:
```javascript
import convertToProxyURL from 'react-native-video-cache';
// ...
await convertToProxyURL.setIgnoreUrlParams(true);

```
### Install on android

Edit your `android/build.gradle` file and add the following lines:

```
        maven {
            url "$rootDir/../node_modules/react-native-video-cache/android/libs"
        }
```

to your `allprojects/repositories`
