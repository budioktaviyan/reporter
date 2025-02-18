buildscript {
  repositories {
    google()
    jcenter()
  }
  dependencies {
    classpath("com.android.tools.build:gradle:4.0.0")
    classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.3.72")
    classpath("com.google.gms:google-services:4.3.3")
    classpath("com.google.firebase:firebase-crashlytics-gradle:2.2.0")
  }
}

allprojects {
  repositories {
    google()
    jcenter()
  }
}

tasks.register("clean", Delete::class) {
  delete(rootProject.buildDir)
}
