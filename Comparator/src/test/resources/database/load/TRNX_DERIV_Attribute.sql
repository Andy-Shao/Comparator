1,country,varchar2(2 char),not null
2,system_unit_id,number(12),not null
3,transaction_id,varchar2(18 char),not null
4,american_eur_ind,char(1)
5,branch,number(7)
6,buy_sell_ind,char(1)
7,citicorp_unit_gfcid,number(10)
8,cmtm_ccy,char(3)
9,early_termination,varchar2(3 char)
10,early_termination_date,timestamp(6)
11,expiry_date,timestamp(6)
12,fail_ind,char(1)
13,gfcid,number(10)
14,handoff_src_id,number(12),not null
15,host_citicorp_unit,varchar2(12 char)
16,host_client_id,number(12)
17,instrument,number(12)
18,market_value_ccy,varchar2(3 char)
19,maturity_date,timestamp(6)
20,mult_term_flag,char(1)
21,no_of_legs,number(7)
22,no_settlement_risk,char(1)
23,number_of_principals,number(7)
24,number_of_units,float
25,notification_days,number(7)
26,org_unit,varchar2(6 char)
27,physical_cash_ind,char(1)
28,premium_ccy,varchar2(3 char)
29,pro_price_rate,float
30,portfolio,varchar2(8 char)
31,option_put_call_ind,char(1)
32,salesperson_id,varchar2(6 char)
33,settlement_date,timestamp(6)
34,spot_forward_ind,char(1)
35,start_date,timestamp(6)
36,sub_instrument,number(12)
37,option_strike_price,float
38,trade_date,timestamp(6)
39,trader_id,varchar2(6 char)
40,trader_originator,varchar2(12 char)
41,underlying_start_dt,timestamp(6)
42,underlying_maturity_dt,timestamp(6)
43,volatility_index_basket,varchar2(20 char)
44,deleted,varchar2(1)
45,account_class,varchar2(6 char)
46,account_id,varchar2(12 char)
47,account_name,varchar2(40 char)
48,delta,float
49,gamma,float
50,host_instrument,varchar2(16 char)
51,primary_sys_id,int
52,primary_trans_id,varchar2(18 char)
53,reset_period,int
54,default_swap_ref_entity,varchar2(30 char)
55,default_swap_spread_curve_id,varchar2(14 char)
56,default_swap_ref_cusip,varchar2(13 char)
57,barrier_up_down_ind,char(1)
58,barrier_in_out_ind,char(1)
59,barrier_option,float
60,init_margin_reqmt,float
61,init_margin_reqmt_ccy,char(3)
62,deferred_prem_ind,char(1)
63,netting_agrmt_id,number(12)
64,margin_agrmt_id,number(12)
65,particpt_assignment_ind,varchar2(1)
66,funded_unfunded_ind,varchar2(1)
67,revolver_term_loan_ind,varchar2(12 char)
68,cusip,varchar2(9 char)
69,cusip_description,varchar2(40 char)
70,settlement_ind,char(1)
71,price_conversion,float
72,comsys_deal_type,varchar2(32 char)
73,system_ref_id,char(16)
74,reference_deriv,char(1),not null
75,protection,char(1)
76,sequence_number,int
77,upi,varchar(76)
78,implied_volatility,float
79,ticker,varchar2(16 char)
80,curve_id,varchar2(16 char)
81,cds_type,char(3)
82,cds_netting_id,varchar2(16 char)
83,var_eligible_indicator,char(1)
84,document_status,char(1)
85,next_call_put_cancel_date,timestamp(6)
86,next_payment_date,timestamp(6)
87,purpose_of_position,varchar2(3 char)
88,delivery_location,varchar2(66 char)
89,relationship_ind,varchar2(2 char)
90,barrier_type,varchar2(1)
91,barrier_2_up_down_ind,varchar2(1)
92,barrier_2_in_out_ind,varchar2(1)
93,barrier_2_option,float
94,barrier_2_type,varchar2(1 char)
95,trader_soeid,varchar2(7 char)
96,end_date,timestamp(6)
97,apar,varchar2(18 char)
98,cpty_mnemonic,varchar2(10 char)
99,cpty_mnemonic_ind,char(1)
100,firm_business_unit_desc,varchar2(64 char)
101,cpty_business_unit_desc,varchar2(64 char)
102,barrier_strike_1_ccy_1,varchar2(3 char)
103,barrier_strike_1_ccy_2,varchar2(3 char)
104,strike_price_2,float
105,barrier_strike_2_ccy_1,varchar2(3 char)
106,barrier_strike_2_ccy_2,varchar2(3 char)
107,pf_total_equity,float
108,pf_total_equity_ccy,varchar2(3 char)
109,facility_id,number(12)
110,sub_limit_id,number(7)
111,external_match_id,varchar2(16 char)
112,group_id,varchar2(16 char)
113,premium_amount,float
114,premium_date,timestamp(6)
115,unwind_date,timestamp(6)
116,unwind_ind,char(1),default 'n',not null
117,attachment_point,float
118,detachment_point,float
119,strategy_code,varchar2(5 char)
120,strategy_name,varchar2(60 char)
121,bond_swap_leverage,float
122,dividend_yield,float
123,underlying_issuer_name,varchar2(50 char)
124,ticket_id,number(12)
125,delta_equivalent_notional,float
126,desk_code,varchar2(60 char)
127,source_sys_swwr_ind,varchar(1)
128,red_id,varchar2(13 char)
129,recovery_rate,float
130,firm_role_id,number(7)
131,edealer_id,varchar2(15 char)
132,gmi_account_id,varchar2(18 char)
133,clearing_house,varchar2(18 char)
134,unique_trade_id,varchar2(50 char)
135,desk_name_id,number(7)

##END!!

SELECT 
country , 
system_unit_id , 
transaction_id , 
american_eur_ind , 
branch , 
buy_sell_ind , 
citicorp_unit_gfcid , 
cmtm_ccy , 
early_termination , 
early_termination_date , 
expiry_date , 
fail_ind , 
gfcid , 
handoff_src_id , 
host_citicorp_unit , 
host_client_id , 
instrument , 
market_value_ccy , 
maturity_date , 
mult_term_flag , 
no_of_legs , 
no_settlement_risk , 
number_of_principals , 
number_of_units , 
notification_days , 
org_unit , 
physical_cash_ind , 
premium_ccy , 
pro_price_rate , 
portfolio , 
option_put_call_ind , 
salesperson_id , 
settlement_date , 
spot_forward_ind , 
start_date , 
sub_instrument , 
option_strike_price , 
trade_date , 
trader_id , 
trader_originator , 
underlying_start_dt , 
underlying_maturity_dt , 
volatility_index_basket , 
deleted , 
account_class , 
account_id , 
account_name , 
delta , 
gamma , 
host_instrument , 
primary_sys_id , 
primary_trans_id , 
reset_period , 
default_swap_ref_entity , 
default_swap_spread_curve_id , 
default_swap_ref_cusip , 
barrier_up_down_ind , 
barrier_in_out_ind , 
barrier_option , 
init_margin_reqmt , 
init_margin_reqmt_ccy , 
deferred_prem_ind , 
netting_agrmt_id , 
margin_agrmt_id , 
particpt_assignment_ind , 
funded_unfunded_ind , 
revolver_term_loan_ind , 
cusip , 
cusip_description , 
settlement_ind , 
price_conversion , 
comsys_deal_type , 
system_ref_id , 
reference_deriv , 
protection , 
sequence_number , 
upi , 
implied_volatility , 
ticker , 
curve_id , 
cds_type , 
cds_netting_id , 
var_eligible_indicator , 
document_status , 
next_call_put_cancel_date , 
next_payment_date , 
purpose_of_position , 
delivery_location , 
relationship_ind , 
barrier_type , 
barrier_2_up_down_ind , 
barrier_2_in_out_ind , 
barrier_2_option , 
barrier_2_type , 
trader_soeid , 
end_date , 
apar , 
cpty_mnemonic , 
cpty_mnemonic_ind , 
firm_business_unit_desc , 
cpty_business_unit_desc , 
barrier_strike_1_ccy_1 , 
barrier_strike_1_ccy_2 , 
strike_price_2 , 
barrier_strike_2_ccy_1 , 
barrier_strike_2_ccy_2 , 
pf_total_equity , 
pf_total_equity_ccy , 
facility_id , 
sub_limit_id , 
external_match_id , 
group_id , 
premium_amount , 
premium_date , 
unwind_date , 
unwind_ind , 
attachment_point , 
detachment_point , 
strategy_code , 
strategy_name , 
bond_swap_leverage , 
dividend_yield , 
underlying_issuer_name , 
ticket_id , 
delta_equivalent_notional , 
desk_code , 
source_sys_swwr_ind , 
red_id , 
recovery_rate , 
firm_role_id , 
edealer_id , 
gmi_account_id , 
clearing_house , 
unique_trade_id , 
desk_name_id 
FROM trnx_deriv_attribute
WHERE handoff_src_id IN (${handoff_source_id})

##END!!
