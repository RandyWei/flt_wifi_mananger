#import "FltWifiManagerPlugin.h"
#if __has_include(<flt_wifi_manager/flt_wifi_manager-Swift.h>)
#import <flt_wifi_manager/flt_wifi_manager-Swift.h>
#else
// Support project import fallback if the generated compatibility header
// is not copied when this plugin is created as a library.
// https://forums.swift.org/t/swift-static-libraries-dont-copy-generated-objective-c-header/19816
#import "flt_wifi_manager-Swift.h"
#endif

@implementation FltWifiManagerPlugin
+ (void)registerWithRegistrar:(NSObject<FlutterPluginRegistrar>*)registrar {
  [SwiftFltWifiManagerPlugin registerWithRegistrar:registrar];
}
@end
