1,host_sys_id,number(12),not null
2,transaction_id,varchar2(18 char),not null
3,handoff_src_id,number(12),not null
4,leg_no,number(12),not null
5,fee_type,varchar2(18 char),not null
6,description,varchar2(18 char)
7,ccy,varchar2(3 char),not null
8,amount,float,not null
9,mtm,float,not null
10,settlement_date,timestamp(6),not null
11,mtm_included_ind,char(1),not null
12,accrual_type,char(2)
13,start_date,timestamp(6)
14,end_date,timestamp(6)
15,fixed_accrual_rate,float
16,ref_rate_term,number(12)

##END!!

SELECT 
host_sys_id , 
transaction_id , 
handoff_src_id , 
leg_no , 
fee_type , 
description , 
ccy , 
amount , 
mtm , 
settlement_date , 
mtm_included_ind , 
accrual_type , 
start_date , 
end_date , 
fixed_accrual_rate , 
ref_rate_term
FROM trnx_deriv_fees
WHERE handoff_src_id IN (${handoff_source_id})

##END!!