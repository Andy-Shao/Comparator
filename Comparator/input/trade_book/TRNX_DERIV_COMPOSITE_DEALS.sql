1,cd_host_sys_id,number(12),not null
2,cd_transaction_id,varchar2(18 char),not null
3,cd_deal_type,char(1),not null
4,cd_status,char(1),not null
5,settle_net,char(1),not null
6,crf_id,varchar2(20 char)
7,local_ref,varchar2(20 char)
8,comments,varchar2(255 char)
9,source,char(1)
10,cefe_update_user_id,number(7)
11,cefe_update_date,timestamp(6)

##END!!

SELECT 
B.cd_host_sys_id , 
B.cd_transaction_id , 
B.cd_deal_type , 
B.cd_status , 
B.settle_net , 
B.crf_id , 
B.local_ref , 
B.comments , 
B.source , 
B.cefe_update_user_id , 
B.cefe_update_date
FROM TRNX_DERIV_ATTRIBUTE A,
TRNX_DERIV_COMPOSITE_DEALS B
WHERE A.TRANSACTION_ID = B.CD_TRANSACTION_ID
AND A.HANDOFF_SRC_ID IN (${handoff_source_id})
##END!!