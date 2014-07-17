1,host_system_id,number(12),not null
2,transaction_id,varchar2(18 char),not null
3,a,float
4,b,float
5,c,float
6,tenr_under_const,number(12)
7,tenr_contr_const,number(12)
8,tenr_under_date,timestamp(6)
9,tenr_contr_date,timestamp(6)
10,crf,float
11,cmtm_override,float
12,add_cmtm_adjust,float
13,percent_cmtm_adjust,float
14,mliv,float
15,psr,float
16,amount,float
17,minimum,float
18,crf_id,varchar2(20 char)
19,comments,varchar2(255 char)
20,cefe_update_user_id,number(12)
21,cefe_update_date,timestamp(6)
22,mandatory_crf,char(1)
23,psle_mliv,float
24,psle,float
25,risk_hedge,char(1),not null

##END!!

SELECT 
host_system_id , 
transaction_id , 
a , 
b , 
c , 
tenr_under_const , 
tenr_contr_const , 
tenr_under_date , 
tenr_contr_date , 
crf , 
cmtm_override , 
add_cmtm_adjust , 
percent_cmtm_adjust , 
mliv , 
psr , 
amount , 
minimum , 
crf_id , 
comments , 
cefe_update_user_id , 
cefe_update_date , 
mandatory_crf , 
psle_mliv , 
psle , 
risk_hedge
FROM trnx_deriv_special_crfs
WHERE transaction_id IN (
        SELECT transaction_id
        FROM TRNX_DERIV_ATTRIBUTE
        WHERE handoff_src_id IN (${handoff_source_id})
)

##END!!