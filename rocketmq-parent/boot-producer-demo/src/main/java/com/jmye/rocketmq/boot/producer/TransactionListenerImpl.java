package com.jmye.rocketmq.boot.producer;

import org.apache.commons.lang3.StringUtils;
import org.apache.rocketmq.spring.annotation.RocketMQTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionState;
import org.apache.rocketmq.spring.support.RocketMQUtil;
import org.springframework.messaging.Message;
import org.springframework.messaging.converter.StringMessageConverter;

/**
 * @Description
 * @Author jmye
 * @Time 2023/10/15 22:44
 * @Version 1.0
 */
@RocketMQTransactionListener(rocketMQTemplateBeanName = "rocketMQTemplate")
public class TransactionListenerImpl implements RocketMQLocalTransactionListener {
    @Override
    public RocketMQLocalTransactionState executeLocalTransaction(Message message, Object arg) {
        // 获得业务参数中的数据
        String destination = (String) arg;
        org.apache.rocketmq.common.message.Message rocketMessage = RocketMQUtil.convertToRocketMessage(new StringMessageConverter(), "utf-8", destination, message);
        // 获得消息中的业务数据tags
        String tags = rocketMessage.getTags();
        if (StringUtils.contains(tags, "TagA")) {
            // 提交本地事务
            return RocketMQLocalTransactionState.COMMIT;
        } else if (StringUtils.contains(tags, "TagB")) {
            // 回滚
            return RocketMQLocalTransactionState.ROLLBACK;
        } else {
            // 中间状态
            return RocketMQLocalTransactionState.UNKNOWN;
        }
    }

    @Override
    public RocketMQLocalTransactionState checkLocalTransaction(Message message) {
        return null;
    }
}
