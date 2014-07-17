1,handoff_src_id,number(12,0)
2,host_sys_id,number(12,0)
3,transaction_id,varchar2(20 char)
4,record_type,varchar2(2 char)
5,reason,number(12,0)
6,cob_date,timestamp (6)
7,reject_dt,timestamp (6)
8,portfolio_1,varchar2(8 char)
9,product_code_1,varchar2(16 char)
10,notional_1,varchar2(18 char)
11,notional_2,varchar2(18 char)
12,ccy_1,varchar2(3 char)
13,ccy_2,varchar2(3 char)
14,gfcid,number(10,0)
15,message,varchar2(255 char)

##END!!

SELECT 
handoff_src_id , 
host_sys_id , 
transaction_id , 
record_type , 
reason , 
cob_date , 
reject_dt , 
portfolio_1 , 
product_code_1 , 
notional_1 , 
notional_2 , 
ccy_1 , 
ccy_2 , 
gfcid , 
message
FROM trnx_deriv_reject_records WHERE handoff_src_id IN (${handoff_source_id})

##END!!