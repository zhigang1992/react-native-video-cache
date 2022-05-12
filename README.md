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
