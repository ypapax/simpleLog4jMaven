#!/usr/bin/env bash
set -ex

build(){
	rm -rf ./target
	mvn package
}

run(){
	java -cp target/testlog4j-1.0-jar-with-dependencies.jar testlog4j.testlog4j.App
}

br(){
	$0 build_and_run
}

build_and_run(){
	$0 build && $0 run
}

$@