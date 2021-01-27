import 'dart:async';
import 'dart:io';

import 'package:flutter/services.dart';

class FltWifiManager {
  static const MethodChannel _channel =
      const MethodChannel('icu.bughub.plugins/flt_wifi_manager');

  static Future<String> get platformVersion async {
    final String version = await _channel.invokeMethod('getPlatformVersion');
    return version;
  }

  static void turnOn() {
    if (Platform.isAndroid) _channel.invokeMethod("turnOn");
  }

  static void turnOff() {
    if (Platform.isAndroid) _channel.invokeMethod("turnOff");
  }
}
