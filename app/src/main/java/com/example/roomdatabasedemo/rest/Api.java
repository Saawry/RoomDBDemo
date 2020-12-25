package com.example.roomdatabasedemo.rest;

import com.example.roomdatabasedemo.actor.Actor;
import com.example.roomdatabasedemo.actor.ActorResponse;
import com.example.roomdatabasedemo.students.AllStudentsResponse;
import com.example.roomdatabasedemo.students.StudentDetailsResponse;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Api {
    @FormUrlEncoded
    @POST("Api/Student/AddStudent")
    Call<ResponseBody> AddNewStudent(
            @Field("studentId") String studentId,
            @Field("studentRoll") String studentRoll,
            @Field("admissionDate") String admissionDate,
            @Field("DateOfBirth") String DateOfBirth,
            @Field("ShiftId") String ShiftId,
            @Field("classId") String classId,
            @Field("sectionId") String sectionId,
            @Field("imageName") String imageName,
            @Field("createdTime") String createdTime,
            @Field("createdBy") String createdBy,
            @Field("status") String status,
            @Field("Guardian_Phone") String Guardian_Phone,
            @Field("Relation") String Relation
    );

//    @FormUrlEncoded
//    @POST("Api/Student/AddStudent")
//    Call<ResponseBody> AddNewStudent(
//            @Field("studentInfo") StudentInfo studentInfo
//    );

    @GET("Api/Student/GetStudent")
    Call<StudentDetailsResponse> GetStudentDetails(
            @Field("studentId") String studentId
    );

    @GET("Api/Student/GetAllStudent")
    Call<AllStudentsResponse> GetAllStudentDetails();



    @GET("data.php")
    Call<List<Actor>> GetActorDetails();


//    @FormUrlEncoded
//    @PUT("user")
//    Call<DfltResponse> UpdateInfo(
//            @Header("Authorization") String token,
//            @Field("name") String UserName,
//            @Field("birthdate") String UserDob
//    );
//
//
//    @GET("auth-user")
//    Call<AuthUsersResponse> getUserDetails(@Header("Authorization") String token);
//
//
//
//    @FormUrlEncoded
//    @POST("purchase/{id}")
//    Call<PurchaseResponse> PurchasePkg(
//            @Path("id") String id,
//            @Header("Authorization") String token,
//            @Field("latitude") String latitude,
//            @Field("longitude") String longitude,
//            @Field("auto_renew") String renewOn
//    );
//
//
//    @GET("user/packages")
//    Call<ActivePackagesResponse> GetMyActivepPkgs(
//            @Header("Authorization") String token
//    );
}
