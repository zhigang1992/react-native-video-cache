#import "VideoCache.h"
#import <KTVHTTPCache/KTVHTTPCache.h>

@implementation VideoCache

RCT_EXPORT_MODULE()

RCT_EXPORT_BLOCKING_SYNCHRONOUS_METHOD(convert:(NSString *)url)
{
    if (!KTVHTTPCache.proxyIsRunning) {
      NSError *error;
      [KTVHTTPCache proxyStart:&error];
      if (error) {
        return url;
      }
    }
    NSURL* videoUrl = [NSURL URLWithString:url];
    @try {
        NSURL *completedCacheFileURL = [KTVHTTPCache cacheCompleteFileURLWithURL:videoUrl];
        if (completedCacheFileURL != nil) {
            return completedCacheFileURL.absoluteString;
        }
    }
    @catch (NSException *exception) {
    }
    
    return [KTVHTTPCache proxyURLWithOriginalURL:videoUrl].absoluteString;
}

RCT_EXPORT_METHOD(convertAsync:(NSString *)url
                  resolver:(RCTPromiseResolveBlock)resolve
                  rejecter:(RCTPromiseRejectBlock)reject)
{
  if (!KTVHTTPCache.proxyIsRunning) {
    NSError *error;
    [KTVHTTPCache proxyStart:&error];
    if (error) {
      reject(@"init.error", @"failed to start proxy server", error);
      return;
    }
  }
  NSURL* videoUrl = [NSURL URLWithString:url];
  @try {
      NSURL *completedCacheFileURL = [KTVHTTPCache cacheCompleteFileURLWithURL:videoUrl];
      if (completedCacheFileURL != nil) {
          resolve(completedCacheFileURL.absoluteString);
          return;
      }
  }
  @catch (NSException *exception) {
  }
  resolve([KTVHTTPCache proxyURLWithOriginalURL:videoUrl].absoluteString);
}

@end
