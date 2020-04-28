buildscript {
    repositories {
        jcenter()            
    }

    dependencies {
        // protobuf plugin used by submodule
        classpath("com.google.protobuf:protobuf-gradle-plugin:0.8.11")                    
    }
    
}

plugins {
    kotlin("jvm") version "1.3.31"
}

allprojects {
    group = "mygroup"
    version = "0.0.1"

    apply(plugin = "kotlin")

    repositories {
        jcenter()
    }

    dependencies {
        val kotestVersion = "4.0.3"
        testImplementation("io.kotest:kotest-runner-junit5-jvm:$kotestVersion")
            ?.because("kotest framework")
        testImplementation("io.kotest:kotest-assertions-core-jvm:$kotestVersion")
            ?.because("kotest core jvm assertions")
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }
}
