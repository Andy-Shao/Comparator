1,host_sys_id,number(12),not null
2,transaction_id,varchar2(18 char),not null
3,leg_no,number(12),not null
4,effective_date,timestamp(6),null
5,cashflow_start_ind,char(1),null
6,cashflow_end_ind,char(1),null
7,interest_rate1,float,null
8,leverage,float,null
9,nominal_amount,float,null
10,reset_frequency,number(8),null
11,ref_rate_tenor,char(3),null
12,spread,float,null

##END!!

SELECT 
host_sys_id , 
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
FROM trnx_deriv_leg_nominals

##END!!