package coffeeshop.graduateproject.chautuan.coffeeshopmanagement.API;

import java.util.List;

import coffeeshop.graduateproject.chautuan.coffeeshopmanagement.model.Bartender;
import coffeeshop.graduateproject.chautuan.coffeeshopmanagement.model.LatestOrder;
import coffeeshop.graduateproject.chautuan.coffeeshopmanagement.model.ResponseInfomation;
import coffeeshop.graduateproject.chautuan.coffeeshopmanagement.model.LoginUser;
import coffeeshop.graduateproject.chautuan.coffeeshopmanagement.model.MenuItem;
import coffeeshop.graduateproject.chautuan.coffeeshopmanagement.model.OrderDetail;
import coffeeshop.graduateproject.chautuan.coffeeshopmanagement.model.Table;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * Created by chautuan on 3/1/18.
 */

public interface ApiInterface {


    @GET("gettable")
    Call<List<Table>> getTable();

    @FormUrlEncoded
    @POST("addmenuitem")
    Call<ResponseInfomation> addMenuItem(@Header("Authorization") String authToken,
                                         @Field("itemname") String itemName,
                                         @Field("itemtype") int itemType,
                                         @Field("itemprice") int itemPrice,
                                         @Field("itemdesc")String desc );

    @FormUrlEncoded
    @POST("createorder")
    Call<ResponseInfomation> createOrder(@Header("Authorization") String authToken,
                                         @Field("idphucvu") int idPhucVu,
                                         @Field("idbartender") int idBartender,
                                         @Field("tablenumber") int tableNumber,
                                         @Field("noticeinfo")String info );

    @FormUrlEncoded
    @POST("addorderdetail")
    Call<OrderDetail> createOrderDetail(@Header("Authorization") String authToken,
                                        @Field("orderid") int orderID,
                                        @Field("itemid") int itemid,
                                        @Field("itemprice") int itemprice,
                                        @Field("quantity") int quantity);

    @GET("getallorderdetail")
    Call<OrderDetail> getAllOrderDetail(@Header("Authorization") String authToken);

    @FormUrlEncoded
    @POST("getorderdetailbyid")
    Call<OrderDetail> getOrderDetailByID(@Header("Authorization") String authToken, @Field("orderid") int orderID);

    @GET("getlistorder")
    Call<ResponseInfomation> getListOrder(@Header("Authorization") String authToken);

    @GET("getmenuitems")
    Call<List<MenuItem>> getMenuItems(@Header("Authorization") String authToken);

    @GET("getlatestorderid")
    Call<LatestOrder> getLatestOrderID(@Header("Authorization") String authToken);

    @FormUrlEncoded
    @POST("login")
    Call<LoginUser> login(@Field("UserName") String UserName, @Field("password") String password);

    @GET("bartenders")
    Call<List<Bartender>> getBartenders ();
}
