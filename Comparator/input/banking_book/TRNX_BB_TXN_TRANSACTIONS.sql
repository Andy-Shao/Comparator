1,host_system_id,number(12,0)
2,transaction_id,varchar2(18 char)
3,country,varchar2(2 char)
4,handoff_src_id,number(12,0)
5,branch,number(7,0)
6,buy_sell_ind,char(1 byte)
7,citicorp_unit_gfcid,number(10,0)
8,fail_ind,char(1 byte)
9,gfcid,number(10,0)
10,host_citicorp_unit,varchar2(12 char)
11,host_client_id,number(12,0)
12,no_of_units,float(126)
13,no_settlement_risk,char(1 byte)
14,org_unit,varchar2(6 char)
15,physical_cash_ind,char(1 byte)
16,premium_ccy,varchar2(3 char)
17,professional_price,float(15)
18,portfolio,varchar2(8 char)
19,salesperson_id,varchar2(6 char)
20,settlement_date,timestamp (6)
21,settle_scheds,number(12,0)
22,sub_instrument,number(12,0)
23,trade_date,timestamp (6)
24,trader_id,varchar2(6 char)
25,txn_status,char(1 byte)
26,txn_storage_type,char(1 byte)
27,product_category,varchar2(18 char)
28,sequence_number,number(38,0)
29,facility_id,number(12,0)
30,sub_limit_id,number(7,0)
31,non_performing_loan_indicator,char(1 byte)
32,write_off_amount,number(18,0)
33,contra_interest_amt,number(18,0)
34,asset_transfer_marks_amt,number(18,0)
35,fas_91_unamortised_fees_amt,number(18,0)
36,fas_114_funded_reserves_amt,number(18,0)
37,fas_114_unfunded_reserves_amt,number(18,0)
38,scr_id,varchar2(50 char)
39,scr_id_typ_cd,varchar2(18 char)
40,src_txn_id,varchar2(150 char)
41,issuer_name,varchar2(120 char)
42,ltd_credit_amount,float(126)
43,ltd_non_credit_amount,float(126)

##END!!

SELECT 
host_system_id , 
transaction_id , 
country , 
handoff_src_id , 
branch , 
buy_sell_ind , 
citicorp_unit_gfcid , 
fail_ind , 
gfcid , 
host_citicorp_unit , 
host_client_id , 
no_of_units , 
no_settlement_risk , 
org_unit , 
physical_cash_ind , 
premium_ccy , 
professional_price , 
portfolio , 
salesperson_id , 
settlement_date , 
settle_scheds , 
sub_instrument , 
trade_date , 
trader_id , 
txn_status , 
txn_storage_type , 
product_category , 
sequence_number , 
facility_id , 
sub_limit_id , 
non_performing_loan_indicator , 
write_off_amount , 
contra_interest_amt , 
asset_transfer_marks_amt , 
fas_91_unamortised_fees_amt , 
fas_114_funded_reserves_amt , 
fas_114_unfunded_reserves_amt , 
scr_id , 
scr_id_typ_cd , 
src_txn_id , 
issuer_name , 
ltd_credit_amount , 
ltd_non_credit_amount 
FROM trnx_bb_txn_transactions WHERE handoff_src_id IN (${handoff_source_id})

##END!!