<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
  <script src="/static/js/login.js"></script>
  <link rel="stylesheet" href="/static/css/login.css"/>
</head>
<body>
<div class="am-container">
  <div class="am-vertical-align shy-head">
    <div class="am-vertical-align-middle am-animation-scale-up am-text-sm">
      山腰儿工作室
    </div>
  </div>
  <div class="am-g">
    <div class="am-u-md-7 am-u-sm-10 am-u-sm-centered am-radius am-animation-fade shy-body">
      <div class="am-animation-scale-up">
        <!--logo-->
        <div class="am-g">
          <div class="am-u-sm-5 am-u-sm-centered am-margin-vertical">
            <img class="am-circle"
                 src="http://s.amazeui.org/media/i/demos/bw-2014-06-19.jpg?imageView/1/w/1000/h/1000/q/80"
                 alt="LOGO"
                 width="100%"
                 height="100%"/>
          </div>
        </div>
        <!--登录表单-->
        <div class="am-g">
          <div class="am-u-lg-7 am-u-sm-centered">
            <form class="am-form">
              <div class="am-form-group">
                <input class="am-input-sm" type="text" placeholder="手机号">
              </div>
              <div class="am-form-group">
                <input class="am-input-sm" type="password" placeholder="密码">
              </div>
              <button type="button" class="am-btn am-btn-primary am-btn-block am-btn-sm am-margin-bottom-xs am-radius"
                      onclick="toIndexPage()">登录
              </button>
            </form>
            <a class="am-text-xs am-link-muted am-fl" href="javascript:toForgotPasswordPage()">忘记密码</a>
            <a class="am-text-xs am-link-muted am-fr" href="javascript:toRegisterPage()">注册</a>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
</body>
</html>
