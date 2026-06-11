plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.receitasferas"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.receitasferas"
        minSdk = 25
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {
    // Dependências padrões que já estavam no seu projeto
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)

    // === DEPENDÊNCIAS DO ROOM DATABASE (ADICIONADAS AQUI) ===
    val roomVersion = "2.6.1"

    // Biblioteca de execução do Room
    implementation("androidx.room:room-runtime:$roomVersion")

    // Processador de anotações (essencial para ler o @Entity, @Dao, etc.)
    annotationProcessor("androidx.room:room-compiler:$roomVersion")
}