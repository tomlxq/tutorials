=========

## Spring Persistence Example Project


### Relevant Articles: 
- [A Guide to JPA with Spring](https://github.com/tomlxq/tutorials/the-persistence-layer-with-spring-and-jpa)
- [Bootstrapping Hibernate 5 with Spring](http://www.tom.com/hibernate-5-spring)
- [The DAO with Spring and Hibernate](https://github.com/tomlxq/tutorials/persistence-layer-with-spring-and-hibernate)
- [Simplify the DAO with Spring and Java Generics](https://github.com/tomlxq/tutorials/simplifying-the-data-access-layer-with-spring-and-java-generics)
- [Transactions with Spring and JPA](https://github.com/tomlxq/tutorials/transaction-configuration-with-jpa-and-spring)
- [Introduction to Spring Data JPA](http://www.tom.com/the-persistence-layer-with-spring-data-jpa)
- [Spring Data JPA @Query](http://www.tom.com/spring-data-jpa-query)
- [Spring JDBC](https://github.com/tomlxq/tutorials/spring-jdbc-jdbctemplate)
- [Transaction Propagation and Isolation in Spring @Transactional](https://github.com/tomlxq/tutorials/spring-transactional-propagation-isolation)

### Eclipse Config 
After importing the project into Eclipse, you may see the following error:  
"No persistence xml file found in project"

This can be ignored: 
- Project -> Properties -> Java Persistance -> JPA -> Error/Warnings -> Select Ignore on "No persistence xml file found in project"
Or: 
- Eclipse -> Preferences - Validation - disable the "Build" execution of the JPA Validator 

