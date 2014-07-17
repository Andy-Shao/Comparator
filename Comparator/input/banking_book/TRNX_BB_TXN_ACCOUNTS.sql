1,host_system_id,number(12,0)
2,account_id,number(15,0)
3,country,varchar2(16 char)
4,account_name,varchar2(20 char)
5,handoff_src_id,number(12,0)
6,branch,number(7,0)
7,base,number(12,0)
8,gfcid,number(10,0)
9,citicorp_unit_gfcid,number(10,0)
10,sub_instrument,number(12,0)
11,host_org_unit,varchar2(10 char)
12,glsl,number(7,0)
13,product_category,varchar2(18 char)
14,account_ccy,varchar2(3 char)
15,account_open_date,timestamp (6)
16,account_status,char(1 byte)
17,hoff_id,number(12,0)
18,update_date,timestamp (6)
19,maturity_date,timestamp (6)
20,node_3,varchar2(18 char)
21,cust_ouc,varchar2(10 char)
22,sequence_number,number(38,0)
23,peak_utilization,float(126)
24,gross_peak_utilization,float(126)
25,net_peak_utilization,float(126)
26,scr_id,varchar2(50 char)
27,scr_id_typ_cd,varchar2(18 char)
28,src_txn_id,varchar2(150 char)
29,issuer_name,varchar2(120 char)
30,ltd_credit_amount,float(126)
31,ltd_non_credit_amount,float(126)

##END!!

SELECT 
host_system_id , 
account_id , 
country , 
account_name , 
handoff_src_id , 
branch , 
base , 
gfcid , 
citicorp_unit_gfcid , 
sub_instrument , 
host_org_unit , 
glsl , 
product_category , 
account_ccy , 
account_open_date , 
account_status , 
hoff_id , 
update_date , 
maturity_date , 
node_3 , 
cust_ouc , 
sequence_number , 
peak_utilization , 
gross_peak_utilization , 
net_peak_utilization , 
scr_id , 
scr_id_typ_cd , 
src_txn_id , 
issuer_name , 
ltd_credit_amount , 
ltd_non_credit_amount
FROM trnx_bb_txn_accounts WHERE handoff_src_id IN (${handoff_source_id})

##END!!