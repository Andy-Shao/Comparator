1,host_system_id,number(12,0)
2,transaction_id,varchar2(18 char)
3,leg_no,number(3,0)
4,effective_date,timestamp (6)
5,cashflow_start_ind,char(1 byte)
6,cashflow_end_ind,char(1 byte)
7,interest_rate1,number(15,0)
8,leverage,number(15,0)
9,nominal_amount,number(15,0)
10,reset_frequency,number(3,0)
11,ref_rate_tenor,char(1 byte)
12,spread,number(15,0)

##END!!

SELECT 
host_system_id , 
transaction_id , 
leg_no , 
effective_date , 
cashflow_start_ind , 
cashflow_end_ind , 
interest_rate1 , 
leverage , 
nominal_amount , 
reset_frequency , 
ref_rate_tenor , 
spread
FROM trnx_bb_txn_leg_nominals WHERE host_system_id IN (${handoff_source_id})

##END!!