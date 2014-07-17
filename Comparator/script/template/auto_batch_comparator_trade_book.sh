#!/bin/sh
#ident "%W%"
#

${BASE_DIR}/bin/batch_load_data_from_oracle.sh  file:${TRADING_BOOK_INPUT_ARGS}/batch_load_data_from_oracle.xml#file:${TRADING_BOOK_SQL_PROCESS}/sqlProcess.xml
${BASE_DIR}/bin/batch_load_data_from_sybase.sh  file:${TRADING_BOOK_INPUT_ARGS}/batch_load_data_from_sybase.xml#file:${TRADING_BOOK_SQL_PROCESS}/sqlProcess.xml

#transaction
${BASE_DIR}/bin/comparator.sh ${TRADING_BOOK_OUTPUT}/transaction_oracle.csv ${TRADING_BOOK_OUTPUT}/transaction_sybase.csv -Dexport.detail#-Ddifferent=${TRADING_BOOK_OUTPUT}/different_transaction.dat#-DonlyFileAHas=${TRADING_BOOK_OUTPUT}/onlyFileAHas_transaction.dat#-DonlyFileBHas=${TRADING_BOOK_OUTPUT}/onlyFileBHas_transaction.dat file:${TRADING_BOOK_INPUT_ARGS}/transactionComparator.xml

#legs
${BASE_DIR}/bin/comparator.sh ${TRADING_BOOK_OUTPUT}/legs_oracle.csv ${TRADING_BOOK_OUTPUT}/legs_sybase.csv -Dexport.detail#-Ddifferent=${TRADING_BOOK_OUTPUT}/different_legs.dat#-DonlyFileAHas=${TRADING_BOOK_OUTPUT}/onlyFileAHas_legs.dat#-DonlyFileBHas=${TRADING_BOOK_OUTPUT}/onlyFileBHas_legs.dat file:${TRADING_BOOK_INPUT_ARGS}/TRNX_DERIV_LEGSComparator.xml

#balances
${BASE_DIR}/bin/comparator.sh ${TRADING_BOOK_OUTPUT}/balances_oracle.csv ${TRADING_BOOK_OUTPUT}/balances_sybase.csv -Dexport.detail#-Ddifferent=${TRADING_BOOK_OUTPUT}/different_balances.dat#-DonlyFileAHas=${TRADING_BOOK_OUTPUT}/onlyFileAHas_balances.dat#-DonlyFileBHas=${TRADING_BOOK_OUTPUT}/onlyFileBHas_balances.dat file:${TRADING_BOOK_INPUT_ARGS}/TRNX_DERIV_BALANCESComparator.xml

#amortisations
${BASE_DIR}/bin/comparator.sh ${TRADING_BOOK_OUTPUT}/amortisations_oracle.csv ${TRADING_BOOK_OUTPUT}/amortisations_sybase.csv -Dexport.detail#-Ddifferent=${TRADING_BOOK_OUTPUT}/different_amortisations.dat#-DonlyFileAHas=${TRADING_BOOK_OUTPUT}/onlyFileAHas_amortisations.dat#-DonlyFileBHas=${TRADING_BOOK_OUTPUT}/onlyFileBHas_amortisations.dat file:${TRADING_BOOK_INPUT_ARGS}/TRNX_DERIV_AMORTISATIONSComparator.xml

#compoundings
${BASE_DIR}/bin/comparator.sh ${TRADING_BOOK_OUTPUT}/compoundings_oracle.csv ${TRADING_BOOK_OUTPUT}/compoundings_sybase.csv -Dexport.detail#-Ddifferent=${TRADING_BOOK_OUTPUT}/different_compoundings.dat#-DonlyFileAHas=${TRADING_BOOK_OUTPUT}/onlyFileAHas_compoundings.dat#-DonlyFileBHas=${TRADING_BOOK_OUTPUT}/onlyFileBHas_compoundings.dat file:${TRADING_BOOK_INPUT_ARGS}/TRNX_DERIV_AMORTISATIONSComparator.xml

#daily_rate_resets
${BASE_DIR}/bin/comparator.sh ${TRADING_BOOK_OUTPUT}/daily_rate_resets_oracle.csv ${TRADING_BOOK_OUTPUT}/daily_rate_resets_sybase.csv -Dexport.detail#-Ddifferent=${TRADING_BOOK_OUTPUT}/different_daily_rate_resets.dat#-DonlyFileAHas=${TRADING_BOOK_OUTPUT}/onlyFileAHas_daily_rate_resets.dat#-DonlyFileBHas=${TRADING_BOOK_OUTPUT}/onlyFileBHas_daily_rate_resets.dat file:${TRADING_BOOK_INPUT_ARGS}/TRNX_DERIV_DAILY_RATE_RESETS_Comparator.xml

#fx_rate_resets
${BASE_DIR}/bin/comparator.sh ${TRADING_BOOK_OUTPUT}/fx_rate_resets_oracle.csv ${TRADING_BOOK_OUTPUT}/fx_rate_resets_sybase.csv -Dexport.detail#-Ddifferent=${TRADING_BOOK_OUTPUT}/different_fx_rate_resets.dat#-DonlyFileAHas=${TRADING_BOOK_OUTPUT}/onlyFileAHas_fx_rate_resets.dat#-DonlyFileBHas=${TRADING_BOOK_OUTPUT}/onlyFileBHas_fx_rate_resets.dat file:${TRADING_BOOK_INPUT_ARGS}/TRNX_DERIV_FX_RATE_RESETS_Comparator.xml

#fee
${BASE_DIR}/bin/comparator.sh ${TRADING_BOOK_OUTPUT}/fees_oracle.csv ${TRADING_BOOK_OUTPUT}/fees_sybase.csv -Dexport.detail#-Ddifferent=${TRADING_BOOK_OUTPUT}/different_fee.dat#-DonlyFileAHas=${TRADING_BOOK_OUTPUT}/onlyFileAHas_fee.dat#-DonlyFileBHas=${TRADING_BOOK_OUTPUT}/onlyFileBHas_fee.dat file:${TRADING_BOOK_INPUT_ARGS}/TRNX_DERIV_FEES_Comparator.xml

#settlements
${BASE_DIR}/bin/comparator.sh ${TRADING_BOOK_OUTPUT}/settlements_oracle.csv ${TRADING_BOOK_OUTPUT}/settlements_sybase.csv -Dexport.detail#-Ddifferent=${TRADING_BOOK_OUTPUT}/different_settlements.dat#-DonlyFileAHas=${TRADING_BOOK_OUTPUT}/onlyFileAHas_settlements.dat#-DonlyFileBHas=${TRADING_BOOK_OUTPUT}/onlyFileBHas_settlements.dat file:${TRADING_BOOK_INPUT_ARGS}/TRNX_DERIV_SETTLEMENTS_Comparator.xml

#rate_resets
${BASE_DIR}/bin/comparator.sh ${TRADING_BOOK_OUTPUT}/rate_resets_oracle.csv ${TRADING_BOOK_OUTPUT}/rate_resets_sybase.csv -Dexport.detail#-Ddifferent=${TRADING_BOOK_OUTPUT}/different_rate_resets.dat#-DonlyFileAHas=${TRADING_BOOK_OUTPUT}/onlyFileAHas_rate_resets.dat#-DonlyFileBHas=${TRADING_BOOK_OUTPUT}/onlyFileBHas_rate_resets.dat file:${TRADING_BOOK_INPUT_ARGS}/TRNX_DERIV_RATE_RESETS_Comparator.xml

#collateral
${BASE_DIR}/bin/comparator.sh ${TRADING_BOOK_OUTPUT}/collateral_oracle.csv ${TRADING_BOOK_OUTPUT}/collateral_sybase.csv -Dexport.detail#-Ddifferent=${TRADING_BOOK_OUTPUT}/different_collateral.dat#-DonlyFileAHas=${TRADING_BOOK_OUTPUT}/onlyFileAHas_collateral.dat#-DonlyFileBHas=${TRADING_BOOK_OUTPUT}/onlyFileBHas_collateral.dat file:${TRADING_BOOK_INPUT_ARGS}/TRNX_DERIV_COLLATERAL_Comparator.xml

#cancellations
${BASE_DIR}/bin/comparator.sh ${TRADING_BOOK_OUTPUT}/cancellations_oracle.csv ${TRADING_BOOK_OUTPUT}/cancellations_sybase.csv -Dexport.detail#-Ddifferent=${TRADING_BOOK_OUTPUT}/different_cancellations.dat#-DonlyFileAHas=${TRADING_BOOK_OUTPUT}/onlyFileAHas_cancellations.dat#-DonlyFileBHas=${TRADING_BOOK_OUTPUT}/onlyFileBHas_cancellations.dat file:${TRADING_BOOK_INPUT_ARGS}/TRNX_DERIV_CANCELLATIONS_Comparator.xml