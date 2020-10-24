# Servlet CRUD 

JSP page to save, get, update and delete persons into MySQL database.

### To run in Intellij IDEA:

- run MySQL server and edit settings in MySQLDB.java
- mark src as source root
- File/Project Structure/Project settings/Project : SDK 8, language level 8
- File/Project Structure/Project settings/Modules : add Library -> Tomcat
- File/Project Structure/Project settings/Artifacts : add / Web Application Exploded /
  name: servlet, available elements -> right button click on servlet folder -> 
  put into output root (folder servlet and Web facet resources)
- Run/Edit configuration/Templates/Tomcat Server/Local/Server: create configuration
  add tomcat directory, jre 1.8, add launch link: 
  http://localhost:8080/servlet/index.jsp (or check context in Tomcat configuration/Deployment)
- Run/Edit configuration/Templates/Tomcat Server/Local/Deployment:
before launch: add Build Artifacts (servlet), then Deploy at the server startup -> add servlet
- Run Tomcat

