call docker-compose stop
call docker image prune -a -f
call docker system prune -a -f
call docker builder prune