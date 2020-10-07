// @flow
import { NativeModules } from 'react-native';

export const convertToProxyURL = (url: string) => string {
  if (!global.nativeCallSyncHook) {
    return url
  }
  return NativeModules.VideoCache.convert(url)
};
export const convertToProxyURLAsync: (url: string) => Promise<string> = VideoCache.convertAsync;
export default convertToProxyURL;

