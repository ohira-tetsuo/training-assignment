package bamv.training.microposts.service;

public interface FollowService {
    int findFollowNumber(String userId);

    int findFollowerNumber(String userId);
}
