1,country,varchar2(2),not null
2,system_unit_id,number(12),not null
3,transaction_id,varchar2(18 char),not null
4,cmtm,float
5,market_value,float
6,default_swap_current_spread,float
7,cmtm_value_date,timestamp(6)
8,adjusted_cmtm_flag,char(1)
9,adjusted_cmtm,float
10,unadjusted_cmtm,float
11,default_swap_exec_spread,float

##END!!

SELECT 
bal.country , 
bal.system_unit_id , 
bal.transaction_id , 
bal.cmtm , 
bal.market_value , 
bal.default_swap_current_spread , 
bal.cmtm_value_date , 
bal.adjusted_cmtm_flag , 
bal.adjusted_cmtm , 
bal.unadjusted_cmtm , 
bal.default_swap_exec_spread
FROM trnx_deriv_balances bal, trnx_deriv_attribute tr WHERE tr.transaction_id=bal.transaction_id AND tr.system_unit_id=bal.system_unit_id AND tr.handoff_src_id IN (${handoff_source_id})
##END!!