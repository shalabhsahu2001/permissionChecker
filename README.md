# PermissionChecker Project

## Modules

### 1. permissionchecker (AAR Library)
Provides:
- `getAppsByPermissions(...)`: Queries apps requesting specific permissions.
- `openAppSettings(...)`: Opens app settings by package name.

#### Supported Input
- `"Access to Camera"` → `android.permission.CAMERA`
- `"Access to Location"` → `android.permission.ACCESS_FINE_LOCATION`
- (See `PermissionMappings.kt` for more)

### 2. samplehost (Sample App)
- UI for entering permission names
- Displays matching apps
- Opens app settings on click

## Setup

1. Clone project
2. Open in Android Studio
3. Run the `samplehost` module

## SDK Requirements
- minSdkVersion = 26
- targetSdkVersion = 36
