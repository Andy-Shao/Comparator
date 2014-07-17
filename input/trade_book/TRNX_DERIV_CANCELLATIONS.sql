1,host_sys_id,varchar2(10 char), not null
2,transaction_id,varchar2(30 char), not null
3,leg_no,number(8), null
4,handoff_src_id,number(12), not null
5,notification_date,TIMESTAMP, not null
6,exercise_eff_date,TIMESTAMP, not null
7,fee_amount,float, not null

##END!!

SELECT 
host_sys_id , 
transaction_id , 
leg_no , 
handoff_src_id , 
notification_date , 
exercise_eff_date , 
fee_amount 
FROM trnx_deriv_cancellations
WHERE handoff_src_id IN (${handoff_source_id})

##END!!