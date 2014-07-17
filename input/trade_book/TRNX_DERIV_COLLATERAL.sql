1,country,char(2),not null
2,host_sys_id,number(12),not null
3,transaction_id,varchar2(18 char),not null
4,handoff_src_id,number(12),not null
5,accrued_interest,float
6,ccy_code,varchar2(3 char)
7,citicorp_unit_gfcid,number(10,0)
8,cusip_desc,varchar2(30 char)
9,cusip_number,varchar2(12 char)
10,fail_ind,char(1)
11,gfcid,number(10,0)
12,haircut,float
13,maturity_date,timestamp(6)
14,nominal_amount,float
15,portfolio,varchar2(8 char)
16,reason_code,varchar2(16 char)
17,sub_instrument,number(12)
18,cmtm,float
19,reval_price,float
20,reason_code_2,varchar2(16 char)
21,cefe_collateral_id,float
22,account_id,varchar2(12 char)
23,host_client_id,number(12,0)
24,branch,varchar2(12 char)
25,im_vm_flag,varchar2(2 char)
26,oasys_netting_agrmt_status,varchar2(2 char)
27,oasys_margin_agrmt_status,varchar2(2 char)
28,isin,varchar2(12 char)
29,coll_at_custodian,char(1)
30,gmi_account_id,varchar2(18 char)
31,illiquid_security_ind,varchar2(1)

##END!!

SELECT 
country , 
host_sys_id , 
transaction_id , 
handoff_src_id , 
accrued_interest , 
ccy_code , 
citicorp_unit_gfcid , 
cusip_desc , 
cusip_number , 
fail_ind , 
gfcid , 
haircut , 
maturity_date , 
nominal_amount , 
portfolio , 
reason_code , 
sub_instrument , 
cmtm , 
reval_price , 
reason_code_2 , 
cefe_collateral_id , 
account_id , 
host_client_id , 
branch , 
im_vm_flag , 
oasys_netting_agrmt_status , 
oasys_margin_agrmt_status , 
isin , 
coll_at_custodian , 
gmi_account_id , 
illiquid_security_ind
FROM trnx_deriv_collateral
WHERE handoff_src_id IN (${handoff_source_id})

##END!!