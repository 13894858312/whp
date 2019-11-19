package com.back.whp.constants;


public class ResultConstants {

    /**
     * Result map key set
     */
    public static final String MESSAGE = "message";

    public static final String RESULT = "result";

    /**
     * Result map value set
     */
    public static final Integer LOG_IN_SUCCESS = 0;//登录成功

    public static final Integer LOG_IN_FAILURE = 1;//登录失败

    public static final Integer LOG_OUT_SUCCESS = 2;//"退出成功";

    public static final Integer LOG_OUT_FAILURE = 3;//"退出失败";

    public static final Integer SIGNATURE_OUT_OF_DATE = 4;//"您已太久未登陆，请重新登陆";

    public static final Integer SIGN_UP_SUCCESS = 5;//"注册成功";

    public static final Integer PASSWORD_RESET_FAILED = 6;//"密码修改失败";

    public static final Integer PASSWORD_RESET_SUCCESS = 7;//"密码修改成功";

    public static final Integer USERNAME_ALREADY_EXISTS = 8;//"用户名已存在";

    public static final Integer USERNAME_NOT_EXISTS = 9;//"用户名不存在";

    public static final Integer PHONE_NUMBER_ALREADY_REGISTERED = 10;//"手机号已被注册";

    public static final Integer IDENTIFY_PLEASE_REQUEST_VERIFY_LATER = 11;//"请于%s后重试";

    public static final Integer IDENTIFY_CODE_SEND_SUCCESS = 12;//"验证码已发送";

    public static final Integer IDENTIFY_CODE_SEND_FAILURE = 13;//"验证码发送失败";

    public static final Integer IDENTIFY_CODE_CORRECT = 14;//"验证码正确";

    public static final Integer IDENTIFY_CODE_INCORRECT = 15;//"验证码错误";

    public static final Integer ACTIVITY_HOST_SUCCESS = 16;//"活动发布成功";

    public static final Integer ACTIVITY_HOST_FAILURE = 17;//"活动发布失败";

    public static final Integer ACTIVITY_REVERT_SUCCESS = 18;//"活动撤销成功";

    public static final Integer ACTIVITY_REVERT_FAILURE = 19;//"活动撤销失败（只有未开始活动可以被撤销）";

    public static final Integer ACTIVITY_EVALUATE_SUCCESS = 20;//"评论成功";

    public static final Integer ACTIVITY_NOT_FINISH = 21;//"活动尚未结束";

    public static final Integer ACTIVITY_EVALUATE_FAILURE = 22;//"评论失败";

    public static final Integer ACTIVITY_COLLECT_SUCCESS = 23;//"收藏成功";

    public static final Integer ACTIVITY_ALREADY_COLLECTED = 24;//"活动已被收藏";

    public static final Integer ACTIVITY_NOT_COLLECTED = 25;//"活动未被收藏";

    public static final Integer REMOVE_COLLECTION_SUCCESS = 26;//"取消收藏成功";

    public static final Integer ACTIVITY_PARTICIPATE_SUCCESS = 27;//"活动参加成功";

    public static final Integer ACTIVITY_NOT_PARTICIPATE = 28;//"活动未参加";

    public static final Integer ACTIVITY_ALREADY_PARTICIPATED = 29;//"活动已经参加";

    public static final Integer ACTIVITY_PARTICIPATE_FAILURE = 30;//"活动无法参加";

    public static final Integer ACTIVITY_PARTICIPATE_FULL = 31;//"活动参加人数已满";

    public static final Integer ACTIVITY_QUIT_FAILURE = 32;//"活动无法退出";

    public static final Integer ACTIVITY_QUIT_SUCCESS = 33;//"活动退出成功";

    public static final Integer MODIFY_INFO_SUCCESS = 34;//"修改成功";

    public static final Integer MODIFY_INFO_FAILURE = 35;//"修改失败";

    public static final Integer PARTY_NOT_EXISTS = 36;//"社团不存在";

    public static final Integer ADD_MEMBER_SUCCESS = 37;//"社团成员添加成功";

    public static final Integer ADD_MEMBER_FAILURE = 38;//"社团成员添加失败";

    public static final Integer REMOVE_MEMBER_SUCCESS = 39;//"社团成员移除成功";

    public static final Integer USER_ALREADY_JOIN_PARTY = 40;//"用户已加入社团";

    public static final Integer USER_NOT_JOIN_PARTY = 41;//"用户未加入社团";

    public static final Integer ASSIGN_MANAGER_SUCCESS = 42;//"转移管理员成功";

    public static final Integer YOU_ARE_NOT_MANAGER = 43;//"权限不够，无法操作";

    public static final Integer NO_IMAGE = 44;//"无图片";

    public static final Integer INVALID_SIGNATURE = 45;//"签名无效";

    public static final Integer PICTURE_EMPTY = 46;//"图片不存在"

    public static final Integer PICTURE_UPLOAD_SUCCESS = 47;//"图片上传成功"

    public static final Integer PICTURE_UPLOAD_FAILURE = 48;//"图片上传失败"

    public static final Integer TOKEN_NOT_EXIST = 49;//"Token不存在"

    public static final Integer TOKEN_VALID = 50;//"token有效"
}
