Selenium/Webdriver/Java project: Search term in google.com



1.Download  'Community' version of Intellij IDEA (https://www.jetbrains.com/idea/download/#section=windows)
2.Download JDK 10.0.2 (https://www.oracle.com/technetwork/java/javase/downloads/jdk10-downloads-4416644.html)
3.Download Firefox version 63 (latest)
4.Download Geckodriver (https://github.com/mozilla/geckodriver/releases)

Setup
--------------
1.Install JDK 10.0.2
2.Verify that JDK 10.0.2 was installed
3.Install Intellij IDEA
4.Verify that Intellij IDEA was installed
5.Open IntelliJ IDEA
6.Create New Project :
	- Select Maven from the options on the left
	- Project SDK - choose Java 10.0.2
	- Use a default one and an archetype
7. Specify Maven basic elements that are added to the pom.xml file: GroupId, ArtifactId, Version
8.Add dependencies to the POM.xml:
    <dependency>
        <groupId>org.seleniumhq.selenium</groupId>
        <artifactId>selenium-java</artifactId>
        <version>3.14.0</version>
    </dependency>

9.To run tests in FireFox you will need a geckodriver for your platform. Add file geckoDriver.exe to system folder System32


Description of the files contained in the project
---------------------------------------------------
1. POM.xml file contains  libraries (dependencies)and information about the various configuration details that Maven uses
to create the project.
2.Gitignore file specifies intentionally untracked files that Git should ignore.
3.SearchTest.java file you run for the test



How to run
----------------

In project qaauto-20.11.18-MyExam/src/test/java/test choose the file SearchTest.java and push the button Run

