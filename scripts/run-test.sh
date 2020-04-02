#!/usr/bin/env bash

BROWSER=$1
HUB=$2

mvn -e clean package -DskipTests=true -Dbrowser=$BROWSER -DhubUrl=$HUB -Dthreads=1 \
&& mvn -q -fn surefire:test