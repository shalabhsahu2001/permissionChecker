package com.bugsmirror.permissionchecker

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.provider.Settings

class PermissionChecker(private val context: Context) {

    fun getAppsByPermissions(userFriendlyPermissions: List<String>): List<AppInfo> {
        val systemPermissions = userFriendlyPermissions.mapNotNull {
            PermissionMappings.userFriendlyToSystem[it]
        }.toSet()

        val pm = context.packageManager
        val installedApps = pm.getInstalledApplications(PackageManager.GET_META_DATA)
        val result = mutableListOf<AppInfo>()

        for (app in installedApps) {
            try {
                val pkgInfo = pm.getPackageInfo(app.packageName, PackageManager.GET_PERMISSIONS)
                val requestedPermissions = pkgInfo.requestedPermissions?.toSet() ?: continue

                if (systemPermissions.any { requestedPermissions.contains(it) }) {
                    val appName = app.loadLabel(pm).toString()
                    val icon = app.loadIcon(pm)
                    result.add(AppInfo(appName, app.packageName, icon))
                }
            } catch (_: Exception) { /* Handle exceptions gracefully */ }
        }

        return result
    }

    fun openAppSettings(packageName: String) {
        val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS).apply {
            data = Uri.parse("package:$packageName")
            flags = Intent.FLAG_ACTIVITY_NEW_TASK
        }
        context.startActivity(intent)
    }
}
