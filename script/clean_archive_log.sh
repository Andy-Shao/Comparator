#!/bin/sh   
#ident "%W%"

############################################################################################
# Name          : clean_archive_log.sh
#
# Description : Use this script to clean some archived data and logs which is older than 3 days 
#
# Usage: clean_archive_log.sh
#
############################################################################################

clean(){
   dir=$1
   
   if [ -d $dir ];then
   		find $dir -mtime +3 -type f -exec rm -f {} \;
   		if [ "$?" -ne "0" ]; then 
	  		exit 1
   		fi
   fi
}

##clean logs##
clean ${LOG_PATH}

exit 0
