# Spring ORM
* [good reference](http://docs.spring.io/spring/docs/current/spring-framework-reference/html/orm.html)
* Integrate with ORM
  * Hibernate
  * JPA
  * JDO
* Benefits
  * Easier testing
  * Easier transaction management
  * Less boilerplate code
  * many more...
* No more `hibernate.cfg.xml` - all config will be in `beans.xml`

# Contextual Sessions
* [good reference](http://docs.spring.io/spring/docs/current/spring-framework-reference/html/orm.html#orm-hibernate-straight)
* Hibernate code has no knowledge of spring
* Can still leverage DI, AOP, and other Spring features

# Overview of integration with Hibernate
* Define 3 Spring Beans
  * DataSource
  * SessionFactory
  * TransactionManager
* Inject DataSource into SessionFactory
* Inject SessionFactory into TransactionManager
* Inject SessionFactory into all DAOs
* Use `@Transactional` to manage transactions
  * commonly used in business logic layer

# Result

### DaoImpl

```java
@Component
public class DaoImpl implements Dao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public FlashCard getFlashCard(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		return (FlashCard) session.get(FlashCard.class, id);
	}

  @Override
	public FlashCard updateFlashCard(FlashCard flashCard) {
		Session session = sessionFactory.getCurrentSession();
		session.update(flashCard);
		return flashCard;
	}

}
```

### BusinessLogicImpl

```java
@Service
public class BusinessLogicImpl implements BusinessLogic {

	@Autowired
	private Dao dao;

	@Override
	@Transactional(readOnly=false, isolation=Isolation.READ_COMMITTED)
	public FlashCard updateAnswer(Integer id, String newAnswer) {
		FlashCard flashCard = dao.getFlashCard(id);
		flashCard.setAnswer(newAnswer);
		dao.updateFlashCard(flashCard);
		return flashCard;
	}

}
```

# Configuration

### Enable `@Transactional` annotation

```xml
<tx:annotation-driven/>
```

### DataSource

```xml
<bean id="mydataSource" class="org.apache.commons.dbcp.BasicDataSource">  
    <property name="driverClassName"  value="oracle.jdbc.driver.OracleDriver"></property>  
    <property name="url" value="#{systemEnvironment['URL']}"></property>  
    <property name="username" value="#{systemEnvironment['USERNAME']}"></property>  
    <property name="password" value="#{systemEnvironment['PASSWORD']}"></property>  
</bean>  
```

### SessionFactory

```xml
<bean id="mySessionFactory"  class="org.springframework.orm.hibernate4.LocalSessionFactoryBean">  
    <property name="dataSource" ref="mydataSource"></property>  

    <property name="packagesToScan" value="com.example.domain"/>

    <property name="hibernateProperties">  
        <props>  
            <prop key="hibernate.dialect">org.hibernate.dialect.Oracle10gDialect</prop>  
            <prop key="hibernate.show_sql">true</prop>    
        </props>  
    </property>  
</bean>  
```

### TransactionManager

```xml
<bean id="transactionManager" class="org.springframework.orm.hibernate4.HibernateTransactionManager">  
  <property name="sessionFactory" ref="mySessionFactory"/>  
</bean>  
```
