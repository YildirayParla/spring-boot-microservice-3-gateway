package com.sha.springbootmicroservice3gateway.service;

import com.google.gson.JsonElement;
import com.sha.springbootmicroservice3gateway.request.ITransactionServiceRequest;
import com.sha.springbootmicroservice3gateway.util.RetrofitUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService implements ITransactionService{
    private final ITransactionServiceRequest transactionServiceRequest;

    public TransactionService(ITransactionServiceRequest transactionServiceRequest) {
        this.transactionServiceRequest = transactionServiceRequest;
    }
    @Override
    public JsonElement saveTransaction(JsonElement transaction){
        return RetrofitUtils.executeInBlock(transactionServiceRequest.saveTransaction(transaction));
    }
    @Override
    public void deleteTransaction(Long transactionId){
        RetrofitUtils.executeInBlock(transactionServiceRequest.deleteTransaction(transactionId));
    }
    @Override
    public List<JsonElement> getAllTransactionsOfUser(Long userId){
        return RetrofitUtils.executeInBlock(transactionServiceRequest.getAllTransactionOfAuthorizedUser(userId));
    }
}
