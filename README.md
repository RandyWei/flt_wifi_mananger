# wifi 管理器

wifi 管理器，在 Android Q 之前，可直接控制 WIFI 开关；在 Android Q 之后，会直接打开 wifi 面板

## 使用说明

### 安装
```yaml
//pub方式
暂无

//导入方式
dependencies:
  flt_wifi_mananger:
    git:
      url: https://github.com/RandyWei/flt_wifi_mananger.git
```

### 配置权限
在android/app/src/main/AndroidManifest.xml 中添加以下权限
```xml
    <uses-permission android:name="android.permission.CHANGE_WIFI_STATE" />
    <uses-permission android:name="android.permission.ACCESS_WIFI_STATE" />
```

### 示例

导包
```dart
import 'package:flt_wifi_manager/flt_wifi_manager.dart'; 
```

```dart
// 打开 WIFI
FltWifiManager.turnOn();

// 关闭 WIFI
FltWifiManager.turnOff();
```
