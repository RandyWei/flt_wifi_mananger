# 我的宁夏

登录SDK

## 使用说明

### 安装
```yaml
//pub方式
暂无

//导入方式
dependencies:
  flt_ningxia_login:
    git:
      url: http://mobilegit.chinahrt.com/mobile/flt_ningxia_login.git
```

### 示例

```dart
//初始化
FltNingxiaLogin.init('clientId', true);

//调起登录界面
FltNingxiaLogin.startLogin((data) => print(data))
```
