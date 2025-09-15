plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    implementation("org.projectlombok:lombok:1.18.40")

    implementation("org.slf4j:slf4j-api:2.1.0-alpha1")

}

tasks.test {
    useJUnitPlatform()
}