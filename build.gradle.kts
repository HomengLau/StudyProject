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


subprojects {
  /*  repositories {
        mavenCentral()
        google()
        maven("https://maven.kr328.app/releases")
    }*/

    val isApp = name == "app"

    apply(plugin = if (isApp) "com.android.application" else "com.android.library")

    extensions.configure<com.android.build.gradle.BaseExtension> {

        defaultConfig {
            if (isApp) {
                applicationId = "com.homeng.study"
            }

            minSdk = 26
            targetSdk = 33

            versionName = "0.9.3"
            versionCode = 105

            resValue("string", "release_name", "v$versionName")
            resValue("integer", "release_code", "$versionCode")

            externalNativeBuild {
                cmake {
                    abiFilters("arm64-v8a", "armeabi-v7a", "x86", "x86_64")
                }
            }

            if (!isApp) {
                consumerProguardFiles("consumer-rules.pro")
            } else {
                setProperty("archivesBaseName", "rocket-$versionName")
            }
        }

        ndkVersion = "23.0.7599858"

        compileSdkVersion(defaultConfig.targetSdk!!)

       /* if (isApp) {
            packagingOptions {
                resources {
                    excludes.add("DebugProbesKt.bin")
                }
            }
        }*/

        /*productFlavors {
            flavorDimensions("feature")

            create("foss") {
                isDefault = true
                dimension = flavorDimensionList[0]
                versionNameSuffix = ""

                buildConfigField("boolean", "PREMIUM", "Boolean.parseBoolean(\"false\")")

                if (isApp) {
                    applicationIdSuffix = ""
                }
            }
            create("premium") {
                dimension = flavorDimensionList[0]
                versionNameSuffix = ".premium"

                buildConfigField("boolean", "PREMIUM", "Boolean.parseBoolean(\"true\")")
            }
        }

        signingConfigs {
            val keystore = rootProject.file("signing.properties")
            if (keystore.exists()) {
                create("release") {
                    val prop = java.util.Properties().apply {
                        keystore.inputStream().use(this::load)
                    }

                    storeFile = rootProject.file(prop.getProperty("keystore.path")!!)
                    storePassword = prop.getProperty("keystore.password")!!
                    keyAlias = prop.getProperty("key.alias")!!
                    keyPassword = prop.getProperty("key.password")!!
                }
            }
        }

        buildTypes {
            named("release") {
                isMinifyEnabled = isApp
                isShrinkResources = isApp
                signingConfig = signingConfigs.findByName("release")
                proguardFiles(
                    getDefaultProguardFile("proguard-android-optimize.txt"),
                    "proguard-rules.pro"
                )
            }
            named("debug") {
                versionNameSuffix = ".debug"
            }
        }

        buildFeatures.apply {
            dataBinding {
                isEnabled = name != "hideapi"
            }
            viewBinding {
                isEnabled = name != "hideapi"
            }
            buildConfig = true
        }

        variantFilter {
            ignore = name.startsWith("premium") && !project(":core")
                .file("src/premium/golang/clash/go.mod").exists()
        }*/

        /*if (isApp) {
            this as com.android.build.gradle.AppExtension

            splits {
                abi {
                    isEnable = true
                    isUniversalApk = true
                }
            }
        }*/
    }
}

task("clean", type = Delete::class) {
    delete(rootProject.buildDir)
}
/*
tasks.wrapper {
    distributionType = Wrapper.DistributionType.ALL

    doLast {
        val sha256 = java.net.URL("$distributionUrl.sha256").openStream()
            .use { it.reader().readText().trim() }

        file("gradle/wrapper/gradle-wrapper.properties")
            .appendText("distributionSha256Sum=$sha256")
    }
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
