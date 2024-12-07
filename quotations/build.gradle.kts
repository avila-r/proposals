plugins {
    java
    id("io.quarkus")
}

repositories {
    mavenCentral()
    mavenLocal()
}

val quarkusPlatformGroupId: String by project
val quarkusPlatformArtifactId: String by project
val quarkusPlatformVersion: String by project

dependencies {
    implementation(enforcedPlatform("${quarkusPlatformGroupId}:${quarkusPlatformArtifactId}:${quarkusPlatformVersion}"))

    /**
     * Web
     */
    implementation("io.quarkus:quarkus-resteasy")
    implementation("io.quarkus:quarkus-rest-client-jackson")

    /**
     * Messaging
     */
    implementation("io.smallrye.reactive:smallrye-reactive-messaging-kafka")

    /**
     * Scheduler
     */
    implementation("io.quarkus:quarkus-quartz")

    /**
     * Persistence
     */
    implementation("io.quarkus:quarkus-hibernate-orm-panache")
    implementation("io.quarkus:quarkus-hibernate-orm")
    implementation("io.quarkus:quarkus-jdbc-postgresql")

    /**
     * CDI
     */
    implementation("io.quarkus:quarkus-arc")

    /**
     * Tests
     */
    testImplementation("io.quarkus:quarkus-junit5")
    testImplementation("io.rest-assured:rest-assured")

    /**
     * Utils
     */
    compileOnly("org.projectlombok:lombok:1.18.36")
}

group = "com.avila"
version = "1.0"

java {
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
}

tasks.withType<Test> {
    systemProperty("java.util.logging.manager", "org.jboss.logmanager.LogManager")
}
tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
    options.compilerArgs.add("-parameters")
}
