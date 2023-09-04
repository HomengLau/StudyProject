pluginManagement {
    repositories {

        maven( url = "https://maven.aliyun.com/repository/public")
        maven( url = "https://maven.aliyun.com/repository/google")
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        maven( url = "https://maven.aliyun.com/repository/public")
        maven( url = "https://maven.aliyun.com/repository/google")
        google()
        mavenCentral()
    }
    versionCatalogs {
        create("libs") {
            library("coreKtx",  "androidx.core:core-ktx:1.10.1")
            library("appcompat","androidx.appcompat:appcompat:1.6.1")
            library("material", "com.google.android.material:material:1.9.0")
            library("marsXlog", "com.tencent.mars:mars-xlog:1.2.6")
            // 使用统一版本号
            version("retrofit","2.9.0")
            //定义使用版本号
//            version("converter-gson", "2.9.0")
//            library('converter-gson', 'com.squareup.retrofit2','converter-gson').versionRef('converter-gson')
//            library('retrofit', 'com.squareup.retrofit2','retrofit').version('2.9.0')
            library("retrofit",             "com.squareup.retrofit2","retrofit").version("retrofit")
            library("converterGson",        "com.squareup.retrofit2","converter-gson").versionRef("retrofit")
            library("loggingInterceptor",   "com.squareup.okhttp3:logging-interceptor:4.11.0")
            library("rxjava",   "io.reactivex.rxjava3","rxjava").version("3.1.5")
            library("rxandroid","io.reactivex.rxjava3:rxandroid:3.0.2")
            library("viewmodel","androidx.lifecycle:lifecycle-viewmodel:2.5.1")
            library("coroutinesCore-ktx","org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
            library("conroutinesAndnroidKtx","org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")
            library("junit","junit:junit:4.13.2")
            library("androidxJunit","androidx.test.ext:junit:1.1.3")
            library("espressoCore","androidx.test.espresso:espresso-core:3.4.0")
            library("mockwebserver","com.squareup.okhttp3:mockwebserver:4.11.0")
        }
    }
}
rootProject.name = "StudyProject"
include(":app")
include(":app:sort_algorithms")
include(":account")
include(":network")
include(":logger")

