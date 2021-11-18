JPA - Hibernate
-------------------------------------------------------

    Lab Setup
    --------------------------
        Eclispe JavaEE latest 
        JDK 1.8
        MySQL   8.5

    ORM     Object Relational Mapping
    ------------------------------------------

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
                                                    Set<TeamMembership> projects;
                                                }     

                                                class Project {                 Projects
                                                    Long projectId;                 prjId,title
                                                    String projectTitle;
                                                    Set<TeamMembership> team;
                                                }
                                                
                                                class TeamMembership {          Memeberships
                                                    Long membershipId;              msid,empId,prId,role
                                                    Employee member;
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

                                                                                AllEmployees
                                                                                 empid,name,basic,allowence,duration

                                                                                Emps    empid(PK),name,basic
                                                                                Mgrs    empid(PK FK),allowence
                                                                                cemps   empid(PK FK),duration
                                                                                
                                                                                Emps    empid(PK),name,basic
                                                                                Mgrs    empid(PK),name,basic,allow
                                                                                cemps   empid(PK),name,basic,duration



