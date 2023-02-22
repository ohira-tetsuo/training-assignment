package bamv.training.microposts.service;

public interface FollowService {
    int selectFollowNumber(String userId); // フォローの数を取得

    int selectFollowerNumber(String userId); // フォロワーの数を取得
}
