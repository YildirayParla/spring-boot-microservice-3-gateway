package com.sha.springbootmicroservice3gateway.request;

import com.google.gson.JsonElement;
import org.springframework.web.bind.annotation.PathVariable;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface ITransactionServiceRequest {
    @POST("/api/transaction")
    Call<JsonElement> saveTransaction(@Body JsonElement requestBody);
    @DELETE("/api/transaction/{transactionId}")
    Call<Void> deleteTransaction(@PathVariable Long transactionId);
    @GET("/api/transaction/{userId}")
    Call<List<JsonElement>> getAllTransactionOfAuthorizedUser(@Path("userId")Long userId);
}
