plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.jetbrains.kotlin.serialization)
    alias(libs.plugins.compose.compiler)
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
    id("com.google.gms.google-services")
}

android {
    namespace = "com.rnk0085.selfcare"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.rnk0085.selfcare"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
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

kapt {
    correctErrorTypes = true
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
    implementation(libs.firebase.firestore.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    // https://developer.android.com/guide/navigation?_gl=1*isa79f*_up*MQ..*_ga*NTI0NDYyNjA5LjE3MzE0OTY0NTU.*_ga_6HH9YJMN9M*MTczMTQ5NjQ1NC4xLjAuMTczMTQ5NjU5Mi4wLjAuMTEwNzc3ODY0MA..#set-up
    implementation(libs.androidx.navigation.compose)
    androidTestImplementation(libs.androidx.navigation.testing)

    // https://kotlinlang.org/docs/serialization.html
    implementation(libs.kotlinx.serialization.json)

    implementation(libs.hilt.android)
    kapt(libs.hilt.android.compiler)

    implementation(platform(libs.firebase.bom))
    implementation(libs.firebase.analytics)
}
