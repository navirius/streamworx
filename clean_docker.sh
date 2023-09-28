#!/bin/zsh
docker compose stop
docker image prune -a -f
docker system prune -a -f
docker builder prune