#!/bin/bash

eval $(cat donstro/remote.env) SERVER_NAME=localhost docker-compose -f donstro/docker-compose.yml $@

