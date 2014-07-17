1,host_sys_id,number(12),not null
2,transaction_id,varchar2(18 char),not null
3,handoff_src_id,number(12),not null
4,leg_no,number(3),not null
5,rate_reset_date,timestamp(6),not null
6,actual_reset_date,timestamp(6),not null
7,interest_rate,float,not null

##END!!

SELECT 
host_sys_id , 
transaction_id , 
handoff_src_id , 
leg_no , 
rate_reset_date , 
actual_reset_date , 
interest_rate
FROM trnx_deriv_rate_resets
WHERE handoff_src_id IN (${handoff_source_id})
##END!!