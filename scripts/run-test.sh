#!/usr/bin/env bash

BROWSER=$1
HUB=$2

mvn -e clean package -DskipTests=true \
&& mvn -Dbrowser=$BROWSER -DhubUrl=$HUB test clean
