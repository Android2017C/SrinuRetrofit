package com.example.sreenureddy.srinuretrofit.modelClasses;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class CategoryResponse {

        @SerializedName("status")
        @Expose
        private String status;
        @SerializedName("total_count")
        @Expose
        private Integer totalCount;
        @SerializedName("category")
        @Expose
        public ArrayList<Category> category = new ArrayList<>();
}
