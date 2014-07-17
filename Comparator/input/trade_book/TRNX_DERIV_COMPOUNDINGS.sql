1,handoff_src_id,number(12),not null
2,host_sys_id,number(12),not null
3,transaction_id,varchar2(18 char),not null
4,leg_no,number(3),not null
5,compounding_date,timestamp(6),not null

##END!!

SELECT 
handoff_src_id , 
host_sys_id , 
transaction_id , 
leg_no , 
compounding_date
FROM trnx_deriv_compoundings
WHERE handoff_src_id IN (${handoff_source_id})

##END!!