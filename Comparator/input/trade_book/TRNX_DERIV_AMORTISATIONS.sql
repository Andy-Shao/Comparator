1,handoff_src_id,number(12),not null
2,host_sys_id,number(12),not null
3,transaction_id,varchar2(18 char),not null
4,amortisation_date,timestamp(6),not null
5,leg_no,number(3),not null
6,notional_amount,float,not null
7,fix_rate,float
8,daily_referral,float
9,cashflow_start_ind,char(1)
10,cashflow_end_ind,char(1)

##END!!

SELECT 
handoff_src_id , 
host_sys_id , 
transaction_id , 
amortisation_date , 
leg_no , 
notional_amount , 
fix_rate , 
daily_referral , 
cashflow_start_ind , 
cashflow_end_ind
FROM trnx_deriv_amortisations
WHERE handoff_src_id IN (${handoff_source_id})

##END!!