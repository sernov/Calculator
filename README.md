## Running the Calculator App

To run the Calculator app locally, you will need to have the following dependencies installed on your system:

1. Java 11 or above (JVM)
2. Docker

Please follow the steps below to configure and run the app:

1. Clone this repository to your local machine.

2. Start a MySQL database in a Docker container by running the following command:

   ```bash
   docker run --name mysql -p 3306:3306 -e MYSQL_ROOT_PASSWORD=password -d mysql:latest
   ```

   This command will start a MySQL container with the root password set to "password". The port mapping (-p) maps port 3306 inside the container to port 3306 on your host machine.

3. Create a new database in the MySQL container:

   ```bash
   docker exec -it mysql mysql -uroot -ppassword -e "CREATE DATABASE calc"
   ```

   This command creates a new database called "calc" inside the MySQL container.

4. Navigate to the root directory of the cloned repository.

5. Build the project using Maven:

   ```bash
   mvn clean package
   ```

   This command will compile the code and generate a runnable .jar file in the `target/` directory.

6. Run the app by executing the following command:

   ```bash
   java -jar target/calc-0.0.1-SNAPSHOT.jar
   ```

   The app should now be running at [http://localhost:8080/calculator](http://localhost:8080/calculator).

Make sure you have Java 11 or above (JVM) and Docker installed on your system before running the app. The provided steps will set up a MySQL database container using Docker and run the Calculator app locally.