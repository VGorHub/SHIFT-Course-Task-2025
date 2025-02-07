plugins {
    id("java")
    id ("application")
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // Логирование
    implementation("ch.qos.logback:logback-classic:1.2.3")
    // Парсинг аргументов
    implementation("commons-cli:commons-cli:1.4")

    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}
application{
    mainClass.set("org.example.Main")
}
tasks.test {
    useJUnitPlatform()
}