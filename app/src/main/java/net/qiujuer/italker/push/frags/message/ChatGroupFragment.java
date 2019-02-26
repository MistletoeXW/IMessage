package net.qiujuer.italker.push.frags.message;


import net.qiujuer.italker.factory.model.db.Group;
import net.qiujuer.italker.factory.presenter.message.ChatContract;
import net.qiujuer.italker.push.R;

/**
 * 群聊天界面实现
 */
public class ChatGroupFragment extends ChatFragment<Group>
        implements ChatContract.GroupView {


    public ChatGroupFragment() {
        // Required empty public constructor
    }


    @Override
    protected int getContentLayoutId() {
        return R.layout.fragment_chat_group;
    }

    @Override
    protected ChatContract.Presenter initPresenter() {
        return null;
    }

    @Override
    public void onInit(Group group) {

    }
}
