package bamv.training.microposts.controller;

import bamv.training.microposts.service.FollowService;
import bamv.training.microposts.service.MicropostService;
import bamv.training.microposts.service.UserService;
import bamv.training.microposts.dto.MicropostDto;
import bamv.training.microposts.dto.UserDto;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MicropostsController {
    @Autowired
    private UserService userService;
    @Autowired
    private MicropostService micropostService;
    @Autowired
    private FollowService followService;

    @GetMapping("/micropostshome")
    String micropostshome(Model model, HttpServletRequest httpServletRequest, @RequestParam(name = "page", defaultValue = "1") int page) {
        /* ユーザー認証情報からユーザIDを取得 */
        String userId = httpServletRequest.getRemoteUser();

        /* Model ⇔ Controller */
        UserDto user = userService.selectUser(userId); // 自ユーザー情報
        int myMicropostNumber = micropostService.countMicropostNumber(userId); // 自ユーザーマイクロポスト数
        List<MicropostDto> followsMicropostList = micropostService.searchFollowMicropost(userId, page); // 自ユーザーおよびフォローのマイクロポスト
        int myFollowNumber = followService.selectFollowNumber(userId);
        int myFollowerNumber = followService.selectFollowerNumber(userId);

        /* View ⇔ Controller */
        model.addAttribute("myUserName", user.getName()); // 自ユーザー情報
        model.addAttribute("myMicropostsNumber", myMicropostNumber); // 自ユーザーのマイクロポスト数
        model.addAttribute("myFollowNumber", myFollowNumber); // 自ユーザーのフォロー数
        model.addAttribute("myFollowerNumber", myFollowerNumber); // 自ユーザーのフォロワー数
        model.addAttribute("followsMicropostList", followsMicropostList); // 現在表示しているページ
        model.addAttribute("page", page);
        return "micropostshome";
    }

    @PostMapping("/postnewmicropost")
    String postnewmicropost(Model model,  HttpServletRequest httpServletRequest, @RequestParam(name = "content") String content) {
        /* ユーザー認証情報からユーザIDを取得 */
        String userId = httpServletRequest.getRemoteUser();

        if (content != "") micropostService.addNewMicropost(userId, content);
        return "redirect:/micropostshome";
    }

    @GetMapping("/login")
    String login(Model model) {
        return "login";
    }

    @GetMapping("/myprofile")
    String myprofile(Model model, HttpServletRequest httpServletRequest, @RequestParam(name = "page", defaultValue = "1") int page) {
        /* ユーザー認証情報からユーザIDを取得 */
        String userId = httpServletRequest.getRemoteUser();

        /* Model ⇔ Controller */
        UserDto user = userService.selectUser(userId); // 自ユーザー情報
        List<MicropostDto> followsMicropostList = micropostService.searchUserMicropost(userId, page); // 自ユーザーおよびフォローのマイクロポスト
        int myFollowNumber = followService.selectFollowNumber(userId);
        int myFollowerNumber = followService.selectFollowerNumber(userId);

        /* View ⇔ Controller */
        model.addAttribute("myUserName", user.getName()); // 自ユーザー情報
        model.addAttribute("myFollowNumber", myFollowNumber); // 自ユーザーのフォロー数
        model.addAttribute("myFollowerNumber", myFollowerNumber); // 自ユーザーのフォロワー数
        model.addAttribute("followsMicropostList", followsMicropostList); // 現在表示しているページ
        model.addAttribute("page", page);
        return "myprofile";
    }

    @GetMapping("/signup")
    String signup(Model model) {
        return "signup";
    }

    @PostMapping("/signup")
    String signup(Model model,
                  @RequestParam(name = "userid") String userId,
                  @RequestParam(name = "name") String name,
                  @RequestParam(name = "password") String password) {
        userService.createNewUser(userId, name, password);
        return "redirect:/login";
    }
}