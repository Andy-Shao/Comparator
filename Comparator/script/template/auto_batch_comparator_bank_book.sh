#!/bin/sh
#ident "%W%"
#

${BASE_DIR}/bin/batch_load_data_from_oracle.sh  file:${BANKING_BOOK_INPUT_ARGS}/batch_load_data_from_oracle.xml#file:${BANKING_BOOK_SQL_PROCESS}/sqlProcess.xml
${BASE_DIR}/bin/batch_load_data_from_sybase.sh  file:${BANKING_BOOK_INPUT_ARGS}/batch_load_data_from_sybase.xml#file:${BANKING_BOOK_SQL_PROCESS}/sqlProcess.xml

#account_balances
${BASE_DIR}/bin/comparator.sh ${BANKING_BOOK_OUTPUT}/account_balances_oracle.csv ${BANKING_BOOK_OUTPUT}/account_balances_sybase.csv -Dexport.detail#-Ddifferent=${BANKING_BOOK_OUTPUT}/different_account_balances.dat#-DonlyFileAHas=${BANKING_BOOK_OUTPUT}/onlyFileAHas_account_balances.dat#-DonlyFileBHas=${BANKING_BOOK_OUTPUT}/onlyFileBHas_account_balances.dat file:${BANKING_BOOK_INPUT_ARGS}/TRNX_BB_TXN_ACCOUNT_BALANCES_Comparator.xml

#accounts
${BASE_DIR}/bin/comparator.sh ${BANKING_BOOK_OUTPUT}/accounts_oracle.csv ${BANKING_BOOK_OUTPUT}/accounts_sybase.csv -Dexport.detail#-Ddifferent=${BANKING_BOOK_OUTPUT}/different_accounts.dat#-DonlyFileAHas=${BANKING_BOOK_OUTPUT}/onlyFileAHas_accounts.dat#-DonlyFileBHas=${BANKING_BOOK_OUTPUT}/onlyFileBHas_accounts.dat file:${BANKING_BOOK_INPUT_ARGS}/TRNX_BB_TXN_ACCOUNTS_Comparator.xml

#general_trans
${BASE_DIR}/bin/comparator.sh ${BANKING_BOOK_OUTPUT}/general_trans_oracle.csv ${BANKING_BOOK_OUTPUT}/general_trans_sybase.csv -Dexport.detail#-Ddifferent=${BANKING_BOOK_OUTPUT}/different_general_trans.dat#-DonlyFileAHas=${BANKING_BOOK_OUTPUT}/onlyFileAHas_general_trans.dat#-DonlyFileBHas=${BANKING_BOOK_OUTPUT}/onlyFileBHas_general_trans.dat file:${BANKING_BOOK_INPUT_ARGS}/TRNX_BB_TXN_GENERAL_TRANS_Comparator.xml

#leg_daily_bal
${BASE_DIR}/bin/comparator.sh ${BANKING_BOOK_OUTPUT}/leg_daily_bal_oracle.csv ${BANKING_BOOK_OUTPUT}/leg_daily_bal_sybase.csv -Dexport.detail#-Ddifferent=${BANKING_BOOK_OUTPUT}/different_leg_daily_bal.dat#-DonlyFileAHas=${BANKING_BOOK_OUTPUT}/onlyFileAHas_leg_daily_bal.dat#-DonlyFileBHas=${BANKING_BOOK_OUTPUT}/onlyFileBHas_leg_daily_bal.dat file:${BANKING_BOOK_INPUT_ARGS}/TRNX_BB_TXN_LEG_DAILY_BAL_Comparator.xml

#leg_nominals
${BASE_DIR}/bin/comparator.sh ${BANKING_BOOK_OUTPUT}/leg_nominals_oracle.csv ${BANKING_BOOK_OUTPUT}/leg_nominals_sybase.csv -Dexport.detail#-Ddifferent=${BANKING_BOOK_OUTPUT}/different_leg_nominals.dat#-DonlyFileAHas=${BANKING_BOOK_OUTPUT}/onlyFileAHas_leg_nominals.dat#-DonlyFileBHas=${BANKING_BOOK_OUTPUT}/onlyFileBHas_leg_nominals.dat file:${BANKING_BOOK_INPUT_ARGS}/TRNX_BB_TXN_LEG_DAILY_BAL_Comparator.xml

#legs
${BASE_DIR}/bin/comparator.sh ${BANKING_BOOK_OUTPUT}/legs_oracle.csv ${BANKING_BOOK_OUTPUT}/legs_sybase.csv -Dexport.detail#-Ddifferent=${BANKING_BOOK_OUTPUT}/different_legs.dat#-DonlyFileAHas=${BANKING_BOOK_OUTPUT}/onlyFileAHas_legs.dat#-DonlyFileBHas=${BANKING_BOOK_OUTPUT}/onlyFileBHas_legs.dat file:${BANKING_BOOK_INPUT_ARGS}/TRNX_BB_TXN_LEGS_Comparator.xml

#transaction
${BASE_DIR}/bin/comparator.sh ${BANKING_BOOK_OUTPUT}/transactions_oracle.csv ${BANKING_BOOK_OUTPUT}/transactions_sybase.csv -Dexport.detail#-Ddifferent=${BANKING_BOOK_OUTPUT}/different_transactions.dat#-DonlyFileAHas=${BANKING_BOOK_OUTPUT}/onlyFileAHas_transactions.dat#-DonlyFileBHas=${BANKING_BOOK_OUTPUT}/onlyFileBHas_transactions.dat file:${BANKING_BOOK_INPUT_ARGS}/TRNX_BB_TXN_TRANSACTIONS_Comparator.xml

#exclude_records
${BASE_DIR}/bin/comparator.sh ${BANKING_BOOK_OUTPUT}/exclude_records_oracle.csv ${BANKING_BOOK_OUTPUT}/exclude_records_sybase.csv -Dexport.detail#-Ddifferent=${BANKING_BOOK_OUTPUT}/different_exclude_records.dat#-DonlyFileAHas=${BANKING_BOOK_OUTPUT}/onlyFileAHas_exclude_records.dat#-DonlyFileBHas=${BANKING_BOOK_OUTPUT}/onlyFileBHas_exclude_records.dat file:${BANKING_BOOK_INPUT_ARGS}/TRNX_DERIV_EXCLUDE_RECORDS_Comparator.xml

#handoff_status
${BASE_DIR}/bin/comparator.sh ${BANKING_BOOK_OUTPUT}/handoff_status_oracle.csv ${BANKING_BOOK_OUTPUT}/handoff_status_sybase.csv -Dexport.detail#-Ddifferent=${BANKING_BOOK_OUTPUT}/different_handoff_status.dat#-DonlyFileAHas=${BANKING_BOOK_OUTPUT}/onlyFileAHas_handoff_status.dat#-DonlyFileBHas=${BANKING_BOOK_OUTPUT}/onlyFileBHas_handoff_status.dat file:${BANKING_BOOK_INPUT_ARGS}/TRNX_DERIV_HANDOFF_STATUS_Comparator.xml

#reject_records
${BASE_DIR}/bin/comparator.sh ${BANKING_BOOK_OUTPUT}/reject_records_oracle.csv ${BANKING_BOOK_OUTPUT}/reject_records_sybase.csv -Dexport.detail#-Ddifferent=${BANKING_BOOK_OUTPUT}/different_reject_records.dat#-DonlyFileAHas=${BANKING_BOOK_OUTPUT}/onlyFileAHas_reject_records.dat#-DonlyFileBHas=${BANKING_BOOK_OUTPUT}/onlyFileBHas_reject_records.dat file:${BANKING_BOOK_INPUT_ARGS}/TRNX_DERIV_REJECT_RECORDS_Comparator.xml