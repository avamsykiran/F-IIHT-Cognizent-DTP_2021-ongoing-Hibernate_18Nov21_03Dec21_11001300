JPA - Hibernate
-------------------------------------------------------

    Lab Setup
    --------------------------
        Eclispe JavaEE latest 
        JDK 1.8
        MySQL   8.5

    ORM     Object Relational Mapping
    ------------------------------------------

        is such a framework or library that enables the automation of
        dtabase operation executions and implementations.

    Data Representation                         OOP                             RDBMS
    ....................................................................................................
    Entity Def                                  class                           Table
    Properties                                  field                           column
    Behaviours                                  method                          ---
    Entity                                      object                          Record/Tuple

    Has A Relationships (Aggregation)
     Composition
        an entity possess another entity        class Address {                 Employees
        An Employee composes of an Address          String street;               empid,name,slary,street,city
                                                    String city;
                                                }

                                                class Employee {
                                                    Long empId;
                                                    String name;
                                                    Double salary;
                                                    Address address;
                                                }

                                                class MovieTicketId{
                                                    String seatNumber;
                                                    LocalDateTime showDateTime;
                                                    String theaterName;
                                                    String screen;
                                                }

                                                class MovieTicket{
                                                    MovieTicketId ticketid;
                                                    String showTitle;  
                                                    Strign ticketHolderName;
                                                }

     Association
        OneToOne                                class BankAccount {             BankAccount
                                                    String accNum;                 accNum,ifsc,bankName
                                                    String ifsc;
                                                    String bankName;
                                                    Employee holder;
                                                }

                                                class Employee{                 Employees
                                                    Long empId;                     empid,name,basic,accnum
                                                    String name;
                                                    Dobule basic;
                                                    BankAccount salAccount;
                                                }

        OneToMany                               class Department {              Depts
        ManyToOne                                   Long deptId;                   deptId,title
                                                    String title;
                                                    Set<Employee> emps;
                                                }

                                                class Employee {                Employees
                                                    Long empId;                     empid,name,basic,dpetid
                                                    String name;
                                                    Double basic;
                                                    Department dept;
                                                }

        ManyToMany                              class Employee {                Employees
                                                    Long empId;                     empid,name,basic
                                                    String name;
                                                    Double basic;
                                                    Set<Project> projects;
                                                }     

                                                class Project {                 Projects
                                                    Long projectId;                 prjId,title
                                                    String projectTitle;
                                                    Set<Employee> team;
                                                }
                                                                                Prj_Emps
                                                                                    prjid,empid

                                                class Employee {                Employees
                                                    Long empId;                     empid,name,basic
                                                    String name;
                                                    Double basic;
                                                    @OneToMany
                                                    Set<TeamMembership> projects;
                                                }     

                                                class Project {                 Projects
                                                    Long projectId;                 prjId,title
                                                    String projectTitle;
                                                    @OneToMany
                                                    Set<TeamMembership> team;
                                                }
                                                
                                                class TeamMembership {          Memeberships
                                                    Long membershipId;              msid,empId,prId,role
                                                    @ManyToOne
                                                    Employee member;
                                                    @ManyToOne
                                                    Project project;
                                                    String role;
                                                }
    
    Is A Relationships (Reliazation)            class Employee {                
                                                    Long empId;                   
                                                    String name;
                                                    Double basic;
                                                }

                                                class Manager extends Employee{
                                                    Double allowence;
                                                }

                                                class ContractEmployee extends Employee {
                                                    Integer duration;
                                                }

                                                           Single Table       AllEmployees
                                                                                 empid,name,basic,allowence,duration

                                                           Join Table           Emps    empid(PK),name,basic
                                                                                Mgrs    empid(PK FK),allowence
                                                                                cemps   empid(PK FK),duration
                                                                                
                                                           Table PEr Class      Emps    empid(PK),name,basic
                                                                                Mgrs    empid(PK),name,basic,allow
                                                                                cemps   empid(PK),name,basic,duration


    JPA - Java Persistence API + (JTA - Java Transaction API)
    -----------------------------------------------------------

        JPA and JTA are JavaEE specifications to provide the ORM for java applications.

        JPA / JTA implementations / JPA or JTA Providers
            1. Hibernate
            2. TopLink
            3. ibates ...etc

        1. Entity Mapping

                @Entity                 class level     configs that a class is an entity
                @Emedable               class level     configs that a class is a part of an entity

                @Table(name="")         class level     map the entity class with a table

                @Inheretence            class level     config the Is A type 
                                                        (Single table/join table/table per class)
                @DiscriminatorColumn    class level
                @DiscriminatorValue     class level

                @Embeded                Field level     config that a field is a embedable object (composition)

                @Id                     Field level     config a field as primary key
                @EmbededId              Field level     config a field as a composite key

                @GeneratedValue         Field level     used along with @Id
                                                            AUTO            jpa-provider's inmeme seqeunce
                                                            IDENTITY        SQL Server/MySQL PK as identity col
                                                            SEQUENCE        oracle sequence

                @Column                 Field level     is an optional annotation on each field
                                                        configs column name,nullable, unique ..etc
                                                        if a field is not marked with @column annotation, then
                                                        that field is mapped to a colmun having the smae name as 
                                                        that of the field.

                @Transiant              Field level     config that a field need not be persisted in the db table.

                @OneToOne               Field level
                @OneToMany              Field level
                @ManyToOne              Field level
                @ManyToMany             Field level

                        mappedBy                        configs the name of the field of 
                                                        the entity on the oppsite side of the relation
                        fetechStrategy                  LAZY | EAGER
                        cascade                         ALL | PERSIST | MERGE | DELETE | NONE | REFERESH | ORPHAN

                @JoinColumn             Field level     config a name to the foreign key col
                @JoinTable              Field level     configs a thrid talbe for relatiosn incase of ManyToMany


        2. Persistence Unit Configuaration
            is informing the JPA provider about the database whereabouts and provider related proeprties.

            ./META-INF/persistence.xml
                <persistence>
                    <persistence-unit name="">
                        ......dbUrl,dbDriver,uid,pwd,...
                    </persistence-unit>
                </persistence>

        3. JPA API to perform the CRUD operations

                Persistence :: static createEntityManagerFactory(String persistencUnitName);
                                |- EntityManagerFactory :: createEntityManager()
                                        |- EntityManager
                                                :: Entity persist(Entity e)                     //insert
                                                :: Entity merge(Entity e)                       //update
                                                :: void remove(Entity e)                        //delete
                                                :: Entity find(Class entityClazz,Object prrimaryKeyValue);
                                                :: EntityTransaction getTransaction();
                                                        |- :: begin()
                                                        |- :: commit()
                                                        |- :: rollback()
                                                :: void flush();
                                                :: void close();
                                                :: Query createQuery(String JPQL);
                                                :: TypedQuery createQuery(String JPQL,Class resultantEntityClazz)
                                                :: TypedQuery createNamedQuery(String qryName,Class entityClazz)


                Entity LifeCycle

                        Transiant
                                        EmpoyeeEntity e = new EmployeeEntity();

                        Persistant
                                        Employee e1 = entityManager.get(EmployeeEntity.class,101);
                                        Employee e1 = entityManager.load(EmployeeEntity.class,101);

                                        entityManager.persist(e);
                                        entityManager.merge(e1);

                                        /*
                                        as long as the entityManger is not closed, the chagnes made to the
                                        entity are monitored and are passed back ot the database just before
                                        closing the entityManager.

                                        to force the persist or merge immediatly we have to commit the transaction
                                        or to commit all open transcations at once, we call entityManager.flush();

                                        once flushed no more rollBack..!
                                        */

                        Detached
                                        entityManger.remove(e1); //only e1 gets detached
                                        entityManger.close(); //all the entity objects will get detached.

    JPQL - Java Persistence Query Language
    ----------------------------------------------------------

    @Embedable
    class Address {                
        String street;               
        String city;
    }

    @Enttiy
    @Table(nam="emps")
    class Employee {
        @Id
        Long empId;
        String name;
        Double salary;
        @Embeded
        Address address;

        @ManyToOne
        @JoinColumn(name="did")
        Department dept;
    }

    @Entity
    class Department { 
          @Id             
          Long deptId;                      
          String title;

          @OneToMany(mappedBy="dept",fetech=FetechStrategry.LAZY,casecade=CascadeType.ALL)
          Set<Employee> emps;
    }

     emps
        empid,name,salary,street,city,did

     depts
        deptId,title

    SQL                                                 JPQL
    --------------------------------------------------------------------------------------
    SELECT * FROM emps                                  SELECT e FROM Employee e

    SELECT empid,name FROM emps                         SELECT e.empId,e.name FROM Employee e

    SELECT empid,name FROM emps WHERE salary>=5000      SELECT e.empId,e.name FROM Employee e WHERE e.salary>=5000

    SELECT name FROM emps WHERE city='VIZAG'            SELECT e.name FROM Employee e WHERE e.address.city='VIZAG'

    SELECT e.name,d.title                               SELECT e.name,e.dept.title FROM Employee e
    FROM   emps e INNER JOIN depts d ON e.did=d.deptId

    
    Maven Dependencies
    -------------------------------
        <dependency>
			<groupId>org.hibernate</groupId>
			<artifactId>hibernate-core</artifactId>
			<version>5.4.1.Final</version>
		</dependency>
		<dependency>
			<groupId>mysql</groupId>
			<artifactId>mysql-connector-java</artifactId>
			<version>8.0.26</version>
		</dependency>
    
    config - META-INF/persistence.xml
    ----------------------------------
    <persistence xmlns="http://xmlns.jcp.org/xml/ns/persistence"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/persistence
             http://xmlns.jcp.org/xml/ns/persistence/persistence_2_1.xsd"
	version="2.1">

	<persistence-unit name="mysqlPU">
		<provider>org.hibernate.jpa.HibernatePersistenceProvider</provider>

		<properties>
			<property name="javax.persistence.jdbc.driver"
				value="com.mysql.cj.jdbc.Driver" />
			<property name="javax.persistence.jdbc.url"
				value="jdbc:mysql://localhost:3306/jpaHibDb?createDatabaseIfNotExist=true" />
			<property name="javax.persistence.jdbc.user" value="root" />
			<property name="javax.persistence.jdbc.password"
				value="root" />
			<property name="hibernate.show_sql" value="true" />
			<property name="hibernate.hbm2ddl.auto" value="update" />
			<property name="hibernate.dialect"
				value="org.hibernate.dialect.MySQL8Dialect" />
		</properties>

	</persistence-unit>
</persistence>

