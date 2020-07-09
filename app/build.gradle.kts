import com.google.firebase.crashlytics.buildtools.gradle.CrashlyticsPlugin
import com.google.gms.googleservices.GoogleServicesPlugin

plugins {
  id("com.android.application")
  kotlin("android")
}

plugins.apply(GoogleServicesPlugin::class.java)
plugins.apply(CrashlyticsPlugin::class.java)

android {
  compileSdkVersion(29)
  buildToolsVersion("30.0.1")

  defaultConfig {
    applicationId = "id.kotlin.crashlytics"
    minSdkVersion(26)
    targetSdkVersion(29)
    versionCode = 1
    versionName = "1.0.0"
  }
  signingConfigs {
    create("release") {
      storeFile = file("keystore.jks")
      storePassword = "bhnk123"
      keyAlias = "bhnk"
      keyPassword = "bhnk123"
      isV2SigningEnabled = true
    }
  }
  buildTypes {
    getByName("release") {
      signingConfig = signingConfigs.getByName("release")
      isMinifyEnabled = true
      isZipAlignEnabled = true
      isShrinkResources = true
      proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
    }
  }
  buildFeatures.viewBinding = true
  sourceSets {
    getByName("main").java.srcDirs("src/main/kotlin")
  }
}

dependencies {
  implementation("org.jetbrains.kotlin:kotlin-stdlib:1.3.72")
  implementation("androidx.appcompat:appcompat:1.1.0")
  implementation("com.google.android.material:material:1.1.0")
  implementation("androidx.constraintlayout:constraintlayout:1.1.3")
  implementation("com.google.firebase:firebase-crashlytics:17.1.1")
  implementation("com.google.firebase:firebase-analytics:17.4.4")
}
