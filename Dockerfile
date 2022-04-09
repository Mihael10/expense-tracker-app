FROM openjdk:17
EXPOSE 9009
ADD target/expense-tracker.jar expense-tracker.jar
ENTRYPOINT ["java", "-jar", "expense-tracker.jar"]