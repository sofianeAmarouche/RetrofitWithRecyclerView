package com.example.sofiane.cakecategories;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Sofiane on 10/12/2018.
 */

public interface GetCakeDataService {
    @GET("/hart88/198f29ec5114a3ec3460/raw/8dd19a88f9b8d24c23d9960f3300d0c917a4f07c/cake.json")
    Call<List<RetroCakeDetail>> getAllCakeDetails();
}
