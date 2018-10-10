package i9.defence.platform.datapush.service;

import i9.defence.platform.datapush.config.ServerConfig;
import i9.defence.platform.datapush.dto.ReceiveMessageDto;
import i9.defence.platform.datapush.utils.Util;

import java.io.UnsupportedEncodingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReceiverServiceController {

	private static Logger logger = LoggerFactory
			.getLogger(ReceiverServiceController.class);

	/**
	 * 功能描述：第三方平台数据接收。
	 * <p>
	 * <ul>
	 * 注:
	 * <li>1.OneNet平台为了保证数据不丢失，有重发机制，如果重复数据对业务有影响，数据接收端需要对重复数据进行排除重复处理。</li>
	 * <li>2.OneNet每一次post数据请求后，等待客户端的响应都设有时限，在规定时限内没有收到响应会认为发送失败。
	 * 接收程序接收到数据时，尽量先缓存起来，再做业务逻辑处理。</li>
	 * </ul>
	 * 
	 * @param body
	 *            数据消息
	 * @return 任意字符串。OneNet平台接收到http 200的响应，才会认为数据推送成功，否则会重发。
	 */
	@RequestMapping(value = "/receive", method = RequestMethod.POST)
	@ResponseBody
	public String receive(@RequestBody String body) throws Exception {
		logger.info("data receive : body String --- " + body);
		ReceiveMessageDto receiveMessageDto = Util.resolveBody(body, false);
		logger.info("data receive : body Object --- " + receiveMessageDto);
		if (receiveMessageDto == null) {
			logger.info("data receive: body empty error");
		}
		boolean dataRight = Util.checkSignature(receiveMessageDto, ServerConfig.TOKEN);
		if (dataRight) {
			logger.info("data receive: content" + receiveMessageDto.toString());
		} else {
			logger.info("data receive: signature error");
		}
		return "ok";
	}

	/**
	 * 功能说明： URL&Token验证接口。如果验证成功返回msg的值，否则返回其他值。
	 * 
	 * @param msg
	 *            验证消息
	 * @param nonce
	 *            随机串
	 * @param signature
	 *            签名
	 * @return msg值
	 */

	@RequestMapping(value = "/receive", method = RequestMethod.GET)
	@ResponseBody
	public String check(@RequestParam(value = "msg") String msg,
			@RequestParam(value = "nonce") String nonce,
			@RequestParam(value = "signature") String signature)
			throws UnsupportedEncodingException {

		logger.info("url&token check: msg:{} nonce{} signature:{}", msg, nonce,
				signature);
		if (Util.checkToken(msg, nonce, signature, ServerConfig.TOKEN)) {
			return msg;
		} else {
			return "error";
		}

	}

}
