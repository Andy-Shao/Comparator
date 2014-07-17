1,host_system_id,number(12,0)
2,transaction_id,varchar2(18 char)
3,leg_activity_date,timestamp (6)
4,reval_profit_loss_usd,number(15,0)
5,pv_unpaid_premium,number(15,0)
6,present_value,number(15,0)

##END!!

SELECT 
host_system_id , 
transaction_id , 
leg_activity_date , 
reval_profit_loss_usd , 
pv_unpaid_premium , 
present_value
FROM trnx_bb_txn_leg_daily_bal WHERE host_system_id IN (${handoff_source_id})

##END!!