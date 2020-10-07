# react-native-video-cache

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

Both sync and async named methods are also exported:
```javascript
import { convertToProxyURL, convertToProxyURLAsync } from 'react-native-video-cache';

convertToProxyURLAsync(originalURL).then(newUrl => console.log(`Got proxy url ${newUrl}`))
```
Note that the Chrome debugger does not currently support synchronous calls to native 
methods, so you can use the async method for compatibility.