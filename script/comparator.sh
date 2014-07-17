#!/bin/sh
#ident "%W%"
#

CLASSPATH=
for jar in `ls ${BASE_DIR}/lib/*.jar`
do
    CLASSPATH=$CLASSPATH:$jar
done

if [ "${instance}" == "local" ]; then
    JVM_ARGS="-Xms512m -Xmx512m -client"
else
    JVM_ARGS="-Xms8192m -Xmx8192m -server"
fi

APP_LOG=${LOG_PATH}/comparator.log
LOG4J="-Dlog4j.configuration=log/config/log4j-${instance}.properties -Dapp.log=${APP_LOG}"

dataA=$1
dataB=$2
system_arg=$3
lineComparatorPath=$4
if [ -z "$dataA" ]; then
    echo "dataA is not supplied."
    exit
fi
if [ -z "$dataB" ]; then
    echo "dataB is not supplied."
    exit
fi
if [ -z "$system_arg" ]; then
    system_arg=
fi
if [ $system_arg = "NULL" ]; then
    system_arg=
fi
if [ -z "$lineComparatorPath" ]; then
    lineComparatorPath="classpath:comparator/action/defaultComparator.xml"
fi

system_arg=`echo $system_arg | sed 's/#/ /g'`
java -cp $CLASSPATH $JVM_ARGS $LOG4J $system_arg comparator.action.DifferentComparator $dataA $dataB $lineComparatorPath