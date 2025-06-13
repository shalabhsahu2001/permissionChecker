package com.bugsmirror.permissionchecker

object PermissionMappings {
    val userFriendlyToSystem = mapOf(
        "Access to Camera" to android.Manifest.permission.CAMERA,
        "Access to Location" to android.Manifest.permission.ACCESS_FINE_LOCATION,
        "Access to Contacts" to android.Manifest.permission.READ_CONTACTS
        // Add more as needed
    )
}
