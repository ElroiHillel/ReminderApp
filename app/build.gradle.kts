plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
}

android {
    namespace = "com.example.reminderapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.reminderapp"
        minSdk = 21
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
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
    implementation("com.google.code.gson:gson:2.10") // Gson
    implementation("com.squareup.retrofit2:retrofit:2.9.0") // Retrofit
    implementation("com.squareup.retrofit2:converter-gson:2.9.0") // Converter for Gson with Retrofit

    implementation ("androidx.appcompat:appcompat:1.6.1") // גרסה עדכנית של AppCompat
    implementation ("com.google.android.material:material:1.9.0") // לחומרים נוספים (אם נדרש)

    // Room for local database
    implementation ("androidx.room:room-runtime:2.5.0")
    annotationProcessor ("androidx.room:room-compiler:2.5.0")

    // Play services for Geofencing
    implementation ("com.google.android.gms:play-services-location:21.0.1")

    // Additional dependencies
    implementation ("androidx.lifecycle:lifecycle-viewmodel:2.6.1")
    implementation ("androidx.recyclerview:recyclerview:1.3.1")
    // Google Play Services - Location
    implementation ("com.google.android.gms:play-services-location:21.0.1")
}