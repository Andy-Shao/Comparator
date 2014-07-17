1,host_system_id,number(12,0)
2,transaction_id,varchar2(18 char)
3,leg_no,number(3,0)
4,leg_pay_receive_ind,char(1 byte)
5,arrears_rate_fix_ind,char(1 byte)
6,coupon_yield_curve,varchar2(18 char)
7,fixed_floating_ind,varchar2(2 char)
8,interest_rate_method,number(3,0)
9,nominal_ccy,varchar2(3 char)
10,ref_rate_ccy,varchar2(3 char)
11,ref_rate_source,varchar2(8 char)

##END!!

SELECT 
host_system_id , 
transaction_id , 
leg_no , 
leg_pay_receive_ind , 
arrears_rate_fix_ind , 
coupon_yield_curve , 
fixed_floating_ind , 
interest_rate_method , 
nominal_ccy , 
ref_rate_ccy , 
ref_rate_source
FROM trnx_bb_txn_legs WHERE host_system_id IN (${handoff_source_id})

##END!!