// @flow
import { NativeModules } from 'react-native';

const { VideoCache } = NativeModules;

export const convertToProxyURL: (url: string) => string = VideoCache.convert;
export const convertToProxyURLAsync: (url: string) => Promise<string> = VideoCache.convertAsync;

export default VideoCache.convert;
