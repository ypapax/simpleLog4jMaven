#!/usr/bin/env bash
set -ex

build(){
	mvn package
}

run(){
	cat 4_big.txt | java -cp target/testlog4j-1.0-jar-with-dependencies.jar testlog4j.testlog4j.App
}

br(){
	$0 build && $0 run
}

$@