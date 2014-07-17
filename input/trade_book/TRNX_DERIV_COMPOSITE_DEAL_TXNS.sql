1,cd_host_sys_id,number(12),not null
2,cd_transaction_id,varchar2(18 char),not null
3,host_sys_id,number(12),not null
4,transaction_id,varchar2(18 char),not null
5,handoff_src_id,number(12)
6,a,float
7,b,float
8,c,float
9,minimum,float
10,tenr_under_const,number(12)
11,tenr_contr_const,number(12)
12,tenr_under_date,timestamp(6)
13,tenr_contr_date,timestamp(6)
14,crf,float
15,cmtm,float
16,mliv,float
17,psr,float
18,amount,float
19,status,char(1),not null
20,psle_mliv,float
21,psle,float

##END!!

SELECT 
C.cd_host_sys_id , 
C.cd_transaction_id , 
C.host_sys_id , 
C.transaction_id , 
C.handoff_src_id , 
C.a , 
C.b , 
C.c , 
C.minimum , 
C.tenr_under_const , 
C.tenr_contr_const , 
C.tenr_under_date , 
C.tenr_contr_date , 
C.crf , 
C.cmtm , 
C.mliv , 
C.psr , 
C.amount , 
C.status , 
C.psle_mliv , 
C.psle
FROM TRNX_DERIV_ATTRIBUTE A,
TRNX_DERIV_COMPOSITE_DEALS B,
TRNX_DERIV_COMPOSITE_DEAL_TXNS C
WHERE A.TRANSACTION_ID  = B.CD_TRANSACTION_ID
AND B.CD_TRANSACTION_ID = C.CD_TRANSACTION_ID
AND B.CD_HOST_SYS_ID    = C.CD_HOST_SYS_ID
AND A.HANDOFF_SRC_ID IN (${handoff_source_id})
##END!!