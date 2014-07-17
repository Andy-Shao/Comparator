#!/bin/sh
#ident "%W%"
#

export BASE_DIR=`pwd`
export PATH=$BASE_DIR/bin:$PATH
export instance=pro
#export JAVA_HOME=
#export PATH=$JAVA_HOME/bin:$PATH

export INPUT_PATH=${BASE_DIR}/input
export OUTPUT_PATH=${BASE_DIR}/output
export LOG_PATH=${BASE_DIR}/logs
export SEPARATOR_CHAR='|'

export BANKING_BOOK_INPUT=${INPUT_PATH}/banking_book
export BANKING_BOOK_INPUT_ARGS=${BANKING_BOOK_INPUT}/args
export BANKING_BOOK_SQL_PROCESS=${BANKING_BOOK_INPUT}/sqlProcess
export BANKING_BOOK_OUTPUT=${OUTPUT_PATH}/banking_book
export TRADING_BOOK_INPUT=${INPUT_PATH}/trade_book
export TRADING_BOOK_INPUT_ARGS=${TRADING_BOOK_INPUT}/args
export TRADING_BOOK_SQL_PROCESS=${TRADING_BOOK_INPUT}/sqlProcess
export TRADING_BOOK_OUTPUT=${OUTPUT_PATH}/trade_book