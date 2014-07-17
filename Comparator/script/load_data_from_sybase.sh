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

APP_LOG=${LOG_PATH}/load_data_from_sybase.log
LOG4J="-Dlog4j.configuration=log/config/log4j-${instance}.properties -Dapp.log=${APP_LOG}"

sql_file=$1
output=$2
contextPathes=$3
if [ -z "$sql_file" ]; then
    echo "sql_file is not supplied."
    exit
fi
if [ -z "$output" ]; then
    echo "output is not supplied."
    exit
fi
if [ -z "$contextPathes" ]; then
    contextPathes=file:${TRADING_BOOK_SQL_PROCESS}/sqlProcess.xml
    exit
fi

contextPathes=classpath:datasource/sybaseDataSource.xml#classpath:database/struct/SybaseTableFactory.xml#${contextPathes}
java -cp $CLASSPATH $JVM_ARGS $LOG4J database.load.LoadData $sql_file $output $contextPathes