import { NativeModules } from 'react-native';

export default (url) => {
  if (!global.nativeCallSyncHook) {
    return url
  }
  return NativeModules.VideoCache.convert(url)
};
