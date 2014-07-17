1,handoff_src_id,number(12),not null
2,previous_trans_loaded,number(12)
3,split_status,number(12)
4,split_records,number(12)
5,split_txn_count,number(12)
6,split_acct_count,number(12)
7,split_collateral_count,number(12)

##END!!

SELECT 
handoff_src_id,
nvl(previous_trans_loaded,0) AS previous_trans_loaded,
split_status,
split_records,
split_txn_count,
nvl(split_acct_count,0) AS split_acct_count,
split_collateral_count 
FROM trnx_deriv_handoff_status
WHERE handoff_src_id IN (${handoff_source_id})

##END!!