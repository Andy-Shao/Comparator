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

APP_LOG=${LOG_PATH}/batch_load_data_from_sybase.log
LOG4J="-Dlog4j.configuration=log/config/log4j-${instance}.properties -Dapp.log=${APP_LOG}"

contextPathes=$1
if [ -z "$contextPathes" ]; then
    echo "contextPathes is not supplied."
    exit
fi

contextPathes=classpath:datasource/sybaseDataSource.xml#classpath:database/struct/SybaseTableFactory.xml#${contextPathes}
java -cp $CLASSPATH $JVM_ARGS $LOG4J database.load.BatchLoadData $contextPathes