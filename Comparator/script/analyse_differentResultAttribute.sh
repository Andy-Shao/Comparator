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

APP_LOG=${LOG_PATH}/analyse_differentResultAttribute.log
LOG4J="-Dlog4j.configuration=log/config/log4j-${instance}-silence.properties -Dapp.log=${APP_LOG}"

filePath=$1
type=$2
system_arg=$3
if [ -z "$filePath" ]; then
    echo "filePath is not supplied."
    exit
fi
if [ -z "$type" ]; then
    echo "type is not supplied."
    exit
fi
if [ -z "$system_arg" ]; then
    system_arg=
fi

system_arg=`echo $system_arg | sed 's/#/ /g'`
java -cp $CLASSPATH $JVM_ARGS $LOG4J $system_arg comparator.action.AnalyseDifferentResult $filePath $type classpath:comparator/analyse/analyseDifferentResultAttributeVisitor.xml