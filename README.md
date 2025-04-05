+ Using VsCode or other similar IDE:

1. Download jar from: https://github.com/djoleluk/react-vite-spring-boot-pattern.git
2. In the backend dir create .env file.
3. Configure .env variable with the db or other data if needed.(optional)
4. Configure application-properties file in src/main/resources dir to include date from .env file(optional).
5. Go in the backend dir, open pom.xml, and you can change the following props:

<groupId>com.pistolshrimp</groupId> // to new groupid if needed 
<artifactId>mytestapp</artifactId> // to new artifactId if needed 
<version>0.0.1-SNAPSHOT</version> // leave it as is for the fist version 
<name>mytestapp</name> // change app name
<description>My application for testing</description> change description 

6. Run the following from the backend dir: mvn clean install, to rebuild the project.
7. To start the spring-boot server, run the following: mvn spring-boot:run 
7a. If 8080 port(or other selected server port) is in use, run the following commands from CMD with admin priviledges, to stop it: 
/> netstat -ano | findstr :8080 // this will show an output like: TCP  0.0.0.0:8080 0.0.0.0:0  LISTENING  6328
/> taskkill /PID 6328 /F // run this command to kill the process using its <PID>(in this example its 6328)
8. Test with Postman using localhost url: http://localhost:8080/someroute
9. Go in the frontend dir and run: npm install, to install all the Vite and React dependencies.
10. To start Vite development server run: npm run dev. 
11. Go to frontend dir, index.html, change the app icon and title.(optional)

