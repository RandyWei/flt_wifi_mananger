package com.example.flt_wifi_manager

import android.content.Context
import android.content.Intent
import android.net.wifi.WifiManager
import android.os.Build
import android.provider.Settings
import androidx.annotation.NonNull
import androidx.core.app.ActivityCompat.startActivityForResult

import io.flutter.embedding.engine.plugins.FlutterPlugin
import io.flutter.embedding.engine.plugins.activity.ActivityAware
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugin.common.MethodChannel.MethodCallHandler
import io.flutter.plugin.common.MethodChannel.Result
import io.flutter.plugin.common.PluginRegistry.Registrar

/** FltWifiManagerPlugin */
class FltWifiManagerPlugin : FlutterPlugin, MethodCallHandler, ActivityAware {
    /// The MethodChannel that will the communication between Flutter and native Android
    ///
    /// This local reference serves to register the plugin with the Flutter Engine and unregister it
    /// when the Flutter Engine is detached from the Activity
    private lateinit var channel: MethodChannel
    private lateinit var flutterPluginBinding: FlutterPlugin.FlutterPluginBinding
    private lateinit var activityBinding: ActivityPluginBinding

    override fun onAttachedToEngine(@NonNull flutterPluginBinding: FlutterPlugin.FlutterPluginBinding) {
        channel = MethodChannel(flutterPluginBinding.binaryMessenger, "icu.bughub.plugins/flt_wifi_manager")
        this.flutterPluginBinding = flutterPluginBinding
        channel.setMethodCallHandler(this)
    }

    override fun onMethodCall(@NonNull call: MethodCall, @NonNull result: Result) {
        when (call.method) {
            "getPlatformVersion" -> {
                result.success("Android ${android.os.Build.VERSION.RELEASE}")
            }
            "turnOn" -> {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                    try {
                        val panelIntent = Intent(Settings.Panel.ACTION_INTERNET_CONNECTIVITY)
                        panelIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                        activityBinding.activity.startActivity(panelIntent)
                    } catch (e: Exception) {
                    }
                } else {
                    val wifiManager = flutterPluginBinding.applicationContext.getSystemService(Context.WIFI_SERVICE) as WifiManager
                    wifiManager.isWifiEnabled = true
                }
                result.success(null)
            }
            "turnOff" -> {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                    try {
                        val panelIntent = Intent(Settings.Panel.ACTION_INTERNET_CONNECTIVITY)
                        panelIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                        activityBinding.activity.startActivity(panelIntent)
                    } catch (e: Exception) {
                    }
                } else {
                    val wifiManager = flutterPluginBinding.applicationContext.getSystemService(Context.WIFI_SERVICE) as WifiManager
                    wifiManager.isWifiEnabled = false
                }
                result.success(null)
            }
            else -> {
                result.notImplemented()
            }
        }
    }

    override fun onDetachedFromEngine(@NonNull binding: FlutterPlugin.FlutterPluginBinding) {
        channel.setMethodCallHandler(null)
    }

    override fun onAttachedToActivity(binding: ActivityPluginBinding) {
        this.activityBinding = binding
    }

    override fun onDetachedFromActivityForConfigChanges() {

    }

    override fun onReattachedToActivityForConfigChanges(binding: ActivityPluginBinding) {

    }

    override fun onDetachedFromActivity() {

    }
}
