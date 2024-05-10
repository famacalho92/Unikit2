import com.android.build.gradle.internal.scope.ProjectInfo.Companion.getBaseName

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    kotlin("plugin.serialization") version "1.9.24"
}

android {
    namespace = "com.example.unikit"
    compileSdk = 34

//val key: String = com.android.build.gradle.internal.cxx.configure.gradleLocalProperties(rootDir)
//        .getProperty("supabaseKey")
//    val url: String = com.android.build.gradle.internal.cxx.configure.gradleLocalProperties(rootDir)
//        .getProperty("supabaseUrl")

    defaultConfig {
        applicationId = "com.example.unikit"
        minSdk = 27
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"


        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
//        buildConfigField("String","supabaseKey","\"$key\"")
//        buildConfigField("String","supabaseUrl","\"$url\"")

    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.material3.android)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
    implementation("androidx.navigation:navigation-compose:2.7.7")
    implementation("com.google.android.material:material:1.12.0")
    implementation ("androidx.compose.material:material:1.2.1")
    implementation ("androidx.compose.material:material-icons-extended:1.5.3")
    //supabase
    //implementation ("com.github.supabase-community:supabase-android:1.0.0")
    //implementation(platform("io.github.jan-tennert.supabase:bom:2.4.0-beta-1"))
    // implementation("io.github.jan-tennert.supabase:postgrest-kt")
    //implementation("io.github.jan-tennert.supabase:gotrue-kt:1.3.2")
    implementation("io.ktor:ktor-client-cio:2.3.4")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.2")
    implementation("androidx.compose.material3:material3:1.2.1")
    implementation("androidx.compose.material3:material3-window-size-class:1.2.1")
    implementation("androidx.compose.material3:material3-adaptive-navigation-suite:1.0.0-alpha07")
    implementation ("androidx.compose.ui:ui:1.3.0-alpha03")
    implementation ("androidx.compose.material3:material3:1.0.0-alpha03")
    implementation ("androidx.compose.material3:material3:1.0.0-beta02")

}

/*
android {
buildFeatures {
compose = true
}

composeOptions {
kotlinCompilerExtensionVersion = "1.1.1"
}

kotlinOptions {
jvmTarget = "1.8"
}
}

 */