# Documentation
## Usage
change your password and settings in `src/java/controller/DBConfig`

Remember to start your mysql server

Follow this tutorial to load the `finalERseparate.mwb` file into your database

https://dev.mysql.com/doc/workbench/en/wb-forward-engineering-live-server.html

```
mvn clean
mvn compile
mvn tomcat7:run
```
## Notification

Do not modify the `web.xml` file

Use `@WebServlet` to set the directory

## TODO

- [ ] Beautify login/register result page
- [ ] Create HttpSession and store user data in it after Login
- [ ] Code for creating database schema, to ensure the same database structure for all developer