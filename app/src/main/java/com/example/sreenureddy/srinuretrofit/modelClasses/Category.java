package com.example.sreenureddy.srinuretrofit.modelClasses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class Category {

    @SerializedName("cat_id")
    @Expose
    public String catId;
    @SerializedName("cat_name")
    @Expose
    public String catName;
    @SerializedName("image")
    @Expose
    public String image;
    @SerializedName("created_on")
    @Expose
    private String createdOn;
    @SerializedName("updated_on")
    @Expose
    private String updatedOn;
    @SerializedName("created_by")
    @Expose
    private String createdBy;
    @SerializedName("updated_by")
    @Expose
    private String updatedBy;
    @SerializedName("status")
    @Expose
    private String status;
}
