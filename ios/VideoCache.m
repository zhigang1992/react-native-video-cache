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
    return [KTVHTTPCache proxyURLWithOriginalURL:[NSURL URLWithString:url]].absoluteString;
}

@end
