#!/bin/sh
#ident "%W%"
#

dataA=$1
dataB=$2
system_arg=$3
lineComparatorPath=$4
output_dataA=$5
output_dataB=$6
if [ -z "$dataA" ]; then
    echo "dataA is not supplied."
    exit
fi
if [ -z "$dataB" ]; then
    echo "dataB is not supplied."
    exit
fi
if [ -z "$system_arg" ]; then
    system_arg="NULL"
fi
if [ -z "$lineComparatorPath" ]; then
    lineComparatorPath=classpath:comparator/action/lineComparator.xml
fi
if [ -z "$output_dataA" ]; then
    output_dataA=data_oracle.csv
fi
if [ -z "$output_dataB" ]; then
    output_dataB=data_sybase.csv
fi

${BASE_DIR}/bin/load_data_from_oracle.sh $dataA ${output_dataA}
${BASE_DIR}/bin/load_data_from_sybase.sh $dataB ${output_dataB}
${BASE_DIR}/bin/comparator.sh ${output_dataA} ${output_dataB} $system_arg $lineComparatorPath
