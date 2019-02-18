# spring-boot-batch

Batch Service is a process to execute more than one command in a single task.

Let us consider an example where we are going to save the content into HSQLDB.

To create a Batch Service program, we need to add the Spring Boot Starter Batch dependency and HSQLDB dependency in our build configuration file.

The `@EnableBatchProcessing` annotation is used to enable the batch operations for our Spring Boot application.