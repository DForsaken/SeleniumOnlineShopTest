#!/usr/bin/env bash

BROWSER=$1
HUB=$2

mvn -Dbrowser=$BROWSER -DhubUrl=$HUB test clean
