1,host_sys_id,number(12),not null
2,transaction_id,varchar2(18 char),not null
3,handoff_src_id,number(12),not null
4,leg_no,number(3),not null
5,reset_date,timestamp(6),not null
6,notional_amount,float

##END!!

SELECT 
host_sys_id , 
transaction_id , 
handoff_src_id , 
leg_no , 
reset_date , 
notional_amount
FROM trnx_deriv_fx_rate_resets
WHERE handoff_src_id IN (${handoff_source_id})

##END!!