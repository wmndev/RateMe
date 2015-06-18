1. Install MongoDB
2. run ./mongod
3. execute:'db_initialize.mng'

RABBITMQ

3. Install RabbitMQ
4. from '/sbin' folder run: './rabbitmq-plugins enable rabbitmq_management'
5. from '/sbin' folder run: './rabbitmq-server status'
6. login to RabbitMQ console @ http://localhost:15672/  guest/guest (or check online for default username/password)
7. from ADMIN tab - create a new user: springApp/springApp with pemissions '/'

STARTUP ARGs:
1.Add -Dspring.profiles.active="dev"