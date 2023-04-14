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

Each group should submit the following files, under the name of only one team member. The file names should be preceded by your team number (e,g, #schema.sql should be 19schema.sql).
[One submission per group]:

A copy of the project description can be found under Files/Project Files/Project1.pdf.


1) #projectCode.zip: a tar/zip file of all the project code the group has written. Please submit all your eclipse project from your workspace (all your .java, .jsp, .html files etc. ) NOT your .war file.
2) #schema.sql: the sql file for your DB schema (you have to export it from your MySQL workbench)
3) #ER diagram: your final ER diagram. You are allowed to make changes from the original version.
4) #ProjectChecklist.docx: This file is attached (and can also be found under Files/Project Files). You should mention on each of the items in the checklist, what are the things you have implemented successfully. Just a check mark in front of each item is enough.
5) #README.txt: please provide the admin and customer representative credentials. In addition you should mention anything you want us to know about your application or group. For example, if the group members didn't contribute equally, you should write down who did what based on the checklist items (this can be submitted by email with subject: Group ___ Project Contributions ).
6) A demo video where you show step by step all the functionality you have implemented following the items in the checklist (you can use any screen recording/video application you like).

Please direct all project related questions to the Project TAs.