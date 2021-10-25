# cardeal

### Criar container MadiaDB
``` shel
$ docker run -p 127.0.0.1:3306:3306  --name cardeal -e MARIADB_ROOT_PASSWORD=cardeal123 -d mariadb:latest
``` 