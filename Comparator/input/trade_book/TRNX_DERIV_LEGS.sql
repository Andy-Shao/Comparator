1,country,varchar2(2 char),not null
2,system_unit_id,number(12),not null
3,transaction_id,varchar2(18 char),not null
4,leg,number(3),not null
5,arrears_rate_fix,char(1)
6,notional_real_back,char(1)
7,notional_real_front,char(1)
8,coupon_yield_curve,varchar2(4 char)
9,fixed_float_ind,varchar2(2 char)
10,interest_calc_convention,number(3)
11,interest_rate,float
12,leverage,float
13,notional,float
14,notional_ccy,varchar2(3 char)
15,rate_fixing_frequency,number(7)
16,ref_rate_ccy,varchar2(3 char)
17,ref_rate_source,varchar2(8 char)
18,ref_rate_tenor,varchar2(3 char)
19,spread,float
20,pse_eq_opt_notional,float
21,commodity_offset,number(12)
22,commodity_offset_units,number(12)
23,commodity_descr,varchar2(50 char)
24,notional_units,varchar2(25 char)
25,notional_time_units,number(12)
26,pse_notional,float
27,no_of_cash_flow,number(12)
28,reset_freq,number(12)
29,no_of_resets,number(12)
30,no_of_amortisations,number(12)
31,annualised_notional_amount,float
32,original_notional,float
33,sr_base_netting_ind,char(1)
34,settlement_type,char(1)

##END!!

SELECT 
leg.country , 
leg.system_unit_id , 
leg.transaction_id , 
leg.leg , 
leg.arrears_rate_fix , 
leg.notional_real_back , 
leg.notional_real_front , 
leg.coupon_yield_curve ,  
leg.fixed_float_ind , 
leg.interest_calc_convention , 
leg.interest_rate , 
leg.leverage , 
leg.notional , 
leg.notional_ccy , 
leg.rate_fixing_frequency , 
leg.ref_rate_ccy , 
leg.ref_rate_source , 
leg.ref_rate_tenor , 
leg.spread , 
leg.pse_eq_opt_notional , 
leg.commodity_offset , 
leg.commodity_offset_units , 
leg.commodity_descr , 
leg.notional_units , 
leg.notional_time_units , 
leg.pse_notional , 
leg.no_of_cash_flow , 
leg.reset_freq , 
leg.no_of_resets , 
leg.no_of_amortisations , 
leg.annualised_notional_amount ,  
leg.original_notional , 
leg.sr_base_netting_ind,
leg.settlement_type
FROM trnx_deriv_attribute tr, trnx_deriv_legs leg WHERE  tr.transaction_id=leg.transaction_id AND tr.system_unit_id=leg.system_unit_id AND tr.handoff_src_id IN (${handoff_source_id})  
##END!!
