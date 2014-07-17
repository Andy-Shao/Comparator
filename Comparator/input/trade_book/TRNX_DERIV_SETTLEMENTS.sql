1,host_sys_id,number(12),not null
2,transaction_id,varchar2(18 char),not null
3,handoff_src_id,number(12),not null
4,leg_no,number(3),not null
5,settlement_date,timestamp(6),not null
6,payment_date,timestamp(6),not null
7,fix_cashflow,float,not null
8,strike1_rate,float
9,strike2_rate,float
10,cashflow_type,number(12)
11,cashflow_amount,float

##END!!

SELECT 
host_sys_id , 
transaction_id , 
handoff_src_id , 
leg_no , 
settlement_date , 
payment_date , 
fix_cashflow , 
strike1_rate , 
strike2_rate , 
cashflow_type , 
cashflow_amount
FROM trnx_deriv_settlements
WHERE handoff_src_id IN (${handoff_source_id})

##END!!