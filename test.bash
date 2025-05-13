rm *.class
javac JavaOverview.java
javac -cp ".:junit-platform-console-standalone-1.8.2.jar" JavaOverviewTest.java
java -jar junit-platform-console-standalone-1.8.2.jar --class-path=. --select-class=JavaOverviewTest
