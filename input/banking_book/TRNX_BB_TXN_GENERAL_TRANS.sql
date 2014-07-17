1,host_system_id,number(12,0)
2,transaction_id,varchar2(18 char)
3,american_european_ind,char(1 byte)
4,early_termination,char(1 byte)
5,early_termination_date,timestamp (6)
6,expiry_date,timestamp (6)
7,maturity_date,timestamp (6)
8,no_of_principals,number(12,0)
9,put_call_ind,char(1 byte)
10,spot_date,timestamp (6)
11,start_date,timestamp (6)
12,strike_price,number(18,0)
13,undly_start_date,timestamp (6)
14,final_maturity_date,timestamp (6)
15,volatility_index_basket,varchar2(20 char)
16,node_3,varchar2(16 char)
17,cust_ouc,varchar2(6 char)

##END!!

SELECT 
host_system_id , 
transaction_id , 
american_european_ind , 
early_termination , 
early_termination_date , 
expiry_date , 
maturity_date , 
no_of_principals , 
put_call_ind , 
spot_date , 
start_date , 
strike_price , 
undly_start_date , 
final_maturity_date , 
volatility_index_basket , 
node_3 , 
cust_ouc
FROM trnx_bb_txn_general_trans WHERE host_system_id IN (${handoff_source_id})

##END!!