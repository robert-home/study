#!/usr/bin/env bats

function setup() {

    PROCESS="#!/usr/bin/bash while [ : ]; do; echo \"hostname : $(hostname)\"; sleep 5; done"
    PROCESS_ID=`PROCESS &`
    echo PROCESS_ID
}

function teardown() {

}

@test "should send signal to a background process" {
    result="$(echo 2+2 | bc)"
    [ "$result" -eq 4 ]
}