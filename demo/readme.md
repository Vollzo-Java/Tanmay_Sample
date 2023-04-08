Application Name - Demo

This is Maven base application, you may import into NetBeans or STS and import as maven project

DB Setup: I am using Oracle 21c


	CREATE TABLE CUSTOMER_DETAIL 
	(
	  CUST_ID NUMBER NOT NULL, 
	  CUST_NAME VARCHAR2(20) NOT NULL,
	  CUST_ADD VARCHAR2(20),  
	  PRIMARY KEY(CUST_ID) 
	);


	CREATE TABLE PAYMENT_TRANSACTION 
	(
	  TRANS_ID NUMBER NOT NULL PRIMARY KEY,
	  CUST_ID NUMBER NOT NULL, 
	  AMOUNT NUMBER(10,2),  
	  TRANS_TIMESTAMP TIMESTAMP DEFAULT SYSDATE, 
	  TRANS_STATUS  VARCHAR2(10),    
	  FOREIGN KEY (CUST_ID) REFERENCES CUSTOMER_DETAIL(CUST_ID) 
	);	

Create Sequence for auto generate transaction id

	CREATE SEQUENCE TAB_CUSTOMER_SEQ
	START WITH 1
	MAXVALUE 999999999999999999999999999
	MINVALUE 1
	NOCYCLE
	CACHE 20
	NOORDER;


Sample Data Insert into

		INSERT INTO "SYSTEM"."CUSTOMER_DETAIL" (CUST_ID, CUST_NAME, CUST_ADD) VALUES ('1', 'Stephen', 'Coppell,TX')
		INSERT INTO "SYSTEM"."CUSTOMER_DETAIL" (CUST_ID, CUST_NAME, CUST_ADD) VALUES ('2', 'Michel', 'Irving,TX')
		INSERT INTO "SYSTEM"."CUSTOMER_DETAIL" (CUST_ID, CUST_NAME, CUST_ADD) VALUES ('3', 'Ravi', 'Plano,TX')
		INSERT INTO "SYSTEM"."CUSTOMER_DETAIL" (CUST_ID, CUST_NAME, CUST_ADD) VALUES ('4', 'Bindu', 'Dallas, TX')

Change DB credential in application.yml file.
    
	datasource:
		url: jdbc:oracle:thin:@hostname:1521:xe
		username: system
		password: system1

How to run this application?
  
  1) Go to Path C:\XXX\demo
     
     And run command: mvn spring-boot:run
     
  2) Or STS >> On App right click and build and run application
  
  
  Swagger UI URL : 
    		
	http://localhost:8088/swagger-ui/index.html#/assignmen-controller
  
  Expose Rest API : Curl command
  
    curl -X GET "http://localhost:8088/api/v2/tnx/allcustomer" -H "accept: */*"
    curl -X GET "http://localhost:8088/api/v2/tnx/customer/1" -H "accept: */*"
    curl -X GET "http://localhost:8088/api/v2/tnx/getreward/1" -H "accept: */*"
    curl -X POST "http://localhost:8088/api/v2/tnx/payment" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"custId\" : 1, \"amount\" : 120, \"status\" : \"Success\"}"
    

    
   Postman Request URL

   Get
       
    http://localhost:8088/api/v2/tnx/allcustomer
    http://localhost:8088/api/v2/tnx/customer/1   
    http://localhost:8088/api/v2/tnx/getreward/1
   
   Post
   
    http://localhost:8088/api/v2/tnx/payment    
    
  Result output screenshot attached in Assignment_Result.docx file.
  

    
    
    