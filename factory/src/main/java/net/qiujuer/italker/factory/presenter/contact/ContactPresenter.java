package net.qiujuer.italker.factory.presenter.contact;


import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;

import com.raizlabs.android.dbflow.config.DatabaseDefinition;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.structure.database.DatabaseWrapper;
import com.raizlabs.android.dbflow.structure.database.transaction.ITransaction;
import com.raizlabs.android.dbflow.structure.database.transaction.QueryTransaction;

import net.qiujuer.italker.common.widget.recycler.RecyclerAdapter;
import net.qiujuer.italker.factory.data.DataSource;
import net.qiujuer.italker.factory.data.helper.UserHelper;
import net.qiujuer.italker.factory.data.user.ContactDataSource;
import net.qiujuer.italker.factory.data.user.ContactRepository;
import net.qiujuer.italker.factory.model.card.UserCard;
import net.qiujuer.italker.factory.model.db.AppDatabase;
import net.qiujuer.italker.factory.model.db.User;
import net.qiujuer.italker.factory.model.db.User_Table;
import net.qiujuer.italker.factory.persistence.Account;
import net.qiujuer.italker.factory.presenter.BasePresenter;
import net.qiujuer.italker.factory.presenter.BaseSourcePresenter;
import net.qiujuer.italker.factory.utils.DiffUiDataCallback;

import java.util.ArrayList;
import java.util.List;

/**
 * 联系人的Presenter实现
 *
 * @author qiujuer Email:qiujuer@live.cn
 * @version 1.0.0
 */
public class ContactPresenter extends BaseSourcePresenter<User, User, ContactDataSource, ContactContract.View>
        implements ContactContract.Presenter, DataSource.SucceedCallback<List<User>> {

    public ContactPresenter(ContactContract.View view) {
        // 初始化数据仓库
        super(new ContactRepository(), view);
    }


    @Override
    public void start() {
        super.start();

        // 加载网络数据
        UserHelper.refreshContacts();
    }

    // 运行到这里的时候是子线程
    @Override
    public void onDataLoaded(List<User> users) {
        // 无论怎么操作，数据变更，最终都会通知到这里来
        final ContactContract.View view = getView();
        if (view == null)
            return;

        RecyclerAdapter<User> adapter = view.getRecyclerAdapter();
        List<User> old = adapter.getItems();

        // 进行数据对比
        DiffUtil.Callback callback = new DiffUiDataCallback<>(old, users);
        DiffUtil.DiffResult result = DiffUtil.calculateDiff(callback);

        // 调用基类方法进行界面刷新
        refreshData(result, users);
    }
}
