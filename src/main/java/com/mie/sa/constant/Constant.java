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
    //{1}您好！{2}发起的一笔金额为{3}，账单描述为{4}的报销！请尽快前往小程序审核专栏进行审核！或回复{5}快速同意该笔报销
    public final static int QCLOUD_SMS_TEMPLATEID_EXAMINE_NOTICE = 162516;
    //腾讯云短信模板ID---审核通过通知
    //{1}您好！您发起的描述为{2}，金额为{3}的报销审核已经通过，请前往绑定的支付宝查收，报销单号为{4}
    public final static int QCLOUD_SMS_TEMPLATEID_EXAMINE_SUCCESS = 159160;
    //腾讯云短信模板ID---审核失败通知
    //{1}您好！您申请的描述为{2}，金额为{3}的报销申请不通过，请前往小程序查看详情！
    public final static int QCLOUD_SMS_TEMPLATEID_EXAMINE_FAILED = 159291;
    //腾讯云短信模板ID---待报销通知
    //{1}您好！{2}发起的编号为{3}，金额为{4}的报销申请已通过审核，请尽快前往小程序向{5}账号报销！
    public final static int QCLOUD_SMS_TEMPLATEID_REIM_NOTICE = 162520;
    //腾讯云短信模板ID---缴纳公共资金通知
    //{1}您好！{2}向您申请缴纳{3}元/人的公共资金通知,缴纳原因:{4}！如有疑问请联系管理员！
    public final static int QCLOUD_SMS_TEMPLATEID_NOTICE_PAY = 173049;
    //腾讯云短信模板ID---缴纳公共资金发起成功通知
    //{1}您好！您发起的缴纳金额{2}元/人，缴纳原因:{3}的公共资金申请已通过！系统已下发通知短信！请耐心等待！
    public final static int QCLOUD_SMS_TEMPLATEID_NOTICE_PAY_APPLY = 173060;
    //腾讯云短信模板ID---公共资金缴纳成功通知
    //{1}您好！系统已收到您缴纳的{2}元公共资金，该笔交易ID({3})！系统将在短时间延迟之后进行入账！
    public final static int QCLOUD_SMS_TEMPLATEID_NOTICE_PAY_SUCCESS = 161114;

    //账单账单内容类型-餐饮
    public final static Byte BILL_CONTEXT_TYPE_CY = 1;
    //账单账单内容类型-交通
    public final static Byte BILL_CONTEXT_TYPE_JT = 2;
    //账单账单内容类型-住房
    public final static Byte BILL_CONTEXT_TYPE_ZF = 3;
    //账单账单内容类型-家装
    public final static Byte BILL_CONTEXT_TYPE_JZ = 4;
    //账单账单内容类型-其他
    public final static Byte BILL_CONTEXT_TYPE_QT = 5;
    //账单账单内容类型-公共资金
    public final static Byte BILL_CONTEXT_TYPE_GGZJ = 6;

    //账单类型-支出
    public final static Byte BILL_TYPE_OUT = 1;
    //账单类型-收入
    public final static Byte BILL_TYPE_IN = 2;

}
