// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.0.2" apply false
    id("com.android.library") version "8.0.2" apply false
    id("org.jetbrains.kotlin.android") version "1.8.20" apply false
//    id("org.jetbrains.kotlin.jvm") version "1.8.20" apply false
}

// 设置全局的 defaultConfig
/*ext {

    val defaultMinSdkVersion = 24
    val defaultTargetSdkVersion = 33
    val testRunner = "androidx.test.runner.AndroidJUnitRunner"

}*/

/*subprojects {
    afterEvaluate {
        if (project.plugins.hasPlugin("com.android.application") || project.plugins.hasPlugin("com.android.library")) {
            android {
                compileSdk = rootProject.ext.defaultTargetSdkVersion
                defaultConfig {
                    minSdk = rootProject.ext.defaultMinSdkVersion
                    targetSdk = rootProject.ext.defaultTargetSdkVersion
                }
            }
        }
    }
}*/
