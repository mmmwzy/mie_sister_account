package com.mie.sa.constant;

/**
 * Created by WangRicky on 2018/7/6.
 */
public class Constant {

    //JWT安全秘钥
    public final static String JWT_SECRET = "#jaaHD56dxN74Y^&emzq4iRLZVrSa!#rD^fyVr=gF=GV%rOmY*1fglio5j8HTNIj";
    //JWT过期时间
    public final static int JWT_EXPIRES = 86400000;

    //微信小程序登录凭证校验URL
    public final static String WX_X_LOGIN_URL = "https://api.weixin.qq.com/sns/jscode2session";
    //微信小程序APPID
    public final static String WX_X_APPID = "wx76d20b256c3e3702";
    //微信小程序SECRET
    public final static String WX_X_SECRET = "030c9f65e93181c246b52d60aac423e9";
    //腾讯云短信服务APPID
    public final static int QCLOUD_SMS_APPID = 1400092776;
    //腾讯云短信服务APPKEY
    public final static String QCLOUD_SMS_APPKEY = "cd7a60b61d87cd11b28a47edf893585b";
    //腾讯云短信签名
    public final static String QCLOUD_SMS_SIGN= "姐妹花记账";
    //腾讯云短信模板ID---验证码
    //您目前正在执行手机绑定操作，验证码为{1}，请于{2}分钟内使用，过期无效！请勿向任何人透露本条验证码信息！
    public final static int QCLOUD_SMS_TEMPLATEID_YANZHENGMA = 145645;
    //腾讯云短信模板ID---审核申请成功
    //{1}您好！您已成功申请账单编号为{2}，账单描述为{3},金额为{4}的报销申请，系统已向审核人下发通知，请耐心等待！
    public final static int QCLOUD_SMS_TEMPLATEID_APPLY_SUCCESS = 159025;
    //腾讯云短信模板ID---待审核通知
    //{1}您好！{2}发起的一笔金额为{3}，账单描述为{4}的报销！请尽快前往小程序审核专栏进行审核！
    public final static int QCLOUD_SMS_TEMPLATEID_EXAMINE_NOTICE = 159136;
    //腾讯云短信模板ID---审核通过通知
    //{1}您好！您发起的描述为{2}，金额为{3}的报销审核已经通过，请前往绑定的支付宝查收，报销单号为{4}
    public final static int QCLOUD_SMS_TEMPLATEID_EXAMINE_SUCCESS = 159160;
    //腾讯云短信模板ID---审核失败通知
    //{1}您好！您申请的描述为{2}，金额为{3}的报销申请不通过，请前往小程序查看详情！
    public final static int QCLOUD_SMS_TEMPLATEID_EXAMINE_FAILED = 159291;
    //腾讯云短信模板ID---待报销通知
    //{1}您好！{2}发起的描述为{3}，金额为{4}的报销申请已通过审核，请尽快前往小程序向{5}账号报销！
    public final static int QCLOUD_SMS_TEMPLATEID_REIM_NOTICE = 159166;

}
