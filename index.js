import { NativeModules } from 'react-native';

export default (url) => {
  if (!global.nativeCallSyncHook) {
    return url
  }
  return NativeModules.VideoCache.convert(url)
};

export const convertAsync = NativeModules.VideoCache.convertAsync;

export const setIgnoreUrlParams = (shouldIgnore) => {
  if (Platform.OS === "web") {
    return Promise.resolve();
  }
  return NativeModules.VideoCache.setIgnoreUrlParams(shouldIgnore);
};
