package com.melody.meishi.base;

import com.meishi.common.constants.CommonConstant;
import com.meishi.common.result.Result;
import com.meishi.common.user.AppContext;
import com.meishi.common.user.UserContext;
import com.melody.meishi.authority.vo.LoginUserVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public class BaseController {

	private Logger logger = LoggerFactory.getLogger("method time logs");

	public void setLoginUser(LoginUserVo user) {
		getRequest().getSession().setAttribute(CommonConstant.LOGIN_USER_INFO, user);
	}
	public LoginUserVo getLoginUser() {
	    return (LoginUserVo) getRequest().getSession().getAttribute(CommonConstant.LOGIN_USER_INFO);
	}

	/**
	 * 验证用户是否登录
	 * @return
	 */
	public Result validateLogin() {
		logger.debug("==start validateLogin==");
		Result result = new Result();
		result.setSuccess(true);
		Object userinfo = getRequest().getSession().getAttribute(CommonConstant.LOGIN_USER_INFO);
        if (userinfo != null) {
			result.setReturnValue((LoginUserVo) userinfo);
			return result;
		} else {
			result.setSuccess(false);
			return result;
		}
	}

	/**
	 * @Description: 获取当前APP信息， 包括当前APP所属公司， 当前登陆用户
	 * @return
	 */
	public AppContext getAppContext() {
		AppContext context = new AppContext();

		Result result = validateLogin();
		if (result.isSuccess()) {
			LoginUserVo loginUser = (LoginUserVo) result.getReturnValue();
			context.setUserId(loginUser.getId());
		}
		return context;
	}
	
	public UserContext getUserContext() {
        UserContext context = new UserContext();
        LoginUserVo loginUser = getLoginUser();
        if (loginUser != null) {
            context.setUserId(loginUser.getId());
            context.setRoleId(loginUser.getRoleId());
            context.setUserLevel(loginUser.getUserLevel());
            context.setRoleType(loginUser.getRoleType());
        }
        return context;
    }


	public HttpServletRequest getRequest() {
		return ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
	}

	public HttpServletResponse getResponse() {
		return  ((ServletWebRequest)RequestContextHolder.getRequestAttributes()).getResponse();
	}

	/**
	 * @Description: 获取request中的参数，构建map
	 * @param request
	 */
	public Map<String, String> getAllRequestParam(final HttpServletRequest request) {
		Map<String, String> res = new HashMap<String, String>();
		Enumeration<?> temp = request.getParameterNames();
		if (null != temp) {
			while (temp.hasMoreElements()) {
				String en = (String) temp.nextElement();
				String value = request.getParameter(en);
				//在报文上送时，如果字段的值为空，则不上送<下面的处理为在获取所有参数数据时，判断若值为空，则删除这个字段>
				if (null == value || "".equals(value)) {
					continue;
				}
				logger.info("key:{},value:{}",en,value);
				res.put(en, value);
			}
		}
		return res;
	}

}
