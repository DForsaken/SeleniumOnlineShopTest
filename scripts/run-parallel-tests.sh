#!/usr/bin/env bash

BROWSER=$1
HUB=$2
THREADS=$3

mvn -e clean package -DskipTests=true -Dbrowser=$BROWSER -DhubUrl=$HUB -Dthreads=$THREADS \
&& mvn -q -fn surefire:test