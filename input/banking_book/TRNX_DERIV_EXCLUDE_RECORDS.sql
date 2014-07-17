1,handoff_src_id,number(12,0)
2,host_sys_id,number(12,0)
3,transaction_id,varchar2(20 char)
4,country,varchar2(2 char)
5,record_type,varchar2(2 char)
6,reason,number(12,0)
7,cob_date,timestamp (6)
8,exclude_dt,timestamp (6)
9,gfcid,number(10,0)
10,message,varchar2(255 char)
11,citicorp_unit_gfcid,number(10,0)
12,sub_instrument,number(12,0)
13,product_code_1,varchar2(16 char)
14,system_ref_id,varchar2(16 char)
15,branch,number(7,0)
16,base,number(12,0)
17,account_ccy,varchar2(3 char)
18,acct_txn_status,char(1 byte)
19,maturity_date,timestamp (6)
20,portfolio,varchar2(9 char)
21,settlement_date,timestamp (6)
22,trade_date,timestamp (6)

##END!!

SELECT 
handoff_src_id , 
host_sys_id , 
transaction_id , 
country , 
record_type , 
reason , 
cob_date , 
exclude_dt , 
gfcid , 
message , 
citicorp_unit_gfcid , 
sub_instrument , 
product_code_1 , 
system_ref_id , 
branch , 
base , 
account_ccy , 
acct_txn_status , 
maturity_date , 
portfolio , 
settlement_date , 
trade_date
FROM trnx_deriv_exclude_records WHERE handoff_src_id IN (${handoff_source_id})

##END!!