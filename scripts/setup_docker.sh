#!/bin/bash
docker run -d --name distance -p 3306:3306 -e MYSQL_ROOT_PASSWORD=root -e MYSQL_USER=distance -e MYSQL_PASSWORD=distance -e MYSQL_DATABASE=distance centurylink/mysql
