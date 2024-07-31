# Empty Java Project

This is an empty Java project structure.

## Installing Gradle Wrapper (gradlew)

To install the Gradle Wrapper (`gradlew`), follow these steps:

1. **Download the Gradle Wrapper files:**
   - You can download the necessary files from the [Gradle Wrapper GitHub repository](https://github.com/gradle/gradle-wrapper).

2. **Add the Wrapper files to your project:**
   - Place the `gradlew` and `gradlew.bat` files in the root of your project.
   - Place the `gradle/wrapper/gradle-wrapper.jar` and `gradle/wrapper/gradle-wrapper.properties` files in the `gradle/wrapper/` directory of your project.

3. **Run the Wrapper to download the Gradle distribution:**
   - On Unix-based systems, run: `./gradlew`
   - On Windows, run: `gradlew.bat`

This will download the Gradle distribution specified in the `gradle-wrapper.properties` file and set up the wrapper for your project.
