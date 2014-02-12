#!/bin/sh
# 查找指定uid的user_game数据
# $1: uid
if [ $# -eq 0 ]
then
	echo "$0 need param uid " 
	exit -1 
fi

query_sql="select * from user_game where uid=$1;"
db_user=fishing
db_pwd=fishing2011
db_name=fishing_beta
host=127.0.0.1
charset=UTF8

echo "execute query -> $query_sql"
mysql $db_name -h$host -u$db_user -p$db_pwd --default-character-set=$charset -e "$query_sql"
