FROM openjdk:17
ADD build/libs/blog-0.0.1-SNAPSHOT.jar blog.jar
ENTRYPOINT ["java", "-jar", "blog.jar"]