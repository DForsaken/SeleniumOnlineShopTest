#!/usr/bin/env bash

BROWSER=$1
THREADS=$2
HUB="http://172.17.0.1:4444/wd/hub"

mvn -e clean package -DskipTests=true -Dbrowser=$BROWSER -DhubUrl=$HUB \
&& mvn -q -fn surefire:test -DpThreads=$THREADS