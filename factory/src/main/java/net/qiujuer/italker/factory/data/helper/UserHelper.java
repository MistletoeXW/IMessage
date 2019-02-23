package net.qiujuer.italker.factory.data.helper;

import net.qiujuer.italker.factory.Factory;
import net.qiujuer.italker.factory.R;
import net.qiujuer.italker.factory.data.DataSource;
import net.qiujuer.italker.factory.model.api.RspModel;
import net.qiujuer.italker.factory.model.card.UserCard;
import net.qiujuer.italker.factory.net.Network;
import net.qiujuer.italker.factory.net.RemoteService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @author qiujuer Email:qiujuer@live.cn
 * @version 1.0.0
 */
public class UserHelper {
//    // 更新用户信息的操作，异步的
//    public static void update(UserUpdateModel model, final DataSource.Callback<UserCard> callback) {
//        // 调用Retrofit对我们的网络请求接口做代理
//        RemoteService service = Network.remote();
//        // 得到一个Call
//        Call<RspModel<UserCard>> call = service.userUpdate(model);
//        // 网络请求
//        call.enqueue(new Callback<RspModel<UserCard>>() {
//            @Override
//            public void onResponse(Call<RspModel<UserCard>> call, Response<RspModel<UserCard>> response) {
//                RspModel<UserCard> rspModel = response.body();
//                if (rspModel.success()) {
//                    UserCard userCard = rspModel.getResult();
//                    // 数据库的存储操作，需要把UserCard转换为User
//                    // 保存用户信息
//                    User user = userCard.build();
//                    user.save();
//                    // 返回成功
//                    callback.onDataLoaded(userCard);
//                } else {
//                    // 错误情况下进行错误分配
//                    Factory.decodeRspCode(rspModel, callback);
//                }
//            }
//
//            @Override
//            public void onFailure(Call<RspModel<UserCard>> call, Throwable t) {
//                callback.onDataNotAvailable(R.string.data_network_error);
//            }
//        });
//    }

    // 搜索的方法
    public static Call search(String name, final DataSource.Callback<List<UserCard>> callback) {
        RemoteService service = Network.remote();
        Call<RspModel<List<UserCard>>> call = service.userSearch(name);

        call.enqueue(new Callback<RspModel<List<UserCard>>>() {
            @Override
            public void onResponse(Call<RspModel<List<UserCard>>> call, Response<RspModel<List<UserCard>>> response) {
                RspModel<List<UserCard>> rspModel = response.body();
                if (rspModel.success()) {
                    // 返回数据
                    callback.onDataLoaded(rspModel.getResult());
                } else {
                    Factory.decodeRspCode(rspModel, callback);
                }
            }

            @Override
            public void onFailure(Call<RspModel<List<UserCard>>> call, Throwable t) {
                callback.onDataNotAvailable(R.string.data_network_error);
            }
        });

        // 把当前的调度者返回
        return call;
    }


}
