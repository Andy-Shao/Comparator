1,host_system_id,number(12,0)
2,account_id,number(15,0)
3,balance_date,timestamp (6)
4,orig_ccy_balances,float(126)

##END!!

SELECT 
host_system_id , 
account_id , 
balance_date , 
orig_ccy_balances
FROM trnx_bb_txn_account_balances WHERE host_system_id IN (${handoff_source_id})

##END!!