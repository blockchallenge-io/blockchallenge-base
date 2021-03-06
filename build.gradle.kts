plugins {
    java
    `maven-publish`
    id("net.linguica.maven-settings") version "0.5"
}

group = "io.blockchallenge"
version = "0.1"
java.targetCompatibility = JavaVersion.VERSION_16
java.sourceCompatibility = JavaVersion.VERSION_16


repositories {
    mavenCentral()
    maven {
        name = "spigot-repo"
        setUrl("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
    }
}

dependencies {
    compileOnly("org.spigotmc:spigot-api:1.16.5-R0.1-SNAPSHOT")
}

publishing {
    repositories {
        maven {
            name = "github"
            setUrl("https://maven.pkg.github.com/blockchallenge-io/blockchallenge-base")
        }
    }

    publications {
        create<MavenPublication>("gpr") {
            groupId = group.toString()
            artifactId = project.name
            version = project.version.toString()

            from(components["java"])
        }
    }
}