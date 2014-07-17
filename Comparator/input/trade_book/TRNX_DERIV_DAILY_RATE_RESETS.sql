1,host_sys_id,number(12),not null
2,transaction_id,varchar2(18 char),not null
3,handoff_src_id,number(12),not null
4,leg_no,number(3),not null
5,reset_start_date,timestamp(6),not null
6,reset_end_date,timestamp(6),not null
7,actual_business_days_ind,char(1),not null
8,lag,number(12),not null

##END!!

SELECT 
host_sys_id , 
transaction_id , 
handoff_src_id , 
leg_no , 
reset_start_date , 
reset_end_date , 
actual_business_days_ind , 
lag
FROM trnx_deriv_daily_rate_resets
WHERE handoff_src_id IN (${handoff_source_id})
##END!!