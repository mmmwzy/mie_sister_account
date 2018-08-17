package com.mie.sa.service;

import com.mie.base.core.service.BaseService;
import com.mie.sa.entity.Sms;
import com.mie.sa.entity.SmsExample;
import com.mie.sa.vo.NoticePaySmsVO;
import com.mie.sa.vo.NoticePaySuccessVO;

public interface SmsService extends BaseService<Sms, SmsExample, String> {

    String noticeSms(NoticePaySmsVO NoticePaySmsVO);

    void paySuccess(NoticePaySuccessVO noticePaySuccessVO);
}