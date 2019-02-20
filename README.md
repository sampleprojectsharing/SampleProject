# SampleProject

SampleProject is a sample automation project that shows author's automation skills

## How to run it on your own PC

1. [Install](https://docs.oracle.com/javase/8/docs/technotes/guides/install/install_overview.html) Java JDK/JRE 8+
2. Clone the project to your PC
3. Change property values in config files (./src/test/resources/*/config.properties). By default, "dev" config is used
4. Change test data (LOGIN, PASSWORD, USERNAME) in the *BaseTest.class*
5. Add *executable* [chromedriver](http://chromedriver.chromium.org/downloads) file to the ./src/test/resources/ folder
6. Run the project with your favorite IDE or with [Maven](https://maven.apache.org/):
```bash
mvn clean package
```
   To specify the environment use `-P{env}` argument:
```bash
mvn clean package -Ptest
```